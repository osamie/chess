package pack;
import java.util.InputMismatchException;
import java.util.Scanner;


//import java.util.ArrayList;
/**
 * The Class Player.
 * 
 * Class models a player of the chess Game
 * 
 * @author Tobi
 */
public class Player {
  /**
   *  The name. 
   */
  String name;

  /**
   *  The my pieces. 
   */

  /**
   *  The chess board. 
   */
  protected ChessBoard chessBoard;
  int colour;

  /**
   * Instantiates a new player.
   * 
   * @param name the name of the player
   * @param chessBoard the chess board the player is playing on
   */
  public Player(String name, ChessBoard chessBoard,int colour) {
		this.name = name;
		this.chessBoard = chessBoard;
		this.colour = colour;
  }
  
  public void myHandler()
  {
	  this.play();
  }
  
  /**
   * Represents a Players turn in a Chess game, the player is prompted to provide x,y coordinates 
   * of the piece to be moved and x, y coordinates of the destination of the piece.
   */
	public void play() {
		while(true){
		int i = 0, j = 0, x = 0, y = 0;
		Scanner sc = new Scanner(System.in);
			try {
				System.out
						.println(this.name
								+ " please enter the X,Y coordinates of the piece to be moved:");
				i = sc.nextInt();
				j = sc.nextInt();
			} catch (InputMismatchException nfe) {
				System.out.println("The input is not invalid.");
				this.myHandler();
				break;
			}

		if (chessBoard.hasPieceAt(i, j)) {
			ChessPiece p = chessBoard.getPieceAt(i, j);
			if (p.getType() == this.colour) {
					try {
						System.out
								.println(this.name
										+ " please enter the X,Y coordinate of destination:");
						x = sc.nextInt();
						y = sc.nextInt();
					} catch (InputMismatchException BEQ) {
						System.out.println("The input is not invalid.");
						this.myHandler();
						break;
					}
				p.move(x, y);
				break;
			} else {
				System.out.println("Invalid Move.");
			}
		} else {
			System.out.println("There is no piece at that location or the piece doesnt belong to you.");
		}
	}
	}
}
