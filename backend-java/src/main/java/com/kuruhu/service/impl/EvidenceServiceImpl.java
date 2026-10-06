package com.kuruhu.service.impl;

import com.kuruhu.service.EvidenceService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EvidenceServiceImpl implements EvidenceService {

    @Override
    public java.util.List<EvidenceDTO> getEvidenceByFIR(Long firId) {
        return java.util.Collections.emptyList();
    }

    @Override
    public EvidenceDTO createEvidence(CreateEvidenceRequest request) {
        return EvidenceDTO.builder().build();
    }
}
