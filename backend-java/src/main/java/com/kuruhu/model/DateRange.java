package com.kuruhu.model;

import java.io.Serializable;

public class DateRange implements Serializable {
    private java.time.OffsetDateTime startDate;
    private java.time.OffsetDateTime endDate;
    private String timezone;

    public DateRange() {}

    public DateRange(java.time.OffsetDateTime startDate, java.time.OffsetDateTime endDate, String timezone) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.timezone = timezone;
    }

    public java.time.OffsetDateTime getStartDate() { return startDate; }
    public void setStartDate(java.time.OffsetDateTime startDate) { this.startDate = startDate; }

    public java.time.OffsetDateTime getEndDate() { return endDate; }
    public void setEndDate(java.time.OffsetDateTime endDate) { this.endDate = endDate; }

    public String getTimezone() { return timezone; }
    public void setTimezone(String timezone) { this.timezone = timezone; }
}
