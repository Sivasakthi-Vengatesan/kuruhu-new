package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface ChatService {
    ChatResponse processChat(ChatRequest request);
}
