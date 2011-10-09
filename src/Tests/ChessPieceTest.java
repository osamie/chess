package Tests;

import static org.junit.Assert.*;
import pack.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
public class ChessPieceTest extends TestCase{
	/*private ChessBoard board;
	private ChessPiece q_w;
	private ChessPiece q_b;
	private ChessPiece p_w;
	private ChessPiece p_b;
	private ChessPiece r_w;
	private ChessPiece r_b;
	private ChessPiece k_w;
	private ChessPiece k_b;*/
	
	private ChessBoard board;
	//private ChessPiece p1_b;
	private ChessPiece p1;
	//private ChessPiece q_w;
	private ChessPiece k1;
	private ChessPiece K1;
	private ChessPiece r_w;
	private ChessPiece bs_w;
	private ChessPiece bs1_w;
	private Pawn p1_b;
	//private ChessPiece r1_w;
	private Queen q_w;
	private Rook r1_w;
	

	@Before
	public void setUp() throws Exception {
		board = new ChessBoard();
		p1 = new Pawn(7,4,board,ChessPiece.WHITE);
		bs_w = new Bishop(7,5,board,ChessPiece.WHITE);
		bs1_w = new Bishop(5,7,board,ChessPiece.WHITE);
		p1_b = new Pawn(6,2,board,ChessPiece.BLACK);
		k1 = new King(7, 3, board,ChessPiece.BLACK);
		K1 = new King(7, 6, board,ChessPiece.WHITE);
		
		q_w = new Queen(2,0,board,ChessPiece.WHITE);
		r_w = new Rook(0,2, board, ChessBoard.WHITE);
		r1_w = new Rook(6,7, board, ChessBoard.WHITE);
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetType() {
		assertTrue(bs_w.getType()== ChessBoard.WHITE);
		assertTrue(p1.getType()== ChessBoard.WHITE);
		assertTrue(p1_b.getType()== ChessBoard.BLACK);
		
	}

	@Test
	public void testGetX() {
		assertTrue(bs_w.getX()== 7);
		assertTrue(p1.getX()== 7);
		assertTrue(p1_b.getX()== 6);
	}

	@Test
	public void testGetY() {
		assertTrue(bs_w.getY()== 5);
		assertTrue(p1.getY()== 4);
		assertTrue(p1_b.getY()== 2);
	}

	@Test
	public void testSimulate() {
		assertFalse(bs_w.simulate(7,3));
	}

	@Test
	public void testMove() {
		q_w.move(4, 0);
		assertTrue(q_w.getX()== 4 && q_w.getY()== 0);
		p1_b.move(6, 3);
		assertFalse(p1_b.getX()== 6 && p1_b.getY()== 3);
		board.print();
		
	}

	@Test
	public void testCanEatAt() 
	{
		assertTrue(q_w.canEatAt(4,0));
		assertFalse(p1_b.canEatAt(7,2));
	}

	@Test
	public void testCanMoveTo() {
		assertTrue(p1_b.canMoveTo(6,3));
	}

	@Test
	public void testCanGoTo() {
		assertTrue(p1_b.canGoTo(6,3));
		assertFalse(p1_b.canGoTo(8,7));
	}

}
