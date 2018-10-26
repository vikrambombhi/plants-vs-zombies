public abstract class Piece {
  private char type;

  // This is not a good way to keep track of types
  // maybe use a array, enum, or hashmap as needed in the future
  protected char normalZombie = 'Z';
  protected char sunFlower = 'S';
  protected char peaShooter = 'P';

  protected char getType() {
    return this.type;
  }

  protected void setType(char type) {
    this.type = type;
  }

}
