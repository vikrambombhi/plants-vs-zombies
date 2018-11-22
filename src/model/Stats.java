package model;

import java.util.ArrayList;
import java.util.List;

import event.StatsEvent;
import view.Listener;

public class Stats {

    private List<Listener> listeners;
    // Start with enough sunpoints to spawn a sunflower, or wait one turn to get a peashooter
    private int sunPoints;
    private int sunPointsGenerationRate;
    private int numZombiesToEliminate;
    private static Stats stats = null;

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
            this.numZombiesToEliminate = numZombiesToEliminated;
        }
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

    // TODO: Call when a sunflower is killed
    public void decreaseSunPointsGenerationRate(int decrease) {
        this.sunPointsGenerationRate -= decrease;
        this.notifyListeners();
    }

    public int getNumZombiesRemaining() {
        return numZombiesToEliminate;
    }

    public void numZombiesEliminated(int zombiesEliminated) {
        this.numZombiesToEliminate -= zombiesEliminated;
        this.notifyListeners();
    }

    public int getNumZombiesToEliminate() {
        return numZombiesToEliminate;
    }
}
