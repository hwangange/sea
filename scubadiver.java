public class GFXFiles02 extends java.applet.Applet
{
	private Image picture1,picture2,picture3;

	public void init()
	{
		picture1 = getImage(getDocumentBase(),"Leon&Isolde.jpg");
		picture2 = getImage(getDocumentBase(),"pictures/Ship.jpg");
		picture3 = getImage(getDocumentBase(),"pictures/Snow.jpg");
	}

	public void paint(Graphics g)
	{
		g.drawImage(picture1,100,0,this);
		g.drawImage(picture2,500,100,this);
		g.drawImage(picture3,50,300,this);
	}
}
