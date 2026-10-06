package com.pramaan.service;

import com.pramaan.dto.CreateEvidenceRequest;
import com.pramaan.dto.EvidenceDto;
import com.pramaan.entity.Evidence;
import com.pramaan.entity.Fir;
import com.pramaan.exception.ResourceNotFoundException;
import com.pramaan.repository.EvidenceRepository;
import com.pramaan.repository.FirRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class EvidenceService {

    private final EvidenceRepository evidenceRepository;
    private final FirRepository firRepository;
    private final ActivityService activityService;

    public EvidenceService(EvidenceRepository evidenceRepository, FirRepository firRepository, ActivityService activityService) {
        this.evidenceRepository = evidenceRepository;
        this.firRepository = firRepository;
        this.activityService = activityService;
    }


    @Transactional(readOnly = true)
    public List<EvidenceDto> getAllEvidence() {
        return evidenceRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<EvidenceDto> getEvidenceByFirId(Long firId) {
        return evidenceRepository.findByFirId(firId).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EvidenceDto getEvidenceById(Long id) {
        Evidence evidence = evidenceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evidence not found with ID: " + id));
        return mapToDto(evidence);
    }

    @Transactional
    public EvidenceDto createEvidence(CreateEvidenceRequest request) {
        Fir fir = firRepository.findById(request.getFirId())
                .orElseThrow(() -> new ResourceNotFoundException("FIR not found with ID: " + request.getFirId()));

        OffsetDateTime now = OffsetDateTime.now();
        Evidence evidence = Evidence.builder()
                .fir(fir)
                .evidenceCode("E-" + (1000 + new Random().nextInt(9000)))
                .label(request.getLabel())
                .evidenceType(request.getEvidenceType().toLowerCase())
                .status(StringUtils.hasText(request.getStatus()) ? request.getStatus().toLowerCase() : "collected")
                .collectedBy(StringUtils.hasText(request.getCollectedBy()) ? request.getCollectedBy() : "Investigating Officer")
                .collectedAt(now)
                .locationDescription(StringUtils.hasText(request.getLocationDescription()) ? request.getLocationDescription() : fir.getStationName())
                .notes(request.getNotes())
                .build();

        evidence = evidenceRepository.save(evidence);
        activityService.logActivity(null, "Linked evidence", evidence.getLabel() + " → FIR " + fir.getFirNumber(), "evidence", "Evidence item registered and hashed");

        return mapToDto(evidence);
    }

    @Transactional
    public void deleteEvidence(Long id) {
        Evidence evidence = evidenceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evidence not found with ID: " + id));
        evidenceRepository.delete(evidence);
        activityService.logActivity(null, "Removed evidence", evidence.getLabel(), "evidence", "Evidence record archived");
    }

    public EvidenceDto mapToDto(Evidence evidence) {
        return EvidenceDto.builder()
                .id(String.valueOf(evidence.getId()))
                .label(evidence.getLabel())
                .type(evidence.getEvidenceType() != null ? evidence.getEvidenceType().toLowerCase() : "physical")
                .firId(String.valueOf(evidence.getFir().getId()))
                .status(evidence.getStatus() != null ? evidence.getStatus().toLowerCase() : "collected")
                .collectedBy(evidence.getCollectedBy() != null ? evidence.getCollectedBy() : "Investigating Officer")
                .collectedAt(evidence.getCollectedAt() != null ? evidence.getCollectedAt().toString() : OffsetDateTime.now().toString())
                .location(evidence.getLocationDescription() != null ? evidence.getLocationDescription() : "Evidence Locker")
                .build();
    }
}