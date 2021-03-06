import java.awt.Image;
import java.awt.Toolkit;

public class Grass {
	private Image image;
	private Monster[] monsters;
	private Double[] percentages;
	public Grass(Monster[] monsters, Double[] percentages){ //The monsters that can be found in the grass, //and the percentage that when encountering a monster it is that monster //Monster number related to percentage number
		if(monsters == null || percentages == null){
			
		}
		else if(monsters.length == percentages.length){		
			Double percentagesAddedUp = 0.0; //Try to get to 100%
			for(int i = 0; i < percentages.length; i++){
				percentagesAddedUp += percentages[i];
			}
			for(int i = 0; i < percentages.length; i++){
				percentages[i] *= 100.0 / percentagesAddedUp; //Multiplies them by this so the percentages always add up to 100.0
			}
		} 
		this.monsters = monsters;
		this.percentages = percentages;
		this.setImage("images/grass/nobackground.png");
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
	public Monster[] getMonsters(){
		return this.monsters;
	}
	public Double[] getPercentages(){
		return this.percentages;
	}
}
