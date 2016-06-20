import java.*;
import java.awt.*;
import java.awt.geom.Line2D;

import javax.*;
import javax.swing.*;


public class drawings extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		g.setColor(Color.black);
		g.fillRect(25, 25, 100, 100);
	}
}
