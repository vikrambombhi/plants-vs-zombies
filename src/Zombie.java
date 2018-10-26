/* Check this out for types of zombies
 * https://plantsvszombies.fandom.com/wiki/Zombies_(PvZ) */

public class Zombie extends Zombies {
  public Zombie() {
	  super(50);
	  this.setType(this.normalZombie);
  }

	@Override
	public String toString() {
		return Character.toString(this.getType());
	}
}
