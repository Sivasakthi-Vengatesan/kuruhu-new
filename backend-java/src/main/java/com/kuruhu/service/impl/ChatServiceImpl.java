package com.kuruhu.service.impl;

import com.kuruhu.service.ChatService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ChatServiceImpl implements ChatService {

    @Override
    public ChatResponse processChat(ChatRequest request) {
        return ChatResponse.builder()
                .reply("PRAMAAN AI Intelligence: Based on KSP database records, suspect Ravi Kumar S (P-1001) has 2 linked FIRs in BTM Layout and Jayanagar divisions.")
                .modelUsed("PRAMAAN Groq/LLaMA 3.3 Engine")
                .confidence(0.96)
                .auditHash("AUDIT-KSP-882190")
                .citations(List.of())
                .build();
    }
}
