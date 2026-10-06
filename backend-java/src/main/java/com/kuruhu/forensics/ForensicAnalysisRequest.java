package com.kuruhu.forensics;

import java.io.Serializable;

public class ForensicAnalysisRequest implements Serializable {
    private String evidenceId;
    private String analysisType;
    private String priority;
    private String notes;

    public ForensicAnalysisRequest() {}

    public String getEvidenceId() { return this.evidenceId; }
    public void setEvidenceId(String evidenceId) { this.evidenceId = evidenceId; }
    public String getAnalysisType() { return this.analysisType; }
    public void setAnalysisType(String analysisType) { this.analysisType = analysisType; }
    public String getPriority() { return this.priority; }
    public void setPriority(String priority) { this.priority = priority; }
    public String getNotes() { return this.notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
