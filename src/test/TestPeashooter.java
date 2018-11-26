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
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestPeashooter.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}