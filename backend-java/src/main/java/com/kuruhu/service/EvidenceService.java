package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface EvidenceService {
    java.util.List<EvidenceDTO> getEvidenceByFIR(Long firId);
    EvidenceDTO createEvidence(CreateEvidenceRequest request);
}
