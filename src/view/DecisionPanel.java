package view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.NextTurnController;
import controller.RedoController;
import controller.UndoController;

/* This is a Subclass that builds the MainView class.
 *  DecisionPanel includes the user option to either press
 *  Next Turn - Redo - Undo during their turn phase.*/ 
public class DecisionPanel {
	private static final int MAX_OPTIONS = 3;
	private JButton[] decisions;
	private JPanel decisionsPanel;

	
	public DecisionPanel(StatsPanel statsPanel) {
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

		decisions[0].addActionListener(new NextTurnController(statsPanel));
		decisions[1].addActionListener(new RedoController(statsPanel));
		decisions[2].addActionListener(new UndoController(statsPanel));
	}
	/* Use to get decisionPanel variable from for MainView */
	public JPanel getDecisionPanel() {
		return decisionsPanel;
	}

	public void handleEvent() {
        
    }
}
