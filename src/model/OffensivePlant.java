package model;

/* 
 * OffensivePlant is a subclass of Plants.
 * This is the initial break down to separate damage dealing plants and sunflower.
 * OffensivePlants shoots out a kinetic projectile and type component of firearm ammunition.
 */
public abstract class OffensivePlant extends Plants {

    protected int projectileDamage;
    protected int projectileSpeed;

    // Create plant
    public OffensivePlant(int hp, int sunPointCost, int abilityFrequency, int projectileDamage, int projectileSpeed) {
        super(hp, sunPointCost, abilityFrequency);
        this.projectileDamage = projectileDamage;
        this.projectileSpeed = projectileSpeed;
    }

    // Create projectile the plant can fire at zombies
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
