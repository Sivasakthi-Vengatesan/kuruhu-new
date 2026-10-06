package com.pramaan.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "document_embeddings")
public class DocumentEmbedding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "document_type", nullable = false, length = 50)
    private String documentType; // fir, person, evidence, finding, pattern

    @Column(name = "source_id", nullable = false, length = 100)
    private String sourceId;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(columnDefinition = "JSONB")
    private String metadata;

    @Column(columnDefinition = "vector(384)")
    private String embedding;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;


    public DocumentEmbedding() {
    }

    public DocumentEmbedding(Long id, String documentType, String sourceId, String title, String content, String metadata, String embedding, OffsetDateTime createdAt) {
        this.id = id;
        this.documentType = documentType;
        this.sourceId = sourceId;
        this.title = title;
        this.content = content;
        this.metadata = metadata;
        this.embedding = embedding;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String getEmbedding() {
        return embedding;
    }

    public void setEmbedding(String embedding) {
        this.embedding = embedding;
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
        private String documentType;
        private String sourceId;
        private String title;
        private String content;
        private String metadata;
        private String embedding;
        private OffsetDateTime createdAt;

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
        public Builder metadata(String metadata) {
            this.metadata = metadata;
            return this;
        }
        public Builder embedding(String embedding) {
            this.embedding = embedding;
            return this;
        }
        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public DocumentEmbedding build() {
            return new DocumentEmbedding(this.id, this.documentType, this.sourceId, this.title, this.content, this.metadata, this.embedding, this.createdAt);
        }
    }
}