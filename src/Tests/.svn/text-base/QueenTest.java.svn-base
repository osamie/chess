package Tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pack.*;
import junit.framework.TestCase;

public class QueenTest extends TestCase {
	private ChessBoard board;
	private ChessPiece q_w;
	private ChessPiece q_b;
	private ChessPiece p_w;
	private ChessPiece p_b;
	private ChessPiece r_w;
	private ChessPiece r_b;

	@Before
	public void setUp() throws Exception {
		board = new ChessBoard();
		q_w = new Queen(3,7,board,ChessBoard.WHITE);
		q_b = new Queen(4,0,board,ChessBoard.BLACK);
		p_w = new Pawn(4,6,board,ChessBoard.WHITE);
		p_b =  new Pawn(3,3,board,ChessBoard.BLACK);
		r_w = new Rook(4,3, board, ChessBoard.WHITE);
		r_b = new Rook(0,7, board, ChessBoard.BLACK);
		
	}

	@After
	public void tearDown() throws Exception {
		board = null;
		q_w = null;
		q_b = null;
		p_w = null;
		p_b =  null;
		r_w = null;
		r_b = null;
	}

	@Test
	public void testCanEatAt() {
		assertTrue(q_w.canEatAt(3,3)); // should be able to eat black pawn at (3,3)
		assertTrue(q_w.canEatAt(0,7)); // should be able to eat black rook at (0,7)
		assertTrue(q_b.canEatAt(4,3)); // should be able to eat white rook at (4,3)
		assertFalse(q_b.canEatAt(4,6)); // cannot jump over the piece at (4,3) to eat another piece at (4,6)
	}

}
