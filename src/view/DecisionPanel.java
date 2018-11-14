package view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

/* This is a Subclass that builds the MainView class.
 *  DecisionPanel includes the user option to either press
 *  Next Turn - Redo - Undo during their turn phase.*/ 
public class DecisionPanel {
	private static final int MAX_OPTIONS = 3;
	private JButton[] decisions;
	private JPanel decisionsPanel;

	
	public DecisionPanel() {
		decisions = new JButton[MAX_OPTIONS];
		decisionsPanel = new JPanel();
		decisionsPanel.setPreferredSize(new Dimension(200,40));
		
		decisions[0] = new JButton("Next Turn");
		decisions[1] = new JButton("Redo");
		decisions[2] = new JButton("Undo");
		
		// Loop in case we want to extend the options in the future
		for ( int i = 0; i < MAX_OPTIONS; i++) {
			decisionsPanel.add(decisions[i]);
		}
	}
	/* Use to get decisionPanel variable from for MainView */
	public JPanel getDecisionPanel() {
		return decisionsPanel;
	}
}
