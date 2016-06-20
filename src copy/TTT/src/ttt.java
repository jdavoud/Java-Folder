import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class ttt implements ActionListener{
	public static JMenuBar menubar;
	public static JFrame frame;
	public static Container content;
	public static JButton b1;
	public static JButton b2;
	public static JButton b3;
	public static JButton b4;
	public static JButton b5;
	public static JButton b6;
	public static JButton b7;
	public static JButton b8;
	public static JButton b9;
	public static JButton rb;
	public static boolean Xturn = true;
	public boolean win = false;
	public JLabel Wtext;
	public static JMenu me3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ttt ttt = new ttt();
		
	}
	public ttt(){
		
		frame = new JFrame();
		frame.setSize(450,500);
		frame.setTitle("A Window");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		content=frame.getContentPane();
		
		buttons();
		buildMenu();
		
		frame.setVisible(true);
	}
	
	public void buttons(){
		rb = new JButton();
		rb.setSize(100,50);
		rb.setLocation(175,400);
		rb.addActionListener(this);
		rb.setText("Restart");
		b1 = new JButton();
		b1.setSize(50,50);
		b1.setLocation(100, 100);
		b1.addActionListener(this);
		b2 = new JButton();
		b2.setSize(50,50);
		b2.setLocation(200, 100);
		b2.addActionListener(this);
		b3 = new JButton();
		b3.setSize(50,50);
		b3.setLocation(300, 100);
		b3.addActionListener(this);
		b4 = new JButton();
		b4.setSize(50,50);
		b4.setLocation(100, 200);
		b4.addActionListener(this);
		b5 = new JButton();
		b5.setSize(50,50);
		b5.setLocation(200, 200);
		b5.addActionListener(this);
		b6 = new JButton();
		b6.setSize(50,50);
		b6.setLocation(300, 200);
		b6.addActionListener(this);
		b7 = new JButton();
		b7.setSize(50,50);
		b7.setLocation(100, 300);
		b7.addActionListener(this);
		b8 = new JButton();
		b8.setSize(50,50);
		b8.setLocation(200, 300);
		b8.addActionListener(this);
		b9 = new JButton();
		b9.setSize(50,50);
		b9.setLocation(300, 300);
		b9.addActionListener(this);
		Wtext = new JLabel();
		Wtext.setText(" ");
		Wtext.setBounds(200,350,100,50);
		b1.setText("   ");
		b2.setText("   ");
		b3.setText("   ");
		b4.setText("   ");
		b5.setText("   ");
		b6.setText("   ");
		b7.setText("   ");
		b8.setText("   ");
		b9.setText("   ");
		content.add(b1);
		content.add(b2);
		content.add(b3);
		content.add(b4);
		content.add(b5);
		content.add(b6);
		content.add(b7);
		content.add(b8);
		content.add(b9);
		rb.setVisible(false);
		Wtext.setVisible(false);
		content.add(rb);
		content.add(Wtext);
	}	
	
	
	public void checkwin(){
		
		if (b1.getText().equals(b2.getText())&&b2.getText().equals(b3.getText())&& !(b2.getText().equals("   ")))
		{
			 
			if(Xturn == true){
				Wtext.setText("O Wins");
			}
			else{
				Wtext.setText("X Wins");
			}
			win = true;
			restart();
			
		}
		if (b4.getText().equals(b5.getText())&&b5.getText().equals(b6.getText())&& !(b5.getText().equals("   ")))
		{
			 
			if(Xturn == true){
				Wtext.setText("O Wins");
			}
			else{
				Wtext.setText("X Wins");
			} 
			win = true;
			restart();
			
		}
		if (b7.getText().equals(b8.getText())&&b8.getText().equals(b9.getText()) && !(b8.getText().equals("   ")))
		{
			 
			if(Xturn == true){
				Wtext.setText("O Wins");
			}
			else{
				Wtext.setText("X Wins");
			}
			win = true;
			restart();
			
		}
		if (b1.getText().equals(b4.getText())&&b4.getText().equals(b7.getText())&& !(b4.getText().equals("   ")))
		{
			 
			if(Xturn == true){
				
				Wtext.setText("O Wins");
			}
			else{
				Wtext.setText("X Wins");
			} 
			win = true;
			restart();
			
		}
		if (b2.getText().equals(b5.getText())&&b5.getText().equals(b8.getText()) && !(b5.getText().equals("   ")))
		{
			 
			if(Xturn == true){
				Wtext.setText("O Wins");
			}
			else{
				Wtext.setText("X Wins");
			} 
			win = true;
			restart();
			
		}
		if (b3.getText().equals(b6.getText())&&b6.getText().equals(b9.getText()) && !(b6.getText().equals("   ")))
		{
			 
			if(Xturn == true){
				Wtext.setText("O Wins");
			}
			else{
				Wtext.setText("X Wins");
			} 
			win = true;
			restart();
			
		}
		if (b1.getText().equals(b5.getText())&&b5.getText().equals(b9.getText()) && !(b5.getText().equals("   ")))
		{
			 
			if(Xturn == true){
				Wtext.setText("O Wins");
			}
			else{
				Wtext.setText("X Wins");
			} 
			win = true;
			restart();
			
		}
		if (b3.getText().equals(b5.getText())&&b5.getText().equals(b7.getText())&&!(b5.getText().equals("   ")))
		{
			 
			if(Xturn == true){
				Wtext.setText("O Wins");
			}
			else {
				Wtext.setText("X Wins");
			}  
			win = true;
			restart();
			
		}
		if(!(b3.getText().equals(b5.getText())&&b5.getText().equals(b7.getText()))
				&&!(b1.getText().equals(b5.getText())&&b5.getText().equals(b9.getText()))
				&&!(b3.getText().equals(b6.getText())&&b6.getText().equals(b9.getText()))
				&&!(b2.getText().equals(b5.getText())&&b5.getText().equals(b8.getText()))
				&&!(b1.getText().equals(b4.getText())&&b4.getText().equals(b7.getText()))
				&&!(b7.getText().equals(b8.getText())&&b8.getText().equals(b9.getText()))
				&&!(b4.getText().equals(b5.getText())&&b5.getText().equals(b6.getText()))
				&&!(b1.getText().equals(b2.getText())&&b2.getText().equals(b3.getText()))
				&&!(b1.getText().equals("   "))&&!(b2.getText().equals("   "))&&!(b3.getText().equals("   "))
				&&!(b4.getText().equals("   "))&&!(b5.getText().equals("   "))&&!(b6.getText().equals("   "))
				&&!(b7.getText().equals("   "))&&!(b8.getText().equals("   "))&&!(b9.getText().equals("   "))
				){
			Wtext.setText("It's a tie");
			win = true;
			restart();
		}
	}
	
	public void restart(){
		if(Wtext.getText().equals("X Wins")||Wtext.getText().equals("O Wins")){
			Wtext.setBounds(205,350,50,50);
		}
		else{
			Wtext.setBounds(200,350,50,50);
		}
		if(win){
		Wtext.setVisible(true);
		rb.setVisible(true);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if (((JButton)event.getSource()).getText().equals("   ") && !win)
		{
			if(Xturn){
				((JButton)event.getSource()).setText("X");
			}
			else{
				((JButton)event.getSource()).setText("O");
			}
			Xturn = !Xturn;
		}	
		
		if(((JButton)event.getSource()).getText().equals("Restart") && win){
			
			b1.setText("   ");
			b2.setText("   ");
			b3.setText("   ");
			b4.setText("   ");
			b5.setText("   ");
			b6.setText("   ");
			b7.setText("   ");
			b8.setText("   ");
			b9.setText("   ");
			Xturn = true;
			win = false;
			rb.setVisible(false);
			Wtext.setVisible(false);
			
		}
		checkwin();
		me3();
	}
	public static void buildMenu() {
		
		JMenuItem mi6;
        JMenuItem mi5;
		JMenuItem mi;
		JMenuItem mi4;
		JMenuItem mi2;
		JMenuItem mi3;
		JMenuItem mi7;
		JMenu me;
		JMenu exit;
		JMenuItem e;
		e = new JMenuItem("Exit");
		exit = new JMenu("Exit");
		me = new JMenu("Background Colors");
		menubar = new JMenuBar();
		mi = new JMenuItem("White");
		mi4 = new JMenuItem("Blue");
		mi2 = new JMenuItem("Green");
		me3 = new JMenu("Goes First"); 
		mi3 = new JMenuItem("Red");
		mi5 = new JMenuItem("X");
		mi6 = new JMenuItem("O");
		mi7 = new JMenuItem("Default");
		menubar.setForeground(new Color(0,255,0));
		menubar.setBackground(new Color(255,0,0));
		content.add(menubar);
		me.add(mi);
		menubar.add(me);
		me.add(mi4);
		me.add(mi2);
		me.add(mi3);
		me.add(mi7);
		menubar.add(exit);
		exit.add(e);
		
		me3.add(mi5);
		me3.add(mi6);
		menubar.add(me3);
		frame.setJMenuBar(menubar);
		
		
			mi5.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					Xturn = true;
				}
			});
			mi6.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					Xturn = false;
				}
			});
			mi.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					content.setBackground(new Color(255,255,255));
				}
			});
			mi4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					content.setBackground(new Color(0,0,255));
				}
			});
			mi2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					content.setBackground(new Color(0,255,0));
				}
			});
			mi3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					content.setBackground(new Color(255,0,0));
				}
			});
			mi7.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					content.setBackground(new Color(238,238,238));
				}
			});
			e.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
	}
	public void me3(){
		if(b1.getText().equals("   ")&&b2.getText().equals("   ")&&b3.getText().equals("   ")
			&&b4.getText().equals("   ")&&b5.getText().equals("   ")&&b6.getText().equals("   ")
			&&b7.getText().equals("   ")&&b8.getText().equals("   ")&&b9.getText().equals("   ")){
			me3.setVisible(true);
		}
		else{
			me3.setVisible(false);
		}
	}
}
