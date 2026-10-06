package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface NotificationService {
    java.util.List<NotificationDTO> getUserNotifications(Long userId);
    void markAsRead(Long notificationId);
}
