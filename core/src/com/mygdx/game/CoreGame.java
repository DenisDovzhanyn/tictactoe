package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;
import java.util.ArrayList;

public class CoreGame implements Screen {
    final MyGdxGame game;
   final Logic logic;
    OrthographicCamera camera;
    Texture grid;
    makeButton[][] buttons;



    public CoreGame(final MyGdxGame game){
        this.game = game;
        logic = new Logic();
        buttons = new makeButton[3][3];

        camera = new OrthographicCamera();
        camera.setToOrtho(false,500,500);
        grid = new Texture(Gdx.files.internal("grid.png"));

        // looping to instantiate a grid of buttons

        int h = -163;
        for (int i = 0; i < 3 ; i++){
            h += 163;
            int g = 0;
            int currentI = i;
            for (int k = 0; k < 3 ; k++){
                int currentK = k;
                buttons[i][k] = new makeButton("transparent/transparent.pack","ticSpace",g,h,160,155,i,k);
                buttons[i][k].button.addListener(new InputListener(){
        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
            if (logic.isIsPlayer1()) {
                logic.setBoard(buttons[currentI][currentK].getRow(),buttons[currentI][currentK].getColumn());
                buttons[currentI][currentK].setStyle("O");
                buttons[currentI][currentK].button.clearListeners();

            }else {
                logic.setBoard(buttons[currentI][currentK].getRow(), buttons[currentI][currentK].getColumn());
                buttons[currentI][currentK].setStyle("x");
                buttons[currentI][currentK].button.clearListeners();
            }
            return true;
        }
    });
                g += 170;
            }
        }

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0,0,0,0);
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(grid,0,0);
        game.batch.end();
        for (int i = 0; i < buttons.length; i++){
            for (int k = 0; k < buttons.length; k++){
                buttons[i][k].stage.act();
                buttons[i][k].stage.draw();

            }


        }




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
        game.dispose();


    }
}
