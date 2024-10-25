package com.css.eternal.domain;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Utterance {
    String speakerID;
    String text;

    public Utterance(String speakerID, String text) {
        this.speakerID = speakerID;
        this.text = text;
    }

    private Sprite getCharacterByID() {
        // TODO: implement a real logic for this.
        return new Sprite();
    }

    public String getSpeakerID() {
        return speakerID;
    }

    public String getSpeakerName() {
        // TODO: implement a real logic for this.
        return "___PLACEHOLDER___";
    }

    public TextureRegionDrawable getSpeakerPicture() {
        // TODO: implement a real logic for this.
        return new TextureRegionDrawable();
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