package com.kuruhu.dto;

import java.io.Serializable;

public class PageResponseDTO implements Serializable {

    private java.util.List<Object> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean last;

    public PageResponseDTO() {}

    public PageResponseDTO(java.util.List<Object> content, int page, int size, long totalElements, int totalPages, boolean last) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.last = last;
    }

    public java.util.List<Object> getContent() { return content; }
    public void setContent(java.util.List<Object> content) { this.content = content; }

    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }

    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }

    public long getTotalElements() { return totalElements; }
    public void setTotalElements(long totalElements) { this.totalElements = totalElements; }

    public int getTotalPages() { return totalPages; }
    public void setTotalPages(int totalPages) { this.totalPages = totalPages; }

    public boolean getLast() { return last; }
    public void setLast(boolean last) { this.last = last; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private java.util.List<Object> content;
        private int page;
        private int size;
        private long totalElements;
        private int totalPages;
        private boolean last;

        public Builder content(java.util.List<Object> content) {
            this.content = content;
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
        public Builder totalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }
        public Builder totalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }
        public Builder last(boolean last) {
            this.last = last;
            return this;
        }

        public PageResponseDTO build() {
            return new PageResponseDTO(this.content, this.page, this.size, this.totalElements, this.totalPages, this.last);
        }
    }
}
