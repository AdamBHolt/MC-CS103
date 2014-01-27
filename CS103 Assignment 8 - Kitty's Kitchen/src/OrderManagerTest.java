import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the methods of the OrderManager class
 * @author Adam Holt
 * @Date 12/4/13
 *
 */
public class OrderManagerTest
{
    OrderManager manager;
    
    @Before
    public void setUp() throws Exception
    {
	manager = new OrderManager();
	
	manager.addOrder(101, 123.45, 0.00);
	manager.addOrder(104, 555.55, 0.05);
	manager.addOrder(102, 321.56, 0.10);
	manager.addOrder(101, 23.65, 0.06);
	manager.addOrder(103, 111.11, 0.00);
    }

    @After
    public void tearDown() throws Exception
    {
	manager = null;
    }

    /**
     * Tests adding orders to the OrderManager
     */
    @Test
    public void testAddOrder()
    {
	assertEquals(1005, manager.getLastOrder().getOrderNumber());
	manager.addOrder(102, 100.00, 0.10);
	assertEquals(1006, manager.getLastOrder().getOrderNumber());
	manager.addOrder(104, 50.00, 0.05);
	assertEquals(1007, manager.getLastOrder().getOrderNumber());
    }

    /**
     * Tests method to get orders from the OrderManager
     */
    @Test
    public void testGetOrder()
    {
	assertEquals(321.56, manager.getOrder(1003).getPurchase(),.001);
	assertEquals(101, manager.getOrder(1004).getCustomerNumber());
	assertEquals(.05, manager.getOrder(1002).getDiscountPercent(),.001);
    }

    /**
     * Tests method to manually set the order number
     */
    @Test
    public void testSetOrderNumber()
    {
	assertEquals(1006, OrderManager.getOrderNumber());
	OrderManager.setOrderNumber(1001);
	assertEquals(1001, OrderManager.getOrderNumber());
    }
    
    /**
     * Tests method to get the next order number
     */
    @Test
    public void testGetOrderNumber()
    {
	assertEquals(1006, OrderManager.getOrderNumber());
	OrderManager.setOrderNumber(1001);
	assertEquals(1001, OrderManager.getOrderNumber());
    }

    /**
     * Tests method to get current total number of orders
     */
    @Test
    public void testGetNumberOfOrders()
    {
	assertEquals(5, OrderManager.getNumberOfOrders());
	manager.addOrder(105, 100, 0.0);
	assertEquals(6, OrderManager.getNumberOfOrders());
    }

    /**
     * Tests the method to get the last order in the manager
     */
    @Test
    public void testGetLastOrder()
    {
	assertEquals(103, manager.getLastOrder().getCustomerNumber());
	assertEquals(111.11, manager.getLastOrder().getPurchase(), .001);
	manager.addOrder(104,  555.55, 0.0);
	assertEquals(104, manager.getLastOrder().getCustomerNumber());
	assertEquals(555.55, manager.getLastOrder().getPurchase(), .001);
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
	assertEquals("1001", scan.next()); //Order number
	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("101", scan.next()); //Customer number
	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("$123.45", scan.next()); //Purchase amount
	scan.next();
	assertEquals("0%", scan.next()); //Discount percent
	assertEquals("$0.00", scan.next()); //Discount amount
	scan.next();
	assertEquals("6%", scan.next()); //Tax percent
	assertEquals("$7.41", scan.next()); //Tax amount
	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("$130.86", scan.next()); //Total amount
	
	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("1002", scan.next()); //Order number
	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("104", scan.next()); //Customer number
	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("$555.55", scan.next()); //Purchase amount
	scan.next();
	assertEquals("5%", scan.next()); //Discount percent
	assertEquals("$27.78", scan.next()); //Discount amount
	scan.next();
	assertEquals("6%", scan.next()); //Tax percent
	assertEquals("$31.67", scan.next()); //Tax amount
	scan.next();
	scan.next(); //Skip first part of the line
	assertEquals("$559.44", scan.next()); //Total amount
	
	scan.close();
    }
}