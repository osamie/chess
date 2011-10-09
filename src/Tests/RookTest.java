/**
 * 
 */
package Tests;

import static org.junit.Assert.*; 
import junit.framework.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pack.*;



public class RookTest extends TestCase{

	private ChessBoard board;
	private ChessPiece p_b;
	private ChessPiece p_w;
	private ChessPiece k_w;
	private ChessPiece k_b;
	private ChessPiece r_w;
	private ChessPiece r_b;
	private ChessPiece p2_b;
	private ChessPiece p2_w;
	
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		board = new ChessBoard();
		
		k_b = new King(6, 0, board,ChessPiece.BLACK);
		p_b = new Pawn(0,0,board,ChessPiece.BLACK); 
		p2_b = new Pawn(5,7,board,ChessPiece.BLACK);
		r_b = new Rook(1,0,board,ChessPiece.BLACK);
		
		
		p_w = new Pawn(1,6,board,ChessPiece.WHITE);
		r_w = new Rook(0,6,board,ChessPiece.WHITE);
		k_w = new King(4, 7, board,ChessPiece.WHITE);
		p2_w = new Pawn(5,0,board,ChessPiece.WHITE);
			
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link pack.Rook#canEatAt(int, int)}.
	 */
	@Test
	public void testMove() {
		r_b.move(1, 2);
		assertTrue(r_b.getX() == 1 && r_b.getY() == 2);
		
		r_b.move(1,4);
		assertTrue(r_b.getX() == 1 && r_b.getY() == 4);
		
		r_b.move(1,0);
		assertTrue(r_b.getX() == 1 && r_b.getY()== 0);
		
		r_b.move(0, 1);
		assertFalse(r_b.getX() == 0 && r_b.getY() == 1); // rooks cannot move diagonally
		
	}
	
	/**
	 * Test method for {@link pack.Rook#canEatAt(int, int)}.
	 */
	@Test
	public void testEat()
	{
		r_b.move(0,0);
		assertFalse(r_b.getX() == 0 && r_b.getY() == 0); // cannot eat same type of piece,p_b
		board.print();
		
		r_b.move(1,6);
		assertTrue(r_b.getX() == 1 && r_b.getY() == 6); // Eats white piece, p_w
		board.print();
		
		r_w.move(1, 6);
		assertTrue(r_w.getX() == 1 && r_w.getY() == 6); // should pass since white rook can eat black rook in its direction
		board.print();
		
		r_w.move(0, 6);
		assertTrue(r_w.getX() == 0 && r_w.getY() == 6); 
		board.print();
		
		r_w.move(0, 0);
		assertTrue(r_w.getX() == 0 && r_w.getY() == 0); // should pass since white rook can eat black pawn in its direction
		board.print();
		
	}
	
	/**
	 * Test method for {@link pack.Rook#canEatAt(int, int)}.
	 */
	@Test
	public void Test_canEatAt()
	{
		assertTrue(r_b.canEatAt(1,6)); // should be able to eat white piece at (1,6)
		assertTrue(r_w.canEatAt(0,0));// should be able to eat black pawn at (0,0)
		assertTrue(k_w.canEatAt(5,7));// should be able to eat black piece at (5,7)
		assertTrue(k_b.canEatAt(5,0));// should be able to eat black piece at (5,0)
		
	}

}
