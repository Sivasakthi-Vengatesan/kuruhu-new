package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "investigationnotes")
public class InvestigationNote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "investigationId")
    private Long investigationId;

    @Column(name = "author")
    private String author;

    @Column(name = "noteContent")
    private String noteContent;

    @Column(name = "classification")
    private String classification;

    @Column(name = "createdAt")
    private java.time.OffsetDateTime createdAt;

    public InvestigationNote() {
    }

    public InvestigationNote(Long id, Long investigationId, String author, String noteContent, String classification, java.time.OffsetDateTime createdAt) {
        this.id = id;
        this.investigationId = investigationId;
        this.author = author;
        this.noteContent = noteContent;
        this.classification = classification;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getInvestigationId() { return investigationId; }
    public void setInvestigationId(Long investigationId) { this.investigationId = investigationId; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getNoteContent() { return noteContent; }
    public void setNoteContent(String noteContent) { this.noteContent = noteContent; }

    public String getClassification() { return classification; }
    public void setClassification(String classification) { this.classification = classification; }

    public java.time.OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(java.time.OffsetDateTime createdAt) { this.createdAt = createdAt; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long investigationId;
        private String author;
        private String noteContent;
        private String classification;
        private java.time.OffsetDateTime createdAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder investigationId(Long investigationId) {
            this.investigationId = investigationId;
            return this;
        }
        public Builder author(String author) {
            this.author = author;
            return this;
        }
        public Builder noteContent(String noteContent) {
            this.noteContent = noteContent;
            return this;
        }
        public Builder classification(String classification) {
            this.classification = classification;
            return this;
        }
        public Builder createdAt(java.time.OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public InvestigationNote build() {
            return new InvestigationNote(this.id, this.investigationId, this.author, this.noteContent, this.classification, this.createdAt);
        }
    }
}
