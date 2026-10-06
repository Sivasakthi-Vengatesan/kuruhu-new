package com.pramaan.dto;


public class VerifyFindingRequest {
    private String status; // verified, rejected
    private String verifiedBy;
    private String notes;


    public VerifyFindingRequest() {
    }

    public VerifyFindingRequest(String status, String verifiedBy, String notes) {
        this.status = status;
        this.verifiedBy = verifiedBy;
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
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
        private String status;
        private String verifiedBy;
        private String notes;

        public Builder status(String status) {
            this.status = status;
            return this;
        }
        public Builder verifiedBy(String verifiedBy) {
            this.verifiedBy = verifiedBy;
            return this;
        }
        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public VerifyFindingRequest build() {
            return new VerifyFindingRequest(this.status, this.verifiedBy, this.notes);
        }
    }
}