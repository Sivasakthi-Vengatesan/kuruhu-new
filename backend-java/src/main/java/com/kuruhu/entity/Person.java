package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "persons")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "personCode")
    private String personCode;

    @Column(name = "canonicalName")
    private String canonicalName;

    @Column(name = "ageYears")
    private Integer ageYears;

    @Column(name = "gender")
    private String gender;

    @Column(name = "primaryRole")
    private String primaryRole;

    @Column(name = "riskLevel")
    private String riskLevel;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "identifierRef")
    private String identifierRef;

    @Column(name = "behavioralProfile")
    private String behavioralProfile;

    @Column(name = "lastActivity")
    private java.time.OffsetDateTime lastActivity;

    public Person() {
    }

    public Person(Long id, String personCode, String canonicalName, Integer ageYears, String gender, String primaryRole, String riskLevel, String phone, String address, String identifierRef, String behavioralProfile, java.time.OffsetDateTime lastActivity) {
        this.id = id;
        this.personCode = personCode;
        this.canonicalName = canonicalName;
        this.ageYears = ageYears;
        this.gender = gender;
        this.primaryRole = primaryRole;
        this.riskLevel = riskLevel;
        this.phone = phone;
        this.address = address;
        this.identifierRef = identifierRef;
        this.behavioralProfile = behavioralProfile;
        this.lastActivity = lastActivity;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPersonCode() { return personCode; }
    public void setPersonCode(String personCode) { this.personCode = personCode; }

    public String getCanonicalName() { return canonicalName; }
    public void setCanonicalName(String canonicalName) { this.canonicalName = canonicalName; }

    public Integer getAgeYears() { return ageYears; }
    public void setAgeYears(Integer ageYears) { this.ageYears = ageYears; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPrimaryRole() { return primaryRole; }
    public void setPrimaryRole(String primaryRole) { this.primaryRole = primaryRole; }

    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getIdentifierRef() { return identifierRef; }
    public void setIdentifierRef(String identifierRef) { this.identifierRef = identifierRef; }

    public String getBehavioralProfile() { return behavioralProfile; }
    public void setBehavioralProfile(String behavioralProfile) { this.behavioralProfile = behavioralProfile; }

    public java.time.OffsetDateTime getLastActivity() { return lastActivity; }
    public void setLastActivity(java.time.OffsetDateTime lastActivity) { this.lastActivity = lastActivity; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String personCode;
        private String canonicalName;
        private Integer ageYears;
        private String gender;
        private String primaryRole;
        private String riskLevel;
        private String phone;
        private String address;
        private String identifierRef;
        private String behavioralProfile;
        private java.time.OffsetDateTime lastActivity;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder personCode(String personCode) {
            this.personCode = personCode;
            return this;
        }
        public Builder canonicalName(String canonicalName) {
            this.canonicalName = canonicalName;
            return this;
        }
        public Builder ageYears(Integer ageYears) {
            this.ageYears = ageYears;
            return this;
        }
        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }
        public Builder primaryRole(String primaryRole) {
            this.primaryRole = primaryRole;
            return this;
        }
        public Builder riskLevel(String riskLevel) {
            this.riskLevel = riskLevel;
            return this;
        }
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public Builder address(String address) {
            this.address = address;
            return this;
        }
        public Builder identifierRef(String identifierRef) {
            this.identifierRef = identifierRef;
            return this;
        }
        public Builder behavioralProfile(String behavioralProfile) {
            this.behavioralProfile = behavioralProfile;
            return this;
        }
        public Builder lastActivity(java.time.OffsetDateTime lastActivity) {
            this.lastActivity = lastActivity;
            return this;
        }

        public Person build() {
            return new Person(this.id, this.personCode, this.canonicalName, this.ageYears, this.gender, this.primaryRole, this.riskLevel, this.phone, this.address, this.identifierRef, this.behavioralProfile, this.lastActivity);
        }
    }
}
