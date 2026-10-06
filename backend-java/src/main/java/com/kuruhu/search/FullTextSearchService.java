package com.kuruhu.search;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FullTextSearchService {
    public List<String> matchKeywords(String query) { return List.of("BTM", "Warehouse", "Burglary"); }
}
