package pack;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class KnightsTour.
 * 
 * @author Osazuwa
 */
public class SetupKnightsTour extends GameSetup {
  
 	/** The k1. */
	 Knight k1;
  
  /**
   * Instantiates a new knights tour game.
   */
  public SetupKnightsTour() 
  {
	 k1 = new Knight(0,0,c,1);
  }
  

	/**
	 * Checks if the Knight is stuck and cannot move to any point
	 * of the board that has not been visited.
	 * 
	 * @return true, if the knight is stuck
	 * false, if otherwise
	 */
	public boolean gameLost() {
		for (int i = 0; i < ChessBoard.SIZE; i++) {
			for (int j = 0; j < ChessBoard.SIZE; j++) {
				if (k1.canEatAt(i, j) && !c.hasBeenVisited(i, j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public Knight getK1() {
		return k1;
	}


	/**
	 * Checks if the Knight has successfully moved to all the points
	 * on the board.
	 * 
	 * @return true, if the knight has moved to every point.
	 * @return false, if otherwise
	 */
	public boolean gameWon() {
		for (int i = 0; i < ChessBoard.SIZE; i++) {
			for (int j = 0; j < ChessBoard.SIZE; j++) {
				if (!c.hasBeenVisited(i, j)) {
					return false;
				}
			}
		}
		return true;
	}
	
  /* (non-Javadoc)
   * @see pack.Game#play()
   */
  public void play()
  {
	  System.out.println("Please enter Knight's starting coordinates: ");
	  Scanner sx = new Scanner(System.in);
	  int knightX = sx.nextInt();
	  int knightY = sx.nextInt();
	  k1.setX(knightX); k1.setY(knightY);
	  c.setVistited(knightX, knightY, 1);
	  c.print();
	  while(!gameWon() && !gameLost())
	  {
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Please input X,Y coordinates of where you want the knight:"); 
	  int i = sc.nextInt();
	  int j = sc.nextInt();
	  
	  if(!c.hasBeenVisited(i, j) && k1.canEatAt(i,j)){
		  k1.setX(i);
		  k1.setY(j);
		  c.setVistited(i, j, 1);
	  }
	  else{System.out.println("Invalid Move");}
	  c.print();
	  }
	  if (gameWon())
	  {
		  System.out.println("Congratulations!! You Won!!");
	  }
	  else if (gameLost())
	  {
		  System.out.println("Sorry!! You Lost!!");
	  }
  }
}
