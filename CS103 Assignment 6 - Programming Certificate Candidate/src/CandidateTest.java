import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class provides tests for the Candidate class
 * @date 11/6/13
 * @author Adam Holt
 */
public class CandidateTest {

	//Candidate objects to be tested
	Candidate cand1, cand2;

	/**
	 * Pre-test setup
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		cand1 = new Candidate("Adam", "Holt", "A", "A", "A", "A", "A", "A");
		cand2 = new Candidate("Susie", "Smith", "B", "C", "A", "B", "C", "B");
	}

	/**
	 * Post-test cleanup
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		cand1=cand2=null;
	}

	@Test
	/**
	 * Tests that the last name is returned correctly before and after modification
	 */
	public void testSetLName() {
		assertEquals("Holt", cand1.getLName());
		cand1.setLName("Jones");
		assertEquals("Jones", cand1.getLName());

		assertEquals("Smith", cand2.getLName());
		cand2.setLName("Clark");
		assertEquals("Clark", cand2.getLName());

		//fail("Not yet implemented");
	}

	/**
	 * Tests that the last name is returned correctly
	 */
	@Test
	public void testGetLName() {
		assertEquals("Holt", cand1.getLName());
		assertEquals("Smith", cand2.getLName());

		//fail("Not yet implemented");
	}

	/**
	 * Tests that the first name is returned correctly before and after modification
	 */
	@Test
	public void testSetFName() {
		assertEquals("Adam", cand1.getFName());
		cand1.setFName("Josh");
		assertEquals("Josh", cand1.getFName());

		assertEquals("Susie", cand2.getFName());
		cand2.setFName("Sally");
		assertEquals("Sally", cand2.getFName());

		//fail("Not yet implemented");
	}

	/**
	 * Tests that the first name is returned correctly
	 */
	@Test
	public void testGetFName() {
		assertEquals("Adam", cand1.getFName());
		assertEquals("Susie", cand2.getFName());

		//fail("Not yet implemented");
	}

	/**
	 * Tests whether expected grades are returned
	 * Sets new grades and tests that the new grades are returned
	 */
	@Test
	public void testSetGrades() {
		String[] grades1 = cand1.getGrades();
		String[] grades2 = cand2.getGrades();

		assertEquals("A", grades1[0]);
		assertEquals("A", grades1[5]);
		assertEquals("B", grades2[0]);
		assertEquals("B", grades2[5]);
		
		cand1.setGrades("B", "B", "B", "B", "B", "B");
		cand2.setGrades("C", "B", "A", "D", "F", "A");
		
		assertEquals("B", grades1[0]);
		assertEquals("B", grades1[5]);
		assertEquals("C", grades2[0]);
		assertEquals("A", grades2[5]);
		
		//fail("Not yet implemented");
	}

	/**
	 * Tests whether expected grades are returned
	 */
	@Test
	public void testGetGrades() {
		String[] grades1 = cand1.getGrades();
		String[] grades2 = cand2.getGrades();

		assertEquals("A", grades1[0]);
		assertEquals("A", grades1[5]);
		
		assertEquals("B", grades2[0]);
		assertEquals("B", grades2[5]);
		
		//fail("Not yet implemented");
	}

	/**
	 * Tests that the expected GPA value is returned
	 * Sets new grades and tests that the new GPA is returned
	 */
	@Test
	public void testGetGPA() {
		
		assertEquals(4.000,cand1.getGPA(),.001);
		assertEquals(2.833,cand2.getGPA(),.001);
		
		cand1.setGrades("B", "B", "B", "B", "B", "B");
		cand2.setGrades("C", "B", "A", "D", "F", "A");
		
		assertEquals(3.000,cand1.getGPA(),.001);
		assertEquals(2.333,cand2.getGPA(),.001);
		
		//fail("Not yet implemented");
	}

	/**
	 * Tests whether the expected graduation status is returned
	 * Sets new grades and tests that the new status is returned
	 */
	@Test
	public void testCheckStatus() {
		
		assertEquals("Scholarship", cand1.checkStatus());
		assertEquals("Eligible", cand2.checkStatus());
		
		cand1.setGrades("B", "B", "B", "B", "B", "B");
		cand2.setGrades("C", "B", "A", "D", "F", "A");
		
		assertEquals("Eligible", cand1.checkStatus());
		assertEquals("Ineligible", cand2.checkStatus());
		
		//fail("Not yet implemented");
	}

	/**
	 * Tests whether the expected String value of each object is returned
	 */
	@Test
	public void testToString() {
		assertEquals("Adam Holt CS110: A CS140: A CS226: A CS249: A CS213: A CS214: A Average GPA: 4.000 Status: Scholarship", cand1.toString());
		assertEquals("Susie Smith CS110: B CS140: C CS226: A CS249: B CS213: C CS214: B Average GPA: 2.833 Status: Eligible", cand2.toString());
		
		//fail("Not yet implemented");
	}
}