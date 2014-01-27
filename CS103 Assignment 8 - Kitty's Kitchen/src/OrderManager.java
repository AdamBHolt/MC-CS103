import java.util.*;

/**
 * This is a data manager class to manage Order objects
 * @author Adam Holt
 * @date 12/4/13
 */
public class OrderManager
{

    //Order number for the next order object added
    private static int orderNumber;
    //Array list to contain Order objects
    private ArrayList<Order> orderList;

    /**
     * Default constructor
     */
    public OrderManager()
    {
	//Set the first order number to 1001
	setOrderNumber(1001);
	orderList = new ArrayList<>();
    }

    /**
     * Adds an Order object to the ArrayList
     * @param cust Customer number
     * @param purch Purchase subtotal
     * @param disc Discount percent
     */
    public void addOrder(int cust, double purch, double disc)
    {
	orderList.add(new Order(cust, purch, orderNumber++, disc));
    }

    /**
     * Get an order based on the passed order number
     * @param orderNum
     * @return Reference to the Order object with the passed order number
     */
    public Order getOrder(int orderNum)
    {
	//Subtract the starting order number to get the index number of the order
	return orderList.get(orderNum - 1001);
    }

    /**
     * Manually set the next order number
     * @param o Order number
     */
    public static void setOrderNumber(int o)
    {
	orderNumber = o;
    }

    /**
     * Get the next order number
     * @return Next order number
     */
    public static int getOrderNumber()
    {
	return orderNumber;
    }

    /**
     * Get the total number of orders in the ArrayList
     * @return Total number of orders
     */
    public static int getNumberOfOrders()
    {
	return orderNumber-1001;
    }

    /**
     * Get the last order in the ArrayList
     * @return Reference to the last Order object in the ArrayList
     */
    public Order getLastOrder()
    {
	return orderList.get(orderList.size()-1);
    }

    /**
     * Convert the OrderManager to a Strin gusing the toString method of each Order object
     */
    public String toString()
    {
	String returnString = "";
	for(Order order : orderList)
	    returnString += order + "\n\n";
	return returnString;
    }
}