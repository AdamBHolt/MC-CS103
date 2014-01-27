import java.util.*;

/**
 * This class creates instances of the CreditCard class
 * And provides methods to validate the card using the Luhn Algorithm
 * Date 10/16/13
 * @author Adam Holt
 */
public class CardValidator
{
	//ArraList to hold CreditCard instances
	private ArrayList<CreditCard> cards;

	/**
	 * Default constructor
	 */
	public CardValidator()
	{
		cards = new ArrayList<>();
	}

	/**
	 * Constructor that takes an ArrayList of CreditCard objects
	 * Sets the reference of cards to the same reference as the passed ArrayList 
	 * @param list ArrayList of CreditCard objects
	 */
	public CardValidator(ArrayList<CreditCard> list)
	{
		cards = list;
	}

	/**
	 * Checks if a credit card is valid based on the Luhn Algorithm
	 * Valid credit card information is used to create a new CreditCard instance
	 * and the instance is added to the ArrayList
	 * @param name Cardholder name
	 * @param type Card type
	 * @param number Card number
	 * @return true indicates a valid card, false indicates an invalid card
	 */
	public boolean validateCard(String name, String type, String number)
	{
		//If either the type or the length are invalid, return false
		if(!checkType(type, number) || !checkLength(type, number))
			return false;

		//Store original number
		String originalNumber = number;

		//Reverse the digits of the number and double every other digit
		number = reverseNumber(number);

		//If the sum of the digits of the number is a multiple of 10
		//then the card is valid - create a new CreditCard instance,
		//add it to the ArrayList and return true
		if(addDigits(number) % 10 == 0)
		{
			cards.add(new CreditCard(name, type, originalNumber));
			return true;
		}

		//Otherwise, the card is invalid - return false
		else
			return false;
	}

	/**
	 * Converts each CreditCard instance in the ArrayList into a String
	 * @return String of all valid cards
	 */
	public String getValidCards()
	{
		//String made up of each valid card
		String validCards = "";

		//Call the toString method for each object in the ArrayList
		//Concatenate each String with the total String
		for(CreditCard card: cards)
		{
			validCards += card + "\n";
		}

		//Return the String of all cards
		return validCards;
	}

	/**
	 * Reverse the digits of a credit card number stored as a String
	 * Doubles every other digit to be used in the Luhn Algorith
	 * @param num The original number
	 * @return The original number with all the digits in reverse order with every other digit doubled
	 */
	private String reverseNumber(String num)
	{
		//The reversed number to be returned
		String newNumber = "";

		//Process each digit in the String starting with the last
		for(int i=num.length()-1; i>=0; i--)
		{
			//Cast the character at index i as an int
			int digit = Integer.parseInt(Character.toString(num.charAt(i)));;

			//Double every other digit in the number
			if(i%2 == 0)
			{
				digit = doubleDigit(digit);
			}

			//Add the String equivalent of each digit to the total String
			newNumber = newNumber + digit;
		}

		//Return the reversed number
		return newNumber;
	}

	/**
	 * Doubles an int - if the resulting int is two digits the digits are added together
	 * @param dig Digit to be doubled
	 * @return Double value of the int or the sum of the doubled int's digits
	 */
	private int doubleDigit(int dig)
	{
		//Multiply the digit by 2 and reassign to itself
		dig *= 2;

		//If the digit is greater than 9 cast the int as a String
		//Cast each char of the string back to an int and add them together
		//Assign the resulting number to the digit
		if(dig>9)
		{
			dig = Integer.parseInt(Character.toString(Integer.toString(dig).charAt(0))) +
					Integer.parseInt(Character.toString(Integer.toString(dig).charAt(1)));
		}

		//Return the doubled digit
		return dig;
	}

	/**
	 * Add all of the digits in a number stored as a String
	 * @param num The number whose digits are to be added together
	 * @return The total value of all the digits
	 */
	private int addDigits(String num)
	{
		//Accumulator - initialized to 0
		int total = 0;

		//Cast each digit of the String number to an int and add its value to the total
		for(int i=0; i<num.length(); i++)
		{
			total += Integer.parseInt(Character.toString(num.charAt(i)));
		}

		//Return the total
		return total;
	}

	/**
	 * Check if the credit card type is valid based on the prefix of the number
	 * @param t Card type
	 * @param n Card number
	 * @return true if the card is valid, false if it is not
	 */
	private boolean checkType(String t, String n)
	{
		//Switch statement based on the first digit of the number
		switch(n.charAt(0))
		{
		case '3':
			//If the first digit is 3 and the card type is not
			//American Express it is invalid - return false
			if(!t.equals("AX"))
				return false;
			//If the second digit is 4 or 5 the number is valid - return true
			if(n.charAt(1) == '4' || n.charAt(1) == '5')
				return true;
			//Otherwise the card is invalid - return false
			else
				return false;
		case '4':
			//If the first digit is 4 and the card type is not
			//Visa it is invalid - return false
			if(!t.equals("V"))
				return false;
			//Otherwise the card is valid - return true
			else
				return true;
		case '5':
			//If the first digit is 5 and the card type is not
			//MasterCard it is invalid - return false
			if(!t.equals("MC"))
				return false;	
			//If the second digit is between 1 and 5 inclusive the number is valid - return true
			if(n.charAt(1) >= '1' && n.charAt(1) <= '5')
				return true;
			//Otherwise the card is invalid - return false
			else
				return false;
		case '6':
			//If the first digit is 6 and the card type is not
			//Discover it is invalid - return false
			if(!t.equals("D"))
				return false;
			//If the second digit is 5 the card is valid - return true
			if(n.charAt(1) == '5')
				return true;
			//If the first 4 digits are 6011 the card is valid - return true
			if(n.substring(0,4).equals("6011"))
				return true;
			//If the first 6 digits are between 622126 and 622925 inclusive the card is valid - return true
			if(n.substring(0,6).compareTo("622125")>0 && n.substring(0,6).compareTo("622926")<0)
				return true;
			//If the first 3 digits are between 644 and 649 inclusive the card is valid - return true
			if(n.substring(0,3).compareTo("643")>0 && n.substring(0,3).compareTo("650")<0)
				return true;
			//Otherwise the card is invalid - return false
			else
				return false;
		default:
			//If the first digit is anything other than 3, 4, 5, or 6 the card is invalid - return false
			return false;
		}
	}

	/**
	 * Check if the card type is valid based on the length of the number
	 * @param t Card type
	 * @param n Card number
	 * @return true if the card is valid, false if it is not
	 */
	private boolean checkLength(String t, String n)
	{
		//If the card type is American Express it must be 15 digits
		//If the card type is MasterCard it must be 16 digits
		//If the card type is Visa is must be either 13 or 16 digit
		//If the card type is Discover it must be 16 digits
		if((t == "AX" && n.length()!=15)
				|| (t == "MC" && n.length()!=16)
				|| (t == "V" && (n.length()!=13 && n.length()!=16))
				|| (t == "D" && n.length()!=16))
			//If the length of the number does not match the type the card is invalid - return false
			return false;
		//Otherwise the card is valid - return true
		else
			return true;
	}
}