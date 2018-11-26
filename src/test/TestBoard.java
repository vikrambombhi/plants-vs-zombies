package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import game.Game;
import model.Board;
import model.Sunflower;

public class TestBoard {

    Board board;
    Game game;

    @Before
    public void setup() {
        game = new Game();
        board = Board.getBoard();
    }

    @Test
    public void testHeight() {
        assertEquals("Board height should be 5", 5, board.getHeight());
    }

    @Test
    public void testWidth() {
        assertEquals("Board width should be 10", 10, board.getWidth());
    }
    
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestBoard.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}