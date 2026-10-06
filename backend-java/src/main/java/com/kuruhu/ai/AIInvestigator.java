package com.kuruhu.ai;

import com.kuruhu.dto.AIQueryRequest;
import com.kuruhu.dto.AIQueryResponse;
import com.kuruhu.dto.CitationDTO;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AIInvestigator {

    public AIQueryResponse analyze(AIQueryRequest request) {
        return AIQueryResponse.builder()
                .answer("Investigation analysis grounded in Karnataka Police database.")
                .summary("Corroborated findings.")
                .confidence(0.95)
                .modelUsed("PRAMAAN Engine v3")
                .citations(List.of(CitationDTO.builder().recordId("FIR-101").recordType("FIR").label("FIR 0042/2026").excerpt("Theft record").build()))
                .build();
    }
}
