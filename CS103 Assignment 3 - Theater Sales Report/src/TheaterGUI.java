//Import class packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

/**
 * This class creates a GUI window to provide input and output for the
 * TheaterSales class
 * Date: 10/7/13
 * @author Adam Holt
 */
public class TheaterGUI extends JFrame
{
	/**
	 * main method for the class
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Create an anonymous instance of the class
		new TheaterGUI();
	}

	//Declare class members
	private static final long serialVersionUID = 1L;
	private TheaterSales theaterSales;							//Instance of the TheaterSales class
	private JPanel topPanel;									//Panel at the top of the frame
	private JPanel centerPanel;									//Panel in the center of the frame
	private JPanel bottomPanel;									//Panel at the bottom of the frame

	//Labels to display text on the frame
	private JLabel titleLabel = new JLabel("ACME Theater");	
	private JLabel sales = new JLabel("Sales");	
	private JLabel quantity = new JLabel("Quantity");
	private JLabel adultTickets = new JLabel("Adult Tickets");
	private JLabel childTickets = new JLabel("Child Tickets");
	private JLabel popcorn = new JLabel("Popcorn");
	private JLabel drinks = new JLabel("Drinks");
	private JLabel adultTickets2 = new JLabel("Adult Tickets");
	private JLabel childTickets2 = new JLabel("Child Tickets");
	private JLabel popcorn2 = new JLabel("Popcorn");
	private JLabel drinks2 = new JLabel("Drinks");
	private JLabel totalSales = new JLabel("Total Sales");
	private JLabel blank = new JLabel("");
	private JLabel blank2 = new JLabel("");

	//Text fields to get and display data
	private JTextField aQuantity = new JTextField(5);	//Quantity of adult tickets
	private JTextField aSales = new JTextField(5);		//Sales of adult tickets
	private JTextField cQuantity = new JTextField(5);	//Quantity of child tickets
	private JTextField cSales = new JTextField(5);		//Sales of child tickets
	private JTextField pQuantity = new JTextField(5);	//Quantity of popcorn
	private JTextField pSales = new JTextField(5);		//Sales of popcorn
	private JTextField dQuantity = new JTextField(5);	//Quantity of drinks
	private JTextField dSales = new JTextField(5);		//Sales of drinks
	private JTextField tSales = new JTextField(8);		//Total sales

	//Buttons to execute commands
	private JButton calculate = new JButton("Calculate Sales Total");	//Calculstes the total
	private JButton close = new JButton("Close");						//Exits the program

	//Formatting for dollar values
	private NumberFormat fmt = NumberFormat.getCurrencyInstance();


	/**
	 * Default constructor for the GUI
	 */
	public TheaterGUI()
	{
		//Create instance of TheaterSales class
		theaterSales = new TheaterSales();
		//Set the frame title
		setTitle("ACME Theater Sales Report");
		//Set the frame size
		setSize(400,300);
		//Prevent resizing of the frame
		setResizable(false);
		//Set the frame layout to BorderLayout
		setLayout(new BorderLayout());
		//Set default close operation to EXIT_ON_CLOSE
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Add elements to the top panel and add it to the frame
		buildTopPanel();
		//Add elements to the center panel and add it to the frame
		buildCenterPanel();
		//Add elements to the bottom panel and add it to the frame
		buildBottomPanel();

		//Display the frame
		setVisible(true);
	}

	/**
	 * Displays "Theater GUI"
	 * @return "Theater GUI"
	 */
	public String toString()
	{
		return "Theater GUI";
	}

	/**
	 * Adds elements to the top panel and adds the panel to the frame
	 */
	private void buildTopPanel()
	{
		//Create new instance of JPanel
		topPanel = new JPanel();
		//Add the titleLabel to the panel
		topPanel.add(titleLabel);
		//Add the panel to the NORTH section of the frame
		add(topPanel, BorderLayout.NORTH);
	}

	/**
	 * Adds elements to the center panel and adds the panel to the frame
	 */
	private void buildCenterPanel()
	{
		//Create new instance of JPanel
		centerPanel = new JPanel();
		//create a new 5x4 GridLayout
		GridLayout grid = new GridLayout(5,4);
		//Add vertical and horizontal gaps to the grid
		grid.setHgap(5);
		grid.setVgap(5);

		//Set the layout of the panel to the grid
		centerPanel.setLayout(grid);

		//Set alignment for the labels
		quantity.setHorizontalAlignment(SwingConstants.CENTER);
		sales.setHorizontalAlignment(SwingConstants.CENTER);
		adultTickets.setHorizontalAlignment(SwingConstants.RIGHT);
		adultTickets2.setHorizontalAlignment(SwingConstants.RIGHT);
		childTickets.setHorizontalAlignment(SwingConstants.RIGHT);
		childTickets2.setHorizontalAlignment(SwingConstants.RIGHT);
		popcorn.setHorizontalAlignment(SwingConstants.RIGHT);
		popcorn2.setHorizontalAlignment(SwingConstants.RIGHT);
		drinks.setHorizontalAlignment(SwingConstants.RIGHT);
		drinks2.setHorizontalAlignment(SwingConstants.RIGHT);

		//Make the sales text fields non-editable and non-focusable
		aSales.setEditable(false);
		aSales.setFocusable(false);
		cSales.setEditable(false);
		cSales.setFocusable(false);
		pSales.setEditable(false);
		pSales.setFocusable(false);
		dSales.setEditable(false);
		pSales.setFocusable(false);

		//Add a FocusListener to the quantity text fields
		aQuantity.addFocusListener(new FieldListener());
		cQuantity.addFocusListener(new FieldListener());
		pQuantity.addFocusListener(new FieldListener());
		dQuantity.addFocusListener(new FieldListener());

		//Add the elements to the panel
		centerPanel.add(blank);
		centerPanel.add(quantity);
		centerPanel.add(blank2);
		centerPanel.add(sales);
		centerPanel.add(adultTickets);
		centerPanel.add(aQuantity);
		centerPanel.add(adultTickets2);
		centerPanel.add(aSales);
		centerPanel.add(childTickets);
		centerPanel.add(cQuantity);
		centerPanel.add(childTickets2);
		centerPanel.add(cSales);
		centerPanel.add(popcorn);
		centerPanel.add(pQuantity);
		centerPanel.add(popcorn2);
		centerPanel.add(pSales);
		centerPanel.add(drinks);
		centerPanel.add(dQuantity);
		centerPanel.add(drinks2);
		centerPanel.add(dSales);

		//Add the panel to the CENTER section of the frame
		add(centerPanel, BorderLayout.CENTER);

		//Set the focus to the aSales text field
		aSales.requestFocus();
	}

	/**
	 * Adds elements to the bottom panel and adds the panel to the frame
	 */
	private void buildBottomPanel()
	{
		//Create new instance of JPanel
		bottomPanel = new JPanel();

		//Create sub panels to be added to bottomPanel
		JPanel top = new JPanel();
		JPanel bottom = new JPanel();

		//Make the total sales text field non-editable and non-focusable
		tSales.setEditable(false);
		tSales.setFocusable(false);
		
		//Set the action commands for the buttons
		calculate.setActionCommand("calc");
		close.setActionCommand("close");

		//Add and ActionListener to the buttons
		calculate.addActionListener(new ButtonListener());
		close.addActionListener(new ButtonListener());

		//Add the total sales label and text field to the top sub panel
		top.add(totalSales);
		top.add(tSales);

		//Add the buttons to the bottom sub panel
		bottom.add(calculate);
		bottom.add(close);

		//Set a 2x1 GriLayout for the main panel
		bottomPanel.setLayout(new GridLayout(2,1));

		//Add the sub panels to the main panel
		bottomPanel.add(top);
		bottomPanel.add(bottom);

		//Add the main panel to the SOUTH section of the frame
		add(bottomPanel, BorderLayout.SOUTH);
	}

	/**
	 * Set the sales field for adult tickets
	 */
	private void setAdultSales()
	{
		//If the quantity field is empty, set it to 0
		if(aQuantity.getText().equals(""))
			aQuantity.setText("0");

		//Parse the integer value from the quantity field
		int aInput = Integer.parseInt(aQuantity.getText());

		//If the value in the field is negative display a message box, clear the field and exit the method
		if(aInput<0)
		{
			aQuantity.setText("");
			JOptionPane.showMessageDialog(null, "All quantities must be positive.\nPlease enter a valid quantity");
			aQuantity.requestFocus();
			return;
		}

		//Use the integer value of the field to set the quantity member value for theaterSales
		theaterSales.setAdultTickets(aInput);

		//If the quantity is 0 set the quantity and sales fields to empty
		if(aInput == 0)
		{
			aQuantity.setText("");
			aSales.setText("");
		}

		//Otherwise call the theaterSales method and set the sales field to the result
		//Formatted as currency
		else
			aSales.setText(fmt.format(theaterSales.adultTicketSales()));

		//Reset the total sales field
		tSales.setText("");
	}

	/**
	 *  Set the sales field for child tickets
	 */
	private void setChildSales()
	{
		//If the quantity field is empty, set it to 0
		if(cQuantity.getText().equals(""))
			cQuantity.setText("0");

		//Parse the integer value from the quantity field
		int cInput = Integer.parseInt(cQuantity.getText());

		//If the value in the field is negative display a message box, clear the field and exit the method
		if(cInput<0)
		{
			cQuantity.setText("");
			JOptionPane.showMessageDialog(null, "All quantities must be positive.\nPlease enter a valid quantity");
			cQuantity.requestFocus();
			return;
		}

		//Use the integer value of the field to set the quantity member value for theaterSales
		theaterSales.setChildTickets(cInput);

		//If the quantity is 0 set the quantity and sales fields to empty
		if(cInput == 0)
		{
			cQuantity.setText("");
			cSales.setText("");
		}

		//Otherwise call the theaterSales method and set the sales field to the result
		//Formatted as currency
		else
			cSales.setText(fmt.format(theaterSales.childTicketSales()));

		//Reset the total sales field
		tSales.setText("");
	}

	/**
	 *  Set the sales field for popcorn
	 */
	private void setPopcornSales()
	{
		//If the quantity field is empty, set it to 0
		if(pQuantity.getText().equals(""))
			pQuantity.setText("0");

		//Parse the integer value from the quantity field
		int pInput = Integer.parseInt(pQuantity.getText());

		//If the value in the field is negative display a message box, clear the field and exit the method
		if(pInput<0)
		{
			pQuantity.setText("");
			JOptionPane.showMessageDialog(null, "All quantities must be positive.\nPlease enter a valid quantity");
			pQuantity.requestFocus();
			return;
		}

		//Use the integer value of the field to set the quantity member value for theaterSales
		theaterSales.setPopcorn(pInput);

		//If the quantity is 0 set the quantity and sales fields to empty
		if(pInput == 0)
		{
			pQuantity.setText("");
			pSales.setText("");
		}

		//Otherwise call the theaterSales method and set the sales field to the result
		//Formatted as currency
		else
			pSales.setText(fmt.format(theaterSales.popcornSales()));

		//Reset the total sales field
		tSales.setText("");
	}

	/**
	 *  Set the sales field for drinks
	 */
	private void setDrinkSales()
	{
		//If the quantity field is empty, set it to 0
		if(dQuantity.getText().equals(""))
			dQuantity.setText("0");

		//Parse the integer value from the quantity field
		int dInput = Integer.parseInt(dQuantity.getText());

		//If the value in the field is negative display a message box, clear the field and exit the method
		if(dInput<0)
		{
			dQuantity.setText("");
			JOptionPane.showMessageDialog(null, "All quantities must be positive.\nPlease enter a valid quantity");
			dQuantity.requestFocus();
			return;
		}

		//Use the integer value of the field to set the quantity member value for theaterSales
		theaterSales.setDrinks(dInput);

		//If the quantity is 0 set the quantity and sales fields to empty
		if(dInput == 0)
		{
			dQuantity.setText("");
			dSales.setText("");
		}

		//Otherwise call the theaterSales method and set the sales field to the result
		//Formatted as currency
		else
			dSales.setText(fmt.format(theaterSales.drinkSales()));

		//Reset the total sales field
		tSales.setText("");
	}

	/**
	 * Set the sales text fields for each item and the total sales text field
	 */
	private void setSales()
	{
		//Call method to set sales fields for each item
		setAdultSales();
		setChildSales();
		setPopcornSales();
		setDrinkSales();

		//Call the theaterSales method to calculate total sales, set the field to the value returned
		//Formatted as currency
		tSales.setText(fmt.format(theaterSales.totalSales()));
	}

	/**
	 * ActionListener to get events from the buttons
	 */
	private class ButtonListener implements ActionListener
	{
		/**
		 * Method called when event occurs
		 */
		public void actionPerformed(ActionEvent e)
		{
			//If the "Calculate Sales Total" button is clicked call the setSales method
			if(e.getActionCommand().equals("calc"))
			{
				setSales();
			}

			//If the "Close" button is clicked hide the frame and end execution
			else if(e.getActionCommand().equals("close"))
			{
				setVisible(false);
				dispose();
				System.exit(0);
			}
		}
	}

	/**
	 * FocusListener to get events from the text fields
	 */
	private class FieldListener implements FocusListener
	{
		/**
		 * Method called when focusLost event occurs
		 */
		public void focusLost(FocusEvent e)
		{
			//Call the method associated with setting sales for the correct item
			if(e.getSource() == aQuantity)
				setAdultSales();
			if(e.getSource() == cQuantity)
				setChildSales();
			if(e.getSource() == pQuantity)
				setPopcornSales();
			if(e.getSource() == dQuantity)
				setDrinkSales();
		}

		/**
		 * Method called when focusGained event occurs
		 */
		public void focusGained(FocusEvent e)
		{
			//Select the contents of a field when it gains focus
			if(e.getSource() == aQuantity)
				aQuantity.selectAll();
			if(e.getSource() == cQuantity)
				cQuantity.selectAll();
			if(e.getSource() == pQuantity)
				pQuantity.selectAll();
			if(e.getSource() == dQuantity)
				dQuantity.selectAll();
		}
	}
}