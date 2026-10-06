package com.kuruhu.ai;

import org.springframework.stereotype.Component;

@Component
public class ModelProviderFactory {
    public String getActiveProviderName() {
        return "OpenAI-Compatible / Ollama";
    }
}
