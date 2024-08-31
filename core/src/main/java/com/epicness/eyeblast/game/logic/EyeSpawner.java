package com.epicness.eyeblast.game.logic;

import static com.epicness.eyeblast.game.GameConstants.SPAWN_RATE;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.eyeblast.game.stuff.Eye;

public class EyeSpawner extends GameLogicHandler {

    private SnapshotArray<Eye> eyes;
    private float time;

    @Override
    protected void init() {
        eyes = stuff.getEyes();
        time = 0f;
    }

    @Override
    protected void update(float delta) {
        time += delta;
        if (time >= SPAWN_RATE) {
            spawnEye();
            time = 0f;
        }
    }

    private void spawnEye() {
        Eye eye = new Eye();
        float x = MathUtils.random(0f, 1200f);
        float y = MathUtils.random(0f, 700f);
        eye.setPosition(x, y);
        eyes.add(eye);
    }
}