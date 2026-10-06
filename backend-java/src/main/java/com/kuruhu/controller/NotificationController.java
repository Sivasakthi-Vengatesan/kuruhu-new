package com.kuruhu.controller;

import com.kuruhu.dto.NotificationDTO;
import com.kuruhu.service.NotificationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
@Tag(name = "Notifications", description = "Dispatch & alert queue")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) { this.notificationService = notificationService; }

    @GetMapping
    public ResponseEntity<List<NotificationDTO>> getNotifications(@RequestParam(required = false) Long userId) {
        return ResponseEntity.ok(notificationService.getUserNotifications(userId));
    }

    @PatchMapping("/{id}/read")
    public ResponseEntity<Void> markRead(@PathVariable Long id) {
        notificationService.markAsRead(id);
        return ResponseEntity.ok().build();
    }
}
