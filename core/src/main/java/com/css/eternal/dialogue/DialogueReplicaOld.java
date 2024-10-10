package com.css.eternal.dialogue;

public class DialogueReplicaOld {
    private String characterId;
    private String sentence;

    public DialogueReplicaOld(String characterId, String sentence) {
        this.characterId = characterId;
        this.sentence = sentence;
    }

    public String getCharacterId() {
        return characterId;
    }

    public String getSentence() {
        return sentence;
    }
}