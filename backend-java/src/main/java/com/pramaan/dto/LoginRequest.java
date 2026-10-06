package com.pramaan.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "Identifier (email/username/phone/PSN) is required")
    private String identifier;

    private String credential; // password or PIN

    private String district;

    private String language;

    private String mode; // mobile_otp, psn_pin, admin, civilian

    private String role; // admin, investigator, officer, civilian

    private String name;


    public LoginRequest() {
    }

    public LoginRequest(String identifier, String credential, String district, String language, String mode, String role, String name) {
        this.identifier = identifier;
        this.credential = credential;
        this.district = district;
        this.language = language;
        this.mode = mode;
        this.role = role;
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String identifier;
        private String credential;
        private String district;
        private String language;
        private String mode;
        private String role;
        private String name;

        public Builder identifier(String identifier) {
            this.identifier = identifier;
            return this;
        }
        public Builder credential(String credential) {
            this.credential = credential;
            return this;
        }
        public Builder district(String district) {
            this.district = district;
            return this;
        }
        public Builder language(String language) {
            this.language = language;
            return this;
        }
        public Builder mode(String mode) {
            this.mode = mode;
            return this;
        }
        public Builder role(String role) {
            this.role = role;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public LoginRequest build() {
            return new LoginRequest(this.identifier, this.credential, this.district, this.language, this.mode, this.role, this.name);
        }
    }
}