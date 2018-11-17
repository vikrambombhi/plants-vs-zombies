package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

import model.Plants;
import model.PlantTypes;
import model.Sunflower;

/* This is a Subclass that builds the MainView class.
 *  ShopPanel includes the list of plants the user can
 *  buy to place on the game field. */ 
public class PlantSelectionPanel {
	private final int PLANT_TYPES = PlantTypes.values().length;
	private JRadioButton[] plants;
	private JPanel shopPanel;
	private ButtonGroup buttonGroup;

	public PlantSelectionPanel() {
		buttonGroup = new ButtonGroup();
		plants = new JRadioButton[PLANT_TYPES];
		shopPanel = new JPanel();
		shopPanel.setPreferredSize(new Dimension(200,40));
		for (int i = 0; i < PLANT_TYPES; i++) {
			plants[i] = new JRadioButton(PlantTypes.values()[i].getName()); //fix this
			shopPanel.add(plants[i]);
			buttonGroup.add(plants[i]);
		}
	}
	
	/* Use to get shopPanel variable from for MainView */
	public JPanel getShopPanel() {
		return shopPanel;
	}

	public String getPlant() {
		for (int i = 0; i < plants.length; i++) {
			if (plants[i].isSelected()) {
				return plants[i].getText();
			}
		}
		return "";
	}
}
