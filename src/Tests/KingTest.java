package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pack.*;
import junit.framework.TestCase;
public class KingTest extends TestCase{
	ChessBoard c;
	King k_w ;
	King k_b ;
	Rook r_b;
	Rook r_w;
	Queen q_b;
	
	@Before
	public void setUp() throws Exception {
		c = new ChessBoard();
		k_w = new King(4,7,c,1);
		k_b = new King(4,0,c,2);
		r_b = new Rook(0, 7, c, 2);
		q_b = new Queen(3, 0, c, 2);
		r_w = new Rook(3, 7, c, 1);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanEatAt() {
		assertTrue (k_w.canEatAt(5,7));//Should be able to eat here
		assertTrue (k_w.canEatAt(4,6));//Should be able to eat here
		assertTrue (k_w.canEatAt(5,6));//Should be able to eat here
		assertFalse (k_w.canEatAt(3,7));//Should not be eat to move as it contains its piece
		assertTrue (k_w.canEatAt(3,6));//Should be able to eat here
	}

	@Test
	public void testIsUnderCheck() {
		q_b.move(3,7);//Move the queen to check the king
		assertTrue(k_w.isUnderCheck());//King should be under check
	}

	@Test
	public void testWillCheck() {
		q_b.move(3,6);//Move the queen to check the king
		k_w.move(5, 7);//King escapes the check
		assertTrue(k_w.willCheck(4,6));//If king moves here he should be under check
		assertTrue(k_w.willCheck(5,6));//If king moves here he should be under check
	}

}
