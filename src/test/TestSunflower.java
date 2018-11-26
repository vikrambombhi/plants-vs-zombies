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

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestSunflower.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}