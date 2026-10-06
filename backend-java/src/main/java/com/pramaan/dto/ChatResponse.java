package com.pramaan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ChatResponse {
    private String reply;
    
    @JsonProperty("modelUsed")
    private String modelUsed;
    
    private double confidence;
    
    @JsonProperty("auditHash")
    private String auditHash;

    private List<CitationDto> sources = new ArrayList<>();


    public ChatResponse() {
    }

    public ChatResponse(String reply, String modelUsed, double confidence, String auditHash, List<CitationDto> sources) {
        this.reply = reply;
        this.modelUsed = modelUsed;
        this.confidence = confidence;
        this.auditHash = auditHash;
        this.sources = sources;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getModelUsed() {
        return modelUsed;
    }

    public void setModelUsed(String modelUsed) {
        this.modelUsed = modelUsed;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public String getAuditHash() {
        return auditHash;
    }

    public void setAuditHash(String auditHash) {
        this.auditHash = auditHash;
    }

    public List<CitationDto> getSources() {
        return sources;
    }

    public void setSources(List<CitationDto> sources) {
        this.sources = sources;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String reply;
        private String modelUsed;
        private double confidence;
        private String auditHash;
        private List<CitationDto> sources;

        public Builder reply(String reply) {
            this.reply = reply;
            return this;
        }
        public Builder modelUsed(String modelUsed) {
            this.modelUsed = modelUsed;
            return this;
        }
        public Builder confidence(double confidence) {
            this.confidence = confidence;
            return this;
        }
        public Builder auditHash(String auditHash) {
            this.auditHash = auditHash;
            return this;
        }
        public Builder sources(List<CitationDto> sources) {
            this.sources = sources;
            return this;
        }

        public ChatResponse build() {
            return new ChatResponse(this.reply, this.modelUsed, this.confidence, this.auditHash, this.sources);
        }
    }
}