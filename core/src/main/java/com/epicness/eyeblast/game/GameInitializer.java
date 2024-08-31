package com.epicness.eyeblast.game;

import com.epicness.eyeblast.game.logic.GameLogic;
import com.epicness.eyeblast.game.stuff.GameStuff;
import com.epicness.fundamentals.initializer.Initializer;

public class GameInitializer extends Initializer<GameAssets, GameRenderer, GameStuff> {

    public GameInitializer(GameAssets assets) {
        super(assets, new GameLogic(), new GameRenderer(), new GameStuff());
    }
}
