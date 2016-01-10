package com.nicole.bowling;
import java.util.HashMap;

/**
 * Created by bears8yourface on 1/7/16.
 */
public class Game {
    private HashMap<Integer, int[]> frames;
    private int currentFrame;
    private int currentRoll;

    public Game() {
        currentFrame = 1;
        currentRoll = 0;
        frames = setupFrames();
    }

    public void roll(int numOfPins) {
        int[] thisFrame = frames.get(currentFrame);
        thisFrame[currentRoll] = numOfPins;

        incrementFrameAndRoll();
    }

    private void incrementFrameAndRoll() {
        if (frameIsComplete()) {
            currentFrame += 1;
            currentRoll = 0;
        } else {
            currentRoll = 1;
        }
    }

    private Boolean frameIsComplete() {
        int[] rolls = frames.get(currentFrame);
        int frameScore = rolls[0] + rolls[1];
        Boolean rolledTwice = currentRoll == 1;

        return frameScore == 10 || rolledTwice;
    }

    public int score() {
        int score = 0;

        for (int i=1; i<frames.size() + 1; i++) {
            score += rollSum(i);
            score += calculateBonusIfApplicable(i);
        }

        return score;
    }

    private int calculateBonusIfApplicable(int frameNumber) {
        int bonus = 0;

        if (frameGetsBonus(frameNumber)) {
            int[] nextFramesRolls = frames.get(frameNumber + 1);
            bonus += nextFramesRolls[0];

            if (frameIsStrike(frameNumber)) {
                bonus += nextFramesRolls[1];
            }
        }

        return bonus;
    }

    private Boolean frameGetsBonus(int frameNumber) {
        return rollSum(frameNumber) == 10;
    }

    private Boolean frameIsStrike(int frameNumber) {
        return currentRoll == 0 && rollSum(frameNumber) == 10;
    }


    private int rollSum(int frameNumber) {
        int[] rolls = frames.get(frameNumber);
        return rolls[0] + rolls[1];
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
