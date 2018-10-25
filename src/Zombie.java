public class Zombie extends Piece {
  public Zombie() {
		this.setRandomZombieType();
  }

	@Override
	public String toString(){
		return Character.toString(this.getType());
	}
}
