package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pack.*;
import junit.framework.TestCase;

public class BishopTest extends TestCase {
	ChessBoard c = new ChessBoard();
	Bishop b1 = new Bishop(0,0,c,2);
	Pawn p1 = new Pawn(2,3,c,1);
	King k2 = new King(4,7,c,1);
	King k1 = new King(3,1,c,2);
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanEatAt() {
		p1.move(2,2);
		//c.print();
		assertFalse(b1.canEatAt(3, 1));
		assertFalse(b1.canEatAt(1, 0));
		assertFalse(b1.canEatAt(0, 1));
		assertTrue(b1.canEatAt(p1.getX(), p1.getY()));
		assertTrue(b1.canEatAt(1,1));
		
	}
	@Test
	public void testMove() {
		p1.move(2,2);
		b1.move(1, 1);
		assertTrue(b1.getX()==0 && b1.getY()==0);
		b1.move(2,2);
		assertTrue(b1.getX()==2 && b1.getY()==2);
		
	}

}
