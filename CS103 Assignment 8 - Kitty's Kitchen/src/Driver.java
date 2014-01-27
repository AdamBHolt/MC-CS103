import javax.swing.*;

/**
 * Main driver class for the Kitty's Kitchen application
 * @author Adam Holt
 * @date 12/4/13
 */
public class Driver extends JFrame
{
    //Deafult serial ID
    private static final long serialVersionUID = 1L;

    /**
     * Main method
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
	//Set the size
	setSize(700,600);
	//Prevent the frame from being resized
	setResizable(false);
	//Set the default close operation
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//Set the title
	setTitle("Kitty's Kitchen");
	//Add a KitchenPanel
	add(new KitchenPanel());
	//Display the frame
	setVisible(true);
    }
}