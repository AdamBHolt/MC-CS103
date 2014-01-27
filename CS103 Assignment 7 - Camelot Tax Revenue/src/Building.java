/**
 * This is an abstract class that holds methods and fields common to all types of buildings
 * @author Adam Holt
 * @date 11/20/2013
 */
public abstract class Building implements Comparable<Building>
{
	//The numeric address of the building
	private int buildingNumber;
	//The name of the street the building is on
	private String street;
	//The total assessed value of the building (in 1000s)
	private double assessment;

	/**
	 * Default constructor
	 */
	public Building()
	{
		//Set the fields to the default values
		setStreetAddress("");
		setAssessment(0);	
		setBuildingNumber(0);
	}

	/**
	 * Constructor that takes parameters to define the building's information
	 * @param st Street name
	 * @param as Assessment value
	 * @param no Building number
	 */
	public Building(String st, double as, int no) 
	{
		//Set the fields to the passed parameters
		setStreetAddress(st);
		setAssessment(as);
		setBuildingNumber(no);
	}

	/**
	 * Abstract method to be defined by sub classes
	 * Calculates the taxes owed on a building
	 * @return Total taxes owed
	 */
	public abstract double calculateTaxes();

	/**
	 * Converts the building to a String to be printed
	 */
	public String toString()
	{
		//Return the building's information
		return getBuildingNumber() + " " + getStreetAddress() + " " + getAssessment();
	}

	/**
	 * Determines whether a passed Building object is equal to this Building
	 * @param b Building object to be compared
	 * @return True if the Buildings are equal, otherwise False
	 */
	public boolean equals(Building b)
	{
		//If the street number and name are the same then the Buildings are equal
		if(b.getStreetAddress() == getStreetAddress() && b.getStreetAddress().equals(getStreetAddress()))
			return true;
		else
			return false;
	}

	/**
	 * Set the numeric address
	 * @param n Building number
	 */
	public void setBuildingNumber(int n)
	{
		buildingNumber = n;
	}

	/**
	 * Get the numeric address
	 * @return Building number
	 */
	public int getBuildingNumber()
	{
		return buildingNumber;
	}

	/**
	 * Set the name of the street
	 * @param st Name of the street
	 */
	public void setStreetAddress(String st)
	{
		street = st;
	}

	/**
	 * Get the name of the street
	 * @return Name of the street
	 */
	public String getStreetAddress()
	{
		return street;
	}

	/**
	 * Set the assessment value
	 * @param as Assessment value
	 */
	public void setAssessment(double as)
	{
		assessment = as;
	}

	/**
	 * Get the assessment value
	 * @return Assessment value
	 */
	public double getAssessment()
	{
		return assessment;
	}

	/**
	 * Determines whether a passed Building object is greater than, equal to, or less than this Building
	 * @param Building object to be compared
	 * @return 0 if the buildings are equal, -1 if the parameter is greater than this building,
	 * and 1 if the parameter is less than this building
	 */
	public int compareTo(Building b)
	{
		//If the parametr's street number is greater than this street number return -1
		if(getBuildingNumber() < b.getBuildingNumber())
			return -1;
		//If the parametr's street number is less than this street number return 1
		else if(getBuildingNumber() > b.getBuildingNumber())
			return 1;
		else
			//If the street numbers are equal return the comparison of the street names
			return getStreetAddress().compareTo(b.getStreetAddress());
	}
}