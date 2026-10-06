package com.kuruhu.controller;

import com.kuruhu.dto.DashboardDTO;
import com.kuruhu.service.DashboardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dashboard")
@Tag(name = "Dashboard", description = "Aggregate statistics & executive KPI metrics")
public class DashboardController {
    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) { this.dashboardService = dashboardService; }

    @GetMapping("/summary")
    public ResponseEntity<DashboardDTO> getSummary() {
        return ResponseEntity.ok(dashboardService.getDashboardMetrics());
    }
}
