package com.kuruhu.biometrics;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "voiceprintsample_records")
public class VoiceprintSample implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String audioSampleUri;
    private String pitchFrequency;
    private String speakerId;
    private String confidence;

    public VoiceprintSample() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getAudioSampleUri() { return this.audioSampleUri; }
    public void setAudioSampleUri(String audioSampleUri) { this.audioSampleUri = audioSampleUri; }
    public String getPitchFrequency() { return this.pitchFrequency; }
    public void setPitchFrequency(String pitchFrequency) { this.pitchFrequency = pitchFrequency; }
    public String getSpeakerId() { return this.speakerId; }
    public void setSpeakerId(String speakerId) { this.speakerId = speakerId; }
    public String getConfidence() { return this.confidence; }
    public void setConfidence(String confidence) { this.confidence = confidence; }
}
