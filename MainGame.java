package com.mygdx.space;

import com.badlogic.gdx.Game;
import com.mygdx.space.utils.Constants;

public class MainGame extends Game {

	@Override
	public void create () {
		setScreen(new StartMenu(this));
		Constants.game = this;
	}
}
