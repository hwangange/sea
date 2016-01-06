import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

public class GraphicsProjectSeaweed
{
	public static void main(String...args)
	{
		JFrame j = new JFrame();  //JFrame is the window; window is a depricated class
		MyPanelb m = new MyPanelb();
		j.setSize(m.getSize());
		j.add(m); //adds the panel to the frame so that the picture will be drawn
			      //use setContentPane() sometimes works better then just add b/c of greater efficiency.

		j.setVisible(true); //allows the frame to be shown.

		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes the dialog box exit when you click the "x" button.
	}

}

class MyPanelb extends JPanel implements ActionListener
{
	
	private Timer time;
	private int x,y,seaX,seaY,track;
	private int add;
	
	MyPanelb()
	{
		//time = new Timer(15, this); //sets delay to 15 millis and calls the actionPerformed of this class.
		time= new Timer(50, this);
		setSize(2000, 1500);
		setVisible(true); //it's like calling the repaint method.
		time.start();
		add=1;
		x=seaX=800;
		y=seaY=500;
		track=1;
	
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0,0,2000,1500);
		drawSeaweed(g,seaX,seaY);
		drawClown(g, x-150, y-100);
		
	}
	
	public void drawSeaweed(Graphics g, int x, int y)
	{
		g.setColor(Color.green);
		g.fillRect(x, y, 5, 150);
		//g.fillArc(x, y+120, 100, 20, 45, 180);
		g.fillArc(x-80, y+120, 100, 20, 135, 180);
		g.fillArc(x-20, y+120, 100, 20, 225, 180); //bottom2
		
		g.fillArc(x-90, y+100, 120, 20, 130, 180);
		g.fillArc(x-25, y+100, 120, 20, 230, 180);
		
		g.fillArc(x-100, y+80, 140, 20, 125, 180);
		g.fillArc(x-30, y+80, 140, 20, 235, 180);
		
		g.fillArc(x-100, y+60, 160, 20, 120, 180);
		g.fillArc(x-35, y+60, 160, 20, 240, 180);
		
		g.fillArc(x-125, y+40, 180, 20, 115, 180);
		g.fillArc(x-40, y+40, 180, 20, 245, 180);
		
		g.fillArc(x-135, y+20, 200, 20, 110, 180);
		g.fillArc(x-70, y+20, 220, 20, 250, 180);
		
		g.fillArc(x-140, y, 220, 20, 105, 180);
		g.fillArc(x-70, y, 220, 20, 255, 180);
	
		//g.fillArc(x-170, y-20, 240, 20, 100, 200);
		//g.fillArc(x-70, y+20, 220, 20, 260, 200);
			
	}
	
	public void drawClown(Graphics g, int x, int y)
	{
		g.setColor(Color.orange);
		x+=80;
		y+=100;
		g.fillOval(x, y, 20, 15); //divide everything by 5
		
		int[] conn={x+5, x+5, x-2, x-2};
		int[] conn2={y+1, y+15, y+11, y+4};
		g.fillPolygon(conn, conn2, 4); //connector
		
		int[] oneTail={x-2, x-2, x-6, x-6};
		int[] oneTail2={y+4, y+11, y+2, y-1};
		
		Graphics2D g2d = (Graphics2D) g;
	    GradientPaint gp1 = new GradientPaint(5, 5, Color.red, 20, 20, Color.yellow, true);
	    g2d.setPaint(gp1);
	    g2d.fillPolygon(oneTail, oneTail2, 4); //tail1
		
		int[] twoTail={x-2, x-2, x-6, x-6};
		int[] twoTail2={y+4, y+11, y+16, y+13};
		g2d.fillPolygon(twoTail, twoTail2, 4); //tail2
		
		int[] fin={x+4, x+10, x+10};
		int[] fin2={y+37/5, y+27/5, y+47/5};
		g2d.fillPolygon(fin, fin2, 3); //fin
		
		g.setColor(Color.black);
		g.fillOval(x+14, y+5, 2, 2); //eye
		g.drawArc(x+15, y+8, 4, 4, 36, 18);
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(track<=15 && track>0)
		{
			track++;
			y++;
		}
		else if (track>15 && track<30)
		{	
			track++;
			y--;			
		}
		else if (track==30)
		{
			track=1;
			y++;
		}
		repaint();
	}
	
}