package flappyBall;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class flappyEric extends Applet implements MouseListener, KeyListener, Serializable{
	Ball ball;
	Pipe pipe1, pipe2;
	Image image;
	Boolean started = false;
	int pipesPassed = 0;
	int record = 0;
	Boolean typingName = false;
	String name;
	String[] names = new String[]{"greg","aaron","zach","jason","jacob","kadden","isaac", "ben", "grant", "noah"};
	Boolean keysPressed[] = new Boolean[222]; //For if the key is pressed http://www.cambiaresearch.com/articles/15/javascript-key-codes

	///MenuBar menuBar;
	public void init(){
		for(int i = 0; i < keysPressed.length; i++){
			keysPressed[i] = false;
		}
		setSize(500,500);
		addMouseListener(this);
		addKeyListener(this);
		ball = new Ball(150,235,80,80);
		pipe1 = new Pipe(100,150);
		pipe2 = new Pipe(125,125);
		
		restart();
	}
	public void paint(Graphics g){

		Graphics2D g2 = (Graphics2D) g;
		setBackground(Color.white);
		g2.setColor(Color.green);
		updateBall();
		//g2.fill(new Ellipse2D.Double(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight()));
		g2.drawImage(ball.getImage(),(int) ball.getX(),(int) ball.getY(), (int) ball.getWidth(),(int) ball.getHeight(), this);
		updatePipes();
		g2.fill(new Rectangle2D.Double(pipe1.getTopPipe().getX(),pipe1.getTopPipe().getY(),pipe1.getTopPipe().getWidth(),pipe1.getTopPipe().getHeight()));
		g2.fill(new Rectangle2D.Double(pipe1.getBottomPipe().getX(),pipe1.getBottomPipe().getY(),pipe1.getBottomPipe().getWidth(),pipe1.getBottomPipe().getHeight()));

		g2.fill(new Rectangle2D.Double(pipe2.getTopPipe().getX(),pipe2.getTopPipe().getY(),pipe2.getTopPipe().getWidth(),pipe2.getTopPipe().getHeight()));
		g2.fill(new Rectangle2D.Double(pipe2.getBottomPipe().getX(),pipe2.getBottomPipe().getY(),pipe2.getBottomPipe().getWidth(),pipe2.getBottomPipe().getHeight()));

		g2.setColor(Color.black);

		g2.drawString("Current: " + pipesPassed + " Record " + record, 20, 20);
		repaint();
	}
	public void updateBall() {
		// TODO Auto-generated method stub
		if(started){
			ball.setY(ball.getY() + ball.getYVelocity());
			ball.setYVelocity(ball.getYVelocity() + 0.004);
			if(ball.getY() > 500){
				restart();
			}
		}
	}
	public void updatePipes() {
		if(started){
			if(pipe1.getX() + 30 <= 0){
				pipe1.setX(530.0);
				pipe1.randomizePipe();
				pipesPassed++;
			}
			if(pipe2.getX() + 30 <= 0){
				pipe2.setX(530.0);
				pipe2.randomizePipe();
				pipesPassed++;
			}
			pipe1.setX(pipe1.getX() - 1);
			pipe2.setX(pipe2.getX() - 1);
			if(pipe1.intersects(ball.getBounds()) || pipe2.intersects(ball.getBounds())){
				restart();
			}
		}
		if(pipesPassed > record){
			record = pipesPassed;
		}
	}
	public void restart() {
		started = false;
		ball.setY(235);
		ball.setYVelocity(0);
		pipe1.setX(780.0);
		pipe1.randomizePipe();
		pipe2.setX(1060.0);
		pipe2.randomizePipe();
		pipesPassed = 0;
		String newPlayer = names[(int)(Math.random()*9)];
		ball.setImage("pictures/" + newPlayer + ".png");
	}
	public void startRound(){
		started = true;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!started){
			startRound();
			ball.setYVelocity(-0.75);
		} else{
			ball.setYVelocity(-0.75);
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
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(typingName){

			if(keysPressed[e.getKeyCode()] == false){
				if(e.getKeyCode() == 10){
					typingName = false;
					ball.setImage("pictures/" + name + ".png");
					name = "";
				}else if(e.getKeyCode() == 8){
					name = name.substring(0,name.length()-2);
				} else{
					name += e.getKeyChar();
					keysPressed[e.getKeyCode()] = true;
				}
			}
		} else {
			name = "";
			typingName = true;
			name += e.getKeyChar();
		}
		System.out.println(name);
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keysPressed[e.getKeyCode()] = false;
	}
}
