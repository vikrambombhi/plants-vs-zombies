public class Peashooter extends Piece {
  public Peashooter() {
    this.setType(this.peaShooter);
  }

	@Override
	public String toString(){
		return Character.toString(this.getType());
	}
}
