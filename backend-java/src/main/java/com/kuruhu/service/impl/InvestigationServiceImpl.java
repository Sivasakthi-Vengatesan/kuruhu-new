package com.kuruhu.service.impl;

import com.kuruhu.service.InvestigationService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class InvestigationServiceImpl implements InvestigationService {

    @Override
    public java.util.List<InvestigationDTO> getAllInvestigations(int page, int size) {
        return java.util.Collections.emptyList();
    }

    @Override
    public InvestigationDTO getInvestigationById(Long id) {
        return InvestigationDTO.builder().build();
    }
}
