package model;

public class Stats {

    // Start with enough sunpoints to spawn a sunflower, or wait one turn to get a peashooter
    private int sunPoints;
    private int numZombiesToEliminate;
    private static Stats stats = null;

    /*
     * The Stats class is a singleton class
     * @param sunPoints: amount of sunpoints to start with
     * @param numZombiesToEliminate: number of zombies to be eliminate
     */
    public Stats(int sunPoints, int numZombiesEliminated) {
        if (Stats.stats != null) {
            Stats.stats = this;
        } else {
            this.sunPoints = sunPoints;
            this.numZombiesToEliminate = numZombiesEliminated;
        }
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
