package com.pramaan.dto;


public class BehavioralProfileDto {
    private String modusOperandiSignature;
    private int recidivismScore; // 0 - 100
    private String violencePropensity; // High, Medium, Low
    private String communicationFingerprint;
    private int accompliceRiskIndex; // 0 - 100


    public BehavioralProfileDto() {
    }

    public BehavioralProfileDto(String modusOperandiSignature, int recidivismScore, String violencePropensity, String communicationFingerprint, int accompliceRiskIndex) {
        this.modusOperandiSignature = modusOperandiSignature;
        this.recidivismScore = recidivismScore;
        this.violencePropensity = violencePropensity;
        this.communicationFingerprint = communicationFingerprint;
        this.accompliceRiskIndex = accompliceRiskIndex;
    }

    public String getModusOperandiSignature() {
        return modusOperandiSignature;
    }

    public void setModusOperandiSignature(String modusOperandiSignature) {
        this.modusOperandiSignature = modusOperandiSignature;
    }

    public int getRecidivismScore() {
        return recidivismScore;
    }

    public void setRecidivismScore(int recidivismScore) {
        this.recidivismScore = recidivismScore;
    }

    public String getViolencePropensity() {
        return violencePropensity;
    }

    public void setViolencePropensity(String violencePropensity) {
        this.violencePropensity = violencePropensity;
    }

    public String getCommunicationFingerprint() {
        return communicationFingerprint;
    }

    public void setCommunicationFingerprint(String communicationFingerprint) {
        this.communicationFingerprint = communicationFingerprint;
    }

    public int getAccompliceRiskIndex() {
        return accompliceRiskIndex;
    }

    public void setAccompliceRiskIndex(int accompliceRiskIndex) {
        this.accompliceRiskIndex = accompliceRiskIndex;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String modusOperandiSignature;
        private int recidivismScore;
        private String violencePropensity;
        private String communicationFingerprint;
        private int accompliceRiskIndex;

        public Builder modusOperandiSignature(String modusOperandiSignature) {
            this.modusOperandiSignature = modusOperandiSignature;
            return this;
        }
        public Builder recidivismScore(int recidivismScore) {
            this.recidivismScore = recidivismScore;
            return this;
        }
        public Builder violencePropensity(String violencePropensity) {
            this.violencePropensity = violencePropensity;
            return this;
        }
        public Builder communicationFingerprint(String communicationFingerprint) {
            this.communicationFingerprint = communicationFingerprint;
            return this;
        }
        public Builder accompliceRiskIndex(int accompliceRiskIndex) {
            this.accompliceRiskIndex = accompliceRiskIndex;
            return this;
        }

        public BehavioralProfileDto build() {
            return new BehavioralProfileDto(this.modusOperandiSignature, this.recidivismScore, this.violencePropensity, this.communicationFingerprint, this.accompliceRiskIndex);
        }
    }
}