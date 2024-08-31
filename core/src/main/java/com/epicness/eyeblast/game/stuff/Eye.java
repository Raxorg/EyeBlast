package com.epicness.eyeblast.game.stuff;

import static com.badlogic.gdx.graphics.Color.BLACK;

import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Circle;

public class Eye {

    private final Circle globe, pupil;
    public float cooldown;

    public Eye() {
        globe = new Circle(25f);
        pupil = new Circle(5f);
        pupil.setColor(BLACK);
    }

    public void draw(ShapeDrawerPlus shapeDrawer) {
        globe.draw(shapeDrawer);
        pupil.draw(shapeDrawer);
    }

    public Vector2 getPosition() {
        return pupil.getCenter();
    }

    public void setPosition(float x, float y) {
        globe.setPosition(x, y);
        pupil.setPosition(x + 20f, y + 20f);
    }
}