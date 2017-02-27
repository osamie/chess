package pack;
import java.awt.Point;
import javax.swing.*;


/**
 * Models a  chess square and contains its coordinates
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChessButton extends JButton
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Point coordinates = new Point(0,0);

    /**
     * Creates a new ChessButton with coordinates x,y
     */
    public ChessButton(int x, int y)
    {
      coordinates.setLocation(x,y);  
    }

   
    /**
     * Gets the coordinates of the button.
     * 
     * @return the coordinates as a point
     */
    public Point getCoord()
    {
       return coordinates;
    }
    
}

