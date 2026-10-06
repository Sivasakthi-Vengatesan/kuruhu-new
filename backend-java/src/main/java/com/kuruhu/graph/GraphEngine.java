package com.kuruhu.graph;

import com.kuruhu.dto.GraphResponse;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class GraphEngine {
    public GraphResponse generateGraphForPerson(Long personId) {
        return GraphResponse.builder().nodes(List.of()).edges(List.of()).build();
    }
}
