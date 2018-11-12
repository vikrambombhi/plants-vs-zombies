package model;
/* Sunflower Class is an essential entity for the game.
 * Sunflower generates cashflow for the player to buy new plants.*/
public class Sunflower extends Plants {

	private final int SUN_POINTS_GENERATED = 3;

	public Sunflower() {
		super(10, 8, 2);
		this.setType(this.sunFlower);
	}

	/*
	 * sunFlower generates sun points based on the turnsUntilAbility variable. ex/
	 * turnsUntilAbility = 2, every two turns the sunFower will generate extra sun
	 * points
	 */
	public int generateSunPoints() {
		this.turnsUntilAbility--;

		if (this.turnsUntilAbility == 0) {
			this.turnsUntilAbility = this.abilityFrequency;
			return SUN_POINTS_GENERATED;
		}
		return 0;
	}

	@Override
	public String toString() {
		return Character.toString(this.getType());
	}
}
