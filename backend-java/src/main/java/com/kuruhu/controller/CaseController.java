package com.kuruhu.controller;

import com.kuruhu.dto.CaseDTO;
import com.kuruhu.dto.CreateCaseRequest;
import com.kuruhu.dto.UpdateCaseRequest;
import com.kuruhu.service.CaseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cases")
@Tag(name = "Case Files", description = "Investigation case management APIs")
public class CaseController {
    private final CaseService caseService;

    public CaseController(CaseService caseService) { this.caseService = caseService; }

    @GetMapping
    public ResponseEntity<List<CaseDTO>> getAllCases(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(caseService.getAllCases(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaseDTO> getCaseById(@PathVariable Long id) {
        return ResponseEntity.ok(caseService.getCaseById(id));
    }

    @PostMapping
    public ResponseEntity<CaseDTO> createCase(@RequestBody CreateCaseRequest request) {
        return ResponseEntity.ok(caseService.createCase(request));
    }
}
