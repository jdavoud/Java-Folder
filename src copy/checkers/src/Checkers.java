import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;


public class Checkers implements ActionListener{
	public static JFrame frame;
	public static Container content;
	public static JButton restart, b12, b14, b16, b18, b21, b23, b25, b27, b32, b34, b36, b38, b41, b43, b45, b47, b52, b54, b56, b58, b61, b63, b65, b67, b72, b74, b76, b78, b81, b83, b85, b87;
	public static boolean whiteTurn = true, firstButton = true, jumpTrue;
	public static JLabel winLabel, whiteLabel, blackLabel;
	public static String b1 = " ", b2 = " ",op = " ", winner = " ";  
	public static Integer whiteGone = 0, blackGone = 0, secondButton = 1, num1 = 0, num2 = 0, num3 = 0, num4 = 0, a;
	public static JMenu numMenu;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Checkers ttt = new Checkers();
		
	}
	public Checkers(){
		frame = new JFrame();
		frame.setSize(400,480);
		frame.setTitle("A Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		content=frame.getContentPane();
		JMenuBar menubar;
		menubar = new JMenuBar();
		//frame.setJMenuBar(menubar);
		JMenu menu;
		
		menu = new JMenu("Switch turn");
		numMenu = new JMenu(" num1: " + num1 + " num2: " + num2 + " num3: " + num3 + " num4: " + num4);
		JMenuItem menuItem;
		menuItem  = new JMenuItem("Switch Turn");
		menuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				whiteTurn = !whiteTurn;
			}
		});
		menu.add(menuItem);
		menubar.add(menu);
		menubar.add(numMenu);
		buttons();
		frame.setVisible(true);
	}
	public void buttons(){
		winLabel = new JLabel();
		winLabel.setText(winner);
		winLabel.setBounds(180,480,50,50);
		whiteLabel = new JLabel();
		whiteLabel.setText(" ");
		whiteLabel.setBounds(50,420,50,50);
		blackLabel = new JLabel();
		blackLabel.setText(" ");
		blackLabel.setBounds(50,435,50,50);
		restart = new JButton();
		restart.setBounds(125,520,150,50);
		restart.setText("Restart");
		restart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				b12.setText("o");
				b14.setText("o");
				b16.setText("o");
				b18.setText("o");
				b21.setText("o");
				b23.setText("o");
				b25.setText("o");
				b27.setText("o");
				b32.setText("o");
				b34.setText("o");
				b36.setText("o");
				b38.setText("o");
				b61.setText("�");
				b63.setText("�");
				b65.setText("�");
				b67.setText("�");
				b72.setText("�");
				b74.setText("�");
				b76.setText("�");
				b78.setText("�");
				b81.setText("�");
				b83.setText("�");
				b85.setText("�");
				b87.setText("�");
				b52.setText(" ");
				b54.setText(" ");
				b56.setText(" ");
				b58.setText(" ");
				b41.setText(" ");
				b43.setText(" ");
				b45.setText(" ");
				b47.setText(" ");
				frame.setSize(400,480);
			}
		});
		content.add(winLabel);
		content.add(restart);
		b12 = new JButton();
		b12.setBounds(frame.getWidth()/8,0,frame.getWidth()/8,frame.getWidth()/8);
		b12.addActionListener(this);
		content.add(b12);
		b14 = new JButton();
		b14.setBounds(150,0,50,50);
		b14.addActionListener(this);
		content.add(b14);
		b16 = new JButton();
		b16.setBounds(250,0,50,50);
		b16.addActionListener(this);
		content.add(b16);
		b18 = new JButton();
		b18.setBounds(350,0,50,50);
		b18.addActionListener(this);
		content.add(b18);
		b21 = new JButton();
		b21.setBounds(0,50,50,50);
		b21.addActionListener(this);
		content.add(b21);
		b23 = new JButton();
		b23.setBounds(100,50,50,50);
		b23.addActionListener(this);
		content.add(b23);
		b25 = new JButton();
		b25.setBounds(200,50,50,50);
		b25.addActionListener(this);
		content.add(b25);
		b27 = new JButton();
		b27.setBounds(300,50,50,50);
		b27.addActionListener(this);
		content.add(b27);
		b32 = new JButton();
		b32.setBounds(50,100,50,50);
		b32.addActionListener(this);
		content.add(b32);
		b34 = new JButton();
		b34.setBounds(150,100,50,50);
		b34.addActionListener(this);
		content.add(b34);
		b36 = new JButton();
		b36.setBounds(250,100,50,50);
		b36.addActionListener(this);
		content.add(b36);
		b38 = new JButton();
		b38.setBounds(350,100,50,50);
		b38.addActionListener(this);
		content.add(b38);
		b41 = new JButton();
		b41.setBounds(0,150,50,50);
		b41.addActionListener(this);
		content.add(b41);
		b43 = new JButton();
		b43.setBounds(100,150,50,50);
		b43.addActionListener(this);
		content.add(b43);
		b45 = new JButton();
		b45.setBounds(200,150,50,50);
		b45.addActionListener(this);
		content.add(b45);
		b47 = new JButton();
		b47.setBounds(300,150,50,50);
		b47.addActionListener(this);
		content.add(b47);
		b52 = new JButton();
		b52.setBounds(50,200,50,50);
		b52.addActionListener(this);
		content.add(b52);
		b54 = new JButton();
		b54.setBounds(150,200,50,50);
		b54.addActionListener(this);
		content.add(b54);
		b56 = new JButton();
		b56.setBounds(250,200,50,50);
		b56.addActionListener(this);
		content.add(b56);
		b58 = new JButton();
		b58.setBounds(350,200,50,50);
		b58.addActionListener(this);
		content.add(b58);
		b61 = new JButton();
		b61.setBounds(0,250,50,50);
		b61.addActionListener(this);
		content.add(b61);
		b63 = new JButton();
		b63.setBounds(100,250,50,50);
		b63.addActionListener(this);
		content.add(b63);
		b65 = new JButton();
		b65.setBounds(200,250,50,50);
		b65.addActionListener(this);
		content.add(b65);
		b67 = new JButton();
		b67.setBounds(300,250,50,50);
		b67.addActionListener(this);
		content.add(b67);
		b72 = new JButton();
		b72.setBounds(50,300,50,50);
		b72.addActionListener(this);
		content.add(b72);
		b74 = new JButton();
		b74.setBounds(150,300,50,50);
		b74.addActionListener(this);
		content.add(b74);
		b76 = new JButton();
		b76.setBounds(250,300,50,50);
		b76.addActionListener(this);
		content.add(b76);
		b78 = new JButton();
		b78.setBounds(350,300,50,50);
		b78.addActionListener(this);
		content.add(b78);
		b81 = new JButton();
		b81.setBounds(0,350,50,50);
		b81.addActionListener(this);
		content.add(b81);
		b83 = new JButton();
		b83.setBounds(100,350,50,50);
		b83.addActionListener(this);
		content.add(b83);
		b85 = new JButton();
		b85.setBounds(200,350,50,50);
		b85.addActionListener(this);
		content.add(b85);
		b87 = new JButton();
		b87.setBounds(300,350,50,50);
		b87.addActionListener(this);
		content.add(b87);
		b12.setText("o");
		b14.setText("o");
		b16.setText("o");
		b18.setText("o");
		b21.setText("o");
		b23.setText("o");
		b25.setText("o");
		b27.setText("o");
		b32.setText("o");
		b34.setText("o");
		b36.setText("o");
		b38.setText("o");
		b61.setText("•");
		b63.setText("•");
		b65.setText("•");
		b67.setText("•");
		b72.setText("•");
		b74.setText("•");
		b76.setText("•");
		b78.setText("•");
		b81.setText("•");
		b83.setText("•");
		b85.setText("•");
		b87.setText("•");
		b52.setText(" ");
		b54.setText(" ");
		b56.setText(" ");
		b58.setText(" ");
		b41.setText(" ");
		b43.setText(" ");
		b45.setText(" ");
		b47.setText(" ");
		b12.setName("b12");
		b14.setName("b14");
		b16.setName("b16");
		b18.setName("b18");
		b21.setName("b21");
		b23.setName("b23");
		b25.setName("b25");
		b27.setName("b27");
		b32.setName("b32");
		b34.setName("b34");
		b36.setName("b36");
		b38.setName("b38");
		b41.setName("b41");
		b43.setName("b43");
		b45.setName("b45");
		b47.setName("b47");
		b52.setName("b52");
		b54.setName("b54");
		b56.setName("b56");
		b58.setName("b58");
		b61.setName("b61");
		b63.setName("b63");
		b65.setName("b65");
		b67.setName("b67");
		b72.setName("b72");
		b74.setName("b74");
		b76.setName("b76");
		b78.setName("b78");
		b81.setName("b81");
		b83.setName("b83");
		b85.setName("b85");
		b87.setName("b87");
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
				
				String regex ="(\\d+)";
				Matcher matcher1 = Pattern.compile( regex ).matcher( ((JButton)event.getSource()).getName().substring(1,2));
				while (matcher1.find()) { // for each match
				    num1 = (Integer.parseInt(matcher1.group())); // convert to int
				}
				Matcher matcher = Pattern.compile( regex ).matcher( ((JButton)event.getSource()).getName().substring(2,3));
				while (matcher.find()) { // for each match
				    num2 = (Integer.parseInt(matcher.group())); // convert to int
				}
			}
			if(!whiteTurn && (((JButton)event.getSource()).getText().equals("�")||((JButton)event.getSource()).getText().equals("��"))){
				b1 = ((JButton)event.getSource()).getName();
				op = ((JButton)event.getSource()).getText();
				firstButton = false;	
				secondButton = 2;
				String regex ="(\\d+)";
				Matcher matcher1 = Pattern.compile( regex ).matcher( ((JButton)event.getSource()).getName().substring(1,2));
				while (matcher1.find()) { // for each match
				    num1 = (Integer.parseInt(matcher1.group())); // convert to int
				}
				Matcher matcher = Pattern.compile( regex ).matcher( ((JButton)event.getSource()).getName().substring(2,3));
				while (matcher.find()) { // for each match
				    num2 = (Integer.parseInt(matcher.group())); // convert to int
				}
			}
		}
		else if(((JButton)event.getSource()).getText().equals(" ") && secondButton == 2){
			
					
			String regex ="(\\d+)";
			Matcher matcher1 = Pattern.compile( regex ).matcher( ((JButton)event.getSource()).getName().substring(1,2));
			while (matcher1.find()) { // for each match
			    num3 = (Integer.parseInt(matcher1.group())); // convert to int
			}
			Matcher matcher = Pattern.compile( regex ).matcher( ((JButton)event.getSource()).getName().substring(2,3));
			while (matcher.find()) { // for each match
			    num4 = (Integer.parseInt(matcher.group())); // convert to int
			}
			
			if(((num1-num3)*(num1-num3)==1)&&((num2-num4)*(num2-num4)==1)){
				if(num1 - num3 == 1 && op != "o"){
					secondButton = 1;
					whiteTurn = !whiteTurn;
					firstButton = true;
					move();
					((JButton)event.getSource()).setText(op);
				}
				if(num1 - num3 == -1 && op != "�"){
					secondButton = 1;
					whiteTurn = !whiteTurn;
					firstButton = true;
					move();
					((JButton)event.getSource()).setText(op);
				}
			}
			if(((num1-num3)*(num1-num3)==4)&&((num2-num4)*(num2-num4)==4)){
				jump();
				if(jumpTrue){
					((JButton)event.getSource()).setText(op);
				}
			}
		}
		title();
		checkWin();
	}
	public static void move(){
		if(b1 == "b12"){
			b12.setText(" ");
		}
		if(b1 == "b14"){
			b14.setText(" ");
		}
		if(b1 == "b16"){
			b16.setText(" ");
		}
		if(b1 == "b18"){
			b18.setText(" ");
		}
		if(b1 == "b21"){
			b21.setText(" ");
		}
		if(b1 == "b23"){
			b23.setText(" ");
		}
		if(b1 == "b25"){
			b25.setText(" ");
		}
		if(b1 == "b27"){
			b27.setText(" ");
		}
		if(b1 == "b32"){
			b32.setText(" ");
		}
		if(b1 == "b34"){
			b34.setText(" ");
		}
		if(b1 == "b36"){
			b36.setText(" ");
		}
		if(b1 == "b38"){
			b38.setText(" ");
		}
		if(b1 == "b41"){
			b41.setText(" ");
		}
		if(b1 == "b43"){
			b43.setText(" ");
		}
		if(b1 == "b45"){
			b45.setText(" ");
		}
		if(b1 == "b47"){
			b47.setText(" ");
		}
		if(b1== "b52"){
			b52.setText(" ");
		}
		if(b1 == "b54"){
			b54.setText(" ");
		}
		if(b1 == "b56"){
			b56.setText(" ");
		}
		if(b1 == "b58"){
			b58.setText(" ");
		}
		if(b1 == "b61"){
			b61.setText(" ");
		}
		if(b1 == "b63"){
			b63.setText(" ");
		}
		if(b1 == "b65"){
			b65.setText(" ");
		}
		if(b1 == "b67"){
			b67.setText(" ");
		}
		if(b1 == "b72"){
			b72.setText(" ");
		}
		if(b1 == "b74"){
			b74.setText(" ");
		}
		if(b1 == "b76"){
			b76.setText(" ");
		}
		if(b1 == "b78"){
			b78.setText(" ");
		}
		if(b1 == "b81"){
			b81.setText(" ");
		}
		if(b1 == "b83"){
			b83.setText(" ");
		}
		if(b1 == "b85"){
			b85.setText(" ");
		}
		if(b1 == "b87"){
			b87.setText(" ");
		}
	}
	public static void jump(){
		if(num1 - num3 == 2 && num2 - num4 == 2 && op != "o"){
			b2 = "b" + (num1 - 1) + (num2 - 1);
		}
		if(num1 - num3 == 2 && num2 - num4 == -2 && op != "o"){
			b2 = "b" + (num1 - 1) + (num2 + 1);
		}
		if(num1 - num3 == -2 && num2 - num4 == 2 && op != "�"){
			b2 = "b" + (num1 + 1) + (num2 - 1);
		}
		if(num1 - num3 == -2 && num2 - num4 == -2 && op != "�"){
			b2 = "b" + (num1 + 1) + (num2 + 1);
		}
		jumpTrue = false;
		if(b2.substring(1,3).equals("12") &&!b12.getText().equals(" ")&&!b12.getText().startsWith(op.substring(0, 1))){
			b12.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("14") &&!b14.getText().equals(" ")&&!b14.getText().startsWith(op.substring(0, 1))){
			b14.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("16") &&!b16.getText().equals(" ")&&!b16.getText().startsWith(op.substring(0, 1))){
			b16.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("18") &&!b18.getText().equals(" ")&&!b18.getText().startsWith(op.substring(0, 1))){
			b18.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("21") &&!b21.getText().equals(" ")&&!b21.getText().startsWith(op.substring(0, 1))){
			b21.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("23") &&!b23.getText().equals(" ")&&!b23.getText().startsWith(op.substring(0, 1))){
			b23.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("25") &&!b25.getText().equals(" ")&&!b25.getText().startsWith(op.substring(0, 1))){
			b25.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("27") &&!b27.getText().equals(" ")&&!b27.getText().startsWith(op.substring(0, 1))){
			b27.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("32") &&!b32.getText().equals(" ")&&!b32.getText().startsWith(op.substring(0, 1))){
			b32.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("34") &&!b34.getText().equals(" ")&&!b34.getText().startsWith(op.substring(0, 1))){
			b34.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("36") &&!b36.getText().equals(" ")&&!b36.getText().startsWith(op.substring(0, 1))){
			b36.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("38") &&!b38.getText().equals(" ")&&!b38.getText().startsWith(op.substring(0, 1))){
			b38.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("41") &&!b41.getText().equals(" ")&&!b41.getText().startsWith(op.substring(0, 1))){
			b41.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("43") &&!b43.getText().equals(" ")&&!b43.getText().startsWith(op.substring(0, 1))){
			b43.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("45") &&!b45.getText().equals(" ")&&!b45.getText().startsWith(op.substring(0, 1))){
			b45.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("47") &&!b47.getText().equals(" ")&&!b47.getText().startsWith(op.substring(0, 1))){
			b47.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("52") &&!b52.getText().equals(" ")&&!b52.getText().startsWith(op.substring(0, 1))){
			b52.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("54") &&!b54.getText().equals(" ")&&!b54.getText().startsWith(op.substring(0, 1))){
			b54.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("56")&&(!b56.getText().equals(" ")&&!b56.getText().startsWith(op.substring(0, 1)))){
			b56.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("58") &&!b58.getText().equals(" ")&&!b58.getText().startsWith(op.substring(0, 1))){
			b58.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("61") &&!b61.getText().equals(" ")&&!b61.getText().startsWith(op.substring(0, 1))){
			b61.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("63") &&!b63.getText().equals(" ")&&!b63.getText().startsWith(op.substring(0, 1))){
			b63.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("65") &&!b65.getText().equals(" ")&&!b65.getText().startsWith(op.substring(0, 1))){
			b65.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("67") &&!b67.getText().equals(" ")&&!b67.getText().startsWith(op.substring(0, 1))){
			b67.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("72") &&!b72.getText().equals(" ")&&!b72.getText().startsWith(op.substring(0, 1))){
			b72.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("74") &&!b74.getText().equals(" ")&&!b74.getText().startsWith(op.substring(0, 1))){
			b74.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("76") &&!b76.getText().equals(" ")&&!b76.getText().startsWith(op.substring(0, 1))){
			b76.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("78") &&!b78.getText().equals(" ")&&!b78.getText().startsWith(op.substring(0, 1))){
			b78.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("81") &&!b81.getText().equals(" ")&&!b81.getText().startsWith(op.substring(0, 1))){
			b81.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("83") &&!b83.getText().equals(" ")&&!b83.getText().startsWith(op.substring(0, 1))){
			b83.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("85") && !b85.getText().equals(" ") &&!b85.getText().startsWith(op.substring(0, 1))){
			b85.setText(" ");
			jumpTrue = true;
		}
		if(b2.substring(1,3).equals("87") &&!b87.getText().equals(" ")&&!b87.getText().startsWith(op.substring(0, 1))){
			b87.setText(" ");
			jumpTrue = true;
		}
		if(jumpTrue){
			move();
			secondButton = 1;
			whiteTurn = !whiteTurn;
			firstButton = true;
			if(op=="o"){
				blackGone += 1;
			}
			else if(op=="�"){
				whiteGone += 1;
			}
		}
	}
	public static void title(){
		if(b12.getText().equals("�")){
			b12.setText("��");
			blackGone -= 1;
		}
		if(b14.getText().equals("�")){
			b14.setText("��");
			blackGone -= 1;
		}
		if(b16.getText().equals("�")){
			b16.setText("��");
			blackGone -= 1;
		}
		if(b18.getText().equals("�")){
			b18.setText("��");
			blackGone -= 1;
		}
		if(b81.getText().equals("o")){
			b81.setText("oo");
			whiteGone -= 1;
		}
		if(b83.getText().equals("o")){
			b83.setText("oo");
			whiteGone -= 1;
		}
		if(b85.getText().equals("o")){
			b85.setText("oo");
			whiteGone -= 1;
		}
		if(b87.getText().equals("o")){
			b87.setText("oo");
			whiteGone -= 1;
		}
		//numMenu.setText(" num1: " + num1 + " num2: " + num2 + " num3: " + num3 + " num4: " + num4);
		frame.setTitle(b1 + " " + b2 + " " + op + " " + whiteTurn + " " + winner);
	}
	public static void checkWin(){
		if(!b12.getText().startsWith("�")&&!b14.getText().startsWith("�")&&!b16.getText().startsWith("�")&&!b18.getText().startsWith("�")
		&&!b21.getText().startsWith("�")&&!b23.getText().startsWith("�")&&!b25.getText().startsWith("�")&&!b27.getText().startsWith("�")
		&&!b32.getText().startsWith("�")&&!b34.getText().startsWith("�")&&!b36.getText().startsWith("�")&&!b38.getText().startsWith("�")
		&&!b41.getText().startsWith("�")&&!b43.getText().startsWith("�")&&!b45.getText().startsWith("�")&&!b47.getText().startsWith("�")
		&&!b52.getText().startsWith("�")&&!b54.getText().startsWith("�")&&!b56.getText().startsWith("�")&&!b58.getText().startsWith("�")
		&&!b61.getText().startsWith("�")&&!b63.getText().startsWith("�")&&!b65.getText().startsWith("�")&&!b67.getText().startsWith("�")
		&&!b72.getText().startsWith("�")&&!b74.getText().startsWith("�")&&!b76.getText().startsWith("�")&&!b78.getText().startsWith("�")
		&&!b81.getText().startsWith("�")&&!b83.getText().startsWith("�")&&!b85.getText().startsWith("�")&&!b87.getText().startsWith("�")){
			winner = "white";
			win();
		}
		if(!b12.getText().startsWith("o")&&!b14.getText().startsWith("o")&&!b16.getText().startsWith("o")&&!b18.getText().startsWith("o")
		&&!b21.getText().startsWith("o")&&!b23.getText().startsWith("o")&&!b25.getText().startsWith("o")&&!b27.getText().startsWith("o")
		&&!b32.getText().startsWith("o")&&!b34.getText().startsWith("o")&&!b36.getText().startsWith("o")&&!b38.getText().startsWith("o")
		&&!b41.getText().startsWith("o")&&!b43.getText().startsWith("o")&&!b45.getText().startsWith("o")&&!b47.getText().startsWith("o")
		&&!b52.getText().startsWith("o")&&!b54.getText().startsWith("o")&&!b56.getText().startsWith("o")&&!b58.getText().startsWith("o")
		&&!b61.getText().startsWith("o")&&!b63.getText().startsWith("o")&&!b65.getText().startsWith("o")&&!b67.getText().startsWith("o")
		&&!b72.getText().startsWith("o")&&!b74.getText().startsWith("o")&&!b76.getText().startsWith("o")&&!b78.getText().startsWith("o")
		&&!b81.getText().startsWith("o")&&!b83.getText().startsWith("o")&&!b85.getText().startsWith("o")&&!b87.getText().startsWith("o")){
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
			winLabel.setText("� wins");
		}
	}
	public static void setLabel(){
		
	}
	
}
