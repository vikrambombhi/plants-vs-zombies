package event;

import java.util.EventObject;

/*
 * Event to let view know of any changes in the stats
 */
@SuppressWarnings("serial")
public class StatsEvent extends EventObject implements Event {

    // Hold game stats
    private int sunPoints;
    private int sunPointsGenerationRate;
    private int numZombiesToEliminate;

    // Create event
	public StatsEvent(Object source, int sunPoints, int sunPointsGenerationRate, int numZombiesToEliminate) {
        super(source);
        this.sunPoints = sunPoints;
        this.sunPointsGenerationRate = sunPointsGenerationRate;
        this.numZombiesToEliminate = numZombiesToEliminate;
	}

    // return stat of how many sunPoints the user has
	public int getSunPoints() {
		return this.sunPoints;
	}

    // return stat of how many sunPoints the user gets per turn
    public int getSunPointsGenerationRate() {
        return this.sunPointsGenerationRate;
    }

    // return stat of how many zombies the user must eliminate/survive
	public int getZombiesToEliminate() {
		return this.numZombiesToEliminate;
	}
}
