package com.kuruhu.dto;

import java.io.Serializable;

public class GraphResponse implements Serializable {

    private java.util.List<GraphNodeDTO> nodes;
    private java.util.List<GraphEdgeDTO> edges;

    public GraphResponse() {}

    public GraphResponse(java.util.List<GraphNodeDTO> nodes, java.util.List<GraphEdgeDTO> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public java.util.List<GraphNodeDTO> getNodes() { return nodes; }
    public void setNodes(java.util.List<GraphNodeDTO> nodes) { this.nodes = nodes; }

    public java.util.List<GraphEdgeDTO> getEdges() { return edges; }
    public void setEdges(java.util.List<GraphEdgeDTO> edges) { this.edges = edges; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private java.util.List<GraphNodeDTO> nodes;
        private java.util.List<GraphEdgeDTO> edges;

        public Builder nodes(java.util.List<GraphNodeDTO> nodes) {
            this.nodes = nodes;
            return this;
        }
        public Builder edges(java.util.List<GraphEdgeDTO> edges) {
            this.edges = edges;
            return this;
        }

        public GraphResponse build() {
            return new GraphResponse(this.nodes, this.edges);
        }
    }
}
