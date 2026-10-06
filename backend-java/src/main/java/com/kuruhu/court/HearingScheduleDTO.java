package com.kuruhu.court;

import java.io.Serializable;

public class HearingScheduleDTO implements Serializable {
    private String caseNumber;
    private String courtName;
    private String hearingDate;
    private String judgeName;

    public HearingScheduleDTO() {}

    public String getCaseNumber() { return this.caseNumber; }
    public void setCaseNumber(String caseNumber) { this.caseNumber = caseNumber; }
    public String getCourtName() { return this.courtName; }
    public void setCourtName(String courtName) { this.courtName = courtName; }
    public String getHearingDate() { return this.hearingDate; }
    public void setHearingDate(String hearingDate) { this.hearingDate = hearingDate; }
    public String getJudgeName() { return this.judgeName; }
    public void setJudgeName(String judgeName) { this.judgeName = judgeName; }
}
