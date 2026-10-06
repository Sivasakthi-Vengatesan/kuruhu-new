package com.pramaan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class AiQueryRequest {

    @NotBlank(message = "Question/Query is required")
    private String question;

    private String query;

    private String language; // en, kn, hi, ur

    @JsonProperty("conversation_id")
    private String conversationId;

    private String page;


    public AiQueryRequest() {
    }

    public AiQueryRequest(String question, String query, String language, String conversationId, String page) {
        this.question = question;
        this.query = query;
        this.language = language;
        this.conversationId = conversationId;
        this.page = page;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String question;
        private String query;
        private String language;
        private String conversationId;
        private String page;

        public Builder question(String question) {
            this.question = question;
            return this;
        }
        public Builder query(String query) {
            this.query = query;
            return this;
        }
        public Builder language(String language) {
            this.language = language;
            return this;
        }
        public Builder conversationId(String conversationId) {
            this.conversationId = conversationId;
            return this;
        }
        public Builder page(String page) {
            this.page = page;
            return this;
        }

        public AiQueryRequest build() {
            return new AiQueryRequest(this.question, this.query, this.language, this.conversationId, this.page);
        }
    }
}