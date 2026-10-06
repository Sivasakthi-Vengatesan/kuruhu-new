package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cases")
public class Case implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "caseNumber")
    private String caseNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private String status;

    @Column(name = "category")
    private String category;

    @Column(name = "district")
    private String district;

    @Column(name = "leadInvestigator")
    private String leadInvestigator;

    @Column(name = "openedAt")
    private java.time.OffsetDateTime openedAt;

    @Column(name = "closedAt")
    private java.time.OffsetDateTime closedAt;

    public Case() {
    }

    public Case(Long id, String caseNumber, String title, String status, String category, String district, String leadInvestigator, java.time.OffsetDateTime openedAt, java.time.OffsetDateTime closedAt) {
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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public java.time.OffsetDateTime getOpenedAt() { return openedAt; }
    public void setOpenedAt(java.time.OffsetDateTime openedAt) { this.openedAt = openedAt; }

    public java.time.OffsetDateTime getClosedAt() { return closedAt; }
    public void setClosedAt(java.time.OffsetDateTime closedAt) { this.closedAt = closedAt; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String caseNumber;
        private String title;
        private String status;
        private String category;
        private String district;
        private String leadInvestigator;
        private java.time.OffsetDateTime openedAt;
        private java.time.OffsetDateTime closedAt;

        public Builder id(Long id) {
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
        public Builder openedAt(java.time.OffsetDateTime openedAt) {
            this.openedAt = openedAt;
            return this;
        }
        public Builder closedAt(java.time.OffsetDateTime closedAt) {
            this.closedAt = closedAt;
            return this;
        }

        public Case build() {
            return new Case(this.id, this.caseNumber, this.title, this.status, this.category, this.district, this.leadInvestigator, this.openedAt, this.closedAt);
        }
    }
}
