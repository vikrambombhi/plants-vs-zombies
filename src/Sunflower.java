public class Sunflower extends Piece {
  public Sunflower() {
    this.setType(this.sunFlower);
  }

	@Override
	public String toString(){
		return Character.toString(this.getType());
	}
}
