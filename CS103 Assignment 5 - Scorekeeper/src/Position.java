/**
 * Enumerated type to set the position for a basketball player
 * Date: 10/28/13
 * @author Adam Holt
 *
 */
public enum Position {
	
	//Valid values
	GUARD ("Guard"), 
	CENTER ("Center"),
	FORWARD ("Forward");
	
	//String representation of the value
	private String position;
	
	/**
	 * No arg constructor
	 */
	Position()
	{
		position = "";
	}
	
	/**
	 * Constructor takes a string to set the position instance variable
	 * @param pos String name of the position
	 */
	Position(String pos)
	{
		position = pos;
	}
	
	/**
	 * Returns the string value of the position
	 */
	public String toString()
	{
		return position;
	}
}