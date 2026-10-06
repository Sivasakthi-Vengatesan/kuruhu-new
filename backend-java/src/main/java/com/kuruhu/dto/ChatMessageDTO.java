package com.kuruhu.dto;

import java.io.Serializable;

public class ChatMessageDTO implements Serializable {

    private String id;
    private String role;
    private String content;
    private String modelUsed;
    private Double confidence;
    private String auditHash;

    public ChatMessageDTO() {}

    public ChatMessageDTO(String id, String role, String content, String modelUsed, Double confidence, String auditHash) {
        this.id = id;
        this.role = role;
        this.content = content;
        this.modelUsed = modelUsed;
        this.confidence = confidence;
        this.auditHash = auditHash;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getModelUsed() { return modelUsed; }
    public void setModelUsed(String modelUsed) { this.modelUsed = modelUsed; }

    public Double getConfidence() { return confidence; }
    public void setConfidence(Double confidence) { this.confidence = confidence; }

    public String getAuditHash() { return auditHash; }
    public void setAuditHash(String auditHash) { this.auditHash = auditHash; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String role;
        private String content;
        private String modelUsed;
        private Double confidence;
        private String auditHash;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder role(String role) {
            this.role = role;
            return this;
        }
        public Builder content(String content) {
            this.content = content;
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

        public ChatMessageDTO build() {
            return new ChatMessageDTO(this.id, this.role, this.content, this.modelUsed, this.confidence, this.auditHash);
        }
    }
}
