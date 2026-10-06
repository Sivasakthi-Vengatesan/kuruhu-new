package com.kuruhu.court;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "courthearing_records")
public class CourtHearing implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String caseNumber;
    private String courtName;
    private String judgeName;
    private String hearingStage;
    private String outcome;

    public CourtHearing() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getCaseNumber() { return this.caseNumber; }
    public void setCaseNumber(String caseNumber) { this.caseNumber = caseNumber; }
    public String getCourtName() { return this.courtName; }
    public void setCourtName(String courtName) { this.courtName = courtName; }
    public String getJudgeName() { return this.judgeName; }
    public void setJudgeName(String judgeName) { this.judgeName = judgeName; }
    public String getHearingStage() { return this.hearingStage; }
    public void setHearingStage(String hearingStage) { this.hearingStage = hearingStage; }
    public String getOutcome() { return this.outcome; }
    public void setOutcome(String outcome) { this.outcome = outcome; }
}
