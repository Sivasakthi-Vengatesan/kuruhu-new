package com.pramaan.dto;

import jakarta.validation.constraints.NotBlank;

public class TtsRequest {

    @NotBlank(message = "Text is required")
    private String text;

    private String language = "en"; // en, kn, hi, ur

    private String speaker; // Anu, Mary, etc.

    private String speed = "moderate";

    private String pitch = "moderate";

    private String emotion = "neutral";


    public TtsRequest() {
    }

    public TtsRequest(String text, String language, String speaker, String speed, String pitch, String emotion) {
        this.text = text;
        this.language = language;
        this.speaker = speaker;
        this.speed = speed;
        this.pitch = pitch;
        this.emotion = emotion;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String text;
        private String language;
        private String speaker;
        private String speed;
        private String pitch;
        private String emotion;

        public Builder text(String text) {
            this.text = text;
            return this;
        }
        public Builder language(String language) {
            this.language = language;
            return this;
        }
        public Builder speaker(String speaker) {
            this.speaker = speaker;
            return this;
        }
        public Builder speed(String speed) {
            this.speed = speed;
            return this;
        }
        public Builder pitch(String pitch) {
            this.pitch = pitch;
            return this;
        }
        public Builder emotion(String emotion) {
            this.emotion = emotion;
            return this;
        }

        public TtsRequest build() {
            return new TtsRequest(this.text, this.language, this.speaker, this.speed, this.pitch, this.emotion);
        }
    }
}