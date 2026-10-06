package com.pramaan.dto;


import java.util.ArrayList;
import java.util.List;

public class GraphResponse {

    private List<GraphNode> nodes = new ArrayList<>();

    private List<GraphEdge> edges = new ArrayList<>();


    public GraphResponse() {
    }

    public GraphResponse(List<GraphNode> nodes, List<GraphEdge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public List<GraphNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public List<GraphEdge> getEdges() {
        return edges;
    }

    public void setEdges(List<GraphEdge> edges) {
        this.edges = edges;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<GraphNode> nodes;
        private List<GraphEdge> edges;

        public Builder nodes(List<GraphNode> nodes) {
            this.nodes = nodes;
            return this;
        }
        public Builder edges(List<GraphEdge> edges) {
            this.edges = edges;
            return this;
        }

        public GraphResponse build() {
            return new GraphResponse(this.nodes, this.edges);
        }
    }
}