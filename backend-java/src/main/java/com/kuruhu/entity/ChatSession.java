package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "chatsessions")
public class ChatSession implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sessionId")
    private String sessionId;

    @Column(name = "userId")
    private String userId;

    @Column(name = "title")
    private String title;

    @Column(name = "startedAt")
    private java.time.OffsetDateTime startedAt;

    @Column(name = "lastActiveAt")
    private java.time.OffsetDateTime lastActiveAt;

    public ChatSession() {
    }

    public ChatSession(Long id, String sessionId, String userId, String title, java.time.OffsetDateTime startedAt, java.time.OffsetDateTime lastActiveAt) {
        this.id = id;
        this.sessionId = sessionId;
        this.userId = userId;
        this.title = title;
        this.startedAt = startedAt;
        this.lastActiveAt = lastActiveAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public java.time.OffsetDateTime getStartedAt() { return startedAt; }
    public void setStartedAt(java.time.OffsetDateTime startedAt) { this.startedAt = startedAt; }

    public java.time.OffsetDateTime getLastActiveAt() { return lastActiveAt; }
    public void setLastActiveAt(java.time.OffsetDateTime lastActiveAt) { this.lastActiveAt = lastActiveAt; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String sessionId;
        private String userId;
        private String title;
        private java.time.OffsetDateTime startedAt;
        private java.time.OffsetDateTime lastActiveAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder sessionId(String sessionId) {
            this.sessionId = sessionId;
            return this;
        }
        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder startedAt(java.time.OffsetDateTime startedAt) {
            this.startedAt = startedAt;
            return this;
        }
        public Builder lastActiveAt(java.time.OffsetDateTime lastActiveAt) {
            this.lastActiveAt = lastActiveAt;
            return this;
        }

        public ChatSession build() {
            return new ChatSession(this.id, this.sessionId, this.userId, this.title, this.startedAt, this.lastActiveAt);
        }
    }
}
