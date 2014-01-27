/** 
 * high school class definition
 * @author JMYERS
 *
 */

public class highSchoolStudent extends Student{
	private String highSchoolName;
	private String counselorName;
	private int yearOfGraduation;
	private double gpa;

	/**
	 * Constructor
	 * @param n name
	 * @param a age
	 * @param add address
	 * @param highsch high school name
	 * @param counselor counselor
	 * @param year year of graduation
	 * @param g gpa
	 */
	public highSchoolStudent(String n, int a, String add,
			String highsch, String counselor,
			int year, double g)
	{
	    super(n, a, add);
	    highSchoolName = highsch;
	    counselorName = counselor;
	    yearOfGraduation = year;
	    gpa = g;
		// put in code for constructor
		// call constructor for parent class
	}

	/**
	 * Returns Counselor's name
	 * @return counselor's name
	 */
	public String getCounselor(){return counselorName;}

	/**
	 * Returns gpa
	 * @return gpa
	 */
	public double getGpa(){return gpa;}

	/**
	 * Returns high school name
	 * @return high school name
	 */
	public String getHighSchoolName() {return highSchoolName;}

	/**
	 * Returns graduation year
	 * @return graduation year
	 */
	public int getGraduationYear() {return yearOfGraduation;}

	/**
	 * Prints out details of the High School Student
	 * @return details of the High School Student
	 */
	public String printStudent()
	{
	    return super.toString() + "\nHigh School: " + highSchoolName + "\nCounselor: " + counselorName + "\nGPA: " + gpa;
		// put in code for printStudent
		// use toString from parent class
	}
}
