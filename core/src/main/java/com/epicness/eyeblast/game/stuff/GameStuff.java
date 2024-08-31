package com.epicness.eyeblast.game.stuff;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.eyeblast.game.GameAssets;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.Text;

public class GameStuff extends Stuff<GameAssets> {

    private Player player;
    private SnapshotArray<Eye> eyes;
    private SnapshotArray<Bullet> bullets;
    private Text timeText, highscore;

    @Override
    public void initializeStuff() {
        player = new Player();
        player.translate(new Vector2(200f, 200f));
        eyes = new SnapshotArray<>();
        bullets = new SnapshotArray<>();

        timeText = new Text(sharedAssets.getPixelFont());
        timeText.setWidth(CAMERA_WIDTH);
        timeText.setY(CAMERA_HALF_HEIGHT);
        timeText.hAlignCenter();
        timeText.setScale(5f);
        timeText.setColor(WHITE.cpy().lerp(CLEAR, 0.5f));

        highscore = new Text(sharedAssets.getPixelFont());
        highscore.setWidth(CAMERA_WIDTH);
        highscore.setY(CAMERA_HEIGHT * 0.85f);
        highscore.hAlignCenter();
        highscore.setScale(5f);
        highscore.setColor(WHITE.cpy().lerp(CLEAR, 0.5f));
    }

    public SnapshotArray<Eye> getEyes() {
        return eyes;
    }

    public Player getPlayer() {
        return player;
    }

    public SnapshotArray<Bullet> getBullets() {
        return bullets;
    }

    public Text getTimeText() {
        return timeText;
    }

    public Text getHighscore() {
        return highscore;
    }
}