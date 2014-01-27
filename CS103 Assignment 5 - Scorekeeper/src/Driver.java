//Import javax.swing package
import javax.swing.*;

/**
 * Create a JFrame and adds a new BasketballPanel to the JFrame
 * Date: 10/28/13
 * @author Adam Holt
 */
public class Driver extends JFrame
{
	//Default version ID
	private static final long serialVersionUID = 1L;
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		new Driver();
	}

	/**
	 * No arg constructor
	 */
	public Driver()
	{
		//Set the frame size
		setSize(325,400);
		//Prevent resizing the frame
		setResizable(false);
		//Set the title of the frame
		setTitle("Create Basketball Team");
		//Exit on close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Add a new BasketballPanel to the frame
		add(new BasketballPanel());
		//Show the frame
		setVisible(true);
	}
}