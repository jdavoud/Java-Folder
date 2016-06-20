import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SukkahProject implements ActionListener {
	public static JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16;
	public static JLabel text;
	public static Container content;
	public static void main(String[] args) {
		SukkahProject p = new SukkahProject();
	}
	public SukkahProject(){
		JFrame frame = new JFrame();
		frame.setSize(725,725);
		frame.setTitle("A Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		content=frame.getContentPane();
		buttons();
		frame.setVisible(true);
	}
	public void buttons(){
		
		b1 = new JButton();
		b1.setForeground(new Color(60,50,0));
		b1.setBackground(new Color(60,50,0));
		b1.setOpaque(true);
		b1.setBorderPainted(false);
		b1.addActionListener(this);
		b1.setBounds(100,600,50,100);
		content.add(b1);
		b2 = new JButton();
		b2.setForeground(new Color(60,50,0));
		b2.setBackground(new Color(60,50,0));
		b2.setOpaque(true);
		b2.setBorderPainted(false);
		b2.addActionListener(this);
		b2.setBounds(100,490,50,100);
		content.add(b2);
		b3 = new JButton();
		b3.setForeground(new Color(60,50,0));
		b3.setBackground(new Color(60,50,0));
		b3.setOpaque(true);
		b3.setBorderPainted(false);
		b3.addActionListener(this);
		b3.setBounds(100,380,50,100);
		content.add(b3);
		b4 = new JButton();
		b4.setForeground(new Color(60,50,0));
		b4.setBackground(new Color(60,50,0));
		b4.setOpaque(true);
		b4.setBorderPainted(false);
		b4.addActionListener(this);
		b4.setBounds(100,270,50,100);
		content.add(b4);
		b5 = new JButton();
		b5.setForeground(new Color(60,50,0));
		b5.setBackground(new Color(60,50,0));
		b5.setOpaque(true);
		b5.setBorderPainted(false);
		b5.addActionListener(this);
		b5.setBounds(100,160,50,100);
		content.add(b5);
		b6 = new JButton();
		b6.setForeground(new Color(60,50,0));
		b6.setBackground(new Color(60,50,0));
		b6.setOpaque(true);
		b6.setBorderPainted(false);
		b6.addActionListener(this);
		b6.setBounds(100,50,50,100);
		content.add(b6);
		b7 = new JButton();
		b7.setForeground(new Color(150,255,0));
		b7.setBackground(new Color(150,255,0));
		b7.setOpaque(true);
		b7.setBorderPainted(false);
		b7.addActionListener(this);
		b7.setBounds(160,50,100,50);
		content.add(b7);
		b8 = new JButton();
		b8.setForeground(new Color(150,255,0));
		b8.setBackground(new Color(150,255,0));
		b8.setOpaque(true);
		b8.setBorderPainted(false);
		b8.addActionListener(this);
		b8.setBounds(270,50,100,50);
		content.add(b8);
		b9 = new JButton();
		b9.setForeground(new Color(150,255,0));
		b9.setBackground(new Color(150,255,0));
		b9.setOpaque(true);
		b9.setBorderPainted(false);
		b9.addActionListener(this);
		b9.setBounds(380,50,100,50);
		content.add(b9);
		b10 = new JButton();
		b10.setForeground(new Color(150,255,0));
		b10.setBackground(new Color(150,255,0));
		b10.setOpaque(true);
		b10.setBorderPainted(false);
		b10.addActionListener(this);
		b10.setBounds(490,50,100,50);
		content.add(b10);
		b11 = new JButton();
		b11.setForeground(new Color(60,50,0));
		b11.setBackground(new Color(60,50,0));
		b11.setOpaque(true);
		b11.setBorderPainted(false);
		b11.addActionListener(this);
		b11.setBounds(600,50,50,100);
		content.add(b11);
		b12 = new JButton();
		b12.setForeground(new Color(60,50,0));
		b12.setBackground(new Color(60,50,0));
		b12.setOpaque(true);
		b12.setBorderPainted(false);
		b12.addActionListener(this);
		b12.setBounds(600,160,50,100);
		content.add(b12);
		b13 = new JButton();
		b13.setForeground(new Color(60,50,0));
		b13.setBackground(new Color(60,50,0));
		b13.setOpaque(true);
		b13.setBorderPainted(false);
		b13.addActionListener(this);
		b13.setBounds(600,270,50,100);
		content.add(b13);
		b14 = new JButton();
		b14.setForeground(new Color(60,50,0));
		b14.setBackground(new Color(60,50,0));
		b14.setOpaque(true);
		b14.setBorderPainted(false);
		b14.addActionListener(this);
		b14.setBounds(600,380,50,100);
		content.add(b14);
		b15 = new JButton();
		b15.setForeground(new Color(60,50,0));
		b15.setBackground(new Color(60,50,0));
		b15.setOpaque(true);
		b15.setBorderPainted(false);
		b15.addActionListener(this);
		b15.setBounds(600,490,50,100);
		content.add(b15);
		b16 = new JButton();
		b16.setForeground(new Color(60,50,0));
		b16.setBackground(new Color(60,50,0));
		b16.setOpaque(true);
		b16.setBorderPainted(false);
		b16.addActionListener(this);
		b16.setBounds(600,600,50,100);
		content.add(b16);
		
		text = new JLabel();
		text.setText("<html><p align=center>Welcome to my Social Justice Sukkah! </p></html>");
		text.setBounds(200,200,350,300);
		content.add(text);
		b1.setName("b1");
		b2.setName("b2");
		b3.setName("b3");
		b4.setName("b4");
		b5.setName("b5");
		b6.setName("b6");
		b7.setName("b7");
		b8.setName("b8");
		b9.setName("b9");
		b10.setName("b10");
		b11.setName("b11");
		b12.setName("b12");
		b13.setName("b13");
		b14.setName("b14");
		b15.setName("b15");
		b16.setName("b16");
		try {
		    Image img = ImageIO.read(getClass().getResource("images/apple.png"));
		    Image img1 = ImageIO.read(getClass().getResource("images/banana.png"));
		    Image img2 = ImageIO.read(getClass().getResource("images/pear.png"));
		    Image img3 = ImageIO.read(getClass().getResource("images/orange.png"));
		    b7.setIcon(new ImageIcon(img));
		    b8.setIcon(new ImageIcon(img1));
		    b9.setIcon(new ImageIcon(img2));
		    b10.setIcon(new ImageIcon(img3));
		  } catch (IOException ex) {
		  }
	}
	public void actionPerformed(ActionEvent event) {
		if(((JButton)event.getSource()).getName().equals("b1")){

			text.setText("<html><p align=center>What social justice issue is your Sukkah teaching about?</p></html>");
		}
		if(((JButton)event.getSource()).getName().equals("b2")){

			text.setText("<html><p align=center>The issue that my Social Justice issue is talking about is hunger around the world.</p></html>");
		}
		if(((JButton)event.getSource()).getName().equals("b3")){
			text.setText("<html><p align=center>Where is your Sukkah located?</p></html>");
		}
		if(((JButton)event.getSource()).getName().equals("b4")){

			text.setText("<html><p align=center>My Sukkah is located outside of a supermarket because supermarkets are filled with people who are buying food and they realize that while they can afford to go in and buy food, there are a lot of people in the world that don't have enough money to buy food. People can go into the supermarket and buy some extra food, and bring it to my Sukkah outside and will be brought to a soup kitchen or food pantry.</p></html>");
		}
		
		if(((JButton)event.getSource()).getName().equals("b5")){

			text.setText("<html><p align=center>What is your Sukkah made of?</p></html>");
		}
		if(((JButton)event.getSource()).getName().equals("b6")){

			text.setText("<html><p align=center>My Sukkah is very bear, made of simple wood and some long grass and shrubs on the top because I don't want to have to spend a lot of money on my Sukkah because if I want people to know that I seriously care about the issue of hunger, then I shouldn't spend money on making my Sukkah pretty, but spend that money to help out people that are hungry.</p></html>");
		}
		if(((JButton)event.getSource()).getName().equals("b7")){

			text.setText("<html><p align=center>Who built and/or supplied the materials for your sukkah?</p></html>");
		}
		if(((JButton)event.getSource()).getName().equals("b8")){

			text.setText("<html><p align=center>My family and I went to Home Depot and got some basic wood for the structure, some screws to hold the wood together, and we retrieved some grass and shrubs and we went and built it.</p></html>");
		}
		if(((JButton)event.getSource()).getName().equals("b9")){

			text.setText("<html><p align=center>How do you expect your Sukkah will influence people who see it and dwell in it?</p></html>");
		}
		if(((JButton)event.getSource()).getName().equals("b10")){

			text.setText("<html><p align=center>I expect that people will realize that people aren't as fortunate as they are to be able to know that they have access to food and are not worrying about what to have for dinner but are worrying about whether they will have dinner.</p></html>");
		}
		if(((JButton)event.getSource()).getName().equals("b11")){

			text.setText("<html><p align=center>I hope that people will understand that hunger affects every country in the world. Even the most developed of countries including the USA have people that don't know where their next meal is coming from.</p></html>");
		}
		if(((JButton)event.getSource()).getName().equals("b12")){

			text.setText("<html><p align=center>In countries like China there are many people unaccounted for that live in very poor areas where they have little food for a lot of people. Also in North Korea, studies have shown that people are about 3 inches shorter than the people in their southern counterpart due to undernourishment.</p></html>");
		}
		if(((JButton)event.getSource()).getName().equals("b13")){
			
			text.setText("<html><p align=center>The Democratic Republic of Congo has the highest percentage of hungry people with up to 75% of the population being hungry, and Eritrea, Burundi, and Haiti also have percentages of the population that are hungry over 50%.</p></html>");
		}
		if(((JButton)event.getSource()).getName().equals("b14")){

			text.setText("<html><p align=center>Even in the USA, 1 in 6 people struggle with hunger and what's worse is that households with children have a higher percentage of being hungry than those with no children. </p></html>");
		}
		if(((JButton)event.getSource()).getName().equals("b15")){

			text.setText("<html><p align=center>Over 870 million people go to bed hungry each night, almost an 8th of the world's population. Hunger is number one on the list of the world's top 10 health risks, killing more people every year than AIDS, malaria, and tuberculosis combined.</p></html>");
		}
		if(((JButton)event.getSource()).getName().equals("b16")){

			text.setText("<html><p align=center>Overall, hunger is a massive issue in the world. Sometimes if you get hungry a few hours after the previous meal, it feels pretty bad, but I can't imagine not eating for days. I also can't imagine when babies cry because they are hungry or want milk, and they can't have any because their parents can't afford to give them any.</p></html>");
		}
		
	}
}
