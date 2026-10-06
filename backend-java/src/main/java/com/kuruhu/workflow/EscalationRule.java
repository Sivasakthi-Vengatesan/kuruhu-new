package com.kuruhu.workflow;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "escalationrule_records")
public class EscalationRule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String triggerCondition;
    private String escalationTarget;
    private String delayHours;

    public EscalationRule() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getTriggerCondition() { return this.triggerCondition; }
    public void setTriggerCondition(String triggerCondition) { this.triggerCondition = triggerCondition; }
    public String getEscalationTarget() { return this.escalationTarget; }
    public void setEscalationTarget(String escalationTarget) { this.escalationTarget = escalationTarget; }
    public String getDelayHours() { return this.delayHours; }
    public void setDelayHours(String delayHours) { this.delayHours = delayHours; }
}
