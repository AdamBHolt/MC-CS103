import java.util.*;

/**
 * Demonstrates the selection and insertion sort algorithms for Building objects
 */
public class SortBuildingArrayList
{
	/**
	 * Sorts the specified array of buildings using the selection sort algorithm.
	 * @param list ArrayList of Building objects to be sorted
	 */
	public static void selectionSort (ArrayList<Building> list)
	{
		int min;
		Building temp;

		for (int index = 0; index < list.size(); index++)
		{
			min = index;
			for (int scan = index+1; scan < list.size(); scan++)
			{	
				if (list.get(scan).compareTo(list.get(min)) < 0)
				{

					min = scan;

				}
			}		
			// Swap the values
			temp = list.get(min);

			list.set(min, list.get(index));
			list.set(index, temp);
		}
	}

	/**
	 * Sorts the specified ArrayList of buildings using the insertion sort algorithm.
	 * @param list ArrayList of Building objects to be sorted
	 */
	public static void insertionSort (ArrayList<Building> list)
	{
		for (int index = 1; index < list.size(); index++)
		{
			Building key = list.get(index);
			int position = index;

			//  Shift larger values to the right
			while (position > 0 && key.compareTo((Building) list.get(position-1)) < 0)
			{
				list.set(position, list.get(position-1));
				position--;
			}

			list.set(position, key);
		}
	}
}