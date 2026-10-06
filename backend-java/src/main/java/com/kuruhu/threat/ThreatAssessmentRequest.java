package com.kuruhu.threat;

import java.io.Serializable;

public class ThreatAssessmentRequest implements Serializable {
    private String jurisdiction;
    private String timeline;
    private String eventType;

    public ThreatAssessmentRequest() {}

    public String getJurisdiction() { return this.jurisdiction; }
    public void setJurisdiction(String jurisdiction) { this.jurisdiction = jurisdiction; }
    public String getTimeline() { return this.timeline; }
    public void setTimeline(String timeline) { this.timeline = timeline; }
    public String getEventType() { return this.eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
}
