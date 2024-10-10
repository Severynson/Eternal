package com.css.eternal.screens.levels;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.css.eternal.EternalGame;
import com.css.eternal.domain.Utterance;
import com.css.eternal.scenes.Dialogue;
import com.css.eternal.ui.DialogueBox;

public class Level1 extends BaseLevel {
    private Stage stage;
    private DialogueBox dialogueBox;
    private Dialogue dialogue;

    public Level1(EternalGame game) {
        super(game);
    }

    @Override
    protected void setupLevel() {
        stage = new Stage(gameViewport);
        dialogue = new Dialogue();
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
    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().setProjectionMatrix(dialogue.stage.getCamera().combined);
        dialogue.stage.act(delta);
        dialogue.stage.draw();

        // Update and draw the stage
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}