package com.pramaan.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "police_stations")
public class PoliceStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "station_code", unique = true, nullable = false, length = 50)
    private String stationCode;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 100)
    private String district;

    @Column(length = 100)
    private String state = "Karnataka";

    @Column(name = "jurisdiction_area", columnDefinition = "TEXT")
    private String jurisdictionArea;

    @Column(name = "contact_number", length = 50)
    private String contactNumber;

    @Column(precision = 10, scale = 6)
    private BigDecimal latitude;

    @Column(precision = 10, scale = 6)
    private BigDecimal longitude;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;

    public PoliceStation() {}

    public PoliceStation(Long id, String stationCode, String name, String district, String state,
                         String jurisdictionArea, String contactNumber, BigDecimal latitude,
                         BigDecimal longitude, OffsetDateTime createdAt) {
        this.id = id;
        this.stationCode = stationCode;
        this.name = name;
        this.district = district;
        this.state = state != null ? state : "Karnataka";
        this.jurisdictionArea = jurisdictionArea;
        this.contactNumber = contactNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdAt = createdAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String stationCode;
        private String name;
        private String district;
        private String state = "Karnataka";
        private String jurisdictionArea;
        private String contactNumber;
        private BigDecimal latitude;
        private BigDecimal longitude;
        private OffsetDateTime createdAt;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder stationCode(String stationCode) { this.stationCode = stationCode; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder district(String district) { this.district = district; return this; }
        public Builder state(String state) { this.state = state; return this; }
        public Builder jurisdictionArea(String jurisdictionArea) { this.jurisdictionArea = jurisdictionArea; return this; }
        public Builder contactNumber(String contactNumber) { this.contactNumber = contactNumber; return this; }
        public Builder latitude(BigDecimal latitude) { this.latitude = latitude; return this; }
        public Builder longitude(BigDecimal longitude) { this.longitude = longitude; return this; }
        public Builder createdAt(OffsetDateTime createdAt) { this.createdAt = createdAt; return this; }

        public PoliceStation build() {
            return new PoliceStation(id, stationCode, name, district, state, jurisdictionArea, contactNumber, latitude, longitude, createdAt);
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getStationCode() { return stationCode; }
    public void setStationCode(String stationCode) { this.stationCode = stationCode; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getJurisdictionArea() { return jurisdictionArea; }
    public void setJurisdictionArea(String jurisdictionArea) { this.jurisdictionArea = jurisdictionArea; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public BigDecimal getLatitude() { return latitude; }
    public void setLatitude(BigDecimal latitude) { this.latitude = latitude; }
    public BigDecimal getLongitude() { return longitude; }
    public void setLongitude(BigDecimal longitude) { this.longitude = longitude; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
}
