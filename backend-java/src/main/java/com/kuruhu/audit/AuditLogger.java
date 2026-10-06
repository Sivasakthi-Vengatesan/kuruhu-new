package com.kuruhu.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AuditLogger {
    private static final Logger log = LoggerFactory.getLogger(AuditLogger.class);

    public void logSecurityEvent(String action, String user, String detail) {
        log.info("[AUDIT] Action: {} | User: {} | Detail: {}", action, user, detail);
    }
}
