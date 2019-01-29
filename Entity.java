package com.mygdx.space.entities;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.space.items.Weapon;
import com.mygdx.space.utils.Direction;
import com.mygdx.space.utils.Grid;
import com.mygdx.space.utils.Position;
import com.mygdx.space.utils.Tile;

public abstract class Entity extends Tile {
    protected Grid grid;
    protected Weapon equippedWeapon;
    public abstract boolean canMove(Position p);
    public abstract void interact(Entity e);
    protected int health;
    protected int mana;
    protected int gold;
    public int getHealth(){
        return health;
    }
    public void setHealth(int n){
        health = n;
    }
    public int getMana(){
        return mana;
    }
    public void setMana(int n){
        mana = n;
    }
    public void damage(int damage){
        setHealth(getHealth() - damage);
    }
    public void updateCooldowns(){
        equippedWeapon.updateCooldowns();
    }
}