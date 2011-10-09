package pack;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

// TODO: Auto-generated Javadoc
/**
 * The Class ChessPiece.
 * Abstract Class that models the chessPiece in a Chess Game
 */
public abstract class ChessPiece extends Observable implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The x and y coordinates of the piece. */
	protected int x;

	/** The x and y coordinates of the piece. */
	protected int y;

	/** The chess board. */
	protected ChessBoard chessBoard;

	/** The type of ChessPiece. */
	protected int type;
	
	/** The black first move. */
	protected boolean FirstMove = true;
	
	/** The white first move. */
	//private boolean whiteFirstMove = true;

	/** The WHITE. white piece */
	public static int WHITE = 1;

	/** The BLACK. black piece */
	public static int BLACK = 2;
	
	
	/**
	 * Instantiates a new chess piece.
	 * 
	 * @param x the x coordinates of the ChessPiece
	 * @param y the y coordinates of the ChessPiece
	 * @param board the board to be added to
	 * @param type the type of ChessPiece: White or Black
	 */
	public ChessPiece(int x, int y, ChessBoard board, int type) {
		if (board == null)
			throw new IllegalArgumentException();
		if ((x < 0) || (y < 0) || (x >= ChessBoard.SIZE)
				|| (y >= ChessBoard.SIZE))
			throw new IllegalArgumentException();
		chessBoard = board;
		this.x = x;
		this.y = y;
		this.type = type;
		
	}
	
	/**
	 * Returns the type of the ChessPiece.
	 * 
	 * @return 1 if ChessPiece is White , 2 if ChessPiece is Black
	 */
	public int getType() {
		return type;
	}

	/**
	 * Returns the X-coordinate of the ChessPiece.
	 * 
	 * @return X-coordinate if the ChessPiece
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the Y-coordinate of the ChessPiece.
	 * 
	 * @return Y-coordinate if the ChessPiece
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the type of ChessPiece.
	 * 
	 * @param type The type of Piece to be set to
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * Sets the X-coordinate of ChessPiece.
	 * 
	 * @param x The x-coordinate to be set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Sets the Y-coordinate of ChessPiece.
	 * 
	 * @param y The y-coordinate to be set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	public ArrayList<Point> legalMoves()
	{
		ArrayList<Point> intArr = new ArrayList<Point>();
		for (int j = 0; j < ChessBoard.SIZE; j++) {
			for (int i = 0; i < ChessBoard.SIZE; i++) {
    		if ((this.canMoveTo(i, j)||canEatAt(i,j)) && !this.checkSim(i, j))
    		{
    		Point p = new Point(i,j);
    		intArr.add(p);
    		}
    	}
    	}
		return intArr;
	}
	
	public boolean hasLegalMove()
	{
		if (this.legalMoves().isEmpty())
		{
			return false;
		}
		return true;
	}
	/**
	 * Simulates a scenario of the King's situation if a move is made.
	 * 
	 * @param i the x coordinate of the position to be checked
	 * @param j the y coordinate of the position to be checked
	 * 
	 * @return true, if simulate
	 */
	public boolean simulate(int i, int j) {
		int oldX = this.getX();
		int oldY = this.getY();
		this.setX(i);
		this.setY(j);
		if (this.getType() == 1) {
			boolean hold = chessBoard.whiteKing().isUnderCheck();
			this.setX(oldX);
			this.setY(oldY);
			return hold;
		} else if (this.getType() == 2) {
			boolean hold = chessBoard.blackKing().isUnderCheck();
			this.setX(oldX);
			this.setY(oldY);
			return hold;
		}
		return false;
	}

	/**
	 * Simulates if moving a piece to a particular location results 
	 * in the king being on check
	 * 
	 * @param i the x coordinate of the position to be checked
	 * @param j the y coordinate of the position to be checked
	 * 
	 * @return true, if successful
	 */
	public boolean checkSim(int i, int j) {
		if (chessBoard.hasPieceAt(i, j)) {
			ChessPiece temp = chessBoard.getPieceAt(i, j);
			chessBoard.removePiece(i, j);
			boolean hold = this.simulate(i, j);
			chessBoard.addPiece(temp);
			return hold;
		}
		return this.simulate(i, j);

	}

	/**
	 * Helper method for checker
	 * 
	 * @param i the x coordinate of the position to be checked
	 * @param j the y coordinate of the position to be checked
	 */
	public void movePieceTo(int i, int j) {
		this.setX(i);
		this.setY(j);
		if (chessBoard.blackKing().isUnderCheck()) {
			chessBoard.onCheckBlack = true;
			this.setChanged();
			this.notifyObservers("OnCheck");
			this.clearChanged();
		} else {
			chessBoard.onCheckBlack = false;
		}
		if (chessBoard.whiteKing().isUnderCheck()) {
			chessBoard.onCheckWhite = true;
			this.setChanged();
			 this.notifyObservers("OnCheck");
			 this.clearChanged();
		} else {
			chessBoard.onCheckWhite = false;
		}
		chessBoard.legalMove = true;
	}
	

	/**
	 * Castling.
	 * 
	 * @param i the x coordinate of the position to be checked
	 * @param j the y coordinate of the position to be checked
	 * 
	 * @return true, if successful
	 */
	public boolean castling(int i, int j){
		if (this instanceof King && (i==this.getX()+2) && canEatAt(i,j) && (chessBoard.getPieceAt(i+1, j)instanceof Rook)){
			Rook r = (Rook) chessBoard.getPieceAt(i+1, j);
			King k = (King) this;
			k.setX(i);
			r.setX(i-1);
			r.FirstMove = false;
			k.FirstMove = false;
			k.setCastled(true);
			return true;
			
		}
		else if (this instanceof King && (i==this.getX()-2) && canEatAt(i,j) && (chessBoard.getPieceAt(i-2, j)instanceof Rook)){
			Rook r = (Rook) chessBoard.getPieceAt(i-2, j);
			King k = (King) this;
			k.setX(i);
			r.setX(i + 1);
			r.FirstMove = false;
			k.FirstMove = false;
			k.setCastled(true);
			return true;
		}
		return false;
	}

	/**
	 * Move the ChessPiece to a particular square on the board.
	 * 
	 * @param i the x-coordinates of the square the piece is to be moved to.
	 * @param j the y-coordinates of the square the piece is to be moved to
	 */
	public void move(int i, int j) {
			
		if (!this.castling(i, j))
		{
			moveHelper(i,j);
			this.FirstMove = false;
		}
	
	}
	public void moveHelper(int i , int j)
	{
		if (canEatAt(i, j)) {
			if (chessBoard.hasPieceAt(i, j)) {
				if (this.checkSim(i, j) == false) {
					chessBoard.removePiece(i, j);
					movePieceTo(i, j);
				} else {
					this.setChanged();
					this.notifyObservers("Check");
					this.clearChanged();
					chessBoard.legalMove = false;
					if (this.checkSim(i, j) == false)
					{
						chessBoard.removePiece(i, j); 
						movePieceTo(i,j);
					}
					else
					{
						this.setChanged();
						this.notifyObservers("Check");
						this.clearChanged();
						chessBoard.legalMove = false;
					}
				}
			} else {
				if (this.checkSim(i, j) == false) {
					movePieceTo(i, j);
				} else {	
					this.setChanged();
					this.notifyObservers("Check");
					this.clearChanged();
					chessBoard.legalMove = false;
				}
			}
		} else {
			this.setChanged();
			this.notifyObservers("Invalid");
			this.clearChanged();
			chessBoard.legalMove = false;
		}
	}

	
	/**
	 * Determines if a piece can take another piece at a given location (i,j). This also implies
	 * that the piece can move to the position (i,j) except in the case of a pawn.
	 * 
	 * @param i the x coordinate of the position to be checked
	 * @param j the y coordinate of the position to be checked
	 * 
	 * @return true, if the piece can take another piece at (i,j) 
	 */
	public abstract boolean canEatAt(int i, int j);

	/**
	 * Returns the result of canEatAt(i, j). Except for pawn.
	 * 
	 * @param i the x coordinate of the position to be checked
	 * @param j the y coordinate of the position to be checked
	 * 
	 * @return  result of canEatAt(i, j);
	 */
	public boolean canMoveTo(int i, int j) {
		return canEatAt(i, j);
	} 
	
	
	/**
	 * Determines if a set of coordinates are within the boundaries of the
	 * board.
	 * 
	 * @param i The x-coordinate to be checked
	 * @param j The y-coordinate to be checked
	 * 
	 * @return true if the coordinates are within the board, false if otherwise
	 */
	public boolean canGoTo(int i, int j) {
		boolean b = ((i >= 0) && (j >= 0) && (i < ChessBoard.SIZE) && (j < ChessBoard.SIZE));
		//if (!b){System.out.println("Location is off the board!");}
		return b;
	}

}
