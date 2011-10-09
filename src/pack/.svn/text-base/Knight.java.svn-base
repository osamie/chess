package pack;

/**
 * The Class Knight.
 * Models the knight piece in a Chess Game
 */
public class Knight extends ChessPiece {
  /**
   * Instantiates a new knight.
   * 
   * @param x the x
   * @param y the y
   * @param chessBoard the chess board
   * @param type the type
   */
  public Knight(int x, int y, ChessBoard chessBoard, int type) {
		super(x, y, chessBoard, type);
		chessBoard.addPiece(this);
  }
  
  @Override
	public Object clone() {
		Knight b = new Knight(x,y,chessBoard,type);
		return b;
	}
@Override
	public boolean canEatAt(int i, int j) {
		if ((Math.abs(x - i) == 2) && (Math.abs(y - j) == 1)
				|| (Math.abs(x - i) == 1) && (Math.abs(y - j) == 2)) {
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
		return false;

	}

}

