package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface InvestigationService {
    java.util.List<InvestigationDTO> getAllInvestigations(int page, int size);
    InvestigationDTO getInvestigationById(Long id);
}
