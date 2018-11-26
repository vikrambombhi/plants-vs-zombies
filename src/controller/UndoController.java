package controller;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import model.Board;
import model.Stats;
import view.MainView;
import view.StatsPanel;

public class UndoController implements ActionListener {
	
	private Board board;
    private StatsPanel statsPanel;
    private Stats stats;
	
	public UndoController(StatsPanel panel) {
		this.board = Board.getBoard();
        this.statsPanel = panel;
        this.stats = Stats.getStats();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		stats.undo();
	}

}
