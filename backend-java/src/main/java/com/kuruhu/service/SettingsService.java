package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface SettingsService {
    java.util.Map<String, Object> getSystemSettings();
    void updateSettings(java.util.Map<String, Object> settings);
}
