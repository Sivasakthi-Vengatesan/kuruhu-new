package com.kuruhu.dto;

import java.io.Serializable;

public class ChatResponse implements Serializable {

    private String reply;
    private String modelUsed;
    private Double confidence;
    private String auditHash;
    private java.util.List<Object> citations;

    public ChatResponse() {}

    public ChatResponse(String reply, String modelUsed, Double confidence, String auditHash, java.util.List<Object> citations) {
        this.reply = reply;
        this.modelUsed = modelUsed;
        this.confidence = confidence;
        this.auditHash = auditHash;
        this.citations = citations;
    }

    public String getReply() { return reply; }
    public void setReply(String reply) { this.reply = reply; }

    public String getModelUsed() { return modelUsed; }
    public void setModelUsed(String modelUsed) { this.modelUsed = modelUsed; }

    public Double getConfidence() { return confidence; }
    public void setConfidence(Double confidence) { this.confidence = confidence; }

    public String getAuditHash() { return auditHash; }
    public void setAuditHash(String auditHash) { this.auditHash = auditHash; }

    public java.util.List<Object> getCitations() { return citations; }
    public void setCitations(java.util.List<Object> citations) { this.citations = citations; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String reply;
        private String modelUsed;
        private Double confidence;
        private String auditHash;
        private java.util.List<Object> citations;

        public Builder reply(String reply) {
            this.reply = reply;
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
        public Builder citations(java.util.List<Object> citations) {
            this.citations = citations;
            return this;
        }

        public ChatResponse build() {
            return new ChatResponse(this.reply, this.modelUsed, this.confidence, this.auditHash, this.citations);
        }
    }
}
