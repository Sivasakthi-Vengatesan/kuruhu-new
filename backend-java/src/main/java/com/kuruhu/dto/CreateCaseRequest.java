package com.kuruhu.dto;

import java.io.Serializable;

public class CreateCaseRequest implements Serializable {

    private String caseNumber;
    private String title;
    private String category;
    private String district;
    private String leadInvestigator;

    public CreateCaseRequest() {}

    public CreateCaseRequest(String caseNumber, String title, String category, String district, String leadInvestigator) {
        this.caseNumber = caseNumber;
        this.title = title;
        this.category = category;
        this.district = district;
        this.leadInvestigator = leadInvestigator;
    }

    public String getCaseNumber() { return caseNumber; }
    public void setCaseNumber(String caseNumber) { this.caseNumber = caseNumber; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getLeadInvestigator() { return leadInvestigator; }
    public void setLeadInvestigator(String leadInvestigator) { this.leadInvestigator = leadInvestigator; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String caseNumber;
        private String title;
        private String category;
        private String district;
        private String leadInvestigator;

        public Builder caseNumber(String caseNumber) {
            this.caseNumber = caseNumber;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
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

        public CreateCaseRequest build() {
            return new CreateCaseRequest(this.caseNumber, this.title, this.category, this.district, this.leadInvestigator);
        }
    }
}
