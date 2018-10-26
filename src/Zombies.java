public abstract class Zombies {
  private char type;

  // This is not a good way to keep track of types
  // maybe use a array, enum, or hashmap as needed in the future
  protected char normalZombie = 'Z';

  protected int hp;


  public Zombies(int hp) {
    this.hp = hp;
  }

  public abstract String toString();

  protected char getType() {
    return this.type;
  }

  protected void setType(char type) {
    this.type = type;
  }
}