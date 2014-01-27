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
 * @author JMYERS modified by Adam Holt
 *
 */
public class StudentDataManagerTest {

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
	studentManager = new DataManager();
	studentManager.reset();
	readCustomerFile();
	readOrderFile();

	//STUDENT - use a different DataManager.  You may read in your own customerSTUDENT and orderSTUDENT file or
	// you may add the customers and orders manually in this setUp method.
    }

    @After
    public void tearDown() throws Exception {
	studentManager = null;
	//STUDENT - tear down your DataManager
    }

    @Test
    public void testChangeInDiscountLevelSTUDENT()
    {
	String result="";
	Scanner scan;

	//Discount will be 0% fore this sale but raised to 6% after $1000 is added to previous purchases
	assertEquals(true,studentManager.addOrder(101, 1000.00));
	result=studentManager.getDetailsOfLastOrder();
	scan = new Scanner(result);

	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("1005", scan.next()); //Current order number
	scan.nextLine(); //Skip line
	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("101", scan.next()); //Customer number
	scan.nextLine(); //Skip line
	scan.nextLine(); //Skip line
	scan.next(); //Skip first part of the line
	assertEquals("0%", scan.next()); //Current discount
	scan.nextLine(); //Skip the rest of the line
	scan.close();

	//Discount for this sale will be 6% but raised to 10% after $1000 more is added to the previous purchases
	assertEquals(true, studentManager.addOrder(101, 1000.00));
	result=studentManager.getDetailsOfLastOrder();
	scan = new Scanner(result);

	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("1006", scan.next()); //Current order number
	scan.nextLine(); //Skip line
	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("101", scan.next()); //Customer number
	scan.nextLine(); //Skip line
	scan.nextLine(); //Skip line
	scan.next(); //Skip first part of the line
	assertEquals("6%", scan.next()); //Current discount
	scan.nextLine(); //Skip the rest of the line
	scan.close();

	//Discount for this sale will be 10%
	assertEquals(true, studentManager.addOrder(101, 1000.00));
	result=studentManager.getDetailsOfLastOrder();
	scan = new Scanner(result);

	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("1007", scan.next()); //Current order number
	scan.nextLine(); //Skip line
	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("101", scan.next()); //Customer number
	scan.nextLine(); //Skip line
	scan.nextLine(); //Skip line
	scan.next(); //Skip first part of the line
	assertEquals("10%", scan.next()); //Current discount
	scan.nextLine(); //Skip the rest of the line
	scan.close();
    }


    @Test
    public void testAddOrderSTUDENT()
    {
	//Valid customer numbers
	assertEquals(true, studentManager.addOrder(102, 654.32));
	assertEquals(true, studentManager.addOrder(101, 123.45));
	//Invalid customer numbers
	assertEquals(false, studentManager.addOrder(105, 100.00));
	assertEquals(false, studentManager.addOrder(106, 1000.00));
    }

    @Test
    public void testAddCustomerSTUDENT()
    {
	String result="";
	Scanner scan;

	//105 is an invalid customer number
	assertEquals(false, studentManager.addOrder(105, 1000.00));

	assertEquals(105,studentManager.addCustomer("Marvin", "Android", "123 Millie Way, End of the Universe", 123.45));

	//Now 105 is valid
	assertEquals(true, studentManager.addOrder(105, 555.55));
	result=studentManager.getDetailsOfLastOrder();
	scan = new Scanner(result);

	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("1005", scan.next());
	scan.nextLine(); //Skip line
	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("105", scan.next());
	assertEquals("Android,", scan.next());
	assertEquals("Marvin", scan.next());
	scan.nextLine(); //Skip line
	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("$555.55",scan.next());
	scan.nextLine(); //Skip line
	scan.next(); //Skip first part of the line
	assertEquals("0%", scan.next());
	scan.nextLine(); //Skip line
	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("$33.33", scan.next());
	scan.nextLine(); //Skip line
	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("$588.88", scan.next());
	scan.close();
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

	    studentManager.addCustomer(cust[0], cust[1], cust[2],Double.parseDouble(cust[3]));
	}
	scan.close();
    }

    public void readOrderFile() throws FileNotFoundException
    {
	Scanner scan = new Scanner(orderFile);
	while(scan.hasNext())
	{
	    String[] ord = scan.nextLine().split(";");

	    studentManager.addOrder(Integer.parseInt(ord[0]),Double.parseDouble(ord[1]));
	}
	scan.close();
    }
}