package com.pramaan.dto;


import java.util.ArrayList;
import java.util.List;

public class SearchResponse {
    private String query;
    private int totalResults;

    private List<SearchResultItem> items = new ArrayList<>();


    public SearchResponse() {
    }

    public SearchResponse(String query, int totalResults, List<SearchResultItem> items) {
        this.query = query;
        this.totalResults = totalResults;
        this.items = items;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<SearchResultItem> getItems() {
        return items;
    }

    public void setItems(List<SearchResultItem> items) {
        this.items = items;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String query;
        private int totalResults;
        private List<SearchResultItem> items;

        public Builder query(String query) {
            this.query = query;
            return this;
        }
        public Builder totalResults(int totalResults) {
            this.totalResults = totalResults;
            return this;
        }
        public Builder items(List<SearchResultItem> items) {
            this.items = items;
            return this;
        }

        public SearchResponse build() {
            return new SearchResponse(this.query, this.totalResults, this.items);
        }
    }
}