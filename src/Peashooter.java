public class Peashooter extends Plant {
  public Peashooter() {
		super(10, 15);
    this.setType(this.peaShooter);
  }

	@Override
	public String toString(){
		return Character.toString(this.getType());
	}
}
