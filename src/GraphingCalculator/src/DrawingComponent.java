import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class DrawingComponent extends JComponent {
	public Double frameWidth = 800.0; 
	public Double frameHeight = 600.0; 
	
	
	public Double xMax = 25.0;
	public Double xMin = -25.0;
	public Double yMax = 25.0;
	public Double yMin = -25.0;
	
	public String function = "y = x * 2";
	
	//public Double yZero = (double) frameHeight/2;
	//public Double xZero = (double) 200+((frameWidth-(200)))/2;
	
	public Double yZero;
	public Double xZero;
	
	public Line2D.Double line1 = new Line2D.Double(200,0,200,frameHeight);
	public Line2D.Double yAxis;
	public Line2D.Double xAxis;
	public Line2D[] yLines = new Line2D[10];
	
	public void paintComponent(Graphics g){
		
		frameWidth = (double) getWidth();
		frameHeight = ((double) getHeight() - 24);
		
		
		yZero = oldYCoord(0);
		xZero = oldXCoord(0);
		//frameHeight -= 24;
		
		Graphics2D g2 = (Graphics2D) g; //= g;
		Line2D.Double line1 = new Line2D.Double(200,0,200,frameHeight);
		//Line2D.Double line2 = new Line2D.Double(point1.getX(),point1.getY(),point1.getX(),point1.getY());
		Line2D.Double yAxis = new Line2D.Double(xZero, 0, xZero, frameHeight);
		g2.draw(yAxis);
		for(double i = yAxis.y1; i < yAxis.y2; i+=0.5){
			Ellipse2D.Double point = new Ellipse2D.Double(xZero, i, 1.25, 1.25);
			g2.draw(point);
		}
		Line2D.Double xAxis = new Line2D.Double(200, yZero, frameWidth, yZero);
		g2.draw(xAxis);
		for(double i = xAxis.x1; i < xAxis.x2; i+=0.5){
			Ellipse2D.Double point = new Ellipse2D.Double(i, yZero, 1.25, 1.25);
			g2.draw(point);
		}
		for(double i = yMax; i > yMin; i -= (yMax-yMin)/10){
			Line2D.Double yLine = new Line2D.Double(xAxis.x1, oldYCoord(i), frameWidth, oldYCoord(i));
			g2.draw(yLine);
			g2.drawString(axisNumber(i), (int) (xZero - 50), (int) oldYCoord(i) + 12);
			
		}
		for(double i = xMax; i > xMin; i -= (xMax-xMin)/10){
			Line2D.Double xLine = new Line2D.Double(oldXCoord(i), 0, oldXCoord(i), frameHeight);
			g2.draw(xLine);
			g2.drawString(axisNumber(i), (int) oldXCoord(i) - 50, (int) (yZero + 12));
			
		}
		
		g2.draw(line1);
		Grapher.graph.setDomainMax(this.getXMax());
		Grapher.graph.setDomainMin(this.getXMin());
		drawGraph(g2, Grapher.graph);
		
		/*for(double i = xMax; i > xMin; i-=(xMax-xMin)/2000){ //y = mx + b
			//Ellipse2D.Double point = new Ellipse2D.Double(i, yZero + (xZero-(i)), 1, 1);
			//Ellipse2D.Double point = new Ellipse2D.Double(i, (((xZero - i)*yMax/frameHeight)) + yZero, 1, 1);
			Ellipse2D.Double point = new Ellipse2D.Double(oldXCoord(i), oldYCoord(Function.textFunc(i, function)), 1, 1);
			
			//Ellipse2D.Double point = new Ellipse2D.Double(oldXCoord(i), oldYCoord(Math.atan(i)), 1, 1);
			//Ellipse2D.Double point = new Ellipse2D.Double(oldXCoord(i), oldYCoord(Mi), 1, 1);
			//System.out.println("i: " + i + " y: " + textFunc(i, Grapher.function.getText()));
			System.out.println("pointx: " + point.x + " pointy: " + point.y);
			g2.draw(point);
		}*/
		
		/*for(double i = xMax; i > xMin; i-=0.01){ //y = x^2
			//Ellipse2D.Double point = new Ellipse2D.Double(i, yZero - Math.pow((xZero-i), 2), 1, 1);
			Ellipse2D.Double point = new Ellipse2D.Double(oldXCoord(i),oldYCoord(Math.pow(i, 2)), 1, 1);
			g2.draw(point);
		}*/
		/*for(double i = xMax; i > xMin; i-=0.0025){ //y = cos x
			//Ellipse2D.Double point = new Ellipse2D.Double(i, yZero - Math.pow((xZero-i), 2), 1, 1);
			Ellipse2D.Double point = new Ellipse2D.Double(oldXCoord(i),oldYCoord(Math.atan(i)), 1, 1);
			g2.draw(point);
		}*/
		/*for(double i = xMax; i > xMin; i-=0.025){ //y = cos x
			//Ellipse2D.Double point = new Ellipse2D.Double(i, yZero - Math.pow((xZero-i), 2), 1, 1);
			Ellipse2D.Double point = new Ellipse2D.Double(oldXCoord(i),4+oldYCoord(Math.log10(i)), 1, 1);
			g2.draw(point);
		}*/
		//Grapher.frame.setTitle("(" + Grapher.frame.getWidth() + ", " + Grapher.frame.getHeight() + ")" + " xZero: " + xZero + " yZero: " + yZero);
		repaint();
	}
	public String axisNumber(double num){
		String response = String.valueOf(num);
		
		if(response.endsWith(".0")){
			response = response.replace(".0", "");
		}
		if(response.length() > 6){
			response = response.substring(0,5);
			if(response.lastIndexOf(".") == response.length()-1){
				response = response.substring(0,4);
			}
		}
		for(int i = response.length(); i < 6; i++){
			response = "  " + response;
		}
		return response;
	}
	public double newXCoord(double oldXCoord){
		//System.out.println("oldXCoord:" + oldXCoord);
		//oldXCoord = (oldXCoord + ((frameWidth-200)/10) - xZero)*xMax/frameHeight*2;
		
		Double slope = (((frameWidth-(200)))/(xMax-xMin)); //y = mx + b -> m = (y1 - y2)/(x1 - x2)
		Double yIntercept = frameWidth - (slope * xMax); //y = mx + b -> y - mx = b
		oldXCoord = (oldXCoord - yIntercept) / slope; //y = mx + b -> inverse y = (x - b) / m
		//System.out.println("newXCoord:" + oldXCoord);
		return oldXCoord;
	}
	public double newYCoord(double oldYCoord){

		//System.out.println("oldYCoord:" + oldYCoord);
		//oldYCoord = (yZero - oldYCoord)*yMax/frameHeight*2;
		
		Double slope = (0-frameHeight)/(yMax-yMin); //y = mx + b -> m = (y1 - y2)/(x1 - x2)
		Double yIntercept = frameHeight - (slope * yMin); //y = mx + b -> y - mx = b
		oldYCoord = (oldYCoord - yIntercept) / slope; //y = mx + b -> inverse y = (x - b) / m
		//System.out.println("newYCoord:" + oldYCoord);
		return oldYCoord;
	}
	public double oldXCoord(double newXCoord){

		//System.out.println("newXCoord:" + newXCoord);
		//newXCoord = (newXCoord/2*frameHeight/xMax)+xZero; 
		//if xMax = 50, xMin = -25, xZero should be 400
		Double slope = (((frameWidth-(200)))/(xMax-xMin)); //y = mx + b -> m = (y1 - y2)/(x1-x2)
		Double yIntercept = frameWidth - (slope * xMax); //y = mx + b -> y - mx = b
		newXCoord = (slope * newXCoord) + (yIntercept);
		//50 / 800 and -25 / 200 and 0 / 400
		//100 / 800 and 0 / 200 and 50 / 500
		//System.out.println("oldXCoord:" + newXCoord);
		return newXCoord;
	}
	public double oldYCoord(double newYCoord){

		//System.out.println("newYCoord:" + newYCoord);
		//newYCoord = ((newYCoord/2*frameHeight/yMax) - yZero) * -1;
		Double slope = (0-frameHeight)/(yMax-yMin); //y = mx + b -> m = (y1 - y2)/(x1-x2)
		Double yIntercept = frameHeight - (slope * yMin); //y = mx + b -> y - mx = b
		newYCoord = (slope * newYCoord) + (yIntercept);
		//System.out.println("oldYCoord:" + newYCoord);
		return newYCoord;
	}
	public void drawGraph(Graphics2D g2, Graph graph){
		for(int i = 0; i < graph.getPoints().length; i++){
			g2.draw(graph.getPoints()[i]);
			System.out.println("Drawing "  + i + " " + graph.getPoints()[i].getX() + " " + graph.getPoints()[i].getY());
		}
	}
	public double getXMax(){ //Get functions for the Grapher.java class to be able to read the values
		return xMax;
	}
	public double getXMin(){
		return xMin;
	}
	public double getYMax(){
		return yMax;
	}
	public double getYMin(){
		return yMin;
	}
	public double getFrameWidth(){
		return frameWidth;
	}
	public double getFrameHeight(){
		return frameHeight;
	}
	public void setXMax(double newX){ //Set functions for the Grapher.java class to be able to set the values
		xMax = newX;
	}
	public void setXMin(double newX){
		xMin = newX;
	}
	public void setYMax(double newY){
		yMax = newY;
	}
	public void setYMin(double newY){
		yMin = newY;
	}
	public void setFrameWidth(double newWidth){
		frameWidth = newWidth;
	}
	public void setFrameHeight(double newHeight){
		frameHeight = newHeight;
	}
}
