package com.kuruhu.dto;

import java.io.Serializable;

public class AIQueryResponse implements Serializable {

    private String answer;
    private String summary;
    private Double confidence;
    private String modelUsed;
    private String auditHash;
    private java.util.List<CitationDTO> citations;
    private java.util.List<String> relatedFirIds;
    private java.util.List<String> relatedPersonIds;

    public AIQueryResponse() {}

    public AIQueryResponse(String answer, String summary, Double confidence, String modelUsed, String auditHash, java.util.List<CitationDTO> citations, java.util.List<String> relatedFirIds, java.util.List<String> relatedPersonIds) {
        this.answer = answer;
        this.summary = summary;
        this.confidence = confidence;
        this.modelUsed = modelUsed;
        this.auditHash = auditHash;
        this.citations = citations;
        this.relatedFirIds = relatedFirIds;
        this.relatedPersonIds = relatedPersonIds;
    }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public Double getConfidence() { return confidence; }
    public void setConfidence(Double confidence) { this.confidence = confidence; }

    public String getModelUsed() { return modelUsed; }
    public void setModelUsed(String modelUsed) { this.modelUsed = modelUsed; }

    public String getAuditHash() { return auditHash; }
    public void setAuditHash(String auditHash) { this.auditHash = auditHash; }

    public java.util.List<CitationDTO> getCitations() { return citations; }
    public void setCitations(java.util.List<CitationDTO> citations) { this.citations = citations; }

    public java.util.List<String> getRelatedFirIds() { return relatedFirIds; }
    public void setRelatedFirIds(java.util.List<String> relatedFirIds) { this.relatedFirIds = relatedFirIds; }

    public java.util.List<String> getRelatedPersonIds() { return relatedPersonIds; }
    public void setRelatedPersonIds(java.util.List<String> relatedPersonIds) { this.relatedPersonIds = relatedPersonIds; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String answer;
        private String summary;
        private Double confidence;
        private String modelUsed;
        private String auditHash;
        private java.util.List<CitationDTO> citations;
        private java.util.List<String> relatedFirIds;
        private java.util.List<String> relatedPersonIds;

        public Builder answer(String answer) {
            this.answer = answer;
            return this;
        }
        public Builder summary(String summary) {
            this.summary = summary;
            return this;
        }
        public Builder confidence(Double confidence) {
            this.confidence = confidence;
            return this;
        }
        public Builder modelUsed(String modelUsed) {
            this.modelUsed = modelUsed;
            return this;
        }
        public Builder auditHash(String auditHash) {
            this.auditHash = auditHash;
            return this;
        }
        public Builder citations(java.util.List<CitationDTO> citations) {
            this.citations = citations;
            return this;
        }
        public Builder relatedFirIds(java.util.List<String> relatedFirIds) {
            this.relatedFirIds = relatedFirIds;
            return this;
        }
        public Builder relatedPersonIds(java.util.List<String> relatedPersonIds) {
            this.relatedPersonIds = relatedPersonIds;
            return this;
        }

        public AIQueryResponse build() {
            return new AIQueryResponse(this.answer, this.summary, this.confidence, this.modelUsed, this.auditHash, this.citations, this.relatedFirIds, this.relatedPersonIds);
        }
    }
}
