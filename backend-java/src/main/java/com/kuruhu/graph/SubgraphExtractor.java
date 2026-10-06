package com.kuruhu.graph;

import com.kuruhu.dto.GraphResponse;
import org.springframework.stereotype.Component;

@Component
public class SubgraphExtractor {
    public GraphResponse extractDepth(Long centerId, int depth) {
        return GraphResponse.builder().build();
    }
}
