package com.pramaan.dto;


public class WeeklyIntakeDto {
    private String day;
    private long count;


    public WeeklyIntakeDto() {
    }

    public WeeklyIntakeDto(String day, long count) {
        this.day = day;
        this.count = count;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String day;
        private long count;

        public Builder day(String day) {
            this.day = day;
            return this;
        }
        public Builder count(long count) {
            this.count = count;
            return this;
        }

        public WeeklyIntakeDto build() {
            return new WeeklyIntakeDto(this.day, this.count);
        }
    }
}