package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface CaseService {
    java.util.List<CaseDTO> getAllCases(int page, int size);
    CaseDTO getCaseById(Long id);
    CaseDTO createCase(CreateCaseRequest request);
    CaseDTO updateCase(Long id, UpdateCaseRequest request);
}
