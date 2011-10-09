package Tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for Tests");
		//$JUnit-BEGIN$
		suite.addTestSuite(KingTest.class);
		suite.addTestSuite(QueenTest.class);
		suite.addTestSuite(PawnTest.class);
		suite.addTestSuite(KnightTest.class);
		suite.addTestSuite(ChessBoardTest.class);
		suite.addTestSuite(RookTest.class);
		suite.addTestSuite(EightQueensTest.class);
		suite.addTestSuite(BishopTest.class);
		suite.addTestSuite(KnightsTourTest.class);
		//$JUnit-END$
		return suite;
	}

}
