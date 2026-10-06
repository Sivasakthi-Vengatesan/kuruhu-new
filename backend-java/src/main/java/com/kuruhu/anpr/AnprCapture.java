package com.kuruhu.anpr;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "anprcapture_records")
public class AnprCapture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String plateNumber;
    private String cameraLocation;
    private String vehicleColor;
    private String vehicleModel;
    private String hotlistMatch;

    public AnprCapture() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getPlateNumber() { return this.plateNumber; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }
    public String getCameraLocation() { return this.cameraLocation; }
    public void setCameraLocation(String cameraLocation) { this.cameraLocation = cameraLocation; }
    public String getVehicleColor() { return this.vehicleColor; }
    public void setVehicleColor(String vehicleColor) { this.vehicleColor = vehicleColor; }
    public String getVehicleModel() { return this.vehicleModel; }
    public void setVehicleModel(String vehicleModel) { this.vehicleModel = vehicleModel; }
    public String getHotlistMatch() { return this.hotlistMatch; }
    public void setHotlistMatch(String hotlistMatch) { this.hotlistMatch = hotlistMatch; }
}
