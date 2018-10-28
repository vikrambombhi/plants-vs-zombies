/* PeashooterProjectile is a projectile subclass that belongs to peashooter.
 * By giving it a separate class, it identifies its unique traits */
public class PeashooterProjectile extends Projectile {

	private char pea = '.'; // change implementation later

	public PeashooterProjectile(int damage, int speed) {
		super(damage, speed);
	}

	public String toString() {
		return Character.toString(pea);
	}
}