package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class makeButton {
     Stage stage;
     TextureAtlas atlas;

     Skin skin;
     ImageButton button;
     int row;
     int column;
    ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();

    public makeButton(String pack, String specificFile, int x, int y, int width, int height,int row, int column){
        atlas = new TextureAtlas(Gdx.files.local(pack));
        skin = new Skin();
        skin.addRegions(atlas);


        this.row = row;
        this.column = column;

        style.up = skin.getDrawable(specificFile);
        button = new ImageButton(style);
        button.setPosition(x,y);
        button.setWidth(width);
        button.setHeight(height);

    }

    public void dispose(){
        atlas.dispose();
        skin.dispose();
    }
    public void setStyle(String specificFile){
        style.up = skin.getDrawable(specificFile);


    }

    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }
}
