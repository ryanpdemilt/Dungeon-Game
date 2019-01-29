package com.mygdx.space.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Tile extends Actor {
    protected Position location;
    protected Texture texture;
    protected Grid grid;
    public Position getPosition(){
        return location;
    }
    public Texture getTexture(){
        return texture;
    }
    public void setPosition(Position p){
        location = p;
    }
    public boolean canMoveOn(){
        return true;
    }
    @Override
    public void draw(Batch batch, float f){
        batch.draw(texture,location.getBottomLeftX(),location.getBottomLeftY());
    }
}
