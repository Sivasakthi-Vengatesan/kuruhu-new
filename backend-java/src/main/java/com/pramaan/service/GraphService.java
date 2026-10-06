package com.pramaan.service;

import com.pramaan.dto.GraphEdge;
import com.pramaan.dto.GraphNode;
import com.pramaan.dto.GraphResponse;
import com.pramaan.entity.*;
import com.pramaan.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GraphService {

    private final FirRepository firRepository;
    private final PersonRepository personRepository;
    private final EvidenceRepository evidenceRepository;
    private final VehicleRepository vehicleRepository;
    private final LocationRecordRepository locationRecordRepository;
    private final PersonRelationshipRepository personRelationshipRepository;
    private final CasePartyRepository casePartyRepository;

    public GraphService(FirRepository firRepository, PersonRepository personRepository, EvidenceRepository evidenceRepository, VehicleRepository vehicleRepository, LocationRecordRepository locationRecordRepository, PersonRelationshipRepository personRelationshipRepository, CasePartyRepository casePartyRepository) {
        this.firRepository = firRepository;
        this.personRepository = personRepository;
        this.evidenceRepository = evidenceRepository;
        this.vehicleRepository = vehicleRepository;
        this.locationRecordRepository = locationRecordRepository;
        this.personRelationshipRepository = personRelationshipRepository;
        this.casePartyRepository = casePartyRepository;
    }


    @Transactional(readOnly = true)
    public GraphResponse getFullGraph(Long personId, Long firId) {
        List<GraphNode> nodes = new ArrayList<>();
        List<GraphEdge> edges = new ArrayList<>();

        List<Fir> firs = firRepository.findAll();
        List<Person> persons = personRepository.findAll();
        List<Evidence> evidenceList = evidenceRepository.findAll();
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<LocationRecord> locations = locationRecordRepository.findAll();

        // 1. FIR nodes
        for (Fir f : firs) {
            nodes.add(GraphNode.builder()
                    .id(String.valueOf(f.getId()))
                    .kind("fir")
                    .label("FIR " + f.getFirNumber())
                    .sub(f.getStationName())
                    .href("/workspace/firs/" + f.getId() + "/")
                    .x(0)
                    .y(0)
                    .build());
        }

        // 2. Person nodes & case party edges
        for (Person p : persons) {
            nodes.add(GraphNode.builder()
                    .id(String.valueOf(p.getId()))
                    .kind("person")
                    .label(p.getCanonicalName())
                    .sub(p.getPrimaryRole())
                    .href("/workspace/persons/" + p.getId() + "/")
                    .x(0)
                    .y(0)
                    .build());
        }

        List<CaseParty> parties = casePartyRepository.findAll();
        for (CaseParty cp : parties) {
            edges.add(GraphEdge.builder()
                    .source(String.valueOf(cp.getFir().getId()))
                    .target(String.valueOf(cp.getPerson().getId()))
                    .label(cp.getRole())
                    .firRef(String.valueOf(cp.getFir().getId()))
                    .verified(true)
                    .build());
        }

        // 3. Evidence nodes & edges
        for (Evidence e : evidenceList) {
            nodes.add(GraphNode.builder()
                    .id(String.valueOf(e.getId()))
                    .kind("evidence")
                    .label(e.getLabel())
                    .sub(e.getEvidenceType())
                    .x(0)
                    .y(0)
                    .build());

            edges.add(GraphEdge.builder()
                    .source(String.valueOf(e.getFir().getId()))
                    .target(String.valueOf(e.getId()))
                    .label(e.getEvidenceType())
                    .firRef(String.valueOf(e.getFir().getId()))
                    .verified("verified".equalsIgnoreCase(e.getStatus()))
                    .build());
        }

        // 4. Vehicle nodes & edges
        for (Vehicle v : vehicles) {
            nodes.add(GraphNode.builder()
                    .id(String.valueOf(v.getId()))
                    .kind("vehicle")
                    .label(v.getRegistrationNumber())
                    .sub(v.getMake() != null ? v.getMake() : "Vehicle")
                    .x(0)
                    .y(0)
                    .build());

            for (Fir f : v.getFirs()) {
                edges.add(GraphEdge.builder()
                        .source(String.valueOf(f.getId()))
                        .target(String.valueOf(v.getId()))
                        .label("Linked Vehicle")
                        .firRef(String.valueOf(f.getId()))
                        .verified(true)
                        .build());
            }
        }

        // 5. Person-to-Person relationships
        List<PersonRelationship> relationships = personRelationshipRepository.findAll();
        for (PersonRelationship pr : relationships) {
            edges.add(GraphEdge.builder()
                    .source(String.valueOf(pr.getPerson().getId()))
                    .target(String.valueOf(pr.getRelatedPerson().getId()))
                    .label(pr.getRelationshipLabel())
                    .firRef(pr.getFirReference() != null ? String.valueOf(pr.getFirReference().getId()) : "")
                    .verified(pr.getIsVerified() != null ? pr.getIsVerified() : true)
                    .build());
        }

        return GraphResponse.builder()
                .nodes(nodes)
                .edges(edges)
                .build();
    }
}