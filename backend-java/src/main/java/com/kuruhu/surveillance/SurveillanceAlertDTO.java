package com.kuruhu.surveillance;

import java.io.Serializable;

public class SurveillanceAlertDTO implements Serializable {
    private String streamId;
    private String alertType;
    private String timestamp;
    private String snapshotUrl;

    public SurveillanceAlertDTO() {}

    public String getStreamId() { return this.streamId; }
    public void setStreamId(String streamId) { this.streamId = streamId; }
    public String getAlertType() { return this.alertType; }
    public void setAlertType(String alertType) { this.alertType = alertType; }
    public String getTimestamp() { return this.timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
    public String getSnapshotUrl() { return this.snapshotUrl; }
    public void setSnapshotUrl(String snapshotUrl) { this.snapshotUrl = snapshotUrl; }
}
