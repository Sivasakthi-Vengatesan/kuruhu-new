package com.kuruhu.audit;

import org.springframework.stereotype.Component;

@Component
public class AuditTrailInterceptor {
    public boolean preHandle() { return true; }
}
