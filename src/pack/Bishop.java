package pack;
import java.awt.Point;

/**
 * TODO: Auto-generated Javadoc
 * 
 * The Class Bishop.
 * Models the Bishop piece in a Chess Game
 */
@SuppressWarnings("serial")
public class Bishop extends ChessPiece {
	/**
	 * Instantiates a new bishop.
	 * 
	 * @param x 	X coordinates of starting point of this piece
	 * @param y 	Y coordinates of starting point of this piece
	 * @param chessBoard Board to be placed on
	 * @param type white or black piece
	 */
	public Bishop(int x, int y, ChessBoard chessBoard, int type) {
		super(x, y, chessBoard, type);
		chessBoard.addPiece(this);
	}

	
	@Override
	public boolean canEatAt(int i, int j) {
		Point from = new Point(this.getX(), this.getY());
		Point to = new Point(i, j);
		if (canGoTo(i, j) && chessBoard.isDiagonal(from, to)) {
			if (chessBoard.hasDia(from, to)) {
				return false;
			}

			else if (chessBoard.hasPieceAt(i, j)) {
				if (chessBoard.getPieceAt(i,j).getType() == this.type) {
					return false;

				} else {
					return true;
				}

			} else {
				return true;
			}
		}
		return false;
	}


}
