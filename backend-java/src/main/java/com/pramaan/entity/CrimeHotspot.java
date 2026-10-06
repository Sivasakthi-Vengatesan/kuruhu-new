package com.pramaan.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "crime_hotspots")
public class CrimeHotspot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hotspot_code", unique = true, length = 50)
    private String hotspotCode;

    @Column(nullable = false, length = 100)
    private String district;

    @Column(name = "location_name", nullable = false, length = 200)
    private String locationName;

    @Column(nullable = false, precision = 10, scale = 6)
    private BigDecimal latitude;

    @Column(nullable = false, precision = 10, scale = 6)
    private BigDecimal longitude;

    @Column(name = "crime_count")
    private Integer crimeCount = 0;

    @Column(name = "dominant_crime_type", nullable = false, length = 150)
    private String dominantCrimeType;

    @Column(name = "risk_level", length = 50)
    private String riskLevel = "high"; // critical, high, moderate

    @Column(name = "peak_hours", length = 100)
    private String peakHours;

    @Column(name = "predicted_trend", length = 50)
    private String predictedTrend = "stable"; // increasing, stable, decreasing

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;


    public CrimeHotspot() {
    }

    public CrimeHotspot(Long id, String hotspotCode, String district, String locationName, BigDecimal latitude, BigDecimal longitude, Integer crimeCount, String dominantCrimeType, String riskLevel, String peakHours, String predictedTrend, OffsetDateTime createdAt) {
        this.id = id;
        this.hotspotCode = hotspotCode;
        this.district = district;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.crimeCount = crimeCount;
        this.dominantCrimeType = dominantCrimeType;
        this.riskLevel = riskLevel;
        this.peakHours = peakHours;
        this.predictedTrend = predictedTrend;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotspotCode() {
        return hotspotCode;
    }

    public void setHotspotCode(String hotspotCode) {
        this.hotspotCode = hotspotCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Integer getCrimeCount() {
        return crimeCount;
    }

    public void setCrimeCount(Integer crimeCount) {
        this.crimeCount = crimeCount;
    }

    public String getDominantCrimeType() {
        return dominantCrimeType;
    }

    public void setDominantCrimeType(String dominantCrimeType) {
        this.dominantCrimeType = dominantCrimeType;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getPeakHours() {
        return peakHours;
    }

    public void setPeakHours(String peakHours) {
        this.peakHours = peakHours;
    }

    public String getPredictedTrend() {
        return predictedTrend;
    }

    public void setPredictedTrend(String predictedTrend) {
        this.predictedTrend = predictedTrend;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String hotspotCode;
        private String district;
        private String locationName;
        private BigDecimal latitude;
        private BigDecimal longitude;
        private Integer crimeCount;
        private String dominantCrimeType;
        private String riskLevel;
        private String peakHours;
        private String predictedTrend;
        private OffsetDateTime createdAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder hotspotCode(String hotspotCode) {
            this.hotspotCode = hotspotCode;
            return this;
        }
        public Builder district(String district) {
            this.district = district;
            return this;
        }
        public Builder locationName(String locationName) {
            this.locationName = locationName;
            return this;
        }
        public Builder latitude(BigDecimal latitude) {
            this.latitude = latitude;
            return this;
        }
        public Builder longitude(BigDecimal longitude) {
            this.longitude = longitude;
            return this;
        }
        public Builder crimeCount(Integer crimeCount) {
            this.crimeCount = crimeCount;
            return this;
        }
        public Builder dominantCrimeType(String dominantCrimeType) {
            this.dominantCrimeType = dominantCrimeType;
            return this;
        }
        public Builder riskLevel(String riskLevel) {
            this.riskLevel = riskLevel;
            return this;
        }
        public Builder peakHours(String peakHours) {
            this.peakHours = peakHours;
            return this;
        }
        public Builder predictedTrend(String predictedTrend) {
            this.predictedTrend = predictedTrend;
            return this;
        }
        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CrimeHotspot build() {
            return new CrimeHotspot(this.id, this.hotspotCode, this.district, this.locationName, this.latitude, this.longitude, this.crimeCount, this.dominantCrimeType, this.riskLevel, this.peakHours, this.predictedTrend, this.createdAt);
        }
    }
}