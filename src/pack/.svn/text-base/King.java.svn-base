package pack;
import java.awt.Point;
// TODO: Auto-generated Javadoc

/**
 * The Class King.
 * Models the king piece in a Chess Game
 */

public class King extends ChessPiece {
	boolean castled = false;
  /**
   * Instantiates a new king.
   * 
   * @param x the x-coordinates
   * @param y the y-coordinates
   * @param chessBoard the chess board
   * @param type the type, white or black
   */
  public King(int x, int y, ChessBoard chessBoard, int type) {
		super(x, y, chessBoard, type);
		chessBoard.addPiece(this);
  }

  
  public boolean isCastled() {
	return castled;
}


public void setCastled(boolean castled) {
	this.castled = castled;
}


/**
   * Checks if the king is currently under check.
   * 
   * @return true, if is under check
   */
  public boolean isUnderCheck()
  {
	  for (ChessPiece p: chessBoard.getPieces())
	  {
		  if (p.canEatAt(x, y))
		  {
			  
			  return true;
			  
		  }
	  }
	return false;
  }
  
  /**
   * Checks a set of x,y coordinates and determines if the king will be on check by
   * moving there
   * 
   * @param i the x coordinate to be checked
   * @param j the y coordinate to checked
   * 
   * @return true, if the king will be on check.
   */
  public boolean willCheck(int i,int j)
  {
	  for (ChessPiece p: chessBoard.getPieces())
	  {
		  if (p.canEatAt(i, j) && p.getType()!= this.type)
		  {
			  return true;
		  }
	  }
	return false;
  }
   
  
	/* (non-Javadoc)
	 * @see pack.ChessPiece#canEatAt(int, int)
	 */
  @Override
	public Object clone() {
		King b = new King(x,y,chessBoard,type);
		return b;
	}
	@Override
	public boolean canEatAt(int i, int j) {
		Point from = new Point(this.getX(), this.getY());
		Point to = new Point(i, j);
		if (canGoTo(i, j) && chessBoard.isInVicinity(from, to)) {
			if (chessBoard.hasPieceAt(i, j)) {
				ChessPiece c = chessBoard.getPieceAt(i, j);
				if (c.getType() == this.type) {
					return false;
				} else {
					return true;
				}
			} else {
				return true;
			}
		}
		else if(canGoTo(i,j) && (i == x+2) && chessBoard.getPieceAt(x+3, j) instanceof Rook)
		{
			Point king = new Point(this.getX(), this.getY());
			Point rook = new Point(x+3, j);
			Rook r = (Rook) chessBoard.getPieceAt(x+3, j);
			if(r.getType() != this.type || isUnderCheck()|| chessBoard.hasHor(king,rook)||!this.FirstMove||!r.FirstMove)
			{
				return false;
			}
			return true;
		}
		else if(canGoTo(i,j) && (i == x-2) && chessBoard.getPieceAt(x-4, j) instanceof Rook)
		{
			Point king = new Point(this.getX(), this.getY());
			Point rook = new Point(i-2, j);
			Rook r = (Rook) chessBoard.getPieceAt(i-2, j);
			if(r.getType() != this.type ||isUnderCheck()|| chessBoard.hasHor(king,rook)||!this.FirstMove||!r.FirstMove)
			{
				return false;
			}
			return true;
		}

		return false;
	}

}
