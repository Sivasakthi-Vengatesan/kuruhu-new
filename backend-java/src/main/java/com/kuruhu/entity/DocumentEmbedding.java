package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "documentembeddings")
public class DocumentEmbedding implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "documentType")
    private String documentType;

    @Column(name = "sourceId")
    private String sourceId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "embeddingVector")
    private String embeddingVector;

    @Column(name = "createdAt")
    private java.time.OffsetDateTime createdAt;

    public DocumentEmbedding() {
    }

    public DocumentEmbedding(Long id, String documentType, String sourceId, String title, String content, String embeddingVector, java.time.OffsetDateTime createdAt) {
        this.id = id;
        this.documentType = documentType;
        this.sourceId = sourceId;
        this.title = title;
        this.content = content;
        this.embeddingVector = embeddingVector;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDocumentType() { return documentType; }
    public void setDocumentType(String documentType) { this.documentType = documentType; }

    public String getSourceId() { return sourceId; }
    public void setSourceId(String sourceId) { this.sourceId = sourceId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getEmbeddingVector() { return embeddingVector; }
    public void setEmbeddingVector(String embeddingVector) { this.embeddingVector = embeddingVector; }

    public java.time.OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(java.time.OffsetDateTime createdAt) { this.createdAt = createdAt; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String documentType;
        private String sourceId;
        private String title;
        private String content;
        private String embeddingVector;
        private java.time.OffsetDateTime createdAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder documentType(String documentType) {
            this.documentType = documentType;
            return this;
        }
        public Builder sourceId(String sourceId) {
            this.sourceId = sourceId;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder content(String content) {
            this.content = content;
            return this;
        }
        public Builder embeddingVector(String embeddingVector) {
            this.embeddingVector = embeddingVector;
            return this;
        }
        public Builder createdAt(java.time.OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public DocumentEmbedding build() {
            return new DocumentEmbedding(this.id, this.documentType, this.sourceId, this.title, this.content, this.embeddingVector, this.createdAt);
        }
    }
}
