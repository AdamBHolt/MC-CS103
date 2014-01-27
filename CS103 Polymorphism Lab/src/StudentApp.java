import java.util.ArrayList;
import java.util.Scanner;
/**
 * Creates Student objects, stores them in an arraylist
 * prints out the details of all the students in the arraylist
 * @author JMYERS
 *
 */
class StudentApp
{
	private static ArrayList<Student> students = new ArrayList<Student>();
	public static void main(String[] args) throws Exception
	{
            Scanner in = new Scanner(System.in);
            System.out.println("Please select type of object to create:");
            System.out.println(
                    "1) Elementry School\n2) High School\n3) College Student\n4) Print out all students\n5) Exit");
            int n = in.nextInt();

            while (n != 5) {
                if (n == 1) {
                	in.nextLine(); // get rid of end of line
                    System.out.println(
                            "You have selected to create a profile of a Elementry School Kid ..... ");
                    System.out.println("Please enter the full name: ");
                    String name = in.nextLine();
                    System.out.println("Please enter the Age: ");
                    int age = in.nextInt();
                    in.nextLine();  //get rid of end of line
                    System.out.println(
                            "Please enter the name of the Elementry School: ");
                    String eschool = in.nextLine();
                    System.out.println("Please enter the City: ");
                    String city = in.nextLine();
                    System.out.println("Please enter the name of the Teacher: ");
                    String tname = in.nextLine();
                    System.out.println("Please enter the Room No.: ");
                    int rno = in.nextInt();
                    students.add(new elementarySchoolStudent(name, age, city, eschool,
                            tname, rno));
                } else if (n == 2) {
                	in.nextLine(); // get rid of end of line
                    System.out.println(
                            "You have selected to create a profile of a High School Kid ..... ");
                    System.out.println("Please enter the full name: ");
                    String name = in.nextLine();
                    System.out.println("Please enter the Age: ");
                    int age = in.nextInt();
                    in.nextLine(); // get rid of end of line
                    System.out.println("Please enter the City: ");
                    String city = in.nextLine();
                    System.out.println(
                            "Please enter the name of the High School: ");
                    String eschool = in.nextLine();
                    System.out.println(
                            "Please enter the name of the Counselor: ");
                    String tname = in.nextLine();
                    System.out.println("Please enter the Year of Graduation: ");
                    int ygr = in.nextInt();
                    System.out.println("Please enter the GPA: ");
                    double gpa = in.nextDouble();
                    students.add(new highSchoolStudent(name, age, city, eschool, tname,
                                              ygr, gpa));
                } else if (n == 3) {
                	in.nextLine(); // get rid of end of line
                    System.out.println(
                            "You have selected to create a profile of a College Kid ..... ");
                    System.out.println("Please enter the full name: ");
                    String name = in.nextLine();
                    System.out.println("Please enter the Age: ");
                    int age = in.nextInt();
                    in.nextLine(); // get rid of end of line
                    System.out.println("Please enter the City: ");
                    String city = in.nextLine();
                    System.out.println(
                            "Please enter the name of the College Name: ");
                    String cschool = in.nextLine();
                    System.out.println("Please enter the name of the Major: ");
                    String maj = in.nextLine();
                    System.out.println("Please enter the GPA: ");
                    double gpa = in.nextDouble();
                    students.add(new CollegeStudent(name, age, city, cschool, maj, gpa));
                } else if(n ==4)
                {
                	printReport();
                }
                System.out.println("Please select type of object to create:");
                System.out.println(
                        "1) Elementry School\n2) High School\n3) College Student\n4) Print out all students\n5) Exit");
               n = in.nextInt();
            }
            in.close();
        }
	
	public static void printReport()
	   {
	    for(Student student : students)
		System.out.println(student.printStudent() + "\n");
	      	// fill in code for printing the details of all the student object in the arraylist
			// use the printStudent for each of the student objects
	   }
}
