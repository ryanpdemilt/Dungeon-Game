package com.mygdx.space.stages;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.space.GameScreen;
import com.mygdx.space.entities.Player;
import com.mygdx.space.utils.Grid;

public abstract class AbstractStage{
    protected Stage stage;
    protected Grid level;
    protected GameScreen screen;
    protected Player player;
    private int[] cameraBounds;
    public abstract void buildStage();
    public Stage getStage(){
        return stage;
    }
    public void advanceStage(){
        screen.advanceStage();
    }
    public Player getPlayer(){
        return player;
    }
    public void update(){
        stage = new Stage(new ScreenViewport());
        stage.addActor(level.convertToTable());
    }
}
