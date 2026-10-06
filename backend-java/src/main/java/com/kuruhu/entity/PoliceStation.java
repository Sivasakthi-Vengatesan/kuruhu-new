package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "policestations")
public class PoliceStation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stationCode")
    private String stationCode;

    @Column(name = "name")
    private String name;

    @Column(name = "district")
    private String district;

    @Column(name = "zone")
    private String zone;

    @Column(name = "contactNumber")
    private String contactNumber;

    @Column(name = "address")
    private String address;

    public PoliceStation() {
    }

    public PoliceStation(Long id, String stationCode, String name, String district, String zone, String contactNumber, String address) {
        this.id = id;
        this.stationCode = stationCode;
        this.name = name;
        this.district = district;
        this.zone = zone;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStationCode() { return stationCode; }
    public void setStationCode(String stationCode) { this.stationCode = stationCode; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getZone() { return zone; }
    public void setZone(String zone) { this.zone = zone; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String stationCode;
        private String name;
        private String district;
        private String zone;
        private String contactNumber;
        private String address;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder stationCode(String stationCode) {
            this.stationCode = stationCode;
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
        public Builder zone(String zone) {
            this.zone = zone;
            return this;
        }
        public Builder contactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }
        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public PoliceStation build() {
            return new PoliceStation(this.id, this.stationCode, this.name, this.district, this.zone, this.contactNumber, this.address);
        }
    }
}
