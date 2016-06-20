import java.awt.*;
import javax.swing.*;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewCal implements ActionListener{
	public static JFrame frame;
	public static Container content;
	public static JButton plus, minus, multiply, divide, root, squared, equals, clear, posNeg, decimal;
	public static JButton[] numberButtons = new JButton[10];
	public static double num1, num2, labelNum, prevNum1, prevNum2;
	public static int decimalPlacesOut = 1;
	public static JLabel label;
	public static boolean onNum1 = true, decimalPressed = false;
	public static String op = "", prevOp = "";
	public static void main(String[] args) {
		NewCal cal = new NewCal();
		//buildFrame();
		//buttons();
		frame.setVisible(true);
	}
	public NewCal(){
		buildFrame();
		buttons();
	}
	public static void buildFrame(){
		frame = new JFrame("Slider");
		frame.setSize(500,740);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setTitle("Calculator");
		content = frame.getContentPane();
	}
	public void buttons(){
		for(int i = 0; i < numberButtons.length; i++){
			numberButtons[i] = new JButton();
			numberButtons[i].setText("" + i);
			numberButtons[i].addActionListener(this);
			content.add(numberButtons[i]);
		}
		
		num1 = 0;
		num2 = 0;
		labelNum = 0;
		
		label = new JLabel();
		setLabel(0);
		clear = new JButton("C");
		equals = new JButton("=");
		plus = new JButton("+");
		minus = new JButton("-");
		divide = new JButton("÷");
		squared = new JButton("^");
		multiply = new JButton("X");
		root = new JButton("√");
		decimal = new JButton(".");
		posNeg = new JButton("+/-");
		
		label.setBounds(25,0,580,100);
		root.setBounds(20,120,100,100);
		squared.setBounds(140,120,100,100);
		posNeg.setBounds(260,120,100,100);
		clear.setBounds(380,120,100,100);
		numberButtons[7].setBounds(20,240,100,100);
		numberButtons[8].setBounds(140,240,100,100);
		numberButtons[9].setBounds(260,240,100,100);
		divide.setBounds(380,240,100,100);
		numberButtons[4].setBounds(20,360,100,100);
		numberButtons[5].setBounds(140,360,100,100);
		numberButtons[6].setBounds(260,360,100,100);
		multiply.setBounds(380,360,100,100);
		numberButtons[1].setBounds(20,480,100,100);
		numberButtons[2].setBounds(140,480,100,100);
		numberButtons[3].setBounds(260,480,100,100);
		minus.setBounds(380,480,100,100);
		numberButtons[0].setBounds(20,600,100,100);
		decimal.setBounds(140,600,100,100);
		equals.setBounds(260,600,100,100);
		plus.setBounds(380,600,100,100);
		
		content.add(label);
		content.add(equals);
		content.add(clear);
		content.add(plus);
		content.add(minus);
		content.add(multiply);
		content.add(divide);
		content.add(squared);
		content.add(root);
		content.add(decimal);
		content.add(posNeg);
		
		plus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(!onNum1){
					whenEqualsPressed();
				} 
				decimalPressed = false;
				decimalPlacesOut = 1;
				op = "+";
				onNum1 = false;
				setLabel(labelNum,op);
			}
		});
		minus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(!onNum1){
					whenEqualsPressed();
				} 
				decimalPressed = false;
				decimalPlacesOut = 1;
				op = "-";
				onNum1 = false;
				setLabel(labelNum,op);
			}
		});
		multiply.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(!onNum1){
					whenEqualsPressed();
				} 
				decimalPressed = false;
				decimalPlacesOut = 1;
				op = "X";
				onNum1 = false;
				setLabel(labelNum,op);
			}
		});
		divide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(!onNum1){
					whenEqualsPressed();
				} 
				decimalPressed = false;
				decimalPlacesOut = 1;
				op = "÷";
				onNum1 = false;
				setLabel(labelNum,op);
			}
		});
		squared.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(!onNum1){
					whenEqualsPressed();
				} 
				decimalPressed = false;
				decimalPlacesOut = 1;
				op = "^";
				onNum1 = false;
				setLabel(labelNum,op);
			}
		});
		root.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(!onNum1){
					whenEqualsPressed();
				} 
				decimalPressed = false;
				decimalPlacesOut = 1;
				op = "√";
				onNum1 = false;
				setLabel(labelNum,op);
			}
		});
		posNeg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(onNum1){
					num1 *= -1;
					setLabel(num1);
				} else {
					num2 *= -1;
					setLabel(num2);
				}
			}
		});
		decimal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				decimalPressed = true;
				setLabel(labelNum);
			}
		});
		
		equals.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				whenEqualsPressed();
			}
		});
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				num1 = 0;
				num2 = 0;
				onNum1 = true;
				decimalPlacesOut = 1;
				decimalPressed = false;
				op = "";
				setLabel(0);
			}
		});
	}
	public void whenEqualsPressed(){
		if(op == "="){
			op = prevOp;
			num1 = labelNum;
			num2 = prevNum2;
		}
		if(op == "+"){
			setLabel(num1 + num2);
		}
		if(op == "-"){
			setLabel(num1 - num2);
		}
		if(op == "X"){
			setLabel(num1 * num2);
		}
		if(op == "÷"){
			setLabel(num1 / num2);
		}
		if(op == "^"){
			setLabel(Math.pow(num1,num2));
		}
		if(op == "√"){
			setLabel(Math.pow(num1,1/num2));
		}
		prevOp = op;
		op = "=";
		onNum1 = true;
		prevNum1 = num1;
		prevNum2 = num2;
		num1 = labelNum;
		num2 = 0;
		onNum1 = true;
		decimalPressed = false;
		decimalPlacesOut = 1;
	}
	public Boolean numberButtonContainsSource(Object object){
		Boolean does = false;
		for(int i = 0; i < numberButtons.length; i++){
			if(String.valueOf(numberButtons[i]) == object){
				does = true;
			}
		}
		
		
		return null;
		
	}
	public void actionPerformed(ActionEvent event){
		/*if(numberButtonContainsSource(event.getSource())){
			
		}*/
		if(!decimalPressed){
			if(!String.valueOf(labelNum).startsWith("-0")){
				if(onNum1){
					num1 *= 10;
					num1 += Integer.parseInt(((JButton)event.getSource()).getText());
					setLabel(num1);
				} else {
					num2 *= 10;
					num2 += Integer.parseInt(((JButton)event.getSource()).getText());
					setLabel(num2);
				}
			} else {
				if(onNum1){
					num1 -= Integer.parseInt(((JButton)event.getSource()).getText());
					setLabel(num1);
				} else {
					num2 -= Integer.parseInt(((JButton)event.getSource()).getText());
					setLabel(num2);
				}
			}
		} else {
			if(!String.valueOf(labelNum).startsWith("-0")){
				if(onNum1){
					num1 += (Integer.parseInt(((JButton)event.getSource()).getText()) * Math.pow(0.1, decimalPlacesOut));
					setLabel(num1);
				} else {
					num2 += (Integer.parseInt(((JButton)event.getSource()).getText()) * Math.pow(0.1, decimalPlacesOut));
					setLabel(num2);
				}
			} else {
				if(onNum1){
					num1 -= (Integer.parseInt(((JButton)event.getSource()).getText()) * Math.pow(0.1, decimalPlacesOut));
					setLabel(num1);
				} else {
					num2 -= (Integer.parseInt(((JButton)event.getSource()).getText()) * Math.pow(0.1, decimalPlacesOut));
					setLabel(num2);
				}
			}
			decimalPlacesOut++;
		}
	}
	public static void setLabel(double newNum){
		labelNum = newNum;
		if(String.valueOf(labelNum).endsWith(".0") && !decimalPressed){
			label.setText(String.valueOf(labelNum).substring(0,String.valueOf(labelNum).length() - 2));
		} else {
			label.setText("" + labelNum);
		}
	}
	public static void setLabel(double newNum, String operation){
		labelNum = newNum;
		if(String.valueOf(labelNum).endsWith(".0") && !decimalPressed){
			label.setText(String.valueOf(labelNum).substring(0,String.valueOf(labelNum).length() - 2) + op);
		} else {
			label.setText("" + labelNum + op);
		}
	}
	
}
