package com.css.eternal;

import com.badlogic.gdx.Game;

public class EternalGame extends Game {
    @Override
    public void create() {
        setScreen(new MainMenuScreen(this));
    }

    public void startLevel(int levelNumber) {
        setScreen(new LevelScreen(this, levelNumber));
    }

    public void showFirstPersonView() {
        setScreen(new FirstPersonScreen(this));
    }
}