import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class test the methods of the CustomerManager class
 * @author Adam Holt
 * @date 12/4/13
 *
 */
public class CustomerManagerTest
{
    CustomerManager manager;
    
    @Before
    public void setUp() throws Exception
    {
	manager = new CustomerManager();
	
	manager.addCustomer("Ford", "Prefect", "42 Mostly Harmless Dr., Betelgeuse", 250.00);
	manager.addCustomer("Arthur", "Dent", "123 Fake St., England", 0.0);
	manager.addCustomer("Trisha", "McMillian", "555 Main St., Earth", 1253.65);
	manager.addCustomer("Zaphod", "Beeblebrox", "666 Heart of Gold Ln., The Galaxy", 2235.52);
    }

    @After
    public void tearDown() throws Exception
    {
	manager = null;
    }

    /**
     * Tests the method to add new customers
     */
    @Test
    public void testAddCustomer()
    {
	assertEquals(105, manager.addCustomer("Marvin", "Android", "321 Millie Way, The End of The Universe", 654.32));
	assertEquals(106, manager.addCustomer("Adam", "Holt", "111 Main Street, College Park, MD", 123.45));
    }

    /**
     * Tests the method to get a customer using the customer number
     */
    @Test
    public void testGetCustomer()
    {
	//Valid customers
	assertEquals("Zaphod", manager.getCustomer(104).getFirstName());
	assertEquals("Prefect", manager.getCustomer(101).getLastName());
	//Customer does not exist
	assertEquals(null, manager.getCustomer(105));
	assertEquals(105, manager.addCustomer("Marvin", "Android", "321 Millie Way, The End of The Universe", 654.32));
	//Customer is now valid
	assertEquals("Marvin", manager.getCustomer(105).getFirstName());
	
    }

    /**
     * Tests the method to manually set the next customer number
     */
    @Test
    public void testSetCustomerNumber()
    {
	assertEquals(105, CustomerManager.getNextCustomerNumber());
	CustomerManager.setCustomerNumber(101);
	assertEquals(101, CustomerManager.getNextCustomerNumber());
    }
    
    /**
     * Tests the method to manually get the next customer number
     */
    @Test
    public void testGetNextCustomerNumber()
    {
	assertEquals(105, CustomerManager.getNextCustomerNumber());
	CustomerManager.setCustomerNumber(101);
	assertEquals(101, CustomerManager.getNextCustomerNumber());
    }

    /** 
     * Tests the method to find a customer number using the first and last name
     */
    @Test
    public void testGetCustomerNumber()
    {
	assertEquals(101, manager.getCustomerNumber("Ford", "Prefect"));
	assertEquals(102, manager.getCustomerNumber("Arthur", "Dent"));
	assertEquals(103, manager.getCustomerNumber("Trisha", "McMillian"));
	assertEquals(104, manager.getCustomerNumber("Zaphod", "Beeblebrox"));
	//Invalid customer
	assertEquals(-1, manager.getCustomerNumber("Marvin", "Android"));
	manager.addCustomer("Marvin", "Android", "321 Millie Way, The End of The Universe", 654.32);
	//Customer is now valid
	assertEquals(105, manager.getCustomerNumber("Marvin", "Android"));
    }

    /**
     * Tests the toString method
     */
    @Test
    public void testToString()
    {
	String result = manager.toString();
	Scanner scan = new Scanner(result);
	
	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("101", scan.next()); //Customer number
	assertEquals("Prefect,", scan.next()); //Customer Name
	assertEquals("Ford", scan.next());
	scan.next(); //Skip first part of the line
	assertEquals("42", scan.next()); //Address number
	assertEquals("Mostly", scan.next()); //First word of street name
	scan.nextLine(); //Skip the rest of the line
	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("$250.00", scan.next()); //Previous purchases
	scan.next();
	assertEquals("0%", scan.next()); //Discount percent
	
	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("102", scan.next()); //Customer number
	assertEquals("Dent,", scan.next()); //Customer Name
	assertEquals("Arthur", scan.next());
	scan.next(); //Skip first part of the line
	assertEquals("123", scan.next()); //Address number
	assertEquals("Fake", scan.next()); //First word of street name
	scan.nextLine(); //Skip the rest of the line
	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("$0.00", scan.next()); //Previous purchases
	scan.next();
	assertEquals("0%", scan.next()); //Discount percent

	scan.close();
    }
}