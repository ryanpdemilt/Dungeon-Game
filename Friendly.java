package com.mygdx.space.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.mygdx.space.utils.Grid;
import com.mygdx.space.utils.Position;
import java.util.ArrayList;

public class Friendly extends Entity{
    private ArrayList<String> dialog;
    private String name;
    private TextureRegionDrawable talkImage;
    private int parent;
    public Friendly(Grid g, Texture t, Position p, String n){
        grid = g;
        texture = t;
        location = p;
        name = n;
        parent = 0;
    }
    public boolean canMove(Position p){
        return true;
    }
    public boolean canMoveOn(){
        return false;
    }
    public void interact(Entity e){

    }
    public TextureRegionDrawable getTalkImage(){
        return talkImage;
    }
    public Array<String> getPlayerOptions(){
        Array<String> options = new Array<String>();
        options.add(getLeftChild());
        options.add(getRightChild());
        return options;
    }
    public String getDialog(int n){
        parent = n;
        return dialog.get(n);
    }
    public int getResponse(String s){
        int parent = dialog.indexOf(s);
        int response = parent;
        return response;
    }
    private String getLeftChild(){
        return dialog.get(parent + 1);
    }
    private String getRightChild(){
        return dialog.get(parent + 2);
    }
}
