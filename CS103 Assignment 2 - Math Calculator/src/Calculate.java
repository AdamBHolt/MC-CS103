/** 
* Adds the sum of even integers between two specified integers
* or multiplies the specified integers
* Assignment 2
* Due date: 9/23/13
* @author Adam Holt
* @version 1
*/

public class Calculate {

	/**
	 * Returns the sum of even integers between the two supplied parameters
	 * @param num1 The first number.
	 * @param num2 The second number.
	 * @return The sum of even integers from num1 to num2.
	 */
	
	public int add(int num1, int num2)
	{
		int total = 0; //Accumulator to hold sum of even numbers
		
		//Repeat for each number from num1 to num2
		for(int i=num1; i<=num2; i++)
		{
			//Test if the current number is even
			if(i%2 == 0)
			{
				//If the current number is even, add it to the accumulator
				total += i;
			} //end if
		} //end for loop
		
		//Return the total sum
		return total;
	} //end add method
	
	/**
	 * Returns the product of two supplied parameters
	 * @param num1 The first number.
	 * @param num2 The second number.
	 * @return The product of num1 and num2
	 */
	
	public int multiply(int num1, int num2)
	{
		//Return the product of the two parameters
		return num1 * num2;
	} //end multiply method

} //end Calculate class definition