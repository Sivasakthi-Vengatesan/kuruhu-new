package com.pramaan.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "person_code", unique = true, length = 50)
    private String personCode;

    @Column(name = "canonical_name", nullable = false, length = 150)
    private String canonicalName;

    @Column(name = "age_years")
    private Integer ageYears;

    @Column(length = 10)
    private String gender = "M"; // M, F, T, O, U

    @Column(name = "primary_role", length = 50)
    private String primaryRole = "suspect"; // accused, suspect, complainant, witness, victim

    @Column(name = "risk_level", length = 50)
    private String riskLevel = "medium"; // high, medium, low

    @Column(length = 50)
    private String phone;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Column(name = "identifier_ref", length = 100)
    private String identifierRef;

    @Column(name = "known_locations", columnDefinition = "JSONB")
    private String knownLocations;

    @Column(name = "socio_demographics", columnDefinition = "JSONB")
    private String socioDemographics;

    @Column(name = "behavioral_profile", columnDefinition = "JSONB")
    private String behavioralProfile;

    @Column(name = "last_activity")
    private OffsetDateTime lastActivity;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PersonAlias> aliases = new ArrayList<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<CaseParty> caseParties = new HashSet<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<PersonRelationship> relationships = new HashSet<>();


    public Person() {
    }

    public Person(Long id, String personCode, String canonicalName, Integer ageYears, String gender, String primaryRole, String riskLevel, String phone, String address, String identifierRef, String knownLocations, String socioDemographics, String behavioralProfile, OffsetDateTime lastActivity, OffsetDateTime createdAt, OffsetDateTime updatedAt, List<PersonAlias> aliases, Set<CaseParty> caseParties, Set<PersonRelationship> relationships) {
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
        this.knownLocations = knownLocations;
        this.socioDemographics = socioDemographics;
        this.behavioralProfile = behavioralProfile;
        this.lastActivity = lastActivity;
        this.createdAt = createdAt;
        this.aliases = aliases != null ? aliases : new ArrayList<>();
        this.caseParties = caseParties != null ? caseParties : new HashSet<>();
        this.relationships = relationships != null ? relationships : new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public String getCanonicalName() {
        return canonicalName;
    }

    public void setCanonicalName(String canonicalName) {
        this.canonicalName = canonicalName;
    }

    public Integer getAgeYears() {
        return ageYears;
    }

    public void setAgeYears(Integer ageYears) {
        this.ageYears = ageYears;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPrimaryRole() {
        return primaryRole;
    }

    public void setPrimaryRole(String primaryRole) {
        this.primaryRole = primaryRole;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentifierRef() {
        return identifierRef;
    }

    public void setIdentifierRef(String identifierRef) {
        this.identifierRef = identifierRef;
    }

    public String getKnownLocations() {
        return knownLocations;
    }

    public void setKnownLocations(String knownLocations) {
        this.knownLocations = knownLocations;
    }

    public String getSocioDemographics() {
        return socioDemographics;
    }

    public void setSocioDemographics(String socioDemographics) {
        this.socioDemographics = socioDemographics;
    }

    public String getBehavioralProfile() {
        return behavioralProfile;
    }

    public void setBehavioralProfile(String behavioralProfile) {
        this.behavioralProfile = behavioralProfile;
    }

    public OffsetDateTime getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(OffsetDateTime lastActivity) {
        this.lastActivity = lastActivity;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<PersonAlias> getAliases() {
        return aliases;
    }

    public void setAliases(List<PersonAlias> aliases) {
        this.aliases = aliases;
    }

    public Set<CaseParty> getCaseParties() {
        return caseParties;
    }

    public void setCaseParties(Set<CaseParty> caseParties) {
        this.caseParties = caseParties;
    }

    public Set<PersonRelationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(Set<PersonRelationship> relationships) {
        this.relationships = relationships;
    }

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
        private String knownLocations;
        private String socioDemographics;
        private String behavioralProfile;
        private OffsetDateTime lastActivity;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;
        private List<PersonAlias> aliases;
        private Set<CaseParty> caseParties;
        private Set<PersonRelationship> relationships;

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
        public Builder knownLocations(String knownLocations) {
            this.knownLocations = knownLocations;
            return this;
        }
        public Builder socioDemographics(String socioDemographics) {
            this.socioDemographics = socioDemographics;
            return this;
        }
        public Builder behavioralProfile(String behavioralProfile) {
            this.behavioralProfile = behavioralProfile;
            return this;
        }
        public Builder lastActivity(OffsetDateTime lastActivity) {
            this.lastActivity = lastActivity;
            return this;
        }
        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        public Builder updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }
        public Builder aliases(List<PersonAlias> aliases) {
            this.aliases = aliases;
            return this;
        }
        public Builder caseParties(Set<CaseParty> caseParties) {
            this.caseParties = caseParties;
            return this;
        }
        public Builder relationships(Set<PersonRelationship> relationships) {
            this.relationships = relationships;
            return this;
        }

        public Person build() {
            return new Person(this.id, this.personCode, this.canonicalName, this.ageYears, this.gender, this.primaryRole, this.riskLevel, this.phone, this.address, this.identifierRef, this.knownLocations, this.socioDemographics, this.behavioralProfile, this.lastActivity, this.createdAt, this.updatedAt, this.aliases, this.caseParties, this.relationships);
        }
    }
}