package com.pramaan.controller;

import com.pramaan.dto.ChatRequest;
import com.pramaan.dto.ChatResponse;
import com.pramaan.service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat")
@Tag(name = "AI Chat Assistant", description = "Conversational multi-lingual AI intelligence chat with RAG grounding")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }


    @PostMapping
    @Operation(summary = "Process conversational chat message with context grounding")
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        return ResponseEntity.ok(chatService.processChat(request));
    }
}