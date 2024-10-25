package com.css.eternal.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.css.eternal.EternalGame;
import com.css.eternal.domain.Utterance;
import java.util.List;

public class Dialogue {
    public Stage stage;
    private Viewport viewport;
    private BitmapFont font;
    private Label utteranceLabel;
    private Label interlocutorNameLabel;
    private Label buttonLeftLabel;
    private Label buttonRightLabel;
    private List<Utterance> utterances;
    private int currentIndex = 0;

    public Dialogue(EternalGame game, List<Utterance> utterances) {
        this.utterances = utterances;
        this.viewport = new StretchViewport(game.V_WIDTH, game.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport);

        font = new BitmapFont();
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;

        Table table = new Table();
        interlocutorNameLabel = new Label("", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        utteranceLabel = new Label("", labelStyle);
        buttonLeftLabel = new Label("<<", labelStyle);
        buttonRightLabel = new Label(">>", labelStyle);

        table.top();
        table.setSize(game.V_WIDTH, game.V_HEIGHT * 0.6f);
        table.setBackground(
                new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("DialogueBox.png")))));

        table.add(interlocutorNameLabel).expandX().padTop(40).left().padLeft(10).colspan(2);
        table.row();
        table.add(utteranceLabel).expand().fill().center().pad(10).colspan(2);
        table.row();
        table.add(buttonLeftLabel).expandX().right().pad(10);
        table.add(buttonRightLabel).expandX().left().pad(10);

        utteranceLabel.setWrap(true);
        utteranceLabel.setAlignment(Align.center);

        stage.addActor(table);

        updateDialogue();

        // Add listeners for button clicks
        buttonLeftLabel.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (currentIndex > 0) {
                    currentIndex--;
                    updateDialogue();
                }
                return true;
            }
        });

        buttonRightLabel.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (currentIndex < utterances.size() - 1) {
                    currentIndex++;
                    updateDialogue();
                }
                return true;
            }
        });

        Gdx.input.setInputProcessor(stage);
    }

    private void updateDialogue() {
        Utterance currentUtterance = utterances.get(currentIndex);
        interlocutorNameLabel.setText(currentUtterance.getSpeakerID());
        utteranceLabel.setText(currentUtterance.getText());
    }

    public Stage getStage() {
        return stage;
    }

    public Viewport getViewport() {
        return viewport;
    }
}
