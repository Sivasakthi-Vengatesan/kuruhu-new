package com.pramaan.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "person_aliases")
public class PersonAlias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column(name = "alias_name", nullable = false, length = 150)
    private String aliasName;


    public PersonAlias() {
    }

    public PersonAlias(Long id, Person person, String aliasName) {
        this.id = id;
        this.person = person;
        this.aliasName = aliasName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Person person;
        private String aliasName;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder person(Person person) {
            this.person = person;
            return this;
        }
        public Builder aliasName(String aliasName) {
            this.aliasName = aliasName;
            return this;
        }

        public PersonAlias build() {
            return new PersonAlias(this.id, this.person, this.aliasName);
        }
    }
}