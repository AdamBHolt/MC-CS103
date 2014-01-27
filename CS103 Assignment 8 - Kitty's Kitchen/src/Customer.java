import java.text.NumberFormat;

/**
 * This class contains the data for a customer to place orders
 * @author Adam Holt
 * @date 12/4/13
 */
public class Customer implements Comparable<Object>
{
    //Data member declarations
    private String firstName, lastName, address; //Names and address of the customer
    private int customerNumber; //Customer number
    private double previousPurchases; //Customer's previous purchases

    /**
     * Default constructor
     */
    public Customer()
    {
	//Set all data members to default values
	setFirstName("");
	setLastName("");
	setAddress("");
	setPreviousPurchases(0.0);
	setCustomerNumber(0);
    }

    /**
     * Constructor takes values to set the data members
     * @param f First name
     * @param l Last name
     * @param a Address
     * @param c Customer number
     * @param p Previous purchase total
     */
    public Customer(String f, String l, String a, int c, double p)
    {
	//Set the data members to the passed values
	setFirstName(f);
	setLastName(l);
	setAddress(a);
	setPreviousPurchases(p);
	setCustomerNumber(c);
    }

    /**
     * Set the first name
     * @param f First name
     */
    public void setFirstName(String f)
    {
	firstName = f;
    }

    /**
     * Get the first name
     * @return First name
     */
    public String getFirstName()
    {
	return firstName;
    }

    /**
     * Set the last name
     * @param l Last name
     */
    public void setLastName(String l)
    {
	lastName = l;
    }

    /**
     * Get the last name
     * @return Last name
     */
    public String getLastName()
    {
	return lastName;
    }

    /**
     * Get the full name
     * @return Full name - Last, First
     */
    public String getName()
    {
	return getLastName() + ", " + getFirstName();
    }

    /**
     * Set the address
     * @param a Address
     */
    public void setAddress(String a)
    {
	address = a;
    }

    /**
     * Get the address
     * @return Address
     */
    public String getAddress()
    {
	return address;
    }

    /**
     * Set the customer number
     * @param c Customer Number
     */
    public void setCustomerNumber(int c)
    {
	customerNumber = c;
    }

    /**
     * Get the customer number
     * @return Customer number
     */
    public int getCustomerNumber()
    {
	return customerNumber;
    }

    /**
     * Set the previous purchases
     * @param p Previous purchases
     */
    public void setPreviousPurchases(double p)
    {
	previousPurchases = p;
    }

    /**
     * Add value to the previous purchases
     * @param p New purchase amount
     */
    public void addPurchase(double p)
    {
	previousPurchases += p;
    }

    /**
     * Get the previous purchases
     * @param p Previous purchases
     */
    public double getPreviousPurchases()
    {
	return previousPurchases;
    }

    /**
     * Calculate the customer's discount percent based on previous purchase amount
     * @return Discount percent
     */
    public double calculateDiscount()
    {
	//Based on the previous purchase total, the discount is set from 0% to 10%
	if(getPreviousPurchases() >= 2000)
	    return .10;
	else if(getPreviousPurchases() >= 1500)
	    return .07;
	else if(getPreviousPurchases() >= 1000)
	    return .06;
	else if(getPreviousPurchases() >= 500)
	    return .05;
	else
	    return 0.0;
    }

    /**
     * Convert the customer to a String
     */
    public String toString()
    {
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	NumberFormat pfmt = NumberFormat.getPercentInstance();

	return 	"\nCustomer #: " + getCustomerNumber() + " " + getName() +
		"\nAddress: " + getAddress() + 
		"\nPrevious purchases: " + fmt.format(getPreviousPurchases()) + 
		"\nDiscount: " + pfmt.format(calculateDiscount());
    }

    /**
     * Compare the current customer to a passed customer
     * @return 1 if the current customer number is greater than the passed customer, -1 if it is less, and 0 if they are equal
     */
    public int compareTo(Object cust)
    {
	if(getCustomerNumber() > ((Customer)cust).getCustomerNumber())
	    return 1;
	else if(getCustomerNumber() < ((Customer)cust).getCustomerNumber())
	    return -1;
	else
	    return 0;
    }
}