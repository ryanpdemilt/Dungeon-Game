package com.mygdx.space.utils;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.space.entities.*;

public class Combat {
    private Player player;
    private Enemy opponent;
    private Stage display;
    private Skin skin;
    private boolean isPlayersTurn;
    private int turnCount;
    private ProgressBar playerHealth;
    private ProgressBar opponentHealth;
    private ProgressBar playerMana;
    private ProgressBar opponentMana;
    private SelectBox combatOptions;
    private boolean actionConfirm;
    public Combat(Player p, Enemy e){
        player = p;
        opponent = e;
        turnCount = 0;
        buildDisplay();
    }
    public void draw(){
        display.draw();
    }
    private void buildDisplay(){
        display = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(display);
        skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));

        skin.get("health", ProgressBar.ProgressBarStyle.class).knobBefore = skin.getTiledDrawable("progress-bar-health-knob");
        skin.get("mana", ProgressBar.ProgressBarStyle.class).knobBefore = skin.getTiledDrawable("progress-bar-mana-knob");

        Dialog dialog = new Dialog("Combat",skin);
        dialog.setFillParent(true);

        playerHealth = new ProgressBar(0,1000,1,false,skin,"health");
        playerHealth.setValue(500);
        dialog.getContentTable().add(playerHealth).left().grow().size(500,92);

        opponentHealth = new ProgressBar(0,1000,1,false,skin,"health");
        opponentHealth.setValue(500);
        dialog.getContentTable().add(opponentHealth).right().grow().size(500,92);

        dialog.getContentTable().row();
        playerMana = new ProgressBar(0,1000,1,false,skin,"mana");
        playerMana.setValue(500);
        dialog.getContentTable().add(playerMana).left().grow().size(500,92);

        opponentMana = new ProgressBar(0,1000,1,false,skin,"mana");
        opponentMana.setValue(500);
        dialog.getContentTable().add(opponentMana).right().grow().size(500,92);

        dialog.getContentTable().row();
        Table table = new Table();
        Image image = new Image(player.getCombatImage());
        image.setScaling(Scaling.fit);
        dialog.getContentTable().add(image).size(309,205).left().grow();
        image = new Image(opponent.getCombatImage());
        dialog.getContentTable().add(image).size(309,205).right().grow();

        dialog.getContentTable().row();
        table = new Table();
        combatOptions = new SelectBox(skin);
        combatOptions.setItems(player.getMoveSet());
        table.add(combatOptions);
        dialog.getContentTable().add(table).left().grow().size(309,205);

        dialog.getContentTable().row();
        Button button = new TextButton("Confirm",skin);
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(isPressed()){
                    playerAttack(combatOptions.getSelected().toString());
                }
            }
        });
        dialog.getContentTable().add(button).left().grow().size(150,100).padLeft(15.0f);
        display.addActor(dialog);
    }
    public void update(){
        playerHealth.setValue(player.getHealth()*10);
        opponentHealth.setValue(opponent.getHealth()*10);
        playerMana.setValue(player.getMana()*10);
        opponentMana.setValue(opponent.getMana()*10);
        combatOptions = new SelectBox(skin);
        combatOptions.setItems(player.getMoveSet());
    }
    private void nextTurn(){
        turnCount++;
        updateCooldowns();
        update();
    }
    public void enemyAttack(){
        opponent.attack("Slash",player);
    }
    public void playerAttack(String s){
        System.out.println("Attacked!");
        player.attack(s, opponent);
        System.out.println(opponent.getHealth());
        enemyAttack();
        if(opponent.getHealth() <= 0){
            win();
        } else if (player.getHealth() <= 0){
            lose();
        }
        nextTurn();
    }
    public void act(){
        display.act();
    }
    public void updateCooldowns(){
        player.updateCooldowns();
        opponent.updateCooldowns();
    }
    public void win(){
        Constants.gameState = "GAME";
        opponent.die();
    }
    public void lose(){
        System.exit(-1);
    }
}
