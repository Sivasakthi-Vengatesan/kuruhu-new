package com.pramaan.controller;

import com.pramaan.dto.TtsRequest;
import com.pramaan.service.TtsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tts")
@Tag(name = "Text-to-Speech", description = "Multi-lingual speech synthesis for intelligence outputs")
public class TtsController {

    private final TtsService ttsService;

    public TtsController(TtsService ttsService) {
        this.ttsService = ttsService;
    }


    @PostMapping
    @Operation(summary = "Synthesize text to audio stream")
    public ResponseEntity<byte[]> synthesize(@Valid @RequestBody TtsRequest request) {
        byte[] audioData = ttsService.synthesizeAudio(request);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("audio/mpeg"));
        headers.setContentLength(audioData.length);
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"tts-synthesis.mp3\"");

        return ResponseEntity.ok()
                .headers(headers)
                .body(audioData);
    }
}