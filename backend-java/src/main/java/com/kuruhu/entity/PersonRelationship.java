package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personrelationships")
public class PersonRelationship implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sourcePersonId")
    private Long sourcePersonId;

    @Column(name = "targetPersonId")
    private Long targetPersonId;

    @Column(name = "relationshipType")
    private String relationshipType;

    @Column(name = "notes")
    private String notes;

    @Column(name = "confidenceScore")
    private Double confidenceScore;

    public PersonRelationship() {
    }

    public PersonRelationship(Long id, Long sourcePersonId, Long targetPersonId, String relationshipType, String notes, Double confidenceScore) {
        this.id = id;
        this.sourcePersonId = sourcePersonId;
        this.targetPersonId = targetPersonId;
        this.relationshipType = relationshipType;
        this.notes = notes;
        this.confidenceScore = confidenceScore;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getSourcePersonId() { return sourcePersonId; }
    public void setSourcePersonId(Long sourcePersonId) { this.sourcePersonId = sourcePersonId; }

    public Long getTargetPersonId() { return targetPersonId; }
    public void setTargetPersonId(Long targetPersonId) { this.targetPersonId = targetPersonId; }

    public String getRelationshipType() { return relationshipType; }
    public void setRelationshipType(String relationshipType) { this.relationshipType = relationshipType; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public Double getConfidenceScore() { return confidenceScore; }
    public void setConfidenceScore(Double confidenceScore) { this.confidenceScore = confidenceScore; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long sourcePersonId;
        private Long targetPersonId;
        private String relationshipType;
        private String notes;
        private Double confidenceScore;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder sourcePersonId(Long sourcePersonId) {
            this.sourcePersonId = sourcePersonId;
            return this;
        }
        public Builder targetPersonId(Long targetPersonId) {
            this.targetPersonId = targetPersonId;
            return this;
        }
        public Builder relationshipType(String relationshipType) {
            this.relationshipType = relationshipType;
            return this;
        }
        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }
        public Builder confidenceScore(Double confidenceScore) {
            this.confidenceScore = confidenceScore;
            return this;
        }

        public PersonRelationship build() {
            return new PersonRelationship(this.id, this.sourcePersonId, this.targetPersonId, this.relationshipType, this.notes, this.confidenceScore);
        }
    }
}
