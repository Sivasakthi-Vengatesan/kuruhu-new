package com.kuruhu.dto;

import java.io.Serializable;

public class SearchRequest implements Serializable {

    private String query;
    private String type;
    private String district;
    private int page;
    private int size;

    public SearchRequest() {}

    public SearchRequest(String query, String type, String district, int page, int size) {
        this.query = query;
        this.type = type;
        this.district = district;
        this.page = page;
        this.size = size;
    }

    public String getQuery() { return query; }
    public void setQuery(String query) { this.query = query; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }

    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String query;
        private String type;
        private String district;
        private int page;
        private int size;

        public Builder query(String query) {
            this.query = query;
            return this;
        }
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        public Builder district(String district) {
            this.district = district;
            return this;
        }
        public Builder page(int page) {
            this.page = page;
            return this;
        }
        public Builder size(int size) {
            this.size = size;
            return this;
        }

        public SearchRequest build() {
            return new SearchRequest(this.query, this.type, this.district, this.page, this.size);
        }
    }
}
