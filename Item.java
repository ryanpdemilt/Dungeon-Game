package com.mygdx.space.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.space.entities.Entity;
import com.mygdx.space.utils.Tile;

public abstract class Item extends Actor {
    protected Tile tile;
    protected int value;
    protected Entity owner;
    public int getValue(){
        return value;
    }
    public void trade(Entity e){
        owner = e;
    }
    public abstract void use();
}
