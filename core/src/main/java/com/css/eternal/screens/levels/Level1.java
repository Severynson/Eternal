package com.css.eternal.screens.levels;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.css.eternal.EternalGame;
import com.css.eternal.domain.Utterance;
import com.css.eternal.scenes.Dialogue;
import java.util.List;

public class Level1 extends BaseLevel {
    private EternalGame game;
    private Stage stage;
    private Dialogue dialogue;
    private List<Utterance> firstDialoguesBlock;

    public Level1(EternalGame game) {
        super(game);
        this.game = game;
    }

    @Override
    protected void setupLevel() {
        stage = new Stage(super.getViewport());

        firstDialoguesBlock = new ArrayList<Utterance>();
        firstDialoguesBlock.add(new Utterance("Name 1",
                "1) Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
        firstDialoguesBlock.add(new Utterance("Name 2",
                "2) Different Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
        firstDialoguesBlock.add(new Utterance("Name 3",
                "3) One more different Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));

        dialogue = new Dialogue(game, firstDialoguesBlock);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void pause() {
        // super.pause();
    }

    @Override
    public void hide() {
        // super.hide();
    }

    @Override
    public void resume() {
        // super.resume();
    }

    @Override
    public void show() {
        setupCommonResources();
        setupLevel();
        Gdx.input.setInputProcessor(dialogue.getStage());
    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update and render the dialogue's stage
        Stage dialogueStage = dialogue.getStage();
        dialogueStage.act(delta);
        dialogueStage.draw();

        // Update and draw the stage of the level1
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        dialogue.getStage().getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}