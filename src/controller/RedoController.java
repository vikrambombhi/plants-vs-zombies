package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import event.TurnResult;
import model.Board;
import view.MainView;
import view.StatsPanel;

public class RedoController implements ActionListener {
	
	private Board board;
    private StatsPanel statsPanel;
	
	public RedoController(StatsPanel panel) {
		this.board = Board.getBoard();
        this.statsPanel = panel;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		TurnResult result = this.board.turn();
	
	}

}
