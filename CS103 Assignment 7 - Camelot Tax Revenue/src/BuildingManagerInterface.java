/**
 * Interface for the BuildingManager class for CS103, Project 7, FALL 2013
 * Contains an ArrayList of objects that inherit from the Abstract class Building
 * Keeps track of the number of Houses, Stores, Churches/Schools,
 *      and Other Buildings
 * @author Professor Myers modified by Professor Justh
 *
 */
public interface BuildingManagerInterface {
	/**
	 * Add a building to the ArrayList.
	 * @param code Type of building: 1-house, 2-store, 3-church/school, 4-other building
	 * @param street address
	 * @param assess assessment in 1000's
	 * @param buildNum building number
	 */
	public void addBuilding(int code, String street, double assess, int buildNum, double gross);
	
	/**
	 * Returns the number of houses in the ArrayList
	 * @return number of House
	 */
	public int getNumHouse();
	
	/**
	 * Returns the number of stores in the ArrayList
	 * @return number of Store
	 */
	public int getNumStore();
	
	/**
	 * Returns the number of Community buildings (churches and schools) in the ArrayList
	 * @return number of Community
	 */
	public int getNumCommunity();
	
	/**
	 * Returns the number of other buildings in the ArrayList
	 * @return number of OtherBuilding
	 */
	public int getNumOtherBuilding();
	
	/**
	 * Returns the first building in the ArrayList for testing purposes
	 * @return the first building in the ArrayList
	 */
	public Building getFirstBuilding();
	
	/**
	 * Sort the objects by building Number
	 * Use one of the methods in your SortBuildingArrayList class
	 * The SortBuildingArrayList class is a modified version of the
	 * SortBuildingArray class given you.
	 */
	public void sort();
	
	/**
	 * Generates a tax report of revenue from buildings
	 * Building are listed in ascending order by building number
	 * @return String that contains the Tax Report
	 */
	public String generateTaxReport();
	
	/**
	 * Calculate the total tax for all buildings in the ArrayList
	 * @return the total tax for all buildings
	 */
	public double calculateTotalTax();
	
	/**
	 * Creates a string representation of the object
	 * @return String that represents the objects in the ArrayList
	 */
	public String toString();
	

}
