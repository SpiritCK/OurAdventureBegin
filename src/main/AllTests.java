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

/* Kelas-kelas lain tidak perlu / tidak bisa dibuat JUnit
 * Karena isinya hanya berupa getter setter (virtumon dan turunannya)
 * dan berupa view atau controller yang tidak bisa dites. */