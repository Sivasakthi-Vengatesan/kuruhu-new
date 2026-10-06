package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "documents")
public class Document implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "documentNumber")
    private String documentNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "documentType")
    private String documentType;

    @Column(name = "fileUrl")
    private String fileUrl;

    @Column(name = "uploadedBy")
    private String uploadedBy;

    @Column(name = "fileSize")
    private Long fileSize;

    @Column(name = "uploadedAt")
    private java.time.OffsetDateTime uploadedAt;

    public Document() {
    }

    public Document(Long id, String documentNumber, String title, String documentType, String fileUrl, String uploadedBy, Long fileSize, java.time.OffsetDateTime uploadedAt) {
        this.id = id;
        this.documentNumber = documentNumber;
        this.title = title;
        this.documentType = documentType;
        this.fileUrl = fileUrl;
        this.uploadedBy = uploadedBy;
        this.fileSize = fileSize;
        this.uploadedAt = uploadedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDocumentNumber() { return documentNumber; }
    public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDocumentType() { return documentType; }
    public void setDocumentType(String documentType) { this.documentType = documentType; }

    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }

    public String getUploadedBy() { return uploadedBy; }
    public void setUploadedBy(String uploadedBy) { this.uploadedBy = uploadedBy; }

    public Long getFileSize() { return fileSize; }
    public void setFileSize(Long fileSize) { this.fileSize = fileSize; }

    public java.time.OffsetDateTime getUploadedAt() { return uploadedAt; }
    public void setUploadedAt(java.time.OffsetDateTime uploadedAt) { this.uploadedAt = uploadedAt; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String documentNumber;
        private String title;
        private String documentType;
        private String fileUrl;
        private String uploadedBy;
        private Long fileSize;
        private java.time.OffsetDateTime uploadedAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder documentNumber(String documentNumber) {
            this.documentNumber = documentNumber;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder documentType(String documentType) {
            this.documentType = documentType;
            return this;
        }
        public Builder fileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
            return this;
        }
        public Builder uploadedBy(String uploadedBy) {
            this.uploadedBy = uploadedBy;
            return this;
        }
        public Builder fileSize(Long fileSize) {
            this.fileSize = fileSize;
            return this;
        }
        public Builder uploadedAt(java.time.OffsetDateTime uploadedAt) {
            this.uploadedAt = uploadedAt;
            return this;
        }

        public Document build() {
            return new Document(this.id, this.documentNumber, this.title, this.documentType, this.fileUrl, this.uploadedBy, this.fileSize, this.uploadedAt);
        }
    }
}
