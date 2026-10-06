package com.kuruhu.dto;

import java.io.Serializable;

public class SearchResponse implements Serializable {

    private String query;
    private int totalResults;
    private java.util.List<SearchResultItem> items;

    public SearchResponse() {}

    public SearchResponse(String query, int totalResults, java.util.List<SearchResultItem> items) {
        this.query = query;
        this.totalResults = totalResults;
        this.items = items;
    }

    public String getQuery() { return query; }
    public void setQuery(String query) { this.query = query; }

    public int getTotalResults() { return totalResults; }
    public void setTotalResults(int totalResults) { this.totalResults = totalResults; }

    public java.util.List<SearchResultItem> getItems() { return items; }
    public void setItems(java.util.List<SearchResultItem> items) { this.items = items; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String query;
        private int totalResults;
        private java.util.List<SearchResultItem> items;

        public Builder query(String query) {
            this.query = query;
            return this;
        }
        public Builder totalResults(int totalResults) {
            this.totalResults = totalResults;
            return this;
        }
        public Builder items(java.util.List<SearchResultItem> items) {
            this.items = items;
            return this;
        }

        public SearchResponse build() {
            return new SearchResponse(this.query, this.totalResults, this.items);
        }
    }
}
