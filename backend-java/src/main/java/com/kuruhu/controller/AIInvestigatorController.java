package com.kuruhu.controller;

import com.kuruhu.dto.*;
import com.kuruhu.service.AIInvestigatorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/investigator")
@Tag(name = "AI Investigator", description = "Explainable AI, RAG, Hotspots & Pattern discovery")
public class AIInvestigatorController {
    private final AIInvestigatorService aiService;

    public AIInvestigatorController(AIInvestigatorService aiService) { this.aiService = aiService; }

    @PostMapping("/query")
    public ResponseEntity<AIQueryResponse> query(@RequestBody AIQueryRequest request) {
        return ResponseEntity.ok(aiService.queryInvestigator(request));
    }

    @GetMapping("/findings")
    public ResponseEntity<List<AIFindingDTO>> getFindings() {
        return ResponseEntity.ok(aiService.getFindings());
    }

    @GetMapping("/hotspots")
    public ResponseEntity<List<HotspotDTO>> getHotspots() {
        return ResponseEntity.ok(aiService.getHotspots());
    }

    @GetMapping("/early-warnings")
    public ResponseEntity<List<EarlyWarningDTO>> getEarlyWarnings() {
        return ResponseEntity.ok(aiService.getEarlyWarnings());
    }

    @GetMapping("/patrol-routes")
    public ResponseEntity<List<PatrolRouteDTO>> getPatrolRoutes() {
        return ResponseEntity.ok(aiService.getPatrolRoutes());
    }

    @GetMapping("/patterns")
    public ResponseEntity<List<PatternDTO>> getPatterns() {
        return ResponseEntity.ok(aiService.getPatterns());
    }
}
