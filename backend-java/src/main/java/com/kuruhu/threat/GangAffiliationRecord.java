package com.kuruhu.threat;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "gangaffiliationrecord_records")
public class GangAffiliationRecord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String personId;
    private String gangId;
    private String roleInGang;
    private String knownAliases;

    public GangAffiliationRecord() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getPersonId() { return this.personId; }
    public void setPersonId(String personId) { this.personId = personId; }
    public String getGangId() { return this.gangId; }
    public void setGangId(String gangId) { this.gangId = gangId; }
    public String getRoleInGang() { return this.roleInGang; }
    public void setRoleInGang(String roleInGang) { this.roleInGang = roleInGang; }
    public String getKnownAliases() { return this.knownAliases; }
    public void setKnownAliases(String knownAliases) { this.knownAliases = knownAliases; }
}
