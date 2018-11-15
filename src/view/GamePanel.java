package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Board;

public class GamePanel {

	GridLayout gameField;
	JButton[][] gameFieldSlot;
	JPanel gamePanel;
	
	public GamePanel() {
    int ROWS = Board.getHeight();
    int COLS = Board.getWidth();
		gameFieldSlot = new JButton[ROWS][COLS];
		gameField = new GridLayout(ROWS, COLS);

		gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(450,250));
		gamePanel.setLayout(gameField);
		
		for(int x = 0; x < ROWS; x++) {
			for (int y = 0; y < COLS; y++) {
				gameFieldSlot[x][y] = new JButton();
				gamePanel.add(gameFieldSlot[x][y]);
			}
		}
	}
	
	public JPanel getGamePanel() {
		return gamePanel;
	}
}
