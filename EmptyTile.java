package com.mygdx.space.utils;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class EmptyTile extends Tile{
    public EmptyTile(Position l){
        texture = new Texture(Gdx.files.internal("empty.png"));
        location = l;
    }
    public boolean canMoveOn(){
        return true;
    }
}
