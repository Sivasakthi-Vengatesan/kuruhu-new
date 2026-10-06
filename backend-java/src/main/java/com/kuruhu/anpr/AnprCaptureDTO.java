package com.kuruhu.anpr;

import java.io.Serializable;

public class AnprCaptureDTO implements Serializable {
    private String plateNumber;
    private String cameraLocation;
    private String capturedAt;
    private String hotlistMatch;

    public AnprCaptureDTO() {}

    public String getPlateNumber() { return this.plateNumber; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }
    public String getCameraLocation() { return this.cameraLocation; }
    public void setCameraLocation(String cameraLocation) { this.cameraLocation = cameraLocation; }
    public String getCapturedAt() { return this.capturedAt; }
    public void setCapturedAt(String capturedAt) { this.capturedAt = capturedAt; }
    public String getHotlistMatch() { return this.hotlistMatch; }
    public void setHotlistMatch(String hotlistMatch) { this.hotlistMatch = hotlistMatch; }
}
