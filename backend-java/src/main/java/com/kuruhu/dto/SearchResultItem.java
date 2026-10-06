package com.kuruhu.dto;

import java.io.Serializable;

public class SearchResultItem implements Serializable {

    private String id;
    private String type;
    private String title;
    private String subtitle;
    private String href;
    private String district;

    public SearchResultItem() {}

    public SearchResultItem(String id, String type, String title, String subtitle, String href, String district) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.subtitle = subtitle;
        this.href = href;
        this.district = district;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSubtitle() { return subtitle; }
    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }

    public String getHref() { return href; }
    public void setHref(String href) { this.href = href; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String type;
        private String title;
        private String subtitle;
        private String href;
        private String district;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder type(String type) {
            this.type = type;
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
        public Builder district(String district) {
            this.district = district;
            return this;
        }

        public SearchResultItem build() {
            return new SearchResultItem(this.id, this.type, this.title, this.subtitle, this.href, this.district);
        }
    }
}
