import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class PvZ_GUI extends JFrame {
	JMenuBar menuBar;
	JMenu menu1, menu2;
	
	JMenuItem createPVZGame, savePVZGame, changeBoardDimensions;
	JTextArea textArea;
	JScrollPane scrollPane;
	JOptionPane optionPane;
	Container contentPane;
	FlowLayout layout;
	
	public PvZ_GUI() {
		super("Plants Vs Zombies Interface");

		/* Setting up start up layout of GUI */
		setLocationRelativeTo(null);
		setSize(1000, 400);
		layout = new FlowLayout();
		contentPane = getContentPane();
		contentPane.setLayout(layout);

		// For Testing purpose
		textArea = new JTextArea(1,80);
		textArea.setEditable(false);		
		contentPane.add(textArea);
		
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
		menu1.add(createPVZGame);
		menu1.add(savePVZGame);
		
		/* Sub menu for navigation tab: BuddyInfo - Add New Buddy */
		changeBoardDimensions = new JMenuItem("Change Game Field Dimension");
		menu2.add(changeBoardDimensions);

		
		/* Create action handler for each sub menu option */
		actionHandler handler = new actionHandler();
		createPVZGame.addActionListener(handler);
		savePVZGame.addActionListener(handler);

		changeBoardDimensions.addActionListener(handler);
		
		/* Disable some sub menu option: forces user to create an AddressBook first */
		createPVZGame.setEnabled(true);
		savePVZGame.setEnabled(false);

		changeBoardDimensions.setEnabled(true);
		
		/* Display the interface */
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	
	/* Need to implement this after the board is created */
	private class actionHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	
			if(e.getSource() == createPVZGame) {
				
				//For Testing
				textArea.setText("Creating Game...... Plants VS. Zombies Created!\n");
				
				createPVZGame.setEnabled(false);
				savePVZGame.setEnabled(true);
				
				changeBoardDimensions.setEnabled(true);
				
				System.out.println(e.getActionCommand());
			}
//			if(e.getSource() == savePVZGame) {
//				// textArea.setText("Game Saving...... Game Saved!\n");
//				
//				try {
//					/* Save Location: F:\Users\Andrew Nguyen\eclipse-workspace\SYSC 3110 PvZ - PvZ GUI */
//					PrintWriter writer = new PrintWriter("PlantsVsZombies.txt", "UTF-8");
//					
//					writer.println();
//					writer.close();
//				} catch(FileNotFoundException e1) {
//					System.out.println("Unable to Create File");
//				} catch(UnsupportedEncodingException e1) {
//					System.out.println("Illegal Charset");
//				}
//				System.out.println(e.getActionCommand());
//			}
			if(e.getSource() == changeBoardDimensions) {
				System.out.println("Changing Dimensions");
			}
			
		}
	}
}
