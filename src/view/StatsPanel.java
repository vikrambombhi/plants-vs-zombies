package view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Stats;
import event.Event;
import event.TurnResult;

/* This is a Subclass that builds the MainView class.
 *  StatsPanel includes the amount of sunflower points you have in your bank.
 *  zombies left to kill, and current turn all displayed above the game field.
 */
public class StatsPanel implements Listener {
	private JLabel sunflowerPoints, zombiesRemaining, currentTurn;
	private JPanel stats;

	private Stats gameStats;

	public StatsPanel(Stats gameStats) {
		this.gameStats = gameStats;
		sunflowerPoints = new JLabel("Sun Points: " + this.gameStats.getSunPoints());
		zombiesRemaining = new JLabel("Zombies Remaining: " + this.gameStats.getNumZombiesRemaining());
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

	public void update(TurnResult turnResult) {
		this.gameStats.addSunPoints(turnResult.getGeneratedSunPoints());
		this.gameStats.numZombiesEliminated(turnResult.getZombiesEliminated());
		this.sunflowerPoints.setText("Sun Points: " + gameStats.getSunPoints());
		this.zombiesRemaining.setText("Zombies Remaining: " + gameStats.getNumZombiesRemaining());

		if (this.gameStats.getNumZombiesToEliminate() == 0) {
			JOptionPane.showMessageDialog(null, "Congratulations, you won!");
			System.exit(0);
		} else if (turnResult.getGeneratedSunPoints() == -1) {
			JOptionPane.showMessageDialog(null, "You lost :( better luck next time!");
			System.exit(0);
		}
	}

	public void update(int sunPointsUsed) {
		this.gameStats.removeSunPoints(sunPointsUsed);
		this.sunflowerPoints.setText("Sun Points: " + gameStats.getSunPoints());
	}

	public Stats getStats() {
		return this.gameStats;
	}

    public void handleEvent(Event event) {
        TurnResult turnResult = (TurnResult)event;
    }
}
