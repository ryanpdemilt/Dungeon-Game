package com.mygdx.space.items;


import com.mygdx.space.entities.Entity;
import com.mygdx.space.utils.Attack;

import java.util.ArrayList;

public class IronSword extends Weapon{
    public IronSword(){
        attacks = new ArrayList<Attack>();
        attacks.add(new Attack("Slash",10));
        attacks.add(new Attack("Jab",20));
    }
    public void attack(String s,Entity e){
        for(Attack a: attacks){
            if(a.getName().equals(s)){
                a.use(e);
            }
        }
    }
}
