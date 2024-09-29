package com.css.eternal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.graphics.Color;

public class MainMenuScreen implements Screen {
    private final EternalGame game;
    private Stage stage;
    private Skin skin;
    private Texture backgroundTexture;

    public MainMenuScreen(EternalGame game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        backgroundTexture = new Texture(Gdx.files.internal("mandala-1.png"));
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

        Table menuTable = new Table();
        backgroundTable.add(menuTable).center();
        table.add(backgroundTable).center().expand();

        Label titleLabel = new Label("Main Menu", skin);
        titleLabel.setFontScale(3);
        titleLabel.setAlignment(Align.center);
        titleLabel.setColor(Color.DARK_GRAY);

        TextButton continueButton = new TextButton("Continue", skin);
        continueButton.getLabel().setFontScale(2);
        continueButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                // TODO: Check for save files and show save selection screen
                // TODO: If no save files, disable button or show a message
                return true;
            }
        });

        TextButton newGameButton = new TextButton("New Game", skin);
        newGameButton.getLabel().setFontScale(1.5f);
        newGameButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new LevelScreen(game, 1));
                return true;
            }
        });

        TextButton exitButton = new TextButton("Exit", skin);
        exitButton.getLabel().setFontScale(1.5f);
        exitButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                return true;
            }
        });

        menuTable.add(titleLabel).expandX().padTop(50).center().row();
        menuTable.add(continueButton).expandX().padTop(20).center().row();
        menuTable.add(newGameButton).expandX().padTop(20).center().row();
        menuTable.add(exitButton).expandX().padTop(20).center().row();
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