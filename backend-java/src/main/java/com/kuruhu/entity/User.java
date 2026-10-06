package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "passwordHash")
    private String passwordHash;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "district")
    private String district;

    @Column(name = "badgeNumber")
    private String badgeNumber;

    @Column(name = "isActive")
    private Boolean isActive;

    @Column(name = "lastLoginAt")
    private java.time.OffsetDateTime lastLoginAt;

    public User() {
    }

    public User(Long id, String username, String email, String passwordHash, String fullName, String phone, String district, String badgeNumber, Boolean isActive, java.time.OffsetDateTime lastLoginAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.fullName = fullName;
        this.phone = phone;
        this.district = district;
        this.badgeNumber = badgeNumber;
        this.isActive = isActive;
        this.lastLoginAt = lastLoginAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getBadgeNumber() { return badgeNumber; }
    public void setBadgeNumber(String badgeNumber) { this.badgeNumber = badgeNumber; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public java.time.OffsetDateTime getLastLoginAt() { return lastLoginAt; }
    public void setLastLoginAt(java.time.OffsetDateTime lastLoginAt) { this.lastLoginAt = lastLoginAt; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String username;
        private String email;
        private String passwordHash;
        private String fullName;
        private String phone;
        private String district;
        private String badgeNumber;
        private Boolean isActive;
        private java.time.OffsetDateTime lastLoginAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder username(String username) {
            this.username = username;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder passwordHash(String passwordHash) {
            this.passwordHash = passwordHash;
            return this;
        }
        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }
        public Builder phone(String phone) {
            this.phone = phone;
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
        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }
        public Builder lastLoginAt(java.time.OffsetDateTime lastLoginAt) {
            this.lastLoginAt = lastLoginAt;
            return this;
        }

        public User build() {
            return new User(this.id, this.username, this.email, this.passwordHash, this.fullName, this.phone, this.district, this.badgeNumber, this.isActive, this.lastLoginAt);
        }
    }
}
