import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

public class GraphicsProjectCrab
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
	private int x,y, track;
	private int add;
	
	MyPanelb()
	{
		time = new Timer(15, this); //sets delay to 15 millis and calls the actionPerformed of this class.
		setSize(2000, 1500);
		setVisible(true); //it's like calling the repaint method.
		time.start();
		add=track=1;
		x=300;
		y=550;
	
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0,0,2000,1500);
		drawCrab(g,x,y);
		
	}
	
	public void drawCrab(Graphics g, int x, int y)
	{
		g.setColor(Color.black);
		//legs
		int[] oneLeg1= {x+10, x+15, x-30, x-35, x-40};
		int[] oneLeg2= {y+40, y+60, y+65, y+100, y+60};
		g.fillPolygon(oneLeg1, oneLeg2, 5);
		
		int[] twoLeg1={x+25, x+30, x-20, x-25, x-30};
		int[] twoLeg2={y+60, y+80, y+85, y+120, y+80};
		g.fillPolygon(twoLeg1, twoLeg2, 5);
		
		int[] threeLeg1={x+190, x+185, x+230, x+235, x+240};
		int[] threeLeg2={y+40, y+60, y+65, y+100, y+60};
		g.fillPolygon(threeLeg1, threeLeg2, 5);
		
		int[] fourLeg1={x+175, x+170, x+215, x+220, x+225};
		int[] fourLeg2={y+60, y+80, y+85, y+120, y+80};
		g.fillPolygon(fourLeg1, fourLeg2, 5);
		
		g.setColor(Color.red);
		//g.fillOval(x, y, 200, 100); 
		//body
		g.fillArc(x, y, 200, 80, 0, 180);
		int[] trapez={x, x+200, x+170, x+30};
		int[] trapez2={y+40, y+40, y+80, y+80};
		g.fillPolygon(trapez, trapez2, 4);
		g.fillArc(x+30, y+60, 140, 40, 0, -180);
		
		g.fillRect(x+70, y-50, 15, 100);
		g.fillRect(x+120, y-50, 15, 100); //eye stalks

		g.setColor(Color.white);
		g.fillOval(x+65, y-65, 25, 25);
		g.fillOval(x+115, y-65, 25, 25); //eye whites
		g.setColor(Color.black);
		g.drawOval(x+65, y-65, 25, 25);
		g.drawOval(x+115, y-65, 25, 25); //eye outline
		g.fillOval(x+115, y-60, 10, 10);
		g.fillOval(x+65, y-60, 10, 10); //pupil
		
		g.setColor(Color.red);
		int[] leftArm1={x+20, x+40, x-10, x-15};
		int[] leftArm2={y+25, y+22, y-10, y-8};
		g.fillPolygon(leftArm1, leftArm2, 4); //left arm
		int[] rightArm1={x+170, x+180, x+200, x+195};
		int[] rightArm2={y+25, y+35, y-10, y-8};
		g.fillPolygon(rightArm1, rightArm2, 4); //right arm
		
		g.setColor(Color.black);
		g.fillArc(x+170, y-50, 50, 50, 60, -330);
		g.fillArc(x-40, y-50, 50, 50, 95, -300); //claws
		
		g.drawArc(x+50, y, 100, 50, 0, -180); //smile
			
	
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		
		//x-=1;
		if (x <-500)
			x=1200;
			
		if(track<=100 && track>0)
		{
			track++;
			//y++;
			x++;
		}
		else if (track>100 && track<200)
		{	
			track++;
		//	y--;
			x--;			
		}
		else if (track==200)
		{
			track=1;
		//	y++;
			x++;
		}
		
			
		
	/*	y+=add;
		if(x==200 && y==200)
			add*=-1;
		if(x==10 && y==10)
			add*=-1;*/		
			
	
		repaint();
	}
	
}