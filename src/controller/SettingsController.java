package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import view.MainView;

public class SettingsController implements ActionListener {
	private MainView gameInterface;
	
	public SettingsController(MainView gameInterface) {
        this.gameInterface = gameInterface;
		gameInterface.addActionListenerSettingsController(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		/* 
         * This action creates the game by making the game visible.
         * This also enables and disables some of the menu selections.
         */
		if(e.getSource() == gameInterface.getCreatePVZGame()) {
			
			gameInterface.getCreatePVZGame().setEnabled(false);
			gameInterface.getSavePVZGame().setEnabled(true);
			gameInterface.getCreateMap().setEnabled(true);
			gameInterface.getLoadMap().setEnabled(true);
			gameInterface.getContentPane().setVisible(true);
			
			System.out.println(e.getActionCommand());
		}

		if(e.getSource() == gameInterface.getQuitPVZGame()) {
			JOptionPane.showMessageDialog(gameInterface.getContentPane(),"Thanks for Playing! \nGoodBye!");
			System.exit(0);
		}

		if(e.getSource() == gameInterface.getCreateMap()) {
            JFileChooser fc = gameInterface.getFileChooser();
            int returnVal = fc.showSaveDialog(gameInterface);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                // TODO: create xml here.
                System.out.println("Saving: " + file.getName());
            } else {
                System.out.println("Open command cancelled by user.");
            }
		}

		if(e.getSource() == gameInterface.getLoadMap()) {
            JFileChooser fc = gameInterface.getFileChooser();
            int returnVal = fc.showOpenDialog(gameInterface);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                // TODO: open xml here
                System.out.println("Opening: " + file.getName());
            } else {
                System.out.println("Open command cancelled by user.");
            }
		}
	}
}
