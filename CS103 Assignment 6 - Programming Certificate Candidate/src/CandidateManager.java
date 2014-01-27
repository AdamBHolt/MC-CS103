import java.text.DecimalFormat;
import java.util.*;

/**
 * This class provides a data structure for objects of the Candidate class
 * @date 11/6/13
 * @author Adam Holt
 */
public class CandidateManager {

	//ArrayList to hold Candidate objects
	ArrayList<Candidate> candidates;

	/**
	 * Default constructor
	 */
	public CandidateManager()
	{
		candidates = new ArrayList<>();
	}

	/**
	 * Adds an existing Candidate object to the ArrayList
	 * @param newCandidate Existing Candidate object
	 */
	public void addCandidate(Candidate newCandidate)
	{
		candidates.add(newCandidate);
	}

	/**
	 * Adds a new Candidate object to the ArrayList based on name and grades
	 * @param f First name
	 * @param l Last name
	 * @param g1 Grade for CS110
	 * @param g2 Grade for CS140
	 * @param g3 Grade for CS226
	 * @param g4 Grade for CS249
	 * @param g5 Grade for CS213
	 * @param g6 Grade for CS214
	 */
	public void addCandidate(String f, String l, String g1, String g2, String g3, String g4, String g5, String g6)
	{
		//Create a new candidate object and add it to the ArrayList
		candidates.add(new Candidate(f, l, g1, g2, g3, g4, g5, g6));
	}

	/**
	 * Calculates the average GPA of all candidates in the ArrayList
	 * @return Average GPA of Candidates in the ArrayList
	 */
	public double getAvgGPA()
	{
		//Accumulator to hold the total GPA
		double total = 0;
		
		//Add the GPA of each candidate to the total
		for(Candidate candidate : candidates)
			total += candidate.getGPA();
		
		//Divide the total by the number of candidates and return the result
		return total / getNumCandidates();
	}

	/**
	 * Gets the name, grades, GPA, and graduation status of all of the candidates
	 * @return Two dimensional array containing information of all of the candidates in the ArrayList
	 */
	public String[][] getcandidates()
	{
		//The number of "rows" in the array is the same as the number of candidates
		String[][] returnArray = new String[getNumCandidates()][10];
		//Format to display the grade values
		DecimalFormat frmt = new DecimalFormat("#.000");

		//Iterate through each candidate
		for(int i=0; i<getNumCandidates(); i++)
		{
			//Set the first two elements in the current row to the names
			returnArray[i][0] = candidates.get(i).getFName();
			returnArray[i][1] = candidates.get(i).getLName();

			//Set the next six elements in the current row to the grades
			for (int j=0;j<6;j++)
				returnArray[i][j+2] = candidates.get(i).getGrades()[j];
			
			//Set the ninth element in the current row to the average GPA
			returnArray[i][8] = frmt.format(candidates.get(i).getGPA());
			
			//Set the final element in the current row to the graduation status
			returnArray[i][9] = candidates.get(i).checkStatus();
		}
		//Return the complete array
		return returnArray;
	}

	/**
	 * Gets the current number of candidates
	 * @return Total number of candidates in the ArrayList
	 */
	public int getNumCandidates()
	{
		return candidates.size();
	}

	/**
	 * Returns a String representation of all of the candidates in the ArrayList
	 * @return NAmes, grades, GPA, and graduation status of each candidate in the ArrayList
	 */
	public String toString()
	{
		//The String to be returned
		String returnString = "";
		
		//Call the toString method for each candidate in the array and concatenate it with the current String
		for(Candidate candidate : candidates)
			returnString += candidate + "\n";
		
		//Return the complete String
		return returnString;
	}
}