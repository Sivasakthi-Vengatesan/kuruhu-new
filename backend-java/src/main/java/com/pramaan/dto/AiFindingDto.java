package com.pramaan.dto;


import java.util.ArrayList;
import java.util.List;

public class AiFindingDto {
    private String id;
    private String question;
    private String title;
    private String summary;
    private double confidence;
    private String status; // verified, pending, rejected
    private String risk; // high, medium, low

    private List<CitationDto> citations = new ArrayList<>();

    private List<String> relatedFirIds = new ArrayList<>();

    private List<String> relatedPersonIds = new ArrayList<>();

    private List<String> detectedRelationships = new ArrayList<>();
    
    private String generatedAt;
    private String verifiedBy;


    public AiFindingDto() {
    }

    public AiFindingDto(String id, String question, String title, String summary, double confidence, String status, String risk, List<CitationDto> citations, List<String> relatedFirIds, List<String> relatedPersonIds, List<String> detectedRelationships, String generatedAt, String verifiedBy) {
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
        this.detectedRelationships = detectedRelationships;
        this.generatedAt = generatedAt;
        this.verifiedBy = verifiedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public List<CitationDto> getCitations() {
        return citations;
    }

    public void setCitations(List<CitationDto> citations) {
        this.citations = citations;
    }

    public List<String> getRelatedFirIds() {
        return relatedFirIds;
    }

    public void setRelatedFirIds(List<String> relatedFirIds) {
        this.relatedFirIds = relatedFirIds;
    }

    public List<String> getRelatedPersonIds() {
        return relatedPersonIds;
    }

    public void setRelatedPersonIds(List<String> relatedPersonIds) {
        this.relatedPersonIds = relatedPersonIds;
    }

    public List<String> getDetectedRelationships() {
        return detectedRelationships;
    }

    public void setDetectedRelationships(List<String> detectedRelationships) {
        this.detectedRelationships = detectedRelationships;
    }

    public String getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(String generatedAt) {
        this.generatedAt = generatedAt;
    }

    public String getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String question;
        private String title;
        private String summary;
        private double confidence;
        private String status;
        private String risk;
        private List<CitationDto> citations;
        private List<String> relatedFirIds;
        private List<String> relatedPersonIds;
        private List<String> detectedRelationships;
        private String generatedAt;
        private String verifiedBy;

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
        public Builder confidence(double confidence) {
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
        public Builder citations(List<CitationDto> citations) {
            this.citations = citations;
            return this;
        }
        public Builder relatedFirIds(List<String> relatedFirIds) {
            this.relatedFirIds = relatedFirIds;
            return this;
        }
        public Builder relatedPersonIds(List<String> relatedPersonIds) {
            this.relatedPersonIds = relatedPersonIds;
            return this;
        }
        public Builder detectedRelationships(List<String> detectedRelationships) {
            this.detectedRelationships = detectedRelationships;
            return this;
        }
        public Builder generatedAt(String generatedAt) {
            this.generatedAt = generatedAt;
            return this;
        }
        public Builder verifiedBy(String verifiedBy) {
            this.verifiedBy = verifiedBy;
            return this;
        }

        public AiFindingDto build() {
            return new AiFindingDto(this.id, this.question, this.title, this.summary, this.confidence, this.status, this.risk, this.citations, this.relatedFirIds, this.relatedPersonIds, this.detectedRelationships, this.generatedAt, this.verifiedBy);
        }
    }
}