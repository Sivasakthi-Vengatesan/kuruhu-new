package com.pramaan.dto;


import java.util.ArrayList;
import java.util.List;

public class VehicleDto {
    private String id;
    private String registration;
    private String make;
    private String color;

    private List<String> firIds = new ArrayList<>();


    public VehicleDto() {
    }

    public VehicleDto(String id, String registration, String make, String color, List<String> firIds) {
        this.id = id;
        this.registration = registration;
        this.make = make;
        this.color = color;
        this.firIds = firIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getFirIds() {
        return firIds;
    }

    public void setFirIds(List<String> firIds) {
        this.firIds = firIds;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String registration;
        private String make;
        private String color;
        private List<String> firIds;

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
        public Builder color(String color) {
            this.color = color;
            return this;
        }
        public Builder firIds(List<String> firIds) {
            this.firIds = firIds;
            return this;
        }

        public VehicleDto build() {
            return new VehicleDto(this.id, this.registration, this.make, this.color, this.firIds);
        }
    }
}