package controller;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

import model.Board;
import model.Peashooter;
import model.PlantTypes;
import model.Stats;
import model.Sunflower;
import view.PlantSelectionPanel;
import view.StatsPanel;

/*
 * Controller for the game board
 */
public class BoardController implements ActionListener {
    private int row;
    private int col;
    private Board board;
    private PlantSelectionPanel plantSelectionPanel;
    private StatsPanel statsPanel;
    
    // Create controller
    public BoardController(int row, int col, PlantSelectionPanel plantSelectionPanel, StatsPanel statsPanel) {
        this.row = row;
        this.col = col;
        this.board = Board.getBoard();
        this.plantSelectionPanel = plantSelectionPanel;
        this.statsPanel = statsPanel;
    }

    // Handle action when any tile on the board is clicked
    // Currently this is how users place plants on the board.
	public void actionPerformed(ActionEvent e) {
        // Get plant selected from plant selection view
        String plantType = plantSelectionPanel.getPlant();

        // Check if selected plant is of type sunflower
        if (plantType == PlantTypes.SUNFLOWER.getName()) {
            // Create sunflower
            Sunflower sunflower = new Sunflower();
            // Check if user has enough sunpoints to buy a sunflower
            if (sunflower.getSunPointCost() <= this.statsPanel.getStats().getSunPoints()) {
                // try to place sunflower on board if there is 
                // this can fail if there is already a plant at selected location for example
                if (this.board.placePlant(sunflower, this.row, this.col) == true) {
                    // remove sunpoints required to buy the sunflower from the user
                    this.statsPanel.getStats().increaseSunPointsGenerationRate(sunflower.getSunPointGeneratedPerTurn());
                }
            }
            // Check if selected plant is of type peashooter
        } else if (plantType == PlantTypes.PEASHOOTER.getName()) {
            // Create peashooter
            Peashooter peashooter = new Peashooter();
            // Check if user has enough sunpoints to buy a peashooter
            if (peashooter.getSunPointCost() <= this.statsPanel.getStats().getSunPoints()) {
                // Place peashooter on board
                // TODO: remove sunpoints from user
                this.board.placePlant(peashooter, this.row, this.col);
            }
        }
	}
}
