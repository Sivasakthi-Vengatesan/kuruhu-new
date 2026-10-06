package com.pramaan.controller;

import com.pramaan.dto.ApiResponse;
import com.pramaan.dto.CreateFirRequest;
import com.pramaan.dto.FirDto;
import com.pramaan.dto.UpdateFirRequest;
import com.pramaan.service.FirService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/firs")
@Tag(name = "FIR Management", description = "First Information Report CRUD, search, and filtering")
public class FirController {

    private final FirService firService;

    public FirController(FirService firService) {
        this.firService = firService;
    }


    @GetMapping
    @Operation(summary = "Get all FIRs with optional query, status, priority, station filters")
    public ResponseEntity<List<FirDto>> getAllFirs(
            @RequestParam(required = false) String query,
            @RequestParam(required = false, defaultValue = "all") String status,
            @RequestParam(required = false, defaultValue = "all") String priority,
            @RequestParam(required = false, defaultValue = "all") String station,
            @RequestParam(required = false, defaultValue = "true") Boolean sortDesc) {
        return ResponseEntity.ok(firService.getAllFirs(query, status, priority, station, sortDesc));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get single FIR by ID or crime number")
    public ResponseEntity<FirDto> getFirById(@PathVariable String id) {
        return ResponseEntity.ok(firService.getFirById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new FIR (from wizard or API)")
    public ResponseEntity<FirDto> createFir(@Valid @RequestBody CreateFirRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(firService.createFir(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing FIR")
    public ResponseEntity<FirDto> updateFir(@PathVariable String id, @RequestBody UpdateFirRequest request) {
        return ResponseEntity.ok(firService.updateFir(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an FIR")
    public ResponseEntity<ApiResponse<Void>> deleteFir(@PathVariable String id) {
        firService.deleteFir(id);
        return ResponseEntity.ok(ApiResponse.of("FIR deleted successfully", null));
    }
}