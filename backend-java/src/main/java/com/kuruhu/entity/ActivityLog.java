package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "activitylogs")
public class ActivityLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "activityType")
    private String activityType;

    @Column(name = "description")
    private String description;

    @Column(name = "performedBy")
    private String performedBy;

    @Column(name = "entityType")
    private String entityType;

    @Column(name = "entityId")
    private Long entityId;

    @Column(name = "timestamp")
    private java.time.OffsetDateTime timestamp;

    public ActivityLog() {
    }

    public ActivityLog(Long id, String activityType, String description, String performedBy, String entityType, Long entityId, java.time.OffsetDateTime timestamp) {
        this.id = id;
        this.activityType = activityType;
        this.description = description;
        this.performedBy = performedBy;
        this.entityType = entityType;
        this.entityId = entityId;
        this.timestamp = timestamp;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getActivityType() { return activityType; }
    public void setActivityType(String activityType) { this.activityType = activityType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPerformedBy() { return performedBy; }
    public void setPerformedBy(String performedBy) { this.performedBy = performedBy; }

    public String getEntityType() { return entityType; }
    public void setEntityType(String entityType) { this.entityType = entityType; }

    public Long getEntityId() { return entityId; }
    public void setEntityId(Long entityId) { this.entityId = entityId; }

    public java.time.OffsetDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(java.time.OffsetDateTime timestamp) { this.timestamp = timestamp; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String activityType;
        private String description;
        private String performedBy;
        private String entityType;
        private Long entityId;
        private java.time.OffsetDateTime timestamp;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder activityType(String activityType) {
            this.activityType = activityType;
            return this;
        }
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        public Builder performedBy(String performedBy) {
            this.performedBy = performedBy;
            return this;
        }
        public Builder entityType(String entityType) {
            this.entityType = entityType;
            return this;
        }
        public Builder entityId(Long entityId) {
            this.entityId = entityId;
            return this;
        }
        public Builder timestamp(java.time.OffsetDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ActivityLog build() {
            return new ActivityLog(this.id, this.activityType, this.description, this.performedBy, this.entityType, this.entityId, this.timestamp);
        }
    }
}
