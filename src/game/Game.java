package game;

import java.util.Date; 
import java.util.Random;
import java.util.Scanner;

import view.MainView;
import model.*;
import controller.SettingsController;

/*
 * Main game class, this is the entry point for the application
 */
public class Game {

    private static Board board = new Board(5, 10);
    private static MainView gameInterface;
    private static TurnStackBoard turnStackBoard = new TurnStackBoard();
    private static TurnStackStats turnStackStats = new TurnStackStats();

    public Game() {}

    public static void main(String args[]) {
        // Create window and start game
        gameInterface = new MainView();
        SettingsController controller = new SettingsController(gameInterface);
    }
}
