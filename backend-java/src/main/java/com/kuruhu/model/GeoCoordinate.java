package com.kuruhu.model;

import java.io.Serializable;

public class GeoCoordinate implements Serializable {
    private Double latitude;
    private Double longitude;
    private String address;
    private String district;

    public GeoCoordinate() {}

    public GeoCoordinate(Double latitude, Double longitude, String address, String district) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.district = district;
    }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }
}
