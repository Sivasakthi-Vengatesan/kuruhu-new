package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface GraphService {
    GraphResponse getInvestigationNetwork(Long personId);
    GraphResponse getCaseGraph(Long caseId);
}
