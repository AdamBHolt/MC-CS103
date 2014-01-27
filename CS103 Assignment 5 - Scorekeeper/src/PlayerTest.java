import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * This JUnit test creates objects of the Player class
 * in order to test its methods
 */
public class PlayerTest {

	Player player1;
	Player player2;
	Player player3;
	
	//Creates three Player objects to use in tests
	@Before
	public void setUp() throws Exception
	{
		player1 = new Player ("Tom", "Jones", "Forward");
		player2 = new Player ("Maggie", "Smith", "Center");
		player3 = new Player ("Judge", "Reinhold", "Guard");
	}

	//Sets the Player objects to null between each test
	@After
	public void tearDown() throws Exception
	{
		player1=player2=player3=null;
	}

	/**
	 * Tests the toString method
	 * Test:
	 * 1. Test for the expected String for each player
	 */
	@Test
	public void testToString()
	{
		assertEquals("Tom Jones Position: Forward", player1.toString());
		assertEquals("Maggie Smith Position: Center", player2.toString());
		assertEquals("Judge Reinhold Position: Guard", player3.toString());
		
		//fail("Not yet implemented");
	}

	/**
	 * Tests the setFName method
	 * Test:
	 * 1. Check the first name of each player
	 * 2. Change the first name of each player
	 * 3. Check that the new first name is correct
	 */
	@Test
	public void testSetFName()
	{
		assertEquals("Tom", player1.getFName());
		assertEquals("Maggie", player2.getFName());
		assertEquals("Judge", player3.getFName());
		
		player1.setFName("Don");
		player2.setFName("Judy");
		player3.setFName("Ron");
		
		assertEquals("Don", player1.getFName());
		assertEquals("Judy", player2.getFName());
		assertEquals("Ron", player3.getFName());
		
		//fail("Not yet implemented");
	}

	/**
	 * Tests the getFName method
	 * Test:
	 * 1. Check the first name of each player
	 */
	@Test
	public void testGetFName() {
		assertEquals("Tom", player1.getFName());
		assertEquals("Maggie", player2.getFName());
		assertEquals("Judge", player3.getFName());
		
		//fail("Not yet implemented");
	}

	/**
	 * Tests the setLName method
	 * Test:
	 * 1. Check the last name of each player
	 * 2. Change the last name of each player
	 * 3. Check that the new last name is correct
	 */
	@Test
	public void testSetLName() {
		assertEquals("Jones", player1.getLName());
		assertEquals("Smith", player2.getLName());
		assertEquals("Reinhold", player3.getLName());
		
		player1.setLName("Brady");
		player2.setLName("Maggee");
		player3.setLName("Judy");
		
		assertEquals("Brady", player1.getLName());
		assertEquals("Maggee", player2.getLName());
		assertEquals("Judy", player3.getLName());
		
		//fail("Not yet implemented");
	}

	/**
	 * Tests the getLName method
	 * Test:
	 * 1. Check the last name of each player
	 */
	@Test
	public void testGetLName() {
		assertEquals("Jones", player1.getLName());
		assertEquals("Smith", player2.getLName());
		assertEquals("Reinhold", player3.getLName());
		
		//fail("Not yet implemented");
	}

	/**
	 * Tests the setPosition method
	 * Test:
	 * 1. Check the position of each player
	 * 2. Change the position of each player
	 * 3. Check that the new position is correct
	 */
	@Test
	public void testSetPosition() {
		assertEquals(Position.FORWARD, player1.getPosition());
		assertEquals(Position.CENTER, player2.getPosition());
		assertEquals(Position.GUARD, player3.getPosition());
		
		player1.setPosition("Guard");
		player2.setPosition("Forward");
		player3.setPosition("Center");
		
		assertEquals(Position.GUARD, player1.getPosition());
		assertEquals(Position.FORWARD, player2.getPosition());
		assertEquals(Position.CENTER, player3.getPosition());
		
		//fail("Not yet implemented");
	}

	/**
	 * Tests the getPosition method
	 * Test:
	 * 1. Check the position of each player
	 */
	@Test
	public void testGetPosition() {
		assertEquals(Position.FORWARD, player1.getPosition());
		assertEquals(Position.CENTER, player2.getPosition());
		assertEquals(Position.GUARD, player3.getPosition());
		
		//fail("Not yet implemented");
	}
}