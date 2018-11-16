package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Board;
import event.BoardEvent;

/* This is a Subclass that builds the MainView class.
 *  GamePanel is the game field the player will place
 *  plants and fight off zombies. */ 
public class GamePanel implements Listener {

	/* Set up for the game's field of play */
	private static int ROWS;
	private static int COLS;
	
	GridLayout gameField;
	JButton[][] gameFieldSlot;
	JPanel gamePanel;
	
	public GamePanel() {
        ROWS = Board.getHeight();
        COLS = Board.getHeight();
		gameFieldSlot = new JButton[ROWS][COLS];
		gameField = new GridLayout(ROWS, COLS);
		gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(450,250));
		gamePanel.setLayout(gameField);
		
		// This will create the garden (game panel)
		for(int x = 0; x < ROWS; x++) {
			for (int y = 0; y < COLS; y++) {
				gameFieldSlot[x][y] = new JButton();
				gamePanel.add(gameFieldSlot[x][y]);
			}
		}

        Board board = Board.getBoard();
        board.addActionListener(this);
	}
	
	// For the board dimension changer
	public void setGamePanel(int rows, int cols) {
		ROWS = rows;
		COLS = cols;
	}

	/* Use to get gamePanel variable from for MainView */
	public JPanel getGamePanel() {
		return gamePanel;
	}

    public void handleEvent(BoardEvent event) {
        this.gameFieldSlot[event.getRow()][event.getCol()].setText(Character.toString(event.getType()));
    }
}
