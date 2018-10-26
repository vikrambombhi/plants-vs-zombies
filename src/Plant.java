public abstract class Plant {
  private char type;

  // This is not a good way to keep track of types
  // maybe use a array, enum, or hashmap as needed in the future
  protected char sunFlower = 'S';
  protected char peaShooter = 'P';

  protected int hp;
  protected int sunPointCost;

  public Plant(int hp, int sunPointCost) {
    this.hp = hp;
    this.sunPointCost = sunPointCost;
  }

  public int getSunPointCost() {
    return this.sunPointCost;
  }

  public abstract String toString();

  protected char getType() {
    return this.type;
  }

  protected void setType(char type) {
    this.type = type;
  }
}
