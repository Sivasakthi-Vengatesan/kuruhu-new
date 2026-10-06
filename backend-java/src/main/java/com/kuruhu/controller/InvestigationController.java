package com.kuruhu.controller;

import com.kuruhu.dto.InvestigationDTO;
import com.kuruhu.service.InvestigationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/investigations")
@Tag(name = "Investigation Workflow", description = "Investigation progress tracking")
public class InvestigationController {
    private final InvestigationService investigationService;

    public InvestigationController(InvestigationService investigationService) { this.investigationService = investigationService; }

    @GetMapping
    public ResponseEntity<List<InvestigationDTO>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(investigationService.getAllInvestigations(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvestigationDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(investigationService.getInvestigationById(id));
    }
}
