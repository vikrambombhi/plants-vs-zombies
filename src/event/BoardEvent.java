package event;

import java.util.EventObject;

@SuppressWarnings("serial")
public class BoardEvent extends EventObject {

    private int row;
    private int col;
    private char type;

    public BoardEvent(Object source, int row, int col, char type) {
        super(source);
        this.row = row;
        this.col = col;
        this.type = type;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public char getType() {
        return this.type;
    }
}
