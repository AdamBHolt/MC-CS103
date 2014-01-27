import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {

	private GradeBook book1, book2, book3;
	
	@Before
	public void setUp() throws Exception {
		book1 = new GradeBook(5);
		book2 = new GradeBook(5);
		book3 = new GradeBook(5);
		
		book1.addScore(100.0);
		book1.addScore(75.0);
		book1.addScore(25.0);
		
		book2.addScore(75.0);
		book2.addScore(50.0);
		book2.addScore(10.0);
	}

	@After
	public void tearDown() throws Exception {
		book1=book2=null;
	}

	@Test
	public void testAddScore() {
	    	assertTrue(book1.toString().equals("100.0 75.0 25.0 "));
	    	assertTrue(book2.toString().equals("75.0 50.0 10.0 "));
	    	assertEquals(3,book1.getScoresSize());
	    	assertEquals(3,book2.getScoresSize());
		assertTrue(book1.addScore(50.0));
		assertTrue(book1.addScore(75.00));
		assertFalse(book1.addScore(100.00));
		//fail("Not yet implemented");
	}

	@Test
	public void testSum() {
		assertEquals(200.00, book1.sum(), .001);
		assertEquals(135.00, book2.sum(), .001);
		//fail("Not yet implemented");
	}

	@Test
	public void testMinimum() {
		assertEquals(25.00, book1.minimum(), .001);
		assertEquals(10.00, book2.minimum(), .001);
		//fail("Not yet implemented");
	}

	@Test
	public void testFinalScore() {
		assertEquals(175.00, book1.finalScore(), .001);
		assertEquals(125.00, book2.finalScore(), .001);
		assertEquals(0.0, book3.finalScore(), .001);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetScoresSize() {
		assertEquals(3,book1.getScoresSize());
		assertEquals(3,book2.getScoresSize());
		//fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		assertTrue(book1.toString().equals("100.0 75.0 25.0 "));
		assertTrue(book2.toString().equals("75.0 50.0 10.0 "));
		//fail("Not yet implemented");
	}
}