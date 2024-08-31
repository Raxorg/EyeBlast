package com.epicness.eyeblast.game.logic;

import static com.epicness.eyeblast.game.GameConstants.EYE_SHOOT_RATE;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.eyeblast.game.stuff.Bullet;
import com.epicness.eyeblast.game.stuff.Eye;
import com.epicness.eyeblast.game.stuff.Player;
import com.epicness.fundamentals.utils.AngleUtils;

public class AttackHandler extends GameLogicHandler {

    private SnapshotArray<Eye> eyes;
    private SnapshotArray<Bullet> bullets;
    private Player player;

    @Override
    protected void init() {
        eyes = stuff.getEyes();
        bullets = stuff.getBullets();
        player = stuff.getPlayer();
    }

    @Override
    public void update(float delta) {
        Eye eye;
        for (int i = 0; i < eyes.size; i++) {
            eye = eyes.get(i);
            eye.cooldown += delta;
            if (eye.cooldown >= EYE_SHOOT_RATE) {
                shoot(eye);
                eye.cooldown = 0f;
            }
        }
    }

    private void shoot(Eye eye) {
        Bullet bullet = new Bullet();
        bullet.translate(eye.getPosition());
        float angle = AngleUtils.degreesBetweenPoints(player.getCenter(), bullet.getCenter());
        float speedX = MathUtils.cosDeg(angle) * 250f;
        float speedY = MathUtils.sinDeg(angle) * 250f;
        bullet.speed.set(speedX, speedY);
        bullets.add(bullet);
    }
}