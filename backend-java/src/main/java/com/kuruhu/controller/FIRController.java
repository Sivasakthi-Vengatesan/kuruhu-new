package com.kuruhu.controller;

import com.kuruhu.dto.CreateFIRRequest;
import com.kuruhu.dto.FIRDTO;
import com.kuruhu.dto.UpdateFIRRequest;
import com.kuruhu.service.FIRService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/firs")
@Tag(name = "FIR Management", description = "First Information Report lifecycle APIs")
public class FIRController {
    private final FIRService firService;

    public FIRController(FIRService firService) {
        this.firService = firService;
    }

    @GetMapping
    @Operation(summary = "Get list of FIRs")
    public ResponseEntity<List<FIRDTO>> getAllFIRs(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(firService.getAllFIRs(page, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get FIR by ID")
    public ResponseEntity<FIRDTO> getFIRById(@PathVariable Long id) {
        return ResponseEntity.ok(firService.getFIRById(id));
    }

    @PostMapping
    @Operation(summary = "Create new FIR")
    public ResponseEntity<FIRDTO> createFIR(@RequestBody CreateFIRRequest request) {
        return ResponseEntity.ok(firService.createFIR(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update FIR")
    public ResponseEntity<FIRDTO> updateFIR(@PathVariable Long id, @RequestBody UpdateFIRRequest request) {
        return ResponseEntity.ok(firService.updateFIR(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete FIR")
    public ResponseEntity<Void> deleteFIR(@PathVariable Long id) {
        firService.deleteFIR(id);
        return ResponseEntity.noContent().build();
    }
}
