package controller;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

import event.StatsEvent;
import model.Board;
import model.Stats;
import model.TurnStack;
import view.StatsPanel;

public class UndoTurnController implements ActionListener {

    private Board board;
    private StatsPanel statsPanel;
    private Stats stats;
    private TurnStack turnStack;

    public UndoTurnController(StatsPanel panel) {
        this.board = Board.getBoard();
        this.statsPanel = panel;
        this.stats = Stats.getStats();
        this.turnStack = TurnStack.getTurnStack();
    }

    public void actionPerformed(ActionEvent e) {
        try {
            this.board.undoBoard(this.turnStack.undoTurn());
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
	}
}
