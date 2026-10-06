package com.kuruhu.biometrics;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "facialrecognitionrecord_records")
public class FacialRecognitionRecord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cameraFeedId;
    private String detectedPersonId;
    private String confidence;
    private String captureTimestamp;

    public FacialRecognitionRecord() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getCameraFeedId() { return this.cameraFeedId; }
    public void setCameraFeedId(String cameraFeedId) { this.cameraFeedId = cameraFeedId; }
    public String getDetectedPersonId() { return this.detectedPersonId; }
    public void setDetectedPersonId(String detectedPersonId) { this.detectedPersonId = detectedPersonId; }
    public String getConfidence() { return this.confidence; }
    public void setConfidence(String confidence) { this.confidence = confidence; }
    public String getCaptureTimestamp() { return this.captureTimestamp; }
    public void setCaptureTimestamp(String captureTimestamp) { this.captureTimestamp = captureTimestamp; }
}
