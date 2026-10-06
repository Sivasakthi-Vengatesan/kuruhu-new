package com.kuruhu.service.impl;

import com.kuruhu.service.NotificationService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {

    @Override
    public java.util.List<NotificationDTO> getUserNotifications(Long userId) {
        return java.util.Collections.emptyList();
    }

    @Override
    public void markAsRead(Long notificationId) {
        // execution placeholder
    }
}
