package com.kuruhu.dto;

import java.io.Serializable;

public class PatrolRouteDTO implements Serializable {

    private String id;
    private String routeCode;
    private String name;
    private String assignedStation;
    private String priority;
    private String patrolSchedule;

    public PatrolRouteDTO() {}

    public PatrolRouteDTO(String id, String routeCode, String name, String assignedStation, String priority, String patrolSchedule) {
        this.id = id;
        this.routeCode = routeCode;
        this.name = name;
        this.assignedStation = assignedStation;
        this.priority = priority;
        this.patrolSchedule = patrolSchedule;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getRouteCode() { return routeCode; }
    public void setRouteCode(String routeCode) { this.routeCode = routeCode; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAssignedStation() { return assignedStation; }
    public void setAssignedStation(String assignedStation) { this.assignedStation = assignedStation; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getPatrolSchedule() { return patrolSchedule; }
    public void setPatrolSchedule(String patrolSchedule) { this.patrolSchedule = patrolSchedule; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String routeCode;
        private String name;
        private String assignedStation;
        private String priority;
        private String patrolSchedule;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder routeCode(String routeCode) {
            this.routeCode = routeCode;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder assignedStation(String assignedStation) {
            this.assignedStation = assignedStation;
            return this;
        }
        public Builder priority(String priority) {
            this.priority = priority;
            return this;
        }
        public Builder patrolSchedule(String patrolSchedule) {
            this.patrolSchedule = patrolSchedule;
            return this;
        }

        public PatrolRouteDTO build() {
            return new PatrolRouteDTO(this.id, this.routeCode, this.name, this.assignedStation, this.priority, this.patrolSchedule);
        }
    }
}
