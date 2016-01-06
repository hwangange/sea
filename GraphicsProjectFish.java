import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsProjectFish
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
	private int x,y;
	private int add;
	
	MyPanelb()
	{
		time = new Timer(15, this); //sets delay to 15 millis and calls the actionPerformed of this class.
		setSize(2000, 1500);
		setVisible(true); //it's like calling the repaint method.
		time.start();
		add=1;
		x=300;
		y=300;
	
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0,0,2000,1500);
		drawFish(g,x,y);
		drawBubble(g, x, y);
		drawPurpleFish(g,x+100, y-135);
		drawBubble(g,x+100, y-135);
		drawGreenFish(g,x-100, y-100);
		drawBubble(g,x-100, y-100);
		
	}
	
	public void drawFish(Graphics g, int x, int y)
	{
		g.setColor(Color.orange);
		g.fillOval(x, y, 100, 75);
		
		int[] conn={x+25, x+25, x-10, x-10};
		int[] conn2={y+5, y+70, y+55, y+20};
		g.fillPolygon(conn, conn2, 4); //connector
		
		int[] oneTail={x-10, x-10, x-30, x-30};
		int[] oneTail2={y+20, y+55, y+10, y-5};
		
		Graphics2D g2d = (Graphics2D) g;
	    GradientPaint gp1 = new GradientPaint(5, 5, Color.red, 20, 20, Color.yellow, true);
	    g2d.setPaint(gp1);
	    g2d.fillPolygon(oneTail, oneTail2, 4); //tail1
		
		int[] twoTail={x-10, x-10, x-30, x-30};
		int[] twoTail2={y+20, y+55, y+80, y+65};
		g2d.fillPolygon(twoTail, twoTail2, 4); //tail2
		
		int[] fin={x+20, x+50, x+50};
		int[] fin2={y+37, y+27, y+47};
		g2d.fillPolygon(fin, fin2, 3); //fin
		
		g.setColor(Color.black);
		g.fillOval(x+70, y+25, 10, 10); //eye
		g.drawArc(x+75, y+40, 20, 20, 180, 90);
	}
	
	public void drawPurpleFish(Graphics g, int x, int y)
	{
		g.setColor(Color.magenta);
		g.fillOval(x, y, 100, 75);
		
		int[] conn={x+25, x+25, x-10, x-10};
		int[] conn2={y+5, y+70, y+55, y+20};
		g.fillPolygon(conn, conn2, 4); //connector
		
		int[] oneTail={x-10, x-10, x-30, x-30};
		int[] oneTail2={y+20, y+55, y+10, y-5};
		
		Graphics2D g2d = (Graphics2D) g;
	    GradientPaint gp1 = new GradientPaint(5, 5, Color.pink, 20, 20, Color.blue, true);
	    g2d.setPaint(gp1);
	    g2d.fillPolygon(oneTail, oneTail2, 4); //tail1
		
		int[] twoTail={x-10, x-10, x-30, x-30};
		int[] twoTail2={y+20, y+55, y+80, y+65};
		g2d.fillPolygon(twoTail, twoTail2, 4); //tail2
		
		int[] fin={x+20, x+50, x+50};
		int[] fin2={y+37, y+27, y+47};
		g2d.fillPolygon(fin, fin2, 3); //fin
		
		g.setColor(Color.black);
		g.fillOval(x+70, y+25, 10, 10); //eye
		g.drawArc(x+75, y+40, 20, 20, 180, 90);
	}
	
	public void drawGreenFish(Graphics g, int x, int y)
	{
		g.setColor(Color.green);
		g.fillOval(x, y, 100, 75);
		
		int[] conn={x+25, x+25, x-10, x-10};
		int[] conn2={y+5, y+70, y+55, y+20};
		g.fillPolygon(conn, conn2, 4); //connector
		
		int[] oneTail={x-10, x-10, x-30, x-30};
		int[] oneTail2={y+20, y+55, y+10, y-5};
		
		Graphics2D g2d = (Graphics2D) g;
	    GradientPaint gp1 = new GradientPaint(5, 5, Color.gray, 20, 20, Color.darkGray, true);
	    g2d.setPaint(gp1);
	    g2d.fillPolygon(oneTail, oneTail2, 4); //tail1
		
		int[] twoTail={x-10, x-10, x-30, x-30};
		int[] twoTail2={y+20, y+55, y+80, y+65};
		g2d.fillPolygon(twoTail, twoTail2, 4); //tail2
		
		int[] fin={x+20, x+50, x+50};
		int[] fin2={y+37, y+27, y+47};
		g2d.fillPolygon(fin, fin2, 3); //fin
		
		g.setColor(Color.black);
		g.fillOval(x+70, y+25, 10, 10); //eye
		g.drawArc(x+75, y+40, 20, 20, 180, 90);
	}
	
	public void drawBubble(Graphics g, int x, int y)
	{
		g.setColor(Color.cyan);
		g.fillOval(x+120, y-20, 30, 30);
		g.setColor(Color.blue);
		g.fillOval(x+140, y-10, 5, 10);
		g.drawArc(x+124, y-18, 25, 25, 180, 90);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		
		x+=1;
		if (x <-500)
			x=1200;
		if(x >2000)
			x=1;
			
		
	/*	y+=add;
		if(x==200 && y==200)
			add*=-1;
		if(x==10 && y==10)
			add*=-1;*/		
			
	
		repaint();
	}
	
}