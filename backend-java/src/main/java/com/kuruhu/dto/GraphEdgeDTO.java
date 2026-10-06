package com.kuruhu.dto;

import java.io.Serializable;

public class GraphEdgeDTO implements Serializable {

    private String id;
    private String source;
    private String target;
    private String label;
    private String relationshipType;
    private Double confidence;

    public GraphEdgeDTO() {}

    public GraphEdgeDTO(String id, String source, String target, String label, String relationshipType, Double confidence) {
        this.id = id;
        this.source = source;
        this.target = target;
        this.label = label;
        this.relationshipType = relationshipType;
        this.confidence = confidence;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getTarget() { return target; }
    public void setTarget(String target) { this.target = target; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public String getRelationshipType() { return relationshipType; }
    public void setRelationshipType(String relationshipType) { this.relationshipType = relationshipType; }

    public Double getConfidence() { return confidence; }
    public void setConfidence(Double confidence) { this.confidence = confidence; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String source;
        private String target;
        private String label;
        private String relationshipType;
        private Double confidence;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
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
        public Builder relationshipType(String relationshipType) {
            this.relationshipType = relationshipType;
            return this;
        }
        public Builder confidence(Double confidence) {
            this.confidence = confidence;
            return this;
        }

        public GraphEdgeDTO build() {
            return new GraphEdgeDTO(this.id, this.source, this.target, this.label, this.relationshipType, this.confidence);
        }
    }
}
