package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.Board;
import event.TurnResult;
import view.StatsPanel;

public class NextTurnController implements ActionListener {

    private Board board;
    private StatsPanel statsPanel;

    public NextTurnController(StatsPanel panel) {
        this.board = Board.getBoard();
        this.statsPanel = panel;
    }

    public void actionPerformed(ActionEvent e) {
        TurnResult result = this.board.turn();
        this.statsPanel.update(result);
	}
}
