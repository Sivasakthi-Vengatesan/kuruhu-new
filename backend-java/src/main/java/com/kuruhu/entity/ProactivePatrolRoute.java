package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "proactivepatrolroutes")
public class ProactivePatrolRoute implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "routeCode")
    private String routeCode;

    @Column(name = "name")
    private String name;

    @Column(name = "assignedStation")
    private String assignedStation;

    @Column(name = "priority")
    private String priority;

    @Column(name = "waypointsJson")
    private String waypointsJson;

    @Column(name = "patrolSchedule")
    private String patrolSchedule;

    public ProactivePatrolRoute() {
    }

    public ProactivePatrolRoute(Long id, String routeCode, String name, String assignedStation, String priority, String waypointsJson, String patrolSchedule) {
        this.id = id;
        this.routeCode = routeCode;
        this.name = name;
        this.assignedStation = assignedStation;
        this.priority = priority;
        this.waypointsJson = waypointsJson;
        this.patrolSchedule = patrolSchedule;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRouteCode() { return routeCode; }
    public void setRouteCode(String routeCode) { this.routeCode = routeCode; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAssignedStation() { return assignedStation; }
    public void setAssignedStation(String assignedStation) { this.assignedStation = assignedStation; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getWaypointsJson() { return waypointsJson; }
    public void setWaypointsJson(String waypointsJson) { this.waypointsJson = waypointsJson; }

    public String getPatrolSchedule() { return patrolSchedule; }
    public void setPatrolSchedule(String patrolSchedule) { this.patrolSchedule = patrolSchedule; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String routeCode;
        private String name;
        private String assignedStation;
        private String priority;
        private String waypointsJson;
        private String patrolSchedule;

        public Builder id(Long id) {
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
        public Builder waypointsJson(String waypointsJson) {
            this.waypointsJson = waypointsJson;
            return this;
        }
        public Builder patrolSchedule(String patrolSchedule) {
            this.patrolSchedule = patrolSchedule;
            return this;
        }

        public ProactivePatrolRoute build() {
            return new ProactivePatrolRoute(this.id, this.routeCode, this.name, this.assignedStation, this.priority, this.waypointsJson, this.patrolSchedule);
        }
    }
}
