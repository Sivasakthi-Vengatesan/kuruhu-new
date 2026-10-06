package com.pramaan.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "ai_findings")
public class AiFinding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "finding_code", unique = true, length = 50)
    private String findingCode;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String question;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String summary;

    @Column(precision = 4, scale = 3)
    private BigDecimal confidence = new BigDecimal("0.900");

    @Column(length = 50)
    private String status = "pending"; // verified, pending, rejected

    @Column(length = 50)
    private String risk = "medium"; // high, medium, low

    @Column(columnDefinition = "JSONB")
    private String citations; // JSON list of citations

    @Column(name = "related_fir_ids", columnDefinition = "JSONB")
    private String relatedFirIds;

    @Column(name = "related_person_ids", columnDefinition = "JSONB")
    private String relatedPersonIds;

    @Column(name = "detected_relationships", columnDefinition = "JSONB")
    private String detectedRelationships;

    @Column(name = "verified_by", length = 150)
    private String verifiedBy;

    @CreationTimestamp
    @Column(name = "generated_at", updatable = false)
    private OffsetDateTime generatedAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;


    public AiFinding() {
    }

    public AiFinding(Long id, String findingCode, String question, String title, String summary, BigDecimal confidence, String status, String risk, String citations, String relatedFirIds, String relatedPersonIds, String detectedRelationships, String verifiedBy, OffsetDateTime generatedAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.findingCode = findingCode;
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
        this.verifiedBy = verifiedBy;
        this.generatedAt = generatedAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFindingCode() {
        return findingCode;
    }

    public void setFindingCode(String findingCode) {
        this.findingCode = findingCode;
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

    public BigDecimal getConfidence() {
        return confidence;
    }

    public void setConfidence(BigDecimal confidence) {
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

    public String getCitations() {
        return citations;
    }

    public void setCitations(String citations) {
        this.citations = citations;
    }

    public String getRelatedFirIds() {
        return relatedFirIds;
    }

    public void setRelatedFirIds(String relatedFirIds) {
        this.relatedFirIds = relatedFirIds;
    }

    public String getRelatedPersonIds() {
        return relatedPersonIds;
    }

    public void setRelatedPersonIds(String relatedPersonIds) {
        this.relatedPersonIds = relatedPersonIds;
    }

    public String getDetectedRelationships() {
        return detectedRelationships;
    }

    public void setDetectedRelationships(String detectedRelationships) {
        this.detectedRelationships = detectedRelationships;
    }

    public String getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public OffsetDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(OffsetDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String findingCode;
        private String question;
        private String title;
        private String summary;
        private BigDecimal confidence;
        private String status;
        private String risk;
        private String citations;
        private String relatedFirIds;
        private String relatedPersonIds;
        private String detectedRelationships;
        private String verifiedBy;
        private OffsetDateTime generatedAt;
        private OffsetDateTime updatedAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder findingCode(String findingCode) {
            this.findingCode = findingCode;
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
        public Builder confidence(BigDecimal confidence) {
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
        public Builder citations(String citations) {
            this.citations = citations;
            return this;
        }
        public Builder relatedFirIds(String relatedFirIds) {
            this.relatedFirIds = relatedFirIds;
            return this;
        }
        public Builder relatedPersonIds(String relatedPersonIds) {
            this.relatedPersonIds = relatedPersonIds;
            return this;
        }
        public Builder detectedRelationships(String detectedRelationships) {
            this.detectedRelationships = detectedRelationships;
            return this;
        }
        public Builder verifiedBy(String verifiedBy) {
            this.verifiedBy = verifiedBy;
            return this;
        }
        public Builder generatedAt(OffsetDateTime generatedAt) {
            this.generatedAt = generatedAt;
            return this;
        }
        public Builder updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public AiFinding build() {
            return new AiFinding(this.id, this.findingCode, this.question, this.title, this.summary, this.confidence, this.status, this.risk, this.citations, this.relatedFirIds, this.relatedPersonIds, this.detectedRelationships, this.verifiedBy, this.generatedAt, this.updatedAt);
        }
    }
}