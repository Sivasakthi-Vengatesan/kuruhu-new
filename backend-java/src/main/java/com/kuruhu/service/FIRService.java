package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface FIRService {
    java.util.List<FIRDTO> getAllFIRs(int page, int size);
    FIRDTO getFIRById(Long id);
    FIRDTO createFIR(CreateFIRRequest request);
    FIRDTO updateFIR(Long id, UpdateFIRRequest request);
    void deleteFIR(Long id);
}
