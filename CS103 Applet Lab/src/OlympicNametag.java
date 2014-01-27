import javax.swing.*;
import java.awt.*;

/**
 * This applet class draws a nametag with the Olympic rings, national flag and information
 * aboutt he participant
 * Date: 10/2/13
 * @author Adam Holt
 *
 */
public class OlympicNametag extends JApplet
{

	/**
	 * Creates the applet
	 */
	public void init()
	{
		setSize(250,300);
	}

	/**
	 * Draws the elements on the applet window
	 */
	public void paint(Graphics g)
	{
		g.drawRect(5, 5, 239, 290);
		//Size of Olympic ring
		final int RING_SIZE = 60;
		
		//Dimensions of flag
		final int FLAG_WIDTH = 90;
		final int FLAG_HEIGHT = 55;
		
		//Dimensions of blue field
		final int FIELD_WIDTH = FLAG_WIDTH / 2;
		final int FIELD_HEIGHT = FLAG_HEIGHT / 2;
		
		//Upper left corner of flag
		final int FLAG_X = 80;
		final int FLAG_Y = 200;
		
		final int STRIPE_HEIGHT = FLAG_HEIGHT / 13;
		final int STRIPE_SEPARATION = STRIPE_HEIGHT * 2;
		
		//Draw Olympic rings
		g.setColor(Color.black);
		g.drawOval(95, 20, RING_SIZE,RING_SIZE);
		g.setColor(Color.blue);
		g.drawOval(25, 20,RING_SIZE,RING_SIZE);		
		g.setColor(Color.red);
		g.drawOval(165, 20, RING_SIZE, RING_SIZE);
		g.setColor(Color.yellow);
		g.drawOval(60,50, RING_SIZE, RING_SIZE);
		g.setColor(Color.green);
		g.drawOval(130, 50, RING_SIZE, RING_SIZE);

		//Draw flag
		g.setColor(Color.black);
		g.drawRect(FLAG_X, FLAG_Y, FLAG_WIDTH, FLAG_HEIGHT);

		//Draw red stripes
		g.setColor(Color.red);
		
		for(int i=0; i <=6; i++)
			g.fillRect(FLAG_X, FLAG_Y+(STRIPE_SEPARATION*i), FLAG_WIDTH, STRIPE_HEIGHT);
		
		//Draw blue field
		g.setColor(Color.blue);
		g.fillRect(FLAG_X, FLAG_Y, FIELD_WIDTH, FIELD_HEIGHT);
		
		//Draw stars
		g.setColor(Color.white);
		for(int y=FLAG_Y+STRIPE_HEIGHT+2; y<FLAG_Y+FIELD_HEIGHT-STRIPE_HEIGHT; y+=STRIPE_HEIGHT+2)
		{
			for(int x=FLAG_X+STRIPE_HEIGHT-2; x<FLAG_X+FIELD_WIDTH-STRIPE_HEIGHT; x+=STRIPE_HEIGHT+2)
			{
				g.drawLine(x, y, x+1, y-3);
				g.drawLine(x+1, y-3, x+2, y);
				g.drawLine(x+2, y, x, y-2);
				g.drawLine(x, y-2, x+2,y-2);
				g.drawLine(x+2,y-2, x, y);
			}
		}
		
		//Draw text elements
		g.setColor(Color.black);
		g.drawString("Adam Holt", 96, 140);
		g.drawString("Decathalon", 94, 160);
		g.drawString("Los Angeles,CA", 82, 180);
		g.drawString("USA", 112, 280);
	}
}
