package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pack.ChessBoard;
import pack.SetupEightQueens;
import pack.Queen;
import junit.framework.TestCase;
public class EightQueensTest extends TestCase{
	SetupEightQueens e;
	
	@Before
	public void setUp() throws Exception {
		e = new SetupEightQueens();
	}

	@After
	public void tearDown() throws Exception {
		e = null;
	}

	@Test
	public void testIsGameOver() {
		Queen q1 = new Queen(0,0,e.getBoard(),1);//Fist Queen at 0,0
		assertFalse(e.isGameOver());  //Game Should not be over
		
		Queen q2 = new Queen(5,1,e.getBoard(),2);  //Second Queen at 5,1
		assertFalse(e.isGameOver());   //Still Not Over
		
		Queen q3 = new Queen(7,2,e.getBoard(),3);//Third Queen at 7,2
		assertFalse(e.isGameOver()); // Still Not Over
		
		Queen q4 = new Queen(1,1,e.getBoard(),3);// Fourth Queen at 1,1 threatens with 0,0
		assertTrue(e.isGameOver());// Game is over
		
		
		
	}

}
