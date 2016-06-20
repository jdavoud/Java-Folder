package flappyBall;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class flappyBall extends Applet implements MouseListener{
	Ball ball;
	Pipe pipe1, pipe2;
	Image image;
	Boolean started = false;
	int pipesPassed = 0;
	int record = 0;
	public void init(){
		setSize(500,500);
		addMouseListener(this);
		ball = new Ball(150,235,30,30);
		pipe1 = new Pipe(100,150);
		pipe2 = new Pipe(125,125);
		restart();
	}
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		setBackground(Color.white);
		g2.setColor(Color.green);
		updateBall();
		g2.fill(new Ellipse2D.Double(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight()));
		//g2.drawImage(ball.getImage(),(int) ball.getX(),(int) ball.getY(), (int) ball.getWidth(),(int) ball.getHeight(), this);
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
			ball.setYVelocity(ball.getYVelocity() + 0.008);
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
			pipe1.setX(pipe1.getX() - 0.2);
			pipe2.setX(pipe2.getX() - 0.2);
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
			ball.setYVelocity(-1.35);
		} else{
			ball.setYVelocity(-1.35);
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
