package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import event.StatsEvent;
import view.Listener;

public class Stats implements Serializable, Cloneable{

    private final int SUN_PER_TURN = 5;

    private List<Listener> listeners;
    // Start with enough sunpoints to spawn a sunflower, or wait one turn to get a peashooter
    private int sunPoints;
    private int sunPointsGenerationRate;
    private int numZombiesToEliminate;
    private int turn;
    private boolean playerLost;
    private static Stats stats = null;

    private CurrentStateStack redoUndoMoves;

    /*
     * The Stats class is a singleton class
     * @param sunPoints: amount of sunpoints to start with
     * @param numZombiesToEliminate: number of zombies to be eliminate
     */
    public Stats(int sunPoints, int numZombiesToEliminated) {
        if (Stats.stats != null) {
            Stats.stats = this;
            System.out.println("returned stats model");
        } else {
            Stats.stats = this;

            this.listeners = new ArrayList<>();
            this.sunPoints = sunPoints;
            this.sunPointsGenerationRate = SUN_PER_TURN;
            this.numZombiesToEliminate = numZombiesToEliminated;
            this.turn = 1;
            this.playerLost = false;
        }
        redoUndoMoves = new CurrentStateStack();
        
        try {
			redoUndoMoves.saveCurrentState(stats);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
    }
    
    public Object clone() throws CloneNotSupportedException{
		Stats clone = (Stats)super.clone();
		clone.sunPoints = this.sunPoints;
		clone.sunPointsGenerationRate = this.sunPointsGenerationRate;
		clone.numZombiesToEliminate = this.numZombiesToEliminate;
		
		return clone;
	}
    
    // After checking whether the previous node has an Object PlayerInfo, the stats gets replaced by the previous node
    // then passes to the listener to update
    public boolean undo() {
    	if(redoUndoMoves.undoChecker()) {
			this.stats = redoUndoMoves.undoMove();
			this.sunPoints = stats.getSunPoints();
			this.sunPointsGenerationRate = stats.getSunPointsGenerationRate();
			this.numZombiesToEliminate = stats.getNumZombiesRemaining();	
			notifyListeners();
			return(true);
		}
		return false;
    }
    
    public boolean redo() {
    	if(redoUndoMoves.redoChecker()) {
    		this.stats = redoUndoMoves.redoMove();
    		this.sunPoints = stats.getSunPoints();
			this.sunPointsGenerationRate = stats.getSunPointsGenerationRate();
			this.numZombiesToEliminate = stats.getNumZombiesRemaining();
    		notifyListeners();
    		return true;
    	}
    	return false;
    }
    
    // Saves the current state onto the stack.
    public void storeCurrentTurn() throws CloneNotSupportedException {
    	redoUndoMoves.saveCurrentState(stats);
    }

    public static Stats getStats() {
        return Stats.stats;
    }

    public void notifyListeners() {
        StatsEvent event = new StatsEvent(this, this.sunPoints, this.sunPointsGenerationRate, this.numZombiesToEliminate);
        for(Listener listener: listeners) listener.handleEvent(event);
    }

    public void addActionListener(Listener listener) {
        this.listeners.add(listener);
    }

    public int getSunPoints() {
        return sunPoints;
    }

    public void addSunPoints(int sunPoints) {
        this.sunPoints += sunPoints;
        this.notifyListeners();
    }

    public void removeSunPoints(int sunPoints) {
        this.sunPoints -= sunPoints;
        this.notifyListeners();
    }

    public int getSunPointsGenerationRate() {
        return this.sunPointsGenerationRate;
    }

    public void increaseSunPointsGenerationRate(int increase) {
        this.sunPointsGenerationRate += increase;
        this.notifyListeners();
    }

    public void decreaseSunPointsGenerationRate(int decrease) {
        this.sunPointsGenerationRate -= decrease;
        this.notifyListeners();
    }

    public int getNumZombiesRemaining() {
        return numZombiesToEliminate;
    }

    public void zombieEliminated() {
        numZombiesEliminated(1);
    }

    public void numZombiesEliminated(int zombiesEliminated) {
        this.numZombiesToEliminate -= zombiesEliminated;
        this.notifyListeners();
    }

    public int getNumZombiesToEliminate() {
        return numZombiesToEliminate;
    }

    public void incrementTurn() {
        turn++;
    }

    public int getTurn() {
        return turn;
    }

    public void playerLost() {
        playerLost = true;
    }

    public boolean hasPlayerLost() {
        return playerLost;
    }
}
