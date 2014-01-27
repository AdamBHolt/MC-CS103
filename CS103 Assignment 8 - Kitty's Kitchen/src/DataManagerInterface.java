
import java.util.*;
import java.text.*;

/**

 * <p>Title: DataManagerInterface</p>
 *
 * <p>Description: Gives the method headers for the DataManager that are used in the DataManagerTest</p>
 * <p>				Your DataManager which implements this DataManagerInterface may contain additional</p>
 * <p>				not listed here </p>
 * 
 * <p>	Your DataManager will be a composition of an OrderManager and a CustomerManager</p>
 *
 * @author Professor Myers
 * @version 1.0
 */

public interface DataManagerInterface{
//    OrderManager orders;
//    CustomerManager customers;

    
   
    /**
     * This resets the static OrderNumber in the OrderManager back to 1001
     * and the static CustomerNumber in the CustomerManager back to 101
     */
    public void reset();    
    
    /**
     * Retrieves the customer object using the get method from the CustomerManager object
     * Adds an order to the OrderManager through its addOrder method
     * Updates the purchases for the Customer (addPurchases method)
     * @param customerNum the Customer Number
     * @param purchase the amount of the purchase
     * @return true if the order was added successfully, false if the customer number was invalid and therefore order not added
     */
    public boolean addOrder(int customerNum, double purchase);
    
    
    /**
     * Print out details of last order in the following format:
     * (Uses toString method of Order)
     * 
     *<p>Order #: (order number)
     *<p>Customer #: (customer number)(2 spaces)(last name, first name)
     *<p>Purchase amount: (purchase amount in currency format)
     *<p>Discount: (discount percent in percent format)(2 spaces)(discount amount in currency format)
     *<p>Tax: (tax percent in percent format)(2 spaces)(tax amount in currency format)
     *<p>Final cost: (final cost in current format)
     *
     *<p>Examples:
     *
     *<p>Order #: 1001
  	*<p>Customer #: 103  Hawthorne, Gale
  	*<p>Purchase amount: $54.77
  	*<p>Discount: 0% $0.00
  	*<p>Tax: 6%  $3.29
  	*<p>Final cost $58.06
  	*
  	*<p>Order #: 1002
  	*<p>Customer #: 105  Snow, Coriolanus
  	*<p>Purchase amount: $369.33
  	*<p>Discount: 10% $36.93
  	*<p>Tax: 6%  $19.94
  	*<p>Final cost $352.34
     */
    public String getDetailsOfLastOrder();
    
    /**
     * Returns the customer number for the following customer if this customer exists
     * @param firstName first name of customer
     * @param lastName lastname of customer
     * @return a customer number if the customer exits, -1 if the customer doesn't exist
     */
    public int getCustomerNumber(String firstName, String lastName);
    
    /**
     * Add customer to ArrayList of customer objects in the CustomerManager through the
     * addCustomer method in the CustomerManager object
     * @param custFName Customer first name
     * @param custLName Customer last name
     * @param custAddress Customer address
     * @param purchase Customer purchase amount
     * @return customerNumber if added customer successfully, -1 if not added successfully
     */
    public int addCustomer(String custFName, String custLName, String custAddress, double purchase);
    
    /**
     * Print all the customers in order by Customer number in the CustomerManager
     * Uses the printCustomers method in the CustomerManager
     * 
	 * <p>Customers printed in the following format:</p>
	 * <p>(First name)(space)(Last name)</p>
	 * <p>Customer Number: (customer number)</p>
	 * <p>(customer address)</p>
	 * <p>Purchases: (purchases in currency format)</p>
	 * <p>Discount: (discount in percent format)</p>
	 * <p>(1 blank line between customers)</p>
	 * 
	 * <p>Example:</p>
	 * 
	 *<p>Katniss Everdeen</p>
	 *<p>Customer Number: 101</p>
	 *<p>86 Hopeless Dr, The Seam</p>
	 *<p>Purchases: $23.56</p>
	 *<p>Discount: 0%</p>
	 *<p>(1 empty line)</p>
	 *<p>Effie Trinket</p>
	 *<p>Customer Number: 106</p>
	 *<p>654 High Society Blvd, The Capitol</p>
	 *<p>Purchases: $1,828.52</p>
	 *<p>Discount: 7%</p>
     * @return a String with all the customers listed in customer number
     */
    public String printCustomers();
    
    /**
     * Prints all the orders in order by Order Number in the OrderManager
     * uses the printOrders in the OrderManager
     * Print out each order in the following format:
     * 
     *<p>Order #: (order number)</p>
     *<p>Customer #: (customer number)(2 spaces)(last name, first name)</p>
     *<p>Purchase amount: (purchase amount in currency format)</p>
     *<p>Discount: (discount percent in percent format)(2 spaces)(discount amount in currency format)</p>
     *<p>Tax: (tax percent in percent format)(2 spaces)(tax amount in currency format)</p>
     *<p>Final cost: (final cost in current format)</p>
     *<p>(1 blank line separates orders)</p>
     *
     *<p>Example:</p>
     *
     *<p>Order #: 1001</p>
     *<p>Customer #: 103  Hawthorne, Gale</p>
     *<p>Purchase amount: $54.77</p>
     *<p>Discount: 0% $0.00</p>
     *<p>Tax: 6%  $3.29</p>
     *<p>Final cost $58.06</p>
     *<p>(1 blank line between orders)</p>
     *<p>Order #: 1002</p>
     *<p>Customer #: 105  Snow, Coriolanus</p>
     *<p>Purchase amount: $369.33</p>
     *<p>Discount: 10% $36.93</p>
     *<p>Tax: 6%  $19.94</p>
     *<p>Final cost $352.34</p>
     *
     * @return a string with all the orders listed in order number
     */
    public String printOrders();

}
