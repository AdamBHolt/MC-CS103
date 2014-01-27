import java.text.NumberFormat;
import java.util.*;

/**
 * This class is a data structure to manage various Building objects
 * The objects are managed in an ArrayList
 * @author Adam Holt
 * @date 11/20/2013
 */
public class BuildingManager implements BuildingManagerInterface
{
	//The ArrayList of Buildings
	private ArrayList<Building> buildings;
	//Counters for the various building types
	private int numHouse, numStore, numCommunity, numOther;

	/**
	 * Default constructor
	 */
	public BuildingManager()
	{
		//Create the ArrayList
		buildings = new ArrayList<>();

		//Set the counters to 0
		numHouse = numStore = numCommunity = numOther = 0;
	}

	/**
	 * Adds a new Building object to the ArrayList
	 * @param code Building code
	 * @param street Street name
	 * @param assess Assessment value
	 * @param buildNum Street number
	 * @param gross Total sales (for Stores only)
	 */
	public void addBuilding(int code, String street, double assess,
			int buildNum, double gross)
	{
		//Switch based on the code of the new Building
		//Add the appropriate type of building to the ArrayList based on the code
		//And increment the counter for that building type
		switch(code)
		{
		case 1:
			buildings.add(new House(street, buildNum, assess));
			numHouse ++;
			break;
		case 2:
			//If the building is a Store include the sales
			buildings.add(new Store(street, buildNum, assess, gross));
			numStore ++;
			break;
		case 3:
			buildings.add(new Community(street, buildNum, assess));
			numCommunity++;
			break;
		case 4:
			buildings.add(new OtherBuilding(street, buildNum, assess));
			numOther++;
			break;
		default:
		}
	}

	/**
	 * Get the number of houses
	 * @return Number of houses
	 */
	public int getNumHouse()
	{
		return numHouse;
	}

	/**
	 * Get the number of stores
	 * @return Number of stores
	 */
	public int getNumStore()
	{
		return numStore;
	}

	/**
	 * Get the number of community buildings
	 * @return Number of community buildings
	 */
	public int getNumCommunity()
	{
		return numCommunity;
	}

	/**
	 * Get the number of other buildings
	 * @return Number of other buildings
	 */
	public int getNumOtherBuilding()
	{
		return numOther;
	}

	/**
	 * Get the first Building in the ArrayList
	 * @return The first Building in the ArrayList
	 */
	public Building getFirstBuilding()
	{
		return buildings.get(0);
	}

	/**
	 * Sort the ArrayList
	 */
	public void sort()
	{
		SortBuildingArrayList.selectionSort(buildings);
	}

	/**
	 * Convert the BuildingManager to a text representation
	 * @return String representation of all of the buildings in the ArrayList and the tax information
	 */
	public String toString()
	{
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		return generateTaxReport() + "\n" +
		"Total Taxes: " + fmt.format(calculateTotalTax()) + "\n" +
		"Total Number of houses: " + getNumHouse() + "\n" +
		"Total Number of stores: " + getNumStore() + "\n" +
		"Total Number of churches and schools: " + getNumCommunity() + "\n" +
		"Total Number of other buildings: " + getNumOtherBuilding();
	}

	/**
	 * Use the Buildings in the ArrayList to create a report
	 * @return Tax information for each building in the ArrayList
	 */
	public String generateTaxReport()
	{
		sort();
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String report = "TAX REVENUE FOR THE TOWN OF CAMELOT\n\nBUILDING STREET TAXES\n";
		for(Building building : buildings)
			report += "    " + building.getBuildingNumber() + "    " + building.getStreetAddress() + "    " + fmt.format(building.calculateTaxes()) + "\n";
		return report;
	}

	/**
	 * Calculate the total taxes owed for all of the Buildings in the ArrayList
	 * @return Total taxes owed for all Buildings combined
	 */
	public double calculateTotalTax()
	{
		//Accumulator
		double totalTax = 0;

		//Calculate the tax of each Building in the ArrayLsit and add it to the accumulator
		for(Building building : buildings)
			totalTax += building.calculateTaxes();
		return totalTax;
	}
}