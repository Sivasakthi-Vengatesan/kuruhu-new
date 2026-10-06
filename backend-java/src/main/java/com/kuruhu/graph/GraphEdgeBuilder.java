package com.kuruhu.graph;

import com.kuruhu.dto.GraphEdgeDTO;
import org.springframework.stereotype.Component;

@Component
public class GraphEdgeBuilder {
    public GraphEdgeDTO createEdge(String source, String target, String rel) {
        return GraphEdgeDTO.builder().source(source).target(target).label(rel).build();
    }
}
