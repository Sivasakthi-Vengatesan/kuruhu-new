package com.kuruhu.dto;

import java.io.Serializable;

public class CreateFIRRequest implements Serializable {

    private String crimeNumber;
    private String title;
    private String summary;
    private String station;
    private String district;
    private String officer;
    private String priority;
    private java.util.List<String> sections;
    private String complainantName;
    private String complainantPhone;
    private String complainantAddress;

    public CreateFIRRequest() {}

    public CreateFIRRequest(String crimeNumber, String title, String summary, String station, String district, String officer, String priority, java.util.List<String> sections, String complainantName, String complainantPhone, String complainantAddress) {
        this.crimeNumber = crimeNumber;
        this.title = title;
        this.summary = summary;
        this.station = station;
        this.district = district;
        this.officer = officer;
        this.priority = priority;
        this.sections = sections;
        this.complainantName = complainantName;
        this.complainantPhone = complainantPhone;
        this.complainantAddress = complainantAddress;
    }

    public String getCrimeNumber() { return crimeNumber; }
    public void setCrimeNumber(String crimeNumber) { this.crimeNumber = crimeNumber; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public String getStation() { return station; }
    public void setStation(String station) { this.station = station; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getOfficer() { return officer; }
    public void setOfficer(String officer) { this.officer = officer; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public java.util.List<String> getSections() { return sections; }
    public void setSections(java.util.List<String> sections) { this.sections = sections; }

    public String getComplainantName() { return complainantName; }
    public void setComplainantName(String complainantName) { this.complainantName = complainantName; }

    public String getComplainantPhone() { return complainantPhone; }
    public void setComplainantPhone(String complainantPhone) { this.complainantPhone = complainantPhone; }

    public String getComplainantAddress() { return complainantAddress; }
    public void setComplainantAddress(String complainantAddress) { this.complainantAddress = complainantAddress; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String crimeNumber;
        private String title;
        private String summary;
        private String station;
        private String district;
        private String officer;
        private String priority;
        private java.util.List<String> sections;
        private String complainantName;
        private String complainantPhone;
        private String complainantAddress;

        public Builder crimeNumber(String crimeNumber) {
            this.crimeNumber = crimeNumber;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder summary(String summary) {
            this.summary = summary;
            return this;
        }
        public Builder station(String station) {
            this.station = station;
            return this;
        }
        public Builder district(String district) {
            this.district = district;
            return this;
        }
        public Builder officer(String officer) {
            this.officer = officer;
            return this;
        }
        public Builder priority(String priority) {
            this.priority = priority;
            return this;
        }
        public Builder sections(java.util.List<String> sections) {
            this.sections = sections;
            return this;
        }
        public Builder complainantName(String complainantName) {
            this.complainantName = complainantName;
            return this;
        }
        public Builder complainantPhone(String complainantPhone) {
            this.complainantPhone = complainantPhone;
            return this;
        }
        public Builder complainantAddress(String complainantAddress) {
            this.complainantAddress = complainantAddress;
            return this;
        }

        public CreateFIRRequest build() {
            return new CreateFIRRequest(this.crimeNumber, this.title, this.summary, this.station, this.district, this.officer, this.priority, this.sections, this.complainantName, this.complainantPhone, this.complainantAddress);
        }
    }
}
