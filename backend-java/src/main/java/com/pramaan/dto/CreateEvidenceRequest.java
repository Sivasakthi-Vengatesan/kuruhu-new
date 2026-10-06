package com.pramaan.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateEvidenceRequest {

    @NotNull(message = "FIR ID is required")
    private Long firId;

    @NotBlank(message = "Label is required")
    private String label;

    @NotBlank(message = "Evidence type is required")
    private String evidenceType; // physical, digital, document, biological, cctv

    private String status; // collected, in-analysis, verified, archived

    private String collectedBy;

    private String locationDescription;

    private String notes;


    public CreateEvidenceRequest() {
    }

    public CreateEvidenceRequest(Long firId, String label, String evidenceType, String status, String collectedBy, String locationDescription, String notes) {
        this.firId = firId;
        this.label = label;
        this.evidenceType = evidenceType;
        this.status = status;
        this.collectedBy = collectedBy;
        this.locationDescription = locationDescription;
        this.notes = notes;
    }

    public Long getFirId() {
        return firId;
    }

    public void setFirId(Long firId) {
        this.firId = firId;
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long firId;
        private String label;
        private String evidenceType;
        private String status;
        private String collectedBy;
        private String locationDescription;
        private String notes;

        public Builder firId(Long firId) {
            this.firId = firId;
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
        public Builder locationDescription(String locationDescription) {
            this.locationDescription = locationDescription;
            return this;
        }
        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public CreateEvidenceRequest build() {
            return new CreateEvidenceRequest(this.firId, this.label, this.evidenceType, this.status, this.collectedBy, this.locationDescription, this.notes);
        }
    }
}