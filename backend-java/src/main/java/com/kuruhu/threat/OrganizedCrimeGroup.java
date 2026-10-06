package com.kuruhu.threat;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "organizedcrimegroup_records")
public class OrganizedCrimeGroup implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gangName;
    private String leaderName;
    private String territory;
    private String activeMembersCount;

    public OrganizedCrimeGroup() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getGangName() { return this.gangName; }
    public void setGangName(String gangName) { this.gangName = gangName; }
    public String getLeaderName() { return this.leaderName; }
    public void setLeaderName(String leaderName) { this.leaderName = leaderName; }
    public String getTerritory() { return this.territory; }
    public void setTerritory(String territory) { this.territory = territory; }
    public String getActiveMembersCount() { return this.activeMembersCount; }
    public void setActiveMembersCount(String activeMembersCount) { this.activeMembersCount = activeMembersCount; }
}
