import java.util.*;

/**
 * This is a data manager class to manage Customer objects
 * @author Adam Holt
 * @date 12/4/13
 */
public class CustomerManager
{
    //Customer number for the next customer object added
    private static int customerNumber;
    //Array list to contain Customer objects
    private ArrayList<Customer> customerList;

    /**
     * Default constructor
     */
    public CustomerManager()
    {
	//Set the first customer number to 101
	setCustomerNumber(101);
	customerList = new ArrayList<>();
    }

    /**
     * Adds a customer object to the ArrayList
     * @param fName First name
     * @param lName Last name
     * @param address Address
     * @param purch Previous purchase amount
     * @return The customer number
     */
    public int addCustomer(String fName, String lName, String address, double purch)
    {
	//Create a new Customer object and add it to the ArrayList
	customerList.add(new Customer(fName, lName, address, customerNumber, purch));
	//Return the customer number then increment it
	return customerNumber++;
    }

    /**
     * Get a customer based on the customer number
     * @param customerNumber The customer number
     * @return Reference to the customer object
     */
    public Customer getCustomer(int customerNumber)
    {
	//PAramteres for searching the ArrayList using a binary search
	int start, middle, end, index;
	//Flag to determine whether the passed customer number was located
	boolean found = false;

	//The index of the located object
	index = -1;
	//Start at the first index of the ArrayList
	start = 0;
	//End at the last element of the ArrayList
	end = customerList.size()-1;

	//Repeat until the customer number has been located or until start is greater than end
	while(start <= end && !found)
	{
	    //Set the middle on each iteration based on the start and end points
	    middle = (start + end)/2;

	    //If the middle index matches the passed customer number, set found to true and set index to the middle location
	    if(customerNumber == customerList.get(middle).getCustomerNumber())
	    {
		found = true;
		index = middle;
	    }

	    //If the middle does not match
	    //If the customer number is greater than the middle object reset the start to the middle
	    else if (customerNumber > customerList.get(middle).getCustomerNumber())
		start = middle + 1;
	    //If the customer number is less than the middle object reset the end to the middle
	    else
		end = middle - 1;
	}
	//If the customer number was found return a reference to the object at that index
	if(found)
	    return customerList.get(index);
	//Otherwise the customer number is not in the ArrayList, return null
	else
	    return null;   
    }    

    /**
     * Manually set the next customer number
     * @param c Customer number
     */
    public static void setCustomerNumber(int c)
    {
	customerNumber = c;
    }

    /**
     * Get the next customer number
     * @return Next customer number
     */
    public static int getNextCustomerNumber()
    {
	return customerNumber;
    }

    /**
     * Locate a customer number based on the first and last name of the customer
     * @param firstName First name
     * @param lastName Last name
     * @return The customer number
     */
    public int getCustomerNumber(String firstName, String lastName)
    {
	//Check each element in the ArrayList in a linear search
	for(Customer customer : customerList)
	{
	    //If the customer is found return the customer number
	    if(firstName.equals(customer.getFirstName()) && lastName.equals(customer.getLastName()))
		return customer.getCustomerNumber();
	}
	//Otherwise, the customer is not in the ArrayList, return -1
	return -1;
    }

    /**
     * Convert the ArrayList of customers into a String using each object's toString method
     */
    public String toString()
    {
	String returnString = "";
	for(Customer customer : customerList)
	    returnString += customer + "\n\n";
	return returnString;
    }
}