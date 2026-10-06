package com.kuruhu.graph;

import com.kuruhu.dto.GraphResponse;
import org.springframework.stereotype.Service;

@Service
public class NetworkGraphService {
    public GraphResponse getFullNetwork() {
        return GraphResponse.builder().build();
    }
}
