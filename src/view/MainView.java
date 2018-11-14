package view;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import controller.MainController;

/* MainView is the main view class for plants vs zombies.
 * Main view will mainly focus on the end picture of the view. There are smaller view classes
 * broken down into individual panels that MainView will use to build the GUI. */
public class MainView extends JFrame {
	JMenuBar menuBar;
	JMenu menu1, menu2;
	
	JMenuItem createPVZGame, savePVZGame, quitPVZGame, changeBoardDimensions;
	JTextArea textArea;
	JScrollPane scrollPane;
	JOptionPane optionPane;
	Container contentPane;
	GridBagLayout layout;
	
	
	/* Set up for the game client view */
	GamePanel gamePanel;
	PlantSelectionPanel plantSelectionPanel;
	DecisionPanel decisionPanel;
	StatsPanel statsPanel;
	DescriptionPanel descriptionPanel;
	
	
	public MainView() {
		super("Plants Vs Zombies Interface");

		/* Setting up start up layout of GUI */
		setLocationRelativeTo(null);
		setSize(800, 450);
		layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		contentPane = getContentPane();
		contentPane.setLayout(layout);
		
		/* Menu navigation: AddressBook and BuddyInfo */
		menuBar = new JMenuBar();
		menu1 = new JMenu("Game");
		menu2 = new JMenu("Setting");
		menuBar.add(menu1);
		menuBar.add(menu2);
		setJMenuBar(menuBar);
		
		/* Sub menu for navigation tabs: AddressBook - Create, Save, Display */
		createPVZGame = new JMenuItem("Create Game");
		savePVZGame = new JMenuItem("Save Game");
		quitPVZGame = new JMenuItem("Quit");
		menu1.add(createPVZGame);
		menu1.add(savePVZGame);
		menu1.addSeparator();
		menu1.add(quitPVZGame);
		
		/* Sub menu for navigation tab: BuddyInfo - Add New Buddy */
		changeBoardDimensions = new JMenuItem("Change Game Field Dimension");
		menu2.add(changeBoardDimensions);
		
		/* This component contains the game's stats like sun flower points and zombies left to kill */
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		statsPanel = new StatsPanel();
		contentPane.add(statsPanel.getStatsPanel(), c);
		
		/* This component contains the game's field of play made out of 2-D JButton slots */
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		gamePanel = new GamePanel();
		contentPane.add(gamePanel.getGamePanel(), c);
		
		/* This component contains the game's instruction */
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		descriptionPanel = new DescriptionPanel();
		contentPane.add(descriptionPanel.getDesciptionPanel(), c);
		
		/* This component contains the flowers you can select to place on the game field */
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 30;
		c.gridx = 0;
		c.gridy = 2;
		plantSelectionPanel = new PlantSelectionPanel();
		contentPane.add(plantSelectionPanel.getShopPanel(), c);
		
		/* This component contains the decisions you make per turn */
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		decisionPanel = new DecisionPanel();
		contentPane.add(decisionPanel.getDecisionPanel(), c);
		
		/* Disable some sub menu option: forces user to create game first for other options to be available. */
		createPVZGame.setEnabled(true);
		savePVZGame.setEnabled(false);
		quitPVZGame.setEnabled(true);
		changeBoardDimensions.setEnabled(true);
		contentPane.setVisible(false); // We want the user to create the game to see the game.
		
		/* Display the interface */
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	/* Create action handler for each sub menu option */
	public void addActionListenerController(MainController handler) {
		createPVZGame.addActionListener(handler);
		savePVZGame.addActionListener(handler);
		quitPVZGame.addActionListener(handler);
		changeBoardDimensions.addActionListener(handler);
	}
	
	/* Use to get createPVZGame variable from view for Controller */
	public JMenuItem getCreatePVZGame() {
		return createPVZGame;
	}
	/* Use to get savePVZGame variable from view for Controller */
	public JMenuItem getSavePVZGame() {
		return savePVZGame;
	}
	/* Use to get changeBoardDimension variable from view for Controller */
	public JMenuItem getChangeBoardDimensions() {
		return changeBoardDimensions;
	}
	/* Use to get quitPVZGame variable from view for Controller */
	public JMenuItem getQuitPVZGame() {
		return quitPVZGame;
	}

}
