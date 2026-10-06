package com.pramaan.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "evidence")
public class Evidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "evidence_code", unique = true, length = 50)
    private String evidenceCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fir_id", nullable = false)
    private Fir fir;

    @Column(nullable = false, length = 255)
    private String label;

    @Column(name = "evidence_type", nullable = false, length = 50)
    private String evidenceType; // physical, digital, document, biological, cctv

    @Column(length = 50)
    private String status = "collected"; // collected, in-analysis, verified, archived

    @Column(name = "collected_by", nullable = false, length = 150)
    private String collectedBy;

    @Column(name = "collected_at")
    private OffsetDateTime collectedAt;

    @Column(name = "location_description", columnDefinition = "TEXT")
    private String locationDescription;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;


    public Evidence() {
    }

    public Evidence(Long id, String evidenceCode, Fir fir, String label, String evidenceType, String status, String collectedBy, OffsetDateTime collectedAt, String locationDescription, String notes, OffsetDateTime createdAt) {
        this.id = id;
        this.evidenceCode = evidenceCode;
        this.fir = fir;
        this.label = label;
        this.evidenceType = evidenceType;
        this.status = status;
        this.collectedBy = collectedBy;
        this.collectedAt = collectedAt;
        this.locationDescription = locationDescription;
        this.notes = notes;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvidenceCode() {
        return evidenceCode;
    }

    public void setEvidenceCode(String evidenceCode) {
        this.evidenceCode = evidenceCode;
    }

    public Fir getFir() {
        return fir;
    }

    public void setFir(Fir fir) {
        this.fir = fir;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getEvidenceType() {
        return evidenceType;
    }

    public void setEvidenceType(String evidenceType) {
        this.evidenceType = evidenceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCollectedBy() {
        return collectedBy;
    }

    public void setCollectedBy(String collectedBy) {
        this.collectedBy = collectedBy;
    }

    public OffsetDateTime getCollectedAt() {
        return collectedAt;
    }

    public void setCollectedAt(OffsetDateTime collectedAt) {
        this.collectedAt = collectedAt;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String evidenceCode;
        private Fir fir;
        private String label;
        private String evidenceType;
        private String status;
        private String collectedBy;
        private OffsetDateTime collectedAt;
        private String locationDescription;
        private String notes;
        private OffsetDateTime createdAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder evidenceCode(String evidenceCode) {
            this.evidenceCode = evidenceCode;
            return this;
        }
        public Builder fir(Fir fir) {
            this.fir = fir;
            return this;
        }
        public Builder label(String label) {
            this.label = label;
            return this;
        }
        public Builder evidenceType(String evidenceType) {
            this.evidenceType = evidenceType;
            return this;
        }
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        public Builder collectedBy(String collectedBy) {
            this.collectedBy = collectedBy;
            return this;
        }
        public Builder collectedAt(OffsetDateTime collectedAt) {
            this.collectedAt = collectedAt;
            return this;
        }
        public Builder locationDescription(String locationDescription) {
            this.locationDescription = locationDescription;
            return this;
        }
        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }
        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Evidence build() {
            return new Evidence(this.id, this.evidenceCode, this.fir, this.label, this.evidenceType, this.status, this.collectedBy, this.collectedAt, this.locationDescription, this.notes, this.createdAt);
        }
    }
}