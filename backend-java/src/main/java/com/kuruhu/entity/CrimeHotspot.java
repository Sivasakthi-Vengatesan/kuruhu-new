package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "crimehotspots")
public class CrimeHotspot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zoneName")
    private String zoneName;

    @Column(name = "district")
    private String district;

    @Column(name = "crimeType")
    private String crimeType;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "incidentCount")
    private Integer incidentCount;

    @Column(name = "peakTimeWindow")
    private String peakTimeWindow;

    @Column(name = "riskScore")
    private String riskScore;

    public CrimeHotspot() {
    }

    public CrimeHotspot(Long id, String zoneName, String district, String crimeType, Double latitude, Double longitude, Integer incidentCount, String peakTimeWindow, String riskScore) {
        this.id = id;
        this.zoneName = zoneName;
        this.district = district;
        this.crimeType = crimeType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.incidentCount = incidentCount;
        this.peakTimeWindow = peakTimeWindow;
        this.riskScore = riskScore;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getZoneName() { return zoneName; }
    public void setZoneName(String zoneName) { this.zoneName = zoneName; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getCrimeType() { return crimeType; }
    public void setCrimeType(String crimeType) { this.crimeType = crimeType; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public Integer getIncidentCount() { return incidentCount; }
    public void setIncidentCount(Integer incidentCount) { this.incidentCount = incidentCount; }

    public String getPeakTimeWindow() { return peakTimeWindow; }
    public void setPeakTimeWindow(String peakTimeWindow) { this.peakTimeWindow = peakTimeWindow; }

    public String getRiskScore() { return riskScore; }
    public void setRiskScore(String riskScore) { this.riskScore = riskScore; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String zoneName;
        private String district;
        private String crimeType;
        private Double latitude;
        private Double longitude;
        private Integer incidentCount;
        private String peakTimeWindow;
        private String riskScore;

        public Builder id(Long id) {
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
        public Builder latitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }
        public Builder longitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }
        public Builder incidentCount(Integer incidentCount) {
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

        public CrimeHotspot build() {
            return new CrimeHotspot(this.id, this.zoneName, this.district, this.crimeType, this.latitude, this.longitude, this.incidentCount, this.peakTimeWindow, this.riskScore);
        }
    }
}
