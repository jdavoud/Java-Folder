import java.awt.Image;
import java.awt.Toolkit;

public class Monster {
	private String name;
	private Type type1, type2;
	private String status;
	private Move[] moves; //Need to Write
	private int healthMax = 100;
	private int health = healthMax;
	private Image image;
	private String monsterStatus = ""; //Can be "", frozen, sleep, burn, poison, paralyze
	private int catchRate; //Number 1 - 255
	public Monster(String name, Type type1, Type type2){
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.setImage("images/monsters/" + name + ".png");
	}
	public Monster(String name, Type type1){
		this.name = name;
		this.type1 = type1;
		this.type2 = null;
		this.setImage("images/monsters/" + name + ".png");
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public Type getType1(){
		return this.type1;
	}
	public Type getType2(){
		return this.type2;
	}
	public void setType1(Type type){
		this.type1 = type;
	}
	public void setType2(Type type){
		this.type2 = type;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return this.status;
	}
	public void setHealthMax(int max){
		this.healthMax = max;
	}
	public int getHealthMax(){
		return this.healthMax;
	}
	public void setHealth(int health){
		this.health = health;
	}
	public int getHealth(){
		return this.health;
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
	public void setMoves(Move[] moves){
		this.moves = new Move[4];
		for(int i = 0; i < this.moves.length; i++){
			if(i < moves.length){
				this.moves[i] = moves[i];
			} else {
				this.moves[i] = null;
			}
		}
		
	}
	
	public Move[] getMoves(){
		return this.moves;
	}
	public int numberOfMoves(){
		int num = 0;
		for(int i = 0; i < this.moves.length; i++){//If there is a filled slot after a null slot, it slides them over so the filled slots are first
			if(this.moves[i] == null){
				for(int j = i; j < this.moves.length; j++){
					if(this.moves[j] != null){
						while(this.moves[i] == null){
							for(int h = i; h < this.moves.length - 1; h++){
								this.moves[h] = this.moves[h+1];
							}
							this.moves[this.moves.length - 1] = null;
						}
					}
				}
			}
		}
		for(int i = 0; i < this.moves.length; i++){
			if(this.moves != null){
				num++;
			}
		}
		return num;
	}
	public void setMonsterStatus(String newStatus){
		this.monsterStatus = newStatus;
	}
	public String getMonsterStatus(){
		return this.monsterStatus;
	}
	public int monsterStatusNumber(){ //Used as a multiplier in the ball catching formula
		int num = 0;
		if(monsterStatus != ""){ //If the monster is frozen, burned, sleeping, etc. 
			num = 2;
		}
		return num;
	}
	public void setCatchRate(int rate){
		this.catchRate = rate;
	}
	public int getCatchRate() {
		// TODO Auto-generated method stub
		return this.catchRate;
	}
}
