package com.epicness.eyeblast;

import com.badlogic.gdx.Game;
import com.epicness.eyeblast.game.GameAssets;
import com.epicness.eyeblast.game.GameInitializer;
import com.epicness.fundamentals.SharedResources;

public class EyeBlastGame extends Game {

    @Override
    public void create() {
        new GameInitializer(new GameAssets()).initialize(new SharedResources());
    }
}