package com.kuruhu.dto;

import java.io.Serializable;

public class InvestigationDTO implements Serializable {

    private String id;
    private String investigationCode;
    private String title;
    private String status;
    private String officerInCharge;
    private String findingsSummary;
    private Double confidenceScore;
    private String startDate;

    public InvestigationDTO() {}

    public InvestigationDTO(String id, String investigationCode, String title, String status, String officerInCharge, String findingsSummary, Double confidenceScore, String startDate) {
        this.id = id;
        this.investigationCode = investigationCode;
        this.title = title;
        this.status = status;
        this.officerInCharge = officerInCharge;
        this.findingsSummary = findingsSummary;
        this.confidenceScore = confidenceScore;
        this.startDate = startDate;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

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

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String investigationCode;
        private String title;
        private String status;
        private String officerInCharge;
        private String findingsSummary;
        private Double confidenceScore;
        private String startDate;

        public Builder id(String id) {
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
        public Builder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public InvestigationDTO build() {
            return new InvestigationDTO(this.id, this.investigationCode, this.title, this.status, this.officerInCharge, this.findingsSummary, this.confidenceScore, this.startDate);
        }
    }
}
