package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * Builds a text area with instructions on how to play the game
 */
public class DescriptionPanel {

	private JTextArea howToPlay;
	private JPanel descriptionPanel;
	
	public DescriptionPanel() {
		howToPlay = new JTextArea("Plants Vs Zombies \nThe objective of the game is to stop zombies from reaching the left end of the board. "
				+ "The zombies will spawn on the right side and will make their way across the field. Defend yourself "
				+ "by planting your trusty flowers to fight back. Remember to plant sun flowers to gain more sun flower points per round. "
				+ "Plants aren't free, use those points to fortify your garden. Good luck!");
		howToPlay.setPreferredSize(new Dimension(190,230));
		howToPlay.setLineWrap(true);
		howToPlay.setWrapStyleWord(true);
		descriptionPanel = new JPanel();
		descriptionPanel.setPreferredSize(new Dimension(200,260));
		descriptionPanel.add(howToPlay);
	}

	/* Use to get descriptionPanel variable from for MainView */
	public JPanel getDesciptionPanel() {
		return descriptionPanel;
	}
}
