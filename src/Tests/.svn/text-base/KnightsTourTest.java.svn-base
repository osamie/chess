package Tests;

import static org.junit.Assert.*;
import junit.framework.TestCase;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pack.ChessBoard;
import pack.Knight;
import pack.SetupKnightsTour;

public class KnightsTourTest extends TestCase{
	SetupKnightsTour k;
	
	@Before
	public void setUp() throws Exception {
		k = new SetupKnightsTour();
		}

	@After
	public void tearDown() throws Exception {
		k = null;
	}

	@Test
	public void testGameLost() {
		k.getBoard().setVistited(0, 0, 1);//Assume the knight is on 0,0
		//Sets the only two squares the knight can me to to visited, trapping it
		k.getBoard().setVistited(2, 1, 1);
		k.getBoard().setVistited(1, 2, 1);
		assertTrue(k.gameLost());//Game should be over
	}

	@Test
	public void testGameWon() {
		//Set all the squares to visited
		for (int i = 0; i < ChessBoard.SIZE; i++) {
			for (int j = 0; j < ChessBoard.SIZE; j++) {
				k.getBoard().setVistited(i, j, 1);
			}
	}
		assertTrue(k.gameWon());// Game should be done.

}
}
