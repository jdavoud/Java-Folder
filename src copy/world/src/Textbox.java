import java.awt.*;
import java.awt.geom.*;

public class Textbox{
	private double x;
	private double y;
	private double width;
	private double height;
	private Rectangle2D button;
	private String text; //Entire text displayed
	private String[] textLines; //Text for each line
	private Point2D[] textCoordinates;
	private Color buttonColor = Color.LIGHT_GRAY;
	private Color textColor = Color.BLACK;
	private int lines;
	private Font font = new Font("Monaco",Font.PLAIN, 25);
	public Textbox(String text, double x, double y, double width, double height, int lines){
		this.text = text;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.lines = lines;
		this.textCoordinates = new Point2D[lines];
		this.setFont(new Font("Monaco", Font.PLAIN, (int)(height/lines/3*2)));//2/3 of the size 
		for(int i = 0; i < textCoordinates.length; i++){
			this.textCoordinates[i] = new Point2D.Double(x+5, y + ((height/lines)*(i) + this.getFont().getSize())); //Is + 1 so that it is the further down
			System.out.println("i: " + i + " x " + this.textCoordinates[i].getX() + " y: " + this.textCoordinates[i].getY());
		}
		
		textLines = new String[lines];
		resetLines();
		//this.textCoordinates = new Point2D[lines].Double(x+5,y+height/2+font.getSize()/5);
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
	public void setTextCoordinates(int line, Point2D coords){
		this.textCoordinates[line] = coords;
	}
	public void setText(String text){
		this.text = text;
		resetLines();
	}
	public void setLines(int lines){
		this.lines = lines;
		resetLines();
	}
	public void resetLines(){
		for(int i = 0; i < textLines.length; i++){
			textLines[i] = ""; //so not null
		}
		int textWidth = (int) (this.width / (this.getFont().getSize()+0.5) * 81/50); //Adjusts to the size of the textbox and 79/50 multiplier for length
		//textWidth = 39;
		System.out.println("Width: " + textWidth + " fontSize: " + this.getFont().getSize());
		//int textWidth = width - 10;//5 pixels on each side of blank space
		//if()
		for(int i = 0; i < text.length(); i += textWidth){
			//System.out.println("i: " + i + " textLength: " + text.length() + " textWidth: " + textWidth);
			int end;
			if(i + (int) (textWidth) < text.length()){ //So no out of bounds exception
				end = i + textWidth;
			} else {
				end = text.length();
			}
			if(i/textWidth < textLines.length){
				textLines[i/textWidth] = text.substring(i,end);
			} else {
				textLines[textLines.length-1] = text.substring(i,end);
			}
		}
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
	public void setTextLine(int line, String text){
		this.textLines[line] = text;
	}
	public String getTextLine(int line){
		return this.textLines[line];
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
	public int getLines(){
		return this.lines;
	}
	public Point2D getTextCoordinates(int line){
		return this.textCoordinates[line];
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
