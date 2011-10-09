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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import com.thoughtworks.xstream.XStream;

/**
 * @author Tobi
 * 
 */

public class GraphicalChessGame implements ActionListener, Observer {
	JFrame chessFrame;
	ChessButton buttons[][];
	JButton labels[];
	JButton labels2[];
	ChessPiece c1;
	int count;
	Panel chesspanel;
	Panel panel;
	JMenuItem NewGame;
	JMenuItem Undo;
	JMenuItem Redo;
	JMenuItem Save;
	JMenuItem Load;
	JMenuItem Exit;
	SetupChess c;
	private int state;
	private XStream xst;

	/**
	 * Constructor for objects of class GraphicalGame
	 */

	public GraphicalChessGame(SetupChess c) {
		c.getBoard().setTurn(1);
		state = 0;
		chessFrame = new JFrame("Chess-White Move");
		chesspanel = new Panel();
		Panel chesspanel3 = new Panel();
		this.c = c;
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

		String[] Numer = { "", "8", "7", "6", "5", "4", "3", "2", "1" };
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
		for (ChessPiece ch : c.getBoard().getPieces()) {
			ch.addObserver(this);
		}
		chessFrame.setVisible(true);
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

		ImageIcon BlackKing = new ImageIcon(getClass().getResource(
				"/Images/Brown K.gif"));
		ImageIcon BlackRook = new ImageIcon(getClass().getResource(
				"/Images/Brown R.gif"));
		ImageIcon BlackQueen = new ImageIcon(getClass().getResource(
				"/Images/Brown Q.gif"));
		ImageIcon BlackPawn = new ImageIcon(getClass().getResource(
				"/Images/Brown P.gif"));
		ImageIcon BlackKnight = new ImageIcon(getClass().getResource(
				"/Images/Brown N.gif"));
		ImageIcon BlackBishop = new ImageIcon(getClass().getResource(
				"/Images/Brown B.gif"));
		ImageIcon WhiteKing = new ImageIcon(getClass().getResource(
				"/Images/Yellow K.gif"));
		ImageIcon WhiteRook = new ImageIcon(getClass().getResource(
				"/Images/Yellow R.gif"));
		ImageIcon WhiteQueen = new ImageIcon(getClass().getResource(
				"/Images/Yellow Q.gif"));
		ImageIcon WhitePawn = new ImageIcon(getClass().getResource(
				"/Images/Yellow P.gif"));
		ImageIcon WhiteKnight = new ImageIcon(getClass().getResource(
				"/Images/Yellow N.gif"));
		ImageIcon WhiteBishop = new ImageIcon(getClass().getResource(
				"/Images/Yellow B.gif"));

		for (int j = 0; j < ChessBoard.SIZE; j++) {
			for (int i = 0; i < ChessBoard.SIZE; i++) {
				if (c.getBoard().getPieceAt(i, j) instanceof Pawn
						&& c.getBoard().getPieceAt(i, j).getType() == 1)
					buttons[i][j].setIcon(WhitePawn);
				else if (c.getBoard().getPieceAt(i, j) instanceof Rook
						&& c.getBoard().getPieceAt(i, j).getType() == 1)
					buttons[i][j].setIcon(WhiteRook);
				else if (c.getBoard().getPieceAt(i, j) instanceof Knight
						&& c.getBoard().getPieceAt(i, j).getType() == 1)
					buttons[i][j].setIcon(WhiteKnight);
				else if (c.getBoard().getPieceAt(i, j) instanceof Bishop
						&& c.getBoard().getPieceAt(i, j).getType() == 1)
					buttons[i][j].setIcon(WhiteBishop);
				else if (c.getBoard().getPieceAt(i, j) instanceof Queen
						&& c.getBoard().getPieceAt(i, j).getType() == 1)
					buttons[i][j].setIcon(WhiteQueen);
				else if (c.getBoard().getPieceAt(i, j) instanceof King
						&& c.getBoard().getPieceAt(i, j).getType() == 1)
					buttons[i][j].setIcon(WhiteKing);
				else if (c.getBoard().getPieceAt(i, j) instanceof Pawn
						&& c.getBoard().getPieceAt(i, j).getType() == 2)
					buttons[i][j].setIcon(BlackPawn);
				else if (c.getBoard().getPieceAt(i, j) instanceof Rook
						&& c.getBoard().getPieceAt(i, j).getType() == 2)
					buttons[i][j].setIcon(BlackRook);
				else if (c.getBoard().getPieceAt(i, j) instanceof Knight
						&& c.getBoard().getPieceAt(i, j).getType() == 2)
					buttons[i][j].setIcon(BlackKnight);
				else if (c.getBoard().getPieceAt(i, j) instanceof Bishop
						&& c.getBoard().getPieceAt(i, j).getType() == 2)
					buttons[i][j].setIcon(BlackBishop);
				else if (c.getBoard().getPieceAt(i, j) instanceof Queen
						&& c.getBoard().getPieceAt(i, j).getType() == 2)
					buttons[i][j].setIcon(BlackQueen);
				else if (c.getBoard().getPieceAt(i, j) instanceof King
						&& c.getBoard().getPieceAt(i, j).getType() == 2)
					buttons[i][j].setIcon(BlackKing);
				else if (!c.getBoard().hasPieceAt(i, j))
					buttons[i][j].setIcon(null);

			}
		}
		for (ChessPiece ch : c.getBoard().getPieces()) {
			ch.addObserver(this);
		}

		if (state == 1) {
			for (Point p : c.getC1().legalMoves()) {
				if (c.getBoard().hasPieceAt((int) p.getX(), (int) p.getY())) {
					buttons[(int) p.getX()][(int) p.getY()]
							.setBackground(Color.RED);
				} else {
					buttons[(int) p.getX()][(int) p.getY()]
							.setBackground(Color.BLUE);
				}
			}
		} else if (state == 0) {
			Border none = BorderFactory.createEmptyBorder();
			for (int a = 0; a < ChessBoard.SIZE; a++) {
				for (int b = 0; b < ChessBoard.SIZE; b++) {
					if ((a - b) % 2 == 0) {

						buttons[a][b].setBackground(Color.WHITE);
					} else {
						buttons[a][b].setBackground(Color.BLACK);

					}
				}
			}
		}
		if (c.getBoard().getTurn() == 1) {
			chessFrame.setTitle("Chess-White Move");
		} else if (c.getBoard().getTurn() == 2) {
			chessFrame.setTitle("Chess-Black Move");
		}

	}

	public void actionPerformed(ActionEvent ev) {

		Object obj = ev.getSource();
		if (obj instanceof ChessButton) {
			ChessButton selected = (ChessButton) obj;
			Point p1 = selected.getCoord();
			int x = (int) p1.getX();
			int y = (int) p1.getY();
			if ((c.getBoard().hasPieceAt(x, y)) && state == 0) {
				c.setC1(c.getBoard().getPieceAt(x, y));
				state = 1;

			} else if (state == 1) {
				repaint();
				if (c.getC1().getType() == c.getBoard().getTurn()) {
					if (x == c.getC1().getX() && y == c.getC1().getY()) {
						state = 0;
					} else {
						try {
							MoveHistory.saveObject(c.getBoard(), "new.txt");
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							c.m.getUndoStack().push(
									MoveHistory.loadObject("new.txt"));
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						c.m.getRedoStack().clear();
						c.getC1().move(x, y);
						toggleturn();
						state = 0;

						Undo.setEnabled(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Not Your Turn");
					state = 0;
				}
			}
			if (c.getBoard().isCheckMate()) {
				chessFrame.validate();
				repaint();
				if (c.getBoard().getTurn() == 1) {
					JOptionPane.showMessageDialog(null, "CHECKMATE BLACK WINS");
					for (int j = 0; j < ChessBoard.SIZE; j++) {
						for (int i = 0; i < ChessBoard.SIZE; i++) {
							chesspanel.setEnabled(false);
						}
						{

						}
					}
				} else if (c.getBoard().getTurn() == 2) {
					JOptionPane.showMessageDialog(null, "CHECKMATE WHITE WINS");
					for (int j = 0; j < ChessBoard.SIZE; j++) {
						for (int i = 0; i < ChessBoard.SIZE; i++) {
							chesspanel.setEnabled(false);
						}
					}

				}
			} else if (c.getBoard().isStalemate(ChessBoard.BLACK)) {
				chessFrame.validate();
				repaint();
				JOptionPane.showMessageDialog(null, "DRAW: STALEMATE");
				for (int j = 0; j < ChessBoard.SIZE; j++) {
					for (int i = 0; i < ChessBoard.SIZE; i++) {
						chesspanel.setEnabled(false);
					}

				}
			} else if (c.getBoard().isStalemate(ChessBoard.WHITE)) {
				chessFrame.validate();
				repaint();
				JOptionPane.showMessageDialog(null, "DRAW: STALEMATE");
				for (int j = 0; j < ChessBoard.SIZE; j++) {
					for (int i = 0; i < ChessBoard.SIZE; i++) {
						chesspanel.setEnabled(false);
					}
				}

			}
		} else if (obj instanceof JMenuItem) {
			JMenuItem source = (JMenuItem) (ev.getSource());
			if (source.getText() == "New Game") {
				chessFrame.dispose();
				SetupChess G = new SetupChess();
				GraphicalChessGame c = new GraphicalChessGame(G);
				c.repaint();
				File f = new File("new.txt");
				f.delete();
			}

			if (source.getText() == "Save Game") {
				FileDialog f = new FileDialog(chessFrame, "Save Game",
						FileDialog.SAVE);
				f.setVisible(true);
				try {
					MoveHistory.saveObject(c.getBoard(),(f.getFile()));
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			if (source.getText() == "Load Game") {
				FileDialog f = new FileDialog(chessFrame, "Load Game",
						FileDialog.LOAD);
				f.setVisible(true);

				try {
					c.setBoard(MoveHistory.loadObject(f.getFile()));
				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Nothing to Redo!!");
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Invalid File!!");
				} catch (NullPointerException e){
					//No file selected no error
				}
				repaint();
			}

				

			if (source.getText() == "Undo") {
				if (!c.m.getUndoStack().isEmpty()) {
					try {
						MoveHistory.saveObject(c.getBoard(), "new.txt");

					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						c.m.getRedoStack().push(
								MoveHistory.loadObject("new.txt"));
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					c.setBoard(c.m.getUndoStack().pop());
					Redo.setEnabled(true);
					repaint();
				} else {
					JOptionPane.showMessageDialog(null, "Nothing to Undo!!");
				}

			}
			if (source.getText() == "Redo") {
				if (!c.m.getRedoStack().isEmpty()) {
					try {
						MoveHistory.saveObject(c.getBoard(), "new.txt");

					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						c.m.getUndoStack().push(
								MoveHistory.loadObject("new.txt"));
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					c.setBoard(c.m.getRedoStack().pop());
					toggleturn();
				} else {
					JOptionPane.showMessageDialog(null, "Nothing to Redo!!");
				}
			}

			if (source.getText() == "Exit") {

				int n = JOptionPane.showConfirmDialog(chessFrame,
						"Are You Sure?", "Confirm Exit",
						JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					chessFrame.dispose();
					File f = new File("new.txt");
					f.delete();
				} else if (n == 1) {

				}

			}
		}

		repaint();

	}

	private void toggleturn() {
		if (c.getBoard().getTurn() == 1) {
			c.getBoard().setTurn(2);
		} else if (c.getBoard().getTurn() == 2) {
			c.getBoard().setTurn(1);
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof ChessPiece)
			if (arg instanceof String)
				if (arg == "Check") {
					JOptionPane.showMessageDialog(null,
							"Your King is on check!");
					toggleturn();
				}
		if (arg == "Invalid") {
			JOptionPane.showMessageDialog(null, "Invalid Move");
			state = 0;
			toggleturn();
		} else if (arg == "OnCheck" && !c.getBoard().isCheckMate()) {
			JOptionPane.showMessageDialog(null, "Check!");
		}
		if (arg == "Promote") {

			int x = ((ChessPiece) o).getX();
			int y = ((ChessPiece) o).getY();
			c.getBoard().removePiece(x, y);
			ImageIcon PromotionPawn = new ImageIcon("src/Images/Clear P.gif");
			Object[] possibilities = { "Queen", "Bishop", "Rook", "Knight" };
			String s = (String) JOptionPane.showInputDialog(chessFrame,
					"Please Select A Piece to promote to:\n", "Pawn Promotion",
					JOptionPane.PLAIN_MESSAGE, PromotionPawn, possibilities,
					"Queen");

			if ((s != null) && (s.length() > 0)) {
				if (s == "Queen") {

					Queen q = new Queen(x, y, c.getBoard(), ((ChessPiece) o)
							.getType());
					q.addObserver(this);
				} else if (s == "Rook") {
					Rook r = new Rook(x, y, c.getBoard(), ((ChessPiece) o)
							.getType());
					r.addObserver(this);
				} else if (s == "Bishop") {
					Bishop b = new Bishop(x, y, c.getBoard(), ((ChessPiece) o)
							.getType());
					b.addObserver(this);
				} else if (s == "Knight") {
					Knight N = new Knight(x, y, c.getBoard(), ((ChessPiece) o)
							.getType());
					N.addObserver(this);
				}

			} else {
				Queen q = new Queen(x, y, c.getBoard(), ((ChessPiece) o)
						.getType());
				q.addObserver(this);
			}

		}

	}

}
