package com.pramaan.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "fir_timelines")
public class FirTimeline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fir_id", nullable = false)
    private Fir fir;

    @Column(name = "event_time")
    private OffsetDateTime eventTime;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String detail;

    @Column(nullable = false, length = 150)
    private String actor;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;


    public FirTimeline() {
    }

    public FirTimeline(Long id, Fir fir, OffsetDateTime eventTime, String title, String detail, String actor, OffsetDateTime createdAt) {
        this.id = id;
        this.fir = fir;
        this.eventTime = eventTime;
        this.title = title;
        this.detail = detail;
        this.actor = actor;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fir getFir() {
        return fir;
    }

    public void setFir(Fir fir) {
        this.fir = fir;
    }

    public OffsetDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(OffsetDateTime eventTime) {
        this.eventTime = eventTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
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
        private Fir fir;
        private OffsetDateTime eventTime;
        private String title;
        private String detail;
        private String actor;
        private OffsetDateTime createdAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder fir(Fir fir) {
            this.fir = fir;
            return this;
        }
        public Builder eventTime(OffsetDateTime eventTime) {
            this.eventTime = eventTime;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }
        public Builder actor(String actor) {
            this.actor = actor;
            return this;
        }
        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public FirTimeline build() {
            return new FirTimeline(this.id, this.fir, this.eventTime, this.title, this.detail, this.actor, this.createdAt);
        }
    }
}