package event;

import java.util.EventObject;

import model.Tile;

@SuppressWarnings("serial")
public class BoardEvent extends EventObject implements Event {

    private Tile[][] tiles;

    public BoardEvent(Object source, Tile[][] tiles) {
        super(source);
        this.tiles = tiles;
    }


    public Tile[][] getTiles() {
        return this.tiles;
    }
}
