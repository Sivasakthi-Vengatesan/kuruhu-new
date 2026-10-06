package com.kuruhu.biometrics;

import java.io.Serializable;

public class BiometricMatchRequest implements Serializable {
    private String featureVector;
    private String modality;
    private String threshold;

    public BiometricMatchRequest() {}

    public String getFeatureVector() { return this.featureVector; }
    public void setFeatureVector(String featureVector) { this.featureVector = featureVector; }
    public String getModality() { return this.modality; }
    public void setModality(String modality) { this.modality = modality; }
    public String getThreshold() { return this.threshold; }
    public void setThreshold(String threshold) { this.threshold = threshold; }
}
