package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    TestBoard.class,
    TestPeashooter.class,
    TestSunflower.class,
    TestTankZombie.class,
    TestZombie.class
})
public class AllTests {
}