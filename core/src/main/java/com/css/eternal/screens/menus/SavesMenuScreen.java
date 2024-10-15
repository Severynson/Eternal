package com.css.eternal.screens.menus;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.css.eternal.EternalGame;
import com.css.eternal.screens.levels.Level1;
import com.css.eternal.utils.SaveFilesManager;
import com.badlogic.gdx.graphics.Color;

public class SavesMenuScreen extends MenuScreen implements Screen {
    private final EternalGame game;
    private final SaveFilesManager saveFilesManager;

    public SavesMenuScreen(EternalGame game) {
        super(game);
        this.game = game;
        this.saveFilesManager = new SaveFilesManager();
    }

    private void displaySaveFiles() {
        Table menuTable = super.getMenuTable();
        Skin skin = super.getSkin();

        if (saveFilesManager.getSaves().isEmpty()) {
            Label noSavesLabel = new Label("No saves have been made yet. \nGo to the main menu \nto start a new game.",
                    skin);
            noSavesLabel.setFontScale(2);
            noSavesLabel.setAlignment(Align.center);
            noSavesLabel.setColor(Color.BLACK);
            menuTable.add(noSavesLabel).expandX().padTop(20).center().row();
        } else
            saveFilesManager.getSaves().forEach(save -> {
                TextButton saveButton = new TextButton(save.levelTitle + " - " + save.getLastModifiedFormatted(),
                        skin);
                saveButton.getLabel().setFontScale(1.5f);
                saveButton.addListener(new InputListener() {

                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        if (button == Buttons.LEFT) {
                            game.setScreen(new Level1(game)); // TODO: Implement level loading with save data.
                        } else if (button == Buttons.RIGHT) {
                            // saveFilesManager.deleteSaveFileByTitle(save.fileTitle);
                            Table deleteTable = new Table();
                            Label deleteLabel = new Label("Delete?", skin);
                            deleteLabel.setFontScale(2);
                            deleteLabel.setAlignment(Align.center);
                            deleteLabel.setColor(Color.BLACK);
                            deleteTable.add(deleteLabel).colspan(2).center().row();

                            TextButton yesButton = new TextButton("Yes", skin);
                            yesButton.getLabel().setFontScale(1.5f);
                            yesButton.setColor(Color.GREEN);
                            yesButton.addListener(new InputListener() {
                                @Override
                                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                                    saveFilesManager.deleteSaveFileByTitle(save.fileTitle);
                                    return true;
                                }
                            });

                            TextButton noButton = new TextButton("No", skin);
                            noButton.getLabel().setFontScale(1.5f);
                            noButton.setColor(Color.RED);
                            noButton.addListener(new InputListener() {
                                @Override
                                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                                    deleteTable.remove();
                                    return true;
                                }
                            });

                            deleteTable.add(yesButton).expandX().padTop(20).center();
                            deleteTable.add(noButton).expandX().padTop(20).center().row();

                            menuTable.add(deleteTable).expandX().padTop(20).center().row();
                        }
                        return true;
                    }
                });

                menuTable.add(saveButton).expandX().padTop(20).center().row();
            });

    }

    @Override
    public void show() {
        super.show();

        Label titleLabel = new Label("Saves", super.getSkin());
        titleLabel.setFontScale(3);
        titleLabel.setAlignment(Align.center);
        titleLabel.setColor(Color.DARK_GRAY);

        Table menuTable = super.getMenuTable();
        menuTable.add(titleLabel).expandX().padTop(50).center().row();

        TextButton exitButton = new TextButton("Back", super.getSkin());
        exitButton.getLabel().setFontScale(1.5f);
        exitButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new MainMenuScreen(game));
                return true;
            }
        });

        displaySaveFiles();

        menuTable.add(exitButton).expandX().padTop(20).center().bottom().row();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}