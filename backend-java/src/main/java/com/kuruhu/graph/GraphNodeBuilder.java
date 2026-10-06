package com.kuruhu.graph;

import com.kuruhu.dto.GraphNodeDTO;
import org.springframework.stereotype.Component;

@Component
public class GraphNodeBuilder {
    public GraphNodeDTO createNode(String id, String label, String type) {
        return GraphNodeDTO.builder().id(id).label(label).type(type).build();
    }
}
