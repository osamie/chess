package pack;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;

public class MoveHistory {
	Stack<ChessBoard> UndoStack;
	Stack<ChessBoard> RedoStack;
	Stack<Move> UndoStack2;
	Stack<Move> RedoStack2;
	Stack<Point> UndoStack3;
	Stack<Point> RedoStack3;
	
	public MoveHistory() {
		UndoStack = new Stack<ChessBoard>(); 
		RedoStack = new Stack<ChessBoard>();
		UndoStack2 = new Stack<Move>(); 
		RedoStack2 = new Stack<Move>();
		UndoStack3 = new Stack<Point>(); 
		RedoStack3 = new Stack<Point>();
	}

	public Stack<Move> getUndoStack2() {
		return UndoStack2;
	}

	public Stack<Move> getRedoStack2() {
		return RedoStack2;
	}
	
	public Stack<Point> getRedoStack3() {
		return RedoStack3;
	}

	public Stack<Point> getUndoStack3() {
		return UndoStack3;
	}

	public Stack<ChessBoard> getUndoStack() {
		return UndoStack;
	}
	public Stack<ChessBoard> getRedoStack() {
		return  RedoStack;
	}

	public static void saveObject (ChessBoard c, String filename) throws IOException {
	        ObjectOutputStream objstream = new ObjectOutputStream(new FileOutputStream(filename));
	        objstream.writeObject(c);
	        objstream.close();
	    }
	 
	    /**
	     * Loads an object.
	     */
	    public static ChessBoard loadObject(String filename) throws ClassNotFoundException, IOException {
	        ObjectInputStream objstream = new ObjectInputStream(new FileInputStream(filename));
	        ChessBoard c = (ChessBoard) objstream.readObject();
	        objstream.close();
	        return c;
	    }

}
