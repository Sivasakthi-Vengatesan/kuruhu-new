package com.kuruhu.patrol;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "patrolvehicle_records")
public class PatrolVehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vehicleRegistration;
    private String vehicleType;
    private String callSign;
    private String gpsUnitId;

    public PatrolVehicle() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getVehicleRegistration() { return this.vehicleRegistration; }
    public void setVehicleRegistration(String vehicleRegistration) { this.vehicleRegistration = vehicleRegistration; }
    public String getVehicleType() { return this.vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }
    public String getCallSign() { return this.callSign; }
    public void setCallSign(String callSign) { this.callSign = callSign; }
    public String getGpsUnitId() { return this.gpsUnitId; }
    public void setGpsUnitId(String gpsUnitId) { this.gpsUnitId = gpsUnitId; }
}
