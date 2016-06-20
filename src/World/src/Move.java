
public class Move {
	private String name = "";
	private Type type;
	public Move(String name, Type type){
		this.name = name;
		this.type = type;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setType(Type type){
		this.type = type;
	}
	public String getName(){
		return this.name;
	}
	public Type getType(){
		return this.type;
	}
}
