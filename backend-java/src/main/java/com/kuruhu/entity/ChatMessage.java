package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "chatmessages")
public class ChatMessage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sessionId")
    private Long sessionId;

    @Column(name = "senderRole")
    private String senderRole;

    @Column(name = "messageContent")
    private String messageContent;

    @Column(name = "modelUsed")
    private String modelUsed;

    @Column(name = "confidence")
    private Double confidence;

    @Column(name = "auditHash")
    private String auditHash;

    @Column(name = "timestamp")
    private java.time.OffsetDateTime timestamp;

    public ChatMessage() {
    }

    public ChatMessage(Long id, Long sessionId, String senderRole, String messageContent, String modelUsed, Double confidence, String auditHash, java.time.OffsetDateTime timestamp) {
        this.id = id;
        this.sessionId = sessionId;
        this.senderRole = senderRole;
        this.messageContent = messageContent;
        this.modelUsed = modelUsed;
        this.confidence = confidence;
        this.auditHash = auditHash;
        this.timestamp = timestamp;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getSessionId() { return sessionId; }
    public void setSessionId(Long sessionId) { this.sessionId = sessionId; }

    public String getSenderRole() { return senderRole; }
    public void setSenderRole(String senderRole) { this.senderRole = senderRole; }

    public String getMessageContent() { return messageContent; }
    public void setMessageContent(String messageContent) { this.messageContent = messageContent; }

    public String getModelUsed() { return modelUsed; }
    public void setModelUsed(String modelUsed) { this.modelUsed = modelUsed; }

    public Double getConfidence() { return confidence; }
    public void setConfidence(Double confidence) { this.confidence = confidence; }

    public String getAuditHash() { return auditHash; }
    public void setAuditHash(String auditHash) { this.auditHash = auditHash; }

    public java.time.OffsetDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(java.time.OffsetDateTime timestamp) { this.timestamp = timestamp; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long sessionId;
        private String senderRole;
        private String messageContent;
        private String modelUsed;
        private Double confidence;
        private String auditHash;
        private java.time.OffsetDateTime timestamp;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder sessionId(Long sessionId) {
            this.sessionId = sessionId;
            return this;
        }
        public Builder senderRole(String senderRole) {
            this.senderRole = senderRole;
            return this;
        }
        public Builder messageContent(String messageContent) {
            this.messageContent = messageContent;
            return this;
        }
        public Builder modelUsed(String modelUsed) {
            this.modelUsed = modelUsed;
            return this;
        }
        public Builder confidence(Double confidence) {
            this.confidence = confidence;
            return this;
        }
        public Builder auditHash(String auditHash) {
            this.auditHash = auditHash;
            return this;
        }
        public Builder timestamp(java.time.OffsetDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ChatMessage build() {
            return new ChatMessage(this.id, this.sessionId, this.senderRole, this.messageContent, this.modelUsed, this.confidence, this.auditHash, this.timestamp);
        }
    }
}
