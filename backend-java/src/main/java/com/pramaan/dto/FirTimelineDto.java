package com.pramaan.dto;


public class FirTimelineDto {
    private String id;
    private String time;
    private String title;
    private String detail;
    private String actor;


    public FirTimelineDto() {
    }

    public FirTimelineDto(String id, String time, String title, String detail, String actor) {
        this.id = id;
        this.time = time;
        this.title = title;
        this.detail = detail;
        this.actor = actor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String time;
        private String title;
        private String detail;
        private String actor;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder time(String time) {
            this.time = time;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }
        public Builder actor(String actor) {
            this.actor = actor;
            return this;
        }

        public FirTimelineDto build() {
            return new FirTimelineDto(this.id, this.time, this.title, this.detail, this.actor);
        }
    }
}