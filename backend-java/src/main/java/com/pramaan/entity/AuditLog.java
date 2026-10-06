package com.pramaan.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "audit_logs")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "actor_name", nullable = false, length = 150)
    private String actorName;

    @Column(name = "actor_role", nullable = false, length = 100)
    private String actorRole;

    @Column(nullable = false, length = 100)
    private String action;

    @Column(name = "target_description", nullable = false, length = 255)
    private String targetDescription;

    @Column(name = "target_type", nullable = false, length = 50)
    private String targetType; // fir, person, evidence, ai-finding, system, auth

    @Column(columnDefinition = "TEXT")
    private String detail;

    @Column(name = "ip_address", length = 50)
    private String ipAddress;

    @CreationTimestamp
    @Column(name = "timestamp", updatable = false)
    private OffsetDateTime timestamp;


    public AuditLog() {
    }

    public AuditLog(Long id, User user, String actorName, String actorRole, String action, String targetDescription, String targetType, String detail, String ipAddress, OffsetDateTime timestamp) {
        this.id = id;
        this.user = user;
        this.actorName = actorName;
        this.actorRole = actorRole;
        this.action = action;
        this.targetDescription = targetDescription;
        this.targetType = targetType;
        this.detail = detail;
        this.ipAddress = ipAddress;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorRole() {
        return actorRole;
    }

    public void setActorRole(String actorRole) {
        this.actorRole = actorRole;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTargetDescription() {
        return targetDescription;
    }

    public void setTargetDescription(String targetDescription) {
        this.targetDescription = targetDescription;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private User user;
        private String actorName;
        private String actorRole;
        private String action;
        private String targetDescription;
        private String targetType;
        private String detail;
        private String ipAddress;
        private OffsetDateTime timestamp;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder user(User user) {
            this.user = user;
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
        public Builder timestamp(OffsetDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public AuditLog build() {
            return new AuditLog(this.id, this.user, this.actorName, this.actorRole, this.action, this.targetDescription, this.targetType, this.detail, this.ipAddress, this.timestamp);
        }
    }
}