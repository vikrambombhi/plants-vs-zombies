package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.Serializable;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

import model.Plants;
import model.PlantTypes;
import model.Sunflower;

/*
 * This view allows the user to select which plant to buy
 */
public class PlantSelectionPanel implements Serializable {
	private final int PLANT_TYPES = PlantTypes.values().length;
	private JRadioButton[] plants;
	private JPanel shopPanel;
	private ButtonGroup buttonGroup;

    /*
     * Create plant selection panel
     */
	public PlantSelectionPanel() {
		buttonGroup = new ButtonGroup();
        // Using radio buttons to select plant
		plants = new JRadioButton[PLANT_TYPES];
		shopPanel = new JPanel();
		shopPanel.setPreferredSize(new Dimension(200,40));
        // Create a radio button for every plant type available
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

    // Returns currently selected plant
	public String getPlant() {
		for (int i = 0; i < plants.length; i++) {
			if (plants[i].isSelected()) {
				return plants[i].getText();
			}
		}
		return "";
	}
}
