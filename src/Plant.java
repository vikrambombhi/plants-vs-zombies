public abstract class Plant {
  private char type;

  // This is not a good way to keep track of types
  // maybe use a array, enum, or hashmap as needed in the future
  protected char sunFlower = 'S';
  protected char peaShooter = 'P';

  protected int hp;
  protected int sunPointCost;
  protected int abilityFrequency;
  protected int turnsUntilAbility;

  public Plant(int hp, int sunPointCost, int abilityFrequency) {
    this.hp = hp;
    this.sunPointCost = sunPointCost;
    this.abilityFrequency = abilityFrequency;
    this.turnsUntilAbility = abilityFrequency;
  }

  public int getHP() {
    return this.hp;
  }

  public void takeDamage(int dmg) {
    hp = hp - dmg > 0 ? hp - dmg : 0;
  }

  public int getSunPointCost() {
    return this.sunPointCost;
  }

  public int getAbilityFrequency() {
    return this.abilityFrequency;
  }

  public abstract String toString();

  protected char getType() {
    return this.type;
  }

  protected void setType(char type) {
    this.type = type;
  }
}
