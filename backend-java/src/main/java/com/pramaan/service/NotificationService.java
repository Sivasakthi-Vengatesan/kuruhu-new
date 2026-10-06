package com.pramaan.service;

import com.pramaan.dto.NotificationDto;
import com.pramaan.entity.Notification;
import com.pramaan.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }


    @Transactional(readOnly = true)
    public List<NotificationDto> getNotifications(Boolean actionRequiredOnly) {
        List<Notification> list = notificationRepository.findAllByOrderByCreatedAtDesc();
        if (Boolean.TRUE.equals(actionRequiredOnly)) {
            list = list.stream().filter(n -> Boolean.TRUE.equals(n.getActionRequired())).collect(Collectors.toList());
        }
        return list.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Transactional
    public void markAsRead(Long id) {
        notificationRepository.markAsReadById(id);
    }

    @Transactional
    public void markAllAsRead() {
        notificationRepository.markAllAsRead();
    }

    public NotificationDto mapToDto(Notification n) {
        return NotificationDto.builder()
                .id(String.valueOf(n.getId()))
                .title(n.getTitle())
                .body(n.getBody())
                .time(n.getCreatedAt() != null ? n.getCreatedAt().toString() : OffsetDateTime.now().toString())
                .kind(n.getKind() != null ? n.getKind().toLowerCase() : "system")
                .actionRequired(Boolean.TRUE.equals(n.getActionRequired()))
                .read(Boolean.TRUE.equals(n.getIsRead()))
                .build();
    }
}