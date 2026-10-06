package com.pramaan.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class CreateVehicleRequest {

    @NotBlank(message = "Registration number is required")
    private String registrationNumber;

    private String make;

    private String model;

    private String color;

    private String registeredOwner;

    private List<Long> firIds;


    public CreateVehicleRequest() {
    }

    public CreateVehicleRequest(String registrationNumber, String make, String model, String color, String registeredOwner, List<Long> firIds) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.color = color;
        this.registeredOwner = registeredOwner;
        this.firIds = firIds;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegisteredOwner() {
        return registeredOwner;
    }

    public void setRegisteredOwner(String registeredOwner) {
        this.registeredOwner = registeredOwner;
    }

    public List<Long> getFirIds() {
        return firIds;
    }

    public void setFirIds(List<Long> firIds) {
        this.firIds = firIds;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String registrationNumber;
        private String make;
        private String model;
        private String color;
        private String registeredOwner;
        private List<Long> firIds;

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
        public Builder registeredOwner(String registeredOwner) {
            this.registeredOwner = registeredOwner;
            return this;
        }
        public Builder firIds(List<Long> firIds) {
            this.firIds = firIds;
            return this;
        }

        public CreateVehicleRequest build() {
            return new CreateVehicleRequest(this.registrationNumber, this.make, this.model, this.color, this.registeredOwner, this.firIds);
        }
    }
}