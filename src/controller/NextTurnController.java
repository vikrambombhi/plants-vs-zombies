package controller;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

import event.StatsEvent;
import model.Board;
import model.Stats;
import model.TurnStack;
import view.StatsPanel;

public class NextTurnController implements ActionListener {

    private Board board;
    private StatsPanel statsPanel;
    private Stats stats;
    private TurnStack turnStack;

    public NextTurnController(StatsPanel panel) {
        this.board = Board.getBoard();
        this.statsPanel = panel;
        this.stats = Stats.getStats();
        this.turnStack = TurnStack.getTurnStack();
    }

    public void actionPerformed(ActionEvent e) {
        try {
            this.turnStack.saveTurn(this.board.saveBoard());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.board.turn();
        this.stats.incrementTurn();
        this.stats.addSunPoints(this.stats.getSunPointsGenerationRate());
	}
}
