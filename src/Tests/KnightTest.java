package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import pack.*;
import junit.framework.TestCase;
public class KnightTest extends TestCase {
	ChessBoard c = new ChessBoard();
	Knight n1 = new Knight(1,0,c,2);
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
		c.print();
		assertFalse(n1.canEatAt(3, 1));
		assertTrue(n1.canEatAt(p1.getX(), p1.getY()));
		assertTrue(n1.canEatAt(0,2));
	}
	@Test
	public void testMove() {
		p1.move(2,2);
		n1.move(3, 1);
		assertTrue(n1.getX()==1 && n1.getY()==0);
		n1.move(2,2);
		assertTrue(n1.getX()==2 && n1.getY()==2);
		
	}
	

}
