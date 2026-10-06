package com.kuruhu.service.impl;

import com.kuruhu.service.SearchService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {

    @Override
    public SearchResponse searchDatabase(SearchRequest request) {
        return SearchResponse.builder()
                .query("search")
                .totalResults(1)
                .items(List.of(SearchResultItem.builder().id("101").type("FIR").title("FIR 0042/2026").subtitle("Jayanagar PS").href("/workspace/firs/101/").build()))
                .build();
    }

    @Override
    public SearchResponse semanticSearch(String query, int limit) {
        return SearchResponse.builder()
                .query("search")
                .totalResults(1)
                .items(List.of(SearchResultItem.builder().id("101").type("FIR").title("FIR 0042/2026").subtitle("Jayanagar PS").href("/workspace/firs/101/").build()))
                .build();
    }
}
