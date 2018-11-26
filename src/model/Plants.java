package model;

/*
 * "Plants Class" for all type of Plants.
 * Class abstract to define common behavior that can be inherited by multiple subclass Plants.
 * Plants can list from {Peashooter, Repeater, Threepeater, Split Pea, Gatling Pea, etc}
 * Check this site for list of plants https://plantsvszombies.fandom.com/wiki/Plants_(PvZ).
 */
public abstract class Plants {
	private char type;

	protected int hp;
	protected int sunPointCost;
	protected int abilityFrequency;
	protected int turnsUntilAbility;

	// hp: plants health point, sunPointCost: cost of plant, abilityFrequency: plants action per N turn(s)
	public Plants(int hp, int sunPointCost, int abilityFrequency) {
		this.hp = hp;
		this.sunPointCost = sunPointCost;
		this.abilityFrequency = abilityFrequency;
		this.turnsUntilAbility = 1;
	}

	public int getHP() {
		return this.hp;
	}

	public void takeDamage(int dmg) {
		hp = ((hp - dmg) > 0) ? hp - dmg : 0;
	}

	public int getSunPointCost() {
		return this.sunPointCost;
	}

	public int getAbilityFrequency() {
		return this.abilityFrequency;
	}

	public abstract String toString();
	public abstract char getType();
}
