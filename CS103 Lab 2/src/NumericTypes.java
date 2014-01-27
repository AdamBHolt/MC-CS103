/**
   This program demonstrates how numeric types and operators behave in Java
*/

//TASK #2  Add import statement here to use the Scanner class
import java.util.Scanner;
//TASK #2  (Alternate) Add import statment to use JOptionPane class
//import javax.swing.JOptionPane;

public class NumericTypes
{
	public static void main (String [] args)
	{
		//TASK #2 Create a Scanner object here (not used for alternate)
		Scanner keyboard = new Scanner(System.in);
		
		//identifier declarations
		final int NUMBER = 2 ;		// number of scores
		final int SCORE1 = 100;		// first test score
		final int SCORE2 = 95;		// second test score
		final int BOILING_IN_F = 212;  // freezing temperature
		int fToC;						// temperature in celsius
		double average;				// arithmetic average
		String output;					// line of output to print out
		//TASK #2 declare variables used here
		String firstName;
		String lastName;
		String fullName;
		
		//TASK #3 declare variables used here
		char firstInitial;
		
		//TASK #4 declare variables used here
		double diameter;
		double radius;
		double volume;

		// Find an arithmetic average
		average = (SCORE1 + SCORE2) / NUMBER;
		output = SCORE1 + " and " + SCORE2 + " have an average of "
				+ average;
		System.out.println(output);

		// Convert Fahrenheit temperatures to Celsius
		fToC = (int) ((float)5/9 * (BOILING_IN_F - 32));
		output = BOILING_IN_F + " in Fahrenheit is " + fToC
			     + " in Celsius.";
		System.out.println(output);
		System.out.println();		// to leave a blank line

		// ADD LINES FOR TASK #2 HERE
		// prompt the user for first name
		System.out.print("Enter your first name: ");
		// read the user's first name
		firstName = keyboard.nextLine();
		// prompt the user for last name
		System.out.print("Enter your last name: ");
		// read the user's last name
		lastName = keyboard.nextLine();
		// concatenate the user's first and last names
		fullName = firstName + " " + lastName;
		// print out the user's full name 
		System.out.println("Your full name is " + fullName);

		/* 
		//Task #2 alternate
		//Prompt and read user's first name
		firstName = JOptionPane.showInputDialog("Enter your first name:");
		//Prompt and read user's last name
		lastName = JOptionPane.showInputDialog("Enter your last name:");
		//Concatenate user's first and last names
		fullName = firstName + " " + lastName;
		//Display user's full name
		JOptionPane.showMessageDialog(null, "Your full name is " + fullName);
		//End Task #2 alternate
		*/
		
		System.out.println();		// to leave a blank line
		
		// ADD LINES FOR TASK #3 HERE
		// get the first character from the user's first name
		firstInitial = firstName.charAt(0);
		// print out the user's first initial
		System.out.println("Your first initial is " + firstInitial);
		// convert the user's full name to all capital letters
		fullName = fullName.toUpperCase();
		// print out the user's full name in all capital letters
		System.out.println("Your name in all capital letters is " + fullName + 
				"\nAnd has " + fullName.length()+ " characters");
		
		System.out.println();		// to leave a blank line
		
		// ADD LINES FOR TASK #4 HERE
		// prompt the user for a diameter of a sphere
		System.out.print("Enter the diameter of a sphere: ");
		// read the diameter
		diameter = keyboard.nextFloat();
		// calculate the radius
		radius = diameter / 2;
		// calculate the volume 
		volume = (float)4/3 * (Math.PI * Math.pow(radius, 3.0));
		// print out the volume
		System.out.println("The volume of the sphere is " + volume);
		//System.exit(0); //exit line to close JOptionPane thread
	}	
}