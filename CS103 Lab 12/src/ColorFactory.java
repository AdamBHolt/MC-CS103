import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class creates a frame to demonstrate various GUI elements
 * including buttons, radio buttons, and events
 * 9/30/13
 * @author Adam Holt
 */
public class ColorFactory extends JFrame
{
	//Constant width and height values
	final int WIDTH = 500;
	final int HEIGHT = 300;

	//Elements to be added to the frame
	JPanel topPanel;
	JPanel bottomPanel;
	JLabel theLabel;

	/**
	 * Default ColorFactory constructor
	 */
	public ColorFactory()
	{
		//Set behaviors for the frame
		setTitle("Color Factory");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane();
		setLayout(new BorderLayout());

		//Create the top panel
		buildTopPanel();
		//Add the top panel to the frame
		add(topPanel, BorderLayout.NORTH);

		//Create the bottom panel
		buildBottomPanel();
		//Add the bottom panel to the frame
		add(bottomPanel, BorderLayout.SOUTH);

		//Create the label
		theLabel = new JLabel("Top buttons change the panel color and bottom radio buttons change the text color.");
		//Add the label to the frame
		add(theLabel, BorderLayout.CENTER);
	}

	/**
	 * Create and add elements to the top panel
	 */
	private void buildTopPanel()
	{
		//Create the panel
		topPanel = new JPanel();

		//Create and name three buttons
		JButton button1 = new JButton("Red");
		JButton button2 = new JButton("Orange");
		JButton button3 = new JButton("Yellow");

		//Set the background colors for the buttons
		button1.setBackground(Color.red);
		button2.setBackground(Color.orange);
		button3.setBackground(Color.yellow);

		//Set the background color for the panel
		topPanel.setBackground(Color.white);
		//Create a flow layout manager for the panel
		topPanel.setLayout(new FlowLayout());

		//Add the buttons to the panel
		topPanel.add(button1);
		topPanel.add(button2);
		topPanel.add(button3);

		//Set action commands for the buttons
		button1.setActionCommand("r");
		button2.setActionCommand("o");
		button3.setActionCommand("y");

		//Add ActionListener to the buttons
		button1.addActionListener(new ButtonListener());
		button2.addActionListener(new ButtonListener());
		button3.addActionListener(new ButtonListener());
	}

	/**
	 * Create and add elements to the bottom panel
	 */
	private void buildBottomPanel()
	{
		//Create the panel
		bottomPanel = new JPanel();

		//Create three radio buttons
		JRadioButton radio1 = new JRadioButton("Green");
		JRadioButton radio2 = new JRadioButton("Blue");
		JRadioButton radio3 = new JRadioButton("Cyan");

		//Create a button group and add the radio buttons to it
		ButtonGroup group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		group.add(radio3);

		//Set the text color of the radio buttons
		radio1.setForeground(Color.green);
		radio2.setForeground(Color.blue);
		radio3.setForeground(Color.cyan);

		//Set the background color of the panel
		bottomPanel.setBackground(Color.white);
		//Create a flow layout manager for the panel
		bottomPanel.setLayout(new FlowLayout());

		//Add the radio buttons to the panel
		bottomPanel.add(radio1);
		bottomPanel.add(radio2);
		bottomPanel.add(radio3);

		//Set action commands for the radio buttons
		radio1.setActionCommand("g");
		radio2.setActionCommand("b");
		radio3.setActionCommand("c");

		//Add ActionListener to the radio buttons
		radio1.addActionListener(new RadioButtonListener());
		radio2.addActionListener(new RadioButtonListener());
		radio3.addActionListener(new RadioButtonListener());
	}

	/**
	 * ActionListener for buttons in the top panel
	 * @author Adam Holt
	 */
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Set the background color of the main frame based on the
			//ActionCommand sent from the buttons
			if(e.getActionCommand().equals("r"))
			{
				getContentPane().setBackground(Color.red);
			}

			else if (e.getActionCommand().equals("o"))
			{
				getContentPane().setBackground(Color.orange);
			}	

			else if (e.getActionCommand().equals("y"))
			{
				getContentPane().setBackground(Color.yellow);
			}	
		}
	}

	/**
	 * ActionListener for radio buttons in the bottom panel
	 * @author Adam Holt
	 */
	private class RadioButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Set the foreground color of the label in the main frame based on the
			//ActionCommand sent from the radio buttons
			if (e.getActionCommand().equals("g"))
			{
				theLabel.setForeground(Color.green);
			}	
			else if (e.getActionCommand().equals("b"))
			{
				theLabel.setForeground(Color.blue);	
			}	
			else if (e.getActionCommand().equals("c"))
			{
				theLabel.setForeground(Color.cyan);	
			}	
		}
	}
}
