package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import view.MainView;

public class MainController implements ActionListener {
	private MainView gameInterface;
	
	/* For saving and opening game file */
	private JFileChooser gameFile;
	
	public MainController() {
		gameInterface = new MainView();
		gameInterface.addActionListenerController(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == gameInterface.getCreatePVZGame()) {
			
			//For Testing
			//textArea.setText("Creating Game...... Plants VS. Zombies Created!\n");
			
			gameInterface.getCreatePVZGame().setEnabled(false);
			gameInterface.getSavePVZGame().setEnabled(true);
			
			gameInterface.getChangeBoardDimensions().setEnabled(true);
			
			System.out.println(e.getActionCommand());
		}
		/* Save the game for future play. Can be saved anywhere on your storage.
		 * NOT FULLY IMPLEMENTED YET - DOESNT SAVE PROPERLY */
		if(e.getSource() == gameInterface.getSavePVZGame()) {
            
			gameFile = new JFileChooser();
			int saveFile = gameFile.showSaveDialog(gameInterface);
			if (saveFile == JFileChooser.APPROVE_OPTION) {
			    File file = gameFile.getSelectedFile();
			}
	
//			// textArea.setText("Game Saving...... Game Saved!\n");
//			
//			try {
//				/* Save Location: F:\Users\Andrew Nguyen\eclipse-workspace\SYSC 3110 PvZ - PvZ GUI */
//				PrintWriter writer = new PrintWriter("PlantsVsZombies.txt", "UTF-8");
//				
//				writer.println();
//				writer.close();
//			} catch(FileNotFoundException e1) {
//				System.out.println("Unable to Create File");
//			} catch(UnsupportedEncodingException e1) {
//				System.out.println("Illegal Charset");
//			}
//			System.out.println(e.getActionCommand());
		}
		if(e.getSource() == gameInterface.getChangeBoardDimensions()) {
			System.out.println("Changing Dimensions");
		}
		if(e.getSource() == gameInterface.getQuitPVZGame()) {
			JOptionPane.showMessageDialog(gameInterface.getContentPane(),"Thanks for Playing! \nGoodBye!");
			System.exit(0);
		}
	}

}
