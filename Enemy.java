package com.mygdx.space.entities;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.space.items.Weapon;
import com.mygdx.space.utils.Constants;
import com.mygdx.space.utils.EmptyTile;
import com.mygdx.space.utils.Position;

public abstract class Enemy extends Entity{
    protected TextureRegionDrawable combatImage;
    public abstract void attack(String s, Entity e);
    public abstract void getMove();
    public void interact(Entity e){
        Constants.player.battle(this);
    }
    public void die(){
        grid.setTile(new EmptyTile(getPosition()));
    }
    public TextureRegionDrawable getCombatImage(){
        return combatImage;
    }
}
