/**
 * Demonstrates the selection and insertion sort algorithms for Buidling objects
 */
public class SortBuildingArray
{
	/**
	 * Sorts the specified array of buildings using the selection sort algorithm.
	 * @param list array of Building objects to be sorted
	 */
	public static void selectionSort (Building[] list)
	{
		int min;
		Building temp;

		for (int index = 0; index < list.length; index++)
		{
			min = index;
			for (int scan = index+1; scan < list.length; scan++)
				if (list[scan].compareTo(list[min]) < 0)
					min = scan;

			// Swap the values
			temp = list[min];
			list[min] = list[index];
			list[index]=temp;
		}
	}

	/**
	 * Sorts the specified array of buildings using the insertion sort algorithm.
	 * @param list array of Building objects to be sorted
	 */
	public static void insertionSort (Building[] list)
	{
		for (int index = 1; index < list.length; index++)
		{
			Building key = list[index];
			int position = index;

			//  Shift larger values to the right
			while (position > 0 && key.compareTo((Building) list[position-1]) < 0)
			{
				list[position] = list[position-1];
				position--;
			}

			list[position]=key;
		}
	}
}
