package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Board;
import model.Tile;
import event.BoardEvent;
import controller.BoardController;

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
	
	public GamePanel(PlantSelectionPanel plantSelectionPanel, StatsPanel statsPanel) {
        this.ROWS = Board.getHeight();
        this.COLS = Board.getWidth();
		gameFieldSlot = new JButton[ROWS][COLS];
		gameField = new GridLayout(ROWS, COLS);
		gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(450, 250));
		gamePanel.setLayout(gameField);
		
		// This will create the garden (game panel)
		for(int x = 0; x < ROWS; x++) {
			for (int y = 0; y < COLS; y++) {
				gameFieldSlot[x][y] = new JButton();
                gameFieldSlot[x][y].addActionListener(new BoardController(x, y, plantSelectionPanel, statsPanel));
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
        Tile[][] tiles = event.getTiles();

        for(int row=0;row<ROWS;row++) {
            for(int col=0;col<COLS;col++) {
                this.gameFieldSlot[row][col].setText(tiles[row][col].toString());
            }
        }
    }
}
