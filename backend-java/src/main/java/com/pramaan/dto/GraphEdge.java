package com.pramaan.dto;


public class GraphEdge {
    private String source;
    private String target;
    private String label;
    private String firRef;
    private boolean verified;


    public GraphEdge() {
    }

    public GraphEdge(String source, String target, String label, String firRef, boolean verified) {
        this.source = source;
        this.target = target;
        this.label = label;
        this.firRef = firRef;
        this.verified = verified;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFirRef() {
        return firRef;
    }

    public void setFirRef(String firRef) {
        this.firRef = firRef;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String source;
        private String target;
        private String label;
        private String firRef;
        private boolean verified;

        public Builder source(String source) {
            this.source = source;
            return this;
        }
        public Builder target(String target) {
            this.target = target;
            return this;
        }
        public Builder label(String label) {
            this.label = label;
            return this;
        }
        public Builder firRef(String firRef) {
            this.firRef = firRef;
            return this;
        }
        public Builder verified(boolean verified) {
            this.verified = verified;
            return this;
        }

        public GraphEdge build() {
            return new GraphEdge(this.source, this.target, this.label, this.firRef, this.verified);
        }
    }
}