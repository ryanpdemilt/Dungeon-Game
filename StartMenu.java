package com.mygdx.space;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class StartMenu implements Screen{
    private final MainGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    private TextButton startButton;
    private TextButton closeButton;
    private Texture startTextureUp = new Texture(Gdx.files.internal("badlogic.jpg"));
    private Texture startTextureDown = new Texture(Gdx.files.internal("testDown.png"));
    private Texture closeTextureUp = new Texture(Gdx.files.internal("testUp.png"));
    private Texture closeTextureDown = new Texture(Gdx.files.internal("testDown.png"));
    private Stage stage;

    public StartMenu(MainGame g){
        game = g;
        Skin skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));
        stage = new Stage(new ScreenViewport());

        Table root = new Table();
        root.setFillParent(true);
        stage.addActor(root);

        Table table = new Table(skin);
        table.setBackground("window-round");
        root.add(table).grow().padTop(25.0f).padBottom(25.0f).padLeft(125.0f).padRight(125.0f);

        Label title = new Label("Rise of the Empire",skin,"title");
        title.setAlignment(Align.right);
        title.setColor(Color.RED);
        table.add(title).left().padLeft(125.0f);

        table.row();
        Label subtitle = new Label("Adventures of the Wolf Knight and the Phoenix",skin,"subtitle");
        subtitle.setAlignment(Align.center);
        subtitle.setColor(Color.GRAY);
        subtitle.setWrap(true);
        table.add(subtitle).growX().padLeft(100.0f);

        table.row();
        Label choice = new Label("Journey Onward?",skin);
        choice.setAlignment(Align.left);
        choice.setColor(Color.WHITE);
        choice.setWrap(true);
        table.add(choice).growX().padLeft(20.0f);

        Table buttonTable = new Table();
        startButton = new TextButton("To Victory",skin,"arcade");
        startButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x,float y){
                if(isPressed()){
                    game.setScreen(new GameScreen(game));
                }
            }
        });
        buttonTable.add(startButton).expandX();

        buttonTable.row();
        closeButton = new TextButton("To Cowardice",skin,"arcade");
        closeButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x,float y){
                if(isPressed()){
                    System.exit(-1);
                }
            }
        });
        buttonTable.add(closeButton).expandX().padTop(25.0f);
        table.add(buttonTable).growX().right().padRight(25.0f);
        Gdx.input.setInputProcessor(stage);
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
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
        stage.dispose();
        startTextureDown.dispose();
        startTextureUp.dispose();
        closeTextureUp.dispose();
        closeTextureDown.dispose();
    }

}

