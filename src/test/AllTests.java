package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    TestPeashooter.class,
    TestSunflower.class,
    TestTankZombie.class,
    TestZombie.class
})
public class AllTests {
}