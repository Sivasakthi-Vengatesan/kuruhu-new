package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "notifications")
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "kind")
    private String kind;

    @Column(name = "actionRequired")
    private Boolean actionRequired;

    @Column(name = "isRead")
    private Boolean isRead;

    @Column(name = "createdAt")
    private java.time.OffsetDateTime createdAt;

    public Notification() {
    }

    public Notification(Long id, Long userId, String title, String body, String kind, Boolean actionRequired, Boolean isRead, java.time.OffsetDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
        this.kind = kind;
        this.actionRequired = actionRequired;
        this.isRead = isRead;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public String getKind() { return kind; }
    public void setKind(String kind) { this.kind = kind; }

    public Boolean getActionRequired() { return actionRequired; }
    public void setActionRequired(Boolean actionRequired) { this.actionRequired = actionRequired; }

    public Boolean getIsRead() { return isRead; }
    public void setIsRead(Boolean isRead) { this.isRead = isRead; }

    public java.time.OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(java.time.OffsetDateTime createdAt) { this.createdAt = createdAt; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long userId;
        private String title;
        private String body;
        private String kind;
        private Boolean actionRequired;
        private Boolean isRead;
        private java.time.OffsetDateTime createdAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder body(String body) {
            this.body = body;
            return this;
        }
        public Builder kind(String kind) {
            this.kind = kind;
            return this;
        }
        public Builder actionRequired(Boolean actionRequired) {
            this.actionRequired = actionRequired;
            return this;
        }
        public Builder isRead(Boolean isRead) {
            this.isRead = isRead;
            return this;
        }
        public Builder createdAt(java.time.OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Notification build() {
            return new Notification(this.id, this.userId, this.title, this.body, this.kind, this.actionRequired, this.isRead, this.createdAt);
        }
    }
}
