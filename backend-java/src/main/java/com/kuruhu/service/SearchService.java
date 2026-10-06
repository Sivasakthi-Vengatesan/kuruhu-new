package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface SearchService {
    SearchResponse searchDatabase(SearchRequest request);
    SearchResponse semanticSearch(String query, int limit);
}
