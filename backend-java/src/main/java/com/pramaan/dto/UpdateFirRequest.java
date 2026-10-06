package com.pramaan.dto;


import java.util.List;

public class UpdateFirRequest {
    private String title;
    private String summary;
    private String priority;
    private String status;
    private List<String> sections;
    private String investigatingOfficer;
    private String district;
    private String stationName;


    public UpdateFirRequest() {
    }

    public UpdateFirRequest(String title, String summary, String priority, String status, List<String> sections, String investigatingOfficer, String district, String stationName) {
        this.title = title;
        this.summary = summary;
        this.priority = priority;
        this.status = status;
        this.sections = sections;
        this.investigatingOfficer = investigatingOfficer;
        this.district = district;
        this.stationName = stationName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getSections() {
        return sections;
    }

    public void setSections(List<String> sections) {
        this.sections = sections;
    }

    public String getInvestigatingOfficer() {
        return investigatingOfficer;
    }

    public void setInvestigatingOfficer(String investigatingOfficer) {
        this.investigatingOfficer = investigatingOfficer;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String title;
        private String summary;
        private String priority;
        private String status;
        private List<String> sections;
        private String investigatingOfficer;
        private String district;
        private String stationName;

        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder summary(String summary) {
            this.summary = summary;
            return this;
        }
        public Builder priority(String priority) {
            this.priority = priority;
            return this;
        }
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        public Builder sections(List<String> sections) {
            this.sections = sections;
            return this;
        }
        public Builder investigatingOfficer(String investigatingOfficer) {
            this.investigatingOfficer = investigatingOfficer;
            return this;
        }
        public Builder district(String district) {
            this.district = district;
            return this;
        }
        public Builder stationName(String stationName) {
            this.stationName = stationName;
            return this;
        }

        public UpdateFirRequest build() {
            return new UpdateFirRequest(this.title, this.summary, this.priority, this.status, this.sections, this.investigatingOfficer, this.district, this.stationName);
        }
    }
}