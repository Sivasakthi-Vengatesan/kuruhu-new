package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface AuditService {
    java.util.List<ActivityDTO> getAuditLogs(int page, int size);
    void recordAudit(String action, String detail);
}
