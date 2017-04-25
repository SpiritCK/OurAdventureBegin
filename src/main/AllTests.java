package main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	entity.PlayerTest.class,
	map.MapTest.class
})
public class AllTests {

}
