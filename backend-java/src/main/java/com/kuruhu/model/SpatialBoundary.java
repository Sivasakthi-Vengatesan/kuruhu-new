package com.kuruhu.model;

import java.io.Serializable;

public class SpatialBoundary implements Serializable {
    private String zoneName;
    private String district;
    private java.util.List<LocationPoint> boundaryCoordinates;

    public SpatialBoundary() {}

    public SpatialBoundary(String zoneName, String district, java.util.List<LocationPoint> boundaryCoordinates) {
        this.zoneName = zoneName;
        this.district = district;
        this.boundaryCoordinates = boundaryCoordinates;
    }

    public String getZoneName() { return zoneName; }
    public void setZoneName(String zoneName) { this.zoneName = zoneName; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public java.util.List<LocationPoint> getBoundaryCoordinates() { return boundaryCoordinates; }
    public void setBoundaryCoordinates(java.util.List<LocationPoint> boundaryCoordinates) { this.boundaryCoordinates = boundaryCoordinates; }
}
