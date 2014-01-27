//Import packages for GUI and event handling
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates a JPanel with input fields and controls
 * to track the players on basketball teams
 * Players can be added to a team and new teams can be created
 * A roster of the current team can be displayed
 * Date: 10/28/13
 * @author Adam Holt
 */
public class BasketballPanel extends JPanel
{
	//Instance variable declarations

	//Default version ID
	private static final long serialVersionUID = 1L;

	//Radio buttons to set the player position
	private JRadioButton guard, center, forward;

	//Buttons to perform actions
	private JButton addPlayer, printTeam, newTeam, exit;

	//Text fields to enter the player's information
	private JTextField teamName, firstName, lastName;

	//Group for the radio buttons
	private ButtonGroup group;

	//Object of the current team
	private Team theTeam;

	/**
	 * No arg constructor
	 */
	public BasketballPanel()
	{
		//Add components to the panel
		buildPanel(getTeamName());
		//Create the Team object
		theTeam = new Team(teamName.getText());
		//Clear the fields and radio buttons
		clearFields();
	}

	/**
	 * Adds the components to the panel
	 * @param t The name of the current team
	 */
	private void buildPanel(String t)
	{
		//Sub panels to be used on the main panel
		JPanel topPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel textPanel = new JPanel();
		JPanel teamPanel = new JPanel();
		JPanel fNamePanel = new JPanel();
		JPanel lNamePanel = new JPanel();
		JPanel radioPanel = new JPanel();
		JPanel bottomPanel = new JPanel();

		//TExt fields to enter and display information
		teamName = new JTextField(15);
		firstName = new JTextField(10);
		lastName = new JTextField(15);

		//Radio buttons to choose the position
		guard = new JRadioButton("Guard");
		center = new JRadioButton("Center");
		forward = new JRadioButton("Forward");
		//Button group for the radio buttons
		group = new ButtonGroup();

		//Buttons to select the action to perform
		addPlayer = new JButton("Add Player");
		printTeam = new JButton("Print Team");
		newTeam = new JButton("New Team");
		exit = new JButton("Exit");

		//Image to be displayed at the top of the panel
		ImageIcon basketballImage = new ImageIcon("basketball.png");
		JLabel basketball = new JLabel("");
		//Set the label to the basketball image
		basketball.setIcon(basketballImage);

		//Add a BorderrLayout to the main panel
		setLayout(new BorderLayout());

		//Add the basketball image to the top panel
		topPanel.add(basketball);
		//Add a title label to the top panel
		topPanel.add(new JLabel("Basketball Teams"));
		//Set the size of the top panel
		topPanel.setPreferredSize(new Dimension(325,125));

		//Set the team name panel to the passed String and make the field non-editable
		teamName.setText(t);
		teamName.setEditable(false);

		//Add the team and name labels and text fields to the sub panels
		teamPanel.add(new JLabel("Team:"));
		teamPanel.add(teamName);
		fNamePanel.add(new JLabel("First Name:"));
		fNamePanel.add(firstName);
		lNamePanel.add(new JLabel("Last Name:"));
		lNamePanel.add(lastName);

		//Add a GridLayout to the text panel
		textPanel.setLayout(new GridLayout(3,1));
		//Add the sub panels to the text panel
		textPanel.add(teamPanel);
		textPanel.add(fNamePanel);
		textPanel.add(lNamePanel);

		//Add the radio buttons to the button group
		group.add(guard);
		group.add(center);
		group.add(forward);

		//Set a title border for the radio button panel and add the radio buttons to the panel
		radioPanel.setBorder(BorderFactory.createTitledBorder("Position"));
		radioPanel.add(guard);
		radioPanel.add(center);
		radioPanel.add(forward);

		//Add the text and radio button panels to the center panel
		centerPanel.add(textPanel);
		centerPanel.add(radioPanel);

		//Set the action commands for the buttons
		addPlayer.setActionCommand("a");
		printTeam.setActionCommand("p");
		newTeam.setActionCommand("n");
		exit.setActionCommand("e");

		//Add ButtonListeners to the buttons
		addPlayer.addActionListener(new ButtonListener());
		printTeam.addActionListener(new ButtonListener());
		newTeam.addActionListener(new ButtonListener());
		exit.addActionListener(new ButtonListener());

		//Set the size of the bottom panel and add the buttons to it
		bottomPanel.setPreferredSize(new Dimension(325,65));
		bottomPanel.add(addPlayer);
		bottomPanel.add(printTeam);
		bottomPanel.add(newTeam);
		bottomPanel.add(exit);

		//Add each of the panels to the appropriate section of the main panel
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}

	/**
	 * Get the name of the team from the user using a JOptionPane
	 * and return the value to the calling method
	 * @return The String value of the team name
	 */
	private String getTeamName()
	{
		return JOptionPane.showInputDialog("What is the name of this team?");
	}

	/**
	 * Detect which radio button is selected and return the String value of that position
	 * Otherwise return an empty String
	 * @return String value of the selected position
	 */
	private String getPosition()
	{
		if(guard.isSelected())
			return "Guard";
		else if(center.isSelected())
			return "Center";
		else if(forward.isSelected())
			return "Forward";
		else return "";
	}

	/**
	 * Clear the text fields and deselect the radio buttons
	 * Give the focus to the first name text field
	 */
	private void clearFields()
	{
		firstName.setText("");
		lastName.setText("");
		group.clearSelection();
		firstName.requestFocus();
	}

	/**
	 * AtionListener for the buttons to determine the action to be performed
	 */
	private class ButtonListener implements ActionListener
	{
		/**
		 * Determine the action to be performed
		 */
		public void actionPerformed(ActionEvent e)
		{
			//Use the action command of each button to determine the appropriate action
			switch(e.getActionCommand().charAt(0))
			{
			//If the "Add Player" button is clicked
			case 'a':
				//If any of the fields are blank or no radio button is selected exit the switch statement
				if(firstName.getText().equals("") || lastName.getText().equals("") || getPosition().equals(""))
					break;
				//Attempt to add the player to the team
				String message = theTeam.addPlayer(firstName.getText(), lastName.getText(), getPosition());
				//If no error message is returned clear the fields and await the next action
				if(message == null)
					clearFields();
				//Otherwise display the returned error message
				else
					JOptionPane.showMessageDialog(null, message);
				break;
				//If the "Print Team" button is clicked
			case 'p':
				//Display a JOptionPane with the String representation of the current team
				JOptionPane.showMessageDialog(null, theTeam.printTeam());
				break;
				//If the "New Team" button is clicked
			case 'n':
				//If the number of teams is 2 or greater display an error message
				if(Team.getNumTeams() >=2)
				{
					JOptionPane.showMessageDialog(null, "There are already two teams\nTeam not added");
				}
				//Otherwise clear the fields, get a new team name, and set the team name field
				else
				{
					clearFields();
					teamName.setText(getTeamName());
					//Create a new Team object - assign the new team to theTeam
					theTeam = new Team(teamName.getText());
				}
				break;
				//If the "Exit" button is clicked
			case 'e':
				//Exit the program and close the frame
				System.exit(0);
			}
		}
	}
}