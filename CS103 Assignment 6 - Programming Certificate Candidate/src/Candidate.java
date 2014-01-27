import java.text.DecimalFormat;

/**
 * This class holds the name, grades, and GPA for a graduate candidate
 * It provides methods to determine the GPA and graduation status 
 * @date 11/6/13
 * @author Adam Holt
 */
public class Candidate {

	//Instance variable declarations
	
	//Last name
	private String lName;
	//First name
	private String fName;
	//Array of grades
	private String[] grades = {"","","","","",""};
	//Average GPA
	private double averageGPA;
	//Numeric values for each grade
	private final double A=4.0, B=3.0, C=2.0, D=1.0, E=0.0, F=0.0;

	/**
	 * Default constructor
	 */
	public Candidate()
	{
		setFName("");
		setLName("");
	}

	/**
	 * Constructor takes strings representing the candidate's name and grades
	 * @param f First name
	 * @param l Last name
	 * @param g1 Grade for CS110
	 * @param g2 Grade for CS140
	 * @param g3 Grade for CS226
	 * @param g4 Grade for CS249
	 * @param g5 Grade for CS213
	 * @param g6 Grade for CS214
	 */
	public Candidate(String f, String l, String g1, String g2, String g3, String g4, String g5, String g6)
	{
		//Set the data members
		setFName(f);
		setLName(l);
		setGrades(g1,g2,g3,g4,g5,g6);
	}

	/**
	 * Setter to set the last name
	 * @param l Candidate's last Name
	 */
	public void setLName(String l)
	{
		lName = l;
	}

	/** Getter to get the last name
	 * @return Candidate's last Name
	 */
	public String getLName()
	{
		return lName;
	}

	/**
	 * Setter to set the first name
	 * @param l Candidate's first Name
	 */
	public void setFName(String f)
	{
		fName = f;
	}

	/** Getter to get the first name
	 * @return Candidate's first Name
	 */
	public String getFName()
	{
		return fName;
	}

	/**
	 * Setter to set each of the grades in the array
	 * @param g1 Grade for CS110
	 * @param g2 Grade for CS140
	 * @param g3 Grade for CS226
	 * @param g4 Grade for CS249
	 * @param g5 Grade for CS213
	 * @param g6 Grade for CS214
	 */
	public void setGrades(String g1, String g2, String g3, String g4, String g5, String g6)
	{
		//Assign grades as upper case
		grades[0] = g1.toUpperCase();
		grades[1] = g2.toUpperCase();
		grades[2] = g3.toUpperCase();
		grades[3] = g4.toUpperCase();
		grades[4] = g5.toUpperCase();
		grades[5] = g6.toUpperCase();
	}

	/**
	 * Getter to return the grades
	 * @return Reference to the array containing the grades
	 */
	public String[] getGrades()
	{
		return grades;
	}

	/**
	 * Getter to get the candidates average GPA
	 * @return Candidate's average GPA
	 */
	public double getGPA()
	{
		//Recalculate the average GPA prior to returning
		calculateGPA();
		return averageGPA;
	}

	/**
	 * Provides a string representation of the candidate's graduation status based on grades and GPA
	 * @return The candidates status for graduation
	 */
	public String checkStatus()
	{
		//Recalculate the GPA
		calculateGPA();

		//Test each grade in the array
		for(String grade : grades)
			//If any grade is F or D the candidate is ineligible
			if(grade.equals("F") || grade.equals("E") || grade.equals("D"))
				return "Ineligible";
		//If the average GPA is greater than or equal to 3.5 the candidate is eligible for scholarship
		if(averageGPA >= 3.5)
			return "Scholarship";
		//If the average GPA is between 3.0 and 3.5 the candidate is eligible for honors
		else if(averageGPA < 3.5 && averageGPA > 3.0)
			return "Honors";
		//All other GPAs are eligible for graduation
		else return "Eligible";
	}

	/**
	 * Calculates and sets the average GPA for the candidate
	 */
	private void calculateGPA()
	{
		//Cumulative value of the grades
		double total = 0.0;
		
		//Convert each grade in the array to its numeric value and add it to the total
		for(String grade : grades)
			total += gradeValue(grade);
		
		//Divide the total by 6 (number of grades) and set the average GPA variable
		averageGPA = total / 6;
	}

	/**
	 * Takes a String representation of a grade and returns the numeric value
	 * @param g Letter grade to be converted
	 * @return Numeric value of the letter grade
	 */
	private double gradeValue(String g)
	{
		//Convert the letter grade to a char and switch
		//Return the constant numeric value of each grade
		switch(g.charAt(0))
		{
		case 'A':
			return A;
		case 'B':
			return B;
		case 'C':
			return C;
		case 'D':
			return D;
		case 'E':
			return E;
		case 'F':
			return F;
		//If an invalid grade is supplied return 0.0
		default:
			return 0.0;
		}
	}

	/**
	 * Converts the candidate to a String representation
	 * @return Candidate name, grades, average GPA, and graduation status
	 */
	public String toString()
	{
		calculateGPA();
		DecimalFormat frmt = new DecimalFormat("#.000");
		return getFName() + " " + getLName() + " CS110: " + grades[0] + " CS140: " + grades[1] +
				" CS226: " + grades[2] + " CS249: " + grades[3] + " CS213: " + grades [4] +
				" CS214: " + grades[5] + " Average GPA: " + frmt.format(averageGPA) + " Status: " + checkStatus();
	}
}