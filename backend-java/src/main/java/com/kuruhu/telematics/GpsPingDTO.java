package com.kuruhu.telematics;

import java.io.Serializable;

public class GpsPingDTO implements Serializable {
    private String vehicleId;
    private String latitude;
    private String longitude;
    private String speedKmh;
    private String timestamp;

    public GpsPingDTO() {}

    public String getVehicleId() { return this.vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }
    public String getLatitude() { return this.latitude; }
    public void setLatitude(String latitude) { this.latitude = latitude; }
    public String getLongitude() { return this.longitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }
    public String getSpeedKmh() { return this.speedKmh; }
    public void setSpeedKmh(String speedKmh) { this.speedKmh = speedKmh; }
    public String getTimestamp() { return this.timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}
