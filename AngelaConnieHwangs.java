import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.applet.Applet;
//sound
//import java.io.*; // for File 
//import java.util.*; // for Scanner 
//import javax.sound.sampled.*; // allows you to use the sound classes 


public class AngelaConnieHwangs
{
	public static void main(String...args)
	{
		
		//sound
		/*File file = new File("underthesea.wav");//File must be .WAV, .AU, or .AIFF
		AudioInputStream stream = AudioSystem.getAudioInputStream(file);
		Clip music = AudioSystem.getClip();
		music.open(stream);
		music.start(); //Start the music
		music.loop(Clip.LOOP_CONTINUOUSLY); //Loop the music
		//music.stop(); //Stop the music
		//music.close(); //Unload the clip from memory*/
		
		JFrame j = new JFrame();  //JFrame is the window; window is a depricated class
		MyPanelb m = new MyPanelb();
		j.setSize(m.getSize());
		j.add(m); //adds the panel to the frame so that the picture will be drawn
			      //use setContentPane() sometimes works better then just add b/c of greater efficiency.

		j.setVisible(true); //allows the frame to be shown.

		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes the dialog box exit when you click the "x" button.
		
		
		
    	
	}

}



class MyPanelb extends JPanel implements ActionListener, MouseListener, KeyListener
{
	
	private Timer time;
	private int x,y;
	private int subX, subY, blinkCount;
	private int seaX, seaY;
	private int crabX,crabY;
	private int add, track;
	private int scubaX, scubaY, scubaTrack;
	private int red, green, blue;
	private int bubbleX, bubbleY, bubbleCount, bLimit;
	private Scuba s;
	private String mystery;
	private int pressCount;
	private int turtleX, turtleY;
	private int bubbletime;
	//private File file; 
    ///private AudioInputStream stream; 
    //private Clip music; 
	
	
	MyPanelb()
	{

		
		time = new Timer(15, this); //sets delay to 15 millis and calls the actionPerformed of this class.
		setSize(2000, 1500);
		setVisible(true); //it's like calling the repaint method.
		time.start();
		
		add=track=1;
		x=y=bubbleX=bubbleY=100;
		bubbleCount=0; bLimit=100;
		crabX=300; crabY=550;
		subX=900; subY=150; blinkCount=0;
		seaX=0; seaY=500;
		red=0; green=255; blue=255;
		turtleX=1000; turtleY=1100;
		bubbletime = 0;
		//scuba//
		s=createScuba("scubadiver1.jpg");
		scubaX=900; scubaY=650; scubaTrack=0;
		mystery="Press down button for lyrics."; pressCount=1;
		
		addMouseListener(this);
		setFocusable(true);
		addKeyListener(this);
		
		
	}
	
	public void paintComponent(Graphics g)
	{
		//g.setColor(Color.cyan);
		//g.fillRect(0,0,2000, 1300);
		
		Color c= new Color(red, green, blue);
		g.setColor(c);
		g.fillRect(0,0,2000, 1300);
		g.setColor(new Color(250, 215, 50));
		g.fillRect(0,520,2000,400); 
		
		drawShark(g,x+300,y);
		drawSubmarine(g,subX,subY);
		
		drawFish(g,x+100,y+300, Color.orange, Color.red, Color.yellow);
		drawBubble(g,bubbleX+100, bubbleY+300);
		drawFish(g,x+200,y+165, Color.magenta, Color.pink, Color.blue);
		drawBubble(g, bubbleX+200, bubbleY+165);
		drawFish(g,x,y+200, Color.green, Color.gray, Color.darkGray);
		drawBubble(g, bubbleX, bubbleY+200);
		drawTurtle(g, turtleX, turtleY);
		
		for(int temp=0; temp<2100; temp+=300)
			drawSeaweed(g,seaX+temp, seaY);
		g.drawImage(s.getImage(), scubaX, scubaY, null);
		drawCrab(g,crabX,crabY);
		
		Font font = new Font("Jokerman", Font.PLAIN, 20);
		g.setFont(font);
		g.drawString(mystery, 1100, 50);
		g.drawString("Click on the water to change its color!", 1100, 800);
		
		if(bubbletime%2000==0)
		{
			bubbleX=bubbleY=100;		
			drawBubble(g,bubbleX+100, bubbleY+300);
			drawBubble(g, bubbleX+200, bubbleY+165);
			drawBubble(g, bubbleX, bubbleY+200);
		}

		
	}
	
	public void keyPressed(KeyEvent e)
	{		System.out.println(pressCount);
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			if(pressCount==6)
				pressCount=1;
			if(pressCount==1)
				mystery="Under the sea,";
			else if(pressCount==2)
				mystery="Under the sea!";
			else if(pressCount==3)
				mystery="Darling it's better";
			else if(pressCount==4)
				mystery="Down where it's wetter";
			else 
				mystery="Take it from me!";
			pressCount++;
			
			repaint();
		}

	}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
	
	public void mousePressed(MouseEvent e){
		if(red>255) red=0;
		red+=50;
		repaint();}
	public void mouseReleased(MouseEvent e){}

	public void mouseClicked(MouseEvent e){
		//left += 10;repaint();
		}

	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	
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
	
	public void drawCrab(Graphics g, int x, int y)
	{
		//y+=500;
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
	
	public void drawFish (Graphics g, int x, int y, Color main, Color shiny1, Color shiny2)
	{

		g.setColor(main);
		g.fillOval(x, y, 100, 75);
		
		int[] conn={x+25, x+25, x-10, x-10};
		int[] conn2={y+5, y+70, y+55, y+20};
		g.fillPolygon(conn, conn2, 4); //connector
		
		int[] oneTail={x-10, x-10, x-30, x-30};
		int[] oneTail2={y+20, y+55, y+10, y-5};
		
		Graphics2D g2d = (Graphics2D) g;
	    GradientPaint gp1 = new GradientPaint(5, 5, shiny1, 20, 20, shiny2, true);
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
	
	public void drawBubble (Graphics g, int x, int y)
	{
		g.setColor(Color.black);
		g.drawOval(x+120, y-20, 30, 30);
		g.setColor(Color.cyan);
		g.fillOval(x+120, y-20, 30, 30);
		g.setColor(Color.blue);
		g.fillOval(x+140, y-10, 5, 10);
		g.drawArc(x+124, y-18, 25, 25, 180, 90);
	}
	public void drawSubmarine (Graphics g, int x, int y)
	{
		//periscope
		g.setColor(Color.orange);
		g.fillRect(x+100,y-25,50,100);
		g.setColor(Color.darkGray);
		g.fillRect(x+105,y-65,25,40);
		g.setColor(Color.lightGray);
		g.fillRect(x+95,y-63,10,10);
		
		if(blinkCount%10==0) 
			g.setColor(Color.yellow);
		else
			g.setColor(Color.red);
		g.fillArc(x+105, y-78, 25, 25, 180, -180);
		
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
		g.setColor(Color.black);
		g.drawArc(x, y+70, 100, 130,90,90);
		
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
	}
	
	public Scuba createScuba(String filename)
	{
		return new Scuba(filename);
	}
	
	public void drawTurtle(Graphics g, int x, int y)
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
	   g.setColor(Color.black);
	   g.drawOval(x-20,y-10,25,25);
	   g.drawOval(x-32,y+10,50,75);
	   g.setColor(Color.green);
	   g.fillOval(x-20,y-10,25,25);
	   g.fillOval(x-32,y+10,50,75);
		g.setColor(Color.black);
	   
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
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		//shark/ fish
		x+=1;
		if(x>2000)
			x=0;
		//if (x <-500)
		//	x=1200;
		
		//crab	
		if (crabX <-500)
			crabX=1200;
			
		if(track<=100 && track>0)
		{
			track++;
			crabX++;
		}
		else if (track>100 && track<200)
		{	
			track++;
			crabX--;			
		}
		else if (track==200)
		{
			track=1;
			crabX++;
		}	
			
		//sub
		subX-=1;
		if (subX <-550)
			subX=2000;
			
		blinkCount++;
		
		//scubadiver
		/*if(scubaX<0)
		{
			scubaX=1200;
			scubaTrack=1;
			scubaY=550;
		} */
		scubaTrack++;
		scubaX--;
		if(scubaTrack<=100 && scubaTrack>0)
		{
			scubaY++;
		}
		else if (scubaTrack>100 && scubaTrack<200)
		{
			scubaY--;
		}
		else if(scubaTrack==200)
		{
			scubaTrack=1;
			scubaY++;
		}
		
		if(scubaX<0)
			scubaX=2000;
		
		//bubble
		
		bubbleX++; //???
		bubbleY--;	
		bubbleCount++;
		bubbletime++;
		
		if(bubbleCount<=bLimit && bubbleCount>0)
		{
			bubbleX--;
		}
		else if (bubbleCount>100 && bubbleCount<200)
		{	
			bubbleX++;			
		}
		else if (bubbleCount==200)
		{
			bubbleCount=1;
			bubbleX++;
			//bLimit+=50;
		}	
			
		//turtle
		turtleY--;
		if(turtleY<0)
			turtleY=1500;
		//scubaX--;
		//scubaY++;
	
		repaint();
	}
	
}

class Scuba
{
	private Image scuba;

	Scuba(String fileName)
	{
		try     // required to do read the image. ImageIO will throw an exception if the file is not there
		{
			scuba = ImageIO.read(new File(fileName));
		}
		catch(Exception e)	{}
	}

	public Image getImage()
	{
		return scuba;
	}

	public void setImage(String fileName)  // not reuired but good to have because you have getImage; image is private
	{
		try
		{
			scuba = ImageIO.read(new File(fileName));
		}
		catch(Exception e)	{}
	}

}