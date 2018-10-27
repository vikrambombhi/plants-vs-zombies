public class Sunflower extends Plant {

	private final int SUN_POINTS_GENERATED = 3;

  public Sunflower() {
		super(10, 8, 2);
    this.setType(this.sunFlower);
  }

	public int generateSunPoints() {
		this.turnsUntilAbility--;

		if (this.turnsUntilAbility == 0) {
			this.turnsUntilAbility = this.abilityFrequency;
			return SUN_POINTS_GENERATED;
		}
		return 0;
	}

	@Override
	public String toString(){
		return Character.toString(this.getType());
	}
}
