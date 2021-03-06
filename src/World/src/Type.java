
public class Type {
	private String name;
	private Type[] weakAttacking;
	private Type[] strongAttacking;
	private Type[] cantAttack;
	private Type[] weakDefending;
	private Type[] strongDefending;
	private Type[] cantBeAttackedBy;
	public Type(String name){
		this.name = name;
	}
	public static void main(String[] args){
		
		Type fire = new Type("fire");
		Type water = new Type("water");
		Type grass = new Type("grass");
		Type electric = new Type("electric");



		fire.setWeakAttacking(new Type[] {electric, water});
		fire.setWeakAttacking(grass);
		water.setStrongDefending(new Type[] {fire});

		water.setStrongAttacking(new Type[] {fire});
		fire.setWeakDefending(new Type[] {water});
	}	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setWeakAttacking(Type[] types){
		this.weakAttacking = types;
	}
	public void setWeakAttacking(Type type){
		if(!this.isWeakAttacking(type)){
			Type[] newWeakAttacking;
			if(this.weakAttacking != null){
				newWeakAttacking = new Type[this.weakAttacking.length + 1];
				for(int i = 0; i < this.weakAttacking.length; i++){
					newWeakAttacking[i] = weakAttacking[i];
				}
				newWeakAttacking[this.weakAttacking.length] = type;
			}	else {
				newWeakAttacking = new Type[]{type};
			}
			this.weakAttacking = newWeakAttacking;
		}
	}
	public void setStrongAttacking(Type[] types){
		this.strongAttacking = types;
	}
	public void setStrongAttacking(Type type){
		if(!this.isStrongAttacking(type)){
			Type[] newStrongAttacking;
			if(this.strongAttacking != null){
				newStrongAttacking = new Type[this.strongAttacking.length + 1];
				for(int i = 0; i < this.strongAttacking.length; i++){
					newStrongAttacking[i] = strongAttacking[i];
				}
				newStrongAttacking[this.strongAttacking.length] = type;
			}	else {
				newStrongAttacking = new Type[]{type};
			}
			this.strongAttacking = newStrongAttacking;
		}
	}
	public void setCantAttack(Type[] types){
		this.cantAttack = types;
	}
	public void setCantAttack(Type type){
		if(!this.cantAttack(type)){
			Type[] newCantAttack;
			if(this.cantAttack != null){
				newCantAttack = new Type[this.cantAttack.length + 1];
				for(int i = 0; i < this.cantAttack.length; i++){
					newCantAttack[i] = cantAttack[i];
				}
				newCantAttack[this.cantAttack.length] = type;
			}	else {
				newCantAttack = new Type[]{type};
			}
			this.cantAttack = newCantAttack;
		}
	}
	public void setWeakDefending(Type[] types){
		this.weakDefending = types;
	}
	public void setWeakDefending(Type type){
		if(!this.isWeakDefending(type)){
			Type[] newWeakDefending;
			if(this.weakDefending != null){
				newWeakDefending = new Type[this.weakDefending.length + 1];
				for(int i = 0; i < this.weakDefending.length; i++){
					newWeakDefending[i] = weakDefending[i];
				}
				newWeakDefending[this.weakDefending.length] = type;
			}	else {
				newWeakDefending = new Type[]{type};
			}
			this.weakDefending = newWeakDefending;
		}
	}
	public void setStrongDefending(Type[] types){
		this.strongDefending = types;
	}
	public void setStrongDefending(Type type){
		if(!this.isStrongDefending(type)){
			Type[] newStrongDefending;
			if(this.strongDefending != null){
				newStrongDefending = new Type[this.strongDefending.length + 1];
				for(int i = 0; i < this.strongDefending.length; i++){
					newStrongDefending[i] = strongDefending[i];
				}
				newStrongDefending[this.strongDefending.length] = type;
			}	else {
				newStrongDefending = new Type[]{type};
			}
			this.strongDefending = newStrongDefending;
		}
	}
	public void setCantBeAttackedBy(Type[] types){
		this.cantBeAttackedBy = types;
	}
	public void setCantBeAttackedBy(Type type){
		if(!this.cantBeAttackedBy(type)){
			Type[] newCantBeAttackedBy;
			if(this.cantBeAttackedBy != null){
				newCantBeAttackedBy = new Type[this.cantBeAttackedBy.length + 1];
				for(int i = 0; i < this.cantBeAttackedBy.length; i++){
					newCantBeAttackedBy[i] = cantBeAttackedBy[i];
				}
				newCantBeAttackedBy[this.cantBeAttackedBy.length] = type;
			}	else {
				newCantBeAttackedBy = new Type[]{type};
			}
			this.cantBeAttackedBy = newCantBeAttackedBy;
		}
	}
	public Boolean isWeakAttacking(Type type){
		return typeArrayContains(weakAttacking, type);
	}
	public Boolean isStrongAttacking(Type type){
		return typeArrayContains(strongAttacking, type);
	}
	public Boolean isWeakDefending(Type type){
		return typeArrayContains(weakDefending, type);
	}
	public Boolean isStrongDefending(Type type){
		return typeArrayContains(strongDefending, type);
	}
	public Boolean cantAttack(Type type){
		return typeArrayContains(this.cantAttack, type);
	}
	public Boolean cantBeAttackedBy(Type type){
		return typeArrayContains(this.cantBeAttackedBy, type);
	}
	public Type[] getWeakAttacking(){
		return this.weakAttacking;
	}
	public Type[] getStrongAttacking(){
		return this.strongAttacking;
	}
	public Type[] getCantAttack(){
		return this.cantAttack;
	}
	public Type[] getWeakDefending(){
		return this.weakDefending;
	}
	public Type[] getStrongDefending(){
		return this.strongDefending;
	}
	public Type[] getCantBeAttackedBy(){
		return this.cantBeAttackedBy;
	}
	public Boolean typeArrayContains(Type[] types, Type type){//Returns whether an array contains a type
		Boolean contains = false;
		if(types != null){
			for(int i = 0; i < types.length; i++){
				if(types[i] == type){
					contains = true;
				}
			}
		}
		return contains;
	}
	public static void log(String s){
		System.out.println(s);
	}
}
