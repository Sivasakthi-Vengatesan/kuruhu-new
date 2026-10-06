package com.kuruhu.dto;

import java.io.Serializable;

public class HotspotDTO implements Serializable {

    private String id;
    private String zoneName;
    private String district;
    private String crimeType;
    private Double lat;
    private Double lng;
    private int incidentCount;
    private String peakTimeWindow;
    private String riskScore;

    public HotspotDTO() {}

    public HotspotDTO(String id, String zoneName, String district, String crimeType, Double lat, Double lng, int incidentCount, String peakTimeWindow, String riskScore) {
        this.id = id;
        this.zoneName = zoneName;
        this.district = district;
        this.crimeType = crimeType;
        this.lat = lat;
        this.lng = lng;
        this.incidentCount = incidentCount;
        this.peakTimeWindow = peakTimeWindow;
        this.riskScore = riskScore;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getZoneName() { return zoneName; }
    public void setZoneName(String zoneName) { this.zoneName = zoneName; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getCrimeType() { return crimeType; }
    public void setCrimeType(String crimeType) { this.crimeType = crimeType; }

    public Double getLat() { return lat; }
    public void setLat(Double lat) { this.lat = lat; }

    public Double getLng() { return lng; }
    public void setLng(Double lng) { this.lng = lng; }

    public int getIncidentCount() { return incidentCount; }
    public void setIncidentCount(int incidentCount) { this.incidentCount = incidentCount; }

    public String getPeakTimeWindow() { return peakTimeWindow; }
    public void setPeakTimeWindow(String peakTimeWindow) { this.peakTimeWindow = peakTimeWindow; }

    public String getRiskScore() { return riskScore; }
    public void setRiskScore(String riskScore) { this.riskScore = riskScore; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String zoneName;
        private String district;
        private String crimeType;
        private Double lat;
        private Double lng;
        private int incidentCount;
        private String peakTimeWindow;
        private String riskScore;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder zoneName(String zoneName) {
            this.zoneName = zoneName;
            return this;
        }
        public Builder district(String district) {
            this.district = district;
            return this;
        }
        public Builder crimeType(String crimeType) {
            this.crimeType = crimeType;
            return this;
        }
        public Builder lat(Double lat) {
            this.lat = lat;
            return this;
        }
        public Builder lng(Double lng) {
            this.lng = lng;
            return this;
        }
        public Builder incidentCount(int incidentCount) {
            this.incidentCount = incidentCount;
            return this;
        }
        public Builder peakTimeWindow(String peakTimeWindow) {
            this.peakTimeWindow = peakTimeWindow;
            return this;
        }
        public Builder riskScore(String riskScore) {
            this.riskScore = riskScore;
            return this;
        }

        public HotspotDTO build() {
            return new HotspotDTO(this.id, this.zoneName, this.district, this.crimeType, this.lat, this.lng, this.incidentCount, this.peakTimeWindow, this.riskScore);
        }
    }
}
