package com.pramaan.dto;


public class SearchResultItem {
    private String key;
    private String kind; // FIR, Person, Vehicle, Location
    private String title;
    private String subtitle;
    private String href;


    public SearchResultItem() {
    }

    public SearchResultItem(String key, String kind, String title, String subtitle, String href) {
        this.key = key;
        this.kind = kind;
        this.title = title;
        this.subtitle = subtitle;
        this.href = href;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String key;
        private String kind;
        private String title;
        private String subtitle;
        private String href;

        public Builder key(String key) {
            this.key = key;
            return this;
        }
        public Builder kind(String kind) {
            this.kind = kind;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder subtitle(String subtitle) {
            this.subtitle = subtitle;
            return this;
        }
        public Builder href(String href) {
            this.href = href;
            return this;
        }

        public SearchResultItem build() {
            return new SearchResultItem(this.key, this.kind, this.title, this.subtitle, this.href);
        }
    }
}