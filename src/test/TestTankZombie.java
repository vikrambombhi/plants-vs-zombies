package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


import model.Stats;
import model.TankZombie;

public class TestTankZombie {

    Stats stats;
    TankZombie zombie;

    @Before
    public void setup() {
        stats = new Stats(0, 0);
        zombie = new TankZombie();
    }

    @Test
    public void testTankZombieType() {
        assertEquals("TankZombie type should be 'T'", 'T', zombie.getType());
    }

    @Test
    public void testTankZombieToString() {
        assertEquals("TankZombie name should be 'Tank'", "Tank", zombie.toString());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestTankZombie.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}