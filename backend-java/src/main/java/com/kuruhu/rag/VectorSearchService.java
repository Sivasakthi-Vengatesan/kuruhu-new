package com.kuruhu.rag;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VectorSearchService {
    public List<String> findNearestRecords(String vector, int limit) {
        return List.of("RECORD-101", "RECORD-102");
    }
}
