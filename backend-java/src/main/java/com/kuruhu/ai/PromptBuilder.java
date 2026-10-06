package com.kuruhu.ai;

import org.springframework.stereotype.Component;

@Component
public class PromptBuilder {
    public String buildInvestigationPrompt(String query, String context, String language) {
        return "Context: " + context + "\nQuery: " + query + "\nLanguage: " + language;
    }
}
