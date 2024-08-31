package com.epicness.eyeblast.game.stuff;

import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.epicness.eyeblast.game.GameConstants.EYE_RADIUS;
import static com.epicness.eyeblast.game.GameConstants.PUPIL_RADIUS;

import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Circle;

public class Eye {

    private final Circle globe, pupil;
    public float cooldown;

    public Eye() {
        globe = new Circle(EYE_RADIUS);
        pupil = new Circle(PUPIL_RADIUS);
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
        pupil.setPosition(x + EYE_RADIUS - PUPIL_RADIUS, y + EYE_RADIUS - PUPIL_RADIUS);
    }
}