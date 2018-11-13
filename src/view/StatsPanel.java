package view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
	
	public JPanel getStatsPanel() {
		return stats;
	}
}
