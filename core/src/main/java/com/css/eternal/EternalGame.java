package com.css.eternal;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.css.eternal.screens.MainMenuScreen;

public class EternalGame extends Game {
    private static EternalGame instance;
    private SpriteBatch batch;

    public static EternalGame getInstance() {
        return instance;
    }

    @Override
    public void create() {
        instance = this;
        batch = new SpriteBatch();
        setScreen(new MainMenuScreen(this));
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    @Override
    public void dispose() {
        batch.dispose();
        super.dispose();
    }
}