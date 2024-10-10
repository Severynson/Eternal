package com.css.eternal.ui;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.css.eternal.EternalGame;
import com.css.eternal.domain.Utterance;
import com.badlogic.gdx.graphics.Color;

// public class DialogueBox extends Table {
//     TextureRegion textureRegion;
//     private List<Utterance> utterances;
//     public Stage stage;
//     private Viewport viewport;
//     private Texture backgroundTexture;

//     public DialogueBox(List<Utterance> utterances) {
//         this.utterances = utterances;

//         viewport = new StretchViewport(1024, 768);
//         stage = new Stage(viewport);

//         // Load the background texture
//         backgroundTexture = new Texture(Gdx.files.internal("DialogueBox.png"));
//         // TextureRegionDrawable backgroundDrawable = new TextureRegionDrawable(new
//         // TextureRegion(backgroundTexture));
//         textureRegion = new TextureRegion(backgroundTexture);
//         TextureRegionDrawable backgroundDrawable = new TextureRegionDrawable(textureRegion);
//         this.setBackground(backgroundDrawable);

//         // Initial size and position setup
//         updateSizeAndPosition();

//         backgroundDrawable.setMinWidth(Gdx.graphics.getWidth());

//         // Add the DialogueBox to the stage
//         stage.addActor(this);

//     }

//     @Override
//     public void draw(Batch batch, float parentAlpha) {
//         // Ensure the viewport is updated to match the screen size
//         viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);

//         // Update size and position dynamically
//         updateSizeAndPosition();

//         // Debug: Print the current width and height
//         System.out.println("Screen Width: " + Gdx.graphics.getWidth());
//         System.out.println("DialogueBox Width: " + this.getWidth());
//         System.out.println("TextureRegion Width: " + textureRegion.getRegionWidth());
//         System.out.println("backgroundTexture Width: " + backgroundTexture.getWidth());
//         System.out.println("Stage Width: " + stage.getWidth());
//         System.out.println("Batch Width: " + batch.getProjectionMatrix().getValues()[0]);

//         // Draw the background texture to fill the DialogueBox
//         batch.draw(backgroundTexture, getX(), getY(), getWidth(), getHeight());

//         super.draw(batch, parentAlpha);
//     }

//     private void updateSizeAndPosition() {

//         this.setWidth(Gdx.graphics.getWidth());
//         this.setHeight(Gdx.graphics.getHeight() * 0.3f);
//         this.setPosition(0, 0);
//     }
// }

// import com.badlogic.gdx.graphics.Pixmap;
// import com.badlogic.gdx.graphics.Pixmap.Format;
// import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

// public class DialogueBox extends Table {
//     private List<Utterance> utterances;
//     public Stage stage;
//     private Viewport viewport;
//     private Texture backgroundTexture;
//     private BitmapFont font;
//     private Label dialogueLabel;
//     private Texture whiteTexture;

//     public DialogueBox(List<Utterance> utterances) {
//         this.utterances = utterances;

//         viewport = new StretchViewport(1024, 768);
//         stage = new Stage(viewport);

//         // Create a white pixmap
//         Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
//         pixmap.setColor(Color.WHITE);
//         pixmap.fill();

//         // Create a texture from the pixmap
//         whiteTexture = new Texture(pixmap);
//         pixmap.dispose(); // Dispose the pixmap to free resources

//         // Set the white texture as the background
//         // TextureRegionDrawable whiteBackground = new TextureRegionDrawable(new TextureRegion(whiteTexture));
//         // this.setBackground(whiteBackground);

//         // Load the background texture
//         backgroundTexture = new Texture(Gdx.files.internal("DialogueBox.png"));
//         TextureRegionDrawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundTexture));
//         // backgroundDrawable.setMinWidth(Gdx.graphics.getWidth());

//         this.setBackground(backgroundDrawable);

//         font = new BitmapFont();
//         Label.LabelStyle labelStyle = new Label.LabelStyle();
//         labelStyle.font = font;

//         dialogueLabel = new Label("", labelStyle);
//         dialogueLabel.setWrap(true);
//         dialogueLabel.setAlignment(Align.center);

//         add(dialogueLabel).expand().fill().center().pad(10);

//         // Initial size and position setup
//         updateSizeAndPosition();

//         // Add the DialogueBox to the stage
//         stage.addActor(this);
//     }

//     @Override
//     public void draw(Batch batch, float parentAlpha) {
//         // Ensure the viewport is updated to match the screen size
//         viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);

//         // Update size and position dynamically
//         updateSizeAndPosition();

//         // Debug: Print the current width and height
//         System.out.println("Screen Width: " + Gdx.graphics.getWidth());
//         System.out.println("DialogueBox Width: " + this.getWidth());
//         System.out.println("TextureRegion Width: " + backgroundTexture.getWidth());

//         // Draw the background texture to fill the DialogueBox
//         batch.draw(backgroundTexture, getX(), getY(), getWidth(), getHeight() / 3);

//         // Draw the rest of the DialogueBox
//         super.draw(batch, parentAlpha);
//     }

//     private void updateSizeAndPosition() {
//         this.setWidth(Gdx.graphics.getWidth());
//         this.setHeight(Gdx.graphics.getHeight() / 3);
//         this.setPosition(0, 0);
//     }

//     public void setDialogueText(String text) {
//         dialogueLabel.setText(text);
//     }

//     public void dispose() {
//         backgroundTexture.dispose();
//         font.dispose();
//         whiteTexture.dispose();
//     }
// }

public class DialogueBox extends Table {
    private List<Utterance> utterances;
    public Stage stage;
    private Viewport viewport;
    private Texture backgroundTexture;
    private BitmapFont font;
    private Label dialogueLabel;

    public DialogueBox(List<Utterance> utterances) {
        this.utterances = utterances;

        viewport = new StretchViewport(1024, 768);
        stage = new Stage(viewport);

        // Load the background texture
        backgroundTexture = new Texture(Gdx.files.internal("DialogueBox.png"));
        TextureRegion textureRegion = new TextureRegion(backgroundTexture);
        TextureRegionDrawable backgroundDrawable = new TextureRegionDrawable(textureRegion);

        // Set the drawable to fill the DialogueBox
        backgroundDrawable.setMinWidth(Gdx.graphics.getWidth());
        backgroundDrawable.setMinHeight(Gdx.graphics.getHeight() * 0.3f);
        this.setBackground(backgroundDrawable);

        font = new BitmapFont();
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;

        dialogueLabel = new Label("", labelStyle);
        dialogueLabel.setWrap(true);
        dialogueLabel.setAlignment(Align.center);

        // Add the label to the DialogueBox
        add(dialogueLabel).expand().fill().center().pad(10);

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
        // updateSizeAndPosition();

        // Debug: Print the current width and height
        System.out.println("Screen Width: " + Gdx.graphics.getWidth());
        System.out.println("DialogueBox Width: " + this.getWidth());
        System.out.println("TextureRegion Width: " + backgroundTexture.getWidth());

        // Draw the rest of the DialogueBox
        super.draw(batch, parentAlpha);
    }

    private void updateSizeAndPosition() {
        this.setWidth(Gdx.graphics.getWidth());
        this.setHeight(Gdx.graphics.getHeight() * 0.3f); // Set height to 30% of screen height
        this.setPosition(0, 0);
    }

    public void setDialogueText(String text) {
        dialogueLabel.setText(text);
    }

    public void dispose() {
        backgroundTexture.dispose();
        font.dispose();
    }
}