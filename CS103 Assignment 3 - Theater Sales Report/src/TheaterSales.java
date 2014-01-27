/**
 * This class stores the quantities for items sold in a theater
 * and calculates the sales of each item based on quantities sold
 * Date: 10/7/13
 * @author Adam Holt
 */
public class TheaterSales
{
	//Declare class members

	//Quantities of each item sold
	private int adultTickets;
	private int childTickets;
	private int popcorn;
	private int drinks;

	//Prices of each item
	private final double ADULT_TICKET_PRICE = 9.5;
	private final double CHILD_TICKET_PRICE = 5.75;
	private final double POPCORN_PRICE = 5.5;
	private final double DRINK_PRICE = 3.25;

	/**
	 * Default constructor
	 */
	public TheaterSales()
	{
		setAdultTickets(0);
		setChildTickets(0);
		setPopcorn(0);
		setDrinks(0);
	}

	/**
	 * Constructor with parameters for the quantity of each item sold
	 * @param a Quantity of adult tickets sold
	 * @param c Quantity of child tickets sold
	 * @param p Quantity of popcorn sold
	 * @param d Quantity of drinks sold
	 */
	public TheaterSales(int a, int c, int p, int d)
	{
		//Call setter for each item
		setAdultTickets(a);
		setChildTickets(c);
		setPopcorn(p);
		setDrinks(d);
	}

	/**
	 * Displays the quantity of each item sold
	 * @return Quantity of each item sold
	 */
	public String toString()
	{
		return "Adult Tickets: " + getAdultTickets() +
				"\nChild Tickets: " + getChildTickets() +
				"\nPopcorn: " + getPopcorn() +
				"\nDrinks: " + getDrinks();

	}

	/**
	 * Set the quantity of adult tickets
	 * @param a Quantity of adult tickets sold
	 */
	public void setAdultTickets(int a)
	{
		adultTickets = a;
	}

	/**
	 * Set the quantity of child tickets
	 * @param c Quantity of child tickets sold
	 */
	public void setChildTickets(int c)
	{
		childTickets = c;
	}

	/**
	 * Set the quantity of popcorn
	 * @param p Quantity of popcorn sold
	 */
	public void setPopcorn(int p)
	{
		popcorn = p;
	}

	/**
	 * Set the quantity of drinks
	 * @param d Quantity of drinks sold
	 */
	public void setDrinks(int d)
	{
		drinks = d;
	}

	/**
	 * Return number of adult tickets
	 * @return Quantity of adult tickets sold
	 */
	public int getAdultTickets()
	{
		return adultTickets;
	}

	/**
	 * Return the number of child tickets
	 * @return Quantity of child tickets sold
	 */
	public int getChildTickets()
	{
		return childTickets;
	}

	/**
	 * Return the number of popcorn
	 * @return Quantity of popcorn sold
	 */
	public int getPopcorn()
	{
		return popcorn;
	}

	/**
	 * Return the number of drinks
	 * @return Quantity of drinks sold
	 */
	public int getDrinks()
	{
		return drinks;
	}

	/**
	 * Calculate the value of adult tickets
	 * @return Monetary value of adult tickets sold
	 */
	public double adultTicketSales()
	{
		return adultTickets * ADULT_TICKET_PRICE;
	}

	/**
	 * Calculate the value of child tickets
	 * @return Monetary value of child tickets sold
	 */
	public double childTicketSales()
	{
		return childTickets * CHILD_TICKET_PRICE;

	}

	/**
	 * Calculate the value of popcorn
	 * @return Monetary value of popcorn sold
	 */
	public double popcornSales()
	{
		return popcorn * POPCORN_PRICE;
	}

	/**
	 * Calculate the value of drinks
	 * @return Monetary value of drinks sold
	 */
	public double drinkSales()
	{
		return drinks * DRINK_PRICE;
	}

	/**
	 * Calculates the total of all items sold
	 * @return Total value of all items sold
	 */
	public double totalSales()
	{
		//Call method for each item sold and return the total
		return adultTicketSales() + childTicketSales() + popcornSales() + drinkSales();
	}
}