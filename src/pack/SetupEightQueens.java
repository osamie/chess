package pack;
import java.util.Scanner;


/**
 * The Class EightQueens.
 * 
 * @author Osazuwa
 */
public class SetupEightQueens extends GameSetup {
  
  /**
   * Instantiates a new eight queens game.
   */
  public SetupEightQueens() 
  {
	}
  
  
  /**
	 * Checks if any queen threatens another. 
	 * 
	 * 
	 * @return true, if the there is any queen on the board threatening another queen.
	 * @return false, if otherwise
	 */
  public boolean isGameOver()
  {
	for (ChessPiece p:c.getPieces())
	{
		for (ChessPiece p2:c.getPieces())
		{
		if(((Queen) p).canEatAt(p2.getX(), p2.getY())){return true;}
		}
	
	}
	return false; 
  }
  
  
  
  /* (non-Javadoc)
   * @see pack.Game#play()
   */
  public void play() 
  {
	  int count = 1;
	  while(isGameOver() == false && count < 9)
	  {
	  System.out.println("Please input X,Y coordinates of Queen " + count +":");
	  Scanner sc = new Scanner(System.in);
	  int i = sc.nextInt();
	  int j = sc.nextInt();
	  Queen q = new Queen(i,j,c,count+3);
	  c.addPiece(q);
	  count++;
	  c.print();
	  }
	  if (count == 9) 
	  {
		  System.out.println("You Won!");
	  }
	  else	
	  {
	  System.out.println("You Lost");
	  }
  }

}
