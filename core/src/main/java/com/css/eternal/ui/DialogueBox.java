package com.css.eternal.ui;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.css.eternal.EternalGame;
import com.css.eternal.domain.Utterance;

public class DialogueBox extends Table {
    TextureRegion textureRegion;
    private List<Utterance> utterances;
    public Stage stage;
    private Viewport viewport;
    private Texture backgroundTexture;

    public DialogueBox(List<Utterance> utterances) {
        this.utterances = utterances;

        viewport = new StretchViewport(1024, 768);
        stage = new Stage(viewport);

        // Load the background texture
        backgroundTexture = new Texture(Gdx.files.internal("DialogueBox.png"));
        // TextureRegionDrawable backgroundDrawable = new TextureRegionDrawable(new
        // TextureRegion(backgroundTexture));
        textureRegion = new TextureRegion(backgroundTexture);
        TextureRegionDrawable backgroundDrawable = new TextureRegionDrawable(textureRegion);
        this.setBackground(backgroundDrawable);

        // Initial size and position setup
        updateSizeAndPosition();

        // Add the DialogueBox to the stage
        stage.addActor(this);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // Ensure the viewport is updated to match the screen size
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);

        // Update size and position dynamically
        updateSizeAndPosition();

        // Debug: Print the current width and height
        System.out.println("Screen Width: " + Gdx.graphics.getWidth());
        System.out.println("DialogueBox Width: " + this.getWidth());
        System.out.println("TextureRegion Width: " + textureRegion.getRegionWidth());
        System.out.println("backgroundTexture Width: " + backgroundTexture.getWidth());


        // Draw the background texture to fill the DialogueBox
        batch.draw(backgroundTexture, getX(), getY(), getWidth(), getHeight());
  
        
        super.draw(batch, parentAlpha);
    }

    private void updateSizeAndPosition() {
        this.setWidth(Gdx.graphics.getWidth());
        this.setHeight(Gdx.graphics.getHeight() * 0.3f);
        this.setPosition(0, 0);
    }
}