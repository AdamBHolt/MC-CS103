import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * This is a JUnit test program to test the Data Manager CurlerTeam.
 * The following classes must be defined and implemented:
 * CurlerPosition - enumeration
 * CurlerPlayer - data element
 * CurlerTeam - data manager
 * @author Professor Myers
 *
 */
public class BasketballTeamTester {

	/**  A Team object reference used for testing */
	Team team;
	
	@Before
	/** This method is run before each individual test
	 *   Creates an object of Team and adds four
	 *   Players to the Team
	 */
	public void setUp() throws Exception {
		team = new Team("Alligators");
		team.addPlayer("John", "Smith","Forward");
		team.addPlayer("Bob", "Brown", "Forward");
		team.addPlayer("Harold", "Jones", "Center");
		
		//STUDENT - Create another Team object, add players
		//to your Team object.  The team name and players must be different
		//than those listed above.  Use YOUR Team object
		//in the STUDENT test below.
		
	}

	@After
	/** This method is run after each individual test
	 *   It sets the team reference to null so the garbage
	 *   collector can reclaim the memory used for the
	 *   Team object
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		team = null;
		
		//STUDENT - tear down YOUR Team object.
	}

	@Test
	/**
	 * Test to 
	 * 1.  check if the number of players is originally 3
	 * 2.  Add another player, and check if number of players is 4
	 * 
	 */
	public void testGetNumPlayers() {
		assertEquals(3,Team.getNumPlayers());
		team.addPlayer("George", "Jones", "Guard");
		assertEquals(4, Team.getNumPlayers());
		team.addPlayer("Susie", "Smith", "Guard");
		assertEquals(5, Team.getNumPlayers());
	}
	
	@Test
	/**
	 * Test to
	 * 1.  add a new player as a forward
	 *     check if recognizes there is already a forward on the team
	 * 2.  add a new player as a center
	 *     check if recognizes there is already a center on the team
	 * 3.  add new player as a sweeper - player is added
	 */
	public void testAddPlayer() {
		String result;
		result = team.addPlayer("Susie", "Smith", "Forward");
		assertEquals("There are already two forwards on this team\nPlayer not added", result);
		result = team.addPlayer("Susie", "Smith", "Center");
		assertEquals("There is already a center on this team\nPlayer not added", result);
	}

	@Test
	/**
	 * Test to:
	 * 1.  Check if the team name is on the first line
	 * 2.  Check if Harold is on the forth line
	 */
	public void testPrintTeam() {
		String result = team.printTeam();
		Scanner team = new Scanner(result);
		assertEquals("Alligators",team.nextLine()); 
		//extract three team players
		team.nextLine();  //John Smith     Position guard
		team.nextLine();  //Bob Brown     Position forward
		assertEquals("Harold",team.next()); //Harold
	}
}