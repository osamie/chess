/**
 * 
 */
package pack;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.thoughtworks.xstream.XStream;

/**
 * @author Tobi
 * 
 */
public class GraphicalEightQueens implements ActionListener {
	JFrame chessFrame;
	ChessButton buttons[][];
	JButton labels[];
	JButton labels2[];
	ChessPiece c1;
	int turn;
	int count;
	Panel chesspanel;
	SetupEightQueens c;
	private JMenuItem NewGame;
	private JMenuItem Undo;
	private JMenuItem Redo;
	private JMenuItem Save;
	private JMenuItem Load;
	private JMenuItem Exit;
	private XStream xst;
	/**
	 * Constructor for objects of class GraphicalGame
	 */
	public GraphicalEightQueens(SetupEightQueens c) {
		this.c = c;
		turn = 1;
		count = 0;
		chessFrame = new JFrame("Eight Queens");
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
		//Undo.setEnabled(false);
		
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
		
		String[] Numer = {"", "8", "7", "6", "5", "4", "3", "2", "1" };
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
		xst = new XStream();
		chessFrame.setVisible(true);
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
		ImageIcon WhiteQueen = new ImageIcon(getClass().getResource("/Images/Yellow Q.gif"));
		for (int j = 0; j < ChessBoard.SIZE; j++) {
			for (int i = 0; i < ChessBoard.SIZE; i++) {
				if (c.getBoard().getPieceAt(i, j) instanceof Queen)
				{
					buttons[i][j].setIcon(WhiteQueen);
				}
				else
				{
					buttons[i][j].setIcon(null);
				}
				for (ChessPiece ch : c.getBoard().getPieces())
					for (int a = 0; a < ChessBoard.SIZE; a++) {
						for (int b = 0; b < ChessBoard.SIZE; b++) {
							if (ch.canEatAt(a, b) || c.getBoard().hasPieceAt(a, b)) {
								buttons[a][b].setBackground(Color.BLUE);

							}
						}

					}
			}
		}
		

	}

	public void actionPerformed(ActionEvent ev) {
		repaint();
		Object obj = ev.getSource();
		if (obj instanceof ChessButton) {
			ChessButton selected = (ChessButton) obj;
			Point p1 = selected.getCoord();
			int x = (int) p1.getX();
			int y = (int) p1.getY();
			if (!c.getBoard().hasPieceAt(x, y)) {
				c.m.getRedoStack3().clear();
				Queen Q = new Queen(x, y, c.getBoard(), count + 3);
				count++;
				c.m.getUndoStack3().push(new Point(x, y));
			} else {
				JOptionPane.showMessageDialog(null, "Invalid Move");
			}
		} else if (obj instanceof JMenuItem) {
			JMenuItem source = (JMenuItem) (ev.getSource());
			if (source.getText() == "New Game") {
				chessFrame.dispose();
				SetupEightQueens g = new SetupEightQueens();
				GraphicalEightQueens q = new GraphicalEightQueens(g);
				q.repaint();

			}
			if (source.getText() == "Save Game") {
				FileDialog f = new FileDialog(chessFrame, "Save Game", FileDialog.SAVE);
				f.setVisible(true);
				try {
					FileWriter w = new FileWriter(f.getFile());
					w.write(xst.toXML(c.getBoard()));
					w.close();
				} catch (IOException e) {
					e.printStackTrace();
				}catch (NullPointerException e){}    
			}
				
			if (source.getText() == "Load Game") {
				FileDialog f = new FileDialog(chessFrame, "Load Game",
						FileDialog.LOAD);
				f.setVisible(true);
				
				ChessBoard newC;
				try {
					SetupEightQueens seq = new SetupEightQueens();
					GraphicalEightQueens g = new GraphicalEightQueens(seq);
					newC = (ChessBoard)xst.fromXML(new FileInputStream(f.getFile()));
					seq.setBoard(newC);
					g.repaint();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (NullPointerException e) {}
				count = 1;
			}

			if (source.getText() == "Undo") {
				if(!c.m.getUndoStack3().isEmpty())
				{
					
					Point p = c.m.getUndoStack3().pop();
					c.getBoard().removePiece((int)p.getX(), (int)p.getY());
					
					c.m.getRedoStack3().push(p);
					count--;
					Redo.setEnabled(true);
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Nothing to Undo!!");	
				}
				this.repaint();
				
				
			}
			if (source.getText() == "Redo") {
				if (!c.m.getRedoStack3().isEmpty())
				{
					Point p = c.m.getRedoStack3().pop();
					Queen Q = new Queen((int)p.getX(), (int)p.getY(), c.getBoard(), count + 3);
					c.m.getUndoStack3().push(p);
					count++;
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
		if (c.isGameOver()) {
			repaint();
			JOptionPane.showMessageDialog(null, "Sorry You Lost");
			chesspanel.setEnabled(false);
		} else if (count == 8) {
			repaint();
			JOptionPane.showMessageDialog(null, "You Won!!!");
			chesspanel.setEnabled(false);
		}
	}

}
