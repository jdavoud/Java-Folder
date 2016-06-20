import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class tictactoe implements ActionListener{

	public JFrame frame, rframe;
	public Container content, rcontent;
	public JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, rb;
	public JPanel panel;
	public JPanel panel2;
	public JPanel panel3;
	public boolean Xturn = true, win = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tictactoe ttt = new tictactoe();
		
	}
	public tictactoe(){
		
		frame = new JFrame();
		frame.setSize(200,133);
		frame.setTitle("A Window");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content=frame.getContentPane();
		buttons();
		
		
		frame.setVisible(true);
	}
	
	public void buttons(){
		
		panel = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
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
		b1.setText("   ");
		b2.setText("   ");
		b3.setText("   ");
		b4.setText("   ");
		b5.setText("   ");
		b6.setText("   ");
		b7.setText("   ");
		b8.setText("   ");
		b9.setText("   ");
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel2.add(b4);
		panel2.add(b5);
		panel2.add(b6);
		panel3.add(b7);
		panel3.add(b8);
		panel3.add(b9);
		panel.setLocation(100,100);
		panel2.setLocation(100,200);
		panel3.setLocation(100,300);
		content.add(panel, BorderLayout.NORTH);
		content.add(panel2, BorderLayout.CENTER);
		content.add(panel3, BorderLayout.SOUTH);
		
		
	}
	public void restart(){
		
		win = true;
		rframe = new JFrame();
		rframe.setSize(200,133);
		rframe.setTitle("Restart");
		rframe.setResizable(true);
		rframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		rcontent=rframe.getContentPane();
		rb = new JButton();
		rb.addActionListener(this);
		rb.setSize(50,50);
		rb.setText("Restart");
		rcontent.add(rb, BorderLayout.SOUTH);
		rframe.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (((JButton)event.getSource()).getText().equals("   ") && !win)
		{
			if(Xturn){
				((JButton)event.getSource()).setText("X");
			}
			else{
				((JButton)event.getSource()).setText("O");
			}
			Xturn = !Xturn;
			if (b1.getText().equals(b2.getText())&&b2.getText().equals(b3.getText())&& !(b2.getText().equals("   ")))
			{
				restart();
				if(Xturn == true){
					rcontent.add(new JLabel("O Wins"),BorderLayout.NORTH);
				}
				else{
					rcontent.add(new JLabel("X Wins"), BorderLayout.NORTH);
				}
				
			}
			if (b4.getText().equals(b5.getText())&&b5.getText().equals(b6.getText())&& !(b5.getText().equals("   ")))
			{
				restart();
				if(Xturn == true){
					rcontent.add(new JLabel("O Wins"),BorderLayout.NORTH);
				}
				else{
					rcontent.add(new JLabel("X Wins"), BorderLayout.NORTH);
				}
				
			}
			if (b7.getText().equals(b8.getText())&&b8.getText().equals(b9.getText()) && !(b8.getText().equals("   ")))
			{
				restart();
				if(Xturn == true){
					rcontent.add(new JLabel("O Wins"),BorderLayout.NORTH);
				}
				else{
					rcontent.add(new JLabel("X Wins"), BorderLayout.NORTH);
				}
				
			}
			if (b1.getText().equals(b4.getText())&&b4.getText().equals(b7.getText())&& !(b4.getText().equals("   ")))
			{
				restart();
				if(Xturn == true){
					rcontent.add(new JLabel("O Wins"),BorderLayout.NORTH);
				}
				else{
					rcontent.add(new JLabel("X Wins"), BorderLayout.NORTH);
				}
				
			}
			if (b2.getText().equals(b5.getText())&&b5.getText().equals(b8.getText()) && !(b5.getText().equals("   ")))
			{
				restart();
				if(Xturn == true){
					rcontent.add(new JLabel("O Wins"),BorderLayout.NORTH);
				}
				else{
					rcontent.add(new JLabel("X Wins"), BorderLayout.NORTH);
				}
				
			}
			if (b3.getText().equals(b6.getText())&&b6.getText().equals(b9.getText()) && !(b6.getText().equals("   ")))
			{
				restart();
				if(Xturn == true){
					rcontent.add(new JLabel("O Wins"),BorderLayout.NORTH);
				}
				else{
					rcontent.add(new JLabel("X Wins"), BorderLayout.NORTH);
				}
				
			}
			if (b1.getText().equals(b5.getText())&&b5.getText().equals(b9.getText()) && !(b5.getText().equals("   ")))
			{
				restart();
				if(Xturn == true){
					rcontent.add(new JLabel("O Wins"),BorderLayout.NORTH);
				}
				else{
					rcontent.add(new JLabel("X Wins"), BorderLayout.NORTH);
				}
				
			}
			if (b3.getText().equals(b5.getText())&&b5.getText().equals(b7.getText())&&!(b5.getText().equals("   ")))
			{
				restart();
				if(Xturn == true){
					rcontent.add(new JLabel("O Wins"));
				}
				else {
					rcontent.add(new JLabel("X Wins"));
				}
				
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
				restart();
				rcontent.add(new JLabel("It's a tie!"));
			}
		}
		
		if(((JButton)event.getSource()).getText().equals("Restart")){
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
			rframe.dispose();
			win = false;
		}
	}
}
