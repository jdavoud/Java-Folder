import java.awt.Image;
import java.awt.Toolkit;

public class Item {
	private String name;
	private Image image;
	private Boolean canUseInBattle = false;
	public Item(String name){
		this.name = name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
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
	public void pressedOn(Trainer trainer, Tile tile){//When talked to, pressed enter and facing
		trainer.getBag().addItem(new Item(this.name));
		tile.setItem(null);
	}
	public void usedInBattle(Trainer trainer){
		if(this.canUseInBattle){
			trainer.getBag().removeOneOfItem(trainer.getBag().slotContaining(this));
		} else {
			World.textBox.setText(this.name + " can't be used in battle");
		}
	}
	public void setCanUseInBattle(Boolean canUse){
		this.canUseInBattle = canUse;
	}
	public Boolean getCanUseInBattle(){
		return this.canUseInBattle;
	}
	
}
