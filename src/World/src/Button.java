import java.awt.*;
import java.awt.geom.*;

public class Button{
	private double x;
	private double y;
	private double width;
	private double height;
	private Rectangle2D button;
	private String text;
	private Point2D textCoordinates;
	private Color buttonColor = Color.LIGHT_GRAY;
	private Color textColor = Color.BLACK;
	private Font font = new Font("Arial",Font.PLAIN, 25);
	public Button(String text, double x, double y, double width, double height){
		this.text = text;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.textCoordinates = new Point2D.Double(x+5,y+height/2+font.getSize()/5);
		button = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
	}
	public void setX(double x){
		this.x = x;
		button = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
	}
	public void setY(double y){
		this.y = y;
		button = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
	}
	public void setWidth(double width){
		this.width = width;
		button = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
	}
	public void setHeight(double height){
		this.height = height;
		button = new Rectangle2D.Double (this.x, this.y, this.width, this.height);
	}
	public void setTextCoordinates(Point2D coords){
		this.textCoordinates = coords;
	}
	public void setText(String text){
		this.text = text;
	}
	public void setButtonColor(Color color){
		this.buttonColor = color;
	}
	public void setTextColor(Color color){
		this.textColor = color;
	}
	public void setFont(Font font){
		this.font = font;
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
	public String getText(){
		return this.text;
	}
	public Point2D getTextCoordinates(){
		return this.textCoordinates;
	}
	public Color getButtonColor(){
		return this.buttonColor;
	}
	public Color getTextColor(){
		return this.textColor;
	}
	public Font getFont(){
		return this.font;
	}
	public void setButton(Rectangle2D button){
		this.button = button;
	}
	
	public void setButton(double x, double y, double width, double height){
		this.button = new Rectangle2D.Double(x,y,width,height);
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	public Rectangle2D getButton(){
		return new Rectangle2D.Double (this.x,this.y,this.width,this.height);
	}
	
}
