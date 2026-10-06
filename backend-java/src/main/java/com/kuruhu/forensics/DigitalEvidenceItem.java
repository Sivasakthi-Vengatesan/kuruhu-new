package com.kuruhu.forensics;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "digitalevidenceitem_records")
public class DigitalEvidenceItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String deviceImei;
    private String macAddress;
    private String osVersion;
    private String diskImageHash;

    public DigitalEvidenceItem() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getDeviceImei() { return this.deviceImei; }
    public void setDeviceImei(String deviceImei) { this.deviceImei = deviceImei; }
    public String getMacAddress() { return this.macAddress; }
    public void setMacAddress(String macAddress) { this.macAddress = macAddress; }
    public String getOsVersion() { return this.osVersion; }
    public void setOsVersion(String osVersion) { this.osVersion = osVersion; }
    public String getDiskImageHash() { return this.diskImageHash; }
    public void setDiskImageHash(String diskImageHash) { this.diskImageHash = diskImageHash; }
}
