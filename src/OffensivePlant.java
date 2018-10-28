/* OffensivePlant is a subclass of Plants.
 * This is the initial break down to separate damage dealing plants and sunflower.
 * OffensivePlants shoots out a kinetic projectile and type component of firearm ammunition.*/
public abstract class OffensivePlant extends Plants {
    public OffensivePlant(int hp, int sunPointCost, int abilityFrequency) {
        super(hp, sunPointCost, abilityFrequency);
    }

    // using "this" works in this case, but it should be "super" to prevent smelly code since we're calling from super class.
    public Projectile generateProjectile() {
    	// PeaShooter should shoot right away
    	return new PeashooterProjectile(1, this.abilityFrequency);
	}

	public abstract String toString();
}
