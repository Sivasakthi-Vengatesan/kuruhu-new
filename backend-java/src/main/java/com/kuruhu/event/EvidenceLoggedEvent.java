package com.kuruhu.event;

public class EvidenceLoggedEvent {
    private final String evidenceId;
    private final String caseNumber;

    public EvidenceLoggedEvent(String evidenceId, String caseNumber) {
        this.evidenceId = evidenceId;
        this.caseNumber = caseNumber;
    }

    public String getEvidenceId() { return this.evidenceId; }
    public String getCaseNumber() { return this.caseNumber; }
}
