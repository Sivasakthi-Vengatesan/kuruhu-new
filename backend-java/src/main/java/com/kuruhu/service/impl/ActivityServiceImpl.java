package com.kuruhu.service.impl;

import com.kuruhu.service.ActivityService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

    @Override
    public java.util.List<ActivityDTO> getActivities(String query, String type) {
        return java.util.Collections.emptyList();
    }

    @Override
    public void logActivity(CreateAuditLogRequest request) {
        // execution placeholder
    }
}
