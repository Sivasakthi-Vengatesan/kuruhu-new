package com.pramaan.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pramaan.dto.*;
import com.pramaan.entity.*;
import com.pramaan.exception.ResourceNotFoundException;
import com.pramaan.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FirService {

    private static final Logger log = LoggerFactory.getLogger(FirService.class);

    private final FirRepository firRepository;
    private final FirTimelineRepository firTimelineRepository;
    private final PoliceStationRepository policeStationRepository;
    private final PersonRepository personRepository;
    private final CasePartyRepository casePartyRepository;
    private final EvidenceRepository evidenceRepository;
    private final VehicleRepository vehicleRepository;
    private final LocationRecordRepository locationRecordRepository;
    private final ActivityService activityService;
    private final ObjectMapper objectMapper;

    public FirService(FirRepository firRepository, FirTimelineRepository firTimelineRepository, PoliceStationRepository policeStationRepository, PersonRepository personRepository, CasePartyRepository casePartyRepository, EvidenceRepository evidenceRepository, VehicleRepository vehicleRepository, LocationRecordRepository locationRecordRepository, ActivityService activityService, ObjectMapper objectMapper) {
        this.firRepository = firRepository;
        this.firTimelineRepository = firTimelineRepository;
        this.policeStationRepository = policeStationRepository;
        this.personRepository = personRepository;
        this.casePartyRepository = casePartyRepository;
        this.evidenceRepository = evidenceRepository;
        this.vehicleRepository = vehicleRepository;
        this.locationRecordRepository = locationRecordRepository;
        this.activityService = activityService;
        this.objectMapper = objectMapper;
    }


    @Transactional(readOnly = true)
    public List<FirDto> getAllFirs(String query, String status, String priority, String station, Boolean sortDesc) {
        List<Fir> firs = firRepository.filterFirs(query, status, priority, station);
        boolean desc = sortDesc == null || sortDesc;

        List<FirDto> dtos = firs.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

        dtos.sort((a, b) -> {
            OffsetDateTime tA = OffsetDateTime.parse(a.getRegisteredAt());
            OffsetDateTime tB = OffsetDateTime.parse(b.getRegisteredAt());
            return desc ? tB.compareTo(tA) : tA.compareTo(tB);
        });

        return dtos;
    }

    @Transactional(readOnly = true)
    public FirDto getFirById(String idOrNumber) {
        Fir fir = null;
        if (idOrNumber.matches("^\\d+$")) {
            fir = firRepository.findById(Long.parseLong(idOrNumber)).orElse(null);
        }
        if (fir == null) {
            fir = firRepository.findByFirNumber(idOrNumber)
                    .orElseThrow(() -> new ResourceNotFoundException("FIR not found with ID/Number: " + idOrNumber));
        }

        return mapToDto(fir);
    }

    @Transactional
    public FirDto createFir(CreateFirRequest request) {
        String crimeNo = request.getCrimeNumber();
        if (!StringUtils.hasText(crimeNo)) {
            crimeNo = StringUtils.hasText(request.getNumber()) ? request.getNumber() : String.format("%04d/2026", new Random().nextInt(900) + 100);
        }

        String title = request.getTitle();
        if (!StringUtils.hasText(title)) {
            title = StringUtils.hasText(request.getBriefFacts()) ? request.getBriefFacts() : "New Incident Report";
            if (title.length() > 60) title = title.substring(0, 60) + "...";
        }

        String summary = StringUtils.hasText(request.getBriefFacts()) ? request.getBriefFacts() : request.getSummary();
        if (!StringUtils.hasText(summary)) {
            summary = "FIR registered at police station for investigation.";
        }

        PoliceStation station = null;
        if (request.getPoliceStationId() != null) {
            station = policeStationRepository.findById(request.getPoliceStationId()).orElse(null);
        }
        if (station == null && StringUtils.hasText(request.getStation())) {
            station = policeStationRepository.findByStationCode(request.getStation())
                    .or(() -> policeStationRepository.findAll().stream()
                            .filter(s -> s.getName().equalsIgnoreCase(request.getStation()))
                            .findFirst()).orElse(null);
        }

        String stationName = station != null ? station.getName() : (StringUtils.hasText(request.getStation()) ? request.getStation() : "Jayanagar PS");
        String district = station != null ? station.getDistrict() : (StringUtils.hasText(request.getDistrict()) ? request.getDistrict() : "Bengaluru City");
        String officer = StringUtils.hasText(request.getOfficer()) ? request.getOfficer() : "Insp. Meera Kulkarni";
        String priority = StringUtils.hasText(request.getPriority()) ? request.getPriority().toLowerCase() : "medium";
        String status = StringUtils.hasText(request.getStatus()) ? request.getStatus().toLowerCase() : "registered";

        String sectionsJson = "[]";
        if (request.getSections() != null && !request.getSections().isEmpty()) {
            try {
                sectionsJson = objectMapper.writeValueAsString(request.getSections());
            } catch (Exception e) {
                log.warn("Error serializing sections: {}", e.getMessage());
            }
        }

        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime incidentDate = now;
        if (StringUtils.hasText(request.getIncidentDate())) {
            try {
                incidentDate = OffsetDateTime.parse(request.getIncidentDate());
            } catch (Exception ignored) {}
        }

        Fir fir = Fir.builder()
                .firNumber(crimeNo)
                .title(title)
                .summary(summary)
                .policeStation(station)
                .stationName(stationName)
                .district(district)
                .investigatingOfficer(officer)
                .priority(priority)
                .status(status)
                .sections(sectionsJson)
                .incidentDate(incidentDate)
                .registeredAt(now)
                .updatedAt(now)
                .build();

        fir = firRepository.save(fir);

        // Add initial timeline event
        FirTimeline timelineEvent = FirTimeline.builder()
                .fir(fir)
                .eventTime(now)
                .title("FIR Registered")
                .detail(String.format("FIR %s registered at %s.", fir.getFirNumber(), fir.getStationName()))
                .actor(fir.getInvestigatingOfficer())
                .build();
        firTimelineRepository.save(timelineEvent);
        if (fir.getTimeline() == null) {
            fir.setTimeline(new ArrayList<>());
        }
        fir.getTimeline().add(timelineEvent);

        // Process complainant if present
        if (StringUtils.hasText(request.getComplainantName())) {
            Person complainant = Person.builder()
                    .canonicalName(request.getComplainantName())
                    .primaryRole("complainant")
                    .riskLevel("low")
                    .phone(request.getComplainantPhone())
                    .address(request.getComplainantAddress())
                    .lastActivity(now)
                    .build();
            complainant = personRepository.save(complainant);

            CaseParty cp = CaseParty.builder()
                    .fir(fir)
                    .person(complainant)
                    .role("complainant")
                    .notes("Complainant in FIR " + fir.getFirNumber())
                    .build();
            casePartyRepository.save(cp);
        }

        // Process involved persons from wizard
        if (request.getPersons() != null) {
            for (CreateFirRequest.PersonEntry pe : request.getPersons()) {
                if (StringUtils.hasText(pe.name)) {
                    Person p = Person.builder()
                            .canonicalName(pe.name)
                            .primaryRole(StringUtils.hasText(pe.role) ? pe.role.toLowerCase() : "suspect")
                            .riskLevel("medium")
                            .lastActivity(now)
                            .build();
                    p = personRepository.save(p);

                    CaseParty cp = CaseParty.builder()
                            .fir(fir)
                            .person(p)
                            .role(p.getPrimaryRole())
                            .notes(pe.note)
                            .build();
                    casePartyRepository.save(cp);
                }
            }
        }

        // Process evidence items from wizard
        if (request.getEvidence() != null) {
            for (CreateFirRequest.EvidenceEntry ee : request.getEvidence()) {
                if (StringUtils.hasText(ee.label)) {
                    Evidence ev = Evidence.builder()
                            .fir(fir)
                            .evidenceCode("E-" + (1000 + new Random().nextInt(9000)))
                            .label(ee.label)
                            .evidenceType(StringUtils.hasText(ee.type) ? ee.type.toLowerCase() : "physical")
                            .status("collected")
                            .collectedBy(fir.getInvestigatingOfficer())
                            .collectedAt(now)
                            .locationDescription(fir.getStationName())
                            .build();
                    evidenceRepository.save(ev);
                }
            }
        }

        activityService.logActivity(null, "Created FIR", "FIR " + fir.getFirNumber() + ": " + fir.getTitle(), "fir", "New FIR intake");

        return mapToDto(fir);
    }

    @Transactional
    public FirDto updateFir(String idOrNumber, UpdateFirRequest request) {
        FirDto existing = getFirById(idOrNumber);
        Fir fir = firRepository.findById(Long.parseLong(existing.getId()))
                .orElseThrow(() -> new ResourceNotFoundException("FIR not found: " + idOrNumber));

        if (StringUtils.hasText(request.getTitle())) fir.setTitle(request.getTitle());
        if (StringUtils.hasText(request.getSummary())) fir.setSummary(request.getSummary());
        if (StringUtils.hasText(request.getPriority())) fir.setPriority(request.getPriority().toLowerCase());
        if (StringUtils.hasText(request.getStatus())) fir.setStatus(request.getStatus().toLowerCase());
        if (StringUtils.hasText(request.getInvestigatingOfficer())) fir.setInvestigatingOfficer(request.getInvestigatingOfficer());
        if (StringUtils.hasText(request.getDistrict())) fir.setDistrict(request.getDistrict());
        if (StringUtils.hasText(request.getStationName())) fir.setStationName(request.getStationName());

        if (request.getSections() != null) {
            try {
                fir.setSections(objectMapper.writeValueAsString(request.getSections()));
            } catch (Exception ignored) {}
        }

        fir.setUpdatedAt(OffsetDateTime.now());
        fir = firRepository.save(fir);

        activityService.logActivity(null, "Updated FIR", "FIR " + fir.getFirNumber(), "fir", "FIR details modified");

        return mapToDto(fir);
    }

    @Transactional
    public void deleteFir(String idOrNumber) {
        FirDto existing = getFirById(idOrNumber);
        firRepository.deleteById(Long.parseLong(existing.getId()));
        activityService.logActivity(null, "Deleted FIR", "FIR " + existing.getNumber(), "fir", "FIR removed from database");
    }

    public FirDto mapToDto(Fir fir) {
        List<String> sections = new ArrayList<>();
        if (StringUtils.hasText(fir.getSections())) {
            try {
                sections = objectMapper.readValue(fir.getSections(), new TypeReference<List<String>>() {});
            } catch (Exception e) {
                sections = List.of(fir.getSections().replace("[", "").replace("]", "").replace("\"", "").split(","));
            }
        }

        List<CaseParty> parties = casePartyRepository.findByFirId(fir.getId());
        List<String> personIds = parties.stream().map(p -> String.valueOf(p.getPerson().getId())).distinct().collect(Collectors.toList());

        List<Evidence> evidenceList = evidenceRepository.findByFirId(fir.getId());
        List<String> evidenceIds = evidenceList.stream().map(e -> String.valueOf(e.getId())).collect(Collectors.toList());

        List<String> vehicleIds = fir.getVehicles().stream().map(v -> String.valueOf(v.getId())).collect(Collectors.toList());
        List<String> locationIds = fir.getLocations().stream().map(l -> String.valueOf(l.getId())).collect(Collectors.toList());

        List<FirTimeline> timelineList = firTimelineRepository.findByFirIdOrderByEventTimeAsc(fir.getId());
        List<FirTimelineDto> timelineDtos = timelineList.stream()
                .map(t -> FirTimelineDto.builder()
                        .id(String.valueOf(t.getId()))
                        .time(t.getEventTime() != null ? t.getEventTime().toString() : fir.getRegisteredAt().toString())
                        .title(t.getTitle())
                        .detail(t.getDetail())
                        .actor(t.getActor())
                        .build())
                .collect(Collectors.toList());

        int relationshipCount = personIds.size() + evidenceIds.size() + vehicleIds.size();

        return FirDto.builder()
                .id(String.valueOf(fir.getId()))
                .number(fir.getFirNumber())
                .title(fir.getTitle())
                .summary(fir.getSummary())
                .station(fir.getStationName())
                .district(fir.getDistrict())
                .officer(fir.getInvestigatingOfficer())
                .priority(fir.getPriority())
                .status(fir.getStatus())
                .sections(sections)
                .registeredAt(fir.getRegisteredAt() != null ? fir.getRegisteredAt().toString() : OffsetDateTime.now().toString())
                .updatedAt(fir.getUpdatedAt() != null ? fir.getUpdatedAt().toString() : OffsetDateTime.now().toString())
                .personIds(personIds)
                .evidenceIds(evidenceIds)
                .vehicleIds(vehicleIds)
                .locationIds(locationIds)
                .relationshipCount(relationshipCount)
                .aiFindingIds(List.of("AI-01", "AI-02"))
                .timeline(timelineDtos)
                .build();
    }
}