package com.kuruhu.dto;

import java.io.Serializable;

public class UpdateFIRRequest implements Serializable {

    private String title;
    private String summary;
    private String status;
    private String priority;
    private String officer;
    private java.util.List<String> sections;

    public UpdateFIRRequest() {}

    public UpdateFIRRequest(String title, String summary, String status, String priority, String officer, java.util.List<String> sections) {
        this.title = title;
        this.summary = summary;
        this.status = status;
        this.priority = priority;
        this.officer = officer;
        this.sections = sections;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getOfficer() { return officer; }
    public void setOfficer(String officer) { this.officer = officer; }

    public java.util.List<String> getSections() { return sections; }
    public void setSections(java.util.List<String> sections) { this.sections = sections; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String title;
        private String summary;
        private String status;
        private String priority;
        private String officer;
        private java.util.List<String> sections;

        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder summary(String summary) {
            this.summary = summary;
            return this;
        }
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        public Builder priority(String priority) {
            this.priority = priority;
            return this;
        }
        public Builder officer(String officer) {
            this.officer = officer;
            return this;
        }
        public Builder sections(java.util.List<String> sections) {
            this.sections = sections;
            return this;
        }

        public UpdateFIRRequest build() {
            return new UpdateFIRRequest(this.title, this.summary, this.status, this.priority, this.officer, this.sections);
        }
    }
}
