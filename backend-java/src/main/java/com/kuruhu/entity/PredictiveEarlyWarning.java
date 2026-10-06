package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "predictiveearlywarnings")
public class PredictiveEarlyWarning implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "warningCode")
    private String warningCode;

    @Column(name = "title")
    private String title;

    @Column(name = "threatLevel")
    private String threatLevel;

    @Column(name = "targetedLocation")
    private String targetedLocation;

    @Column(name = "analysisSummary")
    private String analysisSummary;

    @Column(name = "probability")
    private Double probability;

    @Column(name = "generatedAt")
    private java.time.OffsetDateTime generatedAt;

    public PredictiveEarlyWarning() {
    }

    public PredictiveEarlyWarning(Long id, String warningCode, String title, String threatLevel, String targetedLocation, String analysisSummary, Double probability, java.time.OffsetDateTime generatedAt) {
        this.id = id;
        this.warningCode = warningCode;
        this.title = title;
        this.threatLevel = threatLevel;
        this.targetedLocation = targetedLocation;
        this.analysisSummary = analysisSummary;
        this.probability = probability;
        this.generatedAt = generatedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public java.time.OffsetDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(java.time.OffsetDateTime generatedAt) { this.generatedAt = generatedAt; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String warningCode;
        private String title;
        private String threatLevel;
        private String targetedLocation;
        private String analysisSummary;
        private Double probability;
        private java.time.OffsetDateTime generatedAt;

        public Builder id(Long id) {
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
        public Builder generatedAt(java.time.OffsetDateTime generatedAt) {
            this.generatedAt = generatedAt;
            return this;
        }

        public PredictiveEarlyWarning build() {
            return new PredictiveEarlyWarning(this.id, this.warningCode, this.title, this.threatLevel, this.targetedLocation, this.analysisSummary, this.probability, this.generatedAt);
        }
    }
}
