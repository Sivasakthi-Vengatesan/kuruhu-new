package com.kuruhu.dto;

import java.io.Serializable;

public class LoginRequest implements Serializable {

    private String identifier;
    private String credential;
    private String role;
    private String district;
    private String mode;

    public LoginRequest() {}

    public LoginRequest(String identifier, String credential, String role, String district, String mode) {
        this.identifier = identifier;
        this.credential = credential;
        this.role = role;
        this.district = district;
        this.mode = mode;
    }

    public String getIdentifier() { return identifier; }
    public void setIdentifier(String identifier) { this.identifier = identifier; }

    public String getCredential() { return credential; }
    public void setCredential(String credential) { this.credential = credential; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String identifier;
        private String credential;
        private String role;
        private String district;
        private String mode;

        public Builder identifier(String identifier) {
            this.identifier = identifier;
            return this;
        }
        public Builder credential(String credential) {
            this.credential = credential;
            return this;
        }
        public Builder role(String role) {
            this.role = role;
            return this;
        }
        public Builder district(String district) {
            this.district = district;
            return this;
        }
        public Builder mode(String mode) {
            this.mode = mode;
            return this;
        }

        public LoginRequest build() {
            return new LoginRequest(this.identifier, this.credential, this.role, this.district, this.mode);
        }
    }
}
