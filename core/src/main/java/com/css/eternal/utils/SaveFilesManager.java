package com.css.eternal.utils;

import java.util.ArrayList;
import java.util.List;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.Gdx;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class SaveFilesManager {

    private List<SaveFile> saves;
    private Gson gson;

    public SaveFilesManager() {
        this.saves = new ArrayList<>();
        this.gson = new Gson();
        this.saves = loadSaveFiles();
    }

    @FunctionalInterface
    public interface FileCallback {
        void process(FileHandle file);
    }

    private void forEachSaveFile(FileCallback callback) {
        FileHandle savesDir = Gdx.files.local("saves/");
        if (savesDir.exists() && savesDir.isDirectory()) {
            for (FileHandle file : savesDir.list()) {
                callback.process(file);
            }
        }
    }

    private List<SaveFile> loadSaveFiles() {
        forEachSaveFile(file -> {
            try {
                SaveFile saveFile = gson.fromJson(file.readString(), SaveFile.class);
                saves.add(saveFile);
            } catch (JsonSyntaxException e) {
                System.err.println("Error parsing JSON from file: " + file.name());
            }
        });
        return saves;
    }

    public List<SaveFile> getSaves() {
        return saves;
    }

    public boolean deleteSaveFileByTitle(String title) {
        forEachSaveFile(file -> {
            if (file.nameWithoutExtension().equals(title) && file.extension().equals("json")) {
                file.delete();
                saves.removeIf(save -> save.fileTitle.equals(title));
            }
        });
        return false;
    }

    public void saveSaveFile(SaveFile saveFile, String fileTitle) {
        FileHandle savesDir = Gdx.files.local("saves/");
        savesDir.child(fileTitle + ".json").writeString(gson.toJson(saveFile), false);
    }
}
