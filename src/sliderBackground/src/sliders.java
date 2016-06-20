import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;

public class sliders{
	
	public static JFrame frame;
	public static Container content;
	public static JSlider s1, s2;
	public static JSlider s3;
	public static Hashtable<Integer, JLabel> labelTable, labelTable2, labelTable3;
	public static JLabel colorLabel, num1, num2, num3;
	public static void main(String[] args) {
		
		bf();
		sliders();
		menu();
		frame.setVisible(true);
		
	}
	public static void sliders(){
		
		
		s1 = new JSlider(JSlider.HORIZONTAL, 0 , 255 , 238);
		s2 = new JSlider(JSlider.HORIZONTAL, 0 , 255 , 238);
		s3 = new JSlider(JSlider.HORIZONTAL, 0 , 255 , 238);
		
		
		content.add(s1);
		content.add(s2);
		content.add(s3);
		s1.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
	    
			if (s1.getValueIsAdjusting()) {
	        	color();
	    	}
		}
		});
		s2.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
	    
			if (s2.getValueIsAdjusting()) {
	        	color();
	    	}
		}
		});
		s3.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
	    
			if (s3.getValueIsAdjusting()) {
	        	color();
	    	}
		}
		});
		colorLabel = new JLabel(Integer.toString(s1.getValue())+ ", " + Integer.toString(s2.getValue())+ ", " + Integer.toString(s3.getValue()));
		num1 = new JLabel();
		num2 = new JLabel();
		num3 = new JLabel();
		num1.setText("0");
		num2.setText("238");
		num3.setText("255");
		labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put( new Integer( 0 ), num1 );
		labelTable.put( new Integer( 238 ), num2 );
		labelTable.put( new Integer( 255 ), num3 );
		
		labelTable2 = new Hashtable<Integer, JLabel>();
		labelTable2.put( new Integer( 0 ), num1 );
		labelTable2.put( new Integer( 238 ), num2 );
		labelTable2.put( new Integer( 255 ), num3 );
		
		labelTable3 = new Hashtable<Integer, JLabel>();
		labelTable3.put( new Integer( 127), colorLabel);
		labelTable3.put( new Integer( 0 ), num1 );
		labelTable3.put( new Integer( 238 ), num2 );
		labelTable3.put( new Integer( 255 ), num3 );
		
		
		s1.setLabelTable(labelTable);
		s1.setPaintLabels(true);
		
		s2.setLabelTable(labelTable2);
		s2.setPaintLabels(true);
		
		s3.setLabelTable(labelTable3);
		s3.setPaintLabels(true);
				
	}
	public static void bf(){
		
		frame = new JFrame("Slider");
		frame.setSize(600,200);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content = frame.getContentPane();
		content.setLayout(new GridLayout(3,1));
		
		
	}
	public static void color(){
		
		colorLabel.setText(Integer.toString(s1.getValue())+ ", " + Integer.toString(s2.getValue())+ ", " + Integer.toString(s3.getValue()));
		if(s1.getValue() < 127 && s2.getValue() < 127 && s3.getValue() < 127){
			colorLabel.setForeground(Color.white);
			num1.setForeground(Color.white);
			num2.setForeground(Color.white);
			num3.setForeground(Color.white);
		}
		else{
			colorLabel.setForeground(Color.black);
			num1.setForeground(Color.black);
			num2.setForeground(Color.black);
			num3.setForeground(Color.black);
		}
		frame.setBackground(new Color(s1.getValue(),s2.getValue(),s3.getValue()));
	}
	public static void menu(){
		JMenuBar menuBar;
		JMenu Colors;
		JMenuItem White, Black, Red, Green, Blue, Default;
		menuBar = new JMenuBar();
		
		Colors = new JMenu("Colors");
		
		White = new JMenuItem("White");
		White.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				s1.setValue(255);
				s2.setValue(255);
				s3.setValue(255);
				color();
			}
		});
		Black = new JMenuItem("Black");
		Black.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				s1.setValue(0);
				s2.setValue(0);
				s3.setValue(0);
				color();
			}
		});
		Red = new JMenuItem("Red");
		Red.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				s1.setValue(255);
				s2.setValue(0);
				s3.setValue(0);
				color();
			}
		});
		Green = new JMenuItem("Green");
		Green.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				s1.setValue(0);
				s2.setValue(255);
				s3.setValue(0);
				color();
			}
		});
		Blue = new JMenuItem("Blue");
		Blue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				s1.setValue(0);
				s2.setValue(0);
				s3.setValue(255);
				color();
			}
		});
		Default = new JMenuItem("Default");
		Default.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				s1.setValue(238);
				s2.setValue(238);
				s3.setValue(238);
				color();
			}
		});
		Colors.add(White);
		Colors.add(Black);
		Colors.add(Red);
		Colors.add(Green);
		Colors.add(Blue);
		Colors.add(Default);
		menuBar.add(Colors);
		frame.setJMenuBar(menuBar);
		
	}

}