import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

public class GraphicsProjectShark
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
		time = new Timer(2, this); //sets delay to 15 millis and calls the actionPerformed of this class.
		setSize(2000, 1500);
		setVisible(true); //it's like calling the repaint method.
		time.start();
		add=1;
		x=y=100;
	
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0,0,2000,1500);
		drawShark(g,x,y);
		
	}
	
	public void drawShark(Graphics g, int x, int y)
	{
		
		g.setColor(Color.gray);
		g.fillOval(x, y, 200, 70);

		//fins
		int [] xCoord= {x+60, x+140, x+60+10};
		int [] yCoord= {y+20, y+20, y-30};
		g.fillPolygon(xCoord, yCoord, 3);
		int[]bottom1={x+60, x+150, x+40};
		int[]bottom2={y+60, y+60, y+85};
		g.fillPolygon(bottom1, bottom2, 3);
		
		//snout		
		int[] newXCoord= {x+100, x+100, x+250};
		int[] newYCoord={y, y+70, y+35};
		g.fillPolygon(newXCoord, newYCoord, 3);
		
		//tail
		
		//WEIRD
		/*int[]tailtube={x+20, 20, x-30};
		int[]tailtube2={y+15, y+45, y+30};
		g.fillPolygon(tailtube, tailtube2, 3);*/
		
		int[]tailtube={x+20, x+20, x-30};
		int[]tailtube2={y+20, y+50, y+35};
		g.fillPolygon(tailtube, tailtube2, 3);
		
		int[] tail1={x+20-10, x-30-10, x-50-10};
		int[] tail2={y+30+10, y+20+10, y-50+10};
		g.fillPolygon(tail1, tail2, 3);
		int[] tail3={x+20-10, x-30-10, x-50-10};
		int[] tail4={y+30+10, y+20+10, y+90+10};
		g.fillPolygon(tail3, tail4, 3);

		//face
		g.setColor(Color.black);
		g.fillOval(x+180, y+25, 10, 10);
		//g.drawLine(x+170, y+35, x+250, y+35);
		g.setColor(Color.white);
		int[]teeth1= {x+190, x+190, x+195};
		int[]teeth2={y+50, y+45, y+50};
		g.fillPolygon(teeth1, teeth2, 3);
		
		//gills
		g.setColor(Color.black);
		g.drawArc(x+45, y+15, 20, 40, 90, 180);
		g.drawArc(x+30, y+25, 10, 25, 90, 180);
	
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		
		x+=1;
		if(x>2000)
			x=1;
	/*	if (x <-500)
			x=1200;
			
		
		y+=add;
		if(x==200 && y==200)
			add*=-1;
		if(x==10 && y==10)
			add*=-1;*/		
			
	
		repaint();
	}
	
}