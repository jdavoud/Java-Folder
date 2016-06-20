import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Timer;

import javax.swing.JComponent;



public class drawingComponent extends JComponent{
	public static Timer t;
	public void paint(Graphics g){
		t = new Timer(5, this);
		Integer x = 140;
		Graphics2D g2 = (Graphics2D) g;
		Rectangle rect = new Rectangle(5,x,50,100);
		g2.draw(rect);
		
		x += 20;
		t.start();
		repaint();
	}
}
