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

public class UndoTurnController implements ActionListener {

    private Board board;
    private StatsPanel statsPanel;
    private Stats stats;
    private TurnStackBoard turnStackBoard;
    private TurnStackStats turnStackStats;

    public UndoTurnController(StatsPanel panel) {
        this.board = Board.getBoard();
        this.statsPanel = panel;
        this.stats = Stats.getStats();
        this.turnStackBoard = TurnStackBoard.getTurnStackBoard();
        this.turnStackStats = TurnStackStats.getTurnStackStats();
    }

    public void actionPerformed(ActionEvent e) {
        try {
            this.board.undoBoard(this.turnStackBoard.undoTurn());
            this.stats.undoStats(this.turnStackStats.undoTurn());
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
	}
}
