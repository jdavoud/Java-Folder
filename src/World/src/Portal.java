
public class Portal {
	private Room endRoom;
	private int x, y;
	public Portal(Room endRoom, int x, int y){
		this.endRoom = endRoom;
		this.x = x;
		this.y = y;
	}
	public void setEndRoom(Room endRoom){
		this.endRoom = endRoom;
	}
	public Room getEndRoom(){
		return this.endRoom;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
}
