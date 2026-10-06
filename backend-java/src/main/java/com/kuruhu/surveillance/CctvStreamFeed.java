package com.kuruhu.surveillance;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cctvstreamfeed_records")
public class CctvStreamFeed implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String streamId;
    private String cameraIp;
    private String locationDescription;
    private String rtspUrl;

    public CctvStreamFeed() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getStreamId() { return this.streamId; }
    public void setStreamId(String streamId) { this.streamId = streamId; }
    public String getCameraIp() { return this.cameraIp; }
    public void setCameraIp(String cameraIp) { this.cameraIp = cameraIp; }
    public String getLocationDescription() { return this.locationDescription; }
    public void setLocationDescription(String locationDescription) { this.locationDescription = locationDescription; }
    public String getRtspUrl() { return this.rtspUrl; }
    public void setRtspUrl(String rtspUrl) { this.rtspUrl = rtspUrl; }
}
