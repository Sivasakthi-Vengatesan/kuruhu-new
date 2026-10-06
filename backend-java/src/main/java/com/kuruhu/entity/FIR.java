package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "firs")
public class FIR implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firNumber")
    private String firNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "summary")
    private String summary;

    @Column(name = "stationName")
    private String stationName;

    @Column(name = "district")
    private String district;

    @Column(name = "investigatingOfficer")
    private String investigatingOfficer;

    @Column(name = "priority")
    private String priority;

    @Column(name = "status")
    private String status;

    @Column(name = "sections")
    private String sections;

    @Column(name = "incidentDate")
    private java.time.OffsetDateTime incidentDate;

    @Column(name = "registeredAt")
    private java.time.OffsetDateTime registeredAt;

    @Column(name = "updatedAt")
    private java.time.OffsetDateTime updatedAt;

    @Column(name = "sourceCaseMasterId")
    private Long sourceCaseMasterId;

    public FIR() {
    }

    public FIR(Long id, String firNumber, String title, String summary, String stationName, String district, String investigatingOfficer, String priority, String status, String sections, java.time.OffsetDateTime incidentDate, java.time.OffsetDateTime registeredAt, java.time.OffsetDateTime updatedAt, Long sourceCaseMasterId) {
        this.id = id;
        this.firNumber = firNumber;
        this.title = title;
        this.summary = summary;
        this.stationName = stationName;
        this.district = district;
        this.investigatingOfficer = investigatingOfficer;
        this.priority = priority;
        this.status = status;
        this.sections = sections;
        this.incidentDate = incidentDate;
        this.registeredAt = registeredAt;
        this.updatedAt = updatedAt;
        this.sourceCaseMasterId = sourceCaseMasterId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirNumber() { return firNumber; }
    public void setFirNumber(String firNumber) { this.firNumber = firNumber; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public String getStationName() { return stationName; }
    public void setStationName(String stationName) { this.stationName = stationName; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getInvestigatingOfficer() { return investigatingOfficer; }
    public void setInvestigatingOfficer(String investigatingOfficer) { this.investigatingOfficer = investigatingOfficer; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getSections() { return sections; }
    public void setSections(String sections) { this.sections = sections; }

    public java.time.OffsetDateTime getIncidentDate() { return incidentDate; }
    public void setIncidentDate(java.time.OffsetDateTime incidentDate) { this.incidentDate = incidentDate; }

    public java.time.OffsetDateTime getRegisteredAt() { return registeredAt; }
    public void setRegisteredAt(java.time.OffsetDateTime registeredAt) { this.registeredAt = registeredAt; }

    public java.time.OffsetDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(java.time.OffsetDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Long getSourceCaseMasterId() { return sourceCaseMasterId; }
    public void setSourceCaseMasterId(Long sourceCaseMasterId) { this.sourceCaseMasterId = sourceCaseMasterId; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String firNumber;
        private String title;
        private String summary;
        private String stationName;
        private String district;
        private String investigatingOfficer;
        private String priority;
        private String status;
        private String sections;
        private java.time.OffsetDateTime incidentDate;
        private java.time.OffsetDateTime registeredAt;
        private java.time.OffsetDateTime updatedAt;
        private Long sourceCaseMasterId;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder firNumber(String firNumber) {
            this.firNumber = firNumber;
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
        public Builder stationName(String stationName) {
            this.stationName = stationName;
            return this;
        }
        public Builder district(String district) {
            this.district = district;
            return this;
        }
        public Builder investigatingOfficer(String investigatingOfficer) {
            this.investigatingOfficer = investigatingOfficer;
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
        public Builder sections(String sections) {
            this.sections = sections;
            return this;
        }
        public Builder incidentDate(java.time.OffsetDateTime incidentDate) {
            this.incidentDate = incidentDate;
            return this;
        }
        public Builder registeredAt(java.time.OffsetDateTime registeredAt) {
            this.registeredAt = registeredAt;
            return this;
        }
        public Builder updatedAt(java.time.OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }
        public Builder sourceCaseMasterId(Long sourceCaseMasterId) {
            this.sourceCaseMasterId = sourceCaseMasterId;
            return this;
        }

        public FIR build() {
            return new FIR(this.id, this.firNumber, this.title, this.summary, this.stationName, this.district, this.investigatingOfficer, this.priority, this.status, this.sections, this.incidentDate, this.registeredAt, this.updatedAt, this.sourceCaseMasterId);
        }
    }
}
