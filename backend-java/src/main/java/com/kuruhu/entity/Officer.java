package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "officers")
public class Officer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "badgeNumber")
    private String badgeNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "rank")
    private String rank;

    @Column(name = "stationName")
    private String stationName;

    @Column(name = "district")
    private String district;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "phone")
    private String phone;

    public Officer() {
    }

    public Officer(Long id, String badgeNumber, String name, String rank, String stationName, String district, String specialization, String phone) {
        this.id = id;
        this.badgeNumber = badgeNumber;
        this.name = name;
        this.rank = rank;
        this.stationName = stationName;
        this.district = district;
        this.specialization = specialization;
        this.phone = phone;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBadgeNumber() { return badgeNumber; }
    public void setBadgeNumber(String badgeNumber) { this.badgeNumber = badgeNumber; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRank() { return rank; }
    public void setRank(String rank) { this.rank = rank; }

    public String getStationName() { return stationName; }
    public void setStationName(String stationName) { this.stationName = stationName; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String badgeNumber;
        private String name;
        private String rank;
        private String stationName;
        private String district;
        private String specialization;
        private String phone;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder badgeNumber(String badgeNumber) {
            this.badgeNumber = badgeNumber;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder rank(String rank) {
            this.rank = rank;
            return this;
        }
        public Builder stationName(String stationName) {
            this.stationName = stationName;
            return this;
        }
        public Builder district(String district) {
            this.district = district;
            return this;
        }
        public Builder specialization(String specialization) {
            this.specialization = specialization;
            return this;
        }
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Officer build() {
            return new Officer(this.id, this.badgeNumber, this.name, this.rank, this.stationName, this.district, this.specialization, this.phone);
        }
    }
}
