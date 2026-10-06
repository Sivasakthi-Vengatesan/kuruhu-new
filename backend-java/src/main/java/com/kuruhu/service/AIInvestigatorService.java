package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface AIInvestigatorService {
    AIQueryResponse queryInvestigator(AIQueryRequest request);
    java.util.List<AIFindingDTO> getFindings();
    java.util.List<HotspotDTO> getHotspots();
    java.util.List<EarlyWarningDTO> getEarlyWarnings();
    java.util.List<PatrolRouteDTO> getPatrolRoutes();
    java.util.List<PatternDTO> getPatterns();
}
