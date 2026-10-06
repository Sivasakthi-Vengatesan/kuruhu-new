package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "investigations")
public class Investigation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "investigationCode")
    private String investigationCode;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private String status;

    @Column(name = "officerInCharge")
    private String officerInCharge;

    @Column(name = "findingsSummary")
    private String findingsSummary;

    @Column(name = "confidenceScore")
    private Double confidenceScore;

    @Column(name = "startDate")
    private java.time.OffsetDateTime startDate;

    @Column(name = "targetCompletionDate")
    private java.time.OffsetDateTime targetCompletionDate;

    public Investigation() {
    }

    public Investigation(Long id, String investigationCode, String title, String status, String officerInCharge, String findingsSummary, Double confidenceScore, java.time.OffsetDateTime startDate, java.time.OffsetDateTime targetCompletionDate) {
        this.id = id;
        this.investigationCode = investigationCode;
        this.title = title;
        this.status = status;
        this.officerInCharge = officerInCharge;
        this.findingsSummary = findingsSummary;
        this.confidenceScore = confidenceScore;
        this.startDate = startDate;
        this.targetCompletionDate = targetCompletionDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getInvestigationCode() { return investigationCode; }
    public void setInvestigationCode(String investigationCode) { this.investigationCode = investigationCode; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getOfficerInCharge() { return officerInCharge; }
    public void setOfficerInCharge(String officerInCharge) { this.officerInCharge = officerInCharge; }

    public String getFindingsSummary() { return findingsSummary; }
    public void setFindingsSummary(String findingsSummary) { this.findingsSummary = findingsSummary; }

    public Double getConfidenceScore() { return confidenceScore; }
    public void setConfidenceScore(Double confidenceScore) { this.confidenceScore = confidenceScore; }

    public java.time.OffsetDateTime getStartDate() { return startDate; }
    public void setStartDate(java.time.OffsetDateTime startDate) { this.startDate = startDate; }

    public java.time.OffsetDateTime getTargetCompletionDate() { return targetCompletionDate; }
    public void setTargetCompletionDate(java.time.OffsetDateTime targetCompletionDate) { this.targetCompletionDate = targetCompletionDate; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String investigationCode;
        private String title;
        private String status;
        private String officerInCharge;
        private String findingsSummary;
        private Double confidenceScore;
        private java.time.OffsetDateTime startDate;
        private java.time.OffsetDateTime targetCompletionDate;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder investigationCode(String investigationCode) {
            this.investigationCode = investigationCode;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        public Builder officerInCharge(String officerInCharge) {
            this.officerInCharge = officerInCharge;
            return this;
        }
        public Builder findingsSummary(String findingsSummary) {
            this.findingsSummary = findingsSummary;
            return this;
        }
        public Builder confidenceScore(Double confidenceScore) {
            this.confidenceScore = confidenceScore;
            return this;
        }
        public Builder startDate(java.time.OffsetDateTime startDate) {
            this.startDate = startDate;
            return this;
        }
        public Builder targetCompletionDate(java.time.OffsetDateTime targetCompletionDate) {
            this.targetCompletionDate = targetCompletionDate;
            return this;
        }

        public Investigation build() {
            return new Investigation(this.id, this.investigationCode, this.title, this.status, this.officerInCharge, this.findingsSummary, this.confidenceScore, this.startDate, this.targetCompletionDate);
        }
    }
}
