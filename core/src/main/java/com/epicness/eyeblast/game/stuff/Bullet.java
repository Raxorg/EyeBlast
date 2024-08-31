package com.epicness.eyeblast.game.stuff;

import static com.badlogic.gdx.graphics.Color.RED;
import static com.epicness.eyeblast.game.GameConstants.BULLET_RADIUS;

import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Circle;

public class Bullet {

    private final Circle bullet;
    public final Vector2 speed;

    public Bullet() {
        bullet = new Circle(BULLET_RADIUS, RED);
        speed = new Vector2();
    }

    public void draw(ShapeDrawerPlus shapeDrawer) {
        bullet.draw(shapeDrawer);
    }

    public void translate(Vector2 translation) {
        bullet.translate(translation);
    }

    public Vector2 getCenter() {
        return bullet.getCenter();
    }
}