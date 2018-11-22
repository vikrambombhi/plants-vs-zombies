package test;

import junit.framework.*;
import model.Sunflower;

public class TestSunflower extends TestCase {

    Sunflower sunflower;

    public void testGenerateSunPointsAfterOneTurn() {
        sunflower = new Sunflower();
        assertEquals("Sun points should not be generated by sun flower after first turn.", 0, sunflower.generateSunPoints());
    }

    public void testGenerateSunPointsAfterTwoTurns() {
        sunflower = new Sunflower();
        sunflower.generateSunPoints();
        assertEquals("Sun points generated should equal 3 after two turns.", 3, sunflower.generateSunPoints());
    }

    public void testSunflowerType() {
        sunflower = new Sunflower();
        assertEquals("Sunflower type should be 'S'", 'S', sunflower.getType());
    }

    public void testSunflowerToString() {
        sunflower = new Sunflower();
        assertEquals("Sunflower name should be 'Sunflower'", "Sunflower", sunflower.toString());
    }
}