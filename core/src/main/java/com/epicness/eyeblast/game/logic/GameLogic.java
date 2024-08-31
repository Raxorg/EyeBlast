package com.epicness.eyeblast.game.logic;

import com.epicness.fundamentals.logic.Logic;

public class GameLogic extends Logic {

    private final AttackHandler attackHandler;
    private final BulletHandler bulletHandler;
    private final EyeSpawner spawner;
    private final PlayerHandler playerHandler;
    private final TimeHandler timeHandler;

    public GameLogic() {
        registerHandler(attackHandler = new AttackHandler());
        registerHandler(bulletHandler = new BulletHandler());
        registerHandler(spawner = new EyeSpawner());
        registerHandler(playerHandler = new PlayerHandler());
        registerHandler(timeHandler = new TimeHandler());
    }

    @Override
    public void update() {
        attackHandler.update();
        bulletHandler.update();
        spawner.update();
        playerHandler.update();
        timeHandler.update();
    }
}