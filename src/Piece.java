public abstract class Piece {
  private char type;

  protected char normalZombie = 'Z';
  protected char sunFlower = 'S';

  protected char getType() {
    return this.type;
  }

  protected void setType(char type) {
    this.type = type;
  }

  protected void setRandomZombieType() {
    this.setType(normalZombie);
  }
}
