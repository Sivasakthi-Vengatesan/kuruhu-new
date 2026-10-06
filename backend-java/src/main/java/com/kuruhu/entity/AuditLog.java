package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "auditlogs")
public class AuditLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "actorName")
    private String actorName;

    @Column(name = "actorRole")
    private String actorRole;

    @Column(name = "action")
    private String action;

    @Column(name = "targetDescription")
    private String targetDescription;

    @Column(name = "targetType")
    private String targetType;

    @Column(name = "detail")
    private String detail;

    @Column(name = "ipAddress")
    private String ipAddress;

    @Column(name = "timestamp")
    private java.time.OffsetDateTime timestamp;

    public AuditLog() {
    }

    public AuditLog(Long id, Long userId, String actorName, String actorRole, String action, String targetDescription, String targetType, String detail, String ipAddress, java.time.OffsetDateTime timestamp) {
        this.id = id;
        this.userId = userId;
        this.actorName = actorName;
        this.actorRole = actorRole;
        this.action = action;
        this.targetDescription = targetDescription;
        this.targetType = targetType;
        this.detail = detail;
        this.ipAddress = ipAddress;
        this.timestamp = timestamp;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getActorName() { return actorName; }
    public void setActorName(String actorName) { this.actorName = actorName; }

    public String getActorRole() { return actorRole; }
    public void setActorRole(String actorRole) { this.actorRole = actorRole; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public String getTargetDescription() { return targetDescription; }
    public void setTargetDescription(String targetDescription) { this.targetDescription = targetDescription; }

    public String getTargetType() { return targetType; }
    public void setTargetType(String targetType) { this.targetType = targetType; }

    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public java.time.OffsetDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(java.time.OffsetDateTime timestamp) { this.timestamp = timestamp; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long userId;
        private String actorName;
        private String actorRole;
        private String action;
        private String targetDescription;
        private String targetType;
        private String detail;
        private String ipAddress;
        private java.time.OffsetDateTime timestamp;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }
        public Builder actorName(String actorName) {
            this.actorName = actorName;
            return this;
        }
        public Builder actorRole(String actorRole) {
            this.actorRole = actorRole;
            return this;
        }
        public Builder action(String action) {
            this.action = action;
            return this;
        }
        public Builder targetDescription(String targetDescription) {
            this.targetDescription = targetDescription;
            return this;
        }
        public Builder targetType(String targetType) {
            this.targetType = targetType;
            return this;
        }
        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }
        public Builder ipAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }
        public Builder timestamp(java.time.OffsetDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public AuditLog build() {
            return new AuditLog(this.id, this.userId, this.actorName, this.actorRole, this.action, this.targetDescription, this.targetType, this.detail, this.ipAddress, this.timestamp);
        }
    }
}
