package com.kuruhu.service.impl;

import com.kuruhu.service.ExportService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ExportServiceImpl implements ExportService {

    @Override
    public byte[] exportInvestigationReportPdf(Long firId) {
        return new byte[0];
    }
}
