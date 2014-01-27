/**
 * Stores the first name, last name, and position of a basketball player
 * Date: 10/28/13
 * @author Adam Holt

 */
public class Player {

	//Instance variable declarations
	
	//First and last names
	private String fName, lName;
	//Player position
	private Position position;
	
	
	/**
	 * No arg constructor 
	 */
	public Player()
	{
		//Call setter for each instance variable
		setFName("");
		setLName("");
		setPosition(null);
	}
	
	/**
	 * Constructore - takes the Strings to set the instance variables for the object
	 * @param f Player's first name
	 * @param l Player's last name
	 * @param p Player's position
	 */
	public Player(String f, String l, String p)
	{
		//Call setter for each instance variable
		setFName(f);
		setLName(l);
		setPosition(p);
	}
	
	/**
	 * Returns the first name, last name, and position as a concatenated String
	 * @return String representation of the object
	 */
	public String toString()
	{
		return fName + " " + lName + " Position: " + position;
	}
	
	/**
	 * Set the player's first name
	 * @param f Player's first name
	 */
	public void setFName(String f)
	{
		fName = f;
	}
	
	/**
	 * Get the players first name
	 * @return Player's first name
	 */
	public String getFName()
	{
		return fName;
	}
	
	/**
	 * Set the player's last name
	 * @param f Player's last name
	 */
	public void setLName(String l)
	{
		lName = l;
	}
	
	/**
	 * Get the players last name
	 * @return Player's last name
	 */
	public String getLName()
	{
		return lName;
	}
	
	/**
	 * Set the player's position
	 * @param p Player's position
	 */
	public void setPosition(String p)
	{
		//Set the position to the appropriate enumerated value based on the passed String
		//If an invalid String is passed, set the position to null
		if(p.equals("Center"))
			position = Position.CENTER;
		else if(p.equals("Guard"))
			position = Position.GUARD;
		else if(p.equals("Forward"))
			position = Position.FORWARD;
		else
			position = null;
	}
	
	/**
	 * Get the players position
	 * @return Player's position
	 */
	public Position getPosition()
	{
		return position;
	}
}