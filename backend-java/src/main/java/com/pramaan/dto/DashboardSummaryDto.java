package com.pramaan.dto;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardSummaryDto {
    private long activeFirs;
    private long pendingReviews;
    private long linkedPersons;
    private long aiFindingsToVerify;
    private long priorityFirs;
    private long totalFirs;
    private long totalEvidence;
    private long totalVehicles;
    private long unreadNotifications;

    private Map<String, MetricTrendDto> trends = new HashMap<>();

    private List<WeeklyIntakeDto> weeklyIntake = new ArrayList<>();


    public DashboardSummaryDto() {
    }

    public DashboardSummaryDto(long activeFirs, long pendingReviews, long linkedPersons, long aiFindingsToVerify, long priorityFirs, long totalFirs, long totalEvidence, long totalVehicles, long unreadNotifications, Map<String, MetricTrendDto> trends, List<WeeklyIntakeDto> weeklyIntake) {
        this.activeFirs = activeFirs;
        this.pendingReviews = pendingReviews;
        this.linkedPersons = linkedPersons;
        this.aiFindingsToVerify = aiFindingsToVerify;
        this.priorityFirs = priorityFirs;
        this.totalFirs = totalFirs;
        this.totalEvidence = totalEvidence;
        this.totalVehicles = totalVehicles;
        this.unreadNotifications = unreadNotifications;
        this.trends = trends;
        this.weeklyIntake = weeklyIntake;
    }

    public long getActiveFirs() {
        return activeFirs;
    }

    public void setActiveFirs(long activeFirs) {
        this.activeFirs = activeFirs;
    }

    public long getPendingReviews() {
        return pendingReviews;
    }

    public void setPendingReviews(long pendingReviews) {
        this.pendingReviews = pendingReviews;
    }

    public long getLinkedPersons() {
        return linkedPersons;
    }

    public void setLinkedPersons(long linkedPersons) {
        this.linkedPersons = linkedPersons;
    }

    public long getAiFindingsToVerify() {
        return aiFindingsToVerify;
    }

    public void setAiFindingsToVerify(long aiFindingsToVerify) {
        this.aiFindingsToVerify = aiFindingsToVerify;
    }

    public long getPriorityFirs() {
        return priorityFirs;
    }

    public void setPriorityFirs(long priorityFirs) {
        this.priorityFirs = priorityFirs;
    }

    public long getTotalFirs() {
        return totalFirs;
    }

    public void setTotalFirs(long totalFirs) {
        this.totalFirs = totalFirs;
    }

    public long getTotalEvidence() {
        return totalEvidence;
    }

    public void setTotalEvidence(long totalEvidence) {
        this.totalEvidence = totalEvidence;
    }

    public long getTotalVehicles() {
        return totalVehicles;
    }

    public void setTotalVehicles(long totalVehicles) {
        this.totalVehicles = totalVehicles;
    }

    public long getUnreadNotifications() {
        return unreadNotifications;
    }

    public void setUnreadNotifications(long unreadNotifications) {
        this.unreadNotifications = unreadNotifications;
    }

    public Map<String, MetricTrendDto> getTrends() {
        return trends;
    }

    public void setTrends(Map<String, MetricTrendDto> trends) {
        this.trends = trends;
    }

    public List<WeeklyIntakeDto> getWeeklyIntake() {
        return weeklyIntake;
    }

    public void setWeeklyIntake(List<WeeklyIntakeDto> weeklyIntake) {
        this.weeklyIntake = weeklyIntake;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long activeFirs;
        private long pendingReviews;
        private long linkedPersons;
        private long aiFindingsToVerify;
        private long priorityFirs;
        private long totalFirs;
        private long totalEvidence;
        private long totalVehicles;
        private long unreadNotifications;
        private Map<String, MetricTrendDto> trends;
        private List<WeeklyIntakeDto> weeklyIntake;

        public Builder activeFirs(long activeFirs) {
            this.activeFirs = activeFirs;
            return this;
        }
        public Builder pendingReviews(long pendingReviews) {
            this.pendingReviews = pendingReviews;
            return this;
        }
        public Builder linkedPersons(long linkedPersons) {
            this.linkedPersons = linkedPersons;
            return this;
        }
        public Builder aiFindingsToVerify(long aiFindingsToVerify) {
            this.aiFindingsToVerify = aiFindingsToVerify;
            return this;
        }
        public Builder priorityFirs(long priorityFirs) {
            this.priorityFirs = priorityFirs;
            return this;
        }
        public Builder totalFirs(long totalFirs) {
            this.totalFirs = totalFirs;
            return this;
        }
        public Builder totalEvidence(long totalEvidence) {
            this.totalEvidence = totalEvidence;
            return this;
        }
        public Builder totalVehicles(long totalVehicles) {
            this.totalVehicles = totalVehicles;
            return this;
        }
        public Builder unreadNotifications(long unreadNotifications) {
            this.unreadNotifications = unreadNotifications;
            return this;
        }
        public Builder trends(Map<String, MetricTrendDto> trends) {
            this.trends = trends;
            return this;
        }
        public Builder weeklyIntake(List<WeeklyIntakeDto> weeklyIntake) {
            this.weeklyIntake = weeklyIntake;
            return this;
        }

        public DashboardSummaryDto build() {
            return new DashboardSummaryDto(this.activeFirs, this.pendingReviews, this.linkedPersons, this.aiFindingsToVerify, this.priorityFirs, this.totalFirs, this.totalEvidence, this.totalVehicles, this.unreadNotifications, this.trends, this.weeklyIntake);
        }
    }
}