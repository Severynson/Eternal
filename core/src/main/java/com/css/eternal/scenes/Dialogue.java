package com.css.eternal.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.css.eternal.EternalGame;

public class Dialogue {
    public Stage stage;
    private Viewport viewport;
    private Label countdownLabel;
    private EternalGame game;
    private int V_WIDTH;
    private int V_HEIGHT;

    public Dialogue() {
        V_WIDTH = Gdx.graphics.getWidth();
        V_HEIGHT = Gdx.graphics.getHeight();
        this.viewport = new StretchViewport(V_WIDTH, V_HEIGHT, new OrthographicCamera());
        this.game = EternalGame.getInstance();
        stage = new Stage(viewport);

        Table table = new Table();
        table.top();

        table.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() * 0.6f);

        // Setting table's background to black
        table.setBackground(
                new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("DialogueBox.png")))));

        countdownLabel = new Label("001", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(countdownLabel).expandX().padTop(10);

        stage.addActor(table);
    }

}
