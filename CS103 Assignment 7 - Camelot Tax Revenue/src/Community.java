/**
 * This class is a concrete child class of Building which contains methods and fields specific to a community building.
 * @author Adam Holt
 * @Date 11/20/2013
 */
public class Community extends Building
{
	//The building code
	private final int CODE;

	/**
	 * Default constructor
	 */
	public Community()
	{
		//Call the super class constructor
		super();
		//Code 3 represents a community building
		CODE = 3;
	}

	/**
	 * Constructor that takes parameters to define the building's information
	 * @param st Street name
	 * @param no Building number
	 * @param as Assessment value
	 */
	public Community(String st, int no, double as)
	{
		//Call the super class constructor
		super(st, as, no);
		//Code 3 represents a community building
		CODE = 3;
	}

	/**
	 * Get the type code of the building
	 * @return Numeric code value of the building
	 */
	public int getCode()
	{
		return CODE;
	}

	/**
	 * Calculate and return taxes owed on this building
	 * @return Dollar value of taxes owed for this building
	 */
	public double calculateTaxes()
	{
		//Tax rate is 0.8%
		//Assessment value is passed in as thousands of dollars
		return (getAssessment() * .008) * 1000;
	}
}