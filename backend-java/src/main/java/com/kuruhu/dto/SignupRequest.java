package com.kuruhu.dto;

import java.io.Serializable;

public class SignupRequest implements Serializable {

    private String email;
    private String password;
    private String name;
    private String district;
    private String role;
    private String phone;

    public SignupRequest() {}

    public SignupRequest(String email, String password, String name, String district, String role, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.district = district;
        this.role = role;
        this.phone = phone;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String email;
        private String password;
        private String name;
        private String district;
        private String role;
        private String phone;

        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder password(String password) {
            this.password = password;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder district(String district) {
            this.district = district;
            return this;
        }
        public Builder role(String role) {
            this.role = role;
            return this;
        }
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public SignupRequest build() {
            return new SignupRequest(this.email, this.password, this.name, this.district, this.role, this.phone);
        }
    }
}
