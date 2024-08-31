package com.epicness.eyeblast.game.logic;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.S;
import static com.badlogic.gdx.Input.Keys.W;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.epicness.eyeblast.game.stuff.Player;

public class PlayerHandler extends GameLogicHandler {

    private Player player;

    @Override
    protected void init() {
        player = stuff.getPlayer();
    }

    @Override
    protected void update(float delta) {
        pollInput();
        Vector2 translation = player.speed.cpy().scl(delta);
        player.translate(translation);
        if (player.getCenter().x <= 0f) {
            player.translate(translation.scl(-1));
        }
        if (player.getCenter().x >= CAMERA_WIDTH) {
            player.translate(translation.scl(-1));
        }
        if (player.getCenter().y <= 0f) {
            player.translate(translation.scl(-1));
        }
        if (player.getCenter().y >= CAMERA_HEIGHT) {
            player.translate(translation.scl(-1));
        }
    }

    private void pollInput() {
        player.speed.setZero();
        if (Gdx.input.isKeyPressed(W)) {
            player.speed.y += 500f;
        }
        if (Gdx.input.isKeyPressed(A)) {
            player.speed.x -= 500f;
        }
        if (Gdx.input.isKeyPressed(S)) {
            player.speed.y -= 500f;
        }
        if (Gdx.input.isKeyPressed(D)) {
            player.speed.x += 500f;
        }
    }
}