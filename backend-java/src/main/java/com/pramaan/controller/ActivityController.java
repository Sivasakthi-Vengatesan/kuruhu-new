package com.pramaan.controller;

import com.pramaan.dto.ActivityEventDto;
import com.pramaan.dto.CreateAuditLogRequest;
import com.pramaan.service.ActivityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/activity")
@Tag(name = "Activity & Audit Trail", description = "Tamper-evident activity logging and audit history")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }


    @GetMapping
    @Operation(summary = "Get audit trail logs with search and target type filters")
    public ResponseEntity<List<ActivityEventDto>> getActivities(
            @RequestParam(required = false) String query,
            @RequestParam(required = false, defaultValue = "all") String type) {
        return ResponseEntity.ok(activityService.getActivities(query, type));
    }

    @PostMapping
    @Operation(summary = "Record manual or system audit event")
    public ResponseEntity<ActivityEventDto> createActivity(@Valid @RequestBody CreateAuditLogRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(activityService.createActivity(request));
    }
}