package com.kuruhu.anpr;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "anprcameraunit_records")
public class AnprCameraUnit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cameraId;
    private String latitude;
    private String longitude;
    private String operationalStatus;

    public AnprCameraUnit() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getCameraId() { return this.cameraId; }
    public void setCameraId(String cameraId) { this.cameraId = cameraId; }
    public String getLatitude() { return this.latitude; }
    public void setLatitude(String latitude) { this.latitude = latitude; }
    public String getLongitude() { return this.longitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }
    public String getOperationalStatus() { return this.operationalStatus; }
    public void setOperationalStatus(String operationalStatus) { this.operationalStatus = operationalStatus; }
}
