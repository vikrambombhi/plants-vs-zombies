package game;

import java.util.Date; 
import java.util.Random;
import java.util.Scanner;

import view.MainView;
import model.*;
import controller.SettingsController;
import event.TurnResult;

public class Game {

    private static Board board = new Board(5, 10);
	private static MainView gameInterface;

    public Game() {}

    public static void main(String args[]) {
        gameInterface = new MainView();
        SettingsController controller = new SettingsController(gameInterface);
    }
}
