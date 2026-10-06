package com.kuruhu.surveillance;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "motiondetectionevent_records")
public class MotionDetectionEvent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String streamId;
    private String detectedMotionArea;
    private String eventTimestamp;

    public MotionDetectionEvent() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getStreamId() { return this.streamId; }
    public void setStreamId(String streamId) { this.streamId = streamId; }
    public String getDetectedMotionArea() { return this.detectedMotionArea; }
    public void setDetectedMotionArea(String detectedMotionArea) { this.detectedMotionArea = detectedMotionArea; }
    public String getEventTimestamp() { return this.eventTimestamp; }
    public void setEventTimestamp(String eventTimestamp) { this.eventTimestamp = eventTimestamp; }
}
