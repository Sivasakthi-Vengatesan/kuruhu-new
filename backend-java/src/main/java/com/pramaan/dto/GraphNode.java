package com.pramaan.dto;


public class GraphNode {
    private String id;
    private String kind; // fir, person, vehicle, location, evidence, officer
    private String label;
    private String sub;
    private String href;
    private double x;
    private double y;


    public GraphNode() {
    }

    public GraphNode(String id, String kind, String label, String sub, String href, double x, double y) {
        this.id = id;
        this.kind = kind;
        this.label = label;
        this.sub = sub;
        this.href = href;
        this.x = x;
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String kind;
        private String label;
        private String sub;
        private String href;
        private double x;
        private double y;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder kind(String kind) {
            this.kind = kind;
            return this;
        }
        public Builder label(String label) {
            this.label = label;
            return this;
        }
        public Builder sub(String sub) {
            this.sub = sub;
            return this;
        }
        public Builder href(String href) {
            this.href = href;
            return this;
        }
        public Builder x(double x) {
            this.x = x;
            return this;
        }
        public Builder y(double y) {
            this.y = y;
            return this;
        }

        public GraphNode build() {
            return new GraphNode(this.id, this.kind, this.label, this.sub, this.href, this.x, this.y);
        }
    }
}