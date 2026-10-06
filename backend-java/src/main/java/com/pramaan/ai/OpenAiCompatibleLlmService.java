package com.pramaan.ai;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OpenAiCompatibleLlmService implements LlmService {

    private static final Logger log = LoggerFactory.getLogger(OpenAiCompatibleLlmService.class);

    private final String baseUrl;
    private final String apiKey;
    private final String modelName;
    private final Double temperature;
    private final Integer maxTokens;
    private final ChatLanguageModel chatModel;

    public OpenAiCompatibleLlmService(
            @Value("${ai.llm.base-url:https://api.groq.com/openai/v1}") String baseUrl,
            @Value("${ai.llm.api-key:}") String apiKey,
            @Value("${ai.llm.model-name:llama-3.3-70b-versatile}") String modelName,
            @Value("${ai.llm.temperature:0.3}") Double temperature,
            @Value("${ai.llm.max-tokens:1024}") Integer maxTokens) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.modelName = modelName;
        this.temperature = temperature;
        this.maxTokens = maxTokens;

        if (StringUtils.hasText(apiKey)) {
            log.info("Initializing LangChain4j OpenAiChatModel with endpoint: {}, model: {}", baseUrl, modelName);
            this.chatModel = OpenAiChatModel.builder()
                    .baseUrl(baseUrl)
                    .apiKey(apiKey)
                    .modelName(modelName)
                    .temperature(temperature)
                    .maxTokens(maxTokens)
                    .timeout(Duration.ofSeconds(30))
                    .logRequests(false)
                    .logResponses(false)
                    .build();
        } else {
            log.info("No LLM API key configured. OpenAiCompatibleLlmService will use grounded database synthesis mode.");
            this.chatModel = null;
        }
    }

    @Override
    public String generateResponse(String prompt, String systemPrompt, List<Map<String, String>> history) {
        if (chatModel != null) {
            try {
                List<ChatMessage> messages = new ArrayList<>();
                if (StringUtils.hasText(systemPrompt)) {
                    messages.add(SystemMessage.from(systemPrompt));
                }
                if (history != null) {
                    for (Map<String, String> msg : history) {
                        String role = msg.get("role");
                        String content = msg.get("content");
                        if ("user".equalsIgnoreCase(role)) {
                            messages.add(UserMessage.from(content));
                        } else if ("assistant".equalsIgnoreCase(role)) {
                            messages.add(AiMessage.from(content));
                        }
                    }
                }
                messages.add(UserMessage.from(prompt));

                return chatModel.generate(messages).content().text();
            } catch (Exception e) {
                log.error("Error generating LLM response via API: {}", e.getMessage(), e);
            }
        }

        // Fallback when LLM API key is not configured: generate grounded factual response from retrieved context
        return null;
    }

    @Override
    public boolean isConfigured() {
        return chatModel != null;
    }

    @Override
    public String getProviderName() {
        return isConfigured() ? "PRAMAAN AI (" + modelName + ")" : "PRAMAAN Intelligence Engine (Grounded DB Mode)";
    }
}