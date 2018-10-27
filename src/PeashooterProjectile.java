public class PeashooterProjectile extends Projectile {
    
    private char pea = 'o'; //change implementation later

    public PeashooterProjectile() {
        super(1, 1);
    }

    public String toString() {
        return Character.toString(pea);
    }
}