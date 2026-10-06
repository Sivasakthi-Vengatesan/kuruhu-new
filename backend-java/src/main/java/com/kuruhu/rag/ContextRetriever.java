package com.kuruhu.rag;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ContextRetriever {
    public List<String> retrieveRelevantSnippets(String query) {
        return List.of("FIR 0042/2026: Commercial Burglary", "Person P-1001: Ravi Kumar S");
    }
}
