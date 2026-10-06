package com.kuruhu.dto;

import java.io.Serializable;

public class DashboardDTO implements Serializable {

    private long totalFIRs;
    private long activeCases;
    private long totalPersons;
    private long evidenceCount;
    private long criticalHotspots;
    private java.util.Map<String, Long> firsByCategory;
    private java.util.List<Object> recentActivities;

    public DashboardDTO() {}

    public DashboardDTO(long totalFIRs, long activeCases, long totalPersons, long evidenceCount, long criticalHotspots, java.util.Map<String, Long> firsByCategory, java.util.List<Object> recentActivities) {
        this.totalFIRs = totalFIRs;
        this.activeCases = activeCases;
        this.totalPersons = totalPersons;
        this.evidenceCount = evidenceCount;
        this.criticalHotspots = criticalHotspots;
        this.firsByCategory = firsByCategory;
        this.recentActivities = recentActivities;
    }

    public long getTotalFIRs() { return totalFIRs; }
    public void setTotalFIRs(long totalFIRs) { this.totalFIRs = totalFIRs; }

    public long getActiveCases() { return activeCases; }
    public void setActiveCases(long activeCases) { this.activeCases = activeCases; }

    public long getTotalPersons() { return totalPersons; }
    public void setTotalPersons(long totalPersons) { this.totalPersons = totalPersons; }

    public long getEvidenceCount() { return evidenceCount; }
    public void setEvidenceCount(long evidenceCount) { this.evidenceCount = evidenceCount; }

    public long getCriticalHotspots() { return criticalHotspots; }
    public void setCriticalHotspots(long criticalHotspots) { this.criticalHotspots = criticalHotspots; }

    public java.util.Map<String, Long> getFirsByCategory() { return firsByCategory; }
    public void setFirsByCategory(java.util.Map<String, Long> firsByCategory) { this.firsByCategory = firsByCategory; }

    public java.util.List<Object> getRecentActivities() { return recentActivities; }
    public void setRecentActivities(java.util.List<Object> recentActivities) { this.recentActivities = recentActivities; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long totalFIRs;
        private long activeCases;
        private long totalPersons;
        private long evidenceCount;
        private long criticalHotspots;
        private java.util.Map<String, Long> firsByCategory;
        private java.util.List<Object> recentActivities;

        public Builder totalFIRs(long totalFIRs) {
            this.totalFIRs = totalFIRs;
            return this;
        }
        public Builder activeCases(long activeCases) {
            this.activeCases = activeCases;
            return this;
        }
        public Builder totalPersons(long totalPersons) {
            this.totalPersons = totalPersons;
            return this;
        }
        public Builder evidenceCount(long evidenceCount) {
            this.evidenceCount = evidenceCount;
            return this;
        }
        public Builder criticalHotspots(long criticalHotspots) {
            this.criticalHotspots = criticalHotspots;
            return this;
        }
        public Builder firsByCategory(java.util.Map<String, Long> firsByCategory) {
            this.firsByCategory = firsByCategory;
            return this;
        }
        public Builder recentActivities(java.util.List<Object> recentActivities) {
            this.recentActivities = recentActivities;
            return this;
        }

        public DashboardDTO build() {
            return new DashboardDTO(this.totalFIRs, this.activeCases, this.totalPersons, this.evidenceCount, this.criticalHotspots, this.firsByCategory, this.recentActivities);
        }
    }
}
