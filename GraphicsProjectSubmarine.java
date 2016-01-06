
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

public class GraphicsProjectSubmarine
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
		x=900;
		y=300;
	
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0,0,2000,1500);
		drawSubmarine(g,x,y);
		
	}
	
	public void drawSubmarine(Graphics g, int x, int y)
	{
		//periscope
		g.setColor(Color.orange);
		g.fillRect(x+100,y-25,50,100);
		g.setColor(Color.darkGray);
		g.fillRect(x+105,y-65,25,40);
		g.setColor(Color.lightGray);
		g.fillRect(x+95,y-63,10,10);
		
		//main
		g.setColor(Color.yellow);
		g.fillOval(x, y, 550, 300);		
		
		//windows
		g.setColor(Color.blue);
		g.fillOval(x+93,y+68,90,90);
		g.fillOval(x+243,y+68,90,90);
		g.fillOval(x+393,y+68,90,90);
		g.setColor(Color.cyan);		
		g.fillOval(x+100,y+75,75,75);
		g.fillOval(x+250,y+75,75,75);
		g.fillOval(x+400,y+75,75,75);
		g.fillArc(x, y+70, 100,130,90,90);
		
		g.setColor(Color.red);
		g.fillRect(x+20,y+175,510,10);
		
		//propell..
		g.setColor(Color.blue);
		g.fillOval(x+537,y+130,20,50);
		g.setColor(Color.lightGray);
		g.fillRect(x+556,y+150,20,10);
		g.setColor(Color.darkGray);
		g.fillOval(x+555,y+78,50,80);
		g.fillOval(x+555,y+150,50,80);		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		x-=1;
		if (x <-500)
			x=1200;
			
		
	/*	y+=add;
		if(x==200 && y==200)
			add*=-1;
		if(x==10 && y==10)
			add*=-1;*/		
			
	
		repaint();
	}
	
}