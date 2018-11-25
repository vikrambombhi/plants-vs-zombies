package view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Stats;
import event.Event;
import event.StatsEvent;

/*
 *  This is a Subclass that builds the MainView class.
 *  StatsPanel includes the amount of sunflower points you have in your bank.
 *  zombies left to kill, and current turn all displayed above the game field.
 */
public class StatsPanel implements Listener {
	private JLabel sunPoints, sunPointsGenerationRate, zombiesRemaining, currentTurn;
	private JPanel stats;

	private Stats gameStats;

	public StatsPanel(Stats gameStats) {
		this.gameStats = gameStats;
		sunPoints = new JLabel("Sun Points: " + this.gameStats.getSunPoints());
		sunPointsGenerationRate = new JLabel("Sun Points per Turn: " + this.gameStats.getSunPointsGenerationRate());
		zombiesRemaining = new JLabel("Zombies Remaining: " + this.gameStats.getNumZombiesRemaining());
		currentTurn = new JLabel("Turn Phase: ");
		stats = new JPanel();
		stats.setPreferredSize(new Dimension(200,40));
		stats.add(sunPoints);
        stats.add(sunPointsGenerationRate);
		stats.add(zombiesRemaining);
		stats.add(currentTurn);

        gameStats.addActionListener(this);
	}

	/* Use to get statsPanel variable from for MainView */
	public JPanel getStatsPanel() {
		return stats;
	}

	public Stats getStats() {
		return this.gameStats;
	}

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
