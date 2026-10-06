package com.pramaan.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "location_records")
public class LocationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location_code", unique = true, length = 50)
    private String locationCode;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 150)
    private String area;

    @Column(nullable = false, length = 100)
    private String district;

    @Column(precision = 10, scale = 6)
    private BigDecimal latitude;

    @Column(precision = 10, scale = 6)
    private BigDecimal longitude;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;

    @ManyToMany(mappedBy = "locations", fetch = FetchType.LAZY)
    private Set<Fir> firs = new HashSet<>();


    public LocationRecord() {
    }

    public LocationRecord(Long id, String locationCode, String name, String area, String district, BigDecimal latitude, BigDecimal longitude, OffsetDateTime createdAt, Set<Fir> firs) {
        this.id = id;
        this.locationCode = locationCode;
        this.name = name;
        this.area = area;
        this.district = district;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdAt = createdAt;
        this.firs = firs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Fir> getFirs() {
        return firs;
    }

    public void setFirs(Set<Fir> firs) {
        this.firs = firs;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String locationCode;
        private String name;
        private String area;
        private String district;
        private BigDecimal latitude;
        private BigDecimal longitude;
        private OffsetDateTime createdAt;
        private Set<Fir> firs;

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
        public Builder area(String area) {
            this.area = area;
            return this;
        }
        public Builder district(String district) {
            this.district = district;
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
        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        public Builder firs(Set<Fir> firs) {
            this.firs = firs;
            return this;
        }

        public LocationRecord build() {
            return new LocationRecord(this.id, this.locationCode, this.name, this.area, this.district, this.latitude, this.longitude, this.createdAt, this.firs);
        }
    }
}