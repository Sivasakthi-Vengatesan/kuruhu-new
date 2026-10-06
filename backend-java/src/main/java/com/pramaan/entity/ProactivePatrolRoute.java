package com.pramaan.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "proactive_patrol_routes")
public class ProactivePatrolRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "route_code", unique = true, length = 50)
    private String routeCode;

    @Column(name = "route_name", nullable = false, length = 255)
    private String routeName;

    @Column(nullable = false, length = 100)
    private String district;

    @Column(name = "assigned_station", nullable = false, length = 150)
    private String assignedStation;

    @Column(name = "target_hotspots", columnDefinition = "JSONB")
    private String targetHotspots;

    @Column(name = "optimal_time_window", nullable = false, length = 100)
    private String optimalTimeWindow;

    @Column(name = "efficiency_score")
    private Integer efficiencyScore = 90;

    @Column(length = 50)
    private String status = "active"; // active, scheduled, completed

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;


    public ProactivePatrolRoute() {
    }

    public ProactivePatrolRoute(Long id, String routeCode, String routeName, String district, String assignedStation, String targetHotspots, String optimalTimeWindow, Integer efficiencyScore, String status, OffsetDateTime createdAt) {
        this.id = id;
        this.routeCode = routeCode;
        this.routeName = routeName;
        this.district = district;
        this.assignedStation = assignedStation;
        this.targetHotspots = targetHotspots;
        this.optimalTimeWindow = optimalTimeWindow;
        this.efficiencyScore = efficiencyScore;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAssignedStation() {
        return assignedStation;
    }

    public void setAssignedStation(String assignedStation) {
        this.assignedStation = assignedStation;
    }

    public String getTargetHotspots() {
        return targetHotspots;
    }

    public void setTargetHotspots(String targetHotspots) {
        this.targetHotspots = targetHotspots;
    }

    public String getOptimalTimeWindow() {
        return optimalTimeWindow;
    }

    public void setOptimalTimeWindow(String optimalTimeWindow) {
        this.optimalTimeWindow = optimalTimeWindow;
    }

    public Integer getEfficiencyScore() {
        return efficiencyScore;
    }

    public void setEfficiencyScore(Integer efficiencyScore) {
        this.efficiencyScore = efficiencyScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String routeCode;
        private String routeName;
        private String district;
        private String assignedStation;
        private String targetHotspots;
        private String optimalTimeWindow;
        private Integer efficiencyScore;
        private String status;
        private OffsetDateTime createdAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder routeCode(String routeCode) {
            this.routeCode = routeCode;
            return this;
        }
        public Builder routeName(String routeName) {
            this.routeName = routeName;
            return this;
        }
        public Builder district(String district) {
            this.district = district;
            return this;
        }
        public Builder assignedStation(String assignedStation) {
            this.assignedStation = assignedStation;
            return this;
        }
        public Builder targetHotspots(String targetHotspots) {
            this.targetHotspots = targetHotspots;
            return this;
        }
        public Builder optimalTimeWindow(String optimalTimeWindow) {
            this.optimalTimeWindow = optimalTimeWindow;
            return this;
        }
        public Builder efficiencyScore(Integer efficiencyScore) {
            this.efficiencyScore = efficiencyScore;
            return this;
        }
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ProactivePatrolRoute build() {
            return new ProactivePatrolRoute(this.id, this.routeCode, this.routeName, this.district, this.assignedStation, this.targetHotspots, this.optimalTimeWindow, this.efficiencyScore, this.status, this.createdAt);
        }
    }
}