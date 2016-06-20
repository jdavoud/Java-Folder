
public class Ball extends Item{
	private double catchRate;
	public Ball(String name) {
		super(name);
		this.setImage("images/balls/" + name + ".png");
		this.setCanUseInBattle(true);
		//this.setImage("images/balls/masterball.png");
		// TODO Auto-generated constructor stub
	}
//	@Override
	public void pressedOn(Trainer trainer, Tile tile){
		super.pressedOn(trainer, tile);
		World.textBox.setText("Picked up a " + this.getName());
	}
	@Override
	public void usedInBattle(Trainer trainer){
		this.usedInBattle(trainer);
		
	}
	public void setCatchRate(double catchRate){
		this.catchRate = catchRate;
	}
	public double getCatchRate(){
		return this.catchRate;
	}
}
