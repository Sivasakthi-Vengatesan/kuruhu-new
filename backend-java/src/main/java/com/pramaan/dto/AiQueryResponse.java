package com.pramaan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class AiQueryResponse {
    private String answer;
    private String reply;

    private List<CitationDto> sources = new ArrayList<>();

    private List<CitationDto> citations = new ArrayList<>();
    
    @JsonProperty("modelUsed")
    private String modelUsed;
    
    private double confidence;
    
    @JsonProperty("auditHash")
    private String auditHash;
    
    private AiFindingDto finding;


    public AiQueryResponse() {
    }

    public AiQueryResponse(String answer, String reply, List<CitationDto> sources, List<CitationDto> citations, String modelUsed, double confidence, String auditHash, AiFindingDto finding) {
        this.answer = answer;
        this.reply = reply;
        this.sources = sources;
        this.citations = citations;
        this.modelUsed = modelUsed;
        this.confidence = confidence;
        this.auditHash = auditHash;
        this.finding = finding;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public List<CitationDto> getSources() {
        return sources;
    }

    public void setSources(List<CitationDto> sources) {
        this.sources = sources;
    }

    public List<CitationDto> getCitations() {
        return citations;
    }

    public void setCitations(List<CitationDto> citations) {
        this.citations = citations;
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

    public AiFindingDto getFinding() {
        return finding;
    }

    public void setFinding(AiFindingDto finding) {
        this.finding = finding;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String answer;
        private String reply;
        private List<CitationDto> sources;
        private List<CitationDto> citations;
        private String modelUsed;
        private double confidence;
        private String auditHash;
        private AiFindingDto finding;

        public Builder answer(String answer) {
            this.answer = answer;
            return this;
        }
        public Builder reply(String reply) {
            this.reply = reply;
            return this;
        }
        public Builder sources(List<CitationDto> sources) {
            this.sources = sources;
            return this;
        }
        public Builder citations(List<CitationDto> citations) {
            this.citations = citations;
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
        public Builder finding(AiFindingDto finding) {
            this.finding = finding;
            return this;
        }

        public AiQueryResponse build() {
            return new AiQueryResponse(this.answer, this.reply, this.sources, this.citations, this.modelUsed, this.confidence, this.auditHash, this.finding);
        }
    }
}