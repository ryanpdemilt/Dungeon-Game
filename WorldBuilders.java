package com.mygdx.space.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class WorldBuilders {
    public static World generateTopDownWorld() {
        return new World(new Vector2(0, 0), true);
    }
    public static World generateSideViewWorld(){
        return new World(new Vector2(0,-10),true);
    }

}
