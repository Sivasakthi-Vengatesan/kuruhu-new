package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "casepartys")
public class CaseParty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firId")
    private Long firId;

    @Column(name = "personId")
    private Long personId;

    @Column(name = "role")
    private String role;

    @Column(name = "notes")
    private String notes;

    public CaseParty() {
    }

    public CaseParty(Long id, Long firId, Long personId, String role, String notes) {
        this.id = id;
        this.firId = firId;
        this.personId = personId;
        this.role = role;
        this.notes = notes;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getFirId() { return firId; }
    public void setFirId(Long firId) { this.firId = firId; }

    public Long getPersonId() { return personId; }
    public void setPersonId(Long personId) { this.personId = personId; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long firId;
        private Long personId;
        private String role;
        private String notes;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder firId(Long firId) {
            this.firId = firId;
            return this;
        }
        public Builder personId(Long personId) {
            this.personId = personId;
            return this;
        }
        public Builder role(String role) {
            this.role = role;
            return this;
        }
        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public CaseParty build() {
            return new CaseParty(this.id, this.firId, this.personId, this.role, this.notes);
        }
    }
}
