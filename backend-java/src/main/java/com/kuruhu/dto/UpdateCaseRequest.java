package com.kuruhu.dto;

import java.io.Serializable;

public class UpdateCaseRequest implements Serializable {

    private String title;
    private String status;
    private String category;
    private String leadInvestigator;

    public UpdateCaseRequest() {}

    public UpdateCaseRequest(String title, String status, String category, String leadInvestigator) {
        this.title = title;
        this.status = status;
        this.category = category;
        this.leadInvestigator = leadInvestigator;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getLeadInvestigator() { return leadInvestigator; }
    public void setLeadInvestigator(String leadInvestigator) { this.leadInvestigator = leadInvestigator; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String title;
        private String status;
        private String category;
        private String leadInvestigator;

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
        public Builder leadInvestigator(String leadInvestigator) {
            this.leadInvestigator = leadInvestigator;
            return this;
        }

        public UpdateCaseRequest build() {
            return new UpdateCaseRequest(this.title, this.status, this.category, this.leadInvestigator);
        }
    }
}
