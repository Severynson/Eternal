package com.css.eternal.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.css.eternal.EternalGame;
import com.css.eternal.domain.Utterance;

public class Dialogue {
    public Stage stage;
    private Viewport viewport;
    private BitmapFont font;
    private Label utteranceLabel;
    private Label interlocutorNameLabel;
    private List<Utterance> utterances;

    public Dialogue(EternalGame game, List<Utterance> utterances) {
        this.utterances = utterances;
        this.viewport = new StretchViewport(game.V_WIDTH, game.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport);

        font = new BitmapFont();
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;

        Table table = new Table();
        interlocutorNameLabel = new Label("Name", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        utteranceLabel = new Label(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                labelStyle);

        table.top();
        table.setSize(game.V_WIDTH, game.V_HEIGHT * 0.6f);
        table.setBackground(
                new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("DialogueBox.png")))));

        table.add(interlocutorNameLabel).expandX().padTop(40).left().padLeft(10);
        table.row();
        table.add(utteranceLabel).expand().fill().center().pad(10);

        utteranceLabel.setWrap(true);
        utteranceLabel.setAlignment(Align.center);

        stage.addActor(table);
    }

}
