package com.kuruhu.service.impl;

import com.kuruhu.service.CaseService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CaseServiceImpl implements CaseService {

    @Override
    public java.util.List<CaseDTO> getAllCases(int page, int size) {
        return java.util.Collections.emptyList();
    }

    @Override
    public CaseDTO getCaseById(Long id) {
        return CaseDTO.builder().build();
    }

    @Override
    public CaseDTO createCase(CreateCaseRequest request) {
        return CaseDTO.builder().build();
    }

    @Override
    public CaseDTO updateCase(Long id, UpdateCaseRequest request) {
        return CaseDTO.builder().build();
    }
}
