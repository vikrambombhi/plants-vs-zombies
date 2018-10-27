public abstract class Projectile {

  protected int damage;
  protected int speed; // 1 = 1 tile per turn

  public Projectile(int damage, int speed) {
    this.damage = damage;
    this.speed = speed;
  }

  public int getDamage() {
      return this.damage;
  }

  public int getSpeed() {
      return this.speed;
  }

  public abstract String toString();
}
