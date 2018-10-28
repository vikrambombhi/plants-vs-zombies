/* Projectile class is the kinetic bullet shot from a plant
 * The damage it deals to zombies and the speed it travels in tile space */
public abstract class Projectile {

	protected int damage;
	protected int speed; // 1 = 1 tile per turn

	public Projectile(int damage, int speed) {
		this.damage = damage;
		this.speed = speed;
	}

	public int getDamage() {
		return this.damage;
	}

	public int getSpeed() {
		return this.speed;
	}

	public abstract String toString();
}
