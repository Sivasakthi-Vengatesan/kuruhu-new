package com.pramaan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserDto {
    private String id;
    
    @JsonProperty("login_identifier")
    private String loginIdentifier;
    
    @JsonProperty("mobile_number")
    private String mobileNumber;
    
    private String psn;
    
    @JsonProperty("is_active")
    private boolean isActive;
    
    @JsonProperty("last_login_at")
    private String lastLoginAt;
    
    private String role;
    private List<String> roles;
    private List<String> permissions;
    
    @JsonProperty("display_name")
    private String displayName;
    
    private String district;
    
    @JsonProperty("badge_number")
    private String badgeNumber;
    
    private String station;


    public UserDto() {
    }

    public UserDto(String id, String loginIdentifier, String mobileNumber, String psn, boolean isActive, String lastLoginAt, String role, List<String> roles, List<String> permissions, String displayName, String district, String badgeNumber, String station) {
        this.id = id;
        this.loginIdentifier = loginIdentifier;
        this.mobileNumber = mobileNumber;
        this.psn = psn;
        this.isActive = isActive;
        this.lastLoginAt = lastLoginAt;
        this.role = role;
        this.roles = roles;
        this.permissions = permissions;
        this.displayName = displayName;
        this.district = district;
        this.badgeNumber = badgeNumber;
        this.station = station;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginIdentifier() {
        return loginIdentifier;
    }

    public void setLoginIdentifier(String loginIdentifier) {
        this.loginIdentifier = loginIdentifier;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPsn() {
        return psn;
    }

    public void setPsn(String psn) {
        this.psn = psn;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getLastLoginAt() {
        return lastLoginAt;
    }

    public void setLastLoginAt(String lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String loginIdentifier;
        private String mobileNumber;
        private String psn;
        private boolean isActive;
        private String lastLoginAt;
        private String role;
        private List<String> roles;
        private List<String> permissions;
        private String displayName;
        private String district;
        private String badgeNumber;
        private String station;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder loginIdentifier(String loginIdentifier) {
            this.loginIdentifier = loginIdentifier;
            return this;
        }
        public Builder mobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }
        public Builder psn(String psn) {
            this.psn = psn;
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
        public Builder role(String role) {
            this.role = role;
            return this;
        }
        public Builder roles(List<String> roles) {
            this.roles = roles;
            return this;
        }
        public Builder permissions(List<String> permissions) {
            this.permissions = permissions;
            return this;
        }
        public Builder displayName(String displayName) {
            this.displayName = displayName;
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

        public UserDto build() {
            return new UserDto(this.id, this.loginIdentifier, this.mobileNumber, this.psn, this.isActive, this.lastLoginAt, this.role, this.roles, this.permissions, this.displayName, this.district, this.badgeNumber, this.station);
        }
    }
}