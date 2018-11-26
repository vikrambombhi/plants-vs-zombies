package model;

/*
 * Tank Zombie is a zombie that has more HP and deals more damage than a regular one 
 */
public class TankZombie extends Zombies {

	public TankZombie() {
		super(8, 3, 1);
	}

	@Override
	public String toString() {
		return ZombieTypes.TANK.getName();
	}

	@Override
	public char getType() {
		return ZombieTypes.TANK.getType();
	}
}
