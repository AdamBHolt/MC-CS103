import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * This class creates a GUI and utilizes the methods of the CardValidator
 * class to receive credit card information, determine whether the card is valid
 * and print a report of all valid cards entered.
 * Date: 10/16/13
 * @author Adam Holt
 */
public class CreditCardDriver extends JFrame
{
	private static final long serialVersionUID = 1L;

	//Instance of CardValidator class
	private CardValidator validator;

	//Radio buttons to set the credit card type
	private JRadioButton amex, visa, mc, disc;

	//Fields to get the name and number of the credit card
	private JTextField name, number;

	//Label to display validity of the credit card
	private JLabel valid;

	//Buttons to execute the commands of the GUI
	private JButton validate, report, clear, exit;

	//Group for the radio buttons
	private ButtonGroup group;

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Create anonymous instance of the CreditCardDriver class
		new CreditCardDriver();
	}

	/**
	 * Default constructor
	 */
	public CreditCardDriver()
	{
		//New instance of CardValidator class
		validator = new CardValidator();
		//Build the frame and add the elements
		buildFrame();
		//Focus on name text field
		name.requestFocus();
	}

	/**
	 * Add the elements of the GUI to the frame and display the frame
	 */
	private void buildFrame()
	{
		//Set frame dimensions
		setSize(420,250);
		//Set frame title
		setTitle("Credit Card Validator");
		//Exit when the frame is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Add a BorderLayout
		setLayout(new BorderLayout());
		//Prevent the frame from being resized
		setResizable(false);

		//Call methods to build and add the panels to the frame
		buildTopPanel();
		buildCenterPanel();
		buildBottomPanel();

		//Display the frame
		setVisible(true);
	}

	/**
	 * Build the top panel and add it to the frame
	 */
	private void buildTopPanel()
	{
		//Create a new panel
		JPanel topPanel = new JPanel();

		//Set the background color to yellow
		topPanel.setBackground(Color.yellow);
		//Add the program title label to the panel
		topPanel.add(new JLabel("Credit Card Validator"));
		//Add the panel to the north section of the frame
		add(topPanel, BorderLayout.NORTH);
	}

	/**
	 * Build the center panel and add it to the frame
	 */
	private void buildCenterPanel()
	{
		//Main center panel
		JPanel centerPanel =  new JPanel();

		//Lower sub panel
		JPanel lowerPanel = new JPanel();

		//Panel for radio buttons
		JPanel radioPanel = new JPanel();

		//Individual panels that will be placed on lowerPanel
		JPanel namePanel = new JPanel();
		JPanel numberPanel = new JPanel();

		//Create radio buttons for selecting the card type
		amex = new JRadioButton("American Express");
		visa = new JRadioButton("Visa");
		disc = new JRadioButton("Discover");
		mc = new JRadioButton("MasterCard");
		amex.setFocusable(false);
		visa.setFocusable(false);
		disc.setFocusable(false);
		mc.setFocusable(false);

		//Create button group and add the radio buttons
		group = new ButtonGroup();
		group.add(amex);
		group.add(visa);
		group.add(disc);
		group.add(mc);

		//Set the border of radioPanel and add the radio buttons
		radioPanel.setBorder(BorderFactory.createTitledBorder("Select One"));
		radioPanel.setPreferredSize(new Dimension(410,55));
		radioPanel.add(amex);
		radioPanel.add(visa);
		radioPanel.add(disc);
		radioPanel.add(mc);

		//Create text fields
		name = new JTextField(15);
		number = new JTextField(15);

		//Add focus listener to the text fields
		name.addFocusListener(new FieldListener());
		number.addFocusListener(new FieldListener());

		//Create validity label
		valid = new JLabel("");

		//Add a label and the name text field to the panel
		namePanel.add(new JLabel("Name: "));
		namePanel.add(name);

		//Add a label and the number text field to the panel
		numberPanel.add(new JLabel("Number: "));
		numberPanel.add(number);

		//Set the layout of the lower panel and add the name and number panels
		lowerPanel.setLayout(new GridLayout(3,1));
		lowerPanel.add(namePanel);
		lowerPanel.add(numberPanel);

		//Center the validity panel and add it to the lower panel
		valid.setHorizontalAlignment(SwingConstants.CENTER);
		lowerPanel.add(valid);

		//Add the sub panels to the main panel
		centerPanel.add(radioPanel);
		centerPanel.add(lowerPanel);

		//Add the main panel to the center section of the frame
		add(centerPanel, BorderLayout.CENTER);
	}

	/**
	 * Build the bottom panel and add it to the frame
	 */
	private void buildBottomPanel()
	{
		//Create the bottom panel
		JPanel bottomPanel = new JPanel();

		//Create the action buttons
		validate = new JButton("Validate");
		report = new JButton("Report of Valid Cards");
		clear = new JButton("Clear Fields");
		exit = new JButton("Exit");

		//Set action commands for the action buttons
		validate.setActionCommand("v");
		report.setActionCommand("r");
		clear.setActionCommand("c");
		exit.setActionCommand("e");

		//Add ButtonListener to the action buttons
		validate.addActionListener(new ButtonListener());
		report.addActionListener(new ButtonListener());
		clear.addActionListener(new ButtonListener());
		exit.addActionListener(new ButtonListener());

		//Add the action buttons to the panel
		bottomPanel.add(validate);
		bottomPanel.add(report);
		bottomPanel.add(clear);
		bottomPanel.add(exit);

		//Add the panel to the south section of the frame
		add(bottomPanel, BorderLayout.SOUTH);
	}

	/**
	 *Action listener for the action buttons
	 */
	private class ButtonListener implements ActionListener
	{
		/**
		 * Method when a button is clicked
		 */
		public void actionPerformed(ActionEvent e)
		{
			//Based on the action command passed from the button
			//Call the appropriate method
			switch(e.getActionCommand().charAt(0))
			{
			case 'v':
				validateCard();
				break;
			case 'r':
				createReport();
				break;
			case 'c':
				clearFields();
				break;
			case 'e':
				//If the action command is 'e' close the frame and exit the program
				setVisible(false);
				dispose();
				System.exit(0);
			}
		}
	}

	/**
	 * Focus listener for the text fields
	 */
	private class FieldListener implements FocusListener
	{
		/**
		 * Method when focus is gained
		 */
		public void focusGained(FocusEvent e)
		{
			//Select any text in the field that has gained focus
			if(e.getSource()==name)
				name.selectAll();
			if(e.getSource()==number)
				number.selectAll();
		}

		/**
		 * Method when focus is lost
		 */
		public void focusLost(FocusEvent e)
		{}
	}

	/**
	 * Determines whether or not the credit card is valid based
	 */
	private void validateCard()
	{
		//If no credit card type is selected exit the method
		if((amex.isSelected()==false && visa.isSelected()==false &&
				disc.isSelected()==false && mc.isSelected()==false)
				|| name.getText().equals("") || number.getText().equals(""))
			return;

		//Set the card typed based on the selected radio button
		String type="";
		if(amex.isSelected())
			type = "AX";
		else if(visa.isSelected())
			type = "V";
		else if(disc.isSelected())
			type = "D";
		else if(mc.isSelected())
			type = "MC";

		//Call the CardValidator method to determine if the card is valid or not
		//Pass the name, type, and number
		//If the method returns true, set the validity label to "Valid" otherwise, set it to "Invalid"
		if(validator.validateCard(name.getText(), type , number.getText()))
			valid.setText("Valid");
		else
			valid.setText("Invalid");
	}

	/**
	 * Displays the valid credit cards that have been entered previously
	 */
	private void createReport()
	{
		//Call the CardValidator method that returns a String of all valid cards
		JOptionPane.showMessageDialog(null, validator.getValidCards());
	}

	/**
	 * Clear all fields in the GUI
	 */
	private void clearFields()
	{
		//Set the text fields and label to empty
		name.setText("");
		number.setText("");
		valid.setText("");

		//Clear the selection of the radio buttons
		group.clearSelection();

		//Set the focus to the name field
		name.requestFocus();
	}
}