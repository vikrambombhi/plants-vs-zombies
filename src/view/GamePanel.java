package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Board;
import model.Tile;
import event.Event;
import event.BoardEvent;
import controller.BoardController;

/*
 * View for the game board itself.
 * Creates a grid of buttons and renders out the game state on them
 */
public class GamePanel implements Listener, Serializable {

	private int ROWS;
	private int COLS;
	
	GridLayout gameField;
	JButton[][] gameFieldSlot;
    JPanel gamePanel;
    
    PlantSelectionPanel plantSelectionPanel;
    StatsPanel statsPanel;
	
    /*
     * Create grid of buttons as game board
     */
	public GamePanel(PlantSelectionPanel plantSelectionPanel, StatsPanel statsPanel) {
        // Get height and width of the board from the board model
        this.ROWS = Board.getHeight();
        this.COLS = Board.getWidth();
        this.plantSelectionPanel = plantSelectionPanel;
        this.statsPanel = statsPanel;
        
        // Create two dimensional array to hold all the buttons
		gameFieldSlot = new JButton[ROWS][COLS];
        // Craete grid layout
		gameField = new GridLayout(ROWS, COLS);
		gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(450, 250));
		gamePanel.setLayout(gameField);
		
        // Populate two dimensional array with buttons
		for(int x = 0; x < ROWS; x++) {
			for (int y = 0; y < COLS; y++) {
                // Create button
				gameFieldSlot[x][y] = new JButton();
                // Register controller for the button
                gameFieldSlot[x][y].addActionListener(new BoardController(x, y, plantSelectionPanel, statsPanel));
				gamePanel.add(gameFieldSlot[x][y]);
			}
		}

        // The board is a singleton so we can just get it
        Board board = Board.getBoard();
        // Regester this view to the board model
        board.addActionListener(this);
    }
    
    public void newGamePanel() {
        this.ROWS = Board.getHeight();
        this.COLS = Board.getWidth();
        
        // Create two dimensional array to hold all the buttons
		gameFieldSlot = new JButton[ROWS][COLS];
        // Craete grid layout
		gameField = new GridLayout(ROWS, COLS);
		gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(450, 250));
		gamePanel.setLayout(gameField);
		
        // Populate two dimensional array with buttons
		for(int x = 0; x < ROWS; x++) {
			for (int y = 0; y < COLS; y++) {
                // Create button
				gameFieldSlot[x][y] = new JButton();
                // Register controller for the button
                gameFieldSlot[x][y].addActionListener(new BoardController(x, y, plantSelectionPanel, statsPanel));
				gamePanel.add(gameFieldSlot[x][y]);
			}
		}
    }
	
    /*
     * Change dimensions on the game board.
     * THIS FUNCTION IS NOT YET FULLY IMPLEMENTED
     */
	public void setGamePanel(int rows, int cols) {
		ROWS = rows;
		COLS = cols;
	}

	/* Use to get gamePanel variable from for MainView */
	public JPanel getGamePanel() {
		return gamePanel;
	}

    /*
     * Handle changes in the board and update the game board 
     */
    public void handleEvent(Event event) {
        BoardEvent boardEvent = (BoardEvent)event;
        Tile[][] tiles = boardEvent.getTiles();

        for(int row=0;row<ROWS;row++) {
            for(int col=0;col<COLS;col++) {
                this.gameFieldSlot[row][col].setText(tiles[row][col].toString());
            }
        }
    }
}
