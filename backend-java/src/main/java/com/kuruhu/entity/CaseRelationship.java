package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "caserelationships")
public class CaseRelationship implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sourceCaseId")
    private Long sourceCaseId;

    @Column(name = "targetCaseId")
    private Long targetCaseId;

    @Column(name = "linkageType")
    private String linkageType;

    @Column(name = "description")
    private String description;

    @Column(name = "similarityScore")
    private Double similarityScore;

    public CaseRelationship() {
    }

    public CaseRelationship(Long id, Long sourceCaseId, Long targetCaseId, String linkageType, String description, Double similarityScore) {
        this.id = id;
        this.sourceCaseId = sourceCaseId;
        this.targetCaseId = targetCaseId;
        this.linkageType = linkageType;
        this.description = description;
        this.similarityScore = similarityScore;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getSourceCaseId() { return sourceCaseId; }
    public void setSourceCaseId(Long sourceCaseId) { this.sourceCaseId = sourceCaseId; }

    public Long getTargetCaseId() { return targetCaseId; }
    public void setTargetCaseId(Long targetCaseId) { this.targetCaseId = targetCaseId; }

    public String getLinkageType() { return linkageType; }
    public void setLinkageType(String linkageType) { this.linkageType = linkageType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getSimilarityScore() { return similarityScore; }
    public void setSimilarityScore(Double similarityScore) { this.similarityScore = similarityScore; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long sourceCaseId;
        private Long targetCaseId;
        private String linkageType;
        private String description;
        private Double similarityScore;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder sourceCaseId(Long sourceCaseId) {
            this.sourceCaseId = sourceCaseId;
            return this;
        }
        public Builder targetCaseId(Long targetCaseId) {
            this.targetCaseId = targetCaseId;
            return this;
        }
        public Builder linkageType(String linkageType) {
            this.linkageType = linkageType;
            return this;
        }
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        public Builder similarityScore(Double similarityScore) {
            this.similarityScore = similarityScore;
            return this;
        }

        public CaseRelationship build() {
            return new CaseRelationship(this.id, this.sourceCaseId, this.targetCaseId, this.linkageType, this.description, this.similarityScore);
        }
    }
}
