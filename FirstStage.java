package com.mygdx.space.stages;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.space.GameScreen;
import com.mygdx.space.entities.MysteryMan;
import com.mygdx.space.entities.Player;
import com.mygdx.space.utils.*;

public class FirstStage extends AbstractStage {
    public FirstStage(GameScreen s){
        screen = s;
        buildStage();
    }
    public void buildStage() {
        level = new Grid(4, 4);
        player = new Player(level, new Position(0, 0));
        Constants.player = player;
        MysteryMan combatTest = new MysteryMan(level, new Position(1,1));
        for (int i = 0; i < 4; i++) {
            for (int p = 0; p < 4; p++) {
                level.setTile(new EmptyTile(new Position(i, p)));
            }
        }
        level.setTile(player);
        level.setTile(combatTest);
        stage = new Stage(new ScreenViewport());
        stage.addActor(level.convertToTable());
    }

}
