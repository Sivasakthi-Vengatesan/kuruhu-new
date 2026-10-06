package com.pramaan.dto;


public class SocioDemographicsDto {
    private String occupation;
    private String educationLevel;
    private String incomeBracket;
    private String originDistrict;
    private int familyLinksCount;
    private String economicRiskFactor; // High, Medium, Low


    public SocioDemographicsDto() {
    }

    public SocioDemographicsDto(String occupation, String educationLevel, String incomeBracket, String originDistrict, int familyLinksCount, String economicRiskFactor) {
        this.occupation = occupation;
        this.educationLevel = educationLevel;
        this.incomeBracket = incomeBracket;
        this.originDistrict = originDistrict;
        this.familyLinksCount = familyLinksCount;
        this.economicRiskFactor = economicRiskFactor;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getIncomeBracket() {
        return incomeBracket;
    }

    public void setIncomeBracket(String incomeBracket) {
        this.incomeBracket = incomeBracket;
    }

    public String getOriginDistrict() {
        return originDistrict;
    }

    public void setOriginDistrict(String originDistrict) {
        this.originDistrict = originDistrict;
    }

    public int getFamilyLinksCount() {
        return familyLinksCount;
    }

    public void setFamilyLinksCount(int familyLinksCount) {
        this.familyLinksCount = familyLinksCount;
    }

    public String getEconomicRiskFactor() {
        return economicRiskFactor;
    }

    public void setEconomicRiskFactor(String economicRiskFactor) {
        this.economicRiskFactor = economicRiskFactor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String occupation;
        private String educationLevel;
        private String incomeBracket;
        private String originDistrict;
        private int familyLinksCount;
        private String economicRiskFactor;

        public Builder occupation(String occupation) {
            this.occupation = occupation;
            return this;
        }
        public Builder educationLevel(String educationLevel) {
            this.educationLevel = educationLevel;
            return this;
        }
        public Builder incomeBracket(String incomeBracket) {
            this.incomeBracket = incomeBracket;
            return this;
        }
        public Builder originDistrict(String originDistrict) {
            this.originDistrict = originDistrict;
            return this;
        }
        public Builder familyLinksCount(int familyLinksCount) {
            this.familyLinksCount = familyLinksCount;
            return this;
        }
        public Builder economicRiskFactor(String economicRiskFactor) {
            this.economicRiskFactor = economicRiskFactor;
            return this;
        }

        public SocioDemographicsDto build() {
            return new SocioDemographicsDto(this.occupation, this.educationLevel, this.incomeBracket, this.originDistrict, this.familyLinksCount, this.economicRiskFactor);
        }
    }
}