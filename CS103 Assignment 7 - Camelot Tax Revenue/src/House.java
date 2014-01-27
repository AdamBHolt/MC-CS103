/**
 * This class is a concrete child class of Building which contains methods and fields specific to a house.
 * @author Adam Holt
 * @Date 11/20/2013
 */
public class House extends Building
{
	//The building code
	private final int CODE;

	/**
	 * Default constructor
	 */
	public House()
	{
		//Call the super class constructor
		super();
		//Code 1 represents a house
		CODE = 1;
	}
	
	/**
	 * Constructor that takes parameters to define the house's information
	 * @param st Street name
	 * @param no Building number
	 * @param as Assessment value
	 */
	public House(String st, int no, double as)
	{
		//Call the super class constructor
		super(st, as, no);
		//Code 1 represents a house
		CODE = 1;
	}
	
	/**
	 * Get the type code of the house
	 * @return Numeric code value of the house
	 */
	public int getCode()
	{
		return CODE;
	}

	/**
	 * Calculate and return taxes owed on this house
	 * @return Dollar value of taxes owed for this house
	 */
	public double calculateTaxes()
	{
		//Tax rate is 1.5%
		//Assessment value is passed in as thousands of dollars
		return (getAssessment() * .015) * 1000;
	}
}