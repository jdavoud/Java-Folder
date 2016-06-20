import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class CheckersThis implements ActionListener{
	public static JFrame frame;
	public static Container content;
	public static JButton restart, r1n1, r1n2, r1n3, r1n4, r2n1, r2n2, r2n3, r2n4, r3n1, r3n2, r3n3, r3n4, r4n1, r4n2, r4n3, r4n4, r5n1, r5n2, r5n3, r5n4, r6n1, r6n2, r6n3, r6n4, r7n1, r7n2, r7n3, r7n4, r8n1, r8n2, r8n3, r8n4;
	public static boolean whiteTurn = true, firstButton = true;
	public static JLabel winLabel;
	public static String b1 = " ",op = " ", winner = " ";  
	public static Integer whiteGone = 0, blackGone = 0, secondButton = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckersThis ttt = new CheckersThis();
		
	}
	public CheckersThis(){
		
		frame = new JFrame();
		frame.setSize(400,480);
		frame.setTitle("A Window");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		content=frame.getContentPane();
		JMenuBar menubar;
		menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		JMenu menu;
		menu = new JMenu("Switch turn");
		JMenuItem menuItem;
		menuItem  = new JMenuItem("Switch Turn");
		menuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				whiteTurn = !whiteTurn;
			}
		});
		menu.add(menuItem);
		menubar.add(menu);
		buttons();
		frame.setVisible(true);
	}
	
	public void buttons(){
		winLabel = new JLabel();
		winLabel.setText(winner);
		winLabel.setBounds(180,480,50,50);
		restart = new JButton();
		restart.setBounds(125,520,150,50);
		restart.setText("Restart");
		restart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				r1n1.setText("o");
				r1n2.setText("o");
				r1n3.setText("o");
				r1n4.setText("o");
				r2n1.setText("o");
				r2n2.setText("o");
				r2n3.setText("o");
				r2n4.setText("o");
				r3n1.setText("o");
				r3n2.setText("o");
				r3n3.setText("o");
				r3n4.setText("o");
				r6n1.setText("е");
				r6n2.setText("е");
				r6n3.setText("е");
				r6n4.setText("е");
				r7n1.setText("е");
				r7n2.setText("е");
				r7n3.setText("е");
				r7n4.setText("е");
				r8n1.setText("е");
				r8n2.setText("е");
				r8n3.setText("е");
				r8n4.setText("е");
				r5n1.setText(" ");
				r5n2.setText(" ");
				r5n3.setText(" ");
				r5n4.setText(" ");
				r4n1.setText(" ");
				r4n2.setText(" ");
				r4n3.setText(" ");
				r4n4.setText(" ");
				frame.setSize(400,480);
			}
		});
		content.add(winLabel);
		content.add(restart);
		r1n1 = new JButton();
		r1n1.setBounds(50,0,50,50);
		r1n1.addActionListener(this);
		content.add(r1n1);
		r1n2 = new JButton();
		r1n2.setBounds(150,0,50,50);
		r1n2.addActionListener(this);
		content.add(r1n2);
		r1n3 = new JButton();
		r1n3.setBounds(250,0,50,50);
		r1n3.addActionListener(this);
		content.add(r1n3);
		r1n4 = new JButton();
		r1n4.setBounds(350,0,50,50);
		r1n4.addActionListener(this);
		content.add(r1n4);
		r2n1 = new JButton();
		r2n1.setBounds(0,50,50,50);
		r2n1.addActionListener(this);
		content.add(r2n1);
		r2n2 = new JButton();
		r2n2.setBounds(100,50,50,50);
		r2n2.addActionListener(this);
		content.add(r2n2);
		r2n3 = new JButton();
		r2n3.setBounds(200,50,50,50);
		r2n3.addActionListener(this);
		content.add(r2n3);
		r2n4 = new JButton();
		r2n4.setBounds(300,50,50,50);
		r2n4.addActionListener(this);
		content.add(r2n4);
		r3n1 = new JButton();
		r3n1.setBounds(50,100,50,50);
		r3n1.addActionListener(this);
		content.add(r3n1);
		r3n2 = new JButton();
		r3n2.setBounds(150,100,50,50);
		r3n2.addActionListener(this);
		content.add(r3n2);
		r3n3 = new JButton();
		r3n3.setBounds(250,100,50,50);
		r3n3.addActionListener(this);
		content.add(r3n3);
		r3n4 = new JButton();
		r3n4.setBounds(350,100,50,50);
		r3n4.addActionListener(this);
		content.add(r3n4);
		r4n1 = new JButton();
		r4n1.setBounds(0,150,50,50);
		r4n1.addActionListener(this);
		content.add(r4n1);
		r4n2 = new JButton();
		r4n2.setBounds(100,150,50,50);
		r4n2.addActionListener(this);
		content.add(r4n2);
		r4n3 = new JButton();
		r4n3.setBounds(200,150,50,50);
		r4n3.addActionListener(this);
		content.add(r4n3);
		r4n4 = new JButton();
		r4n4.setBounds(300,150,50,50);
		r4n4.addActionListener(this);
		content.add(r4n4);
		r5n1 = new JButton();
		r5n1.setBounds(50,200,50,50);
		r5n1.addActionListener(this);
		content.add(r5n1);
		r5n2 = new JButton();
		r5n2.setBounds(150,200,50,50);
		r5n2.addActionListener(this);
		content.add(r5n2);
		r5n3 = new JButton();
		r5n3.setBounds(250,200,50,50);
		r5n3.addActionListener(this);
		content.add(r5n3);
		r5n4 = new JButton();
		r5n4.setBounds(350,200,50,50);
		r5n4.addActionListener(this);
		content.add(r5n4);
		r6n1 = new JButton();
		r6n1.setBounds(0,250,50,50);
		r6n1.addActionListener(this);
		content.add(r6n1);
		r6n2 = new JButton();
		r6n2.setBounds(100,250,50,50);
		r6n2.addActionListener(this);
		content.add(r6n2);
		r6n3 = new JButton();
		r6n3.setBounds(200,250,50,50);
		r6n3.addActionListener(this);
		content.add(r6n3);
		r6n4 = new JButton();
		r6n4.setBounds(300,250,50,50);
		r6n4.addActionListener(this);
		content.add(r6n4);
		r7n1 = new JButton();
		r7n1.setBounds(50,300,50,50);
		r7n1.addActionListener(this);
		content.add(r7n1);
		r7n2 = new JButton();
		r7n2.setBounds(150,300,50,50);
		r7n2.addActionListener(this);
		content.add(r7n2);
		r7n3 = new JButton();
		r7n3.setBounds(250,300,50,50);
		r7n3.addActionListener(this);
		content.add(r7n3);
		r7n4 = new JButton();
		r7n4.setBounds(350,300,50,50);
		r7n4.addActionListener(this);
		content.add(r7n4);
		r8n1 = new JButton();
		r8n1.setBounds(0,350,50,50);
		r8n1.addActionListener(this);
		content.add(r8n1);
		r8n2 = new JButton();
		r8n2.setBounds(100,350,50,50);
		r8n2.addActionListener(this);
		content.add(r8n2);
		r8n3 = new JButton();
		r8n3.setBounds(200,350,50,50);
		r8n3.addActionListener(this);
		content.add(r8n3);
		r8n4 = new JButton();
		r8n4.setBounds(300,350,50,50);
		r8n4.addActionListener(this);
		content.add(r8n4);
		r1n1.setText("o");
		r1n2.setText("o");
		r1n3.setText("o");
		r1n4.setText("o");
		r2n1.setText("o");
		r2n2.setText("o");
		r2n3.setText("o");
		r2n4.setText("o");
		r3n1.setText("o");
		r3n2.setText("o");
		r3n3.setText("o");
		r3n4.setText("o");
		r6n1.setText("е");
		r6n2.setText("е");
		r6n3.setText("е");
		r6n4.setText("е");
		r7n1.setText("е");
		r7n2.setText("е");
		r7n3.setText("е");
		r7n4.setText("е");
		r8n1.setText("е");
		r8n2.setText("е");
		r8n3.setText("е");
		r8n4.setText("е");
		r5n1.setText(" ");
		r5n2.setText(" ");
		r5n3.setText(" ");
		r5n4.setText(" ");
		r4n1.setText(" ");
		r4n2.setText(" ");
		r4n3.setText(" ");
		r4n4.setText(" ");
		r1n1.setName("r1n1");
		r1n2.setName("r1n2");
		r1n3.setName("r1n3");
		r1n4.setName("r1n4");
		r2n1.setName("r2n1");
		r2n2.setName("r2n2");
		r2n3.setName("r2n3");
		r2n4.setName("r2n4");
		r3n1.setName("r3n1");
		r3n2.setName("r3n2");
		r3n3.setName("r3n3");
		r3n4.setName("r3n4");
		r4n1.setName("r4n1");
		r4n2.setName("r4n2");
		r4n3.setName("r4n3");
		r4n4.setName("r4n4");
		r5n1.setName("r5n1");
		r5n2.setName("r5n2");
		r5n3.setName("r5n3");
		r5n4.setName("r5n4");
		r6n1.setName("r6n1");
		r6n2.setName("r6n2");
		r6n3.setName("r6n3");
		r6n4.setName("r6n4");
		r7n1.setName("r7n1");
		r7n2.setName("r7n2");
		r7n3.setName("r7n3");
		r7n4.setName("r7n4");
		r8n1.setName("r8n1");
		r8n2.setName("r8n2");
		r8n3.setName("r8n3");
		r8n4.setName("r8n4");
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if (!((JButton)event.getSource()).getText().equals(" ")&& secondButton != 3){
			if(whiteTurn && (((JButton)event.getSource()).getText().equals("o")||((JButton)event.getSource()).getText().equals("oo"))){
				b1 = ((JButton)event.getSource()).getName();
				op = ((JButton)event.getSource()).getText();
				firstButton = false;	
				secondButton = 2;
			}
			if(!whiteTurn && (((JButton)event.getSource()).getText().equals("е")||((JButton)event.getSource()).getText().equals("ее"))){
				b1 = ((JButton)event.getSource()).getName();
				op = ((JButton)event.getSource()).getText();
				firstButton = false;	
				secondButton = 2;
			}
		}
		else if(((JButton)event.getSource()).getText().equals(" ") && secondButton == 2){
			if(b1 == "r1n1"){
				if(((JButton)event.getSource()).getText().equals(" ")&&((JButton)event.getSource()).getName().equals("r2n1")||((JButton)event.getSource()).getName().equals("r2n2")){
					
					((JButton)event.getSource()).setText(op);
					 
					secondButton = 1;
					whiteTurn = !whiteTurn;
					firstButton = true;
					r1n1.setText(" ");
				}
				if(((JButton)event.getSource()).getName().equals("r3n2")&&!r2n2.getText().equals(" ")&&!r2n2.getText().equals(op)&&!r2n2.getText().startsWith(op.substring(0, 1))){
					if(whiteTurn){
						if(r2n2.getText().equals("е")){
							blackGone += 1;
						}
						if(r2n2.getText().equals("ее")){
							blackGone += 2;
						}
					}
					else { 
						if(r2n2.getText().equals("o")){
							whiteGone += 1;
						}
						if(r2n2.getText().equals("oo")){
							whiteGone += 2;
						}
					}
					r2n2.setText(" ");
					r3n2.setText(op);
					 
					secondButton = 1;
					r1n1.setText(" ");
					whiteTurn = !whiteTurn;
					firstButton = true;
				}
			}
			if(b1 == "r1n2"){
				if(((JButton)event.getSource()).getText().equals(" ")&&((JButton)event.getSource()).getName().equals("r2n2")||((JButton)event.getSource()).getName().equals("r2n3")){
					((JButton)event.getSource()).setText(op);
					 
					secondButton = 1;
					whiteTurn = !whiteTurn;
					firstButton = true;
					r1n2.setText(" ");
				}
				if(((JButton)event.getSource()).getName().equals("r3n3")&&!r2n3.getText().equals(" ")&&!r2n3.getText().equals(op)&&!r2n3.getText().startsWith(op.substring(0, 1))){
					if(whiteTurn){
						if(r2n3.getText().equals("е")){
							blackGone += 1;
						}
						if(r2n3.getText().equals("ее")){
							blackGone += 2;
						}
					}
					else { 
						if(r2n3.getText().equals("o")){
							whiteGone += 1;
						}
						if(r2n3.getText().equals("oo")){
							whiteGone += 2;
						}
					}
					r2n3.setText(" ");
					r3n3.setText(op);
					 
					secondButton = 1;
					r1n2.setText(" ");
					whiteTurn = !whiteTurn;
					firstButton = true;
				}
				if(((JButton)event.getSource()).getName().equals("r3n1")&&!r2n2.getText().equals(" ")&&!r2n2.getText().equals(op)&&!r2n2.getText().startsWith(op.substring(0, 1))){
					if(whiteTurn){
						if(r2n2.getText().equals("е")){
							blackGone += 1;
						}
						if(r2n2.getText().equals("ее")){
							blackGone += 2;
						}
					}
					else { 
						if(r2n2.getText().equals("o")){
							whiteGone += 1;
						}
						if(r2n2.getText().equals("oo")){
							whiteGone += 2;
						}
					}
					r2n2.setText(" ");
					r3n1.setText(op);
					 
							secondButton = 1;
					r1n2.setText(" ");
					whiteTurn = !whiteTurn;
					firstButton = true;
				}
			}
			if(b1 == "r1n3"){
				if(((JButton)event.getSource()).getText().equals(" ")&&((JButton)event.getSource()).getName().equals("r2n3")||((JButton)event.getSource()).getName().equals("r2n4")){
					((JButton)event.getSource()).setText(op);
					 
							secondButton = 1;
					whiteTurn = !whiteTurn;
					firstButton = true;
					r1n3.setText(" ");
				}
				if(((JButton)event.getSource()).getName().equals("r3n2")&&!r2n3.getText().equals(" ")&&!r2n3.getText().equals(op)&&!r2n3.getText().startsWith(op.substring(0, 1))){
					if(whiteTurn){
						if(r2n3.getText().equals("е")){
							blackGone += 1;
						}
						if(r2n3.getText().equals("ее")){
							blackGone += 2;
						}
					}
					else { 
						if(r2n3.getText().equals("o")){
							whiteGone += 1;
						}
						if(r2n3.getText().equals("oo")){
							whiteGone += 2;
						}
					}
					r2n3.setText(" ");
					r3n2.setText(op);
					 
							secondButton = 1;
					r1n3.setText(" ");
					whiteTurn = !whiteTurn;
					firstButton = true;
				}
				if(((JButton)event.getSource()).getName().equals("r3n4")&&!r2n4.getText().equals(" ")&&!r2n4.getText().equals(op)&&!r2n4.getText().startsWith(op.substring(0, 1))){
					if(whiteTurn){
						if(r2n4.getText().equals("е")){
							blackGone += 1;
						}
						if(r2n4.getText().equals("ее")){
							blackGone += 2;
						}
					}
					else { 
						if(r2n4.getText().equals("o")){
							whiteGone += 1;
						}
						if(r2n4.getText().equals("oo")){
							whiteGone += 2;
						}
					}
					r2n4.setText(" ");
					r3n4.setText(op);
					 
							secondButton = 1;
					r1n3.setText(" ");
					
					whiteTurn = !whiteTurn;
					firstButton = true;
				}
			}
			if(b1 == "r1n4"){
				if(((JButton)event.getSource()).getText().equals(" ")&&((JButton)event.getSource()).getName().equals("r2n4")){
					((JButton)event.getSource()).setText(op);
					secondButton = 1;
					whiteTurn = !whiteTurn;
					firstButton = true;
					r1n4.setText(" ");
				}
				if(((JButton)event.getSource()).getName().equals("r3n3")&&!r2n4.getText().equals(" ")&&!r2n4.getText().equals(op)&&!r2n4.getText().startsWith(op.substring(0, 1))){
					if(whiteTurn){
						if(r2n4.getText().equals("е")){
							blackGone += 1;
						}
						if(r2n4.getText().equals("ее")){
							blackGone += 2;
						}
					}
					else { 
						if(r2n4.getText().equals("o")){
							whiteGone += 1;
						}
						if(r2n4.getText().equals("oo")){
							whiteGone += 2;
						}
					}
					r2n4.setText(" ");
					r3n3.setText(op); 
					secondButton = 1;
					r1n4.setText(" ");
					whiteTurn = !whiteTurn;
					firstButton = true;
				}
			}
			if(b1 == "r8n1"){
				
				if(((JButton)event.getSource()).getText().equals(" ")&&((JButton)event.getSource()).getName().equals("r7n1")){
					((JButton)event.getSource()).setText(op);
					 
					secondButton = 1;
					whiteTurn = !whiteTurn;
					firstButton = true;
					r8n1.setText(" ");
				}
				if(((JButton)event.getSource()).getName().equals("r6n2")&&!r7n1.getText().equals(" ")&&!r7n1.getText().equals(op)&&!r7n1.getText().startsWith(op.substring(0, 1))){
					if(whiteTurn){
						if(r7n1.getText().equals("е")){
							blackGone += 1;
						}
						if(r7n1.getText().equals("ее")){
							blackGone += 2;
						}
					}
					else { 
						if(r7n1.getText().equals("o")){
							whiteGone += 1;
						}
						if(r7n1.getText().equals("oo")){
							whiteGone += 2;
						}
					}
					r7n1.setText(" ");
					r6n2.setText(op);
					 
							secondButton = 1;
					r8n1.setText(" ");
					whiteTurn = !whiteTurn;
					firstButton = true;
				}
			}
			if(b1 == "r8n2"){
				if(((JButton)event.getSource()).getText().equals(" ")&&((JButton)event.getSource()).getName().equals("r7n1")||((JButton)event.getSource()).getName().equals("r7n2")){
					((JButton)event.getSource()).setText(op);
					 
					secondButton = 1;
					whiteTurn = !whiteTurn;
					firstButton = true;
					r8n2.setText(" ");
				}
				if(((JButton)event.getSource()).getName().equals("r6n1")&&!r7n1.getText().equals(" ")&&!r7n1.getText().equals(op)&&!r7n1.getText().startsWith(op.substring(0, 1))){
					if(whiteTurn){
						if(r7n1.getText().equals("е")){
							blackGone += 1;
						}
						if(r7n1.getText().equals("ее")){
							blackGone += 2;
						}
					}
					else {
						if(r7n1.getText().equals("o")){
							whiteGone += 1;
						}
						if(r7n1.getText().equals("oo")){
							whiteGone += 2;
						}
					}
					r7n1.setText(" ");
					r6n1.setText(op);
					 
					secondButton = 1;
					r8n2.setText(" ");
					whiteTurn = !whiteTurn;
					firstButton = true;
				}
				if(((JButton)event.getSource()).getName().equals("r6n3")&&!r7n2.getText().equals(" ")&&!r7n2.getText().equals(op)&&!r7n2.getText().startsWith(op.substring(0, 1))){
					if(whiteTurn){
						if(r7n2.getText().equals("е")){
							blackGone += 1;
						}
						if(r7n2.getText().equals("ее")){
							blackGone += 2;
						}
					}
					else { 
						if(r7n2.getText().equals("o")){
							whiteGone += 1;
						}
						if(r7n2.getText().equals("oo")){
							whiteGone += 2;
						}
					}
					r7n2.setText(" ");
					r6n3.setText(op);
					 
					secondButton = 1;
					r8n2.setText(" ");
					whiteTurn = !whiteTurn;
					firstButton = true;
				}
			}
			if(b1 == "r8n3"){
				
				if(((JButton)event.getSource()).getText().equals(" ")&&(((JButton)event.getSource()).getName().equals("r7n3")||((JButton)event.getSource()).getName().equals("r7n2"))){
					((JButton)event.getSource()).setText(op);
					secondButton = 1;
					whiteTurn = !whiteTurn;
					r8n3.setText(" ");
				}
				if(((JButton)event.getSource()).getName().equals("r6n2")&&!r7n2.getText().equals(" ")&&!r7n2.getText().equals(op)&&!r7n2.getText().startsWith(op.substring(0, 1))){
					if(whiteTurn){
						if(r7n2.getText().equals("е")){
							blackGone += 1;
						}
						if(r7n2.getText().equals("ее")){
							blackGone += 2;
						}
					}
					else { 
						if(r7n2.getText().equals("o")){
							whiteGone += 1;
						}
						if(r7n2.getText().equals("oo")){
							whiteGone += 2;
						}
					}
					r7n2.setText(" ");
					r6n2.setText(op);
					 
					secondButton = 1;
					r8n3.setText(" ");
					
					whiteTurn = !whiteTurn;
					firstButton = true;
				}
				if(((JButton)event.getSource()).getName().equals("r6n4")&&!r7n3.getText().equals(" ")&&!r7n3.getText().equals(op)&&!r7n3.getText().startsWith(op.substring(0, 1))){
					if(whiteTurn){
						if(r7n3.getText().equals("е")){
							blackGone += 1;
						}
						if(r7n3.getText().equals("ее")){
							blackGone += 2;
						}
					}
					else { 
						if(r7n3.getText().equals("o")){
							whiteGone += 1;
						}
						if(r7n3.getText().equals("oo")){
							whiteGone += 2;
						}
					}
					r7n3.setText(" ");
					r6n4.setText(op);
					secondButton = 1;
					r8n3.setText(" ");
					whiteTurn = !whiteTurn;
					firstButton = true;
				}
			}
			if(b1 == "r8n4"){
				if(((JButton)event.getSource()).getText().equals(" ")&&(((JButton)event.getSource()).getName().equals("r7n3")||((JButton)event.getSource()).getName().equals("r7n4"))){
					((JButton)event.getSource()).setText(op);
					r8n4.setText(" "); 
					secondButton = 1;
					whiteTurn = !whiteTurn;
					firstButton = true;
				}
				if(((JButton)event.getSource()).getName().equals("r6n3")&&!r7n3.getText().equals(" ")&&!r7n3.getText().equals(op)&&!r7n3.getText().startsWith(op.substring(0, 1))){
					if(whiteTurn){
						if(r7n3.getText().equals("е")){
							blackGone += 1;
						}
						if(r7n3.getText().equals("ее")){
							blackGone += 2;
						}
					}
					else { 
						if(r7n3.getText().equals("o")){
							whiteGone += 1;
						}
						if(r7n3.getText().equals("oo")){
							whiteGone += 2;
						}
					}
					r7n3.setText(" ");
					r6n3.setText(op);
					secondButton = 1;
					r8n4.setText(" ");
					whiteTurn = !whiteTurn;
					firstButton = true;
				}
			}
			if(b1 == "r2n1"){
				
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r3n1")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r2n1.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r4n2")&&!r3n1.getText().equals(" ")&&!r3n1.getText().equals(op)&&!r3n1.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r3n1.getText().equals("е")){
									blackGone += 1;
								}
								if(r3n1.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r3n1.getText().equals("o")){
									whiteGone += 1;
								}
								if(r3n1.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							
							r3n1.setText(" ");
							r4n2.setText(op);
							r2n1.setText(" ");
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r1n1")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r2n1.setText(" ");
						}
					}
				}
			}
			if(b1 == "r2n2"){
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " " && op !="е"){
						if(((JButton)event.getSource()).getName().equals("r3n1") || ((JButton)event.getSource()).getName().equals("r3n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r2n2.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r4n1")&&!r3n1.getText().equals(" ")&&!r3n1.getText().equals(op)&&!r3n1.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r3n1.getText().equals("е")){
									blackGone += 1;
								}
								if(r3n1.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r3n1.getText().equals("o")){
									whiteGone += 1;
								}
								if(r3n1.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r3n1.setText(" ");
							r4n1.setText(op);
							 
							secondButton = 1;
							r2n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r4n3")&&!r3n2.getText().equals(" ")&&!r3n2.getText().equals(op)&&!r3n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r3n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r3n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r3n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r3n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r3n2.setText(" ");
							r4n3.setText(op);
							 
							secondButton = 1;
							r2n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r1n1") || ((JButton)event.getSource()).getName().equals("r1n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r2n2.setText(" ");
						}
						
					}
				}
			}
			if(b1 == "r2n3"){
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r3n3") || ((JButton)event.getSource()).getName().equals("r3n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r2n3.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r4n2")&&!r3n2.getText().equals(" ")&&!r3n2.getText().equals(op)&&!r3n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r3n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r3n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r3n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r3n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r3n2.setText(" ");
							r4n2.setText(op);
							 
							secondButton = 1;
							r2n3.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r4n4")&&!r3n3.getText().equals(" ")&&!r3n3.getText().equals(op)&&!r3n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r3n3.getText().equals("е")){
									blackGone += 1;
								}
								if(r3n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r3n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r3n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r3n3.setText(" ");
							r4n4.setText(op);
							 
							secondButton = 1;
							r2n3.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r1n3") || ((JButton)event.getSource()).getName().equals("r1n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r2n3.setText(" ");
						}
						
					}
				}
			}
			if(b1 == "r2n4"){
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r3n4")||((JButton)event.getSource()).getName().equals("r3n3")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r2n4.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r4n3")&&!r3n3.getText().equals(" ")&&!r3n3.getText().equals(op)&&!r3n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r4n4.getText().equals("е")){
									blackGone += 1;
								}
								if(r4n4.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r4n4.getText().equals("o")){
									whiteGone += 1;
								}
								if(r4n4.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r3n3.setText(" ");
							r4n3.setText(op);
							 
							secondButton = 1;
							r2n4.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r1n4")||((JButton)event.getSource()).getName().equals("r1n3")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r2n4.setText(" ");
						}
					}
				}
			}
			if(b1 == "r3n1"){
				
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r4n1") || ((JButton)event.getSource()).getName().equals("r4n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r3n1.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r5n2")&&!r4n2.getText().equals(" ")&&!r4n2.getText().equals(op)&&!r4n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r4n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r4n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r4n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r4n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r4n2.setText(" ");
							r5n2.setText(op);
							 
							secondButton = 1;
							r3n1.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r2n1") || ((JButton)event.getSource()).getName().equals("r2n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r3n1.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r1n2")&&!r2n2.getText().equals(" ")&&!r2n2.getText().equals(op)&&!r2n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r2n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r2n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r2n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r2n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r2n2.setText(" ");
							r1n2.setText(op);
							 
							secondButton = 1;
							r3n1.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
				}
			}
			if(b1 == "r3n2"){
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r4n3") || ((JButton)event.getSource()).getName().equals("r4n2")){
							((JButton)event.getSource()).setText(op);
							whiteTurn = !whiteTurn;
							 
							secondButton = 1;
							firstButton = true;
							r3n2.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r5n1")&&!r4n2.getText().equals(" ")&&!r4n2.getText().equals(op)&&!r4n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r4n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r4n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r4n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r4n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r4n2.setText(" ");
							r5n1.setText(op);
							 
							secondButton = 1;
							r3n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r5n3")&&!r4n3.getText().equals(" ")&&!r4n3.getText().equals(op)&&!r4n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r4n3.getText().equals("е")){
									blackGone += 1;
								}
								if(r4n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r4n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r4n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r4n3.setText(" ");
							r5n3.setText(op);
							 
							secondButton = 1;
							r3n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r2n3") || ((JButton)event.getSource()).getName().equals("r2n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r3n2.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r1n1")&&!r2n2.getText().equals(" ")&&!r2n2.getText().equals(op)&&!r2n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r2n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r2n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r2n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r2n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r2n2.setText(" ");
							r1n1.setText(op);
							 
							secondButton = 1;
							r3n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r1n3")&&!r2n3.getText().equals(" ")&&!r2n3.getText().equals(op)&&!r2n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r2n3.getText().equals("е")){
									blackGone += 1;
								}
								if(r2n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r2n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r2n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r2n3.setText(" ");
							r1n3.setText(op);
							 
							secondButton = 1;
							r3n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
				}
			}
			if(b1 == "r3n3"){
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r4n3") || ((JButton)event.getSource()).getName().equals("r4n4")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r3n3.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r5n2")&&!r4n3.getText().equals(" ")&&!r4n3.getText().equals(op)&&!r4n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r4n3.getText().equals("е")){
									blackGone += 1;
								}
								if(r4n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r4n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r4n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r4n3.setText(" ");
							r5n2.setText(op);
							r3n3.setText(" ");
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r5n4")&&!r4n4.getText().equals(" ")&&!r4n4.getText().equals(op)&&!r4n4.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r4n4.getText().equals("е")){
									blackGone += 1;
								}
								if(r4n4.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r4n4.getText().equals("o")){
									whiteGone += 1;
								}
								if(r4n4.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r4n4.setText(" ");
							r5n4.setText(op);
							 
							secondButton = 1;
							r3n3.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r2n3") || ((JButton)event.getSource()).getName().equals("r2n4")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r3n3.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r1n2")&&!r2n3.getText().equals(" ")&&!r2n3.getText().equals(op)&&!r2n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r2n3.getText().equals("е")){
									blackGone += 1;
								}
								if(r2n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r2n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r2n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r2n3.setText(" ");
							r1n2.setText(op);
							 
							secondButton = 1;
							r3n3.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r1n4")&&!r2n4.getText().equals(" ")&&!r2n4.getText().equals(op)&&!r2n4.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r2n4.getText().equals("е")){
									blackGone += 1;
								}
								if(r2n4.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r2n4.getText().equals("o")){
									whiteGone += 1;
								}
								if(r2n4.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r2n4.setText(" ");
							r1n4.setText(op);
							 
							secondButton = 1;
							r3n3.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
				}
			}
			if(b1 == "r3n4"){
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r4n4")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r3n4.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r5n3")&&!r4n4.getText().equals(" ")&&!r4n4.getText().equals(op)&&!r4n4.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r4n4.getText().equals("е")){
									blackGone += 1;
								}
								if(r4n4.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r4n4.getText().equals("o")){
									whiteGone += 1;
								}
								if(r4n4.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r4n4.setText(" ");
							r5n3.setText(op);
							 
							secondButton = 1;
							r3n4.setText(" ");
							
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r2n4")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							secondButton = 1;
							
							whiteTurn = !whiteTurn;
							firstButton = true;
							r3n4.setText(" ");
						}
						
						if(((JButton)event.getSource()).getName().equals("r1n3")&&!r2n4.getText().equals(" ")&&!r2n4.getText().equals(op)&&!r2n4.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r2n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r2n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r2n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r2n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r2n4.setText(" ");
							r1n3.setText(op);
							 
							secondButton = 1;
							
							r3n4.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
				}
			}
			if(b1 == "r4n1"){
				
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r5n1")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r4n1.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r6n2")&&!r5n1.getText().equals(" ")&&!r5n1.getText().equals(op)&&!r5n1.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r5n1.getText().equals("е")){
									blackGone += 1;
								}
								if(r5n1.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r5n1.getText().equals("o")){
									whiteGone += 1;
								}
								if(r5n1.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r5n1.setText(" ");
							r6n2.setText(op);
							r4n1.setText(" ");
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r3n1")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r4n1.setText(" ");
						}
					}
					if(((JButton)event.getSource()).getName().equals("r2n2")&&!r3n1.getText().equals(" ")&&!r3n1.getText().equals(op)&&!r3n1.getText().startsWith(op.substring(0, 1))){
						if(whiteTurn){
							if(r3n1.getText().equals("е")){
								blackGone += 1;
							}
							if(r3n1.getText().equals("ее")){
								blackGone += 2;
							}
						}
						else { 
							if(r3n1.getText().equals("o")){
								whiteGone += 1;
							}
							if(r3n1.getText().equals("oo")){
								whiteGone += 2;
							}
						}
						r3n1.setText(" ");
						r2n2.setText(op);
						r4n1.setText(" ");
						 
						secondButton = 1;
						whiteTurn = !whiteTurn;
						firstButton = true;
					}
				}
			}
			if(b1 == "r4n2"){
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " " && op !="е"){
						if(((JButton)event.getSource()).getName().equals("r5n1") || ((JButton)event.getSource()).getName().equals("r5n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r4n2.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r6n1")&&!r5n1.getText().equals(" ")&&!r5n1.getText().equals(op)&&!r5n1.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r5n1.getText().equals("е")){
									blackGone += 1;
								}
								if(r5n1.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r5n1.getText().equals("o")){
									whiteGone += 1;
								}
								if(r5n1.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r5n1.setText(" ");
							r6n1.setText(op);
							 
							secondButton = 1;
							r4n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r6n3")&&!r5n2.getText().equals(" ")&&!r5n2.getText().equals(op)&&!r5n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r5n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r5n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r5n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r5n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r5n2.setText(" ");
							r6n3.setText(op);
							 
							secondButton = 1;
							r4n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r3n1") || ((JButton)event.getSource()).getName().equals("r3n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r4n2.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r2n3")&&!r3n2.getText().equals(" ")&&!r3n2.getText().equals(op)&&!r3n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r3n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r3n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r3n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r3n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r3n2.setText(" ");
							r2n3.setText(op);
							 
							secondButton = 1;
							r4n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r2n1")&&!r3n1.getText().equals(" ")&&!r3n1.getText().equals(op)&&!r3n1.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r3n1.getText().equals("е")){
									blackGone += 1;
								}
								if(r3n1.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r3n1.getText().equals("o")){
									whiteGone += 1;
								}
								if(r3n1.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r3n1.setText(" ");
							r2n1.setText(op);
							 
							secondButton = 1;
							r4n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
					
				}
			}
			if(b1 == "r4n3"){
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r5n3") || ((JButton)event.getSource()).getName().equals("r5n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r4n3.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r6n2")&&!r5n2.getText().equals(" ")&&!r5n2.getText().equals(op)&&!r5n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r5n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r5n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r5n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r5n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r5n2.setText(" ");
							r6n2.setText(op);
							 
							secondButton = 1;
							r4n3.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r6n4")&&!r5n3.getText().equals(" ")&&!r5n3.getText().equals(op)&&!r5n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r5n3.getText().equals("е")){
										blackGone += 1;
								}
								if(r5n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r5n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r5n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r5n3.setText(" ");
							r6n4.setText(op);
							 
							secondButton = 1;
							r4n3.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r3n3") || ((JButton)event.getSource()).getName().equals("r3n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r4n3.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r2n4")&&!r3n3.getText().equals(" ")&&!r3n3.getText().equals(op)&&!r3n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r3n3.getText().equals("е")){
									blackGone += 1;
								}
								if(r3n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r3n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r3n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r3n3.setText(" ");
							r2n4.setText(op);
							 
							secondButton = 1;
							r4n3.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r2n2")&&!r3n2.getText().equals(" ")&&!r3n2.getText().equals(op)&&!r3n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r3n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r3n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r3n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r3n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r3n2.setText(" ");
							r2n2.setText(op);
							 
							secondButton = 1;
							r4n3.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
				}
			}
			if(b1 == "r4n4"){
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r5n4")||((JButton)event.getSource()).getName().equals("r5n3")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r4n4.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r6n3")&&!r5n3.getText().equals(" ")&&!r5n3.getText().equals(op)&&!r5n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r5n3.getText().equals("е")){
									blackGone += 1;
								}
								if(r5n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r5n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r5n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r5n3.setText(" ");
							r6n3.setText(op);
							secondButton = 1;
							r4n4.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r3n3")||((JButton)event.getSource()).getName().equals("r3n4")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r4n4.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r2n3")&&!r3n3.getText().equals(" ")&&!r3n3.getText().equals(op)&&!r3n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r3n3.getText().equals("е")){
									blackGone += 1;
								}
								if(r3n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r3n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r3n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r3n3.setText(" ");
							r2n3.setText(op);
							 
							secondButton = 1;
							r4n4.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
				}
			}
			if(b1 == "r5n1"){
				
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r6n1") || ((JButton)event.getSource()).getName().equals("r6n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r5n1.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r7n2")&&!r6n2.getText().equals(" ")&&!r6n2.getText().equals(op)&&!r6n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r6n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r6n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r6n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r6n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r6n2.setText(" ");
							r7n2.setText(op);
							 
							secondButton = 1;
							r5n1.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r4n1") || ((JButton)event.getSource()).getName().equals("r4n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r5n1.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r3n2")&&!r4n2.getText().equals(" ")&&!r4n2.getText().equals(op)&&!r4n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r4n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r4n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r4n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r4n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r4n2.setText(" ");
							r3n2.setText(op);
							 
							secondButton = 1;
							r5n1.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
				}
			}
			if(b1 == "r5n2"){
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r6n3") || ((JButton)event.getSource()).getName().equals("r6n2")){
							((JButton)event.getSource()).setText(op);
							whiteTurn = !whiteTurn;
							 
							secondButton = 1;
							firstButton = true;
							r5n2.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r7n1")&&!r6n2.getText().equals(" ")&&!r6n2.getText().equals(op)&&!r6n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r6n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r6n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r6n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r6n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r6n2.setText(" ");
							r7n1.setText(op);
							 
							secondButton = 1;
							r5n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r7n3")&&!r6n3.getText().equals(" ")&&!r6n3.getText().equals(op)&&!r6n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r6n3.getText().equals("е")){
									blackGone += 1;
								}
								if(r6n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r6n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r6n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r6n3.setText(" ");
							r7n3.setText(op);
							 
							secondButton = 1;
							r5n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r4n3") || ((JButton)event.getSource()).getName().equals("r4n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r5n2.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r3n1")&&!r4n2.getText().equals(" ")&&!r4n2.getText().equals(op)&&!r4n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r4n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r4n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r4n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r4n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r4n2.setText(" ");
							r3n1.setText(op);
							 
							secondButton = 1;
							r5n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r3n3")&&!r4n3.getText().equals(" ")&&!r4n3.getText().equals(op)&&!r4n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r4n3.getText().equals("е")){
									blackGone += 1;
								}
								if(r4n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r4n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r4n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r4n3.setText(" ");
							r3n3.setText(op);
							 
							secondButton = 1;
							r5n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
				}
			}
			if(b1 == "r5n3"){
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r6n3") || ((JButton)event.getSource()).getName().equals("r6n4")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r5n3.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r7n2")&&!r6n3.getText().equals(" ")&&!r6n3.getText().equals(op)&&!r6n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r6n3.getText().equals("е")){
									blackGone += 1;
								}
								if(r6n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r6n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r6n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r6n3.setText(" ");
							r7n2.setText(op);
							r5n3.setText(" ");
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r7n4")&&!r6n4.getText().equals(" ")&&!r6n4.getText().equals(op)&&!r6n4.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r6n4.getText().equals("е")){
									blackGone += 1;
								}
								if(r6n4.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r6n4.getText().equals("o")){
									whiteGone += 1;
								}
								if(r6n4.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r6n4.setText(" ");
							r7n4.setText(op);
							 
							secondButton = 1;
							r5n3.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r4n3") || ((JButton)event.getSource()).getName().equals("r4n4")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r5n3.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r3n2")&&!r4n3.getText().equals(" ")&&!r4n3.getText().equals(op)&&!r4n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r4n3.getText().equals("е")){
									blackGone += 1;
								}
								if(r4n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r4n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r4n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r4n3.setText(" ");
							r3n2.setText(op);
							 
							secondButton = 1;
							r5n3.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r3n4")&&!r4n4.getText().equals(" ")&&!r4n4.getText().equals(op)&&!r4n4.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r4n4.getText().equals("е")){
									blackGone += 1;
								}
								if(r4n4.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r4n4.getText().equals("o")){
									whiteGone += 1;
								}
								if(r4n4.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r4n4.setText(" ");
							r3n4.setText(op);
							 
							secondButton = 1;
							r5n3.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
				}
			}
			if(b1 == "r5n4"){
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r6n4")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r5n4.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r7n3")&&!r6n4.getText().equals(" ")&&!r6n4.getText().equals(op)&&!r6n4.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r6n4.getText().equals("е")){
									blackGone += 1;
								}
								if(r6n4.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r6n4.getText().equals("o")){
									whiteGone += 1;
								}
								if(r6n4.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r6n4.setText(" ");
							r7n3.setText(op);
							 
							secondButton = 1;
							r5n4.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r4n4")){
							((JButton)event.getSource()).setText(op);
							if(whiteTurn){
								if(r4n4.getText().equals("е")){
									blackGone += 1;
								}
								if(r4n4.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r4n4.getText().equals("o")){
									whiteGone += 1;
								}
								if(r4n4.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							secondButton = 1;
							secondButton = 1;
							
							whiteTurn = !whiteTurn;
							firstButton = true;
							r5n4.setText(" ");
						}
						
						if(((JButton)event.getSource()).getName().equals("r3n3")&&!r4n4.getText().equals(" ")&&!r4n4.getText().equals(op)&&!r4n4.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r4n4.getText().equals("е")){
									blackGone += 1;
								}
								if(r4n4.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r4n4.getText().equals("o")){
									whiteGone += 1;
								}
								if(r4n4.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r4n4.setText(" ");
							r3n3.setText(op);
							
							secondButton = 1;
							
							r5n4.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
				}
			}
			if(b1 == "r6n1"){
				
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r7n1")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r6n1.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r8n2")&&!r7n1.getText().equals(" ")&&!r7n1.getText().equals(op)&&!r7n1.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r7n1.getText().equals("е")){
									blackGone += 1;
								}
								if(r7n1.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r7n1.getText().equals("o")){
									whiteGone += 1;
								}
								if(r7n1.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r7n1.setText(" ");
							r8n2.setText(op);
							r6n1.setText(" ");
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r5n1")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r6n1.setText(" ");
						}
					}
					if(((JButton)event.getSource()).getName().equals("r4n2")&&!r5n1.getText().equals(" ")&&!r5n1.getText().equals(op)&&!r5n1.getText().startsWith(op.substring(0, 1))){
						if(whiteTurn){
							if(r5n1.getText().equals("е")){
								blackGone += 1;
							}
							if(r5n1.getText().equals("ее")){
								blackGone += 2;
							}
						}
						else { 
							if(r5n1.getText().equals("o")){
								whiteGone += 1;
							}
							if(r5n1.getText().equals("oo")){
								whiteGone += 2;
							}
						}
						r5n1.setText(" ");
						r4n2.setText(op);
						r6n1.setText(" ");
						 
						secondButton = 1;
						whiteTurn = !whiteTurn;
						firstButton = true;
					}
				}
			}
			if(b1 == "r6n2"){
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " " && op !="е"){
						if(((JButton)event.getSource()).getName().equals("r7n1") || ((JButton)event.getSource()).getName().equals("r7n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r6n2.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r8n1")&&!r7n1.getText().equals(" ")&&!r7n1.getText().equals(op)&&!r7n1.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r7n1.getText().equals("е")){
									blackGone += 1;
								}
								if(r7n1.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r7n1.getText().equals("o")){
									whiteGone += 1;
								}
								if(r7n1.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r7n1.setText(" ");
							r8n1.setText(op);
							 
							secondButton = 1;
							r6n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r8n3")&&!r7n2.getText().equals(" ")&&!r7n2.getText().equals(op)&&!r7n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r7n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r7n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r7n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r7n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r7n2.setText(" ");
							r8n3.setText(op);
							 
							secondButton = 1;
							r6n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r5n1") || ((JButton)event.getSource()).getName().equals("r5n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r6n2.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r4n3")&&!r5n2.getText().equals(" ")&&!r5n2.getText().equals(op)&&!r5n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r5n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r5n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r5n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r5n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r5n2.setText(" ");
							r4n3.setText(op);
							 
							secondButton = 1;
							r6n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r4n1")&&!r5n1.getText().equals(" ")&&!r5n1.getText().equals(op)&&!r5n1.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r5n1.getText().equals("е")){
									blackGone += 1;
								}
								if(r5n1.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r5n1.getText().equals("o")){
									whiteGone += 1;
								}
								if(r5n1.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r5n1.setText(" ");
							r4n1.setText(op);
							 
							secondButton = 1;
							r6n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
					
				}
			}
			if(b1 == "r6n3"){
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r7n3") || ((JButton)event.getSource()).getName().equals("r7n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r6n3.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r8n2")&&!r7n2.getText().equals(" ")&&!r7n2.getText().equals(op)&&!r7n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r7n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r7n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r7n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r7n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r7n2.setText(" ");
							r8n2.setText(op);
							 
							secondButton = 1;
							r6n3.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r8n4")&&!r7n3.getText().equals(" ")&&!r7n3.getText().equals(op)&&!r7n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r7n3.getText().equals("е")){
										blackGone += 1;
								}
								if(r7n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r7n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r7n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r7n3.setText(" ");
							r8n4.setText(op);
							 
							secondButton = 1;
							r6n3.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r5n3") || ((JButton)event.getSource()).getName().equals("r5n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r6n3.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r4n4")&&!r5n3.getText().equals(" ")&&!r5n3.getText().equals(op)&&!r5n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r5n3.getText().equals("е")){
									blackGone += 1;
								}
								if(r5n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r5n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r5n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r5n3.setText(" ");
							r4n4.setText(op);
							 
							secondButton = 1;
							r6n3.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r4n2")&&!r5n2.getText().equals(" ")&&!r5n2.getText().equals(op)&&!r5n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r5n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r5n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r5n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r5n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r5n2.setText(" ");
							r4n2.setText(op);
							 
							secondButton = 1;
							r6n3.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
				}
			}
			if(b1 == "r6n4"){
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r7n4")||((JButton)event.getSource()).getName().equals("r7n3")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r6n4.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r8n3")&&!r7n3.getText().equals(" ")&&!r7n3.getText().equals(op)&&!r7n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r7n3.getText().equals("е")){
									blackGone += 1;
								}
								if(r7n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r7n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r7n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r7n3.setText(" ");
							r8n3.setText(op);
							 
							secondButton = 1;
							r6n4.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r5n3")||((JButton)event.getSource()).getName().equals("r5n4")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r6n4.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r4n3")&&!r5n3.getText().equals(" ")&&!r5n3.getText().equals(op)&&!r5n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r5n3.getText().equals("е")){
									blackGone += 1;
								}
								if(r5n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r5n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r5n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r5n3.setText(" ");
							r4n3.setText(op);
							 
							secondButton = 1;
							r6n4.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
				}
			}
			if(b1 == "r7n1"){
				
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r8n1") || ((JButton)event.getSource()).getName().equals("r8n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r7n1.setText(" ");
						}
					
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r6n1") || ((JButton)event.getSource()).getName().equals("r6n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r7n1.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r5n2")&&!r6n2.getText().equals(" ")&&!r6n2.getText().equals(op)&&!r6n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r6n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r6n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r6n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r6n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r6n2.setText(" ");
							r5n2.setText(op);
							 
							secondButton = 1;
							r7n1.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
				}
			}
			if(b1 == "r7n2"){
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r8n3") || ((JButton)event.getSource()).getName().equals("r8n2")){
							((JButton)event.getSource()).setText(op);
							whiteTurn = !whiteTurn;
							 
							secondButton = 1;
							firstButton = true;
							r7n2.setText(" ");
						}
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r6n3") || ((JButton)event.getSource()).getName().equals("r6n2")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r7n2.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r5n1")&&!r6n2.getText().equals(" ")&&!r6n2.getText().equals(op)&&!r6n2.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r6n2.getText().equals("е")){
									blackGone += 1;
								}
								if(r6n2.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r6n2.getText().equals("o")){
									whiteGone += 1;
								}
								if(r6n2.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r6n2.setText(" ");
							r5n1.setText(op);
							 
							secondButton = 1;
							r7n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r5n3")&&!r6n3.getText().equals(" ")&&!r6n3.getText().equals(op)&&!r6n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r6n3.getText().equals("е")){
									blackGone += 1;
								}
								if(r6n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r6n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r6n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r6n3.setText(" ");
							r5n3.setText(op);
							 
							secondButton = 1;
							r7n2.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
				}
			}
			if(b1 == "r7n3"){
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r8n3") || ((JButton)event.getSource()).getName().equals("r8n4")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r7n3.setText(" ");
						}
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r6n3") || ((JButton)event.getSource()).getName().equals("r6n4")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r7n3.setText(" ");
						}
						if(((JButton)event.getSource()).getName().equals("r5n2")&&!r6n3.getText().equals(" ")&&!r6n3.getText().equals(op)&&!r6n3.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r6n3.getText().equals("е")){
									blackGone += 1;
								}
								if(r6n3.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r6n3.getText().equals("o")){
									whiteGone += 1;
								}
								if(r6n3.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r6n3.setText(" ");
							r5n2.setText(op);
							 
							secondButton = 1;
							r7n3.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
						if(((JButton)event.getSource()).getName().equals("r5n4")&&!r6n4.getText().equals(" ")&&!r6n4.getText().equals(op)&&!r6n4.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r6n4.getText().equals("е")){
									blackGone += 1;
								}
								if(r6n4.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r6n4.getText().equals("o")){
									whiteGone += 1;
								}
								if(r6n4.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r6n4.setText(" ");
							r5n4.setText(op);
							 
							secondButton = 1;
							r7n3.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
				}
			}
			if(b1 == "r7n4"){
				if(((JButton)event.getSource()).getText().equals(" ")){
					if(op != " "&& op !="е"){
						if(((JButton)event.getSource()).getName().equals("r8n4")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							whiteTurn = !whiteTurn;
							firstButton = true;
							r7n4.setText(" ");
						}
					}
						
					if(op != " " && op !="o"){
						if(((JButton)event.getSource()).getName().equals("r6n4")){
							((JButton)event.getSource()).setText(op);
							 
							secondButton = 1;
							secondButton = 1;
							
							whiteTurn = !whiteTurn;
							firstButton = true;
							r7n4.setText(" ");
						}
						
						if(((JButton)event.getSource()).getName().equals("r5n3")&&!r6n4.getText().equals(" ")&&!r6n4.getText().equals(op)&&!r6n4.getText().startsWith(op.substring(0, 1))){
							if(whiteTurn){
								if(r6n4.getText().equals("е")){
									blackGone += 1;
								}
								if(r6n4.getText().equals("ее")){
									blackGone += 2;
								}
							}
							else { 
								if(r6n4.getText().equals("o")){
									whiteGone += 1;
								}
								if(r6n4.getText().equals("oo")){
									whiteGone += 2;
								}
							}
							r6n4.setText(" ");
							r5n3.setText(op);
							
							secondButton = 1;
							
							r7n4.setText(" ");
							whiteTurn = !whiteTurn;
							firstButton = true;
						}
					}
				}
			}
		}
		title();
		checkWin();
	}
	public static void title(){
		if(r1n1.getText().equals("е")){
			r1n1.setText("ее");
			blackGone -= 1;
		}
		if(r1n2.getText().equals("е")){
			r1n2.setText("ее");
			blackGone -= 1;
		}
		if(r1n3.getText().equals("е")){
			r1n3.setText("ее");
			blackGone -= 1;
		}
		if(r1n4.getText().equals("е")){
			r1n4.setText("ее");
			blackGone -= 1;
		}
		if(r8n1.getText().equals("o")){
			r8n1.setText("oo");
			whiteGone -= 1;
		}
		if(r8n2.getText().equals("o")){
			r8n2.setText("oo");
			whiteGone -= 1;
		}
		if(r8n3.getText().equals("o")){
			r8n3.setText("oo");
			whiteGone -= 1;
		}
		if(r8n4.getText().equals("o")){
			r8n4.setText("oo");
			whiteGone -= 1;
		}
		
		frame.setTitle(b1 + " " + op + " " + whiteTurn + " " + winner);
	}
	public static void checkWin(){
		if(!r1n1.getText().startsWith("е")&&!r1n2.getText().startsWith("е")&&!r1n3.getText().startsWith("е")&&!r1n4.getText().startsWith("е")
		&&!r2n1.getText().startsWith("е")&&!r2n2.getText().startsWith("е")&&!r2n3.getText().startsWith("е")&&!r2n4.getText().startsWith("е")
		&&!r3n1.getText().startsWith("е")&&!r3n2.getText().startsWith("е")&&!r3n3.getText().startsWith("е")&&!r3n4.getText().startsWith("е")
		&&!r4n1.getText().startsWith("е")&&!r4n2.getText().startsWith("е")&&!r4n3.getText().startsWith("е")&&!r4n4.getText().startsWith("е")
		&&!r5n1.getText().startsWith("е")&&!r5n2.getText().startsWith("е")&&!r5n3.getText().startsWith("е")&&!r5n4.getText().startsWith("е")
		&&!r6n1.getText().startsWith("е")&&!r6n2.getText().startsWith("е")&&!r6n3.getText().startsWith("е")&&!r6n4.getText().startsWith("е")
		&&!r7n1.getText().startsWith("е")&&!r7n2.getText().startsWith("е")&&!r7n3.getText().startsWith("е")&&!r7n4.getText().startsWith("е")
		&&!r8n1.getText().startsWith("е")&&!r8n2.getText().startsWith("е")&&!r8n3.getText().startsWith("е")&&!r8n4.getText().startsWith("е")){
			winner = "white";
			win();
		}
		if(!r1n1.getText().startsWith("o")&&!r1n2.getText().startsWith("o")&&!r1n3.getText().startsWith("o")&&!r1n4.getText().startsWith("o")
		&&!r2n1.getText().startsWith("o")&&!r2n2.getText().startsWith("o")&&!r2n3.getText().startsWith("o")&&!r2n4.getText().startsWith("o")
		&&!r3n1.getText().startsWith("o")&&!r3n2.getText().startsWith("o")&&!r3n3.getText().startsWith("o")&&!r3n4.getText().startsWith("o")
		&&!r4n1.getText().startsWith("o")&&!r4n2.getText().startsWith("o")&&!r4n3.getText().startsWith("o")&&!r4n4.getText().startsWith("o")
		&&!r5n1.getText().startsWith("o")&&!r5n2.getText().startsWith("o")&&!r5n3.getText().startsWith("o")&&!r5n4.getText().startsWith("o")
		&&!r6n1.getText().startsWith("o")&&!r6n2.getText().startsWith("o")&&!r6n3.getText().startsWith("o")&&!r6n4.getText().startsWith("o")
		&&!r7n1.getText().startsWith("o")&&!r7n2.getText().startsWith("o")&&!r7n3.getText().startsWith("o")&&!r7n4.getText().startsWith("o")
		&&!r8n1.getText().startsWith("o")&&!r8n2.getText().startsWith("o")&&!r8n3.getText().startsWith("o")&&!r8n4.getText().startsWith("o")){
			winner = "black";
			win();
		}
	
	}
	public static void win(){
		frame.setSize(400,700);
		if(winner == "white"){
			winLabel.setText("o wins");
		}
		if(winner == "black"){
			winLabel.setText("е wins");
		}
	}
	
}
