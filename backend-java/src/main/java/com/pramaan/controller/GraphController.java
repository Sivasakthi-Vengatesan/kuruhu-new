package com.pramaan.controller;

import com.pramaan.dto.GraphResponse;
import com.pramaan.service.GraphService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/graph")
@Tag(name = "Entity Graph", description = "Dynamic entity-relationship network graph between FIRs, persons, evidence, vehicles, and officers")
public class GraphController {

    private final GraphService graphService;

    public GraphController(GraphService graphService) {
        this.graphService = graphService;
    }


    @GetMapping
    @Operation(summary = "Get full entity graph with nodes and edges")
    public ResponseEntity<GraphResponse> getGraph(
            @RequestParam(required = false) Long personId,
            @RequestParam(required = false) Long firId) {
        return ResponseEntity.ok(graphService.getFullGraph(personId, firId));
    }

    @GetMapping("/person/{personId}")
    @Operation(summary = "Get ego network graph centered on specific person")
    public ResponseEntity<GraphResponse> getPersonGraph(@PathVariable Long personId) {
        return ResponseEntity.ok(graphService.getFullGraph(personId, null));
    }

    @GetMapping("/fir/{firId}")
    @Operation(summary = "Get entity network graph centered on specific FIR")
    public ResponseEntity<GraphResponse> getFirGraph(@PathVariable Long firId) {
        return ResponseEntity.ok(graphService.getFullGraph(null, firId));
    }
}