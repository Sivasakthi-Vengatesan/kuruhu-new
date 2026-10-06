package com.pramaan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OtpResponse {
    private String message;
    
    @JsonProperty("development_code")
    private String developmentCode;


    public OtpResponse() {
    }

    public OtpResponse(String message, String developmentCode) {
        this.message = message;
        this.developmentCode = developmentCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDevelopmentCode() {
        return developmentCode;
    }

    public void setDevelopmentCode(String developmentCode) {
        this.developmentCode = developmentCode;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String message;
        private String developmentCode;

        public Builder message(String message) {
            this.message = message;
            return this;
        }
        public Builder developmentCode(String developmentCode) {
            this.developmentCode = developmentCode;
            return this;
        }

        public OtpResponse build() {
            return new OtpResponse(this.message, this.developmentCode);
        }
    }
}