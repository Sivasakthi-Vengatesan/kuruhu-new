package com.kuruhu.dto;

import java.io.Serializable;

public class FIRDTO implements Serializable {

    private String id;
    private String number;
    private String title;
    private String summary;
    private String station;
    private String district;
    private String officer;
    private String priority;
    private String status;
    private java.util.List<String> sections;
    private String registeredAt;
    private String updatedAt;
    private java.util.List<String> personIds;
    private java.util.List<String> evidenceIds;
    private java.util.List<String> vehicleIds;

    public FIRDTO() {}

    public FIRDTO(String id, String number, String title, String summary, String station, String district, String officer, String priority, String status, java.util.List<String> sections, String registeredAt, String updatedAt, java.util.List<String> personIds, java.util.List<String> evidenceIds, java.util.List<String> vehicleIds) {
        this.id = id;
        this.number = number;
        this.title = title;
        this.summary = summary;
        this.station = station;
        this.district = district;
        this.officer = officer;
        this.priority = priority;
        this.status = status;
        this.sections = sections;
        this.registeredAt = registeredAt;
        this.updatedAt = updatedAt;
        this.personIds = personIds;
        this.evidenceIds = evidenceIds;
        this.vehicleIds = vehicleIds;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

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

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public java.util.List<String> getSections() { return sections; }
    public void setSections(java.util.List<String> sections) { this.sections = sections; }

    public String getRegisteredAt() { return registeredAt; }
    public void setRegisteredAt(String registeredAt) { this.registeredAt = registeredAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }

    public java.util.List<String> getPersonIds() { return personIds; }
    public void setPersonIds(java.util.List<String> personIds) { this.personIds = personIds; }

    public java.util.List<String> getEvidenceIds() { return evidenceIds; }
    public void setEvidenceIds(java.util.List<String> evidenceIds) { this.evidenceIds = evidenceIds; }

    public java.util.List<String> getVehicleIds() { return vehicleIds; }
    public void setVehicleIds(java.util.List<String> vehicleIds) { this.vehicleIds = vehicleIds; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String number;
        private String title;
        private String summary;
        private String station;
        private String district;
        private String officer;
        private String priority;
        private String status;
        private java.util.List<String> sections;
        private String registeredAt;
        private String updatedAt;
        private java.util.List<String> personIds;
        private java.util.List<String> evidenceIds;
        private java.util.List<String> vehicleIds;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder number(String number) {
            this.number = number;
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
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        public Builder sections(java.util.List<String> sections) {
            this.sections = sections;
            return this;
        }
        public Builder registeredAt(String registeredAt) {
            this.registeredAt = registeredAt;
            return this;
        }
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }
        public Builder personIds(java.util.List<String> personIds) {
            this.personIds = personIds;
            return this;
        }
        public Builder evidenceIds(java.util.List<String> evidenceIds) {
            this.evidenceIds = evidenceIds;
            return this;
        }
        public Builder vehicleIds(java.util.List<String> vehicleIds) {
            this.vehicleIds = vehicleIds;
            return this;
        }

        public FIRDTO build() {
            return new FIRDTO(this.id, this.number, this.title, this.summary, this.station, this.district, this.officer, this.priority, this.status, this.sections, this.registeredAt, this.updatedAt, this.personIds, this.evidenceIds, this.vehicleIds);
        }
    }
}
