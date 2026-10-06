package com.kuruhu.ai;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Collections;

@Component
public class SemanticSearchEngine {
    public List<String> searchSimilarDocuments(String queryVector, int topK) {
        return Collections.emptyList();
    }
}
