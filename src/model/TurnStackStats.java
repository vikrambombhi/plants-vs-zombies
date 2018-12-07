package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;

/*
 * Keeps track of the state of each turn allowing saves and redos.
 */
public class TurnStackStats {
	
    private Stack<byte[]> pastStack;
    private Stack<byte[]> futureStack;
    private static TurnStackStats turnStackStats = null;

    public TurnStackStats() {
    	
        pastStack = new Stack<byte[]>();
        futureStack = new Stack<byte[]>();
        
        if (TurnStackStats.turnStackStats != null) {
            TurnStackStats.turnStackStats = this;
            System.out.println("returned turnStack model");
        } else {
            TurnStackStats.turnStackStats = this;
            pastStack = new Stack<byte[]>();
        }
    }

    public void saveTurn(byte[] b) {
        pastStack.push(b);
        futureStack.clear();
    }

    public byte[] undoTurn() {
    	byte[] tempStack = null;
        if (pastStack.size() > 1) {
        	tempStack = pastStack.pop();
        	futureStack.push(tempStack);
        	return tempStack;
        }
        else if (pastStack.size() == 1) return pastStack.peek();
        return null;
    }
    
    public byte[] redoTurn() {
    	byte[] tempStack = null;
    	if (futureStack.size() > 1) {
    		tempStack = futureStack.pop();
    		pastStack.push(tempStack);
    		return tempStack;
    	}
        else if (futureStack.size() == 1) return futureStack.peek();
        return null;
    }

    public static TurnStackStats getTurnStackStats() {
        return turnStackStats;
    }
    
    public void writeObject(String filePath) throws IOException {
    	byte[] tempStack = null;  
    	if (pastStack.size() > 1) {
         	tempStack = pastStack.pop();
    	 } else tempStack = pastStack.peek();
    	
    	FileOutputStream streamToFile = new FileOutputStream(filePath);
    	ObjectOutputStream outStream= new ObjectOutputStream(streamToFile);
    	outStream.writeObject(tempStack);
    	outStream.close();
    }
    
    public byte[] readObject(String filePath) throws ClassNotFoundException, IOException {
    	byte[] tempStack = null; 
    	FileInputStream streamToFile = new FileInputStream(filePath);
    	ObjectInputStream inStream = new ObjectInputStream(streamToFile);
    	tempStack =(byte []) inStream.readObject();
    	inStream.close();
    	
    	return tempStack;
    }
}