package com.kuruhu.controller;

import com.kuruhu.service.SettingsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/settings")
@Tag(name = "Settings", description = "System configuration APIs")
public class SettingsController {
    private final SettingsService settingsService;

    public SettingsController(SettingsService settingsService) { this.settingsService = settingsService; }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getSettings() {
        return ResponseEntity.ok(settingsService.getSystemSettings());
    }

    @PutMapping
    public ResponseEntity<Void> updateSettings(@RequestBody Map<String, Object> settings) {
        settingsService.updateSettings(settings);
        return ResponseEntity.ok().build();
    }
}
