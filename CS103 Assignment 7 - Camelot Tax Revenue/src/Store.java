/**
 * This class is a concrete child class of Building which contains methods and fields specific to a store.
 * @author Adam Holt
 * @Date 11/20/2013
 */
public class Store extends Building
{
	//Gross sales made for this store
	private double sales;
	//The building code
	private final int CODE;

	/**
	 * Default constructor
	 */
	public Store()
	{
		//Call the super class constructor
		super();
		//Code 2 represents a store
		CODE = 2;
		//Set the sales to 0
		setSales(0);
	}
	
	/**
	 * Constructor that takes parameters to define the store's information
	 * @param st Street name
	 * @param no Building number
	 * @param as Assessment value
	 * @param sa Gross sales
	 */
	public Store(String st, int no, double as, double sa)
	{
		//Call the super class constructor
		super(st, as, no);
		//Code 2 represents a store
		CODE = 2;
		//Set the sales to the passed parameter
		setSales(sa);
	}

	/**
	 * Get the type code of the store
	 * @return Numeric code value of the store
	 */
	public int getCode()
	{
		return CODE;
	}

	/**
	 * Set the gross sales amount
	 * @param sa Gross sales in thousands of dollars
	 */
	public void setSales(double sa)
	{
		sales = sa;
	}

	/**
	 * Get the gross sales amount
	 * @return Gross sales in thousands of dollars
	 */
	public double getSales()
	{
		return sales;
	}

	//Convert the store to a String
	public String toString()
	{
		//Call the super class toString method and append the sales
		return super.toString() + " " + sales;
	}

	/**
	 * Calculate and return taxes owed on this store
	 * @return Dollar value of taxes owed for this store
	 */
	public double calculateTaxes()
	{
		double taxRate;
		//If the gross sales are higher than $500,000 the tax rate is 1.5%
		//Otherwise, the tax rate is 1.25%
		if(sales > 500)
			taxRate = .015;
		else 
			taxRate = .0125;

		//Assessment value is passed in as thousands of dollars
		return (getAssessment() * taxRate) * 1000;
	}
}