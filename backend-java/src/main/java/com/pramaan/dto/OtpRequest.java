package com.pramaan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class OtpRequest {
    @NotBlank(message = "Identifier is required")
    private String identifier;


    public OtpRequest() {
    }

    public OtpRequest(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String identifier;

        public Builder identifier(String identifier) {
            this.identifier = identifier;
            return this;
        }

        public OtpRequest build() {
            return new OtpRequest(this.identifier);
        }
    }
}