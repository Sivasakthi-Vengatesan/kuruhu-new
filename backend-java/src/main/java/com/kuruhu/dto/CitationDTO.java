package com.kuruhu.dto;

import java.io.Serializable;

public class CitationDTO implements Serializable {

    private String recordId;
    private String recordType;
    private String label;
    private String excerpt;

    public CitationDTO() {}

    public CitationDTO(String recordId, String recordType, String label, String excerpt) {
        this.recordId = recordId;
        this.recordType = recordType;
        this.label = label;
        this.excerpt = excerpt;
    }

    public String getRecordId() { return recordId; }
    public void setRecordId(String recordId) { this.recordId = recordId; }

    public String getRecordType() { return recordType; }
    public void setRecordType(String recordType) { this.recordType = recordType; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public String getExcerpt() { return excerpt; }
    public void setExcerpt(String excerpt) { this.excerpt = excerpt; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String recordId;
        private String recordType;
        private String label;
        private String excerpt;

        public Builder recordId(String recordId) {
            this.recordId = recordId;
            return this;
        }
        public Builder recordType(String recordType) {
            this.recordType = recordType;
            return this;
        }
        public Builder label(String label) {
            this.label = label;
            return this;
        }
        public Builder excerpt(String excerpt) {
            this.excerpt = excerpt;
            return this;
        }

        public CitationDTO build() {
            return new CitationDTO(this.recordId, this.recordType, this.label, this.excerpt);
        }
    }
}
