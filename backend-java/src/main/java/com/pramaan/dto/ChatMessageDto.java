package com.pramaan.dto;


public class ChatMessageDto {
    private String role; // user, assistant, system
    private String content;


    public ChatMessageDto() {
    }

    public ChatMessageDto(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String role;
        private String content;

        public Builder role(String role) {
            this.role = role;
            return this;
        }
        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public ChatMessageDto build() {
            return new ChatMessageDto(this.role, this.content);
        }
    }
}