package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel {

	/* Set up for the game's field of play */
	private static final int ROWS = 5;
	private static final int COLS = 10;
	
	GridLayout gameField;
	JButton[][] gameFieldSlot;
	JPanel gamePanel;
	
	public GamePanel() {
		gameFieldSlot = new JButton[ROWS][COLS];
		gameField = new GridLayout(ROWS,COLS);
		gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(450,250));
		gamePanel.setLayout(gameField);
		
		for(int x = 0; x < ROWS; x++) {
			for (int y = 0; y < COLS; y++) {
				gameFieldSlot[x][y] = new JButton();
//				gameFieldSlot[x][y].setEnabled(false);
				gamePanel.add(gameFieldSlot[x][y]);
			}
		}
	}
	
	public JPanel getGamePanel() {
		return gamePanel;
	}
}
