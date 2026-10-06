package com.kuruhu.intelligence;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "informantprofile_records")
public class InformantProfile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String informantCode;
    private String handlerOfficerBadge;
    private String reliabilityGrade;

    public InformantProfile() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getInformantCode() { return this.informantCode; }
    public void setInformantCode(String informantCode) { this.informantCode = informantCode; }
    public String getHandlerOfficerBadge() { return this.handlerOfficerBadge; }
    public void setHandlerOfficerBadge(String handlerOfficerBadge) { this.handlerOfficerBadge = handlerOfficerBadge; }
    public String getReliabilityGrade() { return this.reliabilityGrade; }
    public void setReliabilityGrade(String reliabilityGrade) { this.reliabilityGrade = reliabilityGrade; }
}
