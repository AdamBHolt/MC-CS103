import java.util.Scanner;

/** 
* Creates an instance of the Calculate class and allows the user
* to access its add and multiply methods by supplying two integers
* Assignment 2
* Due date: 9/23/13
* @author Adam Holt
* @version 1
*/

public class Driver {
	
	/**
	 * Creates an instance of the Calculate class and allows the user
	 * to access its add and multiply methods by supplying two integers
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		//Local variable declarations
		int number1, number2;	//User-supplied numbers to be added or subtracted
		String input;			//User input
		
		//Scanner object for keyboard input
		Scanner keyboard = new Scanner(System.in);
		
		//Calculate object to access methods
		Calculate calculator = new Calculate();
		
		//Display welcome message
		System.out.println("\t*****Sum and multiplication calculator*****");
		
		//Repeat the loop until the user enters something other than "Y" or "y"
		do
		{
			//Prompt for two integers
			System.out.print("\nEnter two integers: ");
			
			//Read the next two integers from the keyboard
			number1 = keyboard.nextInt();
			number2 = keyboard.nextInt();
		
			//Prompt for command to exectute
			System.out.print("\nEnter \"add\" to get the sum of the even numbers from the first number to the second number\n" + 
							"or \"multiply\" to multiply the two numbers: ");
			
			//Read next String from keyboard
			input = keyboard.next();
		
			//If the input is neither of the possible commands display error message
			//and ask for new input until a possible command is entered
			while (!input.equals("add") && !input.equals("multiply"))
			{
				//Display error message
				System.out.print("Please enter \"add\" or \"multiply\": ");
				
				//Read next String from keyboard
				input = keyboard.next();
			} //end while loop
		
			//If the requested command is "add"
			if(input.equals("add"))
			{
				//If the first number is odd or is greater than the second number
				//display error message and ask for two new numbers until the criteria are satisfied
				while(number1 > number2 || number1 % 2 != 0)
				{
					//Display error message and prompt for new input
					System.out.println("\nThe first number must be even and less than or equal to the second number.");
					System.out.print("Please enter two new numbers: ");
					
					//Read the next two integers from the keyboard
					number1 = keyboard.nextInt();
					number2 = keyboard.nextInt();
				} //end wihle loop
				
				//Call the Calculate.add method and output the results
				System.out.println("\nThe sum of the even numbers from " + number1 + " to " + number2 +
									" is " + calculator.add(number1, number2));
			} //end if
			
			//If the command is not "add" then it is "multiply"
			else
			{
				//Call the Calculate.multiply method and output the results
				System.out.println("\nThe product of " + number1 + " and " + number2 +
									" is " + calculator.multiply(number1, number2));
			} //end else
		
			
			System.out.print("\nWould you like to enter more numbers? ");
			input = keyboard.next();
		} while(input.equals("Y") || input.equals("y")); //end do-while loop
		
		System.out.println("\n\nProgrammer: Adam Holt");
		
		//Close Scanner object
		keyboard.close();
	} //end Main method

} //end Driver class definition
