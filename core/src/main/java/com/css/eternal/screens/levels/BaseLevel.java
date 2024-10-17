package com.css.eternal.screens.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.css.eternal.EternalGame;
import com.badlogic.gdx.utils.viewport.FitViewport;

public abstract class BaseLevel implements Screen {
    private EternalGame game;
    private OrthographicCamera gameCamera;
    private Viewport gameViewport;

    public BaseLevel(EternalGame game) {
        this.game = game;
        gameCamera = new OrthographicCamera();
        gameCamera.setToOrtho(false, 1024, 768);
        gameViewport = new FitViewport(1024, 768, gameCamera);
    }

    public Viewport getViewport() {
        return gameViewport;
    }

    // Common properties and methods for all levels
    protected void setupCommonResources() {
        // Load common assets, initialize common variables
    }

    // Abstract methods for level-specific setup
    protected abstract void setupLevel();

    @Override
    public void resize(int width, int height) {
        gameViewport.update(width, height);
    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Set the batch. It takes a lot of PC's resources to do this.
        // Don't create a new SpriteBatch for each screen, always use the same one.
        SpriteBatch batch = game.getBatch();
        batch.setProjectionMatrix(gameCamera.combined);
        batch.begin();
        // Draw your game elements here
        batch.end();
    }

}