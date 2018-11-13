package model;
/* Zombie Class with parent class Zombies
 * This class is to allow any unique variables or method that is not necessary
 * for other subclass of Zombies */
public class Zombie extends Zombies {

	// Could include resistance variable

	public Zombie() {

		// Creating a single regular zombie
		super(5, 2, 1);
		this.setType(this.normalZombie);
	}

	@Override
	public String toString() {
		return Character.toString(this.getType());
	}
}
