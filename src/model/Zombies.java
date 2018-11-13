/* "Zombies Class" for all type of Zombies.
 * Class abstract to define common behavior that can be inherited by multiple subclass Zombies.
 * Zombies can list from {Zombie, Flag Zombie, Conehead Zombie, Pole Vaulting Zombie, Bucket head Zombie, etc}
 * Check this site for list of zombies https://plantsvszombies.fandom.com/wiki/Zombies_(PvZ). */
public abstract class Zombies {
	private char type;

	// This is not a good way to keep track of types
	// maybe use a array, enum, or hashmap as needed in the future
	protected char normalZombie = 'Z';

	protected int hp;
	protected int damage;
	protected int movespeed; // 1 = 1 tile per turn

	/* All Zombies will have health point, attack damage, and movement speed */
	public Zombies(int hp, int damage, int movespeed) {
		this.hp = hp;
		this.damage = damage;
		this.movespeed = movespeed;
	}

	public int getHP() {
		return this.hp;
	}

	public int getDamage() {
		return this.damage;
	}

	public int getMovespeed() {
		return this.movespeed;
	}

	public void takeDamage(int dmg) {
		this.hp = ((this.hp - dmg) > 0) ? this.hp - dmg : 0;
	}

	public abstract String toString();

	protected char getType() {
		return this.type;
	}

	protected void setType(char type) {
		this.type = type;
	}
}