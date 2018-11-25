package model;

import java.io.Serializable;

public class PlayerInfo implements Serializable, Cloneable {
	private Stats gameStats;
	private int sunPoints;
	private int sunPointsGenerationRate;
	private int zombiesRemaining;
	
	public PlayerInfo(Stats gameStats) {
		this.gameStats = gameStats;
		sunPoints = this.gameStats.getSunPoints();
		sunPointsGenerationRate = this.gameStats.getSunPoints();
		zombiesRemaining = this.gameStats.getNumZombiesRemaining();
	}
	
	public int getSunPoints() {
		return sunPoints;
	}
	
	public int getSunPointsGenerationRate() {
		return sunPointsGenerationRate;
	}
	
	public int getZombiesRemaining() {
		return zombiesRemaining;
	}
	
	public Object clone() throws CloneNotSupportedException{
		PlayerInfo clone = (PlayerInfo)super.clone();
		clone.sunPoints = this.sunPoints;
		clone.sunPointsGenerationRate = this.sunPointsGenerationRate;
		clone.zombiesRemaining = this.zombiesRemaining;
		
		return clone;
	}
	

}
