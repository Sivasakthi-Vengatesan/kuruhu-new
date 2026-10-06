package com.kuruhu.rag;

import org.springframework.stereotype.Service;

@Service
public class EmbeddingService {
    public String generateEmbedding(String text) {
        return "[0.012, -0.045, 0.089, ... 384 dimensions]";
    }
}
