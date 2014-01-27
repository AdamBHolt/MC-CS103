//Import ArrayList class package
import java.util.ArrayList;

/**
 * Data manager class for basketball scorekeeper
 * Contains an ArrayList of Player objects
 * Date: 10/28/13
 * @author Adam Holt
 *
 */
public class Team {

	//Instance variable declarations
	
	//ArrayList to hold Player objects
	private ArrayList<Player> roster;
	//Static ints to track number of players
	private static int numPlayers, numForwards, numGuards, numCenters;
	//Total number of Team objects
	private static int numTeams = 0;
	//Name of the team
	private String teamName;

	/**
	 * No arg constructor
	 */
	public Team()
	{
		//Create the ArrayList
		roster = new ArrayList<>();
		//Set team name to empty String
		teamName = "";
		//Set number of players to 0
		numPlayers=numForwards=numGuards=numCenters=0;
		//Increment the number of teams
		numTeams++;
	}

	/**
	 * Constructor takes a string parameter for the team name
	 * @param t Name of the team
	 */
	public Team(String t)
	{
		//Create the ArrayList
		roster = new ArrayList<>();
		//Set the team name to the string parameter
		teamName = t;
		//Set the number of players to 0
		numPlayers=numForwards=numGuards=numCenters=0;
		//Increment the number of teams
		numTeams++;
	}

	/**
	 * Adds a player to the current team
	 * Takes parameters to set the members of the Player object
	 * @param f First name of the player
	 * @param l Last name of the player
	 * @param p Position of the player
	 * @return Appropriate error message if the player is not added, otherwise null
	 */
	public String addPlayer(String f, String l, String p)
	{
		//If the total number of players on the team is 5 or greater return an error message
		if(numPlayers>=5)
			return "There are already 5 members on this team\nPlayer not added";
		
		//Check the first character of the passed position and check the number
		//of players in that position
		//If the allowable number has already been reached return an error message
		//If not increment the corresponding count of players by position
		switch(p.charAt(0))
		{
		case 'G':
			if(numGuards>=2)
				return "There are already two guards on this team\nPlayer not added";
			else
				numGuards++;
			break;
		case 'C':
			if(numCenters>=1)
				return "There is already a center on this team\nPlayer not added";
			else
				numCenters++;
			break;
		case 'F':
			if(numForwards>=2)
				return "There are already two forwards on this team\nPlayer not added";
			else numForwards++;
			break;
		}

		//If the number of players hasn't reached its maximum
		//Increment the total player count and add the new player to the ArrayList
		//Return null to indicate that the player was added successfully
		numPlayers++;
		roster.add(new Player(f, l, p));
		return null;
	}

	/**
	 * Get the total number of players on the team
	 * @return Total number of players on the team
	 */
	public static int getNumPlayers()
	{
		return numPlayers;
	}
	
	public static int getNumTeams()
	{
		return numTeams;
	}

	/**
	 * Return the team name and the name and position of each player on the team
	 * @return String value of the team name and all of the players
	 */
	public String printTeam()
	{
		//Create the String to be returned and set it to the team name
		String	theTeam = teamName  + "\n";

		//For each element in the ArrayList add the String version of the Player
		//to the String to be returned
		for(Player member : roster)
		{
			theTeam += member + "\n";
		}
		//Return the complete String
		return theTeam;
	}

	/**
	 * Return the team name and the name and position of each player on the team
	 */
	public String toString()
	{
		//Create the String to be returned and set it to the team name
		String theTeam = teamName + "\n";
		
		//For each element in the ArrayList add the String version of the Player
				//to the String to be returned
		for(Player member: roster)
		{
			theTeam += member + "\n";
		}
		//Return the complete String
		return theTeam;
	}
}