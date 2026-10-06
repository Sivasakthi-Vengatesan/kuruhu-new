package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface ActivityService {
    java.util.List<ActivityDTO> getActivities(String query, String type);
    void logActivity(CreateAuditLogRequest request);
}
