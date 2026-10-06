package com.kuruhu.controller;

import com.kuruhu.dto.CreateEvidenceRequest;
import com.kuruhu.dto.EvidenceDTO;
import com.kuruhu.service.EvidenceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/evidence")
@Tag(name = "Evidence Management", description = "Chain of custody and evidence tracking")
public class EvidenceController {
    private final EvidenceService evidenceService;

    public EvidenceController(EvidenceService evidenceService) { this.evidenceService = evidenceService; }

    @GetMapping
    public ResponseEntity<List<EvidenceDTO>> getEvidenceByFIR(@RequestParam(required = false) Long firId) {
        return ResponseEntity.ok(evidenceService.getEvidenceByFIR(firId));
    }

    @PostMapping
    public ResponseEntity<EvidenceDTO> createEvidence(@RequestBody CreateEvidenceRequest request) {
        return ResponseEntity.ok(evidenceService.createEvidence(request));
    }
}
