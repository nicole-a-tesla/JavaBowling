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

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testGutterGame() {
        for (int i=0; i<20; i++)
            game.roll(0);
        assertEquals(0, game.score());
    }

    @Test
    public void testAllOnes() {
        for (int i=0; i<20; i++)
            game.roll(1);
        assertEquals(20, game.score());
    }

//    @Test
//    public void testASpare() {
//        game.roll(9);
//        game.roll(1);
//        game.roll(3);
//        for (int i=0; i<17; i++)
//            game.roll(0);
//
//        assertEquals(16, game.score());
//    }
}
