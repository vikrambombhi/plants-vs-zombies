package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.Board;
import model.Sunflower;

public class BoardController implements ActionListener {
    
    private int row;
    private int col;
    private Board board;

    public BoardController(int row, int col) {
        this.row = row;
        this.col = col;
        this.board = Board.getBoard();
    }

	public void actionPerformed(ActionEvent e) {
        Sunflower sunflower = new Sunflower();
        this.board.placePlant(sunflower, this.row, this.col);
	}
}
