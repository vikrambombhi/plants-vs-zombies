package model;

/* Peashooter is a type of damage dealing plant
 * Class sets the attributes and type of the plant */
public class Peashooter extends OffensivePlant {
	public Peashooter() {
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
