package Tests;

import junit.framework.TestCase;
import pack.*;



/**
 * 
 */

public class PawnTest extends TestCase {
	private ChessBoard board;
	private ChessPiece p1_w;
	private ChessPiece p1_b;
	private ChessPiece p2_w;
	private ChessPiece k_w;
	private ChessPiece k_b;
	private ChessPiece r_b;
	//private ChessPiece bs_w;
	

	
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		//super.setUp();
		board = new ChessBoard();
		k_w = new King(4, 7, board,ChessPiece.WHITE);
		k_b = new King(6, 0, board,ChessPiece.BLACK);
		p1_b = new Pawn(0,0,board,ChessPiece.BLACK); 
		p1_w = new Pawn(1,6,board,ChessPiece.WHITE);
		p2_w = new Pawn(1,1,board,ChessPiece.WHITE);
		r_b = new Rook(3,3,board,ChessPiece.BLACK);
		//bs_w = new Bishop(0,3,board,ChessPiece.WHITE);
		
		
	}

	
	/**
	 * Test method for {@link Pawn#move(int, int)}.
	 */
	public void testMove() {
		//Testing black piece		
		
		board.print();
		p1_b.move(0,1); // testing first jump move
		assertTrue(p1_b.getX()==0 && p1_b.getY()==1);
		//board.print();
		
		
		p1_b.move(0,2); // testing first jump move
		assertTrue(p1_b.getX() == 0 && p1_b.getY() == 2);
		board.print();
		
		
		p1_b.move(0,3); 
		assertTrue(p1_b.getX()== 0 && p1_b.getY() == 3); 
		
		
		//Testing white piece
		
		p1_w.move(1,5);
		assertTrue(p1_w.getX() == 1 && p1_w.getY() == 5);
		
		
		p1_w.move(1,4);
		assertTrue(p1_w.getX() == 1 && p1_w.getY() == 4);
		
		p1_w.move(0,3);
		assertTrue(p1_w.getX() == 0 && p1_w.getY() == 3); // can eat opponent's piece diagonally
		
		
		p1_w.move(1,4);
		assertFalse(p1_w.getX() == 1 && p1_w.getY()==4); //cannot move diagonally unless there is an opponent's piece
		
	}
	

	/**
	 * Test method for {@link Pawn#canEatAt(int, int)}.
	 */
	public void testCanEatAt() {
		board.print();
		assertFalse(p1_b.canEatAt(1,0)); // cannot eat horizontally
		assertTrue(p1_b.canEatAt(1,1));//can eat piece of another type diagonally
		
		
		assertFalse(p1_w.canEatAt(2,7)); // cannot eat backwards
		
		
		
	}

		



		
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		board = null;
		k_w = null;
		k_b = null;
		p1_b = null; 
		p1_w = null;
		p2_w = null;
		r_b = null;
	}

}
