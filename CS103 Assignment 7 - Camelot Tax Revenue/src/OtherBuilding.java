/**
 * This class is a concrete child class of Building which contains methods and fields specific to other buildings.
 * @author Adam Holt
 * @Date 11/20/2013
 */
public class OtherBuilding extends Building
{
	//The building code
	private final int CODE;

	/**
	 * Default constructor
	 */
	public OtherBuilding()
	{
		//Call the super class constructor
		super();
		//Code 4 represents an other building
		CODE = 4;
	}

	/**
	 * Constructor that takes parameters to define the building's information
	 * @param st Street name
	 * @param no Building number
	 * @param as Assessment value
	 */
	public OtherBuilding(String st, int no, double as)
	{
		//Call the super class constructor
		super(st, as, no);
		//Code 4 represents an other building
		CODE = 4;
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
		//If the assessment value is greater or equal to $25,000 the tax rate is 0.5%
		//Otherwise, no taxes are owed for this building
		if(getAssessment() >= 25)
			//Assessment value is passed in as thousands of dollars
			return (getAssessment() * .005) * 1000;
		else return 0;
	}
}