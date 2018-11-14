package view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

/* This is a Subclass that builds the MainView class.
 *  StatsPanel includes the amount of sunflower points you have in your bank.
 *  zombies left to kill, and current turn all displayed above the game field. */
public class StatsPanel {
	private JLabel sunflowerPoints, zombiesRemaining, currentTurn;
	private JPanel stats;

	public StatsPanel() {
		sunflowerPoints = new JLabel("Sun Flower Points: ");
		zombiesRemaining = new JLabel("Zombies Remaining: ");
		currentTurn = new JLabel("Turn Phase: ");
		stats = new JPanel();
		stats.setPreferredSize(new Dimension(200,40));
		stats.add(sunflowerPoints);
		stats.add(zombiesRemaining);
		stats.add(currentTurn);
	}
	
	/* Use to get statsPanel variable from for MainView */
	public JPanel getStatsPanel() {
		return stats;
	}
}
