package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import model.Stats;
import model.Zombie;

public class TestZombie {

    Stats stats;
    Zombie zombie;

    @Before
    public void setup() {
        stats = new Stats(0, 0);
        zombie = new Zombie();
    }

    @Test
        public void testZombieType() {
        assertEquals("Zombie type should be 'Z'", 'Z', zombie.getType());
    }

    @Test
    public void testZombieToString() {
        assertEquals("Zombie name should be 'Zombie'", "Zombie", zombie.toString());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestZombie.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}