import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

import javax.swing.*;


public class chess implements ActionListener{
	public static JFrame frame;
	public static Container content;
	public static JButton restart;
	public static JButton[][] button = new JButton[8][];
	public static boolean whiteTurn = true, firstButton = true, jumpTrue;
	public static JLabel winLabel, whiteLabel, blackLabel;
	public static String b1 = "", b2 = " ",op = "", winner = " ";  
	public static Integer whiteGone = 0, blackGone = 0, secondButton = 1, a;
	public static int buttonX = 0, buttonY = 0, button2X = 0, button2Y = 0;
	public static Color black = new Color(0,0,0), red = new Color(255,0,0);
	int buttonColor = 0;
	public static JMenu numMenu;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chess ttt = new chess();
	}
	
	
	public chess(){
		frame = new JFrame();
		frame.setSize(400,700);
		frame.setTitle("Chess");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		content=frame.getContentPane();
		JMenuBar menubar;
		menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		JMenu menu;
		
		menu = new JMenu("Switch turn");
		numMenu = new JMenu(" buttonX: " + buttonX + " buttonY " + buttonY + " button2X " + button2X + " num2Y " + button2Y);
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
				buttons();
				frame.setSize(400,480);
			}
		});
		content.add(winLabel);
		content.add(restart);
		for (int i = 0; i < 8; i++){
			button[i] = new JButton[8];
		}
		for(int i = 0; i < button.length; i++){
			for(int j = 0; j < button.length; j++){
				
				button[i][j] = new JButton(); //creates buttons
				button[i][j].setBounds(j*50,i*50,50,50); //defines location and size
				content.add(button[i][j]); //adds them
				button[i][j].addActionListener(this);
				button[i][j].setName(new String("" + i + j)); //sets the names of each button
				
				if(i == 0 || i == button.length - 1){//sets all the pieces
					if(j == 0 || j == 7){
						button[i][j].setText("R");
					}
					if(j == 1 || j == 6){
						button[i][j].setText("Kn");
					}
					if(j == 2 || j == 5){
						button[i][j].setText("B");
					}
					if(j == 3){
						button[i][j].setText("Q");
					}
					if(j == 4){
						button[i][j].setText("K");
					}
				}
				
				if(i == 1 || i == 6){ //sets the pawns
					button[i][j].setText("P");
				}
				
				
				if(i < 2){//sets the colors of the pieces
					button[i][j].setForeground(new Color(255,0,0));
				}
				else if(i > 5){
					button[i][j].setForeground(new Color(0,0,0));
				}
				else{
					button[i][j].setForeground(new Color(238,238,238));
				}
				
				button[i][j].setOpaque(true);
				if(i == 0 || i == 2 || i == 4 || i == 6){ //sets the background colors of the buttons
					if(j == 1 || j == 3 || j == 5 || j == 7){
						button[i][j].setBackground(new Color(0,0,0));
					}
					else {
						button[i][j].setBackground(new Color(255,0,0));
					}
				}
				else{
					if(j == 0 || j == 2 || j == 4 || j == 6){
						button[i][j].setBackground(new Color(0,0,0));
					}
					else{
						button[i][j].setBackground(new Color(255,0,0));
					}
				}
				
			}
		}
		frame.setSize(400, 700);
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public Boolean turnMatchesColor(Boolean turn,Color color){
		boolean isTrue = false;
		if(turn == true && color == new Color(255,0,0)){
			isTrue = true;
		}
		else if(!turn && color == new Color(255,255,255)){
			isTrue = true;
		}
		return isTrue;
	}
	public void actionPerformed(ActionEvent event) {
		String pieceKnockedOff;
		if (!((JButton)event.getSource()).getText().equals(" ")){
			if(turnMatchesColor(whiteTurn,((JButton)event.getSource()).getForeground())){
				b1 = ((JButton)event.getSource()).getName();
				op = ((JButton)event.getSource()).getText();
				//firstButton = false;
				buttonX = ((JButton)event.getSource()).getBounds().x/50;
				buttonY = ((JButton)event.getSource()).getBounds().y/50;
				buttonColor = ((JButton)event.getSource()).getForeground().getRGB();
			}
		}
		if(b1 != "" && ((JButton)event.getSource()).getText().equals(" ") || ((whiteTurn && !((JButton)event.getSource()).getForeground().equals(new Color(255,0,0)) && !((JButton)event.getSource()).getText().equals("")) || (!whiteTurn && !((JButton)event.getSource()).getForeground().equals(new Color(255,255,255)) && !((JButton)event.getSource()).getText().equals("")))){
				//SecondButton
				button2X = ((JButton)event.getSource()).getBounds().x/50;
				button2Y = ((JButton)event.getSource()).getBounds().y/50;
				
				if(op.equals("R")){
					if(buttonX == button2X || buttonY == button2Y){
						if(buttonX == button2X){
							if(buttonY < button2Y){
								Boolean somethingInTheWay = false;
								for(int i = buttonY; i < button2Y; i++){
									if(button[buttonX][i].getText() != ""){
										somethingInTheWay = true;
									}
								}
								if(!somethingInTheWay){
									whiteTurn = !whiteTurn;
									firstButton = true;
									button[buttonY][buttonX].setText(" ");
									button[button2Y][button2X].setText(op);
								}
							}
							else{
								Boolean somethingInTheWay = false;
								for(int i = button2Y; i < buttonY; i++){
									if(button[buttonX][i].getText() != ""){
										somethingInTheWay = true;
									}
								}
								if(!somethingInTheWay){
									whiteTurn = !whiteTurn;
									firstButton = true;
									button[buttonY][buttonX].setText(" ");
									button[button2Y][button2X].setText(op);
								}
							}
						}
						else {
							if(buttonX < button2X){
								Boolean somethingInTheWay = false;
								for(int i = buttonX; i < button2X; i++){
									if(button[i][buttonY].getText() != ""){
										somethingInTheWay = true;
									}
								}
								if(!somethingInTheWay){
									whiteTurn = !whiteTurn;
									firstButton = true;
									button[buttonY][buttonX].setText(" ");
									button[button2Y][button2X].setText(op);
								}
							}
							else{
								Boolean somethingInTheWay = false;
								for(int i = button2X; i < buttonX; i++){
									if(button[i][buttonY].getText() != ""){
										somethingInTheWay = true;
									}
								}
								if(!somethingInTheWay){
									whiteTurn = !whiteTurn;
									firstButton = true;
									button[buttonY][buttonX].setText(" ");
									button[button2Y][button2X].setText(op);
								}
							}
						}
						/*whiteTurn = !whiteTurn;
						firstButton = true;
						button[buttonY][buttonX].setText(" ");
						button[button2Y][button2X].setText(op);*/
						//if(!((JButton)event.getSource()).getForeground().equals(new Color(238,238,238))){
							//pieceKnockedOff = ((JButton)event.getSource()).getText();
						//}
					}
				}
				if(op.equals("P")){
					if(buttonRGB == new Color())
					/*if(buttonX == button2X && (buttonY - button2Y)*(buttonY - button2Y) == 1){
						whiteTurn = !whiteTurn;
						firstButton = true;
						button[buttonY][buttonX].setText(" ");
						button[button2Y][button2X].setText(op);
						if(!((JButton)event.getSource()).getForeground().equals(new Color(238,238,238))){
							pieceKnockedOff = ((JButton)event.getSource()).getText();
						}
					}*/
					
				}
			
		}
		
		title();
		//checkWin();
	}
	public static void title(){
		numMenu.setText(" buttonX: " + buttonX + " buttonY " + buttonY + " button2X " + button2X + " num2Y " + button2Y);
		frame.setTitle("Whites Turn:" + whiteTurn);
	}
	public static void checkWin(){
		
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
}
