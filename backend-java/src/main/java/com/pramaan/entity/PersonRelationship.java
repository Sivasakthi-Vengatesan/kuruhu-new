package com.pramaan.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "person_relationships")
public class PersonRelationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "related_person_id", nullable = false)
    private Person relatedPerson;

    @Column(name = "relationship_label", nullable = false, length = 100)
    private String relationshipLabel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fir_reference_id")
    private Fir firReference;

    @Column(name = "is_verified")
    private Boolean isVerified = true;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;


    public PersonRelationship() {
    }

    public PersonRelationship(Long id, Person person, Person relatedPerson, String relationshipLabel, Fir firReference, Boolean isVerified, OffsetDateTime createdAt) {
        this.id = id;
        this.person = person;
        this.relatedPerson = relatedPerson;
        this.relationshipLabel = relationshipLabel;
        this.firReference = firReference;
        this.isVerified = isVerified;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getRelatedPerson() {
        return relatedPerson;
    }

    public void setRelatedPerson(Person relatedPerson) {
        this.relatedPerson = relatedPerson;
    }

    public String getRelationshipLabel() {
        return relationshipLabel;
    }

    public void setRelationshipLabel(String relationshipLabel) {
        this.relationshipLabel = relationshipLabel;
    }

    public Fir getFirReference() {
        return firReference;
    }

    public void setFirReference(Fir firReference) {
        this.firReference = firReference;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Person person;
        private Person relatedPerson;
        private String relationshipLabel;
        private Fir firReference;
        private Boolean isVerified;
        private OffsetDateTime createdAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder person(Person person) {
            this.person = person;
            return this;
        }
        public Builder relatedPerson(Person relatedPerson) {
            this.relatedPerson = relatedPerson;
            return this;
        }
        public Builder relationshipLabel(String relationshipLabel) {
            this.relationshipLabel = relationshipLabel;
            return this;
        }
        public Builder firReference(Fir firReference) {
            this.firReference = firReference;
            return this;
        }
        public Builder isVerified(Boolean isVerified) {
            this.isVerified = isVerified;
            return this;
        }
        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PersonRelationship build() {
            return new PersonRelationship(this.id, this.person, this.relatedPerson, this.relationshipLabel, this.firReference, this.isVerified, this.createdAt);
        }
    }
}