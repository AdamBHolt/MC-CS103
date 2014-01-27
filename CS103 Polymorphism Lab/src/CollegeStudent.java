/** 
 * College student definition
 * @author JMYERS
 *
 */

public class CollegeStudent extends Student{
   private String collegeName;
   private String major;
   private double gpa;

   /**
    * Constructor
    * @param n name
    * @param a age
    * @param add address
    * @param college college name
    * @param mjr major
    * @param g gpa
    */
   public CollegeStudent(String n, int a, String add,
          String college, String mjr, double g)
   {
       super(n, a, add);
       collegeName = college;
       major = mjr;
       gpa = g;
	   // put in code for constructor
	   // call constructor for parent class 
   }

   /**
    * Returns major
    * @return major
    */
   public String getMajor(){return major;}
  
   /**
    * Returns gpa
    * @return gpa
    */
   public double getGpa(){return gpa;}
   
   /**
    * Returns college name
    * @return college name
    */
   public String getCollegeName() {return collegeName;}

   /**
    * prints out details of College Student
    * @return details of College Student
    */
   public String printStudent()
   {
	    return super.toString() + "\nCollege: " + collegeName + "\nMajor: " + major + "\nGPA: " + gpa;

	   // put in code for printStudent
	   // use toString from parent class
   }
}
