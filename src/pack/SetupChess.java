package pack;
import java.awt.Point;
import java.util.Stack;


/**
 * 
 * The Class ChessGame.
 */

@SuppressWarnings("unused")
public class SetupChess extends GameSetup {
  public ChessPiece getC1() {
		return c1;
	}

	public void setC1(ChessPiece c1) {
		this.c1 = c1;
	}

/**
   * Instantiates a new chess game.
   */
	Player p1 = new Player("Tobi",c,1);
	Player p2 = new Player("Nat",c,2);
	Point a = new Point(3,7);
	Point b = new Point(5,5);
	ChessPiece c1;
	
  public SetupChess() {
		
		
		//Constructing player one's pieces
		Pawn p1 = new Pawn(ChessBoard.SIZE - 1, ChessBoard.SIZE - 2, c, 1);
		Pawn p2 = new Pawn(ChessBoard.SIZE - 2, ChessBoard.SIZE - 2, c, 1);
		Pawn p3 = new Pawn(ChessBoard.SIZE - 3, ChessBoard.SIZE - 2, c, 1);
		Pawn p4 = new Pawn(ChessBoard.SIZE - 4, ChessBoard.SIZE - 2, c, 1);
		Pawn p5 = new Pawn(ChessBoard.SIZE - 5, ChessBoard.SIZE - 2, c, 1);
		Pawn p6 = new Pawn(ChessBoard.SIZE - 6, ChessBoard.SIZE - 2, c, 1);
		Pawn p7 = new Pawn(ChessBoard.SIZE - 7, ChessBoard.SIZE - 2, c, 1);
		Pawn p8 = new Pawn(ChessBoard.SIZE - 8, ChessBoard.SIZE - 2, c, 1);
		Rook r1 = new Rook(ChessBoard.SIZE - 8, ChessBoard.SIZE - 1, c, 1);
		Rook r2 = new Rook(ChessBoard.SIZE - 1, ChessBoard.SIZE - 1, c, 1);
		Queen q1 = new Queen(ChessBoard.SIZE - 5, ChessBoard.SIZE - 1, c, 1);
		King k1 = new King(ChessBoard.SIZE - 4, ChessBoard.SIZE - 1, c, 1);
		Bishop b1 = new Bishop(ChessBoard.SIZE - 3, ChessBoard.SIZE - 1, c, 1);
		Bishop b2 = new Bishop(ChessBoard.SIZE - 6, ChessBoard.SIZE - 1, c, 1);
		Knight t1 = new Knight(ChessBoard.SIZE - 2, ChessBoard.SIZE - 1, c, 1);
		Knight t2 = new Knight(ChessBoard.SIZE - 7, ChessBoard.SIZE - 1, c, 1);
		
		
		//Constructing player two's pieces
		Pawn p9 = new Pawn(ChessBoard.SIZE - 7, ChessBoard.SIZE - 7, c, 2);
		Pawn p10 = new Pawn(ChessBoard.SIZE - 8, ChessBoard.SIZE - 7, c, 2);
		Pawn p11 = new Pawn(ChessBoard.SIZE - 6, ChessBoard.SIZE - 7, c, 2);
		Pawn p12 = new Pawn(ChessBoard.SIZE - 5, ChessBoard.SIZE - 7, c, 2);
		Pawn p13 = new Pawn(ChessBoard.SIZE - 4, ChessBoard.SIZE - 7, c, 2);
		Pawn p14 = new Pawn(ChessBoard.SIZE - 3, ChessBoard.SIZE - 7, c, 2);
		Pawn p15 = new Pawn(ChessBoard.SIZE - 2, ChessBoard.SIZE - 7, c, 2);
		Pawn p16 = new Pawn(ChessBoard.SIZE - 1, ChessBoard.SIZE - 7, c, 2);
		Rook r3 = new Rook(ChessBoard.SIZE - 8, ChessBoard.SIZE - 8, c, 2);
		Rook r4 = new Rook(ChessBoard.SIZE - 1, ChessBoard.SIZE - 8, c, 2);
		Queen q2 = new Queen(ChessBoard.SIZE - 5, ChessBoard.SIZE - 8, c, 2);
		King k2 = new King(ChessBoard.SIZE - 4, ChessBoard.SIZE - 8, c, 2);
		Bishop b3 = new Bishop(ChessBoard.SIZE - 3, ChessBoard.SIZE - 8, c, 2);
		Bishop b4 = new Bishop(ChessBoard.SIZE - 6, ChessBoard.SIZE - 8, c, 2);
		Knight t3 = new Knight(ChessBoard.SIZE - 2, ChessBoard.SIZE - 8, c, 2);
		Knight t4 = new Knight(ChessBoard.SIZE - 7, ChessBoard.SIZE - 8, c, 2);
				
  }
 
/**
   * Play.
   */
  public void play() {
	  c.print();
	  while(true)
	  {
		  c.legalMove = false;
		  
		  while ((!c.legalMove) && (!c.isCheckMate()) && !(c.isStalemate(ChessBoard.WHITE))){
			  p1.play();
			  c.print();
		  }
		  c.legalMove = false;
		  
		  while (!c.legalMove && (!c.isCheckMate())&& !(c.isStalemate(ChessBoard.BLACK))){
			  p2.play();
			  if (!c.legalMove){System.out.println("Illegal Move");}
			  c.print();
		  } 
		  if (c.isCheckMate())
		  {
			  System.out.println("CHECKMATE!");
			  break;
		  }
		  else if (c.isStalemate(ChessBoard.BLACK) || c.isStalemate(ChessBoard.WHITE))
		  {
			  System.out.println("DRAW: STALEMATE!");
			  break;
		  }
	  }
  }

}
