package event;

import java.util.EventObject;

import model.Tile;

/*
 * Event to let view know of any changes in the board
 */
@SuppressWarnings("serial")
public class BoardEvent extends EventObject implements Event {

    // Hold state of board
    private Tile[][] tiles;

    // Create board event
    public BoardEvent(Object source, Tile[][] tiles) {
        super(source);
        this.tiles = tiles;
    }

    // Get state of board
    public Tile[][] getTiles() {
        return this.tiles;
    }
}
