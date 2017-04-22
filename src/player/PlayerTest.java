package player;
import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void getterTest() {
		try{
			Player P = new Player("jupri",50);
			assertEquals("jupri",P.getName());
			assertEquals(50,P.getMaxHp());
			assertEquals(50,P.getHp());
			assertEquals(1,P.getlevel());
			assertEquals(10,P.getMaxExp());
			assertEquals(0,P.getExp());
		}
		catch(IOException E){
			
		}
	}
	
	@Test
	public void setterTest(){
		try{
		Player P = new Player("jupri",100);
			P.setHp(50);
			assertEquals(50,P.getHp());
			P.incHp(25);
			assertEquals(75,P.getHp());
			P.incHp(-50);
			assertEquals(25,P.getHp());
			P.incHp(300);
			assertEquals(100,P.getHp());
			P.incHp(-1000);
			assertEquals(0,P.getHp());
			P.incExp(10);
			assertEquals(2,P.getlevel());
			assertEquals(0,P.getExp());
			assertEquals(110,P.getMaxHp());
			P.incExp(40);
			assertEquals(4,P.getlevel());
			assertEquals(5,P.getExp());
			assertEquals(133,P.getMaxHp());
		}
		catch(IOException E){
			
		}
	}

}
