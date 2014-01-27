/**
 * This class stores the data for a credit card
 * Date: 10/16/13
 * @author Adam Holt
 */
public class CreditCard
{
	//Declare class members

	//Cardholder name
	private String name;
	//Card type
	private String type;
	//Card number
	private String number;

	//Credit card type name constants
	private final String AX = "American Express";
	private final String V = "Visa";
	private final String D = "Discover";
	private final String MC = "MasterCard";

	/**
	 * Default constructor
	 */
	public CreditCard()
	{
		setName("");
		setType("");
		setNumber("");
	}

	/**
	 * Constructor with parameters for the card
	 * @param nam Cardholder name
	 * @param typ Card type
	 * @param num Card number
	 */
	public CreditCard(String nam, String typ, String num)
	{
		//Call setter for each member
		setName(nam);
		setType(typ);
		setNumber(num);
	}

	/**
	 * Converts the data members of and object to a String
	 */
	public String toString()
	{
		return getName() + " " + getType() + " " + getNumber();
	}

	/**
	 * Set the name field
	 * @param nam Cardholder name
	 */
	public void setName(String nam)
	{
		name = nam;
	}

	/**
	 * Get the name field
	 * @return Cardholder name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Set the card type
	 * @param typ Card type
	 */
	public void setType(String typ)
	{
		type = typ;
	}

	/**
	 * Get the card type
	 * @return Name of the card type
	 */
	public String getType()
	{
		//Return the final String associated with the currect card type
		if(type.equals("AX"))
			return AX;
		else if(type.equals("V"))
			return V;
		else if(type.equals("D"))
			return D;
		else if(type.equals("MC"))
			return MC;
		else return "";
	}

	/**
	 * Set the card number
	 * @param num Card number
	 */
	public void setNumber(String num)
	{
		number = num;
	}

	/**
	 * Get the card number
	 * @return Card number
	 */
	public String getNumber()
	{
		return number;
	}
}