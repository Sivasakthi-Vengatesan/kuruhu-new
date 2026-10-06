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
@Table(name = "firs")
public class Fir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fir_number", unique = true, nullable = false, length = 100)
    private String firNumber;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String summary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "police_station_id")
    private PoliceStation policeStation;

    @Column(name = "station_name", nullable = false, length = 150)
    private String stationName;

    @Column(nullable = false, length = 100)
    private String district;

    @Column(name = "investigating_officer", nullable = false, length = 150)
    private String investigatingOfficer;

    @Column(nullable = false, length = 50)
    private String priority = "medium"; // critical, high, medium, low

    @Column(nullable = false, length = 50)
    private String status = "registered"; // draft, registered, investigating, review, closed

    @Column(columnDefinition = "JSONB")
    private String sections; // JSON array of section strings e.g. ["IPC 379", "IPC 420"]

    @Column(name = "incident_date")
    private OffsetDateTime incidentDate;

    @CreationTimestamp
    @Column(name = "registered_at", updatable = false)
    private OffsetDateTime registeredAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @Column(name = "source_case_master_id")
    private Long sourceCaseMasterId;

    @Column(name = "source_payload", columnDefinition = "JSONB")
    private String sourcePayload;

    @OneToMany(mappedBy = "fir", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<FirTimeline> timeline = new ArrayList<>();

    @OneToMany(mappedBy = "fir", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<CaseParty> caseParties = new HashSet<>();

    @OneToMany(mappedBy = "fir", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Evidence> evidenceItems = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "fir_vehicles",
        joinColumns = @JoinColumn(name = "fir_id"),
        inverseJoinColumns = @JoinColumn(name = "vehicle_id")
    )
    private Set<Vehicle> vehicles = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "fir_locations",
        joinColumns = @JoinColumn(name = "fir_id"),
        inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private Set<LocationRecord> locations = new HashSet<>();


    public Fir() {
    }

    public Fir(Long id, String firNumber, String title, String summary, PoliceStation policeStation, String stationName, String district, String investigatingOfficer, String priority, String status, String sections, OffsetDateTime incidentDate, OffsetDateTime registeredAt, OffsetDateTime updatedAt, Long sourceCaseMasterId, String sourcePayload, List<FirTimeline> timeline, Set<CaseParty> caseParties, Set<Evidence> evidenceItems, Set<Vehicle> vehicles, Set<LocationRecord> locations) {
        this.id = id;
        this.firNumber = firNumber;
        this.title = title;
        this.summary = summary;
        this.policeStation = policeStation;
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
        this.timeline = timeline != null ? timeline : new ArrayList<>();
        this.caseParties = caseParties != null ? caseParties : new HashSet<>();
        this.evidenceItems = evidenceItems != null ? evidenceItems : new HashSet<>();
        this.vehicles = vehicles != null ? vehicles : new HashSet<>();
        this.locations = locations != null ? locations : new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirNumber() {
        return firNumber;
    }

    public void setFirNumber(String firNumber) {
        this.firNumber = firNumber;
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

    public PoliceStation getPoliceStation() {
        return policeStation;
    }

    public void setPoliceStation(PoliceStation policeStation) {
        this.policeStation = policeStation;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getInvestigatingOfficer() {
        return investigatingOfficer;
    }

    public void setInvestigatingOfficer(String investigatingOfficer) {
        this.investigatingOfficer = investigatingOfficer;
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

    public String getSections() {
        return sections;
    }

    public void setSections(String sections) {
        this.sections = sections;
    }

    public OffsetDateTime getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(OffsetDateTime incidentDate) {
        this.incidentDate = incidentDate;
    }

    public OffsetDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(OffsetDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getSourceCaseMasterId() {
        return sourceCaseMasterId;
    }

    public void setSourceCaseMasterId(Long sourceCaseMasterId) {
        this.sourceCaseMasterId = sourceCaseMasterId;
    }

    public String getSourcePayload() {
        return sourcePayload;
    }

    public void setSourcePayload(String sourcePayload) {
        this.sourcePayload = sourcePayload;
    }

    public List<FirTimeline> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<FirTimeline> timeline) {
        this.timeline = timeline;
    }

    public Set<CaseParty> getCaseParties() {
        return caseParties;
    }

    public void setCaseParties(Set<CaseParty> caseParties) {
        this.caseParties = caseParties;
    }

    public Set<Evidence> getEvidenceItems() {
        return evidenceItems;
    }

    public void setEvidenceItems(Set<Evidence> evidenceItems) {
        this.evidenceItems = evidenceItems;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<LocationRecord> getLocations() {
        return locations;
    }

    public void setLocations(Set<LocationRecord> locations) {
        this.locations = locations;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String firNumber;
        private String title;
        private String summary;
        private PoliceStation policeStation;
        private String stationName;
        private String district;
        private String investigatingOfficer;
        private String priority;
        private String status;
        private String sections;
        private OffsetDateTime incidentDate;
        private OffsetDateTime registeredAt;
        private OffsetDateTime updatedAt;
        private Long sourceCaseMasterId;
        private String sourcePayload;
        private List<FirTimeline> timeline;
        private Set<CaseParty> caseParties;
        private Set<Evidence> evidenceItems;
        private Set<Vehicle> vehicles;
        private Set<LocationRecord> locations;

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
        public Builder policeStation(PoliceStation policeStation) {
            this.policeStation = policeStation;
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
        public Builder incidentDate(OffsetDateTime incidentDate) {
            this.incidentDate = incidentDate;
            return this;
        }
        public Builder registeredAt(OffsetDateTime registeredAt) {
            this.registeredAt = registeredAt;
            return this;
        }
        public Builder updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }
        public Builder sourceCaseMasterId(Long sourceCaseMasterId) {
            this.sourceCaseMasterId = sourceCaseMasterId;
            return this;
        }
        public Builder sourcePayload(String sourcePayload) {
            this.sourcePayload = sourcePayload;
            return this;
        }
        public Builder timeline(List<FirTimeline> timeline) {
            this.timeline = timeline;
            return this;
        }
        public Builder caseParties(Set<CaseParty> caseParties) {
            this.caseParties = caseParties;
            return this;
        }
        public Builder evidenceItems(Set<Evidence> evidenceItems) {
            this.evidenceItems = evidenceItems;
            return this;
        }
        public Builder vehicles(Set<Vehicle> vehicles) {
            this.vehicles = vehicles;
            return this;
        }
        public Builder locations(Set<LocationRecord> locations) {
            this.locations = locations;
            return this;
        }

        public Fir build() {
            return new Fir(this.id, this.firNumber, this.title, this.summary, this.policeStation, this.stationName, this.district, this.investigatingOfficer, this.priority, this.status, this.sections, this.incidentDate, this.registeredAt, this.updatedAt, this.sourceCaseMasterId, this.sourcePayload, this.timeline, this.caseParties, this.evidenceItems, this.vehicles, this.locations);
        }
    }
}