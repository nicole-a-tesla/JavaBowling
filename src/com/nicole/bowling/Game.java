package com.nicole.bowling;

import java.util.HashMap;

/**
 * Created by bears8yourface on 1/7/16.
 */
public class Game {
    private int score;
    private HashMap<Integer, int[]> frames;
    private int currentFrame;
    private int currentRoll;

    public Game() {
        score = 0;
        currentFrame = 1;
        currentRoll = 0;
        frames = setupFrames();
    }

    public void roll(int numOfPins) {
        score += numOfPins;

        int[] thisFrame = frames.get(currentFrame);
        System.out.print(thisFrame[currentRoll]);
        thisFrame[currentRoll] = numOfPins;

        if (frameIsComplete()) {
            currentFrame += 1;
        }

        toggleCurrentRoll();
    }

    private Boolean frameIsComplete() {
        int[] rolls = frames.get(currentFrame);
        int frameScore = rolls[0] + rolls[1];
        Boolean rolledTwice = currentRoll == 1; // FIND BETTER SOLUTION

        return frameScore == 10 || rolledTwice;
    }

    public int score() {
        return score;
    }


    private void toggleCurrentRoll() {
        if (currentRoll == 0) {
            currentRoll = 1;
        } else {
            currentRoll = 0;
        }
    }

    private HashMap setupFrames() {
        HashMap framesIncubator = new HashMap<Integer, int[]>();
        for (int i = 1; i < 11; i++) {
            int[] rolls = new int[2];
            framesIncubator.put(i, rolls);
        }
        return framesIncubator;
    }
}
