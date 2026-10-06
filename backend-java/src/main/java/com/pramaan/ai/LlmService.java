package com.pramaan.ai;

import java.util.List;
import java.util.Map;

public interface LlmService {
    String generateResponse(String prompt, String systemPrompt, List<Map<String, String>> history);
    boolean isConfigured();
    String getProviderName();
}