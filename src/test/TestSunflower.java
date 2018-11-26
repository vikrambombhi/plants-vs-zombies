package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import model.Sunflower;

public class TestSunflower {

    Sunflower sunflower;

    @Before
    public void setup() {
        sunflower = new Sunflower();
    }

    @Test
    public void testSunflowerType() {
        assertEquals("Sunflower type should be 'S'", 'S', sunflower.getType());
    }

    @Test
    public void testSunflowerToString() {
        assertEquals("Sunflower name should be 'Sunflower'", "Sunflower", sunflower.toString());
    }

    @Test
    public void testSunflowerHp() {
        assertEquals("Sunflower HP should be 10", 10, sunflower.getHP());
    }

    @Test
    public void testSunflowerTakeDamage() {
        sunflower.takeDamage(1);
        assertEquals("Sunflower HP should be 9", 9, sunflower.getHP());
    }

    @Test
    public void testSunflowerTakeExtraDamage() {
        // Way more hp the sunflower has
        sunflower.takeDamage(10000);
        // Sunflower HP should never be negitive only 0
        assertEquals("Sunflower HP should be 0", 0, sunflower.getHP());
    }

    @Test
    public void testSunflowerCost() {
        assertEquals("Sunflower cost should be 8", 8, sunflower.getSunPointCost());
    }

    @Test
    public void testSunflowerAbilityFrequency() {
        assertEquals("Sunflower ability frequency should be 1", 1, sunflower.getAbilityFrequency());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestSunflower.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}
