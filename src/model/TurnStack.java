package model;

import java.util.Stack;

/*
 * Keeps track of the state of each turn allowing saves and redos.
 */
public class TurnStack {

    private Stack<byte[]> stack;
    private static TurnStack turnStack = null;

    public TurnStack() {
        stack = new Stack<byte[]>();
        if (TurnStack.turnStack != null) {
            TurnStack.turnStack = this;
            System.out.println("returned turnStack model");
        } else {
            TurnStack.turnStack = this;
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

    public static TurnStack getTurnStack() {
        return turnStack;
    }
}