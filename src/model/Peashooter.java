package model;

/*
 * Peashooter is a type of damage dealing plant
 * Class sets the attributes and type of the plant
 */
public class Peashooter extends OffensivePlant {
    // Create peashooter plant
	public Peashooter() {
        /*
         * Itialize as OffensivePlant using the following config
         *      - hp: 10
         *      - cost: 15
         *      - frequency at which to fire projectile: 2
         *      - damage of projectile: 1
         *      - projectile speed: 1
         */
		super(10, 15, 2, 1, 1);
	}

	@Override
	public String toString() {
		return PlantTypes.PEASHOOTER.getName();
	}

	@Override
	public char getType() {
		return PlantTypes.PEASHOOTER.getType();
	}
}
