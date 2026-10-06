package com.kuruhu.service.impl;

import com.kuruhu.service.DashboardService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DashboardServiceImpl implements DashboardService {

    @Override
    public DashboardDTO getDashboardMetrics() {
        return DashboardDTO.builder()
                .totalFIRs(142)
                .activeCases(38)
                .totalPersons(215)
                .evidenceCount(480)
                .criticalHotspots(6)
                .firsByCategory(Map.of("Burglary", 45L, "Robbery", 28L, "Fraud", 35L))
                .recentActivities(List.of())
                .build();
    }

    @Override
    public DashboardDTO getDistrictMetrics(String district) {
        return DashboardDTO.builder()
                .totalFIRs(142)
                .activeCases(38)
                .totalPersons(215)
                .evidenceCount(480)
                .criticalHotspots(6)
                .firsByCategory(Map.of("Burglary", 45L, "Robbery", 28L, "Fraud", 35L))
                .recentActivities(List.of())
                .build();
    }
}
