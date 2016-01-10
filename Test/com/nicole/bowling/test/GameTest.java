package com.nicole.bowling.test;
import com.nicole.bowling.Game;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by bears8yourface on 1/7/16.
 */
public class GameTest extends TestCase {
    private Game game;

    private void rollManyTimes(int numToRoll, int timesToRoll) {
        for (int i=0; i<timesToRoll; i++)
            game.roll(numToRoll);
    }

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testGutterGame() {
        rollManyTimes(0, 20);
        assertEquals(0, game.score());
    }

    @Test
    public void testAllOnes() {
        rollManyTimes(1, 20);
        assertEquals(20, game.score());
    }

    @Test
    public void testASpare() {
        game.roll(9);
        game.roll(1);
        game.roll(3);
        rollManyTimes(0, 17);

        assertEquals(16, game.score());
    }

    @Test
    public void testAStrike() {
        game.roll(10);
        rollManyTimes(1, 18);

        assertEquals(30, game.score());
    }
}
