package com.kuruhu.dto;

import java.io.Serializable;

public class AIFindingDTO implements Serializable {

    private String id;
    private String question;
    private String title;
    private String summary;
    private Double confidence;
    private String status;
    private String risk;
    private java.util.List<CitationDTO> citations;
    private java.util.List<String> relatedFirIds;
    private java.util.List<String> relatedPersonIds;
    private String generatedAt;

    public AIFindingDTO() {}

    public AIFindingDTO(String id, String question, String title, String summary, Double confidence, String status, String risk, java.util.List<CitationDTO> citations, java.util.List<String> relatedFirIds, java.util.List<String> relatedPersonIds, String generatedAt) {
        this.id = id;
        this.question = question;
        this.title = title;
        this.summary = summary;
        this.confidence = confidence;
        this.status = status;
        this.risk = risk;
        this.citations = citations;
        this.relatedFirIds = relatedFirIds;
        this.relatedPersonIds = relatedPersonIds;
        this.generatedAt = generatedAt;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public Double getConfidence() { return confidence; }
    public void setConfidence(Double confidence) { this.confidence = confidence; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRisk() { return risk; }
    public void setRisk(String risk) { this.risk = risk; }

    public java.util.List<CitationDTO> getCitations() { return citations; }
    public void setCitations(java.util.List<CitationDTO> citations) { this.citations = citations; }

    public java.util.List<String> getRelatedFirIds() { return relatedFirIds; }
    public void setRelatedFirIds(java.util.List<String> relatedFirIds) { this.relatedFirIds = relatedFirIds; }

    public java.util.List<String> getRelatedPersonIds() { return relatedPersonIds; }
    public void setRelatedPersonIds(java.util.List<String> relatedPersonIds) { this.relatedPersonIds = relatedPersonIds; }

    public String getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(String generatedAt) { this.generatedAt = generatedAt; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String question;
        private String title;
        private String summary;
        private Double confidence;
        private String status;
        private String risk;
        private java.util.List<CitationDTO> citations;
        private java.util.List<String> relatedFirIds;
        private java.util.List<String> relatedPersonIds;
        private String generatedAt;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder question(String question) {
            this.question = question;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
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
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        public Builder risk(String risk) {
            this.risk = risk;
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
        public Builder generatedAt(String generatedAt) {
            this.generatedAt = generatedAt;
            return this;
        }

        public AIFindingDTO build() {
            return new AIFindingDTO(this.id, this.question, this.title, this.summary, this.confidence, this.status, this.risk, this.citations, this.relatedFirIds, this.relatedPersonIds, this.generatedAt);
        }
    }
}
