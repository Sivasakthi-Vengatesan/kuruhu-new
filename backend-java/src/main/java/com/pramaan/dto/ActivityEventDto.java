package com.pramaan.dto;


public class ActivityEventDto {
    private String id;
    private String time;
    private String actor;
    private String role;
    private String action;
    private String target;
    private String targetType; // fir, person, location, vehicle, evidence, officer, ai-finding, system, auth
    private String detail;


    public ActivityEventDto() {
    }

    public ActivityEventDto(String id, String time, String actor, String role, String action, String target, String targetType, String detail) {
        this.id = id;
        this.time = time;
        this.actor = actor;
        this.role = role;
        this.action = action;
        this.target = target;
        this.targetType = targetType;
        this.detail = detail;
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

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String time;
        private String actor;
        private String role;
        private String action;
        private String target;
        private String targetType;
        private String detail;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder time(String time) {
            this.time = time;
            return this;
        }
        public Builder actor(String actor) {
            this.actor = actor;
            return this;
        }
        public Builder role(String role) {
            this.role = role;
            return this;
        }
        public Builder action(String action) {
            this.action = action;
            return this;
        }
        public Builder target(String target) {
            this.target = target;
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

        public ActivityEventDto build() {
            return new ActivityEventDto(this.id, this.time, this.actor, this.role, this.action, this.target, this.targetType, this.detail);
        }
    }
}