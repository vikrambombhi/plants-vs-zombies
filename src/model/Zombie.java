package model;
/* Zombie Class with parent class Zombies
 * This class is to allow any unique variables or method that is not necessary
 * for other subclass of Zombies */
public class Zombie extends Zombies {

	public Zombie() {
		// Creating a single regular zombie
		super(5, 2, 1);
	}

	@Override
	public String toString() {
		return ZombieTypes.ZOMBIE.getName();
	}

	@Override
	public char getType() {
		return ZombieTypes.ZOMBIE.getType();
	}
}
