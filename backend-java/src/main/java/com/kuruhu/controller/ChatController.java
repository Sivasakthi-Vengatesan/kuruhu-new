package com.kuruhu.controller;

import com.kuruhu.dto.ChatRequest;
import com.kuruhu.dto.ChatResponse;
import com.kuruhu.service.ChatService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat")
@Tag(name = "AI Chat Assistant", description = "Conversational copilot for police investigations")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) { this.chatService = chatService; }

    @PostMapping
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        return ResponseEntity.ok(chatService.processChat(request));
    }
}
