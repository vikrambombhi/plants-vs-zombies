/* OffensivePlant is a subclass of Plants.
 * This is the initial break down to separate damage dealing plants and sunflower.
 * OffensivePlants shoots out a kinetic projectile and type component of firearm ammunition.*/
public abstract class OffensivePlant extends Plants {

    protected int projectileDamage;
    protected int projectileSpeed;

    public OffensivePlant(int hp, int sunPointCost, int abilityFrequency, int projectileDamage, int projectileSpeed) {
        super(hp, sunPointCost, abilityFrequency);
        this.projectileDamage = projectileDamage;
        this.projectileSpeed = projectileSpeed;
    }

    // using "this" works in this case, but it should be "super" to prevent smelly code since we're calling from super class.
    public Projectile generateProjectile() {
    	this.turnsUntilAbility--;

        if (this.turnsUntilAbility == 0) {
            this.turnsUntilAbility = this.abilityFrequency;
            return new Projectile(projectileDamage, projectileSpeed);
        }
    	return null;
	}

	public abstract String toString();
}
