package flappyBall;
import java.awt.geom.*;

public class Pipe {
	private double topPipeHeight, bottomPipeHeight;
	private Rectangle2D topPipe, bottomPipe;
	private double x = 0;
	public Pipe(double topPipeHeight, double bottomPipeHeight){
		this.topPipeHeight = topPipeHeight;
		this.bottomPipeHeight = bottomPipeHeight;
		this.topPipe = new Rectangle2D.Double(x,0,30,topPipeHeight);
		this.bottomPipe = new Rectangle2D.Double(x,500-bottomPipeHeight, 30, bottomPipeHeight);
	}
	public Boolean intersects(Rectangle2D obj){
		if(topPipe.intersects(obj) || bottomPipe.intersects(obj)){
			return true;
		} else {
			return false;
		}
	}
	public Double getTopPipeHeight(){
		return this.topPipeHeight;
	}
	public Double getBottomHeight(){
		return this.bottomPipeHeight;
	}
	public Rectangle2D getTopPipe(){
		return this.topPipe;
	}
	public Rectangle2D getBottomPipe(){
		return this.bottomPipe;
	}
	public Double getX(){
		return this.x;
	}
	public void setX(Double x){
		this.x = x;
		this.topPipe = new Rectangle2D.Double(x,0,30,topPipeHeight);
		this.bottomPipe = new Rectangle2D.Double(x,500-bottomPipeHeight, 30, bottomPipeHeight);
	}
	public void setTopPipeHeight(Double height){
		this.topPipeHeight = height;
		this.topPipe = new Rectangle2D.Double(x,0,30,topPipeHeight);
	}
	public void setBottomPipeHeight(Double height){
		this.bottomPipeHeight = height;
		this.bottomPipe = new Rectangle2D.Double(x,500-bottomPipeHeight, 30, bottomPipeHeight);
	}
	public void setTopPipe(Rectangle2D pipe){
		this.topPipe = pipe;
		this.topPipeHeight = pipe.getHeight();
	}
	public void setBottomPipe(Rectangle2D pipe){
		this.bottomPipe = pipe;
		this.bottomPipeHeight = pipe.getHeight();
	}
	public void randomizePipe(){
		setTopPipeHeight(Math.random()*(225-25)+25);
		setBottomPipeHeight(250 - this.topPipeHeight);	
	}
}
