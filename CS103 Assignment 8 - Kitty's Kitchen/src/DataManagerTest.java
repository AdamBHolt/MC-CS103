import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This is to be used with the following data files: customers.txt and orders.txt.  These are semicolon
 * separated field files, or you can create these data files in Notepad:
 * 
 * <p>customers.txt:
 * <p>Katniss;Everdeen;86 Hopeless Dr, The Seam;23.56;
 * <p>Peeta;Mellark;215 Main St, Town Square;217.45;
 * <p>Gale;Hawthorne;724 Despair Ct, The Seam;111.33;
 * <p>Haymitch;Abernathy;32 Winners Row, Victor's Village;836.23;
 * <p>Coriolanus;Snow;President's Mansion, The Capitol;2469.21;
 * <p>Effie;Trinket;654 High Society Blvd, The Capitol;1828.52;
 * 
 * <p>orders.txt:
 * <p>103;54.77;
 * <p>105;369.33;
 * <p>106;865.29;
 * <p>104;974.19;
 * 
 * 
 * @author JMYERS
 *
 */
public class DataManagerTest {
	DataManager manager;
	DataManager studentManager;
	static File customerFile;
	static File orderFile;
	
	/**
	 * This method allows you to choose the customers.txt and orders.txt, before any test are run.  Only need to be selected once
	 * no matter how many tests are to be run
	 * @throws Exception
	 */
	@BeforeClass
	public static void oneTimeSetUp() throws Exception {
		chooseCustomersFile();
		chooseOrdersFile();
	}
	
	/**
	 * This method is run right before any @Test method.  It determines that each @Test method
	 * is using the same initial set of data
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		manager = new DataManager();
		studentManager = new DataManager();
		manager.reset();
		studentManager.reset();
		readCustomerFile();
		readOrderFile();
	
		//STUDENT - use a different DataManager.  You may read in your own customerSTUDENT and orderSTUDENT file or
		// you may add the customers and orders manually in this setUp method.
	}

	@After
	public void tearDown() throws Exception {
		manager = null;
		studentManager = null;
		//STUDENT - tear down your DataManager
	}

	@Test
	public void testChangeInDiscountLevel()
	{
		String result="";
		Scanner scan;
		// currently Peeta, cust 102, has purchases of 217.45, there should be no discount
		assertEquals(true,manager.addOrder(102, 280.56));
		result=manager.getDetailsOfLastOrder();
		scan = new Scanner(result);
		scan.next(); /*Order*/ scan.next(); //#:
		assertEquals("1005", scan.next()); /*1005*/ scan.nextLine(); //discard newline
		scan.next(); /*Customer*/  scan.next(); //#:
		assertEquals("102", scan.next()); /*102*/  scan.nextLine(); //discard newline
		scan.nextLine(); //Purchase amount: $280.56
		scan.next(); /*Discount:*/
		assertEquals("0%", scan.next()); /*0%*/  scan.nextLine(); //discard rest of line
		
		
		// currently Peeta, cust 102, has purchases of 468.01, there should be no discount
		assertEquals(true, manager.addOrder(102, 165.99));
		result=manager.getDetailsOfLastOrder();
		scan = new Scanner(result);
		scan.next(); /*Order*/ scan.next(); //#:
		assertEquals("1006", scan.next()); /*1006*/ scan.nextLine(); //discard newline
		scan.next(); /*Customer*/  scan.next(); //#:
		assertEquals("102", scan.next()); /*102*/  scan.nextLine(); //discard newline
		scan.nextLine(); //Purchase amount: $165.99
		scan.next(); /*Discount:*/
		assertEquals("0%", scan.next()); /*0%*/  scan.nextLine(); //discard rest of line
		
		// currently Peeta, cust 102, has purchases of 634.00, there should be a discount of 5%
		assertEquals(true,manager.addOrder(102,89.99));
		result=manager.getDetailsOfLastOrder();
		scan = new Scanner(result);
		scan.next(); /*Order*/ scan.next(); //#:
		assertEquals("1007", scan.next()); /*1007*/ scan.nextLine(); //discard newline
		scan.next(); /*Customer*/  scan.next(); //#:
		assertEquals("102", scan.next()); /*102*/  scan.nextLine(); //discard newline
		scan.nextLine(); //Purchase amount: $89.99
		scan.next(); /*Discount:*/
		assertEquals("5%", scan.next()); /*5%*/  scan.nextLine(); //discard rest of line
	}
	
	@Test
	public void testAddOrderCorrectCustNum() {
		String result="";
		Scanner scan;
		// currently Peeta, cust 102, has purchases of 217.45, there should be no discount
		assertEquals(true,manager.addOrder(102, 280.56));
		result=manager.getDetailsOfLastOrder();
		scan = new Scanner(result);
		scan.next(); /*Order*/ scan.next(); //#:
		assertEquals("1005", scan.next()); /*1005*/ scan.nextLine(); //discard newline
		scan.next(); /*Customer*/ scan.next(); //#:
		assertEquals("102", scan.next()); /*102*/  scan.nextLine(); //discard newline
		scan.next(); /*Purchase*/  scan.next(); //amount:
		assertEquals("$280.56",scan.next()); /*$280.56*/ scan.nextLine(); //discard newline
		scan.next(); /*Discount:*/
		assertEquals("0%", scan.next()); /*0%*/  scan.nextLine(); //discard rest of line
		scan.next(); /*Tax:*/
		assertEquals("6%", scan.next()); /*6%*/
		assertEquals("$16.83", scan.next()); /*$16.83*/  scan.nextLine(); //discard rest of line
		scan.next(); /*Final*/  scan.next(); //cost:
		assertEquals("$297.39", scan.next()); /*$297.39*/

		// currently Effie, cust 106, has purchases of > 2000, there should be a 10% discount
		assertEquals(true, manager.addOrder(106, 280.56));
		result=manager.getDetailsOfLastOrder();
		scan = new Scanner(result);
		scan.next(); /*Order*/ scan.next(); //#:
		assertEquals("1006", scan.next()); /*1005*/ scan.nextLine(); //discard newline
		scan.next(); /*Customer*/ scan.next(); //#:
		assertEquals("106", scan.next()); /*102*/  scan.nextLine(); //discard newline
		scan.next(); /*Purchase*/  scan.next(); //amount:
		assertEquals("$280.56",scan.next()); /*$280.56*/ scan.nextLine(); //discard newline
		scan.next(); /*Discount:*/
		assertEquals("10%", scan.next()); /*10%*/  
		assertEquals("$28.06", scan.next()); /*$28.06*/ scan.nextLine(); //discard rest of line
		scan.next(); /*Tax:*/
		assertEquals("6%", scan.next()); /*6%*/
		assertEquals("$15.15", scan.next()); /*$15.15*/  scan.nextLine(); //discard rest of line
		scan.next(); /*Final*/  scan.next(); //cost:
		assertEquals("$267.65", scan.next()); /*$267.65*/
	}

	@Test
	public void testAddOrderIncorrectCustNum() {
		//105 is a legitimate customer number
		assertEquals(true, manager.addOrder(105, 280.56));
		//107 is not a correct customer number (currently only 101 - 106 are valid)
		assertEquals(false, manager.addOrder(107, 280.56));
		
	}
	
	@Test
	public void testGetCustomerNumber()
	{
		//Coriolanus Snow is a legitimate customer
		assertEquals(105, manager.getCustomerNumber("Coriolanus","Snow"));
		//Abby Normal is not a current customer
		assertEquals(-1, manager.getCustomerNumber("Abby", "Normal"));
	}
	
	@Test
	public void testAddCustomer() {
		String result="";
		Scanner scan;
		
		//107 is not a correct customer number (currently only 101 - 106 are valid)
		assertEquals(false, manager.addOrder(107, 280.56));
		
		assertEquals(107,manager.addCustomer("Charlie", "Swan", "1515 Twilight Terrace, Forks, WA", 887.87));
		
		//107 is now a correct customer number (currently 101 - 107 are valid)
		assertEquals(true, manager.addOrder(107, 280.56));
		result=manager.getDetailsOfLastOrder();
		scan = new Scanner(result);
		scan.next(); /*Order*/ scan.next(); //#:
		assertEquals("1005", scan.next()); /*1005*/ scan.nextLine(); //discard newline
		scan.next(); /*Customer*/ scan.next(); //#:
		assertEquals("107", scan.next()); /*102*/  
		assertEquals("Swan,", scan.next()); /*Swan,*/scan.nextLine(); //discard newline
		scan.next(); /*Purchase*/  scan.next(); //amount:
		assertEquals("$280.56",scan.next()); /*$280.56*/ scan.nextLine(); //discard newline
		scan.next(); /*Discount:*/
		assertEquals("5%", scan.next()); /*5%*/  
		assertEquals("$14.03",scan.next()); /*$14.03*/ scan.nextLine(); //discard rest of line
		scan.next(); /*Tax:*/
		assertEquals("6%", scan.next()); /*6%*/
		assertEquals("$15.99", scan.next()); /*$15.99*/  scan.nextLine(); //discard rest of line
		scan.next(); /*Final*/  scan.next(); //cost:
		assertEquals("$282.52", scan.next()); /*$282.52*/
		
	}
	
	public static void chooseCustomersFile() throws FileNotFoundException
	{
		JOptionPane.showMessageDialog(null, "Choose a Customers text file");
		JFileChooser cf = new JFileChooser();
		cf.showOpenDialog(null);   		//show file chooser for dictionary
		customerFile = cf.getSelectedFile();
	}
	
	public static void chooseOrdersFile() throws FileNotFoundException
	{
		JOptionPane.showMessageDialog(null, "Choose an Orders text file");
		JFileChooser cf = new JFileChooser();
		cf.showOpenDialog(null);   		//show file chooser for dictionary
		orderFile = cf.getSelectedFile();
	}
	
	public void readCustomerFile() throws FileNotFoundException
	{
		Scanner scan = new Scanner(customerFile);
		while(scan.hasNext())
		{
			String[] cust = scan.nextLine().split(";");
			
			manager.addCustomer(cust[0], cust[1], cust[2],Double.parseDouble(cust[3]));

		}
		scan.close();
	}

	public void readOrderFile() throws FileNotFoundException
	{
		Scanner scan = new Scanner(orderFile);
		while(scan.hasNext())
		{
			String[] ord = scan.nextLine().split(";");
			
			manager.addOrder(Integer.parseInt(ord[0]),Double.parseDouble(ord[1]));
		}
		scan.close();
	}
}
