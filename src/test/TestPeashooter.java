package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import model.Peashooter;

public class TestPeashooter {

    Peashooter peashooter;

    @Before
    public void setup() {
        peashooter = new Peashooter();
    }

    @Test
    public void testPeashooterType() {
        assertEquals("Peashooter type should be 'P'", 'P', peashooter.getType());
    }

    @Test
    public void testPeashooterToString() {
        assertEquals("Peashooter name should be 'Peashooter'", "Peashooter", peashooter.toString());
    }

    @Test
    public void tesPeashooterHp() {
        assertEquals("Peashooter HP should be 10", 10, peashooter.getHP());
    }

    @Test
    public void testPeashooterTakeDamage() {
        peashooter.takeDamage(1);
        assertEquals("Peashooter HP should be 9", 9, peashooter.getHP());
    }

    @Test
    public void testPeashooterTakeExtraDamage() {
        // Way more hp the peashooter has
        peashooter.takeDamage(10000);
        // Peashooter HP should never be negitive only 0
        assertEquals("Peashooter HP should be 0", 0, peashooter.getHP());
    }

    @Test
    public void testPeashooterCost() {
        assertEquals("Peashooter cost should be 15", 15, peashooter.getSunPointCost());
    }

    @Test
    public void testPeashooterAbilityFrequency() {
        assertEquals("Peashooter ability frequency should be 2", 2, peashooter.getAbilityFrequency());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestPeashooter.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}
