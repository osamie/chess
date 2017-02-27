package pack;

/**
 * 
 * The Class ChessBoard.
 * 
 */
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The Class ChessBoard. Models a ChessBoard using an underlying structure of
 * and 8x8 2D Array
 */
public class ChessBoard  extends Observable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The Size of the board for the game. */
	public static int SIZE = 8;

	/** The WHITE Pieces. */
	public static int WHITE = 1;

	/** The BLACK Pieces. */
	public static int BLACK = 2;

	/** A 2d array representing the ChessbBard. */
	private int[][] grid;

	/** The on check black. */
	public boolean onCheckBlack = false;

	/** The on check white. */
	public boolean onCheckWhite = false;

	/** The legal move. */
	public boolean legalMove = false;

	/** The check mate. */
	public boolean checkMate = false;

	/** An ArrayList of pieces contained on the ChessBoard. */
	public CopyOnWriteArrayList<ChessPiece> pieces;
	
	private int turn;
	
	private int KnightX, KnightY;
	
	
	/**
	 * Default constructor for ChessBoard Creates a new 8x8 grid to represent
	 * the board. Creates a new ArrayList of ChessPieces the board contains.
	 */
	public ChessBoard() {
		grid = new int[SIZE][SIZE];
		pieces = new CopyOnWriteArrayList<ChessPiece>();
	}

	/**
	 * Returns the ArrayList containing the pieces currently on the board.
	 * 
	 * @return ArrayList of Chess Pieces
	 */
	public CopyOnWriteArrayList<ChessPiece> getPieces() {
		return pieces;
	}
	
	public void setPieces(CopyOnWriteArrayList<ChessPiece> pieces) {
		this.pieces = pieces;
	}

	/**
	 * Removes the piece.
	 * 
	 * @param i
	 *            the i
	 * @param j
	 *            the j
	 */
	public void removePiece(int i, int j) {
		if (getPieceAt(i, j) == null) {
			throw new NullPointerException();
		}
		ChessPiece c = getPieceAt(i, j);
		pieces.remove(c);
	}

	/**
	 * Adds a ChessPiece to the ArrayList of pieces on the board.
	 * 
	 * @param c
	 *            the ChessPiece to be added
	 */
	public void addPiece(ChessPiece c) {
		if (c == null) {
			throw new NullPointerException();
		}
		pieces.add(c);

	}

	/**
	 * Checks if a square has been visited
	 * 
	 * @param i
	 *            the i
	 * @param j
	 *            the j
	 * 
	 * @return true, if successful
	 */
	public boolean hasBeenVisited(int i, int j) {
		if (grid[i][j] == 1) {
			return true;
		}
		return false;
	}

	/**
	 * Sets the sets a square to a visited value.
	 * 
	 * @param i
	 *            the i
	 * @param j
	 *            the j
	 * @param x
	 *            the x
	 */
	public void setVistited(int i, int j, int x) {
		grid[i][j] = x;
	}

	/**
	 * Determines if a ChessPiece is in place at the given coordinates.
	 * 
	 * @param i
	 *            the x-coordinates of the piece
	 * @param j
	 *            the y-coordinates of the piece
	 * 
	 * @return true if a piece is in place, false if otherwise
	 */
	public boolean hasPieceAt(int i, int j) {
		for (ChessPiece p : pieces) {
			if ((p.getX() == i) && (p.getY() == j)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the ChessPiece at the given coordinates.
	 * 
	 * @param i
	 *            the x-coordinate of the ChessPiece
	 * @param j
	 *            the y-coordinate of the ChessPiece
	 * 
	 * @return ChessPiece with coordinates (X,Y)
	 */
	public ChessPiece getPieceAt(int i, int j) {
		for (ChessPiece p : pieces) {
			if ((p.getX() == i) && (p.getY() == j)) {
				return p;
			}
		}
		return null;
	}

	/**
	 * Finds and returns the White King's Location Needed for checking if the
	 * king is in danger
	 * 
	 * @return the white king
	 */
	public King whiteKing() {
		for (ChessPiece p : this.getPieces())
			if (p instanceof King) {
				if (p.getType() == 1) {
					return (King) p;
				}
			}
		return null;
	}

	/**
	 * 
	 * @see #whiteKing()
	 * @return the black king
	 */
	public King blackKing() {
		for (ChessPiece p : this.getPieces())
			if (p instanceof King) {
				if (p.getType() == 2) {
					return (King) p;
				}
			}
		return null;
	}

	/**
	 * Checks if is check mate.
	 * 
	 * @return true, if is check mate
	 */
	public boolean isCheckMate() {
		if (whiteKing().isUnderCheck()) {
			for (ChessPiece c : pieces) {
				if (c.getType() == WHITE) {
					if (c.hasLegalMove()) {
						return false;
					}
				}
			}
			this.setChanged();
			this.notifyObservers("Checkmate");
			this.clearChanged();
			return true;
		} else if (blackKing().isUnderCheck()) {
			for (ChessPiece c : pieces) {
				if (c.getType() == BLACK) {
					if (c.hasLegalMove()) {
						return false;
					}
				}
			}
			this.setChanged();
			this.notifyObservers("Checkmate");
			this.clearChanged();
			return true;
		}
		return false;

	}

	/**
	 * Checks if is stalemate.
	 * 
	 * @param type
	 *            the type
	 * 
	 * @return true, if is stalemate
	 */
	public boolean isStalemate(int type) {
		if (!blackKing().isUnderCheck() && !whiteKing().isUnderCheck()) {
			for (ChessPiece c : pieces) {
				if (c.getType() == type && c.hasLegalMove()) {
					return false;
				}

			}
			this.setChanged();
			this.notifyObservers("Stalemate");
			this.clearChanged();
			return true;
			
		}
		return false;
	}

	/**
	 * Determines if two ChessBoard squares are horizontal.
	 * 
	 * @param a
	 *            the first chessBoard square
	 * @param b
	 *            the second chessBoard square
	 * 
	 * @return true if they squares are horizontal, false if otherwise
	 */
	public boolean isHorizontal(Point a, Point b) {
		if (a.getY() == b.getY()) {
			return true;
		}
		return false;
	}

	/**
	 * Determines if two ChessBoard squares are vertical.
	 * 
	 * @param a
	 *            the first chessBoard square
	 * @param b
	 *            the second chessBoard square
	 * 
	 * @return true if they squares are vertical, false if otherwise
	 */
	public boolean isVertical(Point a, Point b) {
		if (a.getX() == b.getX()) {
			return true;
		}
		return false;
	}

	/**
	 * Determines if two ChessBoard squares are diagonal.
	 * 
	 * @param a
	 *            the first chessBoard square
	 * @param b
	 *            the second chessBoard square
	 * 
	 * @return true if they squares are diagonal, false if otherwise
	 */
	public boolean isDiagonal(Point a, Point b) {
		double c = Math.abs(a.getY() - b.getY());
		double d = Math.abs(a.getX() - b.getX());
		if (c == d) {
			return true;
		}
		return false;
	}

	/**
	 * Determines if two ChessBoard squares are in the immediate vicinity of one
	 * another.
	 * 
	 * @param a
	 *            the first chessBoard square
	 * @param b
	 *            the second chessBoard square
	 * 
	 * @return true if they squares are in the immediate vicinity of one
	 *         another, false if otherwise
	 */
	public boolean isInVicinity(Point a, Point b) {
		double c = Math.abs(a.getY() - b.getY());
		double d = Math.abs(a.getX() - b.getX());
		if (c == 1 && d < 2 || c < 2 && d == 1) {
			return true;
		}
		return false;
	}

	/**
	 * Gets the all the vertical squares between two ChessBoard squares.
	 * 
	 * @param a
	 *            the first chessBoard square
	 * @param b
	 *            the second chessBoard square
	 * 
	 * @return An ArrayList containing all the vertical squares between the
	 *         provided squares
	 */
	public ArrayList<Point> getVertical(Point a, Point b) {
		ArrayList<Point> intArr = new ArrayList<Point>();
		if (isVertical(a, b)) {
			for (int i = 0; i <= SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					Point c = new Point(i, j);
					int x = (int) a.getY();
					int y = (int) b.getY();
					int z = (int) c.getY();
					if (isVertical(a, c) && isVertical(a, c)
							&& (((y > z) && (z > x)) || ((x > z) && (z > y))))
						intArr.add(c);
				}
			}

		}
		return intArr;
	}

	/**
	 * Gets the all the horizontal squares between two ChessBoard squares.
	 * 
	 * @param a
	 *            the first chessBoard square
	 * @param b
	 *            the second chessBoard square
	 * 
	 * @return An ArrayList containing all the horizontal squares between the
	 *         provided squares
	 */
	public ArrayList<Point> getHorizontal(Point a, Point b) {
		ArrayList<Point> intArr = new ArrayList<Point>();
		if (isHorizontal(a, b)) {
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					Point c = new Point(i, j);
					int x = (int) a.getX();
					int y = (int) b.getX();
					int z = (int) c.getX();
					if (isHorizontal(a, c) && isHorizontal(a, c)
							&& (((y > z) && (z > x) || (x > z) && (z > y))))
						intArr.add(c);
				}
			}

		}
		return intArr;
	}

	/**
	 * Gets the all the diagonal squares between two ChessBoard squares.
	 * 
	 * @param a
	 *            the first chessBoard square
	 * @param b
	 *            the second chessBoard square
	 * 
	 * @return An ArrayList containing all the diagonal squares between the
	 *         provided squares
	 */
	public ArrayList<Point> getDiagonal(Point a, Point b) {
		ArrayList<Point> intArr = new ArrayList<Point>();
		if (isDiagonal(a, b)) {
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					Point c = new Point(i, j);
					int x = (int) a.getY();
					int y = (int) b.getY();
					int z = (int) c.getY();
					if (isDiagonal(a, c) && isDiagonal(b, c)
							&& (((y > z) && (z > x) || (x > z) && (z > y))))
						intArr.add(c);
				}
			}

		}
		return intArr;
	}

	/**
	 * Checks if a piece exists between two squares vertically.
	 * 
	 * @param a
	 *            square 1 to be checked
	 * @param b
	 *            square 2 to be checked
	 * 
	 * @return true, if piece exists
	 */
	public boolean hasVert(Point a, Point b) {
		for (Point p : this.getVertical(a, b)) {
			if (this.hasPieceAt((int) p.getX(), (int) p.getY())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if a piece exists between two squares horizontally.
	 * 
	 * @param a
	 *            square 1 to be checked
	 * @param b
	 *            square 2 to be checked
	 * 
	 * @return true, if piece exists
	 */
	public boolean hasHor(Point a, Point b) {
		for (Point p : this.getHorizontal(a, b)) {
			if (this.hasPieceAt((int) p.getX(), (int) p.getY())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if a piece exists between two squares diagonally.
	 * 
	 * @param a
	 *            square 1 to be checked
	 * @param b
	 *            square 2 to be checked
	 * 
	 * @return true, if piece exists
	 */
	public boolean hasDia(Point a, Point b) {
		for (Point p : this.getDiagonal(a, b)) {
			if (this.hasPieceAt((int) p.getX(), (int) p.getY())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Outputs a String representation of the board.
	 * 
	 * @return String representation of the board
	 */
	@Override
	public String toString() {
		String s = " 0  1  2  3  4  5  6  7 \n";
		s += "------------------------\n";
		int increment = 0;
		for (int j = 0; j < SIZE; j++) {
			for (int i = 0; i < SIZE; i++) {
				if (getPieceAt(i, j) instanceof Pawn
						&& getPieceAt(i, j).getType() == 1)
					s += " P ";
				else if (getPieceAt(i, j) instanceof Rook
						&& getPieceAt(i, j).getType() == 1)
					s += " R ";
				else if (getPieceAt(i, j) instanceof Queen
						&& getPieceAt(i, j).getType() == 1)
					s += " Q ";
				else if (getPieceAt(i, j) instanceof King
						&& getPieceAt(i, j).getType() == 1)
					s += " K ";
				else if (getPieceAt(i, j) instanceof Knight
						&& getPieceAt(i, j).getType() == 1)
					s += " N ";
				else if (getPieceAt(i, j) instanceof Bishop
						&& getPieceAt(i, j).getType() == 1)
					s += " B ";
				else if (getPieceAt(i, j) instanceof Pawn
						&& getPieceAt(i, j).getType() == 2)
					s += " p ";
				else if (getPieceAt(i, j) instanceof Rook
						&& getPieceAt(i, j).getType() == 2)
					s += " r ";
				else if (getPieceAt(i, j) instanceof Queen
						&& getPieceAt(i, j).getType() == 2)
					s += " q ";
				else if (getPieceAt(i, j) instanceof King
						&& getPieceAt(i, j).getType() == 2)
					s += " k ";
				else if (getPieceAt(i, j) instanceof Knight
						&& getPieceAt(i, j).getType() == 2)
					s += " n ";
				else if (getPieceAt(i, j) instanceof Bishop
						&& getPieceAt(i, j).getType() == 2)
					s += " b ";
				else if (getPieceAt(i, j) instanceof Queen)
					s += " Q ";
				else if (grid[i][j] == 0)
					s += " . ";
				else if (grid[i][j] == 1)
					s += " * ";
			}
			s += "| " + increment + "\n";
			increment++;
		}
		return s;
	}

	/**
	 * Prints out String representation of the board in the console.
	 */
	public void print() {
		System.out.println(this);
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int getTurn() {
		return turn;
	}


	public int getKnightX() {
		return KnightX;
	}

	public void setKnightX(int knightX) {
		KnightX = knightX;
	}

	public int getKnightY() {
		return KnightY;
	}

	public void setKnightY(int knightY) {
		KnightY = knightY;
	}

}
