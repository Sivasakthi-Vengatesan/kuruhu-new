package com.pramaan.ai;

import com.pramaan.entity.DocumentEmbedding;
import com.pramaan.entity.Evidence;
import com.pramaan.entity.Fir;
import com.pramaan.entity.Person;
import com.pramaan.repository.DocumentEmbeddingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmbeddingService {

    private static final Logger log = LoggerFactory.getLogger(EmbeddingService.class);
    private static final int DIMENSION = 384;

    private final DocumentEmbeddingRepository embeddingRepository;

    public EmbeddingService(DocumentEmbeddingRepository embeddingRepository) {
        this.embeddingRepository = embeddingRepository;
    }


    /**
     * Generates a 384-dimensional vector string representation: "[0.123, -0.456, ...]"
     */
    public String generateEmbedding(String text) {
        if (text == null || text.trim().isEmpty()) {
            return generateZeroVector();
        }

        float[] vector = new float[DIMENSION];
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(text.toLowerCase().getBytes(StandardCharsets.UTF_8));

            // Seed vector deterministically from text tokens & hash
            String[] words = text.toLowerCase().split("\\s+");
            for (int i = 0; i < DIMENSION; i++) {
                byte h = hash[i % hash.length];
                float val = (float) (h & 0xFF) / 255.0f - 0.5f;
                for (String word : words) {
                    if (word.length() > 2) {
                        int code = Math.abs(word.hashCode() + i * 31);
                        val += (float) (code % 100) / 500.0f - 0.1f;
                    }
                }
                vector[i] = val;
            }

            // Normalize vector to unit length
            double norm = 0.0;
            for (float v : vector) {
                norm += v * v;
            }
            norm = Math.sqrt(norm);
            if (norm > 0) {
                for (int i = 0; i < DIMENSION; i++) {
                    vector[i] /= norm;
                }
            }
        } catch (Exception e) {
            log.error("Error generating deterministic vector embedding: {}", e.getMessage());
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < DIMENSION; i++) {
            sb.append(String.format("%.6f", vector[i]));
            if (i < DIMENSION - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    private String generateZeroVector() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < DIMENSION; i++) {
            sb.append("0.000000");
            if (i < DIMENSION - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    @Transactional
    public void indexFir(Fir fir) {
        String content = "FIR " + fir.getFirNumber() + ": " + fir.getTitle() + ". " +
                fir.getSummary() + " Station: " + fir.getStationName() + ", District: " + fir.getDistrict() +
                ". Officer: " + fir.getInvestigatingOfficer() + ". Priority: " + fir.getPriority() +
                ", Status: " + fir.getStatus() + ". Sections: " + fir.getSections();

        DocumentEmbedding doc = DocumentEmbedding.builder()
                .documentType("fir")
                .sourceId(String.valueOf(fir.getId()))
                .title("FIR " + fir.getFirNumber() + " — " + fir.getTitle())
                .content(content)
                .embedding(generateEmbedding(content))
                .build();

        embeddingRepository.save(doc);
    }

    @Transactional
    public void indexPerson(Person person) {
        String content = "Person: " + person.getCanonicalName() + " (Age: " + person.getAgeYears() +
                ", Role: " + person.getPrimaryRole() + ", Risk: " + person.getRiskLevel() +
                "). Address: " + person.getAddress() + ". Phone: " + person.getPhone() +
                ". Known Locations: " + person.getKnownLocations() +
                ". Behavioral Profile: " + person.getBehavioralProfile();

        DocumentEmbedding doc = DocumentEmbedding.builder()
                .documentType("person")
                .sourceId(String.valueOf(person.getId()))
                .title("Person " + person.getCanonicalName() + " (" + person.getPrimaryRole() + ")")
                .content(content)
                .embedding(generateEmbedding(content))
                .build();

        embeddingRepository.save(doc);
    }

    @Transactional
    public void indexEvidence(Evidence evidence) {
        String content = "Evidence " + evidence.getEvidenceCode() + " (" + evidence.getEvidenceType() +
                "): " + evidence.getLabel() + ". Status: " + evidence.getStatus() +
                ". Collected by: " + evidence.getCollectedBy() + " at " + evidence.getLocationDescription() +
                ". Linked to FIR ID: " + evidence.getFir().getId();

        DocumentEmbedding doc = DocumentEmbedding.builder()
                .documentType("evidence")
                .sourceId(String.valueOf(evidence.getId()))
                .title("Evidence " + evidence.getLabel())
                .content(content)
                .embedding(generateEmbedding(content))
                .build();

        embeddingRepository.save(doc);
    }
}