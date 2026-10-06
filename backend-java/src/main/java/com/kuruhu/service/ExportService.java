package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface ExportService {
    byte[] exportInvestigationReportPdf(Long firId);
}
