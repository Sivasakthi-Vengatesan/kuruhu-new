package com.pramaan.dto;


public class EvidenceDto {
    private String id;
    private String label;
    private String type; // physical, digital, document, biological, cctv
    private String firId;
    private String status; // collected, in-analysis, verified, archived
    private String collectedBy;
    private String collectedAt;
    private String location;


    public EvidenceDto() {
    }

    public EvidenceDto(String id, String label, String type, String firId, String status, String collectedBy, String collectedAt, String location) {
        this.id = id;
        this.label = label;
        this.type = type;
        this.firId = firId;
        this.status = status;
        this.collectedBy = collectedBy;
        this.collectedAt = collectedAt;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirId() {
        return firId;
    }

    public void setFirId(String firId) {
        this.firId = firId;
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

    public String getCollectedAt() {
        return collectedAt;
    }

    public void setCollectedAt(String collectedAt) {
        this.collectedAt = collectedAt;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String label;
        private String type;
        private String firId;
        private String status;
        private String collectedBy;
        private String collectedAt;
        private String location;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder label(String label) {
            this.label = label;
            return this;
        }
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        public Builder firId(String firId) {
            this.firId = firId;
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
        public Builder collectedAt(String collectedAt) {
            this.collectedAt = collectedAt;
            return this;
        }
        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public EvidenceDto build() {
            return new EvidenceDto(this.id, this.label, this.type, this.firId, this.status, this.collectedBy, this.collectedAt, this.location);
        }
    }
}