package com.pramaan.controller;

import com.pramaan.dto.*;
import com.pramaan.service.InvestigatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/investigator")
@Tag(name = "AI Investigator", description = "AI reasoning over database records, findings verification, hotspots, early warnings, and patterns")
public class InvestigatorController {

    private final InvestigatorService investigatorService;

    public InvestigatorController(InvestigatorService investigatorService) {
        this.investigatorService = investigatorService;
    }


    @PostMapping("/query")
    @Operation(summary = "Ask question to AI Investigator with grounded citations")
    public ResponseEntity<AiQueryResponse> queryInvestigator(@Valid @RequestBody AiQueryRequest request) {
        return ResponseEntity.ok(investigatorService.queryInvestigator(request));
    }

    @GetMapping("/findings")
    @Operation(summary = "Get all AI generated findings in verification queue")
    public ResponseEntity<List<AiFindingDto>> getAllFindings() {
        return ResponseEntity.ok(investigatorService.getAllFindings());
    }

    @GetMapping("/findings/{id}")
    @Operation(summary = "Get finding details by ID or finding code")
    public ResponseEntity<AiFindingDto> getFindingById(@PathVariable String id) {
        return ResponseEntity.ok(investigatorService.getFindingById(id));
    }

    @PatchMapping("/findings/{id}/verify")
    @Operation(summary = "Verify or reject an AI finding")
    public ResponseEntity<AiFindingDto> verifyFinding(
            @PathVariable String id,
            @RequestBody VerifyFindingRequest request) {
        return ResponseEntity.ok(investigatorService.verifyFinding(id, request));
    }

    @GetMapping("/hotspots")
    @Operation(summary = "Get spatial crime hotspot clusters")
    public ResponseEntity<List<CrimeHotspotDto>> getCrimeHotspots() {
        return ResponseEntity.ok(investigatorService.getCrimeHotspots());
    }

    @GetMapping("/early-warnings")
    @Operation(summary = "Get predictive early warnings and syndicate movements")
    public ResponseEntity<List<PredictiveEarlyWarningDto>> getEarlyWarnings() {
        return ResponseEntity.ok(investigatorService.getEarlyWarnings());
    }

    @GetMapping("/patrol-routes")
    @Operation(summary = "Get proactive patrol route assignments")
    public ResponseEntity<List<ProactivePatrolRouteDto>> getPatrolRoutes() {
        return ResponseEntity.ok(investigatorService.getPatrolRoutes());
    }

    @GetMapping("/crime-patterns")
    @Operation(summary = "Get crime pattern clusters and modus operandi analysis")
    public ResponseEntity<List<CrimePatternClusterDto>> getCrimePatterns() {
        return ResponseEntity.ok(investigatorService.getCrimePatterns());
    }
}