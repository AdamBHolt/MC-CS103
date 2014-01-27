import java.text.*;

/**
 * This class is used to manage both Customer and Order object through 
 * the manager classes for each class
 * @author Adam Holt
 * @date 12/4/13
 */
public class DataManager implements DataManagerInterface
{

    //DataManger objects for each data type
    private CustomerManager customers;
    private OrderManager orders;

    /**
     * Default constructor
     */
    public DataManager()
    {
	customers = new CustomerManager();
	orders = new OrderManager();
    }

    /**
     * Rest the order and customer numbers to their starting values
     */
    public void reset()
    {
	CustomerManager.setCustomerNumber(101);
	OrderManager.setOrderNumber(1001);
    }

    /**
     * Add an order to the OrderManager
     * @param customerNum The customer number
     * @param purchase Purchase subtotal
     * @return true if the order is added, false if it is not added
     */
    public boolean addOrder(int customerNum, double purchase)
    {
	//Search the CustomerManager for the customer number
	//If it is not found, return false
	if(customers.getCustomer(customerNum) == null)
	    return false;
	else
	{
	    Customer customer = customers.getCustomer(customerNum);
	    //If the customer number is found, add the order to the OrderManager
	    orders.addOrder(customerNum, purchase, customer.calculateDiscount());
	    //Add the purchase to the customer's previous purchases
	    customer.addPurchase(purchase);
	    //Return true to indicate that the order was added successfully
	    return true;
	}
    }

    /**
     * Get the details of the most recently placed order
     * @return String representation of the most recently placed order
     */
    public String getDetailsOfLastOrder()
    {
	//Get the last order in the OrderManager
	Order order = orders.getLastOrder();
	//Get the customer that placed the order
	Customer customer = customers.getCustomer(order.getCustomerNumber());

	//Number formats for output
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	NumberFormat pfmt = NumberFormat.getPercentInstance();

	//Return a String representation of the order and cutomer information
	return "Order #: " + order.getOrderNumber() +
		"\nCustomer #: " + customer.getCustomerNumber() + " " + customer.getName() +
		"\nPurchase amount: " + fmt.format(order.getPurchase()) + 
		"\nDiscount: " + pfmt.format(order.getDiscountPercent()) + " " + fmt.format(order.getDiscount()) +
		"\nTax: " + pfmt.format(order.getTaxPercent()) + " " + fmt.format(order.getTax()) + 
		"\nFinal cost: " + fmt.format(order.getTotalSale());
    }

    /**
     * Find a customer number based on first and last name
     * @param firstName First name
     * @param lastName Last Name
     * @return The customer number
     */
    public int getCustomerNumber(String firstName, String lastName)
    {
	return customers.getCustomerNumber(firstName, lastName);
    }

    /**
     * Get a reference to a Customer object in CustomerManager based on the customer number
     * @param cNumber Customer number
     * @return Reference to the customer with the customer number
     */
    public Customer getCustomer(int cNumber)
    {
	return customers.getCustomer(cNumber);
    }

    /**
     * Add a customer to the CustomerManager
     * @param custFName First name
     * @param custLName Last name
     * @param custAddress Address
     * @param purchase Previous purchases
     * @return The customer number if the customer is successfully added, otherwise, -1
     */
    public int addCustomer(String custFName, String custLName,
	    String custAddress, double purchase)
    {
	//Search the CustomerManager for the customer by name
	//If it is not found, add the customer and return the customer number
	if(customers.getCustomerNumber(custFName, custLName)==-1)	    
	    return customers.addCustomer(custFName, custLName, custAddress, purchase);
	//If the customer id found then it already exists, return -1
	else
	    return -1;
    }

    /**
     * Return a String representation of all of the Customers in the CustomerManager
     */
    public String printCustomers()
    {
	return customers.toString();
    }

    /**
     * Return a String representation of all of the Orders in the OrderManager
     */
    public String printOrders()
    {
	return orders.toString();
    }

    /**
     * Return a String representation of all information in the DataManager
     */
    public String toString()
    {
	String returnString = "";
	//Number formats for output
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	NumberFormat pfmt = NumberFormat.getPercentInstance();

	//For each order in the OrderManager get the needed order information and
	//Corresponding customer information
	for(int i=0; i<OrderManager.getNumberOfOrders(); i++)
	{
	    Customer customer = customers.getCustomer(orders.getOrder(i + 1001).getCustomerNumber());
	    returnString += "Order #: " + orders.getOrder(i + 1001).getOrderNumber() +
		    "\nCustomer #: " + customer.getCustomerNumber() + " " + customer.getName() +
		    "\nPurchase amount: " + fmt.format(orders.getOrder(i + 1001).getPurchase()) + 
		    "\nDiscount: " + pfmt.format(orders.getOrder(i + 1001).getDiscountPercent()) + " " + fmt.format(orders.getOrder(i + 1001).getDiscount()) +
		    "\nTax: " + pfmt.format(orders.getOrder(i + 1001).getTaxPercent()) + " " + fmt.format(orders.getOrder(i + 1001).getTax()) + 
		    "\nFinal cost: " + fmt.format(orders.getOrder(i + 1001).getTotalSale()) + "\n\n";
	}
	//Return the complete String
	return returnString;
    }
}