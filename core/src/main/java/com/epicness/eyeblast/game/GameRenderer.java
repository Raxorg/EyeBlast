package com.epicness.eyeblast.game;

import static com.badlogic.gdx.graphics.Color.SKY;

import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.eyeblast.game.stuff.GameStuff;
import com.epicness.fundamentals.renderer.Renderer;

public class GameRenderer extends Renderer<GameStuff> {

    @Override
    public void render() {
        ScreenUtils.clear(SKY);

        spriteBatch.begin();
        for (int i = 0; i < stuff.getEyes().size; i++) {
            stuff.getEyes().get(i).draw(shapeDrawer);
        }
        stuff.getPlayer().draw(shapeDrawer);
        for (int i = 0; i < stuff.getBullets().size; i++) {
            stuff.getBullets().get(i).draw(shapeDrawer);
        }
        stuff.getTimeText().draw(spriteBatch);
        stuff.getHighscore().draw(spriteBatch);
        spriteBatch.end();
    }
}