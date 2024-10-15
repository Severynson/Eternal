package com.css.eternal.screens.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.css.eternal.EternalGame;
import com.css.eternal.screens.levels.Level1;
import com.badlogic.gdx.graphics.Color;

public class MainMenuScreen extends MenuScreen implements Screen {
    private final EternalGame game;

    public MainMenuScreen(EternalGame game) {
        super(game);
        this.game = game;
    }

    @Override
    public void show() {
        super.show();

        Label titleLabel = new Label("Main Menu", super.getSkin());
        titleLabel.setFontScale(3);
        titleLabel.setAlignment(Align.center);
        titleLabel.setColor(Color.DARK_GRAY);

        TextButton continueButton = new TextButton("Continue", super.getSkin());
        continueButton.getLabel().setFontScale(2);
        continueButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new SavesMenuScreen(game));
                return true;
            }
        });

        TextButton newGameButton = new TextButton("New Game", super.getSkin());
        newGameButton.getLabel().setFontScale(1.5f);
        newGameButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new Level1(game));
                return true;
            }
        });

        TextButton exitButton = new TextButton("Exit", super.getSkin());
        exitButton.getLabel().setFontScale(1.5f);
        exitButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                return true;
            }
        });

        Table menuTable = super.getMenuTable();

        menuTable.add(titleLabel).expandX().padTop(50).center().row();
        menuTable.add(continueButton).expandX().padTop(20).center().row();
        menuTable.add(newGameButton).expandX().padTop(20).center().row();
        menuTable.add(exitButton).expandX().padTop(20).center().row();
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