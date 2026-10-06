package com.kuruhu.messaging;

import java.io.Serializable;

public class EventMessagePayload implements Serializable {
    private String eventType;
    private String payloadJson;
    private String emittedBy;
    private String timestamp;

    public EventMessagePayload() {}

    public String getEventType() { return this.eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    public String getPayloadJson() { return this.payloadJson; }
    public void setPayloadJson(String payloadJson) { this.payloadJson = payloadJson; }
    public String getEmittedBy() { return this.emittedBy; }
    public void setEmittedBy(String emittedBy) { this.emittedBy = emittedBy; }
    public String getTimestamp() { return this.timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}
