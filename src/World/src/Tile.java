import java.awt.Image;
import java.awt.Toolkit;

public class Tile {
	private Image image;
	private Boolean containsItem = false;
	private Item item = null;
	private Trainer trainer = null;
	private Boolean containsTrainer = false;
	private Boolean containsGrass = false;
	private Grass grass;
	private Boolean walkable = true; //Whether the trainer can walk on this tile
	private Boolean containsPortal = false;
	private Portal portal;
	public Tile(){
		//this.image = Toolkit.getDefaultToolkit().getImage("images/black.png");
		this.image = null;
	}
	public Tile(String imagePath){ //Type the string for the path of the image
		this.image = Toolkit.getDefaultToolkit().getImage(imagePath);	
	}
	public Tile(Image image){ //Type the string for the path of the image
		this.image = image;	
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
	public Trainer getTrainer(){
		return this.trainer;
	}
	public Boolean containsTrainer(){
		return this.containsTrainer;
	}
	public void setTrainer(Trainer trainer){
		if(trainer != null){
			containsTrainer = true;
		} else {
			containsTrainer = false;
		}
		this.trainer = trainer;
	}
	public void setGrass(Grass grass){
		if(grass != null){
			containsGrass = true;
		} else {
			containsGrass = false;
		}
		this.grass = grass;
	}
	public Grass getGrass(){
		return this.grass;
	}
	
	public void setItem(Item item){
		if(item != null){
			walkable = false;
			containsItem = true;
		} else {
			walkable = true; //Can't walk on it if there's an item
			containsItem = false;
		}
		this.item = item;
	}
	public Item getItem(){
		return this.item;
	}
	public Boolean containsItem(){
		return containsItem;
	}
	public Boolean containsGrass(){
		return containsGrass;
	}
	public void setWalkable(Boolean walkable){
		this.walkable = walkable;
	}
	public Boolean getWalkable(){
		return this.walkable;
	}
	public void setPortal(Portal portal){
		if(portal != null){
			containsPortal = true;
		} else {
			containsPortal = false;
		}
		this.portal = portal;
	}
	public Portal getPortal(){
		return this.portal;
	}
	public Boolean containsPortal(){
		return this.containsPortal;
	}
}
