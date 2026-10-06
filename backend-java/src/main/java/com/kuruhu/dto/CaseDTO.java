package com.kuruhu.dto;

import java.io.Serializable;

public class CaseDTO implements Serializable {

    private String id;
    private String caseNumber;
    private String title;
    private String status;
    private String category;
    private String district;
    private String leadInvestigator;
    private String openedAt;
    private String closedAt;

    public CaseDTO() {}

    public CaseDTO(String id, String caseNumber, String title, String status, String category, String district, String leadInvestigator, String openedAt, String closedAt) {
        this.id = id;
        this.caseNumber = caseNumber;
        this.title = title;
        this.status = status;
        this.category = category;
        this.district = district;
        this.leadInvestigator = leadInvestigator;
        this.openedAt = openedAt;
        this.closedAt = closedAt;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCaseNumber() { return caseNumber; }
    public void setCaseNumber(String caseNumber) { this.caseNumber = caseNumber; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getLeadInvestigator() { return leadInvestigator; }
    public void setLeadInvestigator(String leadInvestigator) { this.leadInvestigator = leadInvestigator; }

    public String getOpenedAt() { return openedAt; }
    public void setOpenedAt(String openedAt) { this.openedAt = openedAt; }

    public String getClosedAt() { return closedAt; }
    public void setClosedAt(String closedAt) { this.closedAt = closedAt; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String caseNumber;
        private String title;
        private String status;
        private String category;
        private String district;
        private String leadInvestigator;
        private String openedAt;
        private String closedAt;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder caseNumber(String caseNumber) {
            this.caseNumber = caseNumber;
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
        public Builder category(String category) {
            this.category = category;
            return this;
        }
        public Builder district(String district) {
            this.district = district;
            return this;
        }
        public Builder leadInvestigator(String leadInvestigator) {
            this.leadInvestigator = leadInvestigator;
            return this;
        }
        public Builder openedAt(String openedAt) {
            this.openedAt = openedAt;
            return this;
        }
        public Builder closedAt(String closedAt) {
            this.closedAt = closedAt;
            return this;
        }

        public CaseDTO build() {
            return new CaseDTO(this.id, this.caseNumber, this.title, this.status, this.category, this.district, this.leadInvestigator, this.openedAt, this.closedAt);
        }
    }
}
