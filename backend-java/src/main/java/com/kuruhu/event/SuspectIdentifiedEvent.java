package com.kuruhu.event;

public class SuspectIdentifiedEvent {
    private final String personId;
    private final String caseNumber;

    public SuspectIdentifiedEvent(String personId, String caseNumber) {
        this.personId = personId;
        this.caseNumber = caseNumber;
    }

    public String getPersonId() { return this.personId; }
    public String getCaseNumber() { return this.caseNumber; }
}
