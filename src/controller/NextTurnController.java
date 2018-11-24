package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import event.StatsEvent;
import model.Board;
import model.Stats;
import view.StatsPanel;

public class NextTurnController implements ActionListener {

    private Board board;
    private StatsPanel statsPanel;
    private Stats stats;

    public NextTurnController(StatsPanel panel) {
        this.board = Board.getBoard();
        this.statsPanel = panel;
        this.stats = Stats.getStats();
    }

    public void actionPerformed(ActionEvent e) {
        this.board.turn();
        this.stats.incrementTurn();
        this.stats.addSunPoints(this.stats.getSunPointsGenerationRate());
        this.statsPanel.update();
	}
}
