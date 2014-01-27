/**
 This program converts a dollar amount into the least amount of
 bills and coins needed to make the total
 Adam Holt
 Assignment 1
 9/11/13
 */

import java.util.Scanner;  //import Scanner class for input

public class Money
{

	public static void main(String[] args) //begin main method
	{
		
		//Variable declarations
		double initialAmount; 	//initial entered dollar amount
		int totalMoney;			//dollar amount converted to int to control precision
		int twenties,			//amount of each denomination
			tens,
			fives,
			ones,
			quarters,
			nickels,
			dimes,
			pennies;
		
		//Display welcome method
		System.out.println("*****Welcome to the money converter*****" +
							"\nThis program will convert a dollar amount into" +
							"\nthe minimum bills and coins needed.\n");
		
		//Prompt for user to enter total dollar amount
		System.out.print("Enter an amount between $0 and $999.99: $");
		
		//Create new Scanner object for console input
		Scanner keyboard = new Scanner(System.in);
		
		//Get total dollar amount
		initialAmount = keyboard.nextDouble();
		
		//Multiply the total dollar value by 100 and cast as an int
		//to prevent loss of precision during calculations
		//Rounding initialAmount prevents further loss
		totalMoney = (int)(Math.round(initialAmount * 100));
		
		//Divide the total amount by 2000 to determine numer of 20 dollar bills
		//The result will be cast as an int and remove any remainder
		twenties = totalMoney / 2000;
		//Multiply the number of twenties by 2000 to determine their monetary value
		//Subtract the resulting amount from the current total
		totalMoney -= twenties * 2000;
		
		//Divide the total amount by 1000 to determine numer of 10 dollar bills
		//The result will be cast as an int and remove any remainder
		tens = totalMoney / 1000;
		totalMoney -= tens * 1000;

		//Divide the total amount by 500 to determine numer of 5 dollar bills
		//The result will be cast as an int and remove any remainder
		fives = totalMoney / 500;
		totalMoney -= fives * 500;

		//Divide the total amount by 100 to determine numer of 1 dollar bills
		//The result will be cast as an int and remove any remainder
		ones = totalMoney / 100;
		totalMoney -= ones * 100;

		//Divide the total amount by 25 to determine numer of quarters
		//The result will be cast as an int and remove any remainder
		quarters = totalMoney / 25;
		totalMoney -= quarters * 25;
		
		//Divide the total amount by 10 to determine numer of dimes
		//The result will be cast as an int and remove any remainder
		dimes = totalMoney / 10;
		totalMoney -= dimes * 10;
		
		//Divide the total amount by 5 to determine numer of nickels
		//The result will be cast as an int and remove any remainder
		nickels = totalMoney / 5;
		totalMoney -= nickels * 5;
		
		//Any remaining total represents the number of pennies
		pennies = totalMoney;
		
		//Output amount of each denomination
		System.out.println("\n$" + initialAmount + " is made up of:");		
		System.out.println("\t" + twenties + " 20 dollar bills");		
		System.out.println("\t" + tens + " 10 dollar bills");
		System.out.println("\t" + fives + " 5 dollar bills");
		System.out.println("\t"+ ones + " 1 dollar bills");
		System.out.println("\t" + quarters + " quarters");
		System.out.println("\t" + dimes + " dimes");
		System.out.println("\t" + nickels + " nickels");
		System.out.println("\t" + pennies + " pennies");

		System.out.println("\n\tProgrammer: Adam Holt");
		
		//close Scanner
		keyboard.close();
		
	} //end main method
} //end class definition