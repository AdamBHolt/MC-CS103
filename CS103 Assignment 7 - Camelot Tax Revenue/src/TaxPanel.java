import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/**
 * This class provides a graphic interface to add Buildings, calculate taxes on them,
 * And to view reports of the tax information
 * @author Adam Holt
 * @date 11/20/2013
 */
public class TaxPanel extends JPanel
{
	//Default serial ID
	private static final long serialVersionUID = 1L;
	//Data structure manager
	private BuildingManager manager;
	//Building type code
	private int code;
	//Components to be accessed by methods of this class
	private JRadioButton house, store, community, other;
	private JButton add, write, display, read, exit;
	private JTextField building, street, assessment, sales;
	private ButtonGroup group;
	private JPanel salesPanel;

	/**
	 * Default constructor
	 */
	public TaxPanel()
	{
		//Create a new BuildingManager
		manager = new BuildingManager();
		//Create and add the panels
		addTopPanel();
		addCenterPanel();
		addBottomPanel();
	}

	/**
	 * Create and add the top panel
	 */
	private void addTopPanel()
	{
		//Components for this panel
		JPanel topPanel = new JPanel();
		JPanel radioPanel = new JPanel();
		house = new JRadioButton("House");
		store = new JRadioButton("Store");
		community = new JRadioButton("Community");
		other = new JRadioButton("Other Building");

		//Add the radio buttons to a ButtonGroup
		group = new ButtonGroup();
		group.add(house);
		group.add(store);
		group.add(community);
		group.add(other);

		//Set the action commands for the radio buttons
		house.setActionCommand("h");
		store.setActionCommand("s");
		community.setActionCommand("c");
		other.setActionCommand("o");

		//Add action listeners to the radio buttons
		house.addActionListener(new RadioButtonListener());
		store.addActionListener(new RadioButtonListener());
		community.addActionListener(new RadioButtonListener());
		other.addActionListener(new RadioButtonListener());

		//Set the border and size for the radio button sub panel
		radioPanel.setBorder(BorderFactory.createTitledBorder("Type of Building"));
		radioPanel.setPreferredSize(new Dimension(350,125));

		//Add the radio buttons to the sub panel
		radioPanel.add(house);
		radioPanel.add(store);
		radioPanel.add(community);
		radioPanel.add(other);

		//Add the sub panel to the panel
		topPanel.add(radioPanel);
		//Add the panel to the main panel
		add(topPanel, BorderLayout.CENTER);
	}

	/**
	 * Create and add the center panel
	 */
	private void addCenterPanel()
	{
		//Components for this panel
		JPanel centerPanel = new JPanel();
		JPanel buildingPanel = new JPanel();
		JPanel streetPanel = new JPanel();
		JPanel assessmentPanel = new JPanel();
		salesPanel = new JPanel();
		building = new JTextField(10);
		street = new JTextField(15);
		assessment = new JTextField(15);
		sales = new JTextField(15);

		//set a grid layout and panel size
		centerPanel.setLayout(new GridLayout(6,1));
		centerPanel.setPreferredSize(new Dimension(350,175));

		building.addFocusListener(new FieldListener());
		street.addFocusListener(new FieldListener());
		assessment.addFocusListener(new FieldListener());
		sales.addFocusListener(new FieldListener());
		
		//Add the text fields and labels
		buildingPanel.add(new JLabel("Building Number"));
		buildingPanel.add(building);
		streetPanel.add(new JLabel("Street Name"));
		streetPanel.add(street);
		assessmentPanel.add(new JLabel("Assessment (1000's)"));
		assessmentPanel.add(assessment);
		salesPanel.add(new JLabel("Gross Sales (1000's)"));
		salesPanel.add(sales);	

		//Set the sales panel to hidden
		salesPanel.setVisible(false);

		//Add the sub panels
		centerPanel.add(buildingPanel);
		centerPanel.add(streetPanel);
		centerPanel.add(assessmentPanel);
		centerPanel.add(salesPanel);
		//Add the panel to the main panel
		add(centerPanel, BorderLayout.NORTH);
	}

	/**
	 * Create and add the bottom panel
	 */
	private void addBottomPanel()
	{
		//Components for this panel
		JPanel bottomPanel = new JPanel();
		add = new JButton("Add Building");
		write = new JButton("Write Report to File");
		display = new JButton("Display Summary Tax Report");
		read = new JButton("Read from File");
		exit = new JButton("Exit");

		//Set the panel size
		bottomPanel.setPreferredSize(new Dimension(350,200));

		//Set the button action commands
		add.setActionCommand("a");
		write.setActionCommand("w");
		display.setActionCommand("d");
		read.setActionCommand("r");
		exit.setActionCommand("e");

		//Set the button mnemonics and tool tips
		add.setMnemonic(KeyEvent.VK_A);
		write.setMnemonic(KeyEvent.VK_W);
		display.setMnemonic(KeyEvent.VK_D);
		read.setMnemonic(KeyEvent.VK_R);
		exit.setMnemonic(KeyEvent.VK_E);
		add.setToolTipText("Add a new building");
		write.setToolTipText("Write the report to a file");
		display.setToolTipText("Display a summary report");
		read.setToolTipText("Read from a new file");
		exit.setToolTipText("Exit the program");

		//Add action listeners to the buttons
		add.addActionListener(new ButtonListener());
		write.addActionListener(new ButtonListener());
		display.addActionListener(new ButtonListener());
		read.addActionListener(new ButtonListener());
		exit.addActionListener(new ButtonListener());

		//Add the buttons to the panel
		bottomPanel.add(add);
		bottomPanel.add(write);
		bottomPanel.add(display);
		bottomPanel.add(read);
		bottomPanel.add(exit);

		//Add the panel to the main panel
		add(bottomPanel, BorderLayout.SOUTH);
	}

	/**
	 * Clear the fields in the GUI and reset the radio buttons
	 */
	private void clearFields()
	{
		building.setText("");
		street.setText("");
		assessment.setText("");
		sales.setText("");
		group.clearSelection();
		//Hide the sales panel if it is visible
		salesPanel.setVisible(false);
	}

	/**
	 * Display a report of the Buildings in the data manger on the screen
	 */
	private void displayReport()
	{
		//Display the data manger in a JOptionPane
		JOptionPane.showMessageDialog(null, manager);
	}

	/**
	 * Add a new building to the data manager
	 */
	private void addBuilding()
	{
		//Only proceed if the text fields are not empty
		if(!building.getText().equals("") && !street.getText().equals("") && !assessment.getText().equals(""))
		{
			//If the store radio button is selected
			if(code==2)
			{
				//Only proceed if the sales field is not empty
				if(!sales.getText().equals(""))
				{
					//Add a building to the data manger passing the sales field contents as a parameter
					manager.addBuilding(code, street.getText(), Double.parseDouble(assessment.getText()), Integer.parseInt(building.getText()), Double.parseDouble(sales.getText()));
					//Reset the GUI
					clearFields();
				}
			}
			//For all other buildings
			else
			{
				//Add a building to the data manger passing 0 as the sales
				manager.addBuilding(code, street.getText(), Double.parseDouble(assessment.getText()), Integer.parseInt(building.getText()), 0);
				//Reset the GUI
				clearFields();
			}
		}
	}

	/**
	 * Write a report of the Buildings in the data manager to a file
	 * @throws IOException
	 */
	private void writeFile() throws IOException
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
			//Write the String representation of the data manager to the file
			outFile.println(manager);
			//Close the file
			outFile.close();
		}
	}

	/**
	 * Read a file to add Buildings to the data manager
	 * @throws IOException
	 */
	private void readFile() throws IOException
	{
		//File chooser to select the file
		JFileChooser chooser = new JFileChooser();

		//If the "open" option is chosen in the FileChooser
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			//File object with the selected file
			File selectedFile = chooser.getSelectedFile();

			//Scanner to read from the selected file
			Scanner inputFile = new Scanner(selectedFile);

			//Read each line in the text file
			while(inputFile.hasNext())
			{
				//Read each token from the file and store it to the correct variable
				int co = Integer.parseInt(inputFile.next());
				int no = Integer.parseInt(inputFile.next());
				String st = inputFile.next();
				double as = Double.parseDouble(inputFile.next());
				double sa = 0;

				//If the code is 2 read the extra sales token
				if(co == 2)
					sa = Double.parseDouble(inputFile.next());
				//Add a new building to the data manager using the tokens from the file
				manager.addBuilding(co, st, as, no, sa);
			}

			//Close the file
			inputFile.close();
		}
	}

	/**
	 * Action listener for the radio buttons
	 */
	private class RadioButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Switch based on the action command of the radio button clicked
			//Set the code to the type of building
			//If store is selected show the store panel, otherwise hide the store panel
			switch(e.getActionCommand().charAt(0))
			{
			case 'h':
				salesPanel.setVisible(false);
				code = 1;
				break;
			case 's':
				salesPanel.setVisible(true);
				code = 2;
				break;
			case 'c':
				salesPanel.setVisible(false);
				code = 3;
				break;
			case 'o':
				salesPanel.setVisible(false);
				code = 4;
				break;
			default:
			}
		}
	}

	/**
	 * Action listener for the action buttons
	 */
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Switch based on the action command of the button clicked
			//Call the appropriate method
			switch(e.getActionCommand().charAt(0))
			{
			case 'a':
				addBuilding();
				break;
			case 'w':
				try {writeFile();}
				catch (IOException e2) {e2.printStackTrace();}
				break;
			case 'd':
				displayReport();
				break;
			case 'r':
				try {readFile();}
				catch (IOException e1) {e1.printStackTrace();}
				break;
			case 'e':
				//Exit the program
				System.exit(0);
			default:
			}
		}
	}

	/**
	 * Focus listener for text fields
	 */
	private class FieldListener implements FocusListener
	{
		public void focusGained(FocusEvent e)
		{
			//Select the contents of a field when it gains focus
			if(e.getSource() == building)
				building.selectAll();
			if(e.getSource() == street)
				street.selectAll();
			if(e.getSource() == assessment)
				assessment.selectAll();
			if(e.getSource() == sales)
				sales.selectAll();
		}

		public void focusLost(FocusEvent e){}
	}
}