package com.pramaan.dto;


public class PersonRelationshipDto {
    private String personId;
    private String label;
    private String firId;
    private boolean verified;


    public PersonRelationshipDto() {
    }

    public PersonRelationshipDto(String personId, String label, String firId, boolean verified) {
        this.personId = personId;
        this.label = label;
        this.firId = firId;
        this.verified = verified;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFirId() {
        return firId;
    }

    public void setFirId(String firId) {
        this.firId = firId;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String personId;
        private String label;
        private String firId;
        private boolean verified;

        public Builder personId(String personId) {
            this.personId = personId;
            return this;
        }
        public Builder label(String label) {
            this.label = label;
            return this;
        }
        public Builder firId(String firId) {
            this.firId = firId;
            return this;
        }
        public Builder verified(boolean verified) {
            this.verified = verified;
            return this;
        }

        public PersonRelationshipDto build() {
            return new PersonRelationshipDto(this.personId, this.label, this.firId, this.verified);
        }
    }
}