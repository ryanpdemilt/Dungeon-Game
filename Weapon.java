package com.mygdx.space.items;

import com.badlogic.gdx.utils.Array;
import com.mygdx.space.entities.Entity;
import com.mygdx.space.utils.Attack;
import java.util.ArrayList;

public abstract class Weapon extends Item{
    protected ArrayList<Attack> attacks;
    protected String itemDescription;
    public abstract void attack(String s,Entity e);
    public Array<String> getMoves(){
        Array<String> moves = new Array<String>();
        for(Attack a: attacks){
            if(a.checkCooldown()) {
                moves.add(a.getName() + " " + a.getCooldownTime());
            }
            else {
                moves.add(a.getName());
            }
        }
        return moves;
    }
    public void use(){
        System.out.println(itemDescription);
    }
    public void updateCooldowns(){
        for(Attack a: attacks){
            if(a.checkCooldown()){
                a.updateCooldown();
            }
        }
    }
}
