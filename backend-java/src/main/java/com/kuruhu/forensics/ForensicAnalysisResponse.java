package com.kuruhu.forensics;

import java.io.Serializable;

public class ForensicAnalysisResponse implements Serializable {
    private String reportId;
    private String status;
    private String confidence;
    private String completedAt;

    public ForensicAnalysisResponse() {}

    public String getReportId() { return this.reportId; }
    public void setReportId(String reportId) { this.reportId = reportId; }
    public String getStatus() { return this.status; }
    public void setStatus(String status) { this.status = status; }
    public String getConfidence() { return this.confidence; }
    public void setConfidence(String confidence) { this.confidence = confidence; }
    public String getCompletedAt() { return this.completedAt; }
    public void setCompletedAt(String completedAt) { this.completedAt = completedAt; }
}
