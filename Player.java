package com.mygdx.space.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.mygdx.space.items.IronSword;
import com.mygdx.space.items.Item;
import com.mygdx.space.items.Weapon;
import com.mygdx.space.utils.*;
import java.util.ArrayList;

public class Player extends Entity {
    private TextureRegionDrawable combatImage;
    private ArrayList<Item> inventory;


    public Player(Grid g, Position p){
        grid = g;
        location = p;
        health = 100;
        mana = 100;
        texture = new Texture(Gdx.files.internal("playerTest.png"));
        combatImage = new TextureRegionDrawable(new TextureRegion(texture));
        equippedWeapon = new IronSword();

    }
    public boolean canMove(Position p){
        if(grid.getTile(p) instanceof EmptyTile){
            return true;
        } else if(grid.getTile(p).canMoveOn()){
            return true;
        } else{
            return false;
        }
    }
    public Position getTargetPos(Direction d){
        switch(d){
            case DOWN:
                return new Position(location.getX(),location.getY() - 1);
            case LEFT:
                return new Position(location.getX() - 1, location.getY());
            case RIGHT:
                return new Position(location.getX() + 1, location.getY());
            case UP:
                return new Position(location.getX(),location.getY() + 1);
        }
        return null;
    }
    public void move(Direction d){
        Position target = getTargetPos(d);
        System.out.println(target.getX() + " " + target.getY());
        if(grid.inBounds(target)){
            if (canMove(target)) {
                Position oldPos = getPosition();
                location = target;
                grid.setTile(this);
                grid.setTile(new EmptyTile(oldPos));
            } else {
                Entity e = (Entity) grid.getTile(target);
                e.interact(this);
            }
        }
    }
    public boolean canMoveOn(){
        return false;
    }
    public void interact(Entity e){
        if(e instanceof Enemy){
            battle((Enemy) e);
        } else {

        }
    }
    public void battle(Enemy e){
        Constants.gameScreen.battle(this,e);
    }
    public TextureRegionDrawable getCombatImage(){
        return combatImage;
    }
    public Array<String> getMoveSet(){
        return equippedWeapon.getMoves();
    }
    public void attack(String s, Entity e){
        equippedWeapon.attack(s,e);
    }
}