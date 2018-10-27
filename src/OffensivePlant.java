public abstract class OffensivePlant extends Plant {
    public OffensivePlant(int hp, int sunPointCost, int abilityFrequency) {
        super(hp, sunPointCost, abilityFrequency);
    }

    public Projectile generateProjectile() {
		this.turnsUntilAbility--;

		if (this.turnsUntilAbility == 0) {
			this.turnsUntilAbility = this.abilityFrequency;
			return new PeashooterProjectile();
		}

		return null;
	}

    public abstract String toString();
}