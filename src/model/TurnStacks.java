package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Stack;


public class TurnStacks {
	private TurnStackBoard turnStackBoard;
	private TurnStackStats turnStackStats;
	private ArrayList<byte[]> turnStackSet;
	private static TurnStacks turnStacks = null;

	
	public TurnStacks() {
		this.turnStackBoard = TurnStackBoard.getTurnStackBoard();
        this.turnStackStats = TurnStackStats.getTurnStackStats();
        this.turnStackSet = new ArrayList<>();
        
        if (TurnStacks.turnStacks != null) {
            TurnStacks.turnStacks = this;
            System.out.println("returned turnStack model");
        } else {
            TurnStacks.turnStacks = this;
            this.turnStackBoard = TurnStackBoard.getTurnStackBoard();
            this.turnStackStats = TurnStackStats.getTurnStackStats();
            turnStackSet = new ArrayList<>();
        }
        
        turnStackSet.add(turnStackBoard.getCurrentBoard());
        turnStackSet.add(turnStackStats.getCurrentStat());
	}
	
	public static TurnStacks getTurnStacks() {
        return turnStacks;
    }
	
	public void updateStack() {
		
		turnStackSet.set(0, turnStackBoard.getCurrentBoard());
		turnStackSet.set(1, turnStackStats.getCurrentStat());
		
	}
	public ArrayList<byte[]> getTurnStackSet() {
		return turnStackSet;
	}
	
	public void writeObject(String filePath) throws IOException {
		updateStack();
    	FileOutputStream streamToFile = new FileOutputStream(filePath);
    	ObjectOutputStream outStream= new ObjectOutputStream(streamToFile);
    	outStream.writeObject(turnStackSet);
    	outStream.close();
    }
    
    @SuppressWarnings("unchecked")
	public ArrayList<byte[]> readObject(String filePath) throws ClassNotFoundException, IOException {
    	FileInputStream streamToFile = new FileInputStream(filePath);
    	ObjectInputStream inStream = new ObjectInputStream(streamToFile);
    	turnStackSet =(ArrayList<byte[]>) inStream.readObject();
    	inStream.close();
    	
    	return turnStackSet;
    }

}
