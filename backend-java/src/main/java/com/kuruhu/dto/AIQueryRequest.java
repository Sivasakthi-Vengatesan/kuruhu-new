package com.kuruhu.dto;

import java.io.Serializable;

public class AIQueryRequest implements Serializable {

    private String question;
    private String query;
    private String language;
    private java.util.Map<String, Object> context;

    public AIQueryRequest() {}

    public AIQueryRequest(String question, String query, String language, java.util.Map<String, Object> context) {
        this.question = question;
        this.query = query;
        this.language = language;
        this.context = context;
    }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getQuery() { return query; }
    public void setQuery(String query) { this.query = query; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public java.util.Map<String, Object> getContext() { return context; }
    public void setContext(java.util.Map<String, Object> context) { this.context = context; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String question;
        private String query;
        private String language;
        private java.util.Map<String, Object> context;

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
        public Builder context(java.util.Map<String, Object> context) {
            this.context = context;
            return this;
        }

        public AIQueryRequest build() {
            return new AIQueryRequest(this.question, this.query, this.language, this.context);
        }
    }
}
