import java.awt.*;
import javax.swing.*;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cal {
	public static JFrame frame;
	public static Container content;
	public static JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, plus, minus, multiply, divide, root, squared, enter, clear;
	public static int num1, num2, num3, l1, l2;
	public static float numf;
	public static JLabel label;
	public static boolean num = true;
	public static String op;
	public static void main(String[] args) {
		buildFrame();
		buttons();
		frame.setVisible(true);
	}
	public static void buildFrame(){
		frame = new JFrame("Slider");
		frame.setSize(400,400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		content = frame.getContentPane();
	}
	public static void buttons(){
		
		num1 = 0;
		num2 = 0;
		label = new JLabel();
		label.setText(" 0");
		label.setBounds(50,30,100,100);
		content.add(label);
		b1 = new JButton();
		b1.setText("1");
		b1.setBounds(50,100,50,50);
		content.add(b1);
		b2 = new JButton();
		b2.setText("2");
		b2.setBounds(133,100,50,50);
		content.add(b2);
		b3 = new JButton();
		b3.setText("3");
		b3.setBounds(216,100,50,50);
		content.add(b3);
		b4 = new JButton();
		b4.setText("4");
		b4.setBounds(50,150,50,50);
		content.add(b4);
		b5 = new JButton();
		b5.setText("5");
		b5.setBounds(133,150,50,50);
		content.add(b5);
		b6 = new JButton();
		b6.setText("6");
		b6.setBounds(216,150,50,50);
		content.add(b6);
		b7 = new JButton();
		b7.setText("7");
		b7.setBounds(50,200,50,50);
		content.add(b7);
		b8 = new JButton();
		b8.setText("8");
		b8.setBounds(133,200,50,50);
		content.add(b8);
		b9 = new JButton();
		b9.setText("9");
		b9.setBounds(216,200,50,50);
		content.add(b9);
		b0 = new JButton();
		b0.setText("0");
		b0.setBounds(300,200,50,50);
		content.add(b0);
		enter = new JButton();
		enter.setText("=");
		enter.setBounds(300,150,50,50);
		content.add(enter);
		clear = new JButton();
		clear.setText("C");
		clear.setBounds(300,100,50,50);
		content.add(clear);
		plus = new JButton();
		plus.setText("+");
		plus.setBounds(50,250,50,50);
		content.add(plus);
		minus = new JButton();
		minus.setText("-");
		minus.setBounds(133,250,50,50);
		content.add(minus);
		multiply = new JButton();
		multiply.setText("x");
		multiply.setBounds(216,250,50,50);
		content.add(multiply);
		divide = new JButton();
		divide.setText("/");
		divide.setBounds(300,250,50,50);
		content.add(divide);
		squared = new JButton();
		squared.setText("^");
		squared.setBounds(216,300,50,50);
		content.add(squared);
		root = new JButton();
		root.setText("Ã");
		root.setBounds(300,300,50,50);
		content.add(root);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(num && l1 < 8){
					num1*=10;
					num1+=1;
					l1 += 1;
				}
				else{
					if(l2 < 8){
						num2*=10;
						num2+=1;
						l2 += 1;
					}
					
				}
				setLabel();
				
			}
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(num && l1 < 8){
					num1*=10;
					num1+=2;
					l1 += 1;
				}
				else{
					if(l2 < 8){
						num2*=10;
						num2+=2;
						l2 += 1;
					}
				}
				setLabel();
				
			}
		});
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(num && l1 < 8){
					num1*=10;
					num1+=3;
					l1 += 1;
				}
				else{
					if(l2 < 8){
						num2*=10;
						num2+=3;
						l2 += 1;
					}
				}
				setLabel();
				
			}
		});
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(num && l1 < 8){
					num1*=10;
					num1+=4;
					l1 += 1;
				}
				else{
					if(l2 < 8){
						num2*=10;
						num2+=4;
						l2 += 1;
					}
				}
				setLabel();
				
			}
		});
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(num && l1 < 8){
					num1*=10;
					num1+=5;
					l1 += 1;
				}
				else{
					if(l2 < 8){
						num2*=10;
						num2+=5;
						l2 += 1;
					}
				}
				setLabel();
				
			}
		});
		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(num && l1 < 8){
					num1*=10;
					num1+=6;
					l1 += 1;
				}
				else{
					if(l2 < 8){
						num2*=10;
						num2+=6;
						l2 += 1;
					}
				}
				setLabel();
				
			}
		});
		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(num && l1 < 8){
					num1*=10;
					num1+=7;
					l1 += 1;
				}
				else{
					if(l2 < 8){
						num2*=10;
						num2+=7;
						l2 += 1;
					}
				}
				setLabel();
				
			}
		});
		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(num && l1 < 8){
					num1*=10;
					num1+=8;
					l1 += 1;
				}
				else{
					if(l2 < 8){
						num2*=10;
						num2+=8;
						l2 += 1;
					}
				}
				setLabel();
				
			}
		});
		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(num && l1 < 8){
					num1*=10;
					num1+=9;
					l1 += 1;
				}
				else{
					if(l2 < 8){
						num2*=10;
						num2+=9;
						l2 += 1;
					}
				}
				setLabel();
				
			}
		});
		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(num && l1 < 8){
					num1*=10;
					num1+=0;
					l1 += 1;
				}
				else{
					if(l2 < 8){
						num2*=10;
						num2+=0;
						l2 += 1;
					}
				}
				setLabel();
				
			}
		});
		plus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				if(num){
				op = "plus";
				num = !num;
				}
				else{	
				op = "plus";
				}
				num2 = 0;
				setLabel();
			}
		});
		minus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(num){
				op = "minus";
				num = !num;
				}
				else{
				op = "minus";
				}
				num2 = 0;
				setLabel();
				
			}
		});
		multiply.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(num){
				op = "multiply";
				num = !num;
				}
				else{	
				op = "multiply";
				}
				num2 = 0;
				setLabel();
			}
		});
		divide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(num){
				op = "divide";
				num = !num;
				}
				else{
					
					op = "divide";
					}
				num2 = 0;
				setLabel();
			}
		});
		squared.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(num){
				num = !num;
				}	
				if(op.equals("root")){
				op = "squared";
				}
				num2 = 0;
				setLabel();
			}
		});
		root.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				numf = num1;
				numf = (float) Math.sqrt(numf);
				label.setText(" "+numf);
			}
		});
		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(op.equals("plus")){
					num3 = num1 + num2;
					
				}
				if(op.equals("minus")){
					num3 = num1 - num2;
					
				}
				if(op.equals("multiply")){
					num3 = num1 * num2;
					
				}
				if(op.equals("divide")){
					
					num3 = (num1) / (num2);
				}
				if(op.equals("squared")){
					numf = num1;
					for (int i = 1; i < num2; i++){
						numf*=num1;
					}
					
				}
				
				label.setText(" "+num3);
				
				num1 = num3;
			}
		});
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				num1 = 0;
				num2 = 0;
				l1 = 0;
				l2 = 0;
				num = true;
				setLabel();
			}
		});
	}
	public static void setLabel(){
		if(num){
			label.setText(" "+num1);
		}
		else{
			label.setText(" "+num2);
		}
	}
}
