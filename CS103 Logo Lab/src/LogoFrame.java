import javax.swing.*;

/**
 * This class creates a frame and adds a panel with a logo drawn on it
 * Date: 10/7/13
 * @author Adam Holt
 */
public class LogoFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args)
	{
		new LogoFrame();
	}
	
	/**
	 * Default constructor
	 */
	public LogoFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		//Create an anonymous instance of LogoPanel and add it to the frame
		add(new LogoPanel());
		setVisible(true);
	}
}