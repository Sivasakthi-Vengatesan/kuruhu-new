package com.pramaan.controller;

import com.pramaan.dto.ApiResponse;
import com.pramaan.dto.CreateEvidenceRequest;
import com.pramaan.dto.EvidenceDto;
import com.pramaan.service.EvidenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/evidence")
@Tag(name = "Evidence Management", description = "Physical, digital, CCTV, and biological evidence management")
public class EvidenceController {

    private final EvidenceService evidenceService;

    public EvidenceController(EvidenceService evidenceService) {
        this.evidenceService = evidenceService;
    }


    @GetMapping
    @Operation(summary = "Get all evidence items or filter by FIR ID")
    public ResponseEntity<List<EvidenceDto>> getAllEvidence(@RequestParam(required = false) Long firId) {
        if (firId != null) {
            return ResponseEntity.ok(evidenceService.getEvidenceByFirId(firId));
        }
        return ResponseEntity.ok(evidenceService.getAllEvidence());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get single evidence item by ID")
    public ResponseEntity<EvidenceDto> getEvidenceById(@PathVariable Long id) {
        return ResponseEntity.ok(evidenceService.getEvidenceById(id));
    }

    @PostMapping
    @Operation(summary = "Link new evidence item to FIR")
    public ResponseEntity<EvidenceDto> createEvidence(@Valid @RequestBody CreateEvidenceRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(evidenceService.createEvidence(request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete evidence record")
    public ResponseEntity<ApiResponse<Void>> deleteEvidence(@PathVariable Long id) {
        evidenceService.deleteEvidence(id);
        return ResponseEntity.ok(ApiResponse.of("Evidence record deleted successfully", null));
    }
}