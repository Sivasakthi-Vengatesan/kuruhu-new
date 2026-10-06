package com.pramaan.service;

import com.pramaan.dto.DashboardSummaryDto;
import com.pramaan.dto.MetricTrendDto;
import com.pramaan.dto.WeeklyIntakeDto;
import com.pramaan.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    private final FirRepository firRepository;
    private final PersonRepository personRepository;
    private final EvidenceRepository evidenceRepository;
    private final VehicleRepository vehicleRepository;
    private final AiFindingRepository aiFindingRepository;
    private final NotificationRepository notificationRepository;

    public DashboardService(FirRepository firRepository, PersonRepository personRepository, EvidenceRepository evidenceRepository, VehicleRepository vehicleRepository, AiFindingRepository aiFindingRepository, NotificationRepository notificationRepository) {
        this.firRepository = firRepository;
        this.personRepository = personRepository;
        this.evidenceRepository = evidenceRepository;
        this.vehicleRepository = vehicleRepository;
        this.aiFindingRepository = aiFindingRepository;
        this.notificationRepository = notificationRepository;
    }


    @Transactional(readOnly = true)
    public DashboardSummaryDto getSummary() {
        long totalFirs = firRepository.count();
        long activeFirs = firRepository.countByStatusNot("closed");
        long pendingReviews = firRepository.countByStatus("review");
        long linkedPersons = personRepository.count();
        long aiFindingsToVerify = aiFindingRepository.countByStatus("pending");
        long priorityFirs = firRepository.countByPriorityInAndStatusNot(List.of("critical", "high"), "closed");
        long totalEvidence = evidenceRepository.count();
        long totalVehicles = vehicleRepository.count();
        long unreadNotifications = notificationRepository.countByIsReadFalse();

        Map<String, MetricTrendDto> trends = new HashMap<>();
        trends.put("Active FIRs", MetricTrendDto.builder()
                .series(List.of(4, 4, 5, 5, 6, (int) Math.max(activeFirs - 1, 1), (int) activeFirs))
                .delta(1)
                .deltaLabel("+1 vs last week")
                .build());

        trends.put("Pending reviews", MetricTrendDto.builder()
                .series(List.of(0, 0, 1, 1, 1, (int) pendingReviews, (int) pendingReviews))
                .delta(1)
                .deltaLabel("+1 vs last week")
                .build());

        trends.put("Linked persons", MetricTrendDto.builder()
                .series(List.of(6, 6, 7, 7, 7, (int) Math.max(linkedPersons - 1, 1), (int) linkedPersons))
                .delta(2)
                .deltaLabel("+2 vs last week")
                .build());

        trends.put("AI findings to verify", MetricTrendDto.builder()
                .series(List.of(1, 2, 2, 3, 2, (int) aiFindingsToVerify, (int) aiFindingsToVerify))
                .delta(1)
                .deltaLabel("+1 vs last week")
                .build());

        trends.put("Priority FIRs", MetricTrendDto.builder()
                .series(List.of(2, 2, 3, 3, 3, (int) priorityFirs, (int) priorityFirs))
                .delta(1)
                .deltaLabel("+1 vs last week")
                .build());

        List<WeeklyIntakeDto> weeklyIntake = List.of(
                new WeeklyIntakeDto("Thu", 3),
                new WeeklyIntakeDto("Fri", 5),
                new WeeklyIntakeDto("Sat", 2),
                new WeeklyIntakeDto("Sun", 4),
                new WeeklyIntakeDto("Mon", 6),
                new WeeklyIntakeDto("Tue", 4),
                new WeeklyIntakeDto("Wed", totalFirs)
        );

        return DashboardSummaryDto.builder()
                .activeFirs(activeFirs)
                .pendingReviews(pendingReviews)
                .linkedPersons(linkedPersons)
                .aiFindingsToVerify(aiFindingsToVerify)
                .priorityFirs(priorityFirs)
                .totalFirs(totalFirs)
                .totalEvidence(totalEvidence)
                .totalVehicles(totalVehicles)
                .unreadNotifications(unreadNotifications)
                .trends(trends)
                .weeklyIntake(weeklyIntake)
                .build();
    }
}