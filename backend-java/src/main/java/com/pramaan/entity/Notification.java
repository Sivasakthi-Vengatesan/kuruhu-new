package com.pramaan.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String body;

    @Column(length = 50)
    private String kind = "system"; // assignment, verification, deadline, system, escalation

    @Column(name = "action_required")
    private Boolean actionRequired = false;

    @Column(name = "is_read")
    private Boolean isRead = false;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;


    public Notification() {
    }

    public Notification(Long id, User user, String title, String body, String kind, Boolean actionRequired, Boolean isRead, OffsetDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.body = body;
        this.kind = kind;
        this.actionRequired = actionRequired;
        this.isRead = isRead;
        this.createdAt = createdAt;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Boolean isActionRequired() {
        return actionRequired;
    }

    public Boolean getActionRequired() {
        return actionRequired;
    }

    public void setActionRequired(Boolean actionRequired) {
        this.actionRequired = actionRequired;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public Boolean isRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private User user;
        private String title;
        private String body;
        private String kind;
        private Boolean actionRequired;
        private Boolean isRead;
        private OffsetDateTime createdAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder user(User user) {
            this.user = user;
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
        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Notification build() {
            return new Notification(this.id, this.user, this.title, this.body, this.kind, this.actionRequired, this.isRead, this.createdAt);
        }
    }
}