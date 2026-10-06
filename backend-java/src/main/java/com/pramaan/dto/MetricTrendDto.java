package com.pramaan.dto;


import java.util.List;

public class MetricTrendDto {
    private List<Integer> series;
    private int delta;
    private String deltaLabel;


    public MetricTrendDto() {
    }

    public MetricTrendDto(List<Integer> series, int delta, String deltaLabel) {
        this.series = series;
        this.delta = delta;
        this.deltaLabel = deltaLabel;
    }

    public List<Integer> getSeries() {
        return series;
    }

    public void setSeries(List<Integer> series) {
        this.series = series;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }

    public String getDeltaLabel() {
        return deltaLabel;
    }

    public void setDeltaLabel(String deltaLabel) {
        this.deltaLabel = deltaLabel;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<Integer> series;
        private int delta;
        private String deltaLabel;

        public Builder series(List<Integer> series) {
            this.series = series;
            return this;
        }
        public Builder delta(int delta) {
            this.delta = delta;
            return this;
        }
        public Builder deltaLabel(String deltaLabel) {
            this.deltaLabel = deltaLabel;
            return this;
        }

        public MetricTrendDto build() {
            return new MetricTrendDto(this.series, this.delta, this.deltaLabel);
        }
    }
}