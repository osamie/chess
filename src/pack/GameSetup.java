package pack;


import java.util.Scanner;

/**
 * 
 * The Class Game. This class will prompt the user for which of the three games
 * they would like to play
 */

public class GameSetup {
	/**
	 * The ChessBoard.
	 */
	protected ChessBoard c;
	MoveHistory m;
	
  	/**
	   * Returns the board on which the game is being played
	   * 
	   * @return the board
	   */
	  public ChessBoard getBoard()
	{
		return c;
	}
	  public void setBoard(ChessBoard c)
		{
			this.c=c;
		}
	

	/**
	 * Instantiates a new game.
	 */
	public GameSetup() { 
		c = new ChessBoard();
		m = new MoveHistory();
	}

	/**
	 * Play.
	 */
	public void play() {
	}

	/**
	 *Prompts the user to choose a Game.
	 */
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			char choice;
			int genious = 0;
			while (genious == 0) {
				System.out.println("Please enter the game you want to play (C for Classic Chess, E for Eight Queens, K for Knights Tour, Q to Quit)");
				choice = sc.next().charAt(0);
				switch(choice){
					case 'C' : SetupChess game = new SetupChess();
							   game.play();
							   genious = 1;
							   break;
					
					case 'E' : SetupEightQueens e = new SetupEightQueens();
							   e.play();
							   genious = 1;
							   break;
							 
					case 'K' : SetupKnightsTour k = new SetupKnightsTour();
							   k.play();
							   genious = 1;
							   break;
							 
					case 'Q' : System.out.println("Exiting!...Thanks for playing!"); genious = 1; break;
					
					default: System.out.println("Unrecognized input"); break;
				}
			}
	}
}
