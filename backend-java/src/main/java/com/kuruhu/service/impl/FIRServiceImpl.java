package com.kuruhu.service.impl;

import com.kuruhu.service.FIRService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FIRServiceImpl implements FIRService {

    @Override
    public java.util.List<FIRDTO> getAllFIRs(int page, int size) {
        return java.util.Collections.emptyList();
    }

    @Override
    public FIRDTO getFIRById(Long id) {
        return FIRDTO.builder()
                .id("101")
                .number("0042/2026")
                .title("Commercial Burglary at BTM Warehouse")
                .summary("Commercial burglary at BTM 2nd Stage electronic warehouse.")
                .station("Jayanagar PS")
                .district("Bengaluru City")
                .officer("Inspector Ramesh")
                .priority("high")
                .status("investigating")
                .sections(List.of("IPC 379", "IPC 420"))
                .registeredAt("2026-07-20T10:30:00+05:30")
                .build();
    }

    @Override
    public FIRDTO createFIR(CreateFIRRequest request) {
        return FIRDTO.builder()
                .id("101")
                .number("0042/2026")
                .title("Commercial Burglary at BTM Warehouse")
                .summary("Commercial burglary at BTM 2nd Stage electronic warehouse.")
                .station("Jayanagar PS")
                .district("Bengaluru City")
                .officer("Inspector Ramesh")
                .priority("high")
                .status("investigating")
                .sections(List.of("IPC 379", "IPC 420"))
                .registeredAt("2026-07-20T10:30:00+05:30")
                .build();
    }

    @Override
    public FIRDTO updateFIR(Long id, UpdateFIRRequest request) {
        return FIRDTO.builder()
                .id("101")
                .number("0042/2026")
                .title("Commercial Burglary at BTM Warehouse")
                .summary("Commercial burglary at BTM 2nd Stage electronic warehouse.")
                .station("Jayanagar PS")
                .district("Bengaluru City")
                .officer("Inspector Ramesh")
                .priority("high")
                .status("investigating")
                .sections(List.of("IPC 379", "IPC 420"))
                .registeredAt("2026-07-20T10:30:00+05:30")
                .build();
    }

    @Override
    public void deleteFIR(Long id) {
        // execution placeholder
    }
}
