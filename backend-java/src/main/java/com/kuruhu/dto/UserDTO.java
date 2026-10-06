package com.kuruhu.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String id;
    private String loginIdentifier;
    private String displayName;
    private String role;
    private java.util.List<String> roles;
    private java.util.List<String> permissions;
    private String district;
    private String badgeNumber;
    private String station;
    private boolean isActive;
    private String lastLoginAt;

    public UserDTO() {}

    public UserDTO(String id, String loginIdentifier, String displayName, String role, java.util.List<String> roles, java.util.List<String> permissions, String district, String badgeNumber, String station, boolean isActive, String lastLoginAt) {
        this.id = id;
        this.loginIdentifier = loginIdentifier;
        this.displayName = displayName;
        this.role = role;
        this.roles = roles;
        this.permissions = permissions;
        this.district = district;
        this.badgeNumber = badgeNumber;
        this.station = station;
        this.isActive = isActive;
        this.lastLoginAt = lastLoginAt;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getLoginIdentifier() { return loginIdentifier; }
    public void setLoginIdentifier(String loginIdentifier) { this.loginIdentifier = loginIdentifier; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public java.util.List<String> getRoles() { return roles; }
    public void setRoles(java.util.List<String> roles) { this.roles = roles; }

    public java.util.List<String> getPermissions() { return permissions; }
    public void setPermissions(java.util.List<String> permissions) { this.permissions = permissions; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getBadgeNumber() { return badgeNumber; }
    public void setBadgeNumber(String badgeNumber) { this.badgeNumber = badgeNumber; }

    public String getStation() { return station; }
    public void setStation(String station) { this.station = station; }

    public boolean getIsActive() { return isActive; }
    public void setIsActive(boolean isActive) { this.isActive = isActive; }

    public String getLastLoginAt() { return lastLoginAt; }
    public void setLastLoginAt(String lastLoginAt) { this.lastLoginAt = lastLoginAt; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String loginIdentifier;
        private String displayName;
        private String role;
        private java.util.List<String> roles;
        private java.util.List<String> permissions;
        private String district;
        private String badgeNumber;
        private String station;
        private boolean isActive;
        private String lastLoginAt;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder loginIdentifier(String loginIdentifier) {
            this.loginIdentifier = loginIdentifier;
            return this;
        }
        public Builder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }
        public Builder role(String role) {
            this.role = role;
            return this;
        }
        public Builder roles(java.util.List<String> roles) {
            this.roles = roles;
            return this;
        }
        public Builder permissions(java.util.List<String> permissions) {
            this.permissions = permissions;
            return this;
        }
        public Builder district(String district) {
            this.district = district;
            return this;
        }
        public Builder badgeNumber(String badgeNumber) {
            this.badgeNumber = badgeNumber;
            return this;
        }
        public Builder station(String station) {
            this.station = station;
            return this;
        }
        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }
        public Builder lastLoginAt(String lastLoginAt) {
            this.lastLoginAt = lastLoginAt;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(this.id, this.loginIdentifier, this.displayName, this.role, this.roles, this.permissions, this.district, this.badgeNumber, this.station, this.isActive, this.lastLoginAt);
        }
    }
}
