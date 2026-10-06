package com.kuruhu.threat;

import java.io.Serializable;

public class ThreatAssessmentResponse implements Serializable {
    private String riskLevel;
    private String probability;
    private String criticalLocations;

    public ThreatAssessmentResponse() {}

    public String getRiskLevel() { return this.riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }
    public String getProbability() { return this.probability; }
    public void setProbability(String probability) { this.probability = probability; }
    public String getCriticalLocations() { return this.criticalLocations; }
    public void setCriticalLocations(String criticalLocations) { this.criticalLocations = criticalLocations; }
}
