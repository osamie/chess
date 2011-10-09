/**
 * 
 */
package pack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.thoughtworks.xstream.XStream;

/**
 * @author
 * 
 */
public class GraphicalKnightsTour implements ActionListener {
	// instance variables - replace the example below with your own
	JFrame chessFrame;
	ChessButton buttons[][];
	JButton labels[];
	JButton labels2[];
	ChessPiece c1;
	int turn;
	int count;
	Panel chesspanel;
	int moves = 0;
	SetupKnightsTour c;

	ImageIcon WhiteKnight = new ImageIcon(getClass().getResource("/Images/Yellow N.gif"));
	ImageIcon VisitedKnight = new ImageIcon(getClass().getResource("/Images/Brown N.gif"));
	private JMenuItem Redo;
	private JMenuItem Undo;
	private JMenuItem Load;
	private JMenuItem Save;
	private JMenuItem Exit;
	private JMenuItem NewGame;
	private XStream xst;

	/**
	 * Constructor for objects of class GraphicalGame
	 */
	public GraphicalKnightsTour(SetupKnightsTour c) {
		
		this.c = c;
		turn = 1;
		count = 0;
		chessFrame = new JFrame("Knights Tour");
		chesspanel = new Panel();
		Panel chesspanel3 = new Panel();

		chessFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		chessFrame.setSize(550, 500);
		chessFrame.setLayout(new BorderLayout());
		
		chesspanel.setLayout(new GridLayout(9, 8));
		chesspanel3.setLayout(new GridLayout(9, 1));
		chessFrame.add(chesspanel, BorderLayout.CENTER);
		chessFrame.add(chesspanel3, BorderLayout.WEST);

		JMenuBar menuBar = new JMenuBar();
		chessFrame.setJMenuBar(menuBar);

		JMenu Game = new JMenu("Game");
		menuBar.add(Game);
		
		JMenu Edit = new JMenu("Edit");
		menuBar.add(Edit);

		NewGame = new JMenuItem("New Game");
		NewGame.addActionListener(this);
		Game.add(NewGame);
		
		Undo = new JMenuItem("Undo");
		Undo.addActionListener(this);
		Edit.add(Undo);
		Undo.setEnabled(false);
		
		Redo = new JMenuItem("Redo");
		Redo.addActionListener(this);
		Edit.add(Redo);
		
		
		Save = new JMenuItem("Save Game");
		Save.addActionListener(this);
		Game.add(Save);
		
		//jPanel2.
		
		Load = new JMenuItem("Load Game");
		Load.addActionListener(this);
		Game.add(Load);

		Exit = new JMenuItem("Exit");
		Exit.addActionListener(this);
		Game.add(Exit);

		String[] Alpha = { "A", "B", "C", "D", "E", "F", "G", "H" };
		for (int j = 0; j < 8; j++) {
			JButton jb = new JButton(Alpha[j]);
			jb.setEnabled(false);
			chesspanel.add(jb);
		}

		buttons = new ChessButton[ChessBoard.SIZE][ChessBoard.SIZE];
		for (int j = 0; j < ChessBoard.SIZE; j++) {
			for (int i = 0; i < ChessBoard.SIZE; i++) {
				buttons[i][j] = new ChessButton(i, j);
				chesspanel.add(buttons[i][j]);
				buttons[i][j].addActionListener(this);
				buttons[i][j].setRolloverEnabled(false);
			}
		}
		String[] Numer = { " ","8", "7", "6", "5", "4", "3", "2", "1" };
		labels = new JButton[9];
		for (int i = 0; i < 9; i++) {
			JButton bx = new JButton(Numer[i]);
			bx.setEnabled(false);
			labels[i] = bx;
		}
		for (JButton j : labels) {
			chesspanel3.add(j);
			chesspanel3.repaint();
		}

		for (int a = 0; a < ChessBoard.SIZE; a++) {
			for (int b = 0; b < ChessBoard.SIZE; b++) {
				if ((a - b) % 2 == 0) {
					buttons[a][b].setBackground(Color.WHITE);
				} else {
					buttons[a][b].setBackground(Color.BLACK);
				}
			}
		}
		chessFrame.setVisible(true);
		JOptionPane.showMessageDialog(null,
		"Please select the Knight's Starting Coordinates");
		xst = new XStream();
	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void repaint() {

		for (int a = 0; a < ChessBoard.SIZE; a++) {
			for (int b = 0; b < ChessBoard.SIZE; b++) {
				if ((a - b) % 2 == 0) {
					buttons[a][b].setBackground(Color.WHITE);
				} else {
					buttons[a][b].setBackground(Color.BLACK);
				}
			}
		}

		for (int j = 0; j < ChessBoard.SIZE; j++) {
			for (int i = 0; i < ChessBoard.SIZE; i++) {
				if (c.getBoard().hasBeenVisited(i, j)) {
					buttons[i][j].setIcon(VisitedKnight);
				} else {
					buttons[i][j].setIcon(null);
				}
				/*
				if (count != 0) {
					for (ChessPiece ch : c.getBoard().getPieces()) {
						if (ch.canEatAt(i, j) && !c.getBoard().hasBeenVisited(i, j)) {
							buttons[i][j].setBackground(Color.BLUE);
						}
					}
				}
				*/
			}
		}
		buttons[c.getK1().getX()][c.getK1().getY()].setBackground(Color.BLUE);
		buttons[c.getK1().getX()][c.getK1().getY()].setIcon(WhiteKnight);
	}

	public void actionPerformed(ActionEvent ev) {

		Object obj = ev.getSource();
		if (obj instanceof ChessButton) {
			ChessButton selected = (ChessButton) obj;
			Point p1 = selected.getCoord();
			int x = (int) p1.getX();
			int y = (int) p1.getY();
			if (count == 0) {
				c.getK1().setX(x);
				c.getK1().setY(y);
				c.getBoard().setVistited(x, y, 1);
				count++;
				JOptionPane.showMessageDialog(null,
						"Knight Starting coordinates(" + x + "," + y + ")");
			} else if (c.getK1().canEatAt(x, y) && !c.getBoard().hasBeenVisited(x, y)
					&& count > 0) {
				
				Move m = new Move(c.getK1(),x,y);
				c.m.UndoStack2.push(m);
				c.getK1().setX(x);
				c.getK1().setY(y);
				c.getBoard().setVistited(x, y, 1);
				count++;
				moves++;
				c.m.RedoStack2.clear();
				Undo.setEnabled(true);

			} else {
				JOptionPane.showMessageDialog(null, "Invalid Move");
			}

			
			if (c.gameWon()) {
				JOptionPane.showMessageDialog(null, "You Won!!!");
				chesspanel.setEnabled(false);
			} else if (c.gameLost()) {
				JOptionPane.showMessageDialog(null, "Sorry You Lost in " + moves
						+ " moves");
				chesspanel.setEnabled(false);

			}

		} else if (obj instanceof JMenuItem) {
			JMenuItem source = (JMenuItem) (ev.getSource());
			if (source.getText() == "New Game") {
				chessFrame.dispose();
				SetupKnightsTour G = new SetupKnightsTour();
				GraphicalKnightsTour c = new GraphicalKnightsTour(G);
				c.repaint();
			}
				
			if (source.getText() == "Save Game") {
				c.getBoard().setKnightX(c.getK1().getX());
				c.getBoard().setKnightY(c.getK1().getY());
				FileDialog f = new FileDialog(chessFrame, "Save Game", FileDialog.SAVE);
				f.setVisible(true);
				try {
					FileWriter w = new FileWriter(f.getFile());
					w.write(xst.toXML(c.getBoard()));
					w.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			    
			}
				
			if (source.getText() == "Load Game") {
				FileDialog f = new FileDialog(chessFrame, "Load Game",
						FileDialog.LOAD);
				f.setVisible(true);
				ChessBoard newC;
				try {
					newC = (ChessBoard)xst.fromXML(new FileInputStream(f.getFile()));
					c.setBoard(newC);
					c.getK1().setX(c.getBoard().getKnightX());
					c.getK1().setY(c.getBoard().getKnightY());
					repaint();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (NullPointerException e) {}
				count = 1;
				
			}

			if (source.getText() == "Undo") {
				if(!c.m.getUndoStack2().isEmpty())
				{
					c.getBoard().setVistited(c.getK1().getX(), c.getK1().getY(), 0);
					Move m = c.m.getUndoStack2().pop();
					Move m2 = new Move(c.getK1(),c.getK1().getX(),c.getK1().getY());
					c.getK1().setX(m.getX());
					c.getK1().setY(m.getY());
					c.m.getRedoStack2().push(m2);
					moves--;
					Redo.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Nothing to Undo!!");	
				}

				repaint();

			}
			if (source.getText() == "Redo") {
				if (!c.m.getRedoStack2().isEmpty())
				{
					Move m = c.m.getRedoStack2().pop();
					Move m2 = new Move(c.getK1(),c.getK1().getX(),c.getK1().getY());
					c.getBoard().setVistited(m.getX(),m.getY(), 1);
					c.m.getUndoStack2().push(m2);
					c.getK1().setX(m.getX());
					c.getK1().setY(m.getY());
					moves++;
					repaint();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Nothing to Redo!!");	
				}
			}

			if (source.getText() == "Exit") {

				int n = JOptionPane.showConfirmDialog(chessFrame, "Are You Sure?",
						"Confirm Exit", JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					chessFrame.dispose();
				} else if (n == 1) {

				}

			}
		}
		repaint();


	}

}
