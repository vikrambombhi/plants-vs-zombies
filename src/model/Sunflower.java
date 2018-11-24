package model;

import model.Stats;

/* Sunflower Class is an essential entity for the game.
 * Sunflower generates cashflow for the player to buy new plants.*/
public class Sunflower extends Plants {

	private final int SUN_POINTS_GENERATED = 3;

	public Sunflower() {
		super(10, 8, 1);
	}

	public int getSunPointGeneratedPerTurn() {
		return SUN_POINTS_GENERATED;
	}

	@Override
	public String toString() {
		return PlantTypes.SUNFLOWER.getName();
	}

	@Override
	public char getType() {
		return PlantTypes.SUNFLOWER.getType();
	}
}
