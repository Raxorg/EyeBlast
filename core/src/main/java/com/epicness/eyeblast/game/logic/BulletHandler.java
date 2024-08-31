package com.epicness.eyeblast.game.logic;

import static com.epicness.eyeblast.game.GameConstants.BULLET_RADIUS;
import static com.epicness.eyeblast.game.GameConstants.PLAYER_RADIUS;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

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
        bullets.begin();
        Bullet bullet;
        for (int i = 0; i < bullets.size; i++) {
            bullet = bullets.get(i);
            moveBullet(bullet, delta);
            checkCollision(bullet);
        }
        bullets.end();
    }

    private void moveBullet(Bullet bullet, float delta) {
        bullet.translate(bullet.speed.cpy().scl(delta));
        if (bullet.getCenter().x <= 0f) {
            bullets.removeValue(bullet, true);
        }
        if (bullet.getCenter().x >= CAMERA_WIDTH) {
            bullets.removeValue(bullet, true);
        }
        if (bullet.getCenter().y <= 0f) {
            bullets.removeValue(bullet, true);
        }
        if (bullet.getCenter().y >= CAMERA_HEIGHT) {
            bullets.removeValue(bullet, true);
        }
    }

    private void checkCollision(Bullet bullet) {
        if (bullet.getCenter().dst(player.getCenter()) <= PLAYER_RADIUS + BULLET_RADIUS) {
            get(TimeHandler.class).reset();
            eyes.clear();
        }
    }
}