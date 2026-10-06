package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "locationrecords")
public class LocationRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "locationCode")
    private String locationCode;

    @Column(name = "name")
    private String name;

    @Column(name = "district")
    private String district;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    public LocationRecord() {
    }

    public LocationRecord(Long id, String locationCode, String name, String district, Double latitude, Double longitude) {
        this.id = id;
        this.locationCode = locationCode;
        this.name = name;
        this.district = district;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLocationCode() { return locationCode; }
    public void setLocationCode(String locationCode) { this.locationCode = locationCode; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String locationCode;
        private String name;
        private String district;
        private Double latitude;
        private Double longitude;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder locationCode(String locationCode) {
            this.locationCode = locationCode;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder district(String district) {
            this.district = district;
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

        public LocationRecord build() {
            return new LocationRecord(this.id, this.locationCode, this.name, this.district, this.latitude, this.longitude);
        }
    }
}
