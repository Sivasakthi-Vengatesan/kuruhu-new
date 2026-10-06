package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicles")
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registrationNumber")
    private String registrationNumber;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @Column(name = "vehicleType")
    private String vehicleType;

    @Column(name = "chassisNumber")
    private String chassisNumber;

    public Vehicle() {
    }

    public Vehicle(Long id, String registrationNumber, String make, String model, String color, String vehicleType, String chassisNumber) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.color = color;
        this.vehicleType = vehicleType;
        this.chassisNumber = chassisNumber;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public String getChassisNumber() { return chassisNumber; }
    public void setChassisNumber(String chassisNumber) { this.chassisNumber = chassisNumber; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String registrationNumber;
        private String make;
        private String model;
        private String color;
        private String vehicleType;
        private String chassisNumber;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder registrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
            return this;
        }
        public Builder make(String make) {
            this.make = make;
            return this;
        }
        public Builder model(String model) {
            this.model = model;
            return this;
        }
        public Builder color(String color) {
            this.color = color;
            return this;
        }
        public Builder vehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
            return this;
        }
        public Builder chassisNumber(String chassisNumber) {
            this.chassisNumber = chassisNumber;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this.id, this.registrationNumber, this.make, this.model, this.color, this.vehicleType, this.chassisNumber);
        }
    }
}
