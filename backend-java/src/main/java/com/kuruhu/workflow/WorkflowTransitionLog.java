package com.kuruhu.workflow;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "workflowtransitionlog_records")
public class WorkflowTransitionLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String caseNumber;
    private String fromStage;
    private String toStage;
    private String transitionUser;

    public WorkflowTransitionLog() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getCaseNumber() { return this.caseNumber; }
    public void setCaseNumber(String caseNumber) { this.caseNumber = caseNumber; }
    public String getFromStage() { return this.fromStage; }
    public void setFromStage(String fromStage) { this.fromStage = fromStage; }
    public String getToStage() { return this.toStage; }
    public void setToStage(String toStage) { this.toStage = toStage; }
    public String getTransitionUser() { return this.transitionUser; }
    public void setTransitionUser(String transitionUser) { this.transitionUser = transitionUser; }
}
