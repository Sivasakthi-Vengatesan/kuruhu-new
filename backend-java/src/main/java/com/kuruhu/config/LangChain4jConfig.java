package com.kuruhu.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class LangChain4jConfig {
    public static final String DEFAULT_MODEL = "llama-3.3-70b-versatile";
    public static final double DEFAULT_TEMPERATURE = 0.2;
    public static final int MAX_TOKENS = 2048;
}
