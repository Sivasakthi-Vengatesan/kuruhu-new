package com.kuruhu.event;

public class CaseCreatedEvent {
    private final String caseNumber;
    private final String crimeType;

    public CaseCreatedEvent(String caseNumber, String crimeType) {
        this.caseNumber = caseNumber;
        this.crimeType = crimeType;
    }

    public String getCaseNumber() { return this.caseNumber; }
    public String getCrimeType() { return this.crimeType; }
}
