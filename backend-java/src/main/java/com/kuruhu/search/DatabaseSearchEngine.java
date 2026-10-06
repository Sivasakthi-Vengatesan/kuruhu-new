package com.kuruhu.search;

import com.kuruhu.dto.SearchResultItem;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DatabaseSearchEngine {
    public List<SearchResultItem> executeTextSearch(String term) {
        return List.of(SearchResultItem.builder().id("101").title("FIR 0042/2026").type("FIR").build());
    }
}
