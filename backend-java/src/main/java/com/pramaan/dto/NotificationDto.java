package com.pramaan.dto;


public class NotificationDto {
    private String id;
    private String title;
    private String body;
    private String time;
    private String kind; // assignment, verification, deadline, system, escalation
    private boolean actionRequired;
    private boolean read;


    public NotificationDto() {
    }

    public NotificationDto(String id, String title, String body, String time, String kind, boolean actionRequired, boolean read) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.time = time;
        this.kind = kind;
        this.actionRequired = actionRequired;
        this.read = read;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public boolean isActionRequired() {
        return actionRequired;
    }

    public void setActionRequired(boolean actionRequired) {
        this.actionRequired = actionRequired;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String title;
        private String body;
        private String time;
        private String kind;
        private boolean actionRequired;
        private boolean read;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder body(String body) {
            this.body = body;
            return this;
        }
        public Builder time(String time) {
            this.time = time;
            return this;
        }
        public Builder kind(String kind) {
            this.kind = kind;
            return this;
        }
        public Builder actionRequired(boolean actionRequired) {
            this.actionRequired = actionRequired;
            return this;
        }
        public Builder read(boolean read) {
            this.read = read;
            return this;
        }

        public NotificationDto build() {
            return new NotificationDto(this.id, this.title, this.body, this.time, this.kind, this.actionRequired, this.read);
        }
    }
}