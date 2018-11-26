package controller;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

import event.StatsEvent;
import model.Board;
import model.Stats;
import model.TurnStackBoard;
import model.TurnStackStats;
import view.StatsPanel;

public class NextTurnController implements ActionListener {

    private Board board;
    private StatsPanel statsPanel;
    private Stats stats;
    private TurnStackBoard turnStackBoard;
    private TurnStackStats turnStackStats;

    public NextTurnController(StatsPanel panel) {
        this.board = Board.getBoard();
        this.statsPanel = panel;
        this.stats = Stats.getStats();
        this.turnStackBoard = TurnStackBoard.getTurnStackBoard();
        this.turnStackStats = TurnStackStats.getTurnStackStats();
    }

    public void actionPerformed(ActionEvent e) {
        try {
            this.turnStackBoard.saveTurn(this.board.saveBoard());
            this.turnStackStats.saveTurn(this.stats.saveStats());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.board.turn();
        this.stats.incrementTurn();
        this.stats.addSunPoints(this.stats.getSunPointsGenerationRate());
	}
}
