package com.pramaan.dto;


public class CrimeHotspotDto {
    private String id;
    private String district;
    private String locationName;
    private double lat;
    private double lng;
    private int crimeCount;
    private String dominantCrimeType;
    private String riskLevel; // critical, high, moderate
    private String peakHours;
    private String predictedTrend; // increasing, stable, decreasing


    public CrimeHotspotDto() {
    }

    public CrimeHotspotDto(String id, String district, String locationName, double lat, double lng, int crimeCount, String dominantCrimeType, String riskLevel, String peakHours, String predictedTrend) {
        this.id = id;
        this.district = district;
        this.locationName = locationName;
        this.lat = lat;
        this.lng = lng;
        this.crimeCount = crimeCount;
        this.dominantCrimeType = dominantCrimeType;
        this.riskLevel = riskLevel;
        this.peakHours = peakHours;
        this.predictedTrend = predictedTrend;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getCrimeCount() {
        return crimeCount;
    }

    public void setCrimeCount(int crimeCount) {
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String district;
        private String locationName;
        private double lat;
        private double lng;
        private int crimeCount;
        private String dominantCrimeType;
        private String riskLevel;
        private String peakHours;
        private String predictedTrend;

        public Builder id(String id) {
            this.id = id;
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
        public Builder lat(double lat) {
            this.lat = lat;
            return this;
        }
        public Builder lng(double lng) {
            this.lng = lng;
            return this;
        }
        public Builder crimeCount(int crimeCount) {
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

        public CrimeHotspotDto build() {
            return new CrimeHotspotDto(this.id, this.district, this.locationName, this.lat, this.lng, this.crimeCount, this.dominantCrimeType, this.riskLevel, this.peakHours, this.predictedTrend);
        }
    }
}