//********************************************************************
//  ReboundPanel.java     
//  Represents the primary panel for the Rebound program.
//********************************************************************

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ReboundPanel extends JPanel
{
    private final int WIDTH = 300, HEIGHT = 100;
    private final int DELAY = 20, IMAGE_SIZE = 35;

    private ImageIcon image;
    private Timer timer;
    private int x, y, moveX, moveY;

    //-----------------------------------------------------------------
    //  Sets up the panel, including the timer for the animation.
    //-----------------------------------------------------------------
    public ReboundPanel()
    {
	timer = new Timer(DELAY, new ReboundListener());

	image = new ImageIcon ("C:\\happyFace.gif");

	x = 0;
	y = 40;
	moveX = moveY = 3;

	setPreferredSize (new Dimension(WIDTH, HEIGHT));
	setBackground (Color.black);
	addMouseListener(new TheMouseListener());
	timer.start();
    }

    //-----------------------------------------------------------------
    //  Draws the image in the current location.
    //-----------------------------------------------------------------
    public void paintComponent (Graphics page)
    {
	super.paintComponent (page);
	image.paintIcon (this, page, x, y);
    }

    //*****************************************************************
    //  Represents the action listener for the timer.
    //*****************************************************************
    private class ReboundListener implements ActionListener
    {
	//--------------------------------------------------------------
	//  Updates the position of the image and possibly the direction
	//  of movement whenever the timer fires an action event.
	//--------------------------------------------------------------
	public void actionPerformed (ActionEvent event)
	{
	    x += moveX;
	    y += moveY;

	    if (x <= 0 || x >= WIDTH-IMAGE_SIZE)
		moveX = moveX * -1;

	    if (y <= 0 || y >= HEIGHT-IMAGE_SIZE)
		moveY = moveY * -1;

	    repaint();
	}
    }

    private class TheMouseListener implements MouseListener
    {
	public void mouseClicked(MouseEvent e)
	{
	    if(e.getX() > x && e.getX() < x+30 && e.getY() > y && e.getY() < y+30)
	    {
		if(image.toString().equals("C:\\happyFace.gif"))

		    image = new ImageIcon ("C:\\redSmiley.gif");
		else
		    image = new ImageIcon ("C:\\happyFace.gif");
	    }
	}

	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}

    }
}
