package com.pramaan.controller;

import com.pramaan.dto.SearchResponse;
import com.pramaan.service.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/search")
@Tag(name = "Global Search", description = "Unified search across FIRs, persons, vehicles, and locations")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }


    @GetMapping
    @Operation(summary = "Search across all entities in database")
    public ResponseEntity<SearchResponse> search(@RequestParam(required = false, defaultValue = "") String query) {
        return ResponseEntity.ok(searchService.search(query));
    }
}