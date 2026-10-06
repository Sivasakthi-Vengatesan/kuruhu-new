package com.kuruhu.dto;

import java.io.Serializable;

public class EvidenceDTO implements Serializable {

    private String id;
    private String evidenceCode;
    private String label;
    private String evidenceType;
    private String status;
    private String collectedBy;
    private String location;
    private String collectedAt;
    private Long firId;

    public EvidenceDTO() {}

    public EvidenceDTO(String id, String evidenceCode, String label, String evidenceType, String status, String collectedBy, String location, String collectedAt, Long firId) {
        this.id = id;
        this.evidenceCode = evidenceCode;
        this.label = label;
        this.evidenceType = evidenceType;
        this.status = status;
        this.collectedBy = collectedBy;
        this.location = location;
        this.collectedAt = collectedAt;
        this.firId = firId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEvidenceCode() { return evidenceCode; }
    public void setEvidenceCode(String evidenceCode) { this.evidenceCode = evidenceCode; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public String getEvidenceType() { return evidenceType; }
    public void setEvidenceType(String evidenceType) { this.evidenceType = evidenceType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCollectedBy() { return collectedBy; }
    public void setCollectedBy(String collectedBy) { this.collectedBy = collectedBy; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCollectedAt() { return collectedAt; }
    public void setCollectedAt(String collectedAt) { this.collectedAt = collectedAt; }

    public Long getFirId() { return firId; }
    public void setFirId(Long firId) { this.firId = firId; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String evidenceCode;
        private String label;
        private String evidenceType;
        private String status;
        private String collectedBy;
        private String location;
        private String collectedAt;
        private Long firId;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder evidenceCode(String evidenceCode) {
            this.evidenceCode = evidenceCode;
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
        public Builder location(String location) {
            this.location = location;
            return this;
        }
        public Builder collectedAt(String collectedAt) {
            this.collectedAt = collectedAt;
            return this;
        }
        public Builder firId(Long firId) {
            this.firId = firId;
            return this;
        }

        public EvidenceDTO build() {
            return new EvidenceDTO(this.id, this.evidenceCode, this.label, this.evidenceType, this.status, this.collectedBy, this.location, this.collectedAt, this.firId);
        }
    }
}
