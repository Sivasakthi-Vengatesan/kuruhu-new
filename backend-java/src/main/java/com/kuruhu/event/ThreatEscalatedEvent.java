package com.kuruhu.event;

public class ThreatEscalatedEvent {
    private final String threatCode;
    private final String riskLevel;

    public ThreatEscalatedEvent(String threatCode, String riskLevel) {
        this.threatCode = threatCode;
        this.riskLevel = riskLevel;
    }

    public String getThreatCode() { return this.threatCode; }
    public String getRiskLevel() { return this.riskLevel; }
}
