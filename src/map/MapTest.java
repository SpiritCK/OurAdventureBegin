package map;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import entity.Player;

public class MapTest {

	@Test
	public void testIncrementX() {
		try {
			Map test = new Map(new File("data/testmap.txt"),new Player("Kevin", 10));
			test.IncrementX(true);
			assertEquals(1,test.player.getX());
			test.IncrementX(false);
			assertEquals(0,test.player.getX());
		} catch (IOException e) {
			fail("File not found");
		}
	}

	@Test
	public void testIncrementY() {
		try {
			Map test = new Map(new File("data/testmap.txt"),new Player("Kevin", 10));
			test.IncrementY(true);
			assertEquals(2,test.player.getY());
		} catch (IOException e) {
			fail("File not found");
		}
	}

	@Test
	public void testGetBattle() {
		try {
			Map test = new Map(new File("data/testmap.txt"),new Player("Kevin", 10));
			assertEquals(-1,test.getBattle());
		} catch (IOException e) {
			fail("File not found");
		}
	}

	@Test
	public void testBattleConfirmed() {
		try {
			Map test = new Map(new File("data/testmap.txt"),new Player("Kevin", 10));
			test.battleStatus = 1;
			test.battleConfirmed(2);
			assertEquals(-1,test.getBattle());
		} catch (IOException e) {
			fail("File not found");
		}
	}

	@Test
	public void testGetNumRows() {
		try {
			Map test = new Map(new File("data/testmap.txt"),new Player("Kevin", 10));
			assertEquals(5,test.getNumRows());
		} catch (IOException e) {
			fail("File not found");
		}
	}

	@Test
	public void testGetNumCols() {
		try {
			Map test = new Map(new File("data/testmap.txt"),new Player("Kevin", 10));
			assertEquals(5,test.getNumCols());
		} catch (IOException e) {
			fail("File not found");
		}
	}

}
