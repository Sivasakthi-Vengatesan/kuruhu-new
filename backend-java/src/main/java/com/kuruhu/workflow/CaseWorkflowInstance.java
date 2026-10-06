package com.kuruhu.workflow;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "caseworkflowinstance_records")
public class CaseWorkflowInstance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String caseNumber;
    private String currentStage;
    private String assignedDesk;
    private String slaDeadline;

    public CaseWorkflowInstance() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getCaseNumber() { return this.caseNumber; }
    public void setCaseNumber(String caseNumber) { this.caseNumber = caseNumber; }
    public String getCurrentStage() { return this.currentStage; }
    public void setCurrentStage(String currentStage) { this.currentStage = currentStage; }
    public String getAssignedDesk() { return this.assignedDesk; }
    public void setAssignedDesk(String assignedDesk) { this.assignedDesk = assignedDesk; }
    public String getSlaDeadline() { return this.slaDeadline; }
    public void setSlaDeadline(String slaDeadline) { this.slaDeadline = slaDeadline; }
}
