package com.mygdx.space.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ObjectFloatMap;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.space.entities.Friendly;
import com.mygdx.space.entities.Player;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Dialog {
    private Stage display;
    private Player player;
    private Friendly friend;
    private SelectBox dialogOptions;
    public Dialog(Player p, Friendly f){
        player = p;
        friend = f;
        build();
    }
    private void build(){
        display = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(display);
        Skin skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));

        Table root = new Table();
        root.setFillParent(true);
        display.addActor(root);

        Table table = new Table(skin);
        table.setBackground("window-round");
        root.add(table).grow().pad(25.0f);

        Label label = new Label(friend.getName(),skin);
        table.add(label).right().growX();

        table.row();
        table = new Table();
        Image image = new Image(player.getCombatImage());
        table.add(image).left().growX().expandY();
        image = new Image(friend.getTalkImage());
        table.add(image).right().growX().expandY();

        table.row();
        dialogOptions = new SelectBox(skin);
        dialogOptions.setItems(friend.getPlayerOptions());
        table.add(dialogOptions).left().growX().expandX();
        Label response = new Label(friend.getDialog(0),skin);
        response.setWrap(true);
        response.setAlignment(Align.right);
        table.add(response).right().growX();

        table.row();
        Button button = new TextButton("Confirm",skin);
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                friend.getResponse(dialogOptions.getSelected().toString());
            }
        });
        table.add(button).left().growX().padLeft(15.0f);

        display.addActor(root);
    }
    public void update(){

    }
}
