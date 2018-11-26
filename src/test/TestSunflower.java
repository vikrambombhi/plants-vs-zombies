package test;

import junit.framework.*;
import model.Sunflower;

public class TestSunflower extends TestCase {

    Sunflower sunflower;

    public void testSunflowerType() {
        sunflower = new Sunflower();
        assertEquals("Sunflower type should be 'S'", 'S', sunflower.getType());
    }

    public void testSunflowerToString() {
        sunflower = new Sunflower();
        assertEquals("Sunflower name should be 'Sunflower'", "Sunflower", sunflower.toString());
    }
}