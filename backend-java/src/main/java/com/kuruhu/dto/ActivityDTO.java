package com.kuruhu.dto;

import java.io.Serializable;

public class ActivityDTO implements Serializable {

    private String id;
    private String actorName;
    private String actorRole;
    private String action;
    private String targetDescription;
    private String targetType;
    private String detail;
    private String time;

    public ActivityDTO() {}

    public ActivityDTO(String id, String actorName, String actorRole, String action, String targetDescription, String targetType, String detail, String time) {
        this.id = id;
        this.actorName = actorName;
        this.actorRole = actorRole;
        this.action = action;
        this.targetDescription = targetDescription;
        this.targetType = targetType;
        this.detail = detail;
        this.time = time;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getActorName() { return actorName; }
    public void setActorName(String actorName) { this.actorName = actorName; }

    public String getActorRole() { return actorRole; }
    public void setActorRole(String actorRole) { this.actorRole = actorRole; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public String getTargetDescription() { return targetDescription; }
    public void setTargetDescription(String targetDescription) { this.targetDescription = targetDescription; }

    public String getTargetType() { return targetType; }
    public void setTargetType(String targetType) { this.targetType = targetType; }

    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String actorName;
        private String actorRole;
        private String action;
        private String targetDescription;
        private String targetType;
        private String detail;
        private String time;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder actorName(String actorName) {
            this.actorName = actorName;
            return this;
        }
        public Builder actorRole(String actorRole) {
            this.actorRole = actorRole;
            return this;
        }
        public Builder action(String action) {
            this.action = action;
            return this;
        }
        public Builder targetDescription(String targetDescription) {
            this.targetDescription = targetDescription;
            return this;
        }
        public Builder targetType(String targetType) {
            this.targetType = targetType;
            return this;
        }
        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }
        public Builder time(String time) {
            this.time = time;
            return this;
        }

        public ActivityDTO build() {
            return new ActivityDTO(this.id, this.actorName, this.actorRole, this.action, this.targetDescription, this.targetType, this.detail, this.time);
        }
    }
}
