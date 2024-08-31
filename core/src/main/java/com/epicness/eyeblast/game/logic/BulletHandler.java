package com.epicness.eyeblast.game.logic;

import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.eyeblast.game.stuff.Bullet;
import com.epicness.eyeblast.game.stuff.Eye;
import com.epicness.eyeblast.game.stuff.Player;

public class BulletHandler extends GameLogicHandler {

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
    protected void update(float delta) {
        Bullet bullet;
        for (int i = 0; i < bullets.size; i++) {
            bullet = bullets.get(i);
            moveBullet(bullet, delta);
            checkCollision(bullet);
        }
    }

    private void moveBullet(Bullet bullet, float delta) {
        bullet.translate(bullet.speed.cpy().scl(delta));
    }

    private void checkCollision(Bullet bullet) {
        if (bullet.getCenter().dst(player.getCenter()) <= 7.5f) {
            get(TimeHandler.class).reset();
            eyes.clear();
        }
    }
}