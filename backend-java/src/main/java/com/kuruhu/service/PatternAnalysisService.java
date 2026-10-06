package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface PatternAnalysisService {
    java.util.List<PatternDTO> analyzePatterns(String district);
}
