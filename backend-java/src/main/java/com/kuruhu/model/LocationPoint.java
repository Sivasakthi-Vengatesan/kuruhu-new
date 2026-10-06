package com.kuruhu.model;

import java.io.Serializable;

public class LocationPoint implements Serializable {
    private String locationName;
    private Double lat;
    private Double lng;
    private String jurisdiction;

    public LocationPoint() {}

    public LocationPoint(String locationName, Double lat, Double lng, String jurisdiction) {
        this.locationName = locationName;
        this.lat = lat;
        this.lng = lng;
        this.jurisdiction = jurisdiction;
    }

    public String getLocationName() { return locationName; }
    public void setLocationName(String locationName) { this.locationName = locationName; }

    public Double getLat() { return lat; }
    public void setLat(Double lat) { this.lat = lat; }

    public Double getLng() { return lng; }
    public void setLng(Double lng) { this.lng = lng; }

    public String getJurisdiction() { return jurisdiction; }
    public void setJurisdiction(String jurisdiction) { this.jurisdiction = jurisdiction; }
}
