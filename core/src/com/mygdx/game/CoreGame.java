package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.*;
import java.util.ArrayList;

public class CoreGame implements Screen {
    final MyGdxGame game;
    final Logic logic;
    OrthographicCamera camera;
    Texture grid;
    Texture p1;
    Texture p2;
    Texture draw;
    makeButton[][] buttons;
    Stage stage;
    static int turn = 0;
    float elapsedTime = 0;



    public CoreGame(final MyGdxGame game){

        this.game = game;
        logic = new Logic();
        buttons = new makeButton[3][3];



        camera = new OrthographicCamera();
        camera.setToOrtho(false,500,500);
        grid = new Texture(Gdx.files.internal("grid.png"));
        p1 = new Texture(Gdx.files.internal("player1.png"));
        p2 = new Texture(Gdx.files.internal("player2.png"));
        draw = new Texture(Gdx.files.internal("draw.png"));
        stage = new Stage(new ScreenViewport());
        stage.clear();
        Gdx.input.setInputProcessor(stage);

        // looping to instantiate a grid of buttons

        int h = 489;
        for (int i = 0; i < 3 ; i++){
            h -= 163;
            int g = 0;
            int currentI = i;
            for (int k = 0; k < 3 ; k++){
                int currentK = k;
                buttons[i][k] = new makeButton("transparent/transparent.pack","ticSpace",g,h,160,155,i,k);
                stage.addActor(buttons[i][k].button);
                buttons[i][k].button.addListener(new InputListener(){
                    /* if the button is touched, then it calls logic to see which player it is, then it calls the makebutton class
                    to set style up to either an x or o depending on what logic returns, after that it clears the buttons listeners
                    so that if the button has been clicked, it cannot be clicked again
                     */
        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
            if (logic.isIsPlayer1()) {
                logic.setBoard(buttons[currentI][currentK].getRow(),buttons[currentI][currentK].getColumn());
                buttons[currentI][currentK].setStyle("O");
                buttons[currentI][currentK].button.clearListeners();
                turn++;


            }else {
                logic.setBoard(buttons[currentI][currentK].getRow(), buttons[currentI][currentK].getColumn());
                buttons[currentI][currentK].setStyle("x");
                buttons[currentI][currentK].button.clearListeners();
                turn++;


            }
            return false;
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

        stage.act();
        stage.draw();

        game.batch.begin();
        if (logic.didYouWin()){
            if (logic.getPlayer()){
                game.batch.draw(p1,0,250);
                stage.clear();

            }
            else {
                game.batch.draw(p2,0,250);
                stage.clear();

            }
            elapsedTime += Gdx.graphics.getDeltaTime();
            if (elapsedTime > 5){

                dispose();
                Gdx.app.exit();
            }

        }else if (logic.didYouWin() == false && turn == 9){
            game.batch.draw(draw,0,250);
            stage.clear();

            elapsedTime += Gdx.graphics.getDeltaTime();
            if (elapsedTime > 5){

                dispose();
                Gdx.app.exit();
            }


        }



        game.batch.end();




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
        grid.dispose();
        stage.dispose();
        p1.dispose();
        p2.dispose();


    }
}
