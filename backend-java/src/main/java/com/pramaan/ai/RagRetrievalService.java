package com.pramaan.ai;

import com.pramaan.dto.CitationDto;
import com.pramaan.entity.DocumentEmbedding;
import com.pramaan.entity.Evidence;
import com.pramaan.entity.Fir;
import com.pramaan.entity.Person;
import com.pramaan.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RagRetrievalService {

    private static final Logger log = LoggerFactory.getLogger(RagRetrievalService.class);

    private final EmbeddingService embeddingService;
    private final DocumentEmbeddingRepository documentEmbeddingRepository;
    private final FirRepository firRepository;
    private final PersonRepository personRepository;
    private final EvidenceRepository evidenceRepository;
    private final VehicleRepository vehicleRepository;

    public RagRetrievalService(EmbeddingService embeddingService, DocumentEmbeddingRepository documentEmbeddingRepository, FirRepository firRepository, PersonRepository personRepository, EvidenceRepository evidenceRepository, VehicleRepository vehicleRepository) {
        this.embeddingService = embeddingService;
        this.documentEmbeddingRepository = documentEmbeddingRepository;
        this.firRepository = firRepository;
        this.personRepository = personRepository;
        this.evidenceRepository = evidenceRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public static class RagContext {
        private String formattedContext;
        private List<CitationDto> citations;
        private List<String> relatedFirIds;
        private List<String> relatedPersonIds;

        public RagContext() {
        }

        public RagContext(String formattedContext, List<CitationDto> citations, List<String> relatedFirIds, List<String> relatedPersonIds) {
            this.formattedContext = formattedContext;
            this.citations = citations;
            this.relatedFirIds = relatedFirIds;
            this.relatedPersonIds = relatedPersonIds;
        }

        public String getFormattedContext() {
            return formattedContext;
        }

        public void setFormattedContext(String formattedContext) {
            this.formattedContext = formattedContext;
        }

        public List<CitationDto> getCitations() {
            return citations;
        }

        public void setCitations(List<CitationDto> citations) {
            this.citations = citations;
        }

        public List<String> getRelatedFirIds() {
            return relatedFirIds;
        }

        public void setRelatedFirIds(List<String> relatedFirIds) {
            this.relatedFirIds = relatedFirIds;
        }

        public List<String> getRelatedPersonIds() {
            return relatedPersonIds;
        }

        public void setRelatedPersonIds(List<String> relatedPersonIds) {
            this.relatedPersonIds = relatedPersonIds;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder {
            private String formattedContext;
            private List<CitationDto> citations;
            private List<String> relatedFirIds;
            private List<String> relatedPersonIds;

            public Builder formattedContext(String formattedContext) {
                this.formattedContext = formattedContext;
                return this;
            }

            public Builder citations(List<CitationDto> citations) {
                this.citations = citations;
                return this;
            }

            public Builder relatedFirIds(List<String> relatedFirIds) {
                this.relatedFirIds = relatedFirIds;
                return this;
            }

            public Builder relatedPersonIds(List<String> relatedPersonIds) {
                this.relatedPersonIds = relatedPersonIds;
                return this;
            }

            public RagContext build() {
                return new RagContext(formattedContext, citations, relatedFirIds, relatedPersonIds);
            }
        }
    }

    @Transactional(readOnly = true)
    public RagContext retrieveContext(String query) {
        List<CitationDto> citations = new ArrayList<>();
        List<String> relatedFirIds = new ArrayList<>();
        List<String> relatedPersonIds = new ArrayList<>();
        StringBuilder contextBuilder = new StringBuilder();

        contextBuilder.append("=== RETRIEVED POLICE DATABASE RECORDS ===\n\n");

        // 1. Keyword search on FIRs
        List<Fir> matchedFirs = firRepository.filterFirs(query, "all", "all", "all");
        if (matchedFirs.isEmpty()) {
            matchedFirs = firRepository.findAll();
        }
        
        int firCount = 0;
        for (Fir f : matchedFirs) {
            if (firCount++ >= 4) break;
            relatedFirIds.add(String.valueOf(f.getId()));
            contextBuilder.append(String.format("• [FIR %s] Title: %s | Station: %s | Status: %s | Priority: %s | Officer: %s\n  Summary: %s\n  Sections: %s\n\n",
                    f.getFirNumber(), f.getTitle(), f.getStationName(), f.getStatus(), f.getPriority(), f.getInvestigatingOfficer(), f.getSummary(), f.getSections()));

            citations.add(CitationDto.builder()
                    .recordId(String.valueOf(f.getId()))
                    .recordType("fir")
                    .label("FIR " + f.getFirNumber() + " — " + f.getTitle())
                    .excerpt(f.getSummary().length() > 120 ? f.getSummary().substring(0, 120) + "..." : f.getSummary())
                    .build());
        }

        // 2. Keyword search on Persons
        List<Person> matchedPersons = personRepository.searchAndFilterPersons(query, "all");
        if (matchedPersons.isEmpty()) {
            matchedPersons = personRepository.findAll();
        }

        int personCount = 0;
        for (Person p : matchedPersons) {
            if (personCount++ >= 3) break;
            relatedPersonIds.add(String.valueOf(p.getId()));
            contextBuilder.append(String.format("• [Person %s / %s] Role: %s | Risk: %s | Phone: %s | Address: %s\n  Profile/MO: %s\n\n",
                    p.getPersonCode() != null ? p.getPersonCode() : "P-" + p.getId(),
                    p.getCanonicalName(), p.getPrimaryRole(), p.getRiskLevel(),
                    p.getPhone(), p.getAddress(),
                    p.getBehavioralProfile() != null ? p.getBehavioralProfile() : "Standard record"));

            citations.add(CitationDto.builder()
                    .recordId(String.valueOf(p.getId()))
                    .recordType("person")
                    .label("Person " + p.getCanonicalName() + " (" + p.getPrimaryRole() + ")")
                    .excerpt("Risk: " + p.getRiskLevel() + ", Address: " + p.getAddress())
                    .build());
        }

        // 3. Evidence matches
        List<Evidence> evidenceList = evidenceRepository.findAll();
        int evCount = 0;
        for (Evidence e : evidenceList) {
            if (evCount++ >= 2) break;
            contextBuilder.append(String.format("• [Evidence %s] Type: %s | Status: %s | Collected by: %s\n  Label: %s\n\n",
                    e.getEvidenceCode() != null ? e.getEvidenceCode() : "E-" + e.getId(),
                    e.getEvidenceType(), e.getStatus(), e.getCollectedBy(), e.getLabel()));

            citations.add(CitationDto.builder()
                    .recordId(String.valueOf(e.getId()))
                    .recordType("evidence")
                    .label(e.getLabel())
                    .excerpt("Type: " + e.getEvidenceType() + ", Status: " + e.getStatus())
                    .build());
        }

        // 4. PGVector Vector Similarity Search if embeddings exist
        try {
            String queryVector = embeddingService.generateEmbedding(query);
            List<DocumentEmbedding> vectorResults = documentEmbeddingRepository.findSimilarByVector(queryVector, 3);
            if (vectorResults != null && !vectorResults.isEmpty()) {
                contextBuilder.append("=== SEMANTIC VECTOR MATCHES ===\n");
                for (DocumentEmbedding de : vectorResults) {
                    contextBuilder.append(String.format("• [%s - %s] %s\n  %s\n\n",
                            de.getDocumentType(), de.getSourceId(), de.getTitle(), de.getContent()));
                }
            }
        } catch (Exception e) {
            log.debug("Vector similarity lookup skipped or not configured: {}", e.getMessage());
        }

        return RagContext.builder()
                .formattedContext(contextBuilder.toString())
                .citations(citations)
                .relatedFirIds(relatedFirIds)
                .relatedPersonIds(relatedPersonIds)
                .build();
    }
}