package com.kuruhu.service.impl;

import com.kuruhu.service.GraphService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GraphServiceImpl implements GraphService {

    @Override
    public GraphResponse getInvestigationNetwork(Long personId) {
        return GraphResponse.builder()
                .nodes(List.of(GraphNodeDTO.builder().id("P-1001").label("Ravi Kumar S").type("Person").role("accused").risk("high").build()))
                .edges(List.of())
                .build();
    }

    @Override
    public GraphResponse getCaseGraph(Long caseId) {
        return GraphResponse.builder()
                .nodes(List.of(GraphNodeDTO.builder().id("P-1001").label("Ravi Kumar S").type("Person").role("accused").risk("high").build()))
                .edges(List.of())
                .build();
    }
}
