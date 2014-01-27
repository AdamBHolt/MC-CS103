import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This JUnit test creates an object of the Team class in order
 * to test its methods.  These tests are in addition to the ones
 * performed by the supplied JUnit test
 */
public class TeamManagerTestStudent 
{
	Team theTeam;
	
	/**
	 * Creates an instance of the Team class and adds players
	 * in order to test the methods of the class
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		theTeam = new Team("Wolverines");
		theTeam.addPlayer("Bob", "Smith", "Center");
		theTeam.addPlayer("Jane", "Doe", "Forward");
		theTeam.addPlayer("Pat", "Peters", "Guard");
	}

	/**
	 * Sets the existing Team object to null in order to reset the
	 * JUnit test between each test
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		theTeam = null;
	}

	/**
	 * Tests the addPlayer method
	 * Test:
	 * 1. Add an additional forward
	 * 2. Add another forward
	 * 		Determines if the correct number of forwards is tracked
	 * 3. Add an additional center
	 * 		Determines if the correct number of centers is tracked
	 * 4. Add an additional guard
	 * 5. Add another guard
	 * 		Determines if the correct number of total players is tracked
	 */
	@Test
	public void testAddPlayer()
	{
		assertEquals(null, theTeam.addPlayer("John", "Jones", "Forward"));
		assertEquals("There are already two forwards on this team\nPlayer not added", theTeam.addPlayer("Tom", "Thumb", "Forward"));
		assertEquals("There is already a center on this team\nPlayer not added", theTeam.addPlayer("Adam", "Holt", "Center"));
		assertEquals(null, theTeam.addPlayer("Wil", "Wheaton", "Guard"));
		assertEquals("There are already 5 members on this team\nPlayer not added", theTeam.addPlayer("John", "Jones", "Guard"));
		//fail("Not yet implemented");
	}

	/**
	 * Tests the getNumPlayers method
	 * Test:
	 * 1. Check if the current number of players is 3
	 * 2. Add a player and check if the current number of players is 4
	 * 3. Add another player and check if the current number of players is 5
	 */
	@Test
	public void testGetNumPlayers()
	{
		assertEquals(3, Team.getNumPlayers());
		theTeam.addPlayer("Jane", "Goodall", "Forward");
		assertEquals(4, Team.getNumPlayers());
		theTeam.addPlayer("Bob", "Barker", "Gurad");
		assertEquals(5, Team.getNumPlayers());
		
		//fail("Not yet implemented");
	}

	/**
	 * Tests the getNumTeams method
	 * Test:
	 * 1. Check that the current number of teams is 4 - due to other objects created during tests
	 * 2. Create a new Team object and test that the number of teams is 5
	 */
	@Test
	public void testGetNumTeams()
	{
		assertEquals(4, Team.getNumTeams());
		new Team();
		assertEquals(5, Team.getNumTeams());
		
		//fail("Not yet implemented");
	}


	/**
	 * Test the printTeam method
	 * Test:
	 * 1. Check that the correct String is being returned
	 * 2. Add a new player and check that the correct String is being returned again
	 */
	@Test
	public void testPrintTeam()
	{
		assertEquals("Wolverines\nBob Smith Position: Center\nJane Doe Position: Forward\nPat Peters Position: Guard\n", theTeam.printTeam());
		theTeam.addPlayer("Adam", "Holt", "Guard");
		assertEquals("Wolverines\nBob Smith Position: Center\nJane Doe Position: Forward\nPat Peters Position: Guard\nAdam Holt Position: Guard\n", theTeam.printTeam());
		
		//fail("Not yet implemented");
	}

	/**
	 * Test the toString method
	 * Test:
	 * 1. Check that the correct String is being returned
	 * 2. Add a new player and check that the correct String is being returned again
	 */
	@Test
	public void testToString()
	{
		assertEquals("Wolverines\nBob Smith Position: Center\nJane Doe Position: Forward\nPat Peters Position: Guard\n", theTeam.printTeam());
		theTeam.addPlayer("Adam", "Holt", "Guard");
		assertEquals("Wolverines\nBob Smith Position: Center\nJane Doe Position: Forward\nPat Peters Position: Guard\nAdam Holt Position: Guard\n", theTeam.printTeam());
		
		//fail("Not yet implemented");
	}
}