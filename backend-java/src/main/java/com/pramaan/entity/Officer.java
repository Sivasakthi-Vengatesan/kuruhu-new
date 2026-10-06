package com.pramaan.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "officers")
public class Officer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "badge_number", unique = true, nullable = false, length = 50)
    private String badgeNumber;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(name = "rank_title", nullable = false, length = 100)
    private String rankTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "police_station_id")
    private PoliceStation policeStation;

    @Column(length = 50)
    private String phone;

    @Column(length = 150)
    private String email;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;


    public Officer() {
    }

    public Officer(Long id, String badgeNumber, String name, String rankTitle, PoliceStation policeStation, String phone, String email, OffsetDateTime createdAt) {
        this.id = id;
        this.badgeNumber = badgeNumber;
        this.name = name;
        this.rankTitle = rankTitle;
        this.policeStation = policeStation;
        this.phone = phone;
        this.email = email;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRankTitle() {
        return rankTitle;
    }

    public void setRankTitle(String rankTitle) {
        this.rankTitle = rankTitle;
    }

    public PoliceStation getPoliceStation() {
        return policeStation;
    }

    public void setPoliceStation(PoliceStation policeStation) {
        this.policeStation = policeStation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String badgeNumber;
        private String name;
        private String rankTitle;
        private PoliceStation policeStation;
        private String phone;
        private String email;
        private OffsetDateTime createdAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder badgeNumber(String badgeNumber) {
            this.badgeNumber = badgeNumber;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder rankTitle(String rankTitle) {
            this.rankTitle = rankTitle;
            return this;
        }
        public Builder policeStation(PoliceStation policeStation) {
            this.policeStation = policeStation;
            return this;
        }
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Officer build() {
            return new Officer(this.id, this.badgeNumber, this.name, this.rankTitle, this.policeStation, this.phone, this.email, this.createdAt);
        }
    }
}