import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * This class draws a logo on a JFrame
 * @author Adam Holt
 */

public class LogoPanel extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	//Ellipses to for "Q" of the logo
	Ellipse2D.Double outerEllipse,
					innerEllipse,
					bigOuterEllipse,
					bigInnerEllipse;
	/**
	 * Default constructor
	 */
	public LogoPanel()
	{

		//Define dimensions of ellipses
		outerEllipse = new Ellipse2D.Double(60,100,100,100);
		innerEllipse = new Ellipse2D.Double(70,110,90,90);
		bigOuterEllipse = new Ellipse2D.Double(30,20,300,300);
		bigInnerEllipse = new Ellipse2D.Double(50,40,280,280);
		setBackground(Color.white);
	}
	
	/**
	 * Paints the elementts on the panel
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		//Graphics2D objectcast from Graphics object
		Graphics2D g2 = (Graphics2D) g;
		
		//Define partially transparent color
		Color lightG = new Color(100,100,100,40);
		
		//Draw ellipses of background "Q"
		g2.setColor(lightG);
		g2.fill(bigOuterEllipse);
		g2.setColor(Color.white);
		g2.fill(bigInnerEllipse);
		
		g.setColor(lightG);
		//Coordinates for background polygon
		int[]xCoordsBack = {160,340,290};
		int[]yCoordsBack = {160,285,335};
		//Draw background polygon
		g.fillPolygon(xCoordsBack,yCoordsBack,3);
		
		//Coordinates for "Q" polygon
		int[]xCoordsQ = {110,165,150};
		int[]yCoordsQ = {150,195,210};
		//Coordinates for "i" polygon
		int[]xCoordsI = {225,215,235};
		int[]yCoordsI = {210,150,150};
		//Fonts for text elements
		Font bigFont = new Font("Arial", Font.BOLD, 75);
		Font smallFont = new Font("Arial", Font.PLAIN, 14);
		
		//Draw ellipses to form first part of "Q"
		g2.setColor(Color.black);
		g2.fill(outerEllipse);
		//Clear the center section of the "Q"
		g2.setColor(Color.white);
		g2.fill(innerEllipse);
		//Draw the line through the "Q"
		g.setColor(Color.red);
		g.fillPolygon(xCoordsQ,yCoordsQ,3);
		
		//Draw large text
		g2.setColor(Color.black);
		g2.setFont(bigFont);
		g2.drawString("u rk", 170, 200);
		
		//Draw small text URL
		g2.setFont(smallFont);
		g2.drawString("QuirkComputing.com", 160, 220);
		
		//Draw "i" polygon
		g.setColor(Color.red);
		g.fillPolygon(xCoordsI,yCoordsI,3);
		
	}
}