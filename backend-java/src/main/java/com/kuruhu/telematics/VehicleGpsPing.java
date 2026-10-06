package com.kuruhu.telematics;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehiclegpsping_records")
public class VehicleGpsPing implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vehicleId;
    private String latitude;
    private String longitude;
    private String speedKmh;
    private String headingDegrees;

    public VehicleGpsPing() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getVehicleId() { return this.vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }
    public String getLatitude() { return this.latitude; }
    public void setLatitude(String latitude) { this.latitude = latitude; }
    public String getLongitude() { return this.longitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }
    public String getSpeedKmh() { return this.speedKmh; }
    public void setSpeedKmh(String speedKmh) { this.speedKmh = speedKmh; }
    public String getHeadingDegrees() { return this.headingDegrees; }
    public void setHeadingDegrees(String headingDegrees) { this.headingDegrees = headingDegrees; }
}
