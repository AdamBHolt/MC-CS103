import javax.swing.*;

/**
 * This class creates a frame to hold a panel that is used to interact with a CandidateManager
 * @date 11/6/13
 * @author Adam Holt
 */
public class CandidateDriver extends JFrame
{
	//Default serial number
	private static final long serialVersionUID = 1L;

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Create a new driver object
		new CandidateDriver();
	}

	/**
	 * Default constructor
	 */
	public CandidateDriver()
	{
		//Set the frame title
		setTitle("Candidates for Graduation");
		//Set the frame size
		setSize(750,425);
		//Prevent the frame from being resized
		setResizable(false);
		//Set the default closer operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Add the GUI panel
		add(new CandidatePanel());
		//Display the frame
		setVisible(true);
	}
}