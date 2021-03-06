package flappyBall;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.*;
import java.io.Serializable;

public class Ball implements Serializable {
	
	private Image image =  Toolkit.getDefaultToolkit().getImage("pictures/greg.png");
	private double x, y, width, height;
	private Rectangle2D bounds;
	private double yVelocity;
	public Ball(double x, double y, double width, double height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public void setX(double x){
		this.x = x;
		this.bounds = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
	}
	public void setY(double y){
		this.y = y;
		this.bounds = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
	}
	public void setWidth(double width){
		this.width = width;
		this.bounds = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
	}
	public void setHeight(double height){
		this.height = height;
		this.bounds = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
	}
	public void setYVelocity(double velocity){
		this.yVelocity = velocity;
	}
	public double getX(){
		return this.x;
	}
	public double getY(){
		return this.y;
	}
	public double getWidth(){
		return this.width;
	}
	public double getHeight(){
		return this.height;
	}
	public double getYVelocity(){
		return this.yVelocity;
	}
	public void setBounds(Rectangle2D bounds){
		this.bounds = bounds;
	}
	public void setBounds(double x, double y, double width, double height){
		this.bounds = new Rectangle2D.Double(x,y,width,height);
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	public Rectangle2D.Double getBounds(){
		return new Rectangle2D.Double(this.x,this.y,this.width,this.height);
	}
	
	public void setImage(Image image){
		this.image = image;
	}
	public void setImage(String imagePath){
		this.image = Toolkit.getDefaultToolkit().getImage(imagePath);
	}
	public Image getImage(){
		return this.image;
	}
}
