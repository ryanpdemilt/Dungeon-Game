package com.mygdx.space.utils;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.mygdx.space.entities.Entity;
import com.mygdx.space.entities.Player;

public class Grid {
    private Tile[][] grid;
    ArrayList<Entity> entities = new ArrayList<Entity>();
    public Grid(int row, int col){
        grid = new Tile[row][col];
    }
    public void addEntity(Entity e) {
        entities.add(e);
    }
    public void setTile(Tile t){
        grid[t.getPosition().getX()][t.getPosition().getY()] = t;
    }
    public Table convertToTable(){
        Table root = new Table();
        root.setFillParent(true);

        Table world = new Table();
        for(Tile[] row: grid){
            for(Tile t : row){
                world.add(t);
            }
            world.row();
        }
        root.add(world).pad(25.0f);
        return root;
    }
    public Tile getTile(Position p){
        return grid[p.getX()][p.getY()];
    }
    public boolean inBounds(Position p) {
        return !(p.getX() >= grid.length || p.getY() >= grid.length || p.getY() < 0 || p.getX() < 0);
    }
}

