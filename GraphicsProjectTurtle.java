

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.awt.geom.*;

public class GraphicsProjectTurtle
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
		x=500;
		y=700;
		
	
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0,0,2000,1500);
		drawJellyFish(g,x,y);
		
	}
	
	public void drawJellyFish(Graphics g, int x, int y)
	{
	   //fins
	   g.setColor(Color.darkGray);
	   int[] leftfin={x-20, x-20, x-40, x-40};
	   int[] leftfin2={y+30, y+65, y+20, y+5};
	   g.fillPolygon(leftfin, leftfin2, 4);
	   int[]rightfin = {x+5,x+5,x+25,x+25};
	   int[]rightfin2 = {y+30, y+60,y+20,y+5};
	   g.fillPolygon(rightfin, rightfin2, 4);
	   
	   int[]lefttail={x-20, x-20, x-40, x-40};	   
	   int[]lefttail2={y+30, y+65, y+90, y+75};
	   g.fillPolygon(lefttail, lefttail2,4);	   
	   
	   int[]righttail = {x+5,x+5,x+25,x+25};
	   int[]righttail2 = {y+30, y+65, y+90, y+75};
	   g.fillPolygon(righttail, righttail2, 4);
	   
	   //main body
	   g.setColor(Color.green);
	   g.fillOval(x-20,y-10,25,25);
	   g.fillOval(x-32,y+10,50,75);
	   g.setColor(Color.black);
	   g.drawOval(x-32,y+10,50,75);
	   //shell
	   g.drawLine(x-25,y+20,x-15,y+25);
	   g.drawLine(x-15,y+25,x,y+25);
	   g.drawLine(x,y+25,x+10,y+20);
	   
	   g.drawLine(x,y+25,x+5,y+30);
	   g.drawLine(x+5,y+30,x+5,y+35);
	   g.drawLine(x+5,y+35,x,y+40);
	   g.drawLine(x,y+40,x-15,y+40);
	   g.drawLine(x-15, y+40,x-20,y+35);
	   g.drawLine(x-20,y+35,x-20,y+30);
	   g.drawLine(x-20,y+30,x-15,y+25);
	   
	   g.drawLine(x-20,y+35,x-30,y+40);
	   g.drawLine(x+5,y+35,x+15,y+40);
	   
	   g.drawLine(x,y+40,x+5,y+45);
	   g.drawLine(x+5,y+45,x+5,y+50);
	   g.drawLine(x+5,y+50,x,y+55);
	   g.drawLine(x,y+55,x-15,y+55);//
	   g.drawLine(x-15,y+55,x-20,y+50);
	   g.drawLine(x-20,y+50,x-20,y+45);
	   g.drawLine(x-20,y+45,x-15,y+40);
	   
	   
	   g.drawLine(x-20,y+50,x-30,y+55);
	   g.drawLine(x+5,y+50,x+15,y+55);
	   g.drawLine(x,y+55,x+5,y+60);
	   g.drawLine(x+5,y+60,x+5,y+65);//
	   g.drawLine(x+5,y+65,x,y+70);
	   g.drawLine(x,y+70,x-15,y+70);
	   g.drawLine(x-15,y+70,x-20,y+65);
	   g.drawLine(x-20,y+65,x-20,y+60);
	   g.drawLine(x-20,y+60,x-15,y+55);
	   
	   g.drawLine(x+5,y+65,x+10,y+70);
	   g.drawLine(x-20,y+65,x-25,y+70);
	   
	   g.drawLine(x,y+70,x+5,y+80);
	   g.drawLine(x-15,y+70,x-20,y+80);
	   
	   //eyes
	   g.fillOval(x-15,y-5,5,5);
	   g.fillOval(x-5,y-5,5,5);
	   
	  
	   
	   	
    /* g.fillArc(x+2,y-5,100,137,345,180);
	   g.fillArc(x+2,y+38,20,20,155,180);
	   g.fillArc(x+22,y+45,20,20,155,180);
	   g.fillArc(x+42,y+52,20,20,155,180);
	   g.fillArc(x+62,y+59,20,20,155,180);
	   g.fillArc(x+82,y+66,20,20,155,180);*/
	   
	   //tentacles
	  
	   
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		y--;
		add++;
				
			
		
		/*y+=add;
		if(x==200 && y==200)
			add*=-1;
		if(x==10 && y==10)
			add*=-1;		
			*/
	
		repaint();
	}
	
}