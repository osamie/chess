package pack;

import java.awt.Point;

/**
 * The Class Queen.
 * Models the queen piece in a Chess Game
 */
public class Queen extends ChessPiece {
	/**
	 * Instantiates a new queen.
	 * 
	 * @param x 	X coordinates of starting point of this piece
	 * @param y 	Y coordinates of starting point of this piece
	 * @param chessBoard Board to be placed on
	 * @param type White or black piece
	 */
	public Queen(int x, int y, ChessBoard chessBoard, int type) {
		super(x, y, chessBoard, type);
		chessBoard.addPiece(this);
	}

	@Override
	public Object clone() {
		Queen b = new Queen(x,y,chessBoard,type);
		return b;
	}
	@Override
	public boolean canEatAt(int i, int j) {
		Point from = new Point(this.getX(), this.getY());
		Point to = new Point(i, j);
		if (canGoTo(i, j)
				&& (chessBoard.isVertical(from, to)
						|| chessBoard.isDiagonal(from, to) || chessBoard
						.isHorizontal(from, to))) {
			if (chessBoard.hasVert(from, to) || chessBoard.hasHor(from, to)
					|| chessBoard.hasDia(from, to)) 
			{
				return false;
			}

			else if (chessBoard.hasPieceAt(i, j)){
				if (chessBoard.getPieceAt((int) to.getX(), (int) to.getY())
						.getType() == this.type) {
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
