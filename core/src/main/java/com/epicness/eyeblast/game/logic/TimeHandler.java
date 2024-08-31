package com.epicness.eyeblast.game.logic;

import com.epicness.fundamentals.stuff.Text;

public class TimeHandler extends GameLogicHandler {

    private Text timeText, highscoreText;
    private float time, highscore;

    @Override
    protected void init() {
        timeText = stuff.getTimeText();
        highscoreText = stuff.getHighscore();
        time = 0f;
    }

    @Override
    protected void update(float delta) {
        time += delta;

        timeText.setText((int) time + "");

        if (time > highscore) {
            highscoreText.setText("Highscore: " + (int) time);
            highscore = time;
        }
    }

    public void reset() {
        time = 0f;
    }
}