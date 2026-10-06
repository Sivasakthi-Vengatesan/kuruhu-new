package com.kuruhu.dto;

import java.io.Serializable;

public class GraphNodeDTO implements Serializable {

    private String id;
    private String label;
    private String name;
    private String type;
    private String role;
    private String risk;
    private java.util.Map<String, Object> attributes;

    public GraphNodeDTO() {}

    public GraphNodeDTO(String id, String label, String name, String type, String role, String risk, java.util.Map<String, Object> attributes) {
        this.id = id;
        this.label = label;
        this.name = name;
        this.type = type;
        this.role = role;
        this.risk = risk;
        this.attributes = attributes;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getRisk() { return risk; }
    public void setRisk(String risk) { this.risk = risk; }

    public java.util.Map<String, Object> getAttributes() { return attributes; }
    public void setAttributes(java.util.Map<String, Object> attributes) { this.attributes = attributes; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String label;
        private String name;
        private String type;
        private String role;
        private String risk;
        private java.util.Map<String, Object> attributes;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder label(String label) {
            this.label = label;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        public Builder role(String role) {
            this.role = role;
            return this;
        }
        public Builder risk(String risk) {
            this.risk = risk;
            return this;
        }
        public Builder attributes(java.util.Map<String, Object> attributes) {
            this.attributes = attributes;
            return this;
        }

        public GraphNodeDTO build() {
            return new GraphNodeDTO(this.id, this.label, this.name, this.type, this.role, this.risk, this.attributes);
        }
    }
}
