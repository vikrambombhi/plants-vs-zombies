package view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

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
		
		for ( int i = 0; i < MAX_OPTIONS; i++) {
			decisionsPanel.add(decisions[i]);
		}
	}
	
	public JPanel getDecisionPanel() {
		return decisionsPanel;
	}
}
