package com.pramaan.dto;


import java.util.ArrayList;
import java.util.List;

public class ProactivePatrolRouteDto {
    private String id;
    private String routeName;
    private String district;
    private String assignedStation;

    private List<String> targetHotspots = new ArrayList<>();
    
    private String optimalTimeWindow;
    private int efficiencyScore;
    private String status; // active, scheduled, completed


    public ProactivePatrolRouteDto() {
    }

    public ProactivePatrolRouteDto(String id, String routeName, String district, String assignedStation, List<String> targetHotspots, String optimalTimeWindow, int efficiencyScore, String status) {
        this.id = id;
        this.routeName = routeName;
        this.district = district;
        this.assignedStation = assignedStation;
        this.targetHotspots = targetHotspots;
        this.optimalTimeWindow = optimalTimeWindow;
        this.efficiencyScore = efficiencyScore;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<String> getTargetHotspots() {
        return targetHotspots;
    }

    public void setTargetHotspots(List<String> targetHotspots) {
        this.targetHotspots = targetHotspots;
    }

    public String getOptimalTimeWindow() {
        return optimalTimeWindow;
    }

    public void setOptimalTimeWindow(String optimalTimeWindow) {
        this.optimalTimeWindow = optimalTimeWindow;
    }

    public int getEfficiencyScore() {
        return efficiencyScore;
    }

    public void setEfficiencyScore(int efficiencyScore) {
        this.efficiencyScore = efficiencyScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String routeName;
        private String district;
        private String assignedStation;
        private List<String> targetHotspots;
        private String optimalTimeWindow;
        private int efficiencyScore;
        private String status;

        public Builder id(String id) {
            this.id = id;
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
        public Builder targetHotspots(List<String> targetHotspots) {
            this.targetHotspots = targetHotspots;
            return this;
        }
        public Builder optimalTimeWindow(String optimalTimeWindow) {
            this.optimalTimeWindow = optimalTimeWindow;
            return this;
        }
        public Builder efficiencyScore(int efficiencyScore) {
            this.efficiencyScore = efficiencyScore;
            return this;
        }
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public ProactivePatrolRouteDto build() {
            return new ProactivePatrolRouteDto(this.id, this.routeName, this.district, this.assignedStation, this.targetHotspots, this.optimalTimeWindow, this.efficiencyScore, this.status);
        }
    }
}