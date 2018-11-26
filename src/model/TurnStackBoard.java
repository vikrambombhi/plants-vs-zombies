package model;

import java.util.Stack;

/*
 * Keeps track of the state of each turn allowing saves and redos.
 */
public class TurnStackBoard {

    private Stack<byte[]> pastStack;
    private Stack<byte[]> futureStack;
    private static TurnStackBoard turnStackBoard = null;


    public TurnStackBoard() {
    	 pastStack = new Stack<byte[]>();
         futureStack = new Stack<byte[]>();
         
         if (TurnStackBoard.turnStackBoard != null) {
             TurnStackBoard.turnStackBoard = this;
             System.out.println("returned turnStack model");
         } else {
             TurnStackBoard.turnStackBoard = this;
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

    public static TurnStackBoard getTurnStackBoard() {
        return turnStackBoard;
    }
}