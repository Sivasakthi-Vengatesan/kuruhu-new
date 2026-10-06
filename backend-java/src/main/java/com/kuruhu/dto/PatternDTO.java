package com.kuruhu.dto;

import java.io.Serializable;

public class PatternDTO implements Serializable {

    private String id;
    private String patternCode;
    private String title;
    private String modusOperandi;
    private int firCount;
    private String suspectProfileSummary;

    public PatternDTO() {}

    public PatternDTO(String id, String patternCode, String title, String modusOperandi, int firCount, String suspectProfileSummary) {
        this.id = id;
        this.patternCode = patternCode;
        this.title = title;
        this.modusOperandi = modusOperandi;
        this.firCount = firCount;
        this.suspectProfileSummary = suspectProfileSummary;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPatternCode() { return patternCode; }
    public void setPatternCode(String patternCode) { this.patternCode = patternCode; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getModusOperandi() { return modusOperandi; }
    public void setModusOperandi(String modusOperandi) { this.modusOperandi = modusOperandi; }

    public int getFirCount() { return firCount; }
    public void setFirCount(int firCount) { this.firCount = firCount; }

    public String getSuspectProfileSummary() { return suspectProfileSummary; }
    public void setSuspectProfileSummary(String suspectProfileSummary) { this.suspectProfileSummary = suspectProfileSummary; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String patternCode;
        private String title;
        private String modusOperandi;
        private int firCount;
        private String suspectProfileSummary;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder patternCode(String patternCode) {
            this.patternCode = patternCode;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder modusOperandi(String modusOperandi) {
            this.modusOperandi = modusOperandi;
            return this;
        }
        public Builder firCount(int firCount) {
            this.firCount = firCount;
            return this;
        }
        public Builder suspectProfileSummary(String suspectProfileSummary) {
            this.suspectProfileSummary = suspectProfileSummary;
            return this;
        }

        public PatternDTO build() {
            return new PatternDTO(this.id, this.patternCode, this.title, this.modusOperandi, this.firCount, this.suspectProfileSummary);
        }
    }
}
