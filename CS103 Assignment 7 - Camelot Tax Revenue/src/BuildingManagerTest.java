import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BuildingManagerTest {
	BuildingManager buildings, studentBuildings;
	House house;
	Store store;
	Community community;
	OtherBuilding other;

	@Before
	public void setUp() throws Exception {
		buildings = new BuildingManager();
		buildings.addBuilding(2,"Neville", 155.75, 44444, 3);
		buildings.addBuilding(4,"Argus", 12.50,22222,0);
		buildings.addBuilding(3,"Colin", 1200.00,11111,0);
		buildings.addBuilding(1,"Katie", 92.32,33333,0);
		community = new Community("Colin", 11111, 1200.00);
		other = new OtherBuilding("Argus", 22222, 12.50);
		house = new House("Katie", 33333, 92.32);
		store = new Store("Neville", 44444, 155.75, 3);
		
		// STUDENT:  create an other BuildingManager object.  Add some
		// buildings to your BuildingManager.  They must be different than
		// the data used in the buildings object.  Use your BuildingManager object
		// for the Student Tests.
		studentBuildings = new BuildingManager();
		studentBuildings.addBuilding(1, "Fake", 213.35, 123, 0);
		studentBuildings.addBuilding(2, "Pretend", 1500.00, 54321, 600);
		studentBuildings.addBuilding(3, "Nowhere", 100.00, 42, 0);
		studentBuildings.addBuilding(4, "Elsewhere", 550.00, 999, 0);
	}

	@After
	public void tearDown() throws Exception {
		buildings = null;
		community = null; other = null; 
		house = null; store = null;
		
		// STUDENT: tear down the objects you created in setUp
		studentBuildings = null;
	}

	/**
	 * Test the addBuilding method
	 */
	@Test
	public void testAddBuilding() {
		assertEquals(1,buildings.getNumStore());
		assertEquals(1,buildings.getNumCommunity());
		buildings.addBuilding(3,"Bob", 1252.50,11100,0);
		assertEquals(1,buildings.getNumStore());
		assertEquals(2,buildings.getNumCommunity());
	}
	
	@Test
	public void testAddBuildingSTUDENT() {
		assertEquals(1,studentBuildings.getNumHouse());
		assertEquals(1,studentBuildings.getNumOtherBuilding());
		studentBuildings.addBuilding(1,"There", 200.0,50,0);
		studentBuildings.addBuilding(1,"Elm", 600.0,2510,0);
		studentBuildings.addBuilding(4,"Security", 10.0,555,0);
		assertEquals(3,studentBuildings.getNumHouse());
		assertEquals(2,studentBuildings.getNumOtherBuilding());	
	}

	/**
	 * Test the CalculateTotalTaxes method
	 */
	@Test
	public void testCalculateTotalTaxes() {
		assertEquals(12931.675, buildings.calculateTotalTax(), .001);
	}

	@Test
	public void testCalculateTotalTaxesSTUDENT() {
		assertEquals(29250.25, studentBuildings.calculateTotalTax(), .001);
	}
	
	/**
	 * Test the getNumStore method
	 */
	@Test
	public void testGetNumStore() {
		assertEquals(1, buildings.getNumStore());
		buildings.addBuilding(2,"Bob", 1252.50,11100,0);
		assertEquals(2, buildings.getNumStore());
	}

	/**
	 * Test the getNumCommunity method
	 */
	@Test
	public void testGetNumCommunity() {
		assertEquals(1, buildings.getNumCommunity());
		buildings.addBuilding(3,"Bob", 1252.50,11100,0);
		assertEquals(2, buildings.getNumCommunity());
	}

	/**
	 * Test the getNumHouse method
	 */
	@Test
	public void testGetNumHouse() {
		assertEquals(1, buildings.getNumHouse());
		buildings.addBuilding(1,"Bob", 1252.50,11100,0);
		assertEquals(2, buildings.getNumHouse());
	}

	/**
	 * Test the getNumOtherBuildings method
	 */
	@Test
	public void testGetNumOtherBuildings() {
		assertEquals(1, buildings.getNumOtherBuilding());
		buildings.addBuilding(4,"Bob", 1252.50,11100,0);
		assertEquals(2, buildings.getNumOtherBuilding());
	}

	/**
	 * Test the sort method
	 */
	@Test
	public void testSort() {
		assertEquals("Neville", buildings.getFirstBuilding().getStreetAddress());
		buildings.sort();
		assertEquals("Colin", buildings.getFirstBuilding().getStreetAddress());
		buildings.addBuilding(3,"Bob", 1252.50,11100,0);
		buildings.sort();
		assertEquals("Bob", buildings.getFirstBuilding().getStreetAddress());

	}
	
	@Test
	public void testSortSTUDENT() {
		assertEquals("Fake", studentBuildings.getFirstBuilding().getStreetAddress());
		studentBuildings.sort();
		assertEquals("Nowhere", studentBuildings.getFirstBuilding().getStreetAddress());
		studentBuildings.addBuilding(4,"Security",10.0,1,0);
		studentBuildings.sort();
		assertEquals("Security", studentBuildings.getFirstBuilding().getStreetAddress());
		
	}
	
	/**
	 * Test the generateTaxReport
	 */
	@Test
	public void testGenerateTaxReport() {
		String result = buildings.generateTaxReport();
		Scanner report = new Scanner(result);
		report.nextLine(); //Tax REPORT FOR Camelot
		report.nextLine();  //empty line
		report.nextLine();  //BUILDING       TAXES
		assertEquals("11111",report.next()); //11111
		report.next(); //Colin
		assertEquals("$9,600.00",report.next()); //$9600
		report.nextLine();//
		assertEquals("22222",report.next()); //22222
		report.nextLine();
		assertEquals("33333",report.next()); //33333
		report.nextLine();
		assertEquals("44444",report.next()); //44444
		buildings.addBuilding(3,"Bob", 1252.50,11100,0);
		report.close();
		result = buildings.generateTaxReport();
		report = new Scanner(result);
		report.nextLine(); //Tax REPORT FOR Camelot
		report.nextLine();  //empty line
		report.nextLine();  //BUILDING       TAXES
		assertEquals("11100",report.next()); //11100
		report.nextLine(); 
		assertEquals("11111",report.next()); //11111
	}
	
	@Test
	public void testGenerateTaxReportSTUDENT() {
		String result = studentBuildings.generateTaxReport();
		Scanner report = new Scanner(result);
		report.nextLine();
		report.nextLine();
		report.nextLine();
		assertEquals("42",report.next());
		assertEquals("Nowhere",report.next());
		assertEquals("$800.00",report.next());
		assertEquals("123",report.next());
		assertEquals("Fake",report.next());
		assertEquals("$3,200.25",report.next());
		
		studentBuildings.addBuilding(2,"Main", 500.00,11,600);
		report.close();
		result = studentBuildings.generateTaxReport();
		report = new Scanner(result);
		report.nextLine();
		report.nextLine();
		report.nextLine();
		assertEquals("11",report.next());
		assertEquals("Main",report.next());
		assertEquals("$7,500.00",report.next());
		assertEquals("42",report.next());
		assertEquals("Nowhere",report.next());
		assertEquals("$800.00",report.next());
		report.close();
	}
}
