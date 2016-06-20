package Pong;
import java.awt.*;
import java.awt.geom.*;

public class Puck{
	private double x;
	private double y;
	private double width;
	private double height;
	private Rectangle2D circle;
	private Point2D velocity;
	private Boolean bounced;
	public Puck(double x, double y, double width, double height){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.circle = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
		this.velocity = new Point(0,0);
		this.bounced = false;
	}
	public void setX(double x){
		this.x = x;
		this.circle = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
	}
	public void setY(double y){
		this.y = y;
		this.circle = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
	}
	public void setWidth(double width){
		this.width = width;
		this.circle = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
	}
	public void setHeight(double height){
		this.height = height;
		this.circle = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
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
	public void setVelocity(double x, double y){
		this.velocity = new Point2D.Double(x,y);
	}
	public Point2D getVelocity(){
		return this.velocity;
	}
	public void setCircle(Rectangle circle){
		this.circle = circle;
	}
	public void setCircle(int x, int y, int width, int height){
		this.circle = new Rectangle(x,y,width,height);
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	public Rectangle2D.Double getCircle(){
		return new Rectangle2D.Double(this.x,this.y,this.width,this.height);
	}
	public void setBounced(Boolean bounced){
		this.bounced = bounced;
	}
	public Boolean getBounced(){
		return this.bounced;
	}
	public Boolean intersects(Rectangle2D obj){
		if(circle.intersects(obj)){
			return true;
		} else {
			return false;
		}
	}
	
}
