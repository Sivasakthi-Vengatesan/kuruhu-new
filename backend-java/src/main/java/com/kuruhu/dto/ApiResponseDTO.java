package com.kuruhu.dto;

import java.io.Serializable;

public class ApiResponseDTO implements Serializable {

    private boolean success;
    private String message;
    private Object data;
    private java.time.OffsetDateTime timestamp;

    public ApiResponseDTO() {}

    public ApiResponseDTO(boolean success, String message, Object data, java.time.OffsetDateTime timestamp) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
    }

    public boolean getSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Object getData() { return data; }
    public void setData(Object data) { this.data = data; }

    public java.time.OffsetDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(java.time.OffsetDateTime timestamp) { this.timestamp = timestamp; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private boolean success;
        private String message;
        private Object data;
        private java.time.OffsetDateTime timestamp;

        public Builder success(boolean success) {
            this.success = success;
            return this;
        }
        public Builder message(String message) {
            this.message = message;
            return this;
        }
        public Builder data(Object data) {
            this.data = data;
            return this;
        }
        public Builder timestamp(java.time.OffsetDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ApiResponseDTO build() {
            return new ApiResponseDTO(this.success, this.message, this.data, this.timestamp);
        }
    }
}
