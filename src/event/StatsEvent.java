package event;

import java.util.EventObject;

@SuppressWarnings("serial")
public class StatsEvent extends EventObject implements Event {

    private int sunPoints;
    private int sunPointsGenerationRate;
    private int numZombiesToEliminate;

	public StatsEvent(Object source, int sunPoints, int sunPointsGenerationRate, int numZombiesToEliminate) {
        super(source);
        this.sunPoints = sunPoints;
        this.sunPointsGenerationRate = sunPointsGenerationRate;
        this.numZombiesToEliminate = numZombiesToEliminate;
	}

	public int getSunPoints() {
		return this.sunPoints;
	}

    public int getSunPointsGenerationRate() {
        return this.sunPointsGenerationRate;
    }

	public int getZombiesToEliminate() {
		return this.numZombiesToEliminate;
	}
}
