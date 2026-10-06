package com.kuruhu.dto;

import java.io.Serializable;

public class EarlyWarningDTO implements Serializable {

    private String id;
    private String warningCode;
    private String title;
    private String threatLevel;
    private String targetedLocation;
    private String analysisSummary;
    private Double probability;

    public EarlyWarningDTO() {}

    public EarlyWarningDTO(String id, String warningCode, String title, String threatLevel, String targetedLocation, String analysisSummary, Double probability) {
        this.id = id;
        this.warningCode = warningCode;
        this.title = title;
        this.threatLevel = threatLevel;
        this.targetedLocation = targetedLocation;
        this.analysisSummary = analysisSummary;
        this.probability = probability;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getWarningCode() { return warningCode; }
    public void setWarningCode(String warningCode) { this.warningCode = warningCode; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getThreatLevel() { return threatLevel; }
    public void setThreatLevel(String threatLevel) { this.threatLevel = threatLevel; }

    public String getTargetedLocation() { return targetedLocation; }
    public void setTargetedLocation(String targetedLocation) { this.targetedLocation = targetedLocation; }

    public String getAnalysisSummary() { return analysisSummary; }
    public void setAnalysisSummary(String analysisSummary) { this.analysisSummary = analysisSummary; }

    public Double getProbability() { return probability; }
    public void setProbability(Double probability) { this.probability = probability; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String warningCode;
        private String title;
        private String threatLevel;
        private String targetedLocation;
        private String analysisSummary;
        private Double probability;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder warningCode(String warningCode) {
            this.warningCode = warningCode;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder threatLevel(String threatLevel) {
            this.threatLevel = threatLevel;
            return this;
        }
        public Builder targetedLocation(String targetedLocation) {
            this.targetedLocation = targetedLocation;
            return this;
        }
        public Builder analysisSummary(String analysisSummary) {
            this.analysisSummary = analysisSummary;
            return this;
        }
        public Builder probability(Double probability) {
            this.probability = probability;
            return this;
        }

        public EarlyWarningDTO build() {
            return new EarlyWarningDTO(this.id, this.warningCode, this.title, this.threatLevel, this.targetedLocation, this.analysisSummary, this.probability);
        }
    }
}
