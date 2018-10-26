public class Sunflower extends Plant {
  public Sunflower() {
		super(10, 10);
    this.setType(this.sunFlower);
  }

	@Override
	public String toString(){
		return Character.toString(this.getType());
	}
}
