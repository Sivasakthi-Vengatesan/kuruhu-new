package com.kuruhu.dto;

import java.io.Serializable;

public class UpdatePersonRequest implements Serializable {

    private String name;
    private java.util.List<String> aliases;
    private int age;
    private String gender;
    private String role;
    private String risk;
    private String phone;
    private String address;

    public UpdatePersonRequest() {}

    public UpdatePersonRequest(String name, java.util.List<String> aliases, int age, String gender, String role, String risk, String phone, String address) {
        this.name = name;
        this.aliases = aliases;
        this.age = age;
        this.gender = gender;
        this.role = role;
        this.risk = risk;
        this.phone = phone;
        this.address = address;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public java.util.List<String> getAliases() { return aliases; }
    public void setAliases(java.util.List<String> aliases) { this.aliases = aliases; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getRisk() { return risk; }
    public void setRisk(String risk) { this.risk = risk; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private java.util.List<String> aliases;
        private int age;
        private String gender;
        private String role;
        private String risk;
        private String phone;
        private String address;

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder aliases(java.util.List<String> aliases) {
            this.aliases = aliases;
            return this;
        }
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }
        public Builder role(String role) {
            this.role = role;
            return this;
        }
        public Builder risk(String risk) {
            this.risk = risk;
            return this;
        }
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public UpdatePersonRequest build() {
            return new UpdatePersonRequest(this.name, this.aliases, this.age, this.gender, this.role, this.risk, this.phone, this.address);
        }
    }
}
