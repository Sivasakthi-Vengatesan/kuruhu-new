package com.kuruhu.notification;

import org.springframework.stereotype.Component;

@Component
public class PriorityAlertManager {
    public boolean isEscalationRequired(String alertLevel) { return "CRITICAL".equalsIgnoreCase(alertLevel); }
}
