package com.kuruhu.dto;

import java.io.Serializable;

public class VehicleDTO implements Serializable {

    private String id;
    private String registration;
    private String make;
    private String model;
    private String color;
    private String vehicleType;

    public VehicleDTO() {}

    public VehicleDTO(String id, String registration, String make, String model, String color, String vehicleType) {
        this.id = id;
        this.registration = registration;
        this.make = make;
        this.model = model;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getRegistration() { return registration; }
    public void setRegistration(String registration) { this.registration = registration; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String registration;
        private String make;
        private String model;
        private String color;
        private String vehicleType;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder registration(String registration) {
            this.registration = registration;
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

        public VehicleDTO build() {
            return new VehicleDTO(this.id, this.registration, this.make, this.model, this.color, this.vehicleType);
        }
    }
}
