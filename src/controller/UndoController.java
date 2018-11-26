package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import event.TurnResult;
import model.Board;
import view.MainView;
import view.StatsPanel;

public class UndoController implements ActionListener {
	
	private Board board;
    private StatsPanel statsPanel;
	
	public UndoController(StatsPanel panel) {
		this.board = Board.getBoard();
        this.statsPanel = panel;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		statsPanel.getStats().undo();
	}

}
