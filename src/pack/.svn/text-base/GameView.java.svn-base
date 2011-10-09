package pack;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class GameView extends GameSetup implements ActionListener {
	/**
	 * Central Area to select which game to play
	 */
	private static final long serialVersionUID = 1L;
	
	public JFrame frame;

	JMenuItem EightQueens;
	JMenuItem Chess;
	JMenuItem KnightsTour;
	JMenuItem Exit;

	// JTextArea area;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		@SuppressWarnings("unused")
		GameView z = new GameView();

	}

	public GameView() {
				
		ImageIcon Knight = new ImageIcon(getClass().getResource("/Images/Knight.gif"));
		ImageIcon Queen = new ImageIcon(getClass().getResource("/Images/Queen.gif"));
		ImageIcon King = new ImageIcon(getClass().getResource("/Images/King.gif"));
		
		JFrame frame = new JFrame("Chess Suite");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		frame.setLayout(new GridLayout());

		JMenu NewGame = new JMenu("Game");
		menuBar.add(NewGame);

		JButton j = new JButton("Play Chess",King);
		j.addActionListener(this);
		j.setVerticalTextPosition(SwingConstants.BOTTOM);
		j.setHorizontalTextPosition(SwingConstants.CENTER);
		frame.add(j);
		j.setRolloverEnabled(false);
		j.setVisible(true);
		
		JButton j2 = new JButton("Play Eight Queens", Queen);
		j2.addActionListener(this);
		j2.setVerticalTextPosition(SwingConstants.BOTTOM);
		j2.setHorizontalTextPosition(SwingConstants.CENTER);
		frame.add(j2);
		j2.setRolloverEnabled(false);
		j2.setVisible(true);
		
		JButton j3 = new JButton("Play Knights Tour",Knight);
		j3.addActionListener(this);
		j3.setVerticalTextPosition(SwingConstants.BOTTOM);
		j3.setHorizontalTextPosition(SwingConstants.CENTER);
		frame.add(j3);
		j3.setRolloverEnabled(false);
		j3.setVisible(true);

		EightQueens = new JMenuItem("EightQueens");
		EightQueens.addActionListener(this);
		NewGame.add(EightQueens);

		Chess = new JMenuItem("Chess");
		Chess.addActionListener(this);
		NewGame.add(Chess);

		KnightsTour = new JMenuItem("KnightsTour");
		KnightsTour.addActionListener(this);
		NewGame.add(KnightsTour);

		NewGame.addSeparator();

		Exit = new JMenuItem("Exit");
		Exit.addActionListener(this);
		NewGame.add(Exit);

		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj instanceof JMenuItem)
		{
		JMenuItem source = (JMenuItem) (obj);
		if (source.getText() == "Chess") {
			SetupChess G = new SetupChess();
			GraphicalChessGame c = new GraphicalChessGame(G);
			c.repaint();

		}

		if (source.getText() == "EightQueens") {
			SetupEightQueens g = new SetupEightQueens();
			GraphicalEightQueens q = new GraphicalEightQueens(g);

			q.repaint();

		}

		if (source.getText() == "KnightsTour") {
			SetupKnightsTour g = new SetupKnightsTour();
			GraphicalKnightsTour k = new GraphicalKnightsTour(g);
			k.repaint();
		}

		if (source.getText() == "Exit") {
			int n = JOptionPane.showConfirmDialog(frame, "Are You Sure?",
					"Confirm Exit", JOptionPane.YES_NO_OPTION);
			if (n == 0) {
				System.exit(0);
			} else if (n == 1) {

			}
		}
		}
		if (obj instanceof JButton)
		{
			JButton source = (JButton) (obj);
			if (source.getText() == "Play Chess") {
				SetupChess G = new SetupChess();
				GraphicalChessGame c = new GraphicalChessGame(G);
				c.repaint();

			}

			if (source.getText() == "Play Eight Queens") {
				SetupEightQueens g = new SetupEightQueens();
				GraphicalEightQueens q = new GraphicalEightQueens(g);
				q.repaint();

			}

			if (source.getText() == "Play Knights Tour") {
				SetupKnightsTour g = new SetupKnightsTour();
				GraphicalKnightsTour k = new GraphicalKnightsTour(g);
				k.repaint();
			}
		}
		
	}

}
