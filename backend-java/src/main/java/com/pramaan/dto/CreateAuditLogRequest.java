package com.pramaan.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateAuditLogRequest {
    @NotBlank(message = "Action is required")
    private String action;
    
    @NotBlank(message = "Target description is required")
    private String targetDescription;
    
    @NotBlank(message = "Target type is required")
    private String targetType;
    
    private String detail;


    public CreateAuditLogRequest() {
    }

    public CreateAuditLogRequest(String action, String targetDescription, String targetType, String detail) {
        this.action = action;
        this.targetDescription = targetDescription;
        this.targetType = targetType;
        this.detail = detail;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTargetDescription() {
        return targetDescription;
    }

    public void setTargetDescription(String targetDescription) {
        this.targetDescription = targetDescription;
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
        private String action;
        private String targetDescription;
        private String targetType;
        private String detail;

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

        public CreateAuditLogRequest build() {
            return new CreateAuditLogRequest(this.action, this.targetDescription, this.targetType, this.detail);
        }
    }
}