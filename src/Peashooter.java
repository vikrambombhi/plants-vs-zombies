public class Peashooter extends OffensivePlant {
  public Peashooter() {
		super(10, 15, 1);
    this.setType(this.peaShooter);
  }

	@Override
	public String toString(){
		return Character.toString(this.getType());
	}
}
