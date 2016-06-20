package Pong;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;

import javax.swing.*;

import java.applet.*;
public class Pong extends Applet implements KeyListener, ActionListener, MouseListener{
	Paddle player;
	Paddle computer;
	Puck ball;
	Boolean onMenu = true, Started = false;
	//double computerYAcceleration;
	//int playerPoints = 0;
	//int computerPoints = 0;
	Button start;
	
	Button onePlayer, twoPlayer;
	Button easy, medium, impossible;
	
	
	Boolean downPressed = false, upPressed = false, wPressed = false, sPressed = false;
	Double defaultSpeed = 0.75;

	Boolean playerHitLast = null; 
	Boolean theresAPowerUp = false;
	//Button doubleSpeed, doubleLength, freeze, plus10, plus100;
	Button power = new Button("",0,0,80,25);
	Boolean playerDoubleSpeed = false, computerDoubleSpeed = false;
	Boolean playerDoubleLength = false, computerDoubleLength = false;
	Boolean playerFrozen = false, computerFrozen = false;

	int numOfPlayers = 1;
	int difficulty = 1;
	public void init(){
		setSize(500,500);
		addKeyListener(this);
		addMouseListener(this);

		player = new Paddle(480,215,20,70);
		player.setYVelocity(defaultSpeed);

		player.setPoints(0);
		player.setPoints(0);
		computer = new Paddle(0,215,20,70);
		computer.setYVelocity(defaultSpeed);

		ball = new Puck(this.getWidth()/2 - 15,this.getHeight()/2 - 15,30,30);
		ball.setVelocity(0, 0);

		start = new Button("Start",216.5,400,67,25); //25 is optimal height for a button
		onePlayer = new Button("One Player", 100, 100, 140, 25);
		onePlayer.setButtonColor(Color.GRAY);
		twoPlayer = new Button("Two Player", 260, 100, 140, 25);

		easy = new Button("     Easy", 20, 250, 140, 25);
		easy.setButtonColor(Color.GRAY);
		medium = new Button("   Medium", 180 ,250, 140, 25);
		impossible = new Button("Impossible", 340, 250, 140, 25);
	}
	public void paint(Graphics g){

		Graphics2D g2 = (Graphics2D) g;
		setBackground(Color.black);
		g2.setFont(new Font("Arial",Font.PLAIN, 25));

		if(!onMenu){
			
			g2.setColor(Color.blue);

			g2.fill(new Rectangle2D.Double(player.getX(),player.getY(),player.getWidth(),player.getHeight()));
			g2.fill(new Rectangle2D.Double(computer.getX(),computer.getY(),computer.getWidth(),computer.getHeight()));

			g2.setColor(Color.green);


			updateBall();
			updateComputer();
			updatePlayer();
			addPowerUp(g2);
			checkForWin();
			g2.fill(new Ellipse2D.Double(ball.getX(),ball.getY(),ball.getWidth(),ball.getHeight()));
			if(!Started){
				g.drawString("Press Space to Start", 135, 50);
			}
			if(numOfPlayers == 1){
				g2.drawString("P1: " + player.getPoints(), 400, 20);
				g2.drawString("Com: " + computer.getPoints(), 20, 20);
			} else {
				g2.drawString("P2: " + player.getPoints(), 400, 20);
				g2.drawString("P1: " + computer.getPoints(), 20, 20);
			}
		} else {

			g2.setColor(Color.green);
			g2.drawString("Pong", 215, 50);
			drawButton(g2, start);
			drawButton(g2, onePlayer);
			drawButton(g2, twoPlayer);
			drawButton(g2, easy);
			drawButton(g2, medium);
			drawButton(g2, impossible);

		}
		repaint();
	}
	public void drawButton(Graphics2D g2, Button b){
		Color startColor = g2.getColor();
		Font startFont = g2.getFont();
		g2.setColor(b.getButtonColor());
		g2.fill(new Rectangle2D.Double(b.getX(), b.getY(), b.getWidth(), b.getHeight()));
		g2.setFont(b.getFont());
		g2.setColor(b.getTextColor());
		g2.drawString(b.getText(), (float) b.getTextCoordinates().getX(), (float) b.getTextCoordinates().getY());
		g2.setFont(startFont);
		g2.setColor(startColor);
	}

	public void checkForWin() {
		// TODO Auto-generated method stub
		if(ball.getX() + ball.getWidth() < 0){
			player.setPoints(player.getPoints() + 1);
			restartRound();
		} else if(ball.getX() > this.getWidth()){
			computer.setPoints(computer.getPoints() + 1);
			restartRound();
		}
	}
	public void updateComputer() {
		// TODO Auto-generated method stub
		if(numOfPlayers == 1){
			if(computer.getY() < 0 || computer.getY() + computer.getHeight() > this.getHeight()){
				computer.setYVelocity(-computer.getYVelocity());
				//computerYAcceleration *= -1;
			}
		} else if (numOfPlayers == 2) {
			if(wPressed){
				if(computer.getY() > 0){
					computer.setYVelocity(-defaultSpeed);
				} else {
					computer.setYVelocity(0.0);
				}
			} else if(sPressed){
				if(computer.getY() < this.getHeight() - computer.getHeight()){
					computer.setYVelocity(defaultSpeed);
				} else {
					computer.setYVelocity(0.0);
				}
			} else {
				computer.setYVelocity(0.0);
			}
		}
		computer.setYVelocity(computer.getYVelocity()*computer.getVelocityMultiplier());
		if(difficulty == 3 && numOfPlayers == 1 && computer.getVelocityMultiplier() > 0.0){
			computer.setY((ball.getY() + ball.getHeight()/2) - computer.getHeight()/2); //ball follow
		} else {
			computer.setY(computer.getY() + computer.getYVelocity());
		}


	}

	public void updateBall(){
		if(!ball.getBounced()){
			if(ball.intersects(player.getPad()) || ball.intersects(computer.getPad())){
				ball.setVelocity(-ball.getVelocity().getX(), ball.getVelocity().getY());
				if(difficulty == 2){
					double computerYAccelerationRandom = Math.random()*(2)-1;
					ball.setVelocity(ball.getVelocity().getX(), computerYAccelerationRandom);
				}
				ball.setBounced(true);
				if(ball.intersects(player.getPad())){
					playerHitLast = true;
				} else if(ball.intersects(computer.getPad())){
					playerHitLast = false;
				}
			}
			if(ball.getY() < 0 || ball.getY() + ball.getHeight() > this.getHeight()){
				ball.setVelocity(ball.getVelocity().getX(), -ball.getVelocity().getY());
				ball.setBounced(true);
			}
		} else {
			if(ball.intersects(player.getPad()) || ball.intersects(computer.getPad())){

			} else if(ball.getY() < 0 || ball.getY() + ball.getHeight() > this.getHeight()){

			} else {
				ball.setBounced(false);
			}
		}

		ball.setX(ball.getX() + ball.getVelocity().getX());
		ball.setY(ball.getY() + ball.getVelocity().getY());

	}
	public void updatePlayer(){

		if(upPressed){
			if(player.getY() > 0){
				player.setYVelocity(-defaultSpeed);
			} else {
				player.setYVelocity(0.0);
			}
		} else if (downPressed){
			if(player.getY() < this.getHeight() - player.getHeight()){
				player.setYVelocity(defaultSpeed);
			} else {
				player.setYVelocity(0.0);
			}
		} else {
			player.setYVelocity(0.0);
		}
		player.setYVelocity(player.getYVelocity()*player.getVelocityMultiplier());
		player.setY(player.getY() + player.getYVelocity());
	}

	public void addPowerUp(Graphics2D g2){
		if(Started){
			if(!theresAPowerUp){
				double Random = Math.random();
				if(Random <= 0.001){
					Double xCoord = Math.random()*(400-power.getWidth()-100) + 100;
					Double yCoord = Math.random()*(400-power.getHeight()-100) + 100;
					power = new Button(power.getText(),xCoord, yCoord, power.getWidth(), power.getHeight());

					Random = Math.random();
					power.setTextCoordinates(new Point2D.Double(power.getX()+5,power.getY()+22));
					if(Random <= 0.25){
						if(Random <= 0.01){
							power.setText(" +100");
							//plus100 = new Button("+100", )
						} else {
							power.setText("  +10");
						}
					} else if (Random > 0.25 && Random <= 0.5){
						power.setText("Freeze");
						power.setTextCoordinates(new Point2D.Double(power.getTextCoordinates().getX()-5,power.getTextCoordinates().getY()));
					} else if (Random > 0.5 && Random <= 0.75){
						power.setText("+Speed");
						power.setTextCoordinates(new Point2D.Double(power.getTextCoordinates().getX()-5,power.getTextCoordinates().getY()));
					} else {
						power.setText("+Length");
						power.setTextCoordinates(new Point2D.Double(power.getTextCoordinates().getX()-5,power.getTextCoordinates().getY()));
					}

					power.setButtonColor(Color.BLUE);
					power.setTextColor(Color.WHITE);
					power.setFont(new Font("Arial", Font.PLAIN, 22));

					theresAPowerUp = true;

				}
			} else {
				drawButton(g2, power);
				if(ball.intersects(power.getButton())){
					if(playerHitLast != null){
						if(playerHitLast == true){
							if(power.getText().endsWith("+10")){
								player.setPoints(player.getPoints() + 10);
							} else if(power.getText().endsWith("+100")){
								player.setPoints(player.getPoints() + 100);
							} else if(power.getText().endsWith("+Length")){
								player.setHeight(player.getHeight() * 2);
							} else if(power.getText().endsWith("+Speed")){
								player.setVelocityMultiplier(2.0);
							} else if(power.getText().endsWith("Freeze")){
								computer.setVelocityMultiplier(0.0);
							} 
						} else {
							if(power.getText().endsWith("+10")){
								computer.setPoints(computer.getPoints() + 10);
							} else if(power.getText().endsWith("+100")){
								computer.setPoints(computer.getPoints() + 100);
							} else if(power.getText().endsWith("+Length")){
								computer.setHeight(computer.getHeight() * 2);
							} else if(power.getText().endsWith("+Speed")){
								computer.setVelocityMultiplier(2.0);
							} else if(power.getText().endsWith("Freeze")){
								player.setVelocityMultiplier(0.0);
							} 
						}
						theresAPowerUp = false;
					}
				}
			}
		}
	}
	public void startRound(){
		Started = true;
		double yRandom = (Math.random()*0.7-0.35);
		double xRandom = (Math.random()*1.4-0.7);
		if(Math.abs(xRandom) < 0.35){
			if(xRandom < 0){
				xRandom -= 0.35;
			} else {
				xRandom += 0.35;
			}
		}
		while(Math.sqrt(Math.pow(xRandom,2) + Math.pow(yRandom,2)) > 0.7){
			xRandom *= 0.8;
			yRandom *= 0.8;
		}
		ball.setVelocity(xRandom, yRandom);



		//computerYAccelerationRandom = Math.atan(Math.sqrt(Math.pow(xRandom,2) + Math.pow(yRandom,2)));
		//System.out.println(Math.atan(Math.sqrt(Math.pow(xRandom,2) + Math.pow(yRandom,2))));
		//computerYAcceleration = Math.sin(Math.atan(Math.sqrt(Math.pow(xRandom,2) + Math.pow(yRandom,2))));
		//System.out.println(computerYAcceleration);
		player.setYVelocity(0.5);
		if(numOfPlayers == 1){
			double computerYAccelerationRandom = Math.random();
			if((computerYAccelerationRandom) < 0.5){
				computerYAccelerationRandom += 0.5;
			}
			if(yRandom < 0){ //If the ball is going up, make the computer paddle go up
				computerYAccelerationRandom *= -1;
			}
			computer.setYVelocity(computerYAccelerationRandom);
		} else if (numOfPlayers == 2){
			computer.setYVelocity(defaultSpeed);
		}

	}
	public void restartRound(){
		Started = false;
		player.setPad(480,215,20,70);
		computer.setPad(0,215,20,70);
		computer.setYVelocity(0.0);

		ball = new Puck(this.getWidth()/2 - 15,this.getHeight()/2 - 15,30,30);
		ball.setVelocity(0, 0);

		upPressed = false;
		downPressed = false;
		wPressed = false;
		sPressed = false;

		theresAPowerUp = false;

		player.setVelocityMultiplier(1.0);
		computer.setVelocityMultiplier(1.0);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(!onMenu){
			if(Started){
				switch (e.getKeyCode()){
				case KeyEvent.VK_UP:
					upPressed = true;
					break;
				case KeyEvent.VK_DOWN:
					downPressed = true;
					break;
				case KeyEvent.VK_W:
					if(numOfPlayers == 2){
						wPressed = true;
					}
					break;
				case KeyEvent.VK_S:
					if(numOfPlayers == 2){
						sPressed = true;
					}
					break;
				}
			} else {
				switch (e.getKeyCode()){
				case KeyEvent.VK_SPACE:
					startRound();
					break;
				case KeyEvent.VK_ESCAPE:
					onMenu = true;
					break;
				}

			}
		} else {

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(!onMenu){
			if(Started){
				switch (e.getKeyCode()){
				case KeyEvent.VK_UP:
					upPressed = false;
					//player.setY(player.getY()-20);
					break;
				case KeyEvent.VK_DOWN:
					downPressed = false;
					//player.setY(player.getY()+20);
					break;
				case KeyEvent.VK_W:
					if(numOfPlayers == 2){
						wPressed = false;
						//computer.setY(computer.getY()-20);
					}
					break;
				case KeyEvent.VK_S:
					if(numOfPlayers == 2){
						sPressed = false;
						//computer.setY(computer.getY()+20);
					}
					break;
				}
			}
		} 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Pressed");
		Rectangle2D.Double mouseCoords = new Rectangle2D.Double(e.getX(), e.getY(),1,1);
		if(mouseCoords.intersects(start.getButton())){
			restartRound();
			onMenu = false;
			player.setPoints(0);
			computer.setPoints(0);
		}
		if(mouseCoords.intersects(onePlayer.getButton())){
			numOfPlayers = 1;
			onePlayer.setButtonColor(Color.GRAY);
			twoPlayer.setButtonColor(Color.LIGHT_GRAY);
		} else if (mouseCoords.intersects(twoPlayer.getButton())){
			numOfPlayers = 2;
			twoPlayer.setButtonColor(Color.GRAY);
			onePlayer.setButtonColor(Color.LIGHT_GRAY);
		}

		if(mouseCoords.intersects(easy.getButton())){
			difficulty = 1;
			easy.setButtonColor(Color.GRAY);
			medium.setButtonColor(Color.LIGHT_GRAY);
			impossible.setButtonColor(Color.LIGHT_GRAY);
		} else if (mouseCoords.intersects(medium.getButton())){
			difficulty = 2;
			easy.setButtonColor(Color.LIGHT_GRAY);
			medium.setButtonColor(Color.GRAY);
			impossible.setButtonColor(Color.LIGHT_GRAY);
		} else if (mouseCoords.intersects(impossible.getButton())){
			difficulty = 3;
			easy.setButtonColor(Color.LIGHT_GRAY);
			medium.setButtonColor(Color.LIGHT_GRAY);
			impossible.setButtonColor(Color.GRAY);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
