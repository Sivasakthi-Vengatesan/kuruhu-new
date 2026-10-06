package com.kuruhu.controller;

import com.kuruhu.dto.SearchRequest;
import com.kuruhu.dto.SearchResponse;
import com.kuruhu.service.SearchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/search")
@Tag(name = "Search", description = "Global database & semantic vector search")
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) { this.searchService = searchService; }

    @GetMapping
    public ResponseEntity<SearchResponse> search(@RequestParam String query, @RequestParam(defaultValue = "all") String type, @RequestParam(defaultValue = "all") String district, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
        SearchRequest req = SearchRequest.builder().query(query).type(type).district(district).page(page).size(size).build();
        return ResponseEntity.ok(searchService.searchDatabase(req));
    }
}
