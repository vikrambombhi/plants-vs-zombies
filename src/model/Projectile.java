package model;
/* Projectile class is the kinetic bullet shot from a plant
 * The damage it deals to zombies and the speed it travels in tile space */
public class Projectile {

	private char projectile = '.'; // change implementation later
	
	private int damage;
	private int speed; // 1 = 1 tile per turn
	private int turn;
	private int distanceLeft;

	public Projectile(int damage, int speed) {
		this.damage = damage;
		this.speed = speed;
		this.turn = Stats.getStats().getTurn();
		this.distanceLeft = speed;
	}

	public int getDamage() {
		return this.damage;
	}

	public int getSpeed() {
		return this.speed;
	}

	public boolean move(int gameTurn) {
		if (turn != gameTurn) {
			return false;
		}

		distanceLeft--;
		if (distanceLeft == 0) {
			// projectile will only move again next turn
			turn++;
			distanceLeft = speed;
		}

		return true;
	}

	public int getTurn() {
		return turn;
	}

	public String toString() {
        return Character.toString(projectile);
	}

}
