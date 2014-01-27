/**
 * abstract student class definition
 * @author JMYERS
 *
 */

public abstract class Student{
   private String name;
   private int age;
   private String address;

   /**
    * Constructor
    * @param n name
    * @param a age
    * @param add address
    */
   public Student(String n, int a, String add)
   { name = n; age = a; address = add; }
   
   /**
    * Returns Student name
    * @return student name
    */
   public String getName(){return name;}
   
   /**
    * Returns student age
    * @return student age
    */
   public int getAge(){return age;}
   
   /**
    * Returns student address
    * @return student address
    */
   public String getAddress(){return address;}
   
   /**
    * Prints out details of a student
    * @return details of a student
    */
   public String toString()
   {
	   String result = "";
	   result = name + "\n" + "Age: "+ age + "\n"+ "Address: " + address;
	   return result;
   }
   
   /**
    * Print details of a student
    * @return details of a student
    */
   public abstract String printStudent();
}
