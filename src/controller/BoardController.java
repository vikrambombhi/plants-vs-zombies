package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.Board;
import model.Peashooter;
import model.PlantTypes;
import model.Sunflower;

import view.PlantSelectionPanel;
import view.StatsPanel;

public class BoardController implements ActionListener {
    private int row;
    private int col;
    private Board board;
    private PlantSelectionPanel plantSelectionPanel;
    private StatsPanel statsPanel;

    public BoardController(int row, int col, PlantSelectionPanel plantSelectionPanel, StatsPanel statsPanel) {
        this.row = row;
        this.col = col;
        this.board = Board.getBoard();
        this.plantSelectionPanel = plantSelectionPanel;
        this.statsPanel = statsPanel;
    }

	public void actionPerformed(ActionEvent e) {
        String plantType = plantSelectionPanel.getPlant();

        if (plantType == PlantTypes.SUNFLOWER.getName()) {
            Sunflower sunflower = new Sunflower();
            if (sunflower.getSunPointCost() <= this.statsPanel.getStats().getSunPoints()) {
                this.board.placePlant(sunflower, this.row, this.col);
                this.statsPanel.update(sunflower.getSunPointCost());
            }
        } else if (plantType == PlantTypes.PEASHOOTER.getName()) {
            Peashooter peashooter = new Peashooter();
            if (peashooter.getSunPointCost() <= this.statsPanel.getStats().getSunPoints()) {
                this.board.placePlant(peashooter, this.row, this.col);
                this.statsPanel.update(peashooter.getSunPointCost());
            }
        }
	}
}
