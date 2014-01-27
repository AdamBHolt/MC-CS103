import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * This class provides the GUI interface to add orders and customers for Kitty's Kitchen
 * @author Adam Holt
 * @date 12/24/13
 */
public class KitchenPanel extends JPanel
{
    //Default serial ID
    private static final long serialVersionUID = 1L;
    //Components to be added to the GUI
    private JRadioButton newCust, existingCust;
    private ButtonGroup group;
    private JButton addLookup, submit, clear, print, exit;
    private JTextField cNumber1, fName, lName, address, cNumber2, items, subtotal;
    private JTextArea receipt;
    private JPanel[] fields;
    //Instance of the DataManager class to manage orders and custoemrs
    private DataManager manager;

    /**
     * Default constructor
     */
    public KitchenPanel()
    {
	manager = new DataManager();
	//Set the layout
	setLayout(new BorderLayout());
	//Build and add the sub panels
	addTopPanel();
	addCenterPanel();
	addBottomPanel();
    }

    /**
     * Build and add the top sub panel
     */
    private void addTopPanel()
    {
	//Components to be displayed on the top sub panel
	JPanel topPanel = new JPanel();
	JPanel optionPanel = new JPanel();
	JPanel detailPanel = new JPanel();
	JPanel fieldPanel = new JPanel();
	fields = new JPanel[8];
	newCust = new JRadioButton("New Customer");
	existingCust = new JRadioButton("Existing Customer");
	group = new ButtonGroup();
	addLookup = new JButton("Add Customer");
	cNumber1 = new JTextField(18);
	fName = new JTextField(18);
	lName = new JTextField(18);
	address = new JTextField(18);

	//Set the customer number field to read-only
	cNumber1.setEditable(false);

	//Add borders to the sub panels
	optionPanel.setBorder(BorderFactory.createTitledBorder("Customer Options"));
	detailPanel.setBorder(BorderFactory.createTitledBorder("Customer Details"));

	//Add the radio buttons to the ButtonGroup
	group.add(newCust);
	group.add(existingCust);
	newCust.setFocusable(false);
	existingCust.setFocusable(false);

	//Set the radio button action commands
	newCust.setActionCommand("n");
	existingCust.setActionCommand("e");

	//Add RadioListeners to the radio buttons
	newCust.addActionListener(new RadioListener());
	existingCust.addActionListener(new RadioListener());

	//Add the components to the option sub panel
	optionPanel.add(newCust);
	optionPanel.add(existingCust);

	//Set the option panel size
	optionPanel.setPreferredSize(new Dimension(200,125));

	//Set the new customer radio button to selected when the program loads
	newCust.setSelected(true);

	//Set a grid layout into the field panel
	fieldPanel.setLayout(new GridLayout(4,2));

	//Instantiate each panel in the fields array
	for(int i=0; i<8; i++)
	    fields[i] = new JPanel();

	//Add a component to each panel in the array
	fields[0].add(new JLabel("Customer Number"));
	fields[1].add(cNumber1);
	fields[2].add(new JLabel("First Name"));
	fields[3].add(fName);
	fields[4].add(new JLabel("Last Name"));
	fields[5].add(lName);
	fields[6].add(new JLabel("Address, City, ST, Zip"));
	fields[7].add(address);

	//Add each panel to the grid panel
	for(JPanel panel : fields)
	    fieldPanel.add(panel);

	cNumber1.setFocusable(false);

	//Add FieldListeners to the fields
	fName.addFocusListener(new FieldListener());
	lName.addFocusListener(new FieldListener());
	address.addFocusListener(new FieldListener());

	//Set the initial characteristics of the add/lookup button
	addLookup.setActionCommand("a");
	addLookup.addActionListener(new ButtonListener());
	addLookup.setMnemonic(KeyEvent.VK_A);
	addLookup.setToolTipText("Add a new customer");
	addLookup.setFocusable(false);

	//Set the size of the detail panel and add the components to it
	detailPanel.setPreferredSize(new Dimension(450,180));
	detailPanel.add(fieldPanel);
	detailPanel.add(addLookup);

	//Add the sub panels to the panel
	topPanel.add(optionPanel);
	topPanel.add(detailPanel);
	//Add the panel to the main panel
	add(topPanel, BorderLayout.NORTH);
    }

    /**
     * Build and add the center sub panel
     */
    private void addCenterPanel()
    {
	//Components to be displayed on the top sub panel
	JPanel centerPanel = new JPanel();
	JPanel detailPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel[] fields = new JPanel[6];
	cNumber2 = new JTextField(20);
	items = new JTextField(20);
	subtotal = new JTextField(20);
	submit = new JButton("Submit Order");
	clear = new JButton("Clear");
	print = new JButton("Print Order to File");
	exit = new JButton("Exit");

	//Instantiate each panel in the fields array

	for(int i=0; i<6; i++)
	    fields[i] = new JPanel();

	//Add a component to each panel in the array
	fields[0].add(new JLabel("Customer Number"));
	fields[1].add(cNumber2);
	fields[2].add(new JLabel("Number of Items"));
	fields[3].add(items);
	fields[4].add(new JLabel("Subtotal"));
	fields[5].add(subtotal);

	//Set the layout and border for the detail panel
	detailPanel.setBorder(BorderFactory.createTitledBorder("Order Details"));
	detailPanel.setLayout(new GridLayout(3,2));

	//Add each panel to the grid panel
	for(JPanel panel : fields)
	    detailPanel.add(panel);

	//Add FieldListeners to the fields
	cNumber2.addFocusListener(new FieldListener());
	items.addFocusListener(new FieldListener());
	subtotal.addFocusListener(new FieldListener());

	submit.setFocusable(false);
	clear.setFocusable(false);
	print.setFocusable(false);
	exit.setFocusable(false);

	//Set the action commands for the buttons
	submit.setActionCommand("s");
	clear.setActionCommand("c");
	print.setActionCommand("p");
	exit.setActionCommand("e");

	//Add a ButtonListener to each button
	submit.addActionListener(new ButtonListener());
	clear.addActionListener(new ButtonListener());
	print.addActionListener(new ButtonListener());
	exit.addActionListener(new ButtonListener());

	//Set mnemonics for the buttons
	submit.setMnemonic(KeyEvent.VK_S);
	clear.setMnemonic(KeyEvent.VK_C);
	print.setMnemonic(KeyEvent.VK_P);
	exit.setMnemonic(KeyEvent.VK_E);

	//Set tool tips for the buttons
	submit.setToolTipText("Submit the current order");
	clear.setToolTipText("Clear all fields");
	print.setToolTipText("Print all orders to a file");
	exit.setToolTipText("Exit the program");

	//Add each button to the button panel
	buttonPanel.add(submit);
	buttonPanel.add(clear);
	buttonPanel.add(print);
	buttonPanel.add(exit);

	//Add the sub panels to the panel
	centerPanel.add(detailPanel);
	centerPanel.add(buttonPanel);
	//Add the panel to the main panel
	add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * Build and add the bottom sub panel
     */
    private void addBottomPanel()
    {
	//Components to be displayed on the top sub panel
	JPanel bottomPanel = new JPanel();
	JPanel innerPanel = new JPanel();
	receipt = new JTextArea(8,50);
	receipt.setEditable(false);
	receipt.setFocusable(false);

	//Set the size of the panel
	bottomPanel.setPreferredSize(new Dimension(500, 200));

	//Set the border for the inner panel
	innerPanel.setBorder(BorderFactory.createTitledBorder("Receipt"));
	//Add the text area to the inner panel
	innerPanel.add(receipt);

	//Add the inner panel to the panel
	bottomPanel.add(innerPanel);
	//Add the panel to the main panel
	add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Clear all text fields and reset the radio buttons
     */
    private void clearAll()
    {
	newCust.doClick();
	cNumber1.setText("");
	fName.setText("");
	lName.setText("");
	address.setText("");
	cNumber2.setText("");
	items.setText("");
	subtotal.setText("");
	receipt.setText("");
	fName.requestFocus();
    }

    /**
     * Add a customer to the DataManager
     */
    private void addCustomer()
    {
	//If any of the customer text fields are empty end the method
	if(!fName.getText().equals("") && !lName.getText().equals("") && !address.getText().equals(""))
	{
	    //If the attempt to add the customer fails, the customer already exists
	    //The customer is not added and the user is notified
	    if(manager.addCustomer(fName.getText(), lName.getText(), address.getText(), 0) == -1)
		JOptionPane.showMessageDialog(null, "Customer Already Exists\nCustomer number added to order");
	    //Set both customer number text fields to the customer number
	    cNumber1.setText(String.valueOf(manager.getCustomerNumber(fName.getText(), lName.getText())));
	    cNumber2.setText(String.valueOf(manager.getCustomerNumber(fName.getText(), lName.getText())));
	    items.requestFocus();
	}
    }

    /**
     * Look up an existing customer based on name
     */
    private void lookupCustomer()
    {
	//If any of the customer text fields are empty end the method
	if(!fName.getText().equals("") && !lName.getText().equals(""))
	    //If the customer is not found the user is notified
	    if(manager.getCustomerNumber(fName.getText(), lName.getText()) == -1)
		JOptionPane.showMessageDialog(null, "Customer not found");
	//If the customer is found set both customer number text fields to the customer number
	    else
	    {
		cNumber1.setText(String.valueOf(manager.getCustomerNumber(fName.getText(), lName.getText())));
		cNumber2.setText(String.valueOf(manager.getCustomerNumber(fName.getText(), lName.getText())));
		items.requestFocus();
	    }
    }

    /**
     * Submit a new order to be created
     */
    private void submitOrder()
    {
	//If any of the order text fields are empty end the method
	if(!cNumber2.getText().equals("") && !items.getText().equals("") && !subtotal.getText().equals(""))
	    //If the customer exists, add the order and reset the GUI
	    if(manager.getCustomer(Integer.parseInt(cNumber2.getText()))!=null)
	    {
		manager.addOrder(Integer.parseInt(cNumber2.getText()), Double.parseDouble(subtotal.getText()));
		clearAll();
		receipt.setText(manager.getDetailsOfLastOrder());
	    }
	//If the customer is not found notify the user
	    else
		JOptionPane.showMessageDialog(null, "Customer not found");

    }

    /**
     * Prints all orders to a file
     * @throws FileNotFoundException
     */
    private void printOrders() throws FileNotFoundException
    {
	//File chooser to save the file
	JFileChooser chooser = new JFileChooser();
	//PrintWriter to write to the file
	PrintWriter outFile = null;

	//If the "save" option is chosen in the FileChooser
	if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
	{
	    //Write to the name of the file entered by the user
	    outFile = new PrintWriter(new File(chooser.getSelectedFile().toString()));
	    //Write the String representation of the DataManager to the file
	    outFile.println(manager);
	    //Close the file
	    outFile.close();
	}
    }

    /**
     * ActionListener for the buttons
     */
    private class ButtonListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e)
	{
	    //Switch based on the action command of the button pressed
	    switch(e.getActionCommand().charAt(0))
	    {
		case 'a': //Add Customer
		    addCustomer();
		    break;
		case 'l': //Look up Customer
		    lookupCustomer();
		    break;
		case 's': //Submit Order
		    submitOrder();
		    break;
		case 'c': //Clear
		    clearAll();
		    break;
		case 'p': //Print to File
		    try {printOrders();}
		    catch (FileNotFoundException e1){}
		    break;
		case 'e': //Exit
		    System.exit(0);
		default:
	    }
	}
    }

    /**
     * ActionListener for the radio buttons
     */
    private class RadioListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e)
	{
	    //Switch based on the action command of the radio button pressed
	    switch(e.getActionCommand().charAt(0))
	    {
		case 'n': //New Customer
		    //If new customer is selected show all fields and set the
		    //Parameters of the add/lookup button
		    addLookup.setActionCommand("a");
		    addLookup.setText("Add Customer");
		    addLookup.setMnemonic(KeyEvent.VK_A);
		    addLookup.setToolTipText("Add a new customer");
		    fields[6].setVisible(true);
		    fields[7].setVisible(true);
		    break;
		case 'e': //Existing Customer
		    //If new customer is selected hide unused fields and set the
		    //Parameters of the add/lookup button
		    addLookup.setActionCommand("l");
		    addLookup.setText("Look up Customer");
		    addLookup.setMnemonic(KeyEvent.VK_L);
		    addLookup.setToolTipText("Look up and existing customer");
		    fields[6].setVisible(false);
		    fields[7].setVisible(false);
		    break;
		default:
	    }
	}
    }

    private class FieldListener implements FocusListener
    {
	public void focusGained(FocusEvent e)
	{
	    //Select the contents of a field when it gains focus
	    if(e.getSource() == fName)
		fName.selectAll();
	    if(e.getSource() == lName)
		lName.selectAll();
	    if(e.getSource() == address)
		address.selectAll();
	    if(e.getSource() == cNumber2)
		cNumber2.selectAll();
	    if(e.getSource() == items)
		items.selectAll();
	    if(e.getSource() == subtotal)
		subtotal.selectAll();
	}

	public void focusLost(FocusEvent e){}
    }
}