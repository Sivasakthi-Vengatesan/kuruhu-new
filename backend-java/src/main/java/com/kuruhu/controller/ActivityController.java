package com.kuruhu.controller;

import com.kuruhu.dto.ActivityDTO;
import com.kuruhu.dto.CreateAuditLogRequest;
import com.kuruhu.service.ActivityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/activity")
@Tag(name = "Audit & Activity", description = "Audit trail and event logging")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) { this.activityService = activityService; }

    @GetMapping
    public ResponseEntity<List<ActivityDTO>> getActivities(@RequestParam(defaultValue = "all") String query, @RequestParam(defaultValue = "all") String type) {
        return ResponseEntity.ok(activityService.getActivities(query, type));
    }

    @PostMapping
    public ResponseEntity<Void> logActivity(@RequestBody CreateAuditLogRequest request) {
        activityService.logActivity(request);
        return ResponseEntity.ok().build();
    }
}
