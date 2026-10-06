package com.kuruhu.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PgVectorConfig {
    // PGVector dimension and similarity metric configurations (384 dimensions for all-MiniLM-L6-v2)
    public static final int VECTOR_DIMENSIONS = 384;
    public static final String DISTANCE_METRIC = "cosine";
}
