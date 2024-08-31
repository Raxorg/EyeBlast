package com.epicness.eyeblast.game.stuff;

import static com.badlogic.gdx.graphics.Color.FOREST;
import static com.badlogic.gdx.graphics.Color.RED;
import static com.epicness.eyeblast.game.GameConstants.PLAYER_RADIUS;

import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Circle;

public class Player {

    private final Circle circle;
    public final Vector2 speed;

    public Player() {
        circle = new Circle(PLAYER_RADIUS, FOREST);
        speed = new Vector2();
    }

    public void draw(ShapeDrawerPlus shapeDrawer) {
        circle.draw(shapeDrawer);
    }

    public void translate(Vector2 translation) {
        circle.translate(translation);
    }

    public Vector2 getCenter() {
        return circle.getCenter();
    }
}