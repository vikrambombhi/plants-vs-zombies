package model;

import java.util.Stack;

/*
 * Keeps track of the state of each turn allowing saves and redos.
 */
public class TurnStackBoard {

    private Stack<byte[]> stack;
    private static TurnStackBoard turnStackBoard = null;


    public TurnStackBoard() {
        stack = new Stack<byte[]>();
        if (TurnStackBoard.turnStackBoard != null) {
            TurnStackBoard.turnStackBoard = this;

            System.out.println("returned turnStack model");
        } else {
            TurnStackBoard.turnStackBoard = this;
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

    public static TurnStackBoard getTurnStackBoard() {
        return turnStackBoard;
    }
}