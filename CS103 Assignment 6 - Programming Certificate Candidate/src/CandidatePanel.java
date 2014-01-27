import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

/**
 * This class provides a GUI for accessing the CandidateManager data structure
 * It provides actions to read information from a file and to clear the fields
 * @date 11/6/13
 * @author Adam Holt
 */
public class CandidatePanel extends JPanel
{
	//Instance variable declarations

	//Default serial number
	private static final long serialVersionUID = 1L;
	//Text fields to display number and average GPA of all candidates
	private JTextField numCandidates, avgGPA;
	//Action buttons
	private JButton read, clear, exit;
	//Two dimensional array of text fields that will display the data
	private JTextField[][] entryFields;
	//Array of text fields that will display the graduation status of each candidate
	private JTextField[] statusFields;
	//Data manager for Candidate objects
	private CandidateManager manager;

	/**
	 * Default constructor
	 */
	public CandidatePanel()
	{
		//Set a BorderLayout
		setLayout(new BorderLayout());
		//Build the header panel
		buildTopPanel();
		//Build the text field panel
		buildCenterPanel();
		//build the button panel
		buildBottomPanel();
	}

	/**
	 * Builds and add the top, header panel to the main panel
	 */
	private void buildTopPanel()
	{
		//Main panel and sub panels
		JPanel topPanel = new JPanel();
		JPanel termPanel = new JPanel();
		JPanel fieldPanel = new JPanel();

		//Text fields to display overall candidate information
		numCandidates = new JTextField(5);
		avgGPA = new JTextField(5);

		//Ask the user to supply a term and year and set the label to the user's input
		JLabel term = new JLabel(JOptionPane.showInputDialog("Enter Semester and Year   Ex:Fall 2013"));
		//Font for the term panel
		term.setFont(new Font("Arial", Font.PLAIN, 16));

		//Prevent the text fields from being edited & set the appearance
		numCandidates.setEditable(false);
		numCandidates.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		numCandidates.setBackground(Color.WHITE);
		avgGPA.setEditable(false);
		avgGPA.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		avgGPA.setBackground(Color.WHITE);

		//Add the term label to the term sub panel
		termPanel.add(term);

		//Add the text fields and their labels to the field sub panel
		fieldPanel.add(new JLabel("Number of Candidates:"));
		fieldPanel.add(numCandidates);
		fieldPanel.add(new JLabel("Average GPA:"));
		fieldPanel.add(avgGPA);

		//Set the top panel to a GridLayout
		topPanel.setLayout(new GridLayout(2,1));

		//Add each sub panel to the top panel
		topPanel.add(termPanel);
		topPanel.add(fieldPanel);

		//Add the top panel to the main panel
		add(topPanel, BorderLayout.NORTH);
	}

	/**
	 * Build and add the center, text field panel
	 */
	private void buildCenterPanel()
	{
		//Main panel and sub panels
		JPanel centerPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel middlePanel = new JPanel();
		JPanel rightPanel = new JPanel();
		//Array of sub panels to hold the text fields
		JPanel[] entryPanels = new JPanel[10];

		//Instantiate the text field arrays
		entryFields = new JTextField[10][9];
		statusFields = new JTextField[10];

		//Set the layouts for the panel and sub panels
		centerPanel.setLayout(new BorderLayout());
		leftPanel.setLayout(new GridLayout(1,2));
		middlePanel.setLayout(new GridLayout(1,6));
		rightPanel.setLayout(new GridLayout(1,2));

		//Instantiate each panel in the array of sub panels
		for(int i=0; i<10; i++)
			entryPanels[i] = new JPanel();

		//Add a header label to each of the sub panels in the array
		entryPanels[0].add(new JLabel("First Name"));
		entryPanels[1].add(new JLabel("Last Name"));
		entryPanels[2].add(new JLabel("CS110"));
		entryPanels[3].add(new JLabel("CS140"));
		entryPanels[4].add(new JLabel("CS226")); 
		entryPanels[5].add(new JLabel("CS249"));
		entryPanels[6].add(new JLabel("CS213"));
		entryPanels[7].add(new JLabel("CS214"));
		entryPanels[8].add(new JLabel("GPA"));
		entryPanels[9].add(new JLabel("Status"));

		//Add each of the text fields in the two dimensional array to the correct sub panel
		for(int j=0; j<10; j++)
		{
			for(int i=0; i<9; i++)
			{
				//Default text field width
				int x=4;
				//Increase the width for the name text fields
				if(i==0 || i==1)
					x=10;
				//Increase the width for the GPA text field
				if(i==8)
					x=6;
				//Instantiate each text field with the appropriate size and add it to the corresponding sub panel
				entryFields[j][i] = new JTextField(x);
				entryPanels[i].add(entryFields[j][i]);
			}
			//Set the features of each status field and add them to the last sub panel
			statusFields[j] = new JTextField(6);
			statusFields[j].setBorder(BorderFactory.createEmptyBorder());
			statusFields[j].setFont(new Font("Arial", Font.BOLD, 12));
			statusFields[j].setPreferredSize(new Dimension(25,18));
			statusFields[j].setEditable(false);
			entryPanels[9].add(statusFields[j]);
		}

		//Add each of the sub panels to the correct panel
		for(int k=0; k<2; k++)
			leftPanel.add(entryPanels[k]);
		for(int k=2; k<8; k++)
			middlePanel.add(entryPanels[k]);
		for(int k=8; k<10; k++)
			rightPanel.add(entryPanels[k]);

		//Set each field to be non editable but to retain its original appearance
		for(JTextField[] fieldArray : entryFields)
			for(JTextField field : fieldArray)
			{
				field.setEditable(false);
				field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				field.setBackground(Color.WHITE);
			}
		for(JTextField field : statusFields)
		{
			field.setEditable(false);
		}

		//Set the size of each sub panel
		leftPanel.setPreferredSize(new Dimension(250,250));
		middlePanel.setPreferredSize(new Dimension(400,250));
		rightPanel.setPreferredSize(new Dimension(150,250));

		//Add each sub panel to the appropriate section of the center panel
		centerPanel.add(leftPanel, BorderLayout.WEST);
		centerPanel.add(middlePanel, BorderLayout.CENTER);
		centerPanel.add(rightPanel, BorderLayout.EAST);

		//Add the center panel to the main panel
		add(centerPanel, BorderLayout.CENTER);
	}

	/**
	 * Build and add the bottom, button panel to the main panel
	 */
	private void buildBottomPanel()
	{
		//The bottom panel
		JPanel bottomPanel = new JPanel();

		//Instantiate the action buttons
		read = new JButton("Read File");
		clear = new JButton("Clear Fields");
		exit = new JButton("Exit");

		//Set the action command for each button
		read.setActionCommand("r");
		clear.setActionCommand("c");
		exit.setActionCommand("e");

		//Add a ButtonListener to each button
		read.addActionListener(new ButtonListener());
		clear.addActionListener(new ButtonListener());
		exit.addActionListener(new ButtonListener());

		//Add the buttons to the bottom panel
		bottomPanel.add(read);
		bottomPanel.add(clear);
		bottomPanel.add(exit);

		//Add the bottom panel to the main panel
		add(bottomPanel, BorderLayout.SOUTH);
	}

	/**
	 * Prompts the user to choose a file to be read
	 * Reads the tokens from the text file to add Candidates to the CandidateManager
	 * @throws IOException
	 */
	private void readFile() throws IOException
	{
		//File chooser to select the file
		JFileChooser chooser = new JFileChooser();
		//Instantiate the CandidateManager
		manager = new CandidateManager();

		//Display the open file dialog box
		int status = chooser.showOpenDialog(null);

		//If the user clicks the "open" button
		if(status == JFileChooser.APPROVE_OPTION)
		{
			//Clear all the fields
			clearFields();
			
			//File object with the selected file
			File selectedFile = chooser.getSelectedFile();

			//Scanner to read from the selected file
			Scanner inputFile = new Scanner(selectedFile);

			//Read each line in the text file
			while(inputFile.hasNext())
			{
				//Divide each line into tokens based on a "," delimiter
				StringTokenizer tokenizer = new StringTokenizer(inputFile.next(), ",");
				while(tokenizer.hasMoreTokens())
				{
					//Create a new Candidate object based on the tokens and add the Candidate to the data manager
					manager.addCandidate(tokenizer.nextToken(),tokenizer.nextToken(),tokenizer.nextToken(),tokenizer.nextToken(),tokenizer.nextToken(),tokenizer.nextToken(),tokenizer.nextToken(),tokenizer.nextToken());
				}
			}
			//Call the method to populate the text fields in the GUI
			fillFields();
			//Close the file
			inputFile.close();
		}
	}

	/**
	 * Populates the GUI text fields based on the Candidates stored in the CandidateManager
	 */
	private void fillFields()
	{
		//Text format for the GPAs
		DecimalFormat frmt = new DecimalFormat("#.000");
		//Two dimensional array containing the Candidate information
		String[][] candidates = manager.getcandidates();

		//Repeat based on the number of candidates in the CandidateManager
		for(int j=0;j<manager.getNumCandidates();j++)
		{
			//Repeat for the number of columns in the GUI - excluding the "Status" column
			for(int i=0;i<9;i++)
			{
				//Populate the text fields with the corresponding candidate information
				entryFields[j][i].setText(candidates[j][i]);
			}
			//Populate the status column for the current candidate
			statusFields[j].setText(candidates[j][9]);
		}
		//Set the number of candidates field to the total elements in the CandidateManager
		numCandidates.setText(String.valueOf(manager.getNumCandidates()));
		//GEt the average GPA of all of the Candidates and set the text field
		avgGPA.setText(frmt.format(manager.getAvgGPA()));
	}

	/**
	 * Clear all of the fields in the GUI
	 */
	private void clearFields()
	{
		//Set each text field to ""
		for(JTextField[] fieldArray : entryFields)
			for(JTextField field : fieldArray)
				field.setText("");

		for(JTextField field : statusFields)
			field.setText("");

		numCandidates.setText("");
		avgGPA.setText("");
	}

	/**
	 * This inner class listens for the action buttons and executes the correct method or action
	 */
	private class ButtonListener implements ActionListener
	{
		/**
		 * Method to be performed on button click
		 * @param e ActionEvent
		 */
		public void actionPerformed(ActionEvent e)
		{
			//Switch based on the char representation of the button's action command
			switch(e.getActionCommand().charAt(0))
			{
			//"Read File" button
			case 'r':
				try
				{
					readFile();
				} catch (IOException e1) {e1.printStackTrace();}
				break;
			//"Clear Fields" button
			case 'c':
				clearFields();
				break;
			//"Exit" button
			case 'e':
				System.exit(0);
			default:
			}
		}
	}
}