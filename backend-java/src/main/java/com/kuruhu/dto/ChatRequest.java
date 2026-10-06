package com.kuruhu.dto;

import java.io.Serializable;

public class ChatRequest implements Serializable {

    private java.util.List<ChatMessageDTO> messages;
    private java.util.Map<String, Object> context;
    private String message;

    public ChatRequest() {}

    public ChatRequest(java.util.List<ChatMessageDTO> messages, java.util.Map<String, Object> context, String message) {
        this.messages = messages;
        this.context = context;
        this.message = message;
    }

    public java.util.List<ChatMessageDTO> getMessages() { return messages; }
    public void setMessages(java.util.List<ChatMessageDTO> messages) { this.messages = messages; }

    public java.util.Map<String, Object> getContext() { return context; }
    public void setContext(java.util.Map<String, Object> context) { this.context = context; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private java.util.List<ChatMessageDTO> messages;
        private java.util.Map<String, Object> context;
        private String message;

        public Builder messages(java.util.List<ChatMessageDTO> messages) {
            this.messages = messages;
            return this;
        }
        public Builder context(java.util.Map<String, Object> context) {
            this.context = context;
            return this;
        }
        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public ChatRequest build() {
            return new ChatRequest(this.messages, this.context, this.message);
        }
    }
}
