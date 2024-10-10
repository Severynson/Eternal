package com.css.eternal.dialogue;

import java.util.ArrayList;
import java.util.List;

public class DialogueOld {
    private List<DialogueReplicaOld> dialogues;
    private int currentIndex;

    public DialogueOld() {
        this.dialogues = new ArrayList<DialogueReplicaOld>();
        this.currentIndex = 0;
    }

    public void addDialogue(DialogueReplicaOld dialogue) {
        dialogues.add(dialogue);
    }

    public DialogueReplicaOld getCurrentDialogue() {
        if (currentIndex < dialogues.size()) {
            return dialogues.get(currentIndex);
        }
        return null;
    }

    public void nextDialogue() {
        if (currentIndex < dialogues.size() - 1) {
            currentIndex++;
        }
    }

    public boolean hasNext() {
        return currentIndex < dialogues.size() - 1;
    }
}