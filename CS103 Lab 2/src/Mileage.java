/**
   This program calculates mileage based on miles driven and gallons of gas used
   Adam Holt 9/9/13
*/

//import JOptionPane for dialog boxes
import javax.swing.JOptionPane;

public class Mileage
{

	public static void main(String[] args) //begin main method
	{
		
		//Variable Declarations
		String miles;   //miles driven
		String gallons; //gallons of gas used
		double mileage; //total mileage
		
		//Display welcome message
		JOptionPane.showMessageDialog(null, "This program will calculte mileage.");
		
		//Input number of miles driven
		miles = JOptionPane.showInputDialog("How many miles did you drive?");
		
		//Input number of gallons of gas used
		gallons = JOptionPane.showInputDialog("How many gallons of gas did you use?");
		
		//Divide miles by gallons to calculate mileage
		//The String variables are parsed for numerical value
		mileage = Double.parseDouble(miles) / Double.parseDouble(gallons);
		
		//Display the milage
		JOptionPane.showMessageDialog(null, "The total mileage is " +
									mileage + " miles per gallon.");
		
		//Close JOptionPane thread
		System.exit(0);
	} //end main method

} //end class definition
