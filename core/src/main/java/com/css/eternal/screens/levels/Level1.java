package com.css.eternal.screens.levels;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.css.eternal.EternalGame;
import com.css.eternal.domain.Utterance;
import com.css.eternal.ui.DialogueBox;

public class Level1 extends BaseLevel {
    private Stage stage;
    private DialogueBox dialogueBox;

    public Level1(EternalGame game) {
        super(game);
    }

    @Override
    protected void setupLevel() {
        // Initialize the stage
        stage = new Stage(gameViewport);

        // Create and configure the dialogue box
        dialogueBox = new DialogueBox(new ArrayList<Utterance>() {
            {
                add(new Utterance("Player",
                        "Welcome to Level 1! Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
            }
        });

        // Add the dialogue box to the stage
        stage.addActor(dialogueBox);

        // Set the stage as the input processor
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
        // Gdx.gl.glClearColor(0, 0, 0, 1);
        // Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Dark-brown temporary color
        Gdx.gl.glClearColor(Color.BROWN.r, Color.BROWN.g, Color.BROWN.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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