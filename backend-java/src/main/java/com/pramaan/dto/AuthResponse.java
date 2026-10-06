package com.pramaan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponse {
    private String token;

    private String tokenType = "Bearer";
    private UserDto user;
    
    @JsonProperty("requiresEmailVerification")

    private boolean requiresEmailVerification = false;


    public AuthResponse() {
    }

    public AuthResponse(String token, String tokenType, UserDto user, boolean requiresEmailVerification) {
        this.token = token;
        this.tokenType = tokenType;
        this.user = user;
        this.requiresEmailVerification = requiresEmailVerification;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public boolean isRequiresEmailVerification() {
        return requiresEmailVerification;
    }

    public void setRequiresEmailVerification(boolean requiresEmailVerification) {
        this.requiresEmailVerification = requiresEmailVerification;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String token;
        private String tokenType;
        private UserDto user;
        private boolean requiresEmailVerification;

        public Builder token(String token) {
            this.token = token;
            return this;
        }
        public Builder tokenType(String tokenType) {
            this.tokenType = tokenType;
            return this;
        }
        public Builder user(UserDto user) {
            this.user = user;
            return this;
        }
        public Builder requiresEmailVerification(boolean requiresEmailVerification) {
            this.requiresEmailVerification = requiresEmailVerification;
            return this;
        }

        public AuthResponse build() {
            return new AuthResponse(this.token, this.tokenType, this.user, this.requiresEmailVerification);
        }
    }
}