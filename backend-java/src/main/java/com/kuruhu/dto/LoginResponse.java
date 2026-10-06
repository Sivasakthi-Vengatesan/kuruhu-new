package com.kuruhu.dto;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    private String token;
    private String tokenType;
    private Object user;
    private boolean requiresVerification;

    public LoginResponse() {}

    public LoginResponse(String token, String tokenType, Object user, boolean requiresVerification) {
        this.token = token;
        this.tokenType = tokenType;
        this.user = user;
        this.requiresVerification = requiresVerification;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getTokenType() { return tokenType; }
    public void setTokenType(String tokenType) { this.tokenType = tokenType; }

    public Object getUser() { return user; }
    public void setUser(Object user) { this.user = user; }

    public boolean getRequiresVerification() { return requiresVerification; }
    public void setRequiresVerification(boolean requiresVerification) { this.requiresVerification = requiresVerification; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String token;
        private String tokenType;
        private Object user;
        private boolean requiresVerification;

        public Builder token(String token) {
            this.token = token;
            return this;
        }
        public Builder tokenType(String tokenType) {
            this.tokenType = tokenType;
            return this;
        }
        public Builder user(Object user) {
            this.user = user;
            return this;
        }
        public Builder requiresVerification(boolean requiresVerification) {
            this.requiresVerification = requiresVerification;
            return this;
        }

        public LoginResponse build() {
            return new LoginResponse(this.token, this.tokenType, this.user, this.requiresVerification);
        }
    }
}
