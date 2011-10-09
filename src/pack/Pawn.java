package pack;

import java.awt.Point;
import java.util.ArrayList;


/**
 * The Class Pawn.
 * Models the knight pawn in a Chess Game
 */
public class Pawn extends ChessPiece {
  boolean tookJump = false;
  /**
   * Instantiates a new pawn.
   * 
   * @param x the x coordinate of the new pawn
   * @param y the y coordinate of the new pawn
   * @param board the board the pawn will be placed on
   * @param type white or black piece
   */
	
  public Pawn(int x, int y, ChessBoard board, int type) {
		super(x, y, board, type);
		board.addPiece(this); 
		}
  

	/**
	 *Handles the promotion of a Pawn after it reaches an end square.
	 *
	 */
	public void promote() {
		if ((this.type == WHITE && this.y == 0)
				|| (this.type == BLACK && this.y == 7)) 
		{
			this.setChanged();
			this.notifyObservers("Promote");
			this.clearChanged();

		}
	}
	
	public ArrayList<Point> legalMoves()
	{
		ArrayList<Point> intArr = new ArrayList<Point>();
		for (int j = 0; j < ChessBoard.SIZE; j++) {
			for (int i = 0; i < ChessBoard.SIZE; i++) {
    		if ((this.canMoveTo(i, j)||canEatAt(i,j)||empassant(i,j)) && !this.checkSim(i, j))
    		{
    		Point p = new Point(i,j);
    		intArr.add(p);
    		}
    	}
    	}
		return intArr;
	}
  /**
   *  (non-Javadoc)
   * @see ChessPiece#move(int, int)
   */
  @Override
  public void move(int i, int j) {
	  int holdx = this.x;
	  int holdy = this.y;
	  if (canGoTo(i, j)){
			if (canMoveTo(i, j))
			{
				if (this.checkSim(i, j) == false)
				{
					movePieceTo(i,j);
					if((j == holdy + 2) || (j == holdy - 2))
					{
					tookJump = true;	
					}
					promote();
				}
				else
				{
					this.setChanged();
					this.notifyObservers("Check");
					this.clearChanged();
					chessBoard.legalMove = false;
				
				}
			}
			else if (canEatAt(i,j))
			{
				if (this.checkSim(i, j) == false)
				{
					chessBoard.removePiece(i, j);
					movePieceTo(i,j);
					promote();
				}
				else
				{
					this.setChanged();
					this.notifyObservers("Check");
					this.clearChanged();
					chessBoard.legalMove = false;
				}
			}
			else if (empassant(i,j))
			{
				if (this.checkSim(i, j) == false)
				{
					if (this.type == WHITE)
					{
					chessBoard.removePiece(i, j+1);
					}
					else if (this.type == BLACK)
					{
					chessBoard.removePiece(i, j-1);
					}
					movePieceTo(i,j);
					promote();
				}
				else
				{
					this.setChanged();
					this.notifyObservers("Check");
					this.clearChanged();
					chessBoard.legalMove = false;
				}
			}
		else{this.setChanged();
		this.notifyObservers("Invalid");
		this.clearChanged();
		chessBoard.legalMove = false;}
	  }
  }

  public boolean canMoveTo(int i,int j){
	  if (canGoTo(i, j)) {
			if (this.type == WHITE) {
				if (!(chessBoard.hasPieceAt(i, j)) && !(chessBoard.hasPieceAt(i, j+1)) && j == y - 2 && y == 6 && x == i){
					return true;
				}
				else if (!(chessBoard.hasPieceAt(i, j)) && j == y - 1 && x == i)
				{
					return true;
				}
			}
			else if (this.type == BLACK) {
				if (!(chessBoard.hasPieceAt(i, j)) && !(chessBoard.hasPieceAt(i, j-1)) && j == y + 2 && y == 1 && x == i){
					return true;
				}
				else if (!(chessBoard.hasPieceAt(i, j)) && j == y + 1 && x == i)
				{
					return true;
				}
			}
	  }
	return false;
  }
public boolean empassant(int i,int j)
{
	if (this.type == WHITE)
	{
		if (chessBoard.hasPieceAt(i, j+1) && (j == y - 1) && (i == x + 1 || i == x - 1) && (y==3))
		{
			if(chessBoard.getPieceAt(i, j+1) instanceof Pawn && chessBoard.getPieceAt(i, j+1).getType() == BLACK)
			{
				Pawn p = (Pawn) chessBoard.getPieceAt(i, j+1);
				if (p.tookJump){return true;}
			}
					
		}
	}
	else if (this.type == BLACK)
	{
		if (chessBoard.hasPieceAt(i, j-1) && (j == y + 1) && (i == x + 1 || i == x - 1) && (y==4))
		{
			if(chessBoard.getPieceAt(i, j-1) instanceof Pawn && chessBoard.getPieceAt(i, j-1).getType() == WHITE)
			{
				Pawn p = (Pawn) chessBoard.getPieceAt(i, j-1);
				if (p.tookJump){return true;}
			}
					
		}
	}
	return false;
}
@Override
	public boolean canEatAt(int i, int j) {
		if (canGoTo(i, j)) {
			if (this.type == WHITE) {
				if ((j == y - 1) && (i == x + 1 || i == x - 1)) {
					if (chessBoard.hasPieceAt(i, j)) {
						if (!(chessBoard.getPieceAt(i, j).getType() == this.type)) {
							return true;
						}
					}
				}
			} else if (this.type == BLACK) {
				if ((j == y + 1) && (i == x + 1 || i == x - 1)) {
					if (chessBoard.hasPieceAt(i, j)) {
						if (!(chessBoard.getPieceAt(i, j).getType() == this.type)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
