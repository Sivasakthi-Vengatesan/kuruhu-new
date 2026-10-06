package com.kuruhu.controller;

import com.kuruhu.dto.GraphResponse;
import com.kuruhu.service.GraphService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/graph")
@Tag(name = "Entity Graph", description = "Visual crime network & relationship graph")
public class GraphController {
    private final GraphService graphService;

    public GraphController(GraphService graphService) { this.graphService = graphService; }

    @GetMapping
    public ResponseEntity<GraphResponse> getGraph(@RequestParam(required = false) Long personId) {
        return ResponseEntity.ok(graphService.getInvestigationNetwork(personId));
    }

    @GetMapping("/{personId}")
    public ResponseEntity<GraphResponse> getByPerson(@PathVariable Long personId) {
        return ResponseEntity.ok(graphService.getInvestigationNetwork(personId));
    }
}
