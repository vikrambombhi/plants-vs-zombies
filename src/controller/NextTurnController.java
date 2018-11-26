package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import event.StatsEvent;
import model.Board;
import model.Stats;
import view.StatsPanel;

/*
 * This controller handles when the user wants to go to the next turn, redo, or undo 
 */
public class NextTurnController implements ActionListener {

    private Board board;
    private StatsPanel statsPanel;
    private Stats stats;

    // Create controller
    public NextTurnController(StatsPanel panel) {
        this.board = Board.getBoard();
        this.statsPanel = panel;
        this.stats = Stats.getStats();
    }

    // Handle what the user wants to do, for now only the ability to goto the next turn is supported
    public void actionPerformed(ActionEvent e) {
        this.board.turn();
        this.stats.incrementTurn();
        this.stats.addSunPoints(this.stats.getSunPointsGenerationRate());
	}
}
