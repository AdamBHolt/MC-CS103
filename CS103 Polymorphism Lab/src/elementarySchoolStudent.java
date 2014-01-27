/**
 * elementary school class definition
 * @author JMYERS
 *
 */

public class elementarySchoolStudent extends Student{
	private String elementarySchoolName;
	private String teachersName;
	private int homeroom;

	/**
	 * Constructor
	 * @param n name
	 * @param a age
	 * @param add address
	 * @param elemsch elementary school name
	 * @param teacher teacher name
	 * @param room homeroom number
	 */
	public elementarySchoolStudent(String n, int a,
			String add, String elemsch, String teacher,
			int room)
	{
	    super(n, a, add);
	    elementarySchoolName = elemsch;
	    teachersName = teacher;
	    homeroom = room;
		 // put in code for constructor
		 // call constructor for parent class 
	}
	
	/**
	 * Returns teacher's name
	 * @return teacher's name
	 */
	public String getTeachersName(){return teachersName;}

	/**
	 * Returns Elementary School Name
	 * @return elementary school name
	 */
	public String getElemSchoolName() {return elementarySchoolName;}

	/**
	 * Returns Home room number
	 * @return home room number
	 */
	public int getHomeRoom() {return homeroom;}

	/**
	 * Prints out details of elementary school student
	 */
	public String printStudent()
	{
	    return super.toString() + "\nElementary School: " + elementarySchoolName + "\nTeacher: " + teachersName + "\nHomeroom: " + homeroom;

		// put in code for printStudent
		// use toString from parent class
	}
}
