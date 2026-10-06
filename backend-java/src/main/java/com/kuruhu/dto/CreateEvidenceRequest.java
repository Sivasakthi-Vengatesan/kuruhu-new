package com.kuruhu.dto;

import java.io.Serializable;

public class CreateEvidenceRequest implements Serializable {

    private String label;
    private String evidenceType;
    private String collectedBy;
    private String location;
    private Long firId;

    public CreateEvidenceRequest() {}

    public CreateEvidenceRequest(String label, String evidenceType, String collectedBy, String location, Long firId) {
        this.label = label;
        this.evidenceType = evidenceType;
        this.collectedBy = collectedBy;
        this.location = location;
        this.firId = firId;
    }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public String getEvidenceType() { return evidenceType; }
    public void setEvidenceType(String evidenceType) { this.evidenceType = evidenceType; }

    public String getCollectedBy() { return collectedBy; }
    public void setCollectedBy(String collectedBy) { this.collectedBy = collectedBy; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Long getFirId() { return firId; }
    public void setFirId(Long firId) { this.firId = firId; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String label;
        private String evidenceType;
        private String collectedBy;
        private String location;
        private Long firId;

        public Builder label(String label) {
            this.label = label;
            return this;
        }
        public Builder evidenceType(String evidenceType) {
            this.evidenceType = evidenceType;
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
        public Builder firId(Long firId) {
            this.firId = firId;
            return this;
        }

        public CreateEvidenceRequest build() {
            return new CreateEvidenceRequest(this.label, this.evidenceType, this.collectedBy, this.location, this.firId);
        }
    }
}
