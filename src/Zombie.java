public class Zombie extends Piece {
  public Zombie() {
		this.setType(this.normalZombie);
  }

	@Override
	public String toString(){
		return Character.toString(this.getType());
	}
}
