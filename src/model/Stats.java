package model;

public class Stats {

    // Start with enough sunpoints to spawn a sunflower, or wait one turn to get a peashooter
    private int sunPoints;
    private int numZombiesToGenerate, numZombiesToEliminate;

    public Stats(int sunPoints, int numZombiesToGenerate, int numZombiesEliminated) {
        this.sunPoints = sunPoints;
        this.numZombiesToGenerate = numZombiesToGenerate;
        this.numZombiesToEliminate = numZombiesEliminated;
    }

    public int getSunPoints() {
        return sunPoints;
    }

    public void addSunPoints(int sunPoints) {
        this.sunPoints += sunPoints;
    }

    public void removeSunPoints(int sunPoints) {
        this.sunPoints -= sunPoints;
    }

    public int getNumZombiesRemaining() {
        return numZombiesToEliminate;
    }

    public void numZombiesEliminated(int zombiesEliminated) {
        this.numZombiesToEliminate -= zombiesEliminated;
    }

    public int getNumZombiesToEliminate() {
        return numZombiesToEliminate;
    }
}