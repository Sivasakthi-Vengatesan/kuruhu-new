package com.pramaan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChatRequest {

    private List<ChatMessageDto> messages = new ArrayList<>();

    private String message; // single message support

    @JsonProperty("conversation_id")
    private String conversationId;

    private Map<String, Object> context;


    public ChatRequest() {
    }

    public ChatRequest(List<ChatMessageDto> messages, String message, String conversationId, Map<String, Object> context) {
        this.messages = messages;
        this.message = message;
        this.conversationId = conversationId;
        this.context = context;
    }

    public List<ChatMessageDto> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessageDto> messages) {
        this.messages = messages;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public Map<String, Object> getContext() {
        return context;
    }

    public void setContext(Map<String, Object> context) {
        this.context = context;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<ChatMessageDto> messages;
        private String message;
        private String conversationId;
        private Map<String, Object> context;

        public Builder messages(List<ChatMessageDto> messages) {
            this.messages = messages;
            return this;
        }
        public Builder message(String message) {
            this.message = message;
            return this;
        }
        public Builder conversationId(String conversationId) {
            this.conversationId = conversationId;
            return this;
        }
        public Builder context(Map<String, Object> context) {
            this.context = context;
            return this;
        }

        public ChatRequest build() {
            return new ChatRequest(this.messages, this.message, this.conversationId, this.context);
        }
    }
}