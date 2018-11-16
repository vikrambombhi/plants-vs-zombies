package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JRadioButton;
import javax.swing.JPanel;

/* This is a Subclass that builds the MainView class.
 *  ShopPanel includes the list of plants the user can
 *  buy to place on the game field. */ 
public class PlantSelectionPanel {
	private static final int MAX_PLANTS = 5;
	private JRadioButton[] plants;
	private JPanel shopPanel;

	
	public PlantSelectionPanel() {
		plants = new JRadioButton[MAX_PLANTS];
		shopPanel = new JPanel();
		shopPanel.setPreferredSize(new Dimension(200,40));
		
		for ( int i = 0; i < MAX_PLANTS; i++) {
			plants[i] = new JRadioButton("Plant: " + (i+1)); //fix this
			shopPanel.add(plants[i]);
		}
	}
	
	/* Use to get shopPanel variable from for MainView */
	public JPanel getShopPanel() {
		return shopPanel;
	}
}
