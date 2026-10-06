package com.kuruhu.telematics;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "speedviolationrecord_records")
public class SpeedViolationRecord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vehicleId;
    private String recordedSpeed;
    private String speedLimit;
    private String location;

    public SpeedViolationRecord() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getVehicleId() { return this.vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }
    public String getRecordedSpeed() { return this.recordedSpeed; }
    public void setRecordedSpeed(String recordedSpeed) { this.recordedSpeed = recordedSpeed; }
    public String getSpeedLimit() { return this.speedLimit; }
    public void setSpeedLimit(String speedLimit) { this.speedLimit = speedLimit; }
    public String getLocation() { return this.location; }
    public void setLocation(String location) { this.location = location; }
}
