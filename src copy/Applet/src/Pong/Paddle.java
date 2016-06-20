package Pong;
import java.awt.geom.Rectangle2D;

public class Paddle{
	private double x;
	private double y;
	private double width;
	private double height;
	private Rectangle2D pad;
	private Double yVelocity;
	private int points;
	private Double velocityMultiplier = 1.0; //Used for bonuses like freeze and 2x speed, set to 1 so it doesnt change at the beginning
	
	public Paddle(double x, double y, double width, double height){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		pad = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
	}
	public void setX(double x){
		this.x = x;
		pad = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
	}
	public void setY(double y){
		this.y = y;
		pad = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
	}
	public void setWidth(double width){
		this.width = width;
		pad = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
	}
	public void setHeight(double height){
		this.height = height;
		pad = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
	}
	public void setYVelocity(double velocity){
		this.yVelocity = velocity;
	}
	public void setPoints(int points){
		this.points = points;
	}
	public void setVelocityMultiplier(Double multiplier){
		this.velocityMultiplier = multiplier;
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
	public int getPoints(){
		return this.points;
	}
	public Double getVelocityMultiplier(){
		return this.velocityMultiplier;
	}
	public void setPad(Rectangle2D pad){
		this.pad = pad;
	}
	public void setPad(double x, double y, double width, double height){
		this.pad = new Rectangle2D.Double(x,y,width,height);
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	public Rectangle2D getPad(){
		return new Rectangle2D.Double (this.x,this.y,this.width,this.height);
	}
	public Boolean intersects(Rectangle2D obj){
		if(pad.intersects(obj)){
			return true;
		} else {
			return false;
		}
	}
	
}
