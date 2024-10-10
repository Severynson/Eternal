package com.css.eternal.domain;

public class Utterance {
    String speakerID;
    String text;

    public Utterance(String speakerID, String text) {
        this.speakerID = speakerID;
        this.text = text;
    }

    public String getSpeakerID() {
        return speakerID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSpeakerID(String speakerID) {
        this.speakerID = speakerID;
    }

}