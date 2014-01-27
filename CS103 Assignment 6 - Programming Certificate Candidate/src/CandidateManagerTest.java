import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CandidateManagerTest {

	CandidateManager candidatesTest;
	Candidate cand1, cand2, cand3, cand4, cand5;

	CandidateManager studentManager;
	Candidate stud1, stud2, stud3, stud4, stud5, stud6;

	@Before
	public void setUp() throws Exception {
		candidatesTest = new CandidateManager();
		cand1 = new Candidate("Lauren", "Smith", "A", "B", "C", "A", "B", "C");
		cand2 = new Candidate("Bobby", "Brown", "A", "C", "C", "B", "B", "C");
		cand3 = new Candidate("Betty", "Jones", "C", "B", "C", "A", "C", "C");
		cand4 = new Candidate("Felicity", "Mammot", "B", "B", "D", "A", "B", "C");
		cand5 = new Candidate("Eric", "Epstein", "B", "B", "C", "A", "B", "A");


		candidatesTest.addCandidate(cand1);
		candidatesTest.addCandidate(cand2);
		candidatesTest.addCandidate(cand3);
		candidatesTest.addCandidate(cand4);
		candidatesTest.addCandidate(cand5);


		//STUDENT - Create another CandidateManager object, add candidates
		//to your CandidateManager object.  The candidates must be different
		//than those listed above.  Use your CandidateManager object
		//in the STUDENT test below.

		studentManager = new CandidateManager();
		stud1 = new Candidate("Adam", "Holt", "A", "A", "A", "A", "A", "A");
		stud2 = new Candidate("John", "Doe", "B", "D", "F", "C", "A", "A");
		stud3 = new Candidate("Susie", "Student", "B", "C", "A", "B", "C", "B");
		stud4 = new Candidate("Jane", "Dough", "F", "F", "A", "B", "D", "A");
		stud5 = new Candidate("Henry", "Hill", "A", "B", "A", "B", "A", "B");
		stud6 = new Candidate("Tom", "Jerry", "A", "B", "A", "C", "A", "C");

		studentManager.addCandidate(stud1);
		studentManager.addCandidate(stud2);
		studentManager.addCandidate(stud3);
		studentManager.addCandidate(stud4);
		studentManager.addCandidate(stud5);
		studentManager.addCandidate(stud6);

	}

	@After
	public void tearDown() throws Exception {
		cand1=cand2=cand3=cand4=cand5=null;
		candidatesTest=null;
		stud1=stud2=stud3=stud4=stud5=stud6=null;
		studentManager=null;
	}

	@Test
	public void testAddCandidates() {
		assertEquals(5,candidatesTest.getNumCandidates());
		candidatesTest.addCandidate("Alena","Leonova","B", "B", "C", "A", "B", "A");
		assertEquals(6,candidatesTest.getNumCandidates());
		String[][] result = candidatesTest.getcandidates();
		assertEquals("Alena", result[5][0]);
	}

	@Test
	public void testAddCandidatesSTUDENT()
	{
		assertEquals(6,studentManager.getNumCandidates());
		studentManager.addCandidate("Bill", "Smith", "B", "B", "C", "A", "C", "A");
		assertEquals(7,studentManager.getNumCandidates());
		studentManager.addCandidate("Bonnie", "Jones", "A", "A", "A", "A", "C", "A");
		assertEquals(8,studentManager.getNumCandidates());
		String[][] result = studentManager.getcandidates();
		assertEquals("Bonnie", result[7][0]);
		assertEquals("B", result[6][3]);
		//fail("test not yet implemented");
	}

	@Test
	public void testStatus() {
		String[][] results = candidatesTest.getcandidates();
		assertEquals("Eligible", results[0][9]);
		assertEquals("Eligible", results[1][9]);
		assertEquals("Eligible", results[2][9]);
		assertEquals("Ineligible", results[3][9]);
		assertEquals("Honors", results[4][9]);

	}

	@Test
	public void testStatusSTUDENT()
	{
		String[][] result = studentManager.getcandidates();
		assertEquals("Scholarship", result[0][9]);
		assertEquals("Ineligible", result[1][9]);
		assertEquals("Eligible", result[2][9]);
		assertEquals("Ineligible", result[3][9]);
		assertEquals("Scholarship", result[4][9]);
		assertEquals("Honors", result[5][9]);
		//fail("test not yet implemented");
	}

	@Test
	public void testGPA() {
		DecimalFormat fmt1 = new DecimalFormat("#.000");
		String[][] results = candidatesTest.getcandidates();
		assertEquals("3.000", fmt1.format(Double.parseDouble(results[0][8])));
		assertEquals("2.667", fmt1.format(Double.parseDouble(results[1][8])));
		assertEquals("2.500", fmt1.format(Double.parseDouble(results[2][8])));
		assertEquals("2.667", fmt1.format(Double.parseDouble(results[3][8])));
		assertEquals("3.167", fmt1.format(Double.parseDouble(results[4][8])));

	}
	@Test
	public void testGpaSTUDENT()
	{
		DecimalFormat fmt = new DecimalFormat("#.000");
		String[][] result = studentManager.getcandidates();
		assertEquals("4.000", fmt.format(Double.parseDouble(result[0][8])));
		assertEquals("2.333", fmt.format(Double.parseDouble(result[1][8])));
		assertEquals("2.833", fmt.format(Double.parseDouble(result[2][8])));
		assertEquals("2.000", fmt.format(Double.parseDouble(result[3][8])));
		assertEquals("3.500", fmt.format(Double.parseDouble(result[4][8])));
		assertEquals("3.167", fmt.format(Double.parseDouble(result[5][8])));
		//fail("test not yet implemented");
	}

	@Test
	public void testGetcandidates() {
		candidatesTest.addCandidate("Alena","Leonova","B", "B", "C", "A", "B", "A");
		String[][] result = candidatesTest.getcandidates();
		assertEquals("Lauren", result[0][0]);
		assertEquals("Brown", result[1][1]);
		assertEquals("C", result[2][2]);
		assertEquals("B", result[3][3]);
		assertEquals("C", result[4][4]);
		assertEquals("A", result[5][5]);



	}

	@Test
	public void testGetcandidatesSTUDENT()
	{
		studentManager.addCandidate("Bill", "Smith", "B", "B", "C", "A", "C", "A");
		String[][] result = studentManager.getcandidates();
		assertEquals("Adam", result[0][0]);
		assertEquals("Holt", result[0][1]);
		assertEquals("A", result[0][2]);
		assertEquals("D", result[1][3]);
		assertEquals("A", result[2][4]);
		assertEquals("B", result[3][5]);
		assertEquals("A", result[4][6]);
		assertEquals("Smith", result[6][1]);
		
		//fail("test not yet implemented");
	}
}
