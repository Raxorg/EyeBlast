package com.epicness.eyeblast.game.logic;

import static com.epicness.eyeblast.game.GameConstants.EYE_SIZE;
import static com.epicness.eyeblast.game.GameConstants.EYE_SPAWN_RATE;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

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
        if (time >= EYE_SPAWN_RATE) {
            spawnEye();
            time = 0f;
        }
    }

    private void spawnEye() {
        Eye eye = new Eye();
        float x = MathUtils.random(0f, CAMERA_WIDTH - EYE_SIZE);
        float y = MathUtils.random(0f, CAMERA_HEIGHT - EYE_SIZE);
        eye.setPosition(x, y);
        eyes.add(eye);
    }
}