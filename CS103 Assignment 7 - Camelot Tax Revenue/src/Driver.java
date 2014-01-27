import javax.swing.*;

/**
 * Driver class for the Camelot Tax Calculator
 * Creates and add a TaxPanel object
 * @author Adam Holt
 * @date 11/20/2013
 */
public class Driver extends JFrame
{
	//Default serial ID
	private static final long serialVersionUID = 1L;

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args)
	{
		new Driver();
	}

	/**
	 * Default constructor
	 */
	public Driver()
	{
		setSize(500,500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new TaxPanel());
		setVisible(true);
	}
}