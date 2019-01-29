package com.mygdx.space.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.space.items.IronSword;
import com.mygdx.space.utils.Grid;
import com.mygdx.space.utils.Position;

public class MysteryMan extends Enemy{
    public MysteryMan(Grid g, Position p){
        grid = g;
        location = p;
        health = 100;
        mana = 100;
        texture = new Texture(Gdx.files.internal("mysteryMan.png"));
        combatImage = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("mysteryMan.png"))));
        equippedWeapon = new IronSword();
    }
    public void attack(String s, Entity e){
        equippedWeapon.attack(s,e);
    }
    public void getMove(){

    }
    public boolean canMove(Position position){
        return true;
    }
    public boolean canMoveOn(){
        return false;
    }
}
