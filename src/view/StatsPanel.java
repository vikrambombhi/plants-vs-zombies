package view;

import java.awt.Dimension;
import java.io.Serializable;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Stats;
import event.Event;
import event.StatsEvent;

/*
 *  This view shows the user the current stats of their game, this includes the following information:
 *      - Number of sunpoints the user currently has
 *      - Number of sunpoints the user gets per turn
 *      - Number of zombies left remaining that the use must kill/survive
 *      - What number turn the user is on
 */
public class StatsPanel implements Listener, Serializable {
	private JLabel sunPoints, sunPointsGenerationRate, zombiesRemaining, currentTurn;
	private JPanel stats;

	private Stats gameStats;

    /*
     * Creates the stats panel
     */
	public StatsPanel(Stats gameStats) {
		this.gameStats = gameStats;
        // Create labels for all the stats
		sunPoints = new JLabel("Sun Points: " + this.gameStats.getSunPoints());
		sunPointsGenerationRate = new JLabel("Sun Points per Turn: " + this.gameStats.getSunPointsGenerationRate());
		zombiesRemaining = new JLabel("Zombies Remaining: " + this.gameStats.getNumZombiesRemaining());
		currentTurn = new JLabel("Turn Phase: ");
		stats = new JPanel();
		stats.setPreferredSize(new Dimension(200,40));
        // Add labels to view
		stats.add(sunPoints);
        stats.add(sunPointsGenerationRate);
		stats.add(zombiesRemaining);
		stats.add(currentTurn);

        // Register this view to stats model
        gameStats.addActionListener(this);
	}

	/* Use to get statsPanel variable from for MainView */
	public JPanel getStatsPanel() {
		return stats;
	}

	public Stats getStats() {
		return this.gameStats;
	}

    // Handle updates to the stats, update the view for the user using the new stats
    public void handleEvent(Event event) {
        StatsEvent statsEvent = (StatsEvent)event;
		this.sunPoints.setText("Sun Points: " + statsEvent.getSunPoints());
        this.sunPointsGenerationRate.setText("Sun Points per Turn" + statsEvent.getSunPointsGenerationRate());
		this.zombiesRemaining.setText("Zombies Remaining: " + statsEvent.getZombiesToEliminate());
		if (this.gameStats.getNumZombiesToEliminate() == 0) {
			JOptionPane.showMessageDialog(null, "Congratulations, you won!");
			System.exit(0);
		} else if (this.gameStats.hasPlayerLost()) {
			JOptionPane.showMessageDialog(null, "You lost :( better luck next time!");
			System.exit(0);
		}
    }
}
