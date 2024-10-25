package com.css.eternal.screens.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.css.eternal.EternalGame;
import com.badlogic.gdx.graphics.Color;

public class MenuScreen implements Screen {
    private final EternalGame game;
    private Stage stage;
    private Skin skin;
    private Texture backgroundTexture;
    private Table menuTable;

    public MenuScreen(EternalGame game) {
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        this.skin = new Skin(Gdx.files.internal("uiskin.json"));
        this.backgroundTexture = new Texture(Gdx.files.internal("mandala-1.png"));
        this.menuTable = new Table();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setFillParent(true);
        stage.addActor(backgroundImage);

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        Table backgroundTable = new Table();
        backgroundTable.setBackground(skin.newDrawable("white", new Color(192, 192, 192, 0.65f)));
        backgroundTable.pad(20, 40, 20, 40);

        menuTable = new Table();
        backgroundTable.add(menuTable).center();
        table.add(backgroundTable).center().expand();
    }

    public Table getMenuTable() {
        return menuTable;
    }

    public Skin getSkin() {
        return skin;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
        skin.dispose();
        backgroundTexture.dispose();
    }
}