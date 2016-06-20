import java.awt.Color;
import java.awt.Container;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;

import javax.swing.*;
import java.awt.event.*;

public class getbc {

	public static JFrame frame;
	public static Container content;
	public static JLabel bc;
	public static JLabel bc2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getbc getbc = new getbc();
		
	}
	public getbc(){
		
		frame = new JFrame();
		frame.setSize(450,500);
		frame.setTitle("A Window");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		content=frame.getContentPane();
		gettbc();
		frame.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				PointerInfo a = MouseInfo.getPointerInfo();
				Point b = a.getLocation();
				int x = (int) b.getX();
				int y = (int) b.getY();
				Color initialBackground = frame.getBackground();
				bc.setText("pos: " + x + " " + y);
                System.out.println(initialBackground.toString());
			}
		});
		
		
		frame.setVisible(true);
	}
	public void gettbc(){
		bc = new JLabel();
		bc.setText("hi");
		bc.setBounds(100,100,100,100);
		bc2 = new JLabel();
		bc2.setText("hi");
		bc2.setBounds(200,100,100,100);
		content.add(bc);
	}
}
