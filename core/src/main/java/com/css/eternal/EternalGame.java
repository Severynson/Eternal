package com.css.eternal;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.css.eternal.screens.menus.MainMenuScreen;

public class EternalGame extends Game {
    private static EternalGame instance;
    public SpriteBatch batch;

    public static EternalGame getInstance() {
        return instance;
    }

    public int V_WIDTH;
    public int V_HEIGHT;

    @Override
    public void create() {
        V_WIDTH = Gdx.graphics.getWidth();
        V_HEIGHT = Gdx.graphics.getHeight();
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