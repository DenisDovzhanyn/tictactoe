package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;

import java.awt.*;

public class MainMenu implements Screen {
    final MyGdxGame game;
    OrthographicCamera camera;
    Texture menuBackGround;
    Stage stage;
    TextureAtlas buttonsAtlas;
    Skin startSkin;
    ImageButton start;


// X AND O SHOULD BE AROUND 160 PIXELS L AND W
    public MainMenu(final MyGdxGame game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 500, 500);
        menuBackGround = new Texture(Gdx.files.internal("TicMenu.png"));

        buttonsAtlas = new TextureAtlas(Gdx.files.local("startbutton/startbutton.pack"));
        startSkin = new Skin();
        startSkin.addRegions(buttonsAtlas);
        stage = new Stage(new ScreenViewport());
        stage.clear();
        Gdx.input.setInputProcessor(stage);

        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
        style.up = startSkin.getDrawable("startBeforePress");
        style.down = startSkin.getDrawable("startAfterPress");
        start = new ImageButton(style);
        start.setPosition(100,100);
        start.setHeight(150);
        start.setWidth(300);

        start.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new CoreGame(game));

                return true;

            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
        });

        stage.addActor(start);







    }



    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0,0,0,0);
        game.batch.setProjectionMatrix(camera.combined);

        camera.update();
        game.batch.begin();
        game.batch.draw(menuBackGround,0,0);

        game.batch.end();
        stage.act();
        stage.draw();


    }

    @Override
    public void resize(int i, int i1) {

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
        buttonsAtlas.dispose();
        startSkin.dispose();
        menuBackGround.dispose();


    }
}
