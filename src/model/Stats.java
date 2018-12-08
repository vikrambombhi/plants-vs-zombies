package model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import event.StatsEvent;
import view.Listener;

public class Stats implements Serializable {

    private final int SUN_PER_TURN = 5;

    private List<Listener> listeners;
    // Start with enough sunpoints to spawn a sunflower, or wait one turn to get a peashooter
    private int sunPoints;
    private int sunPointsGenerationRate;
    private int numZombiesToEliminate;
    private int turn;
    private boolean playerLost;
    private static Stats stats = null;

    /*
     * The Stats class is a singleton class
     * @param sunPoints: amount of sunpoints to start with
     * @param numZombiesToEliminate: number of zombies to be eliminate
     */
    public Stats(int sunPoints, int numZombiesToEliminate) {
        if (Stats.stats != null) {
            Stats.stats = this;
        } else {
            Stats.stats = this;

            this.listeners = new ArrayList<>();
            this.sunPoints = sunPoints;
            this.sunPointsGenerationRate = SUN_PER_TURN;
            this.numZombiesToEliminate = numZombiesToEliminate;
            this.turn = 1;
            this.playerLost = false;
        }
    }

    public static Stats getStats() {
        return Stats.stats;
    }

    public void resetStats(int sunPoints, int numZombiesToEliminate) {
        this.sunPoints = sunPoints;
        this.sunPointsGenerationRate = SUN_PER_TURN;
        this.numZombiesToEliminate = numZombiesToEliminate;
        this.turn = 1;
        this.playerLost = false;
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
    
    public byte[] saveStats() throws IOException {
    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);

        out.writeObject(stats);
        byte[] b = bos.toByteArray();
        out.close();
        bos.close();

        return b;
    }
    
    public void undoStats(byte[] b) throws IOException, ClassNotFoundException {
    	ByteArrayInputStream bis = null;
    	ObjectInputStream in = null;
    	for (int i = 0; i < 3; i++) {
    		bis = new ByteArrayInputStream(b);
    		in = new ObjectInputStream(bis);
    		if (i < 1) stats.setSunPoints(((Stats)in.readObject()).getSunPoints());
    		else if (i < 2) stats.setSunPointsGenerationRate(((Stats)in.readObject()).getSunPointsGenerationRate());
    		else stats.setNumZombiesToEliminate(((Stats)in.readObject()).getNumZombiesToEliminate());
        }
        in.close();
        bis.close();
        notifyListeners();
    }
    
    public void setStats(int sunPoints, int sunPointsGenerationRate, int numZombiesToEliminate) {
    	this.sunPoints = sunPoints;
    	this.sunPointsGenerationRate = sunPointsGenerationRate;
    	this.numZombiesToEliminate = numZombiesToEliminate;
    }
    
    public void setSunPoints(int sunPoints) {
    	this.sunPoints = sunPoints;
    }
    
    public void setSunPointsGenerationRate(int sunPointsGenerationRate) {
    	this.sunPointsGenerationRate = sunPointsGenerationRate;
    }
    
    public void setNumZombiesToEliminate(int numZombiesToEliminate) {
    	this.numZombiesToEliminate = numZombiesToEliminate;
    }
}
