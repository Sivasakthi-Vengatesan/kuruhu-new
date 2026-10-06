package com.kuruhu.workflow;

import java.io.Serializable;

public class WorkflowTransitionDTO implements Serializable {
    private String caseNumber;
    private String targetStage;
    private String notes;
    private String authorizedBy;

    public WorkflowTransitionDTO() {}

    public String getCaseNumber() { return this.caseNumber; }
    public void setCaseNumber(String caseNumber) { this.caseNumber = caseNumber; }
    public String getTargetStage() { return this.targetStage; }
    public void setTargetStage(String targetStage) { this.targetStage = targetStage; }
    public String getNotes() { return this.notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public String getAuthorizedBy() { return this.authorizedBy; }
    public void setAuthorizedBy(String authorizedBy) { this.authorizedBy = authorizedBy; }
}
