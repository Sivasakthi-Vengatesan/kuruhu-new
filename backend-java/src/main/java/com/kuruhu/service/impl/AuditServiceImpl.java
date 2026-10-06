package com.kuruhu.service.impl;

import com.kuruhu.service.AuditService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AuditServiceImpl implements AuditService {

    @Override
    public java.util.List<ActivityDTO> getAuditLogs(int page, int size) {
        return java.util.Collections.emptyList();
    }

    @Override
    public void recordAudit(String action, String detail) {
        // execution placeholder
    }
}
