package com.kuruhu.telematics;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fueltelemetryrecord_records")
public class FuelTelemetryRecord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vehicleId;
    private String fuelLevelPercentage;
    private String odometerKm;

    public FuelTelemetryRecord() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getVehicleId() { return this.vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }
    public String getFuelLevelPercentage() { return this.fuelLevelPercentage; }
    public void setFuelLevelPercentage(String fuelLevelPercentage) { this.fuelLevelPercentage = fuelLevelPercentage; }
    public String getOdometerKm() { return this.odometerKm; }
    public void setOdometerKm(String odometerKm) { this.odometerKm = odometerKm; }
}
