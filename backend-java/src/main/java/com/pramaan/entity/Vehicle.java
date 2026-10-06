package com.pramaan.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_number", unique = true, nullable = false, length = 50)
    private String registrationNumber;

    @Column(length = 100)
    private String make;

    @Column(length = 100)
    private String model;

    @Column(length = 50)
    private String color;

    @Column(name = "registered_owner", length = 150)
    private String registeredOwner;

    @Column(name = "chassis_number_hash")
    private String chassisNumberHash;

    @Column(name = "engine_number_hash")
    private String engineNumberHash;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;

    @ManyToMany(mappedBy = "vehicles", fetch = FetchType.LAZY)
    private Set<Fir> firs = new HashSet<>();


    public Vehicle() {
    }

    public Vehicle(Long id, String registrationNumber, String make, String model, String color, String registeredOwner, String chassisNumberHash, String engineNumberHash, OffsetDateTime createdAt, Set<Fir> firs) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.color = color;
        this.registeredOwner = registeredOwner;
        this.chassisNumberHash = chassisNumberHash;
        this.engineNumberHash = engineNumberHash;
        this.createdAt = createdAt;
        this.firs = firs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getChassisNumberHash() {
        return chassisNumberHash;
    }

    public void setChassisNumberHash(String chassisNumberHash) {
        this.chassisNumberHash = chassisNumberHash;
    }

    public String getEngineNumberHash() {
        return engineNumberHash;
    }

    public void setEngineNumberHash(String engineNumberHash) {
        this.engineNumberHash = engineNumberHash;
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
        private String registrationNumber;
        private String make;
        private String model;
        private String color;
        private String registeredOwner;
        private String chassisNumberHash;
        private String engineNumberHash;
        private OffsetDateTime createdAt;
        private Set<Fir> firs;

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
        public Builder registeredOwner(String registeredOwner) {
            this.registeredOwner = registeredOwner;
            return this;
        }
        public Builder chassisNumberHash(String chassisNumberHash) {
            this.chassisNumberHash = chassisNumberHash;
            return this;
        }
        public Builder engineNumberHash(String engineNumberHash) {
            this.engineNumberHash = engineNumberHash;
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

        public Vehicle build() {
            return new Vehicle(this.id, this.registrationNumber, this.make, this.model, this.color, this.registeredOwner, this.chassisNumberHash, this.engineNumberHash, this.createdAt, this.firs);
        }
    }
}