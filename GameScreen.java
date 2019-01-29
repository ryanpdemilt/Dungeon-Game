package com.mygdx.space;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.space.entities.*;
import com.mygdx.space.stages.AbstractStage;
import com.mygdx.space.stages.FirstStage;
import com.mygdx.space.utils.Combat;
import com.mygdx.space.utils.Constants;
import com.mygdx.space.utils.Direction;
import java.util.ArrayList;
import static com.mygdx.space.utils.Constants.gameState;

public class GameScreen implements Screen {
    private MainGame game;
    private ArrayList<AbstractStage> stages = new ArrayList<AbstractStage>();
    private AbstractStage currentStage;
    private Player player;
    private Combat battle;
    public GameScreen(MainGame g){
        game = g;
        callStages();
        currentStage = stages.get(0);
        player = currentStage.getPlayer();
        gameState = "GAME";
        Constants.gameScreen = this;
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(gameState.equals("GAME")){
            currentStage.getStage().act();
            currentStage.getStage().draw();

            if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
                player.move(Direction.UP);
                currentStage.update();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
                player.move(Direction.LEFT);
                currentStage.update();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
                player.move(Direction.DOWN);
                currentStage.update();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
                player.move(Direction.RIGHT);
                currentStage.update();
            }

        } else if(gameState.equals("PAUSE")){

        } else if(gameState.equals("BATTLE")){
            battle.act();
            battle.draw();
        } else if(gameState.equals("INVENTORY")){

        } else if(gameState.equals("DIALOG")){

        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
    private void callStages(){
        stages.add(new FirstStage(this));
    }
    public void advanceStage(){
        currentStage = stages.get(stages.indexOf(currentStage)+ 1);
    }
    public void battle(Player player, Enemy e){
        battle = new Combat(player,e);
        gameState = "BATTLE";
    }
    public void talk(){

    }
}
