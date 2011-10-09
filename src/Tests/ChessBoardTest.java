/**
 * 
 */
package Tests;

import static org.junit.Assert.*;
import pack.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



/**
 * 
 *
 */
public class ChessBoardTest extends TestCase {
	
	private ChessBoard board;
	//private ChessPiece p1_b;
	private ChessPiece p1_w;
	//private ChessPiece q_w;
	private ChessPiece k_b;
	private ChessPiece k_w;
	private ChessPiece r_w;
	private ChessPiece bs_w;
	private ChessPiece bs1_w;
	//private ChessPiece r1_w;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		board = new ChessBoard();
		//p1_w = new Pawn(7,4,board,ChessPiece.WHITE);
		bs_w = new Bishop(7,4,board,ChessPiece.WHITE);
		bs1_w = new Bishop(5,7,board,ChessPiece.WHITE);
		//p1_b = new Pawn(6,2,board,ChessPiece.BLACK);
		k_b = new King(7, 3, board,ChessPiece.BLACK);
		k_w = new King(7, 6, board,ChessPiece.WHITE);
		
		//q_w = new Queen(2,0,board,ChessPiece.WHITE);
		r_w = new Rook(0,2, board, ChessBoard.WHITE);
		//r1_w = new Rook(6,7, board, ChessBoard.WHITE);
	}

	
	/**
	 * Test method for {@link pack.ChessBoard#removePiece(int, int)}.
	 * This method tests the removePiece method to remove a piece at a given coordinate
	 */
	@Test
	public void testRemovePiece() {
		ChessPiece temp = new Knight(0,0,board,ChessBoard.BLACK); //adds Knight piece to board
		board.removePiece(0,0);
		assertFalse(board.getPieces().contains(temp)); // the board should no longer contain the knight piece
	}

	/**
	 * Test method for {@link pack.ChessBoard#addPiece(pack.ChessPiece)}.
	 * This method tests the AddPiece method to check if it actually adds a piece to the board. 
	 */
	@Test
	public void testAddPiece() {
		
		board.addPiece(k_b);
		assertTrue(board.getPieces().contains(k_b)); //board should contain the k_b piece 
	
		
	}

	

	/**
	 * Test method for {@link pack.ChessBoard#hasPieceAt(int, int)}.
	 * This method tests the method HasPieceAt(i,j) which returns true if there is piece at the given coordinate ot false if otherwise
	 */
	@Test
	public void testHasPieceAt() {
		assertTrue(board.hasPieceAt(7,4));
		assertTrue(board.hasPieceAt(5,7));
		assertTrue(board.hasPieceAt(7,3));
		assertTrue(board.hasPieceAt(7,6));
		
		k_w.move(7,5); //piece k_w has moved from (7,6) to (7,5)
		assertTrue(board.hasPieceAt(7,5)); //piece k_w now at (7,5)
		assertFalse(board.hasPieceAt(7,6)); // There is no piece at (7,6)
		
		
	}

	/**
	 * Test method for {@link pack.ChessBoard#getPieceAt(int, int)}.
	 * This method tests to find if there is a piece at a given coordinate (i,j) 
	 */
	@Test
	public void testGetPieceAt() {
		assertTrue(board.getPieceAt(7, 6).equals(k_w));
		k_w.move(6,5);
		assertTrue(board.getPieceAt(6,5).equals(k_w)); //k_w is in a new position
		
		assertTrue(board.getPieceAt(0,2).equals(r_w));
		r_w.move(0,7);
		assertTrue(board.getPieceAt(0,7).equals(r_w));
				
	}



	/**
	 * Test method for {@link pack.ChessBoard#isCheckMate()}.
	 * This method tests for a situation in which one player's king is threatened with capture (in check) and there is no way to meet that threat
	 */
	@Test
	public void testIsCheckMate() {
		
		board.print();
		k_w.move(7,5);
		bs1_w.move(4,6);
		
		assertTrue(board.isCheckMate());
		
	}

	/**
	 * Test method for {@link pack.ChessBoard#isStalemate(int)}.
	 * This method checks for a situation where the player whose turn it is to move is not in check but has no legal moves  
	 */
	@Test
	public void testIsStalemate_1() {
		//board.print();
			
		k_w.move(7, 5);
		assertTrue(board.isStalemate(ChessBoard.BLACK)); // stale mate on black king
		//board.print();
		
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		board = null;
		bs_w = null;
		bs1_w = null;
		k_b = null;
		k_w = null;
		r_w = null;
		
		
	}
	
	

}
