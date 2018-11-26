package model;

import java.util.Stack;

/*
 * Keeps track of the state of each turn allowing saves and redos.
 */
public class TurnStackStats {
	
    private Stack<byte[]> stack;
    private static TurnStackStats turnStackStats = null;

    public TurnStackStats() {
    	
        stack = new Stack<byte[]>();
        if (TurnStackStats.turnStackStats != null) {
            TurnStackStats.turnStackStats = this;
            System.out.println("returned turnStack model");
        } else {
            TurnStackStats.turnStackStats = this;
            stack = new Stack<byte[]>();
        }
    }

    public void saveTurn(byte[] b) {
        stack.push(b);
    }

    public byte[] undoTurn() {
        if (stack.size() > 1) return stack.pop();
        else if (stack.size() == 1) return stack.peek();
        return null;
    }
    
    public static TurnStackStats getTurnStackStats() {
        return turnStackStats;
    }
}