package com.pramaan.dto;


import java.util.ArrayList;
import java.util.List;

public class CrimePatternClusterDto {
    private String id;
    private String patternName;
    private String category;

    private List<String> affectedDistricts = new ArrayList<>();
    
    private int firCount;
    private int suspectsIdentified;
    private String moSignature;
    private String riskLevel; // critical, high, medium
    private String keyInsight;


    public CrimePatternClusterDto() {
    }

    public CrimePatternClusterDto(String id, String patternName, String category, List<String> affectedDistricts, int firCount, int suspectsIdentified, String moSignature, String riskLevel, String keyInsight) {
        this.id = id;
        this.patternName = patternName;
        this.category = category;
        this.affectedDistricts = affectedDistricts;
        this.firCount = firCount;
        this.suspectsIdentified = suspectsIdentified;
        this.moSignature = moSignature;
        this.riskLevel = riskLevel;
        this.keyInsight = keyInsight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatternName() {
        return patternName;
    }

    public void setPatternName(String patternName) {
        this.patternName = patternName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getAffectedDistricts() {
        return affectedDistricts;
    }

    public void setAffectedDistricts(List<String> affectedDistricts) {
        this.affectedDistricts = affectedDistricts;
    }

    public int getFirCount() {
        return firCount;
    }

    public void setFirCount(int firCount) {
        this.firCount = firCount;
    }

    public int getSuspectsIdentified() {
        return suspectsIdentified;
    }

    public void setSuspectsIdentified(int suspectsIdentified) {
        this.suspectsIdentified = suspectsIdentified;
    }

    public String getMoSignature() {
        return moSignature;
    }

    public void setMoSignature(String moSignature) {
        this.moSignature = moSignature;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getKeyInsight() {
        return keyInsight;
    }

    public void setKeyInsight(String keyInsight) {
        this.keyInsight = keyInsight;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String patternName;
        private String category;
        private List<String> affectedDistricts;
        private int firCount;
        private int suspectsIdentified;
        private String moSignature;
        private String riskLevel;
        private String keyInsight;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder patternName(String patternName) {
            this.patternName = patternName;
            return this;
        }
        public Builder category(String category) {
            this.category = category;
            return this;
        }
        public Builder affectedDistricts(List<String> affectedDistricts) {
            this.affectedDistricts = affectedDistricts;
            return this;
        }
        public Builder firCount(int firCount) {
            this.firCount = firCount;
            return this;
        }
        public Builder suspectsIdentified(int suspectsIdentified) {
            this.suspectsIdentified = suspectsIdentified;
            return this;
        }
        public Builder moSignature(String moSignature) {
            this.moSignature = moSignature;
            return this;
        }
        public Builder riskLevel(String riskLevel) {
            this.riskLevel = riskLevel;
            return this;
        }
        public Builder keyInsight(String keyInsight) {
            this.keyInsight = keyInsight;
            return this;
        }

        public CrimePatternClusterDto build() {
            return new CrimePatternClusterDto(this.id, this.patternName, this.category, this.affectedDistricts, this.firCount, this.suspectsIdentified, this.moSignature, this.riskLevel, this.keyInsight);
        }
    }
}