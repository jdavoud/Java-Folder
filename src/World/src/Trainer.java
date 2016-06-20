import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.Serializable;
import java.util.Arrays;

public class Trainer implements Serializable {
	private String talkedToText;
	private String name;
	private Bag bag;
	private Monster[] monsters;
	private String gender;
	private Point coordinates;
	private Image image;
	private Boolean canMove = true; //Whether the trainer can move, used so that you can't run infinitely
	private int canWalkNum = 0; //Counts how many times the screen is repainted to say whether the player can move
	private String direction = "down"; //Can be "down", "up", "left", and "right"
	public Trainer(String name) {
		this.name = name;
		this.talkedToText = "Hi my name is " + this.name;
		setImage("images/trainer/boy/down.png");
	}
	//private
	public Point getCoordinates(){
		return this.coordinates;
	}
	public String getGender(){
		return this.gender;
	}
	public String getName(){
		return this.name;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setCoordinates(Point point){
		this.coordinates = point;
	}
	public void setCoordinates(int x, int y){
		this.coordinates = new Point(x,y);
	}
	public Bag getBag(){
		return this.bag;
	}
	public void setBag(Bag newBag){
		bag = newBag;
	}
	public Monster[] getMonsters(){
		return this.monsters;
	}
	public void setMonsters(Monster[] monsters){
		this.monsters = monsters;
	}
	public Image getImage(){
		return this.image;
	}
	public void setImage(String imagePath){
		this.image = Toolkit.getDefaultToolkit().getImage(imagePath);
	}
	public void setImage(Image image){
		this.image = image;
	}
	public Boolean getCanMove(){
		return this.canMove;
	}
	public void setCanMove(Boolean canMove){
		this.canMove = canMove;
	}
	public void setCanWalkNum(int num){
		this.canWalkNum = num;
	}
	public int getCanWalkNum(){
		return this.canWalkNum;
	}
	public void setDirection(String direction){
		this.direction = direction;
	}
	public String getDirection(){
		return this.direction;
	}
	public void talkedTo() {
		World.textBox.setText(this.talkedToText);
	}
	@Override
	public String toString() {
		return "Trainer [talkedToText=" + talkedToText + ", name=" + name + ", bag=" + bag + ", monsters="
				+ Arrays.toString(monsters) + ", gender=" + gender + ", coordinates=" + coordinates + ", image=" + image
				+ ", canMove=" + canMove + ", canWalkNum=" + canWalkNum + ", direction=" + direction + "]";
	}
	
}
